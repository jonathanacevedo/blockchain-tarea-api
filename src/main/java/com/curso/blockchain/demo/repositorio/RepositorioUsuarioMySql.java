package com.curso.blockchain.demo.repositorio;

import com.curso.blockchain.demo.modelo.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioUsuarioMySql implements RepositorioUsuario {

    private final JdbcTemplate jdbcTemplate;

    public RepositorioUsuarioMySql(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public String crearUsuario(String nombreUsuario) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("nombre", nombreUsuario);

        List<Usuario> usuario = jdbcTemplate.query("SELECT * FROM usuario WHERE usuario_nombre = 'Jonathan'", new MapeoUsuario());

        return usuario.get(0).getNombre();
    }
}
