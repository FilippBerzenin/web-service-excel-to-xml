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
	
//	$('table').each(function() {
//		$(this).each().css('background', 'red');
//	});
	
	find(".custom-control-input").each(function() {
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