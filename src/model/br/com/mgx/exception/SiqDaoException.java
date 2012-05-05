package br.com.mgx.exception;

import java.util.ArrayList;

import org.jboss.seam.annotations.ApplicationException;

@ApplicationException(rollback=false,end=false)
public class SiqDaoException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

		
	private static final String MESSAGE = "Ocorreu um erro na camada DAO";
	
	
	public SiqDaoException()
    {
		super(MESSAGE);		
		
    }
	
	
	public SiqDaoException(String message)
    {
        super(message);
       
    }

    public SiqDaoException(Throwable cause)
    {
        super(MESSAGE,cause);

    }

    public SiqDaoException(String message, Throwable cause)
    {
        super(message, cause);
    }


}
