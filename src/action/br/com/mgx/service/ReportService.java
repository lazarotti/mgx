package br.com.mgx.service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public abstract class ReportService {
	
    protected abstract JRDataSource getDataSource(); 
	
    protected abstract String getReportPath(); 
    
    protected abstract Map<String, Object> getParams();
    
	public byte[] gerarRelatorio() throws Exception{
        String reportUrl = getReportPath(); 		
		
        Map<String, Object> params = new HashMap<String, Object>();  
        params.putAll(getParams());  
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();  
        String reportUrlReal = request.getRealPath(reportUrl);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportUrlReal, params,getDataSource());  
        ByteArrayOutputStream output = new ByteArrayOutputStream();  
        JasperExportManager.exportReportToPdfStream(jasperPrint, output);
        return output.toByteArray();

	}
	

}
