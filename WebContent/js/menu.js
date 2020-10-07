


$(document).ready(function(){
	
	var lista = $("#listaTotal").val()
	

$("#divEliminar").hide();
$("#formCrear").hide();
$("#ocultarLista").hide();
$("#tablaUsuarios").hide();
$("#divEditar").hide();
//$("#divEditarFinal").hide();

	
	$( "#crear" ).click(function() {
		$("#cardCrear").hide();
		$("#formCrear").show();
		});
	
	$( "#editar" ).click(function() {
		$("#cardEditar").hide();
		$("#divEditar").show();
		
		
		});
	
	$( "#eliminar" ).click(function() {
		console.log("funciona")
		$("#cardEliminar").hide();
		$("#divEliminar").show();
		
		
		});
	
	$( "#mostrarLista" ).click(function() {
		$("#ocultarLista").show();
		$("#tablaUsuarios").show();
		$("#mostrarLista").hide();
		
		});
	$( "#ocultarLista" ).click(function() {
		$("#ocultarLista").hide();
		$("#tablaUsuarios").hide();
		$("#mostrarLista").show();
		
		});
});
