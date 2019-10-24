$(document).ready(function() {
	let i = 1;
	
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
	
	function blockNotUsedInput (object) {
		if ($(object).is(':checked')) {
			$(object).closest('tr').children().children('[id $= input]').prop('disabled', true);
			$(object).closest('tr').children().children('[type=text][id *= excel]').prop('disabled', false);
		} else if (!$(object).is(':checked')) {
			$(object).closest('tr').children().children('[id $= input]').prop('disabled', false);
			$(object).closest('tr').children().children('[type=text][id *= excel]').prop('disabled', true);
		}	
	}
	
	$(document).on('change', '#excelResourcesName', function() {
		blockNotUsedInput(this)
	});
	
	$(document).on('change', '#excelResourcesCompany', function() {
		blockNotUsedInput(this);
	});
	
	$(document).on('change', '#excelResourcesUrl', function() {
		blockNotUsedInput(this);
	});
	
	$(document).on('change', '#excelResourcesPlatform', function() {
		blockNotUsedInput(this);
	});
});