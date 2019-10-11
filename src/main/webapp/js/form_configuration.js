//alert("Start");	

function addCurrencie() {
		let element = document.createElement("input");
		element.setAttribute("type", "text");
		element.setAttribute("id", "cur_id");
		let element2 = document.createElement("input");
		element2.setAttribute("type", "text");
		element2.setAttribute("id", "cur_name");
		let td1 = document.createElement("td");
		let td2 = document.createElement("td");
		let row = document.createElement("tr");
		let table = document.getElementById("currencies");
		td1.appendChild(element);
		td2.appendChild(element2);
		row.appendChild(td1);
		row.appendChild(td2);
		table.appendChild(row);
	}

let currencies = new Set();

function saveCurrencies() {
	let table = document.getElementById("currencies");
	var rowLength = table.rows.length;
	for (let i = 1; i<rowLength; i++) {		

		let id_teg = table.rows[i].getElementsByTagName("input")[0];
		let id_value = id_teg.value;
		
		let name_teg = table.rows[i].getElementsByTagName("input")[1];
		let name_value = name_teg.value;
		alert(`${id_value}, ${name_value} `);
		
		let currencie = {
				id: id_value,
				name: name_value
		}
		currencies.add(currencie);
	}
}