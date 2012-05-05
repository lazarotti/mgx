	    function doBack(nomeDaClasse,idDaClasse, campo2, campo3, campo4){
    	
    		
    		var	campoRetorno1 = window.oponerCampoRetorno1;    		
			var	campoRetorno2 = window.oponerCampoRetorno2;
			var	campoRetorno3 = window.oponerCampoRetorno3;
			var	campoRetorno4 = window.oponerCampoRetorno4;
			
			
			var formId = window.oponerForm;
			

			if(campoRetorno1 != null && idDaClasse != null && nomeDaClasse != null){
				opener.document.forms[formId][formId + ":" +  campoRetorno1].value =idDaClasse+"-"+nomeDaClasse;
			}

			if(campoRetorno2 != null && campo2 != null){			
				opener.document.forms[formId][formId + ":" +  campoRetorno2].value = campo2;
			}

			if(campoRetorno3 != null && campo3 != null){		
				opener.document.forms[formId][formId + ":" +  campoRetorno3].value = campo3;
			}
			
			if(campoRetorno4 != null && campo4 != null){		
				opener.document.forms[formId][formId + ":" +  campoRetorno4].value = campo4;
			}
		          
    		window.close();
    }


    function doPopup(paginaDestino,campoPreenchidoDestino,formId,campoRetorno1, campoRetorno2, campoRetorno3, campoRetorno4){
    		
    		campo = getObj(campoPreenchidoDestino,formId);
    		
    		if(campo == null)
    			alert(formId + campoPreenchidoDestino);
    	
    		popup = window.open(paginaDestino + "?campoEnvio="+campo.value,"popup",
    		"height=450,width=585,toolbar=no,menubar=no,scrollbars=yes");
    				
			popup.oponerCampoRetorno1 = campoRetorno1;
			popup.oponerCampoRetorno2 = campoRetorno2;
			popup.oponerCampoRetorno3 = campoRetorno3;
			popup.oponerCampoRetorno4 = campoRetorno4;
			popup.oponerForm = formId;	
			
							
    		popup.focus();
    }
    
    
    function doPopupAnexo(grupoAnexoTipo,entidadeNome,id){
    		    	
    		popup = window.open("modulo/anexo/anexo.seam?grupoAnexoTipo="+
    				grupoAnexoTipo+"&entidadeNome="+entidadeNome+"&id="+id,"popup",
    			"height=450,width=585,toolbar=no,menubar=no,scrollbars=yes");
    			    		    				
    		popup.focus();
    }    
    
    
    
    
    
   