package com.curso.blockchain.demo.repositorio.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.modelo.blockchain.Header;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoBloqueAMinar implements RowMapper<Bloque> {
    @Override
    public Bloque mapRow(ResultSet rs, int rowNum) throws SQLException {

        String hashPrevio = rs.getString("bloque_hashprevio");
        Header header = new Header(hashPrevio, null, null, null);
        Long idBloque = rs.getLong("bloque_id");
        return new Bloque(idBloque, header, null, null);
    }
}
