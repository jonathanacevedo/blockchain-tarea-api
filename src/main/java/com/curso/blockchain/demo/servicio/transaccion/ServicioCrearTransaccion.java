package com.curso.blockchain.demo.servicio.transaccion;

import com.curso.blockchain.demo.modelo.blockchain.Transaccion;
import com.curso.blockchain.demo.repositorio.bloque.RepositorioBloque;
import com.curso.blockchain.demo.repositorio.transaccion.RepositorioTransaccion;
import com.curso.blockchain.demo.servicio.bloque.ServicioCrearBloqueNuevo;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ServicioCrearTransaccion {

    private static final String TRANSACCION_EXITOSA = "Se ha creado la transacción exitosamente";

    private final RepositorioTransaccion repositorioTransaccion;
    private final RepositorioBloque repositorioBloque;
    private final ServicioCrearBloqueNuevo servicioCrearBloqueNuevo;

    public ServicioCrearTransaccion(RepositorioTransaccion repositorioTransaccion, RepositorioBloque repositorioBloque, ServicioCrearBloqueNuevo servicioCrearBloqueNuevo) {
        this.repositorioTransaccion = repositorioTransaccion;
        this.repositorioBloque = repositorioBloque;
        this.servicioCrearBloqueNuevo = servicioCrearBloqueNuevo;
    }

    private void validarTransaccionesBloque(Long idBloquePendiente, Transaccion transaccion) {
        int numeroTransacciones = this.repositorioBloque.obtenerNumeroTransaccionesBloque(idBloquePendiente);
        if(numeroTransacciones < 5) {
            if(numeroTransacciones == 4) {
                this.repositorioBloque.marcarBloqueLleno(idBloquePendiente);
            }
            this.repositorioTransaccion.crearTransaccion(transaccion, idBloquePendiente);
        } else {
            this.repositorioBloque.marcarBloqueLleno(idBloquePendiente);
            iniciarBloqueNuevo(transaccion);
        }
    }

    private Long iniciarBloqueNuevo(Transaccion transaccion) {
        Long idBloqueNuevo = servicioCrearBloqueNuevo.ejecutar(transaccion);
        this.repositorioTransaccion.crearTransaccion(transaccion, idBloqueNuevo);
        return idBloqueNuevo;
    }


    public String ejecutar(Transaccion transaccion) {
        Long idBloquePendiente = this.repositorioBloque.obtenerBloquePendiente();
        if(idBloquePendiente != null) {
            validarTransaccionesBloque(idBloquePendiente, transaccion);
        } else {
            iniciarBloqueNuevo(transaccion);
        }
        return TRANSACCION_EXITOSA;
    }

}
