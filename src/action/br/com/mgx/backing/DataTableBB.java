package br.com.mgx.backing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityHome;
import org.richfaces.component.html.HtmlDataTable;

import br.com.mgx.entity.Selecionavel;
import br.com.mgx.exception.NenhumDadoSelecionadoException;
import br.com.mgx.helper.DaoHelper;

@Name("dataTableBB")
public class DataTableBB {

	private HtmlDataTable dataTable;
	@In(create=true)
	private DaoHelper daoHelper;

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public List selecionados() throws IOException {
		List<Selecionavel> linhas;
		List linhasSelecionadas = new ArrayList<Selecionavel>();
		if (dataTable != null) {
			linhas = (List<Selecionavel>) dataTable.getValue();
			for (Selecionavel selecionavel : linhas) {
				if (selecionavel.isSelected())
					linhasSelecionadas.add(selecionavel);
			}
		}
	//	if (linhasSelecionadas.size() < 1)
		//	throw new NenhumDadoSelecionadoException();

		return linhasSelecionadas;
	}

	public Object remove() throws IOException{
		List<Selecionavel> linhas;
		List linhasSelecionadas = new ArrayList<Selecionavel>();
		if(dataTable != null){
			linhas = (List<Selecionavel>)dataTable.getValue();
			for(int i=0;i<linhas.size();i++){
				Selecionavel selecionavel = linhas.get(i);
				 if(selecionavel.isSelected()){
					 dataTable.setRowIndex(i);
					 dataTable.setRowKey(null);				 
						dataTable.decode(FacesContext.getCurrentInstance());					 
				 }
			 }
		}
		
		dataTable.setValue(null);
		dataTable.decode(FacesContext.getCurrentInstance());
		
		Object linhaSelecionada = null;

		 linhasSelecionadas = selecionados();

		if (linhasSelecionadas != null && linhasSelecionadas.size() > 0)
			linhaSelecionada = linhasSelecionadas.get(0);

		return linhaSelecionada;	
	}	
	
	public Object selecionado() throws IOException {

		Object linhaSelecionada = null;

		List linhasSelecionadas = selecionados();

		if (linhasSelecionadas != null && linhasSelecionadas.size() > 0)
			linhaSelecionada = linhasSelecionadas.get(0);

		return linhaSelecionada;
	}

}
