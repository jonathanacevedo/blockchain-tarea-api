package com.curso.blockchain.demo.repositorio.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;

import java.util.List;

public interface RepositorioBloque {

    /**
     * Guardar bloque
     * @param bloque
     * */
    Long guardarBloqueGenesis(Bloque bloque);

    /**
     * Guardar bloque
     * @param bloque
     * */
    Long guardarBloque(Bloque bloque);

    /**
     * Actualizar bloque
     * @param bloque
     * */
    void actualizarBloque(Bloque bloque);

    /**
     * Obtener bloque pendiente por minar
     * */
    Long obtenerBloquePendiente();

    /**
     * Obtener el header del último bloque de la cadena
     * */
    Bloque obtenerUltimoBloque();

    /**
     * Obtener el número de transacciones de un bloque
     * @param idBloque : id del bloque
     * @return número de transacciones del bloque
     * */
    Integer obtenerNumeroTransaccionesBloque(Long idBloque);

    /**
     * Permite marcar un bloque como lleno de transacciones en su body
     * @param idBloque : id del bloque
     * */
    void marcarBloqueLleno(Long idBloque);

    /**
     * Obtener bloque que sigue para ser minado
     * @return Bloque a ser minado
     * */
    Bloque obtenerBloqueAMinar();

    /**
     * Obtener bloque que sigue para ser minado
     * @return Bloque a ser minado
     * */
    Integer obtenerNumeroBloques();

    /**
     * Obtener bloque que sigue para ser minado
     * @return Bloque a ser minado
     * */
    List<Bloque> obtenerBloques();
}
