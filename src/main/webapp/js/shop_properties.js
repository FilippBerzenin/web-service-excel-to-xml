$(document).ready(function() {
	
	$('#shopProperties').find(".custom-control-input").each(function() {
		$(this).prop('checked', true)
	});
	
	$('#shopProperties').find(".custom-control-input").each(function() {
			if ($(this).is(':checked')) {
				$('[id $= input]').prop('disabled', true);
				$('[id *= excel]').prop('disabled', false);
			} else if (!$(this).is(':checked')) {
				$('[id $= input]').prop('disabled', false);
				$('[id *= excel]').prop('disabled', true);
			}
	});
	
	$(find(".custom-control-input")).each(function() {
		if ($(this).is(':checked')) {
			$('[id $= input]').prop('disabled', true);
			$('[id *= excel]').prop('disabled', false);
		} else if (!$(this).is(':checked')) {
			$('[id $= input]').prop('disabled', false);
			$('[id *= excel]').prop('disabled', true);
		}
	});
	
	$(document).on('change', '.custom-control-input', function() {
		if ($(this).is(':checked')) {
			$(this).closest('tr').children().children('[id $= input]').prop('disabled', true);
			$(this).closest('tr').children().children('[type=text][id *= excel]').prop('disabled', false);
		} else if (!$(this).is(':checked')) {
			$(this).closest('tr').children().children('[id $= input]').prop('disabled', false);
			$(this).closest('tr').children().children('[type=text][id *= excel]').prop('disabled', true);
		}	
	});
});

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
});
