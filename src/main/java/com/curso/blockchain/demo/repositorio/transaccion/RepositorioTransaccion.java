package com.curso.blockchain.demo.repositorio.transaccion;

import com.curso.blockchain.demo.modelo.blockchain.Transaccion;

import java.util.List;

public interface RepositorioTransaccion {

    /**
     * Crear transacción
     * @param transaccion
     * */
    void crearTransaccion(Transaccion transaccion, Long idBloque);

    /**
     * Listar transacciones de un bloque
     * @param idBloque
     * */
    List<Transaccion> listarTransacciones(Long idBloque);
}
