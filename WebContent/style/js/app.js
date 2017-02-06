var currentId = "";
var isRepeat = false;
$(function () {
	$('#carousel-example-generic').carousel({
		interval: 5000
	});
	
	// login-form.jsp
	if ($('.alert.alert-danger').length > 0) {
		$('#myModal').modal('show');
	}
	
	// registration-form.jsp
	if ($('.alert.alert-danger.registration').length > 0) {
		$('#add-account').modal('show');
	}
	
	// updating-form.jsp
	if ($('.alert.alert-danger.updating').length > 0) {
		$('#update-account').modal('show');
	}
	
	// prescribe-form.jsp
	if ($('.alert.alert-danger.prescribe').length > 0) {
		$('#assign-treatment').modal('show');
	}
	
	$(".select-profession").on("change", function(e) {
		if ($(this).val() == 2) {
			$(".category-doctor").css("display", "block");
		}
		else {
			$(".category-doctor").css("display", "none");
		}
	});
	
	$(".navigation__item").on("mouseenter", function() {
		$($(this).find(".sub-menu")).css("display", "block");
		
	});
	
	$(".navigation__item").on("mouseleave", function(e) {
		$($(this).find(".sub-menu")).css("display", "none");
	});
	
	$(".assign-doctor-select").on("change", function(e) {
		$(".dn").css("display", "none");
		$("#" + $(this).val()).css("display", "block");
	});
	
	$(".edit-account").on("click", function(e) {
		var tr = $(this).closest("tr");
		currentId = tr.attr("data-id");
		var input = $($(".hide").find("input"));
		input.val(currentId);
		console.log(currentId);
	});
	
	/*$(".delete-account").on("click", function(e) {
		var result = confirm("dsdsolo");
		var tr = $(this).closest("tr");
		if (result) {
			tr.remove();
		}
	});*/
});

