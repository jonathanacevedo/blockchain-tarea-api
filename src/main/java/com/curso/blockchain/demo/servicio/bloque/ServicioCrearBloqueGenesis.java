package com.curso.blockchain.demo.servicio.bloque;

import com.curso.blockchain.demo.fabrica.FabricaBloque;
import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.modelo.blockchain.Transaccion;
import com.curso.blockchain.demo.repositorio.bloque.RepositorioBloque;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicioCrearBloqueGenesis {

    private final RepositorioBloque repositorioBloque;
    private static final String SE_HA_MINADO_CORRECTAMENTE = "Se ha minado exitosamente.";

    public ServicioCrearBloqueGenesis(RepositorioBloque repositorioBloque) {
        this.repositorioBloque = repositorioBloque;
    }


    public String ejecutar() {
        List<Transaccion> transacciones = new ArrayList<>();
        transacciones.add(new Transaccion("MINA", "GENESIS", new Date(), 10L));

        Bloque bloqueGenesis = FabricaBloque.construirBloque(null, "", transacciones, null);

        String hashBloqueGenesis = ServicioRealizarPruebaTrabajo.obtenerHash(bloqueGenesis);

        bloqueGenesis.getHeader().setHashPropio(hashBloqueGenesis);

        this.repositorioBloque.guardarBloque(bloqueGenesis);

        return SE_HA_MINADO_CORRECTAMENTE;
    }
}
