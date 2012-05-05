package br.com.mgx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.mgx.entity.Acessorio;
import br.com.mgx.entity.OrdemServico;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;

@Name("comprovanteReport")
@Scope(ScopeType.CONVERSATION)
@AutoCreate
public class ComprovanteReport extends ReportService{
	
	OrdemServico ordemServico;	

	@Override
	protected JRDataSource getDataSource() {
		return new JREmptyDataSource();
	}

	@Override
	protected Map<String, Object> getParams() {
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();  
        String logoRealReal = request.getRealPath("/img/LOGO.gif");		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("logo", logoRealReal);
		map.put("os", ordemServico);
		
		//acessorios
		List<Acessorio> acessorios =  ordemServico.getAcessorios();
		StringBuilder acessorioName = new StringBuilder();
		for(int i=0; i<acessorios.size();i++){
			acessorioName.append(acessorios.get(i).getNome());
			if(i!= acessorios.size()-1)
				acessorioName.append(" - ");
		}
		map.put("acessorios",acessorioName.toString());		
		
		return map;		
	}

	@Override
	protected String getReportPath() {
		return "/jasper/Comprovante_bku.jasper";
	}
	
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}	

}
