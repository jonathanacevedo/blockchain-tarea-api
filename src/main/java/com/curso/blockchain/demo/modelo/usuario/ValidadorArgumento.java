package com.curso.blockchain.demo.modelo.usuario;

import com.curso.blockchain.demo.modelo.excepcion.ExcepcionValorObligatorio;

public final class ValidadorArgumento {

    private ValidadorArgumento(){}

    public static void validarObligatorio(String valorObligatorio, String mensaje) {
        if(valorObligatorio == null || valorObligatorio.isEmpty()) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }
}
