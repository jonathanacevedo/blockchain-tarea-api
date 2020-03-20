package com.curso.blockchain.demo.repositorio.usuario;

import com.curso.blockchain.demo.modelo.usuario.dto.DtoUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RepositorioUsuarioMySql implements RepositorioUsuario {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    String sqlCrear = "INSERT INTO usuario (usuario_nombre, usuario_clave) VALUES (:nombre,:clave);";
    String sqlListar = "SELECT * FROM usuario;";

    public RepositorioUsuarioMySql(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public int crearUsuario(String nombreUsuario, String claveUsuario) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("nombre", nombreUsuario)
                .addValue("clave", claveUsuario);

        return this.namedParameterJdbcTemplate.update(sqlCrear, namedParameters);
    }

    @Override
    public List<DtoUsuario> listarUsuarios() {
        return this.namedParameterJdbcTemplate.query(sqlListar, new MapeoUsuario());
    }
}
