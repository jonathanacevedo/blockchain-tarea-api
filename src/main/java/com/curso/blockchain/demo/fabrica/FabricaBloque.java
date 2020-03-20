package com.curso.blockchain.demo.fabrica;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.modelo.blockchain.Body;
import com.curso.blockchain.demo.modelo.blockchain.Header;
import com.curso.blockchain.demo.modelo.blockchain.Transaccion;

import java.util.List;

public class FabricaBloque {

    private FabricaBloque() {}

    public static Bloque construirBloque(String hashPrevio, String hashRoot, List<Transaccion> transacciones, Long bloqueAnterior) {

        Header header = new Header(hashPrevio, null, null, hashRoot);
        Body body = new Body(transacciones);

        return new Bloque(null, header, body, bloqueAnterior);
    }

}