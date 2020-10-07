$(document).ready(function(){
	var date_input=$('input[name="date"]'); //our date input has the name "date"
	var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	date_input.datepicker({
		format: 'yyyy/mm/dd',
		container: container,
		todayHighlight: true,
		autoclose: true,
		
	});

//	verificacion de fecha y asignacion de signo
	$( "#date" ).change(function() {

		var fecha = $("#date").val().split("/")
		var resto = fecha[0] % 12;
		$("#signo").val(resto)
		console.log("resto "+resto)
	});
	

	//antes de mandar el formulario de registro  
	jQuery("#formRegister").submit(function(e) {


	});



});
