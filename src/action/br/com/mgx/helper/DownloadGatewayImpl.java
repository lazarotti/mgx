package br.com.mgx.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class DownloadGatewayImpl{

	public void doDownload(String fileName, String directory,
			HttpServletResponse response) {
		FileInputStream in = null;
		OutputStream out = null;
		try {
			
			in = new FileInputStream(fileName);
			out = response.getOutputStream();
			setResponseHead(response, fileName.substring(directory.length()), in.available());
			writeInputstream(in, out);		
		} catch (Exception e) {
			throw new SiqDownloadException(e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
	

	public void doDownload(String fileName, String path, String extension,
			HttpServletResponse response) {

		FileInputStream in = null;
		OutputStream out = null;

		try {
			
			extension = extension.toLowerCase();
			in = new FileInputStream(path + fileName + "." + extension);
			out = response.getOutputStream();
			setResponseHead(response, fileName+"."+extension, in.available());
			writeInputstream(in, out);
			
		} catch (Exception e) {
			throw new SiqDownloadException(e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void doDownload(String fileName, InputStream in, HttpServletResponse response){
		OutputStream out = null;
		try{
			out = response.getOutputStream();
			setResponseHead(response, fileName, in.available());
			writeInputstream(in, out);
			
		}catch(Exception e){
			throw new SiqDownloadException(e);
			
		}finally {
			try {
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void doDownload(String fileName,byte[] bytes, HttpServletResponse response){
		OutputStream out = null;
		try{
			out = response.getOutputStream();
			setResponseHead(response, fileName, bytes.length);
			out = response.getOutputStream();
			out.write(bytes, 0, bytes.length);			
		}catch(Exception e){
			throw new SiqDownloadException(e);
			
		}finally {
			try {
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void writeInputstream(InputStream inputStream,
				 OutputStream outputStream) throws IOException{
		int iBufSize = inputStream.available();
		byte inBuf[] = new byte[iBufSize];
		int iNumRead;
		while ((iNumRead = inputStream.read(inBuf, 0, iBufSize)) > 0)
			outputStream.write(inBuf, 0, iNumRead);
	}
	
	protected void setResponseHead(HttpServletResponse response,String fileName,int fileLength){
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;  filename=\""+fileName+"\"");
		response.setContentLength(fileLength);
	}

}
