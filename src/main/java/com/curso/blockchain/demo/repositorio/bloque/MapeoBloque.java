package com.curso.blockchain.demo.repositorio.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.modelo.blockchain.Header;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoBloque implements RowMapper<Bloque> {

    @Override
    public Bloque mapRow(ResultSet rs, int rowNum) throws SQLException {
        String hashPropio = rs.getString("bloque_hashpropio");
        Header header = new Header(null, hashPropio, null, null);
        Long idBloque = rs.getLong("bloque_id");
        return new Bloque(idBloque, header, null, null);
    }
}
