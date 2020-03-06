package com.curso.blockchain.demo.servicio;

import com.curso.blockchain.demo.repositorio.RepositorioUsuario;

public class ServicioListarUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioListarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public String ejecutar(String nombreUsuario) {
        return this.repositorioUsuario.crearUsuario(nombreUsuario);
    }
}
