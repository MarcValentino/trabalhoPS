package com.marcelo.exception;

public class AutorNaoEncontradoException extends Exception{
    private final static long serialVersionUID = 1;

    private int codigo;

    public AutorNaoEncontradoException(String msg)
    {	super(msg);
    }

    public AutorNaoEncontradoException(int codigo, String msg)
    {	super(msg);
        this.codigo = codigo;
    }

    public int getCodigoDeErro()
    {	return codigo;
    }
}
