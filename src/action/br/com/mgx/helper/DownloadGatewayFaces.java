package br.com.mgx.helper;

import java.io.InputStream;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;

@Name("downloadGateway")
@AutoCreate
public class DownloadGatewayFaces implements DownloadGateway{
	
	private DownloadGatewayImpl download;
	
	public  DownloadGatewayFaces(){
		download = new DownloadGatewayImpl();
	}

	public void doDownload(String fileName, String directory) {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		download.doDownload(fileName, directory, (HttpServletResponse)facesContext.
		                 getExternalContext().getResponse());
		facesContext.responseComplete();
	}

	public void doDownload(String fileName, String path, String extension){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		download.doDownload(fileName, path, extension, (HttpServletResponse)facesContext.
		                 getExternalContext().getResponse());
		facesContext.responseComplete();
	}
	
	public void doDownload(String fileName, InputStream in){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		download.doDownload(fileName, in, (HttpServletResponse)facesContext.
		                 getExternalContext().getResponse());
		facesContext.responseComplete();		
	}
	
	public void doDownload(String fileName,byte[] bytes, HttpServletResponse response){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		download.doDownload(fileName, bytes, response);		
		facesContext.responseComplete();		
	}

	public void doDownload(String fileName, byte[] bytes) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		download.doDownload(fileName, bytes, (HttpServletResponse)facesContext.
		                 getExternalContext().getResponse());		
		facesContext.responseComplete();
		
	}
}
