$(document).ready(function(){
	var date_input=$('input[name="dateEdit"]'); //our date input has the name "date"
	var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	date_input.datepicker({
		format: 'yyyy/mm/dd',
		container: container,
		todayHighlight: true,
		autoclose: true,

	});

//	verificacion de fecha y asignacion de signo
	$( "#dateEdit" ).change(function() {

		var fecha = $("#dateEdit").val().split("/")
		var resto = fecha[0] % 12;
		$("#signoEdit").val(resto)
		console.log("resto "+resto)
	});

});