package com.curso.blockchain.demo.servicio.usuario;

import com.curso.blockchain.demo.modelo.usuario.dto.DtoUsuario;
import com.curso.blockchain.demo.repositorio.usuario.RepositorioUsuario;

import java.util.List;

public class ServicioListarUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioListarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<DtoUsuario> ejecutar() {
        return this.repositorioUsuario.listarUsuarios();
    }
}
