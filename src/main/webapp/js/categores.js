$(document).ready(function() {
	
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
			);
			$('#add_category').remove();
	});
});