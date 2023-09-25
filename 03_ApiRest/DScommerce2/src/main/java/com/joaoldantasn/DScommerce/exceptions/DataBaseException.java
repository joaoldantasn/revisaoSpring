package com.joaoldantasn.DScommerce.exceptions;

//excecao de qnd não encontra um recurso que esta sendo buscada
public class DataBaseException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataBaseException(String msg) {
		super(msg);
	}
}
