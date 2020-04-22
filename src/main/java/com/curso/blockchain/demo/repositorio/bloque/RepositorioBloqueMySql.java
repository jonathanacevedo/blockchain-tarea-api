package com.curso.blockchain.demo.repositorio.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.modelo.excepcion.ExcepcionBloqueInexistente;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class RepositorioBloqueMySql implements RepositorioBloque {

    private static final String BLOQUE_INEXISTENTE = "No existe ningún bloque que se pueda minar.";
    Logger logger = Logger.getLogger("RepositorioBloqueMySql");

    String sqlGuardar = "INSERT INTO bloque(bloque_hashprevio, bloque_hashpropio, bloque_nonce, bloque_hashroot) VALUES (:hashPrevio,:hashPropio,:nonce,:hashRoot);";
    String sqlGuardarGenesis = "INSERT INTO bloque(bloque_hashprevio, bloque_hashpropio, bloque_nonce, bloque_hashroot, bloque_eslleno, bloque_esminado) VALUES (:hashPrevio,:hashPropio,:nonce,:hashRoot, 1, 1);";
    String sqlActualizar = "UPDATE bloque SET bloque_hashpropio = :hashPropio,bloque_nonce = :nonce,bloque_esminado = 1 WHERE bloque_id = :idBloque";
    String sqlObtenerBloquePendiente = "SELECT bloque_id FROM bloque WHERE bloque_eslleno = :FALSE LIMIT 1;";
    String sqlObtenerUltimoBloque = "SELECT * FROM bloque WHERE bloque_esminado = :TRUE ORDER BY bloque_id DESC LIMIT 1";
    String sqlObtenerTransaccionesBloque = "SELECT COUNT(1) FROM transaccion INNER JOIN bloque ON transaccion.bloque_id = bloque.bloque_id WHERE bloque.bloque_id = :idBloque;";
    String sqlMarcarBloqueLleno = "UPDATE bloque SET bloque_eslleno = true WHERE bloque_id = :idBloque;";
    String sqlObtenerBloqueAMinar = "SELECT * FROM bloque WHERE bloque_esminado = 0 AND bloque_eslleno = 1 ORDER BY bloque_id ASC LIMIT 1;";
    String sqlObtenerNumeroBloques = "SELECT COUNT(1) FROM bloque;";
    String sqlObtenerBloques = "SELECT * FROM bloque";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public RepositorioBloqueMySql(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public Long guardarBloqueGenesis(Bloque bloque) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("hashPrevio", bloque.getHeader().getHashPrevio());
        parameterSource.addValue("hashPropio", bloque.getHeader().getHashPropio());
        parameterSource.addValue("nonce", bloque.getHeader().getNonce());
        parameterSource.addValue("hashRoot", bloque.getHeader().getHashRoot());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.namedParameterJdbcTemplate.update(sqlGuardarGenesis, parameterSource, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public Long guardarBloque(Bloque bloque) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("hashPrevio", bloque.getHeader().getHashPrevio());
        parameterSource.addValue("hashPropio", bloque.getHeader().getHashPropio());
        parameterSource.addValue("nonce", bloque.getHeader().getNonce());
        parameterSource.addValue("hashRoot", bloque.getHeader().getHashRoot());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.namedParameterJdbcTemplate.update(sqlGuardar, parameterSource, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public void actualizarBloque(Bloque bloque) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("hashPropio", bloque.getHeader().getHashPropio());
        parameterSource.addValue("nonce", bloque.getHeader().getNonce());
        parameterSource.addValue("idBloque", bloque.getId());
        namedParameterJdbcTemplate.update(sqlActualizar, parameterSource);
    }

    @Override
    public Long obtenerBloquePendiente() {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("FALSE", 0);
        Long idBloqueSinMinar = null;
        try {
            idBloqueSinMinar = namedParameterJdbcTemplate.queryForObject(sqlObtenerBloquePendiente,parameterSource, Long.class);
        } catch (EmptyResultDataAccessException e) {
            logger.info(e.getMessage());
        }
        return idBloqueSinMinar;
    }

    @Override
    public Bloque obtenerUltimoBloque() {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("TRUE", 1);
        return namedParameterJdbcTemplate.queryForObject(sqlObtenerUltimoBloque, parameterSource, new MapeoBloque());
    }

    @Override
    public Integer obtenerNumeroTransaccionesBloque(Long idBloque) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("idBloque", idBloque);
        return namedParameterJdbcTemplate.queryForObject(sqlObtenerTransaccionesBloque, parameterSource, Integer.class);
    }

    @Override
    public void marcarBloqueLleno(Long idBloque) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("idBloque", idBloque);
        namedParameterJdbcTemplate.update(sqlMarcarBloqueLleno, parameterSource);
    }

    @Override
    public Bloque obtenerBloqueAMinar() {
        Bloque bloque = null;
        try {
            bloque = namedParameterJdbcTemplate.queryForObject(sqlObtenerBloqueAMinar, new MapSqlParameterSource(), new MapeoBloqueAMinar());
        } catch(EmptyResultDataAccessException e){
            throw new ExcepcionBloqueInexistente(BLOQUE_INEXISTENTE);
        }
        return bloque;
    }

    @Override
    public Integer obtenerNumeroBloques() {
        return namedParameterJdbcTemplate.queryForObject(sqlObtenerNumeroBloques, new MapSqlParameterSource(), Integer.class);
    }

    @Override
    public List<Bloque> obtenerBloques() {
        return namedParameterJdbcTemplate.query(sqlObtenerBloques, new MapSqlParameterSource(), new MapeoListaBloques());
    }
}
