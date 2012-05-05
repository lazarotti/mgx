window.onload = function(){
	if (window.event){
		var el = document.getElementById("acompanha");
		var formulario = document.getElementById("geral");
		el.style.height = formulario.offsetHeight;
	} else {
		var el = document.getElementById("acompanha");
		var formulario = document.getElementById("geral");
		el.style.height = formulario.offsetHeight+"px";
	}
}
