/** *  */
$(function(){
	
	function suerte(){
		var signo ={};
		signo["signo"] =$("#signo").val();
		//alert("signo " + signo );
		
		$.ajax({//objeto Config
		url:'suerte',	
		type:"POST",
		data:signo,
		dataType:"html",
		success : function(respuesta){
			$("#salida").html(respuesta);
		}
		});
	}
	
	$("#formSuerte").submit(function(evento){
		suerte();
		evento.preventDefault();
		return false;
	});
})