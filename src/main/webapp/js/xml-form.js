$(document).ready(function() {

	let currencies = [];

	$('#save_currencies').click(function() {
		let table = document.getElementById("currencies");
		var rowLength = table.rows.length;
		for (let i = 1; i < rowLength; i++) {

			let id_teg = table.rows[i].getElementsByTagName("input")[0];
			let id_value = id_teg.value;

			let name_teg = table.rows[i].getElementsByTagName("input")[1];
			let name_value = name_teg.value;
			alert(`${id_value}, ${name_value} `);

			let currencie = {
				id : id_value,
				name : name_value
			}
			if (!currencies.includes(currencie)) {
				currencies.push(currencie);
			}			
		}
		let iterator = currencies.keys(); 
		for (let key of iterator) {
			  console.log(key);
			}
	});
})