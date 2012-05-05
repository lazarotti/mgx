package br.com.mgx.faces;

import java.lang.reflect.Field;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.jboss.seam.Component;

import br.com.mgx.dao.DataAccessObject;



public class SiqConvertEntity implements Converter {
	
	public SiqConvertEntity(){
		
	}

	public static final String CONVERTER_ID = "SiqConvertEntity";

	private DataAccessObject dao;

	public Object getAsObject(FacesContext ctx, UIComponent ui, String idClasse) {
		Object entidade = null;
		
		String id = idClasse.substring(0,idClasse.indexOf("-"));
		String nomeClasse = idClasse.substring(idClasse.indexOf("-")+1);	  
	
		
		dao  = (DataAccessObject)Component.getInstance("dao");
		
		entidade = dao.querySingleResult(
					"FROM "+ nomeClasse + " entity " +
					"WHERE entity.id = ?1",new Object[]{new Long(id)});
	

		return entidade;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Field campoId = null;
		String id = null;
		try {
			try{
				//obtendo o atributo id de qualquer classe entity
				campoId = obj.getClass().getDeclaredField("id");
			} catch (NoSuchFieldException e) {
				try {
					// se o objeto é herdado, procurar o campo no pai do objeto
					campoId = obj.getClass().getSuperclass().getDeclaredField("id");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			campoId.setAccessible(true);
			id = campoId.get(obj)!=null?campoId.get(obj).toString():null;
			if(id!= null)
				id = id+"-"+obj.getClass().getName();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return id ;
	}
		
}
