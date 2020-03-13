package com.curso.blockchain.demo.repositorio;

import com.curso.blockchain.demo.modelo.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoUsuario implements RowMapper<Usuario> {


    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

        String nombre = rs.getString("nombre");
        String clave = rs.getString("password");

        return new Usuario(nombre, clave);
    }
}
