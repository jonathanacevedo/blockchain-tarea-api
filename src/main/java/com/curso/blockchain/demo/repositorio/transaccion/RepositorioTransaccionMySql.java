package com.curso.blockchain.demo.repositorio.transaccion;

import com.curso.blockchain.demo.modelo.blockchain.Transaccion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTransaccionMySql implements RepositorioTransaccion {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    String sqlCrear = "INSERT INTO transaccion(transaccion_fecha, transaccion_valor, transaccion_origen_usuario, transaccion_destino_usuario, bloque_id) " +
            "VALUES(:fecha, :valor, :origen, :destino, :bloque);";

    String sqlListar = "SELECT * FROM transaccion WHERE bloque_id = :idBloque;";

    public RepositorioTransaccionMySql(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void crearTransaccion(Transaccion transaccion, Long idBloque) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("fecha", transaccion.getFecha());
        parameterSource.addValue("valor", transaccion.getValor());
        parameterSource.addValue("origen", transaccion.getOrigen());
        parameterSource.addValue("destino", transaccion.getDestino());
        parameterSource.addValue("bloque", idBloque);

        namedParameterJdbcTemplate.update(sqlCrear, parameterSource);
    }

    @Override
    public List<Transaccion> listarTransacciones(Long idBloque) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("idBloque", idBloque);
        return namedParameterJdbcTemplate.query(sqlListar, parameterSource, new MapeoTransaccion());
    }
}
