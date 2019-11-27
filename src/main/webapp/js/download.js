//$(document).ready(function () {	
//
//	let files;
//	$('input[type=file]').on('change', function(){
//		files = this.files;
//	});
//	
//	$('.upload_files').on( 'click', function( event ){
//
//		event.stopPropagation(); // остановка всех текущих JS событий
//		event.preventDefault();  // остановка дефолтного события для текущего элемента - клик для <a> тега
//
//		if( typeof files == 'undefined' ) return;
//
//		let data = new FormData();
//
//		$.each( files, function( key, value ){
//			data.append( key, value );
//		});
//
//		data.append('my_file_upload', 1);
//		
//	    $.ajax({
//	        url: "http://localhost:8080/greeting"
//	    }).then(function(data, status, jqxhr) {
//	       $('.greeting-id').append(data.id);
//	       $('.greeting-content').append(data.content);
//	       console.log(jqxhr);
//	    });
//
////		// AJAX запрос
////		$.ajax({
////			url         : 'http://localhost:8080/api/file/submit',
////			type        : 'POST', // важно!
//////			data        : data,
////			cache       : false,
////			dataType    : 'json',
////			// отключаем обработку передаваемых данных, пусть передаются как есть
////			processData : false,
////			// отключаем установку заголовка типа запроса. Так jQuery скажет серверу что это строковой запрос
////			contentType : false, 
////			// функция успешного ответа сервера
////			success     : function( respond, status, jqXHR ){
////
////				// ОК - файлы загружены
////				if( typeof respond.error === 'undefined' ){
////					// выведем пути загруженных файлов в блок '.ajax-reply'
////					var files_path = respond.files;
////					var html = '';
////					$.each( files_path, function( key, val ){
////						 html += val +'<br>';
////					} )
////
////					$('.ajax-reply').html( html );
////				}
////				// ошибка
////				else {
////					console.log('ОШИБКА: ' + respond.error );
////				}
////			},
////			// функция ошибки ответа сервера
////			error: function( jqXHR, status, errorThrown ){
////				console.log( 'ОШИБКА AJAX запроса: ' + status, jqXHR );
////			}
////
////		});
//
//	});
//	
//})