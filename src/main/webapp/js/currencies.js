$(document).ready(function() {
	
	$(document).on('click', '#addRow', function addCurrencie() {
		$(this).siblings('#removeRow').show();
		let tr = $(this).closest('tr').html();		
		$(this).closest('tbody').append('<tr>'+tr+'</tr>');
		$(this).hide();
		$(this).parent('tr').next('tr').find('input').attr('value', '');
	});
	
	$(document).on('click', '#removeRow', function addCurrencie() {
		if ($(this).parents('table').find("tr").length == 3) {
			$(this).parent('tr').prev('tr').children().siblings('#removeRow').hide();
		}
		if ($(this).closest('tr').index()+1 == $(this).parents('table').find("tr").length-1) {
			$(this).parent('tr').prev("tr").children().siblings('#addRow').show();
		}
		$(this).closest('tr').remove();
	});
	
//	let indexCurrencie = 0;
//	
//	$(document).on('click','#remove_currencie',function(){
//		if (indexCurrencie == 1 &&  $('[id ^= currency_id]').val() != 1) {
//			forFirstPosition();
//		}
//		if ($('#currencies tr').length == 2) {
//			$('#'+"currency_name_"+indexCurrencie).val('');
//			return;
//		}
//		$(this).closest('tr').remove();
//		$('#add_currencie').remove();
//		$('#currencies tr:last')
//		.append($('<td>')
//			.attr('class', 'p-0 pl-md-2 pr-sm-2')
//			.attr('align', 'center')
//			.attr('valign', 'middle')
//			.attr('id', 'add_currencie')
//			.attr('type', 'text')
//				.append($('<img>')
//				.attr('alt', 'add new row')
//				.attr('src', '../../fonts/plus.svg')
//				.attr('width', '200%')
//				)
//			)
//		indexCurrencie--;
//		});
//	
//	function forFirstPosition() {
//		$('[id ^= currency_id]').attr('id', 'currency_id_'+indexCurrencie)
//		$('[id ^= currency_name]').attr('id', 'currency_name_'+indexCurrencie)
//		$('[id ^= currency_id]').val(indexCurrencie);
//	}
//	
//	$(document).on('click', '#add_currencie', function addCurrencie() {
//		if (indexCurrencie == 0) {
//			indexCurrencie = $("#currency_id_1").val();
//			$(this).closest('tr')
//			.append($('<td>')
//				.attr('class', 'p-0 pl-md-2 pr-sm-2')
//				.attr('align', 'center')
//				.attr('valign', 'middle')
//				.attr('id', 'remove_currencie')
//				.attr('type', 'text')
//					.append($('<img>')
//					.attr('alt', 'remove row')
//					.attr('src', '../../fonts/minus.svg')
//					.attr('width', '200%')
//					)
//				)
//		}
//		if (indexCurrencie == 1 &&  $('[id ^= currency_id]').val() != 1) {
//			forFirstPosition();
//		}
//		let lastCurValue = $('#'+"currency_name_"+indexCurrencie).val();
//		if (indexCurrencie >= 1) {
//			if (typeof lastCurValue === "undefined" || lastCurValue.length != 3) {
//				$('#'+"currency_name_"+indexCurrencie).val('');
//				$('#'+"currency_name_"+indexCurrencie).attr("placeholder","Please, enter correct value!");
//				return;
//			}
//		}
//		
//		indexCurrencie++;
//		$('#add_currencie').remove();
//		let currency_id = "currency_id_"+indexCurrencie;
//		let currency_name = "currency_name_"+indexCurrencie;
//		let row = document.createElement("tr");
//		let td1 = document.createElement("td");
//		let td2 = document.createElement("td");
//		let element = document.createElement("input");
//		element.setAttribute("type", "text");
//		element.setAttribute("id", currency_id);
//		element.setAttribute("value", indexCurrencie)
//		let element2 = document.createElement("input");
//		element2.setAttribute("type", "text");
//		element2.setAttribute("id", currency_name);
//		let tbody = document.getElementById("body_by_cur");
//		td1.appendChild(element);
//		td2.appendChild(element2);
//		row.appendChild(td1);
//		row.appendChild(td2);
//		row.appendChild(removeButton());
//		row.appendChild(addButton());
//		tbody.appendChild(row);
//	});
//	
//	function addButton ()  {
//		let addButton = document.createElement('td');
//		addButton.setAttribute('class', 'p-0 pl-md-2 pr-sm-2');
//		addButton.setAttribute('id', 'add_currencie');
//		addButton.setAttribute('align', 'center');
//		addButton.setAttribute('valign', 'middle');
//		let imgAddButton = document.createElement('img');
//		imgAddButton.setAttribute('src', '../../fonts/plus.svg');
//		imgAddButton.setAttribute('alt', 'add new row');
//		imgAddButton.setAttribute('width', '200%');
//		addButton.appendChild(imgAddButton);
//		return addButton;
//	}
//	
//	function removeButton ()  {
//		let removeButton = document.createElement('td');
//		removeButton.setAttribute('class', 'p-0 pl-md-2 pr-sm-2');
//		removeButton.setAttribute('id', 'remove_currencie');
//		removeButton.setAttribute('align', 'center');
//		removeButton.setAttribute('valign', 'middle');
//		let imgRemoveButton = document.createElement('img');
//		imgRemoveButton.setAttribute('src', '../../fonts/minus.svg');
//		imgRemoveButton.setAttribute('alt', 'remove row');
//		imgRemoveButton.setAttribute('width', '200%');
//		removeButton.appendChild(imgRemoveButton);
//		return removeButton;
//	}
});