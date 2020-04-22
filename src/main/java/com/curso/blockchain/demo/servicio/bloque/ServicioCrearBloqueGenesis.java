package com.curso.blockchain.demo.servicio.bloque;

import com.curso.blockchain.demo.fabrica.FabricaBloque;
import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.modelo.blockchain.Transaccion;
import com.curso.blockchain.demo.repositorio.bloque.RepositorioBloque;
import com.curso.blockchain.demo.repositorio.transaccion.RepositorioTransaccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicioCrearBloqueGenesis {

    private final RepositorioBloque repositorioBloque;
    private final RepositorioTransaccion repositorioTransaccion;
    private final ServicioObtenerHashRoot servicioObtenerHashRoot;
    private static final String SE_HA_MINADO_CORRECTAMENTE = "Se ha minado exitosamente.";

    public ServicioCrearBloqueGenesis(RepositorioBloque repositorioBloque, RepositorioTransaccion repositorioTransaccion, ServicioObtenerHashRoot servicioObtenerHashRoot) {
        this.repositorioBloque = repositorioBloque;
        this.repositorioTransaccion = repositorioTransaccion;
        this.servicioObtenerHashRoot = servicioObtenerHashRoot;
    }


    public String ejecutar() {
        List<Transaccion> transacciones = new ArrayList<>();
        transacciones.add(new Transaccion("MINA", "Jonathan", new Date(), 10L));

        String hashRoot = servicioObtenerHashRoot.ejecutar(transacciones);

        Bloque bloqueGenesis = FabricaBloque.construirBloque(null, hashRoot, transacciones, null);

        String hashBloqueGenesis = ServicioRealizarPruebaTrabajo.obtenerHash(bloqueGenesis);

        bloqueGenesis.getHeader().setHashPropio(hashBloqueGenesis);

        Long idBloqueGenesis = this.repositorioBloque.guardarBloqueGenesis(bloqueGenesis);

        this.repositorioTransaccion.crearTransaccion(transacciones.get(0), idBloqueGenesis);

        return SE_HA_MINADO_CORRECTAMENTE;
    }
}
