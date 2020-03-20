package com.curso.blockchain.demo.modelo.excepcion;

public class ExcepcionBloqueInexistente extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionBloqueInexistente(String mensaje) {
        super(mensaje);
    }
}
