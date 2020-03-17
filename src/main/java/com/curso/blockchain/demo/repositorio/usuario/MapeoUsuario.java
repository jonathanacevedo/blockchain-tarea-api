package com.curso.blockchain.demo.repositorio.usuario;

import com.curso.blockchain.demo.modelo.usuario.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoUsuario implements RowMapper<Usuario> {


    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

        String nombre = rs.getString("usuario_nombre");
        String clave = rs.getString("usuario_clave");

        return new Usuario(nombre, clave);
    }
}
