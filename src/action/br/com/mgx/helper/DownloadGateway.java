package br.com.mgx.helper;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

public interface DownloadGateway {

	public abstract void doDownload(String fileName, String directory);

	public abstract void doDownload(String fileName, String path,
			String extension);

	public abstract void doDownload(String fileName, InputStream in);
	
	public abstract void doDownload(String fileName, byte[] bytes);	

	public abstract void doDownload(String fileName, byte[] bytes,
			HttpServletResponse response);

}