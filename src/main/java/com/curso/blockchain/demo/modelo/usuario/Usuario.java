package com.curso.blockchain.demo.modelo.usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Usuario {

    private static final String NOMBRE_OBLIGATORIO = "El nombre debe ser obligatorio.";
    private static final String CLAVE_OBLIGATORIA = "La clave debe ser obligatoria.";

    private String nombre;
    private String clave;

    public Usuario(String nombre, String clave) {

        ValidadorArgumento.validarObligatorio(nombre, NOMBRE_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(clave, CLAVE_OBLIGATORIA);

        this.nombre = nombre;
        this.clave = clave;
    }
}
