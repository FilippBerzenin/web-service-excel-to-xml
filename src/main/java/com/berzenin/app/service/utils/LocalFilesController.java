package com.berzenin.app.service.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalFilesController {
	
	@Getter
	protected static final String pathToResource = "..\\Server-for-photo\\src\\main\\resources\\";
	
	public static boolean copyFileForlocalDirectory(MultipartFile file) {
		Path copied = Paths.get(pathToResource, "test.jpg");
		if (Files.notExists(copied)) {
			Files.exists(copied);
		}
		try {
			Files.copy(file.getInputStream(), copied, StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteFile(String link) {
		try {
			Files.deleteIfExists(Paths.get(link));
			return true;
		} catch (IOException e) {
			log.error(e.getLocalizedMessage());
			return false;
		}
	}
	
	public Path getLocalPathForPdf(MultipartFile file) {
		createLocalDirectory();
		Path path = Paths.get(pathToResource + "\\localfiles\\" + file.getOriginalFilename());
		return path;
	}
	
	public void createLocalDirectory() {
		if (!Files.notExists(Paths.get(pathToResource + "\\localfiles\\"))) {
			try {
				Files.createDirectory(Paths.get(pathToResource + "\\localfiles\\"));
			} catch (IOException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}


//	public boolean downloadPdfFileFromUrl (LinkForMetalResources res) {
//		if (res.getUrlForResource() == null || res.getUrlForResource().length()==0) {
//			return false;
//		}
//		URL url = null;
//		Path filePdf = Paths.get(res.getLocalPathForPdfFile());
//		try {
//			url = new URL(res.getUrlForResource());
//		} catch (MalformedURLException e) {
//			log.error(e.getMessage());
//			e.printStackTrace();
//			return false;
//		}
//		try (InputStream in = url.openStream()) {
//			if (!Files.exists(filePdf)) {
//				Files.createFile(filePdf);
//			}
//			Files.copy(in, filePdf, StandardCopyOption.REPLACE_EXISTING);
//			return true;
//		} catch (IOException e) {
//			log.error(e.getMessage());
//			e.printStackTrace();
//			return false;
//		}
//	}
	
	public String setPathForFile(String url) {
		String path = "";
		try {
			URL partOfurl = new URL(url);
			if (!Files.exists(Paths.get(pathToResource + partOfurl.getHost()))) {
				Files.createDirectories(Paths.get(pathToResource + partOfurl.getHost()));
			}
			path = pathToResource + partOfurl.getHost() + "\\";
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return path;
	}
	

	public Optional<List<String>> readAllLines(String url) {
		try {
			return Optional.of(Files.readAllLines(Paths.get(url)));
		} catch (IOException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
	

}
