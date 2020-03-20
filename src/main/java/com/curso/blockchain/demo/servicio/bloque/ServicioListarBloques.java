package com.curso.blockchain.demo.servicio.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.modelo.blockchain.Body;
import com.curso.blockchain.demo.modelo.blockchain.Transaccion;
import com.curso.blockchain.demo.repositorio.bloque.RepositorioBloque;
import com.curso.blockchain.demo.repositorio.transaccion.RepositorioTransaccion;

import java.util.List;

public class ServicioListarBloques {

    private final RepositorioBloque repositorioBloque;
    private final RepositorioTransaccion repositorioTransaccion;

    public ServicioListarBloques(RepositorioBloque repositorioBloque, RepositorioTransaccion repositorioTransaccion) {
        this.repositorioBloque = repositorioBloque;
        this.repositorioTransaccion = repositorioTransaccion;
    }

    private void asignarTransacciones(List<Bloque> bloques) {
        for(Bloque bloque : bloques) {
            List<Transaccion> transacciones = this.repositorioTransaccion.listarTransacciones(bloque.getId());
            Body body = new Body(transacciones);
            bloque.setBody(body);
        }
    }

    public List<Bloque> ejecutar() {
        List<Bloque> bloques = this.repositorioBloque.obtenerBloques();
        asignarTransacciones(bloques);
        return bloques;
    }
}
