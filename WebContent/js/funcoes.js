// Esta função "chama" todas as funções usadas em um documento.
function init() {
	createExternalLinks();
}




// FORÇA LINKS A ABRIREM EM UMA NOVA JANELA
//******************************************************************************
// A W3C não aceita mais o atributo "target" em links (tag <a>) em doctypes XHTML 1.0 Strict
// A função abaixo faz com que todos os links que possuem rel="externo" no link, abram em outra janela conforme no exemplo abaixo:
// EXEMPLO:
//******************************************************************************
//<a href="index.php" title="Link de Exemplo" rel="externo">

/* Para chamar a função, insira no body  == <script type="text/javascript">createExternalLinks();</script>  */
function createExternalLinks() {
    if(document.getElementsByTagName) {
        var anchors = document.getElementsByTagName('a');
        for(var i=0; i<anchors.length; i++) {
            var anchor = anchors[i];
            if(anchor.getAttribute("href") && anchor.getAttribute('rel')=='externo') { // <-- É necessário inserir rel="externo" no link
                anchor.target = '_blank';
                var title = anchor.title + ' (Este link abre uma nova janela)'; // <-- Insere este texto no final do Title do link
                anchor.title = title;
            }
        }
    }
}


function getObj(objId, formId) {
        var fullId = objId;

        if (formId != null && formId.length > 0) {
            fullId = formId + ':' + objId;
        }
        var elem = null;
        if (document.getElementById) {
            elem = document.getElementById(fullId);	
        } else if (document.all) {
            elem = document.all[fullId];
        } else if (document.layers) {
            elem = document.layers[fullId];
        }
        return elem;
} 

function imagens(layer){
	
	itm = document.getElementById(layer)
	
	altura = 58 - (itm.offsetHeight) //58 é o tamanho dessa div estipulado no estilo.css!!!
	alturaReal = altura/2
	
	itm.style.marginTop = alturaReal+"px"
}
function menu(id){
		
	getElementById(id).style.marginTop = '100px'
}

function cleanComponentRight(id1,id2){
	var comp1 = getObj(id1);
	var comp2 = getObj(id2);
	if(comp1.value == '' || comp1.value == null ||
		 comp1.value == 'org.jboss.seam.ui.NoSelectionConverter.noSelectionValue'){
		comp2.value = '';
	}
}

function ShowHide(id1, id2) { // Função usada para exibir ou ocultar Layers
	if (id1 != '') 
		expMenu(id1);

	if (id2 != '') 
		expMenu(id2);
}

function expMenu(id){ // Complemento da função ShowHide (acima) **Função Crossbrowser
	var itm = null;
	
	if (document.getElementById)
		itm = document.getElementById(id);
	else 
		if (document.all)
			itm = document.all[id];
	
	if (itm)
		if (itm.style)
			if (itm.style.display == "none")
				itm.style.display = ""; 
				
			else 
				itm.style.display = "none"; 
		else 
			itm.visibility = "show";
			troca_sinal(itm)
}			
function troca_sinal(id) { // Função usada para exibir ou ocultar Layers
	var itm = null;
	
	if (document.getElementById)
		itm = document.getElementById('op');
	else 
		if (document.all)
			itm = document.all['op'];
				
	if(itm){
		
		inner = itm.className
		
		if(id.style.display == ""){
			itm.innerHTML = "-";
			return false;
		}else{
			itm.innerHTML = "+";
			return false;
		}
	}
}	


function tipoMedicaoRegra(){
		    		    				
	if (document.getElementById('paCaracteristicaForm:tipoMedicao')!=null){

		tipoMedicao = document.getElementById('paCaracteristicaForm:tipoMedicao');		
		espMax = document.getElementById('paCaracteristicaForm:espMinima');
		espMin = document.getElementById('paCaracteristicaForm:espMaxima');	
						
			if(tipoMedicao.selectedIndex == 0){
				espMax.value = '';
				espMin.value = '';
				espMax.readOnly = true;
				espMin.readOnly = true;		
							
			}if(tipoMedicao.selectedIndex == 1){
				espMax.readOnly = false;
				espMin.value = '';
				espMin.readOnly = true;	
						
			}if(tipoMedicao.selectedIndex == 2){								
					espMax.readOnly = true;
					espMax.value = '';
					espMin.readOnly = false;
										
			}if(tipoMedicao.selectedIndex == 3){
					espMax.readOnly = false;
					espMin.readOnly = false;	
			}
				
	}				
}

	

		
		


