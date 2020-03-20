package com.curso.blockchain.demo.modelo.excepcion;

public class ExcepcionBloqueIncompleto extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionBloqueIncompleto(String mensaje) {
        super(mensaje);
    }
}
