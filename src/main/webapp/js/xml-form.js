$(document).ready(function() {
	
	let indexCurrencie = 0;
	
	$(document).on('click','#remove_currencie',function(){
		if ($('#currencies tr').length == 2) {
			$('#'+"currency_name_"+indexCurrencie).val('');
			$('#'+"currency_name_"+indexCurrencie).attr('disabled', false);
			return;
		}
		$(this).closest('tr').remove();
		$('#add_currencie').remove();
		$("td:last").after(addButton());
		indexCurrencie--;
		});
	
	$(document).on('click', '#add_currencie', function addCurrencie() {
		if (indexCurrencie == 0) {
			indexCurrencie = $("#currency_id_1").val();
		}
		let lastCurValue = $('#'+"currency_name_"+indexCurrencie).val();
		if (indexCurrencie > 1) {
			if (typeof lastCurValue === "undefined" || lastCurValue.length != 3) {
				$('#'+"currency_name_"+indexCurrencie).val('');
				$('#'+"currency_name_"+indexCurrencie).attr("placeholder","Please, enter correct value!");
				return;
			}
		}
		
		indexCurrencie++;
		$('#add_currencie').remove();
		let currency_id = "currency_id_"+indexCurrencie;
		let currency_name = "currency_name_"+indexCurrencie;
		let row = document.createElement("tr");
		let td1 = document.createElement("td");
		let td2 = document.createElement("td");
		let element = document.createElement("input");
		element.setAttribute("type", "text");
		element.setAttribute("id", currency_id);
		element.setAttribute("value", indexCurrencie)
		element.disabled = true;
		let element2 = document.createElement("input");
		element2.setAttribute("type", "text");
		element2.setAttribute("id", currency_name);
		let tbody = document.getElementById("body_by_cur");
		td1.appendChild(element);
		td2.appendChild(element2);
		row.appendChild(td1);
		row.appendChild(td2);
		row.appendChild(removeButton());
		row.appendChild(addButton());
		tbody.appendChild(row);
	});
	
	function addButton ()  {
		let addButton = document.createElement('td');
		addButton.setAttribute('class', 'p-0 pl-md-2 pr-sm-2');
		addButton.setAttribute('id', 'add_currencie');
		addButton.setAttribute('align', 'center');
		addButton.setAttribute('valign', 'middle');
		let imgAddButton = document.createElement('img');
		imgAddButton.setAttribute('src', '../../fonts/plus.svg');
		imgAddButton.setAttribute('alt', 'add new row');
		imgAddButton.setAttribute('width', '200%');
		addButton.appendChild(imgAddButton);
		return addButton;
	}
	
	function removeButton ()  {
		let removeButton = document.createElement('td');
		removeButton.setAttribute('class', 'p-0 pl-md-2 pr-sm-2');
		removeButton.setAttribute('id', 'remove_currencie');
		removeButton.setAttribute('align', 'center');
		removeButton.setAttribute('valign', 'middle');
		let imgRemoveButton = document.createElement('img');
		imgRemoveButton.setAttribute('src', '../../fonts/minus.svg');
		imgRemoveButton.setAttribute('alt', 'remove row');
		imgRemoveButton.setAttribute('width', '200%');
		removeButton.appendChild(imgRemoveButton);
		return removeButton;
	}

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
	
	$(document).on('click','#remove_category',function(){
		if ($('#categores tr').length == 3) {
			$(this).closest('tr').remove();
			$('#remove_category').remove();
			$("tr:last").append($('<td>')
					.attr('class', 'p-0 pl-md-2 pr-sm-2')
					.attr('align', 'center')
					.attr('valign', 'middle')
					.attr('id', 'add_category')
					.attr('type', 'text')
						.append($('<img>')
						.attr('alt', 'add new row')
						.attr('src', '../../fonts/plus.svg')
						.attr('width', '200%')
						)
					);
			return;
		}
		$(this).closest('tr').remove();
		$('#add_currencie').remove();
		$("td:last").after(addButton());
		});
	
	$(document).on('click', '#add_category', function addCurrencie() {
		let num =  $('#categores tr:last #category_id').val();
		if (typeof num === "undefined" || num == '' || !$.isNumeric(num)) {
			 $('#categores tr:last #category_id').val('');
			 $('#categores tr:last #category_id').attr("placeholder","Please, enter correct value!");
				return;	
		}

		let val =  $('#categores tr:last #category_value').val();
		if (typeof val === "undefined" || val == '' || $.isNumeric(val)) {
			$('#categores tr:last #category_value').val('');
			$('#categores tr:last #category_value').attr("placeholder","Please, enter correct value!");
				return;	
		}
		
		let parent =  $('#categores tr:last #category_parent_id').val();
		if (parent.length > 0 && !$.isNumeric(parent)) {
			$('#categores tr:last #category_parent_id').val('');
			$('#categores tr:last #category_parent_id').attr("placeholder","Please, enter correct value!");
				return;	
		}
		
		if ($('#categores tr').length == 2) {
			$(this).closest('tr')
				.append($('<td>')
					.attr('class', 'p-0 pl-md-2 pr-sm-2')
					.attr('align', 'center')
					.attr('valign', 'middle')
					.attr('id', 'remove_category')
					.attr('type', 'text')
						.append($('<img>')
						.attr('alt', 'remove row')
						.attr('src', '../../fonts/minus.svg')
						.attr('width', '200%')
						)
					)
		}		
		$(this).closest('tbody')
		.append($('<tr>')
			.append($('<td>')
				.append($('<input>')
					.attr('id', 'category_id')
					.attr('type', 'text')
					)
				)
			.append($('<td>')
				.append($('<input>')
					.attr('id', 'category_parent_id')
					.attr('type', 'text')
					)
				)
			.append($('<td>')
				.append($('<input>')
					.attr('id', 'category_value')
					.attr('type', 'text')
					)
				)
			.append($('<td>')
				.attr('class', 'p-0 pl-md-2 pr-sm-2')
				.attr('align', 'center')
				.attr('valign', 'middle')
				.attr('id', 'remove_category')
				.attr('type', 'text')
					.append($('<img>')
					.attr('alt', 'remove row')
					.attr('src', '../../fonts/minus.svg')
					.attr('width', '200%')
					)
				)
			.append($('<td>')
				.attr('class', 'p-0 pl-md-2 pr-sm-2')
				.attr('align', 'center')
				.attr('valign', 'middle')
				.attr('id', 'add_category')
				.attr('type', 'text')
					.append($('<img>')
					.attr('alt', 'add new row')
					.attr('src', '../../fonts/plus.svg')
					.attr('width', '200%')
					)
				)
			)
			$('#add_category').remove();
	});
})