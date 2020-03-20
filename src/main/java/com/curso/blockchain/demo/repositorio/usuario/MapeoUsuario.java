package com.curso.blockchain.demo.repositorio.usuario;

import com.curso.blockchain.demo.modelo.usuario.Usuario;
import com.curso.blockchain.demo.modelo.usuario.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoUsuario implements RowMapper<DtoUsuario> {


    @Override
    public DtoUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {

        String nombre = rs.getString("usuario_nombre");
        String clave = rs.getString("usuario_clave");

        return new DtoUsuario(nombre, clave);
    }
}
