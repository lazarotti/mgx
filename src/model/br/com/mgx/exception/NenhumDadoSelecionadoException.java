package br.com.mgx.exception;

import org.jboss.seam.annotations.ApplicationException;

@ApplicationException(rollback=false,end=false)
public class NenhumDadoSelecionadoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Nenhum dado foi selecionado";	

	
	public NenhumDadoSelecionadoException()
    {
        super(MESSAGE);
       
    }
	
	public NenhumDadoSelecionadoException(String message)
    {
        super(message);
       
    }

    public NenhumDadoSelecionadoException(Throwable cause)
    {
        super(MESSAGE,cause);

    }

    public NenhumDadoSelecionadoException(String message, Throwable cause)
    {
        super(message, cause);
    }
	

}
