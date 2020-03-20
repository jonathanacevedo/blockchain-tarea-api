package com.curso.blockchain.demo.servicio.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.modelo.blockchain.Header;
import com.curso.blockchain.demo.repositorio.bloque.RepositorioBloque;

public class ServicioCrearBloqueNuevo {

    private final RepositorioBloque repositorioBloque;

    public ServicioCrearBloqueNuevo(RepositorioBloque repositorioBloque) {
        this.repositorioBloque = repositorioBloque;
    }

    public Long ejecutar() {

        Bloque bloqueAnterior = this.repositorioBloque.obtenerUltimoBloque();
        Header header = new Header(bloqueAnterior.getHeader().getHashPropio(), null, null, null);
        Bloque bloqueNuevo = new Bloque(null, header, null, bloqueAnterior.getId());

        return this.repositorioBloque.guardarBloque(bloqueNuevo);
    }
}
