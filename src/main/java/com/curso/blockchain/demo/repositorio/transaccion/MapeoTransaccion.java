package com.curso.blockchain.demo.repositorio.transaccion;

import com.curso.blockchain.demo.modelo.blockchain.Transaccion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class MapeoTransaccion implements RowMapper<Transaccion> {
    @Override
    public Transaccion mapRow(ResultSet rs, int rowNum) throws SQLException {

        String origen = rs.getString("transaccion_origen_usuario");
        String destino = rs.getString("transaccion_destino_usuario");
        Long valor = rs.getLong("transaccion_valor");
        Date fecha = rs.getDate("transaccion_fecha");
        return new Transaccion(origen, destino, fecha, valor);
    }
}
