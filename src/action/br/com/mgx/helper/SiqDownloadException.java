package br.com.mgx.helper;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class SiqDownloadException extends RuntimeException{
	
	
	private static final String MESSAGE = "Erro na tentativa de Donwload";
	private String keyDefault = "error.siqLocator";
	
	@SuppressWarnings("unchecked")
	private ArrayList keys = new ArrayList();
	
	
	public SiqDownloadException()
    {
		super(MESSAGE);	
		setSuperKeys(null);		
    }
	
	public SiqDownloadException(String[] keys){
		super(MESSAGE);	
		setSuperKeys(keys);
	}
	
	public SiqDownloadException(String message)
    {
        super(message);
        setSuperKeys(null);
    }

    public SiqDownloadException(Throwable cause)
    {
        super(MESSAGE,cause);
        setSuperKeys(null);        
    }

    public SiqDownloadException(String message, Throwable cause)
    {
        super(message, cause);
        setSuperKeys(null);        
    }
    
    @SuppressWarnings("unchecked")
	private void setSuperKeys(String keys[]){
			this.keys.add(keyDefault);
			if(keys!=null){			
				for(int i = 0; i<keys.length;i++){
					this.keys.add(keys[i]);
				}
			}else
				keys= new String[0];
		keys = (String[])this.keys.toArray(keys);    	
    }


}
