package com.curso.blockchain.demo.repositorio.usuario;

import com.curso.blockchain.demo.modelo.usuario.dto.DtoUsuario;

import java.util.List;

public interface RepositorioUsuario {

    /**
     * Creación de usuarios
     * @param: nombre del usuario a crear
     * @return id del usuario creado
     * */
    int crearUsuario(String nombreUsuario, String claveUsuario);

    /**
     * Listado de usuarios
     * @return id del usuario creado
     * */
    List<DtoUsuario> listarUsuarios();
}
