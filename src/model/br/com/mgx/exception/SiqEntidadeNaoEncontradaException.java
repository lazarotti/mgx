package br.com.mgx.exception;

import org.jboss.seam.annotations.ApplicationException;

@ApplicationException(rollback=false,end=false)
public class SiqEntidadeNaoEncontradaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Entidade não encontrada no repositório";	

	
	public SiqEntidadeNaoEncontradaException(String message)
    {
        super(message);
       
    }

    public SiqEntidadeNaoEncontradaException(Throwable cause)
    {
        super(MESSAGE,cause);

    }

    public SiqEntidadeNaoEncontradaException(String message, Throwable cause)
    {
        super(message, cause);
    }
	

}
