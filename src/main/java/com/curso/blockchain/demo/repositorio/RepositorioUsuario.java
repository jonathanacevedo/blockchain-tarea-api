package com.curso.blockchain.demo.repositorio;

public interface RepositorioUsuario {

    /**
     * Creación de usuarios
     * @param: nombre del usuario a crear
     * @return id del usuario creado
     * */

    String crearUsuario(String nombreUsuario);
}
