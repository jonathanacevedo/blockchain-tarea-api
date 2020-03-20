package com.curso.blockchain.demo.modelo.excepcion;

public class ExcepcionValorObligatorio extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionValorObligatorio(String mensaje) {
        super(mensaje);
    }
}
