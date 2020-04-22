package com.curso.blockchain.demo.servicio.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.modelo.blockchain.Header;
import com.curso.blockchain.demo.modelo.blockchain.Transaccion;
import com.curso.blockchain.demo.repositorio.bloque.RepositorioBloque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ServicioCrearBloqueNuevo {

    private final RepositorioBloque repositorioBloque;
    private final ServicioObtenerHashRoot servicioObtenerHashRoot;

    public ServicioCrearBloqueNuevo(RepositorioBloque repositorioBloque, ServicioObtenerHashRoot servicioObtenerHashRoot) {
        this.repositorioBloque = repositorioBloque;
        this.servicioObtenerHashRoot = servicioObtenerHashRoot;
    }

    public Long ejecutar(Transaccion transaccion) {
        List<Transaccion> transacciones = new ArrayList<>(Arrays.asList(transaccion));
        String hashRoot = servicioObtenerHashRoot.ejecutar(transacciones);
        Bloque bloqueAnterior = this.repositorioBloque.obtenerUltimoBloque();
        Header header = new Header(bloqueAnterior.getHeader().getHashPropio(), null, null, hashRoot);
        Bloque bloqueNuevo = new Bloque(null, header, null, bloqueAnterior.getId());

        return this.repositorioBloque.guardarBloque(bloqueNuevo);
    }
}
