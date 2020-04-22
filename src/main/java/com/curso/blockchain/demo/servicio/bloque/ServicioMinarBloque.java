package com.curso.blockchain.demo.servicio.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.repositorio.bloque.RepositorioBloque;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ServicioMinarBloque {

    private static final String MINADO_EXITOSO = "El bloque ha sido minado exitosamente.";

    private final RepositorioBloque repositorioBloque;
    private final ServicioCrearBloqueGenesis servicioCrearBloqueGenesis;

    public ServicioMinarBloque(RepositorioBloque repositorioBloque, ServicioCrearBloqueGenesis servicioCrearBloqueGenesis) {
        this.repositorioBloque = repositorioBloque;
        this.servicioCrearBloqueGenesis = servicioCrearBloqueGenesis;
    }


    private String agregarACadena(String llavePublica) {
        int numeroBloques = this.repositorioBloque.obtenerNumeroBloques();
        if(numeroBloques == 0) {
            this.servicioCrearBloqueGenesis.ejecutar();
        } else {
            Bloque bloqueAMinar = this.repositorioBloque.obtenerBloqueAMinar();
            String hashBloqueGenesis = ServicioRealizarPruebaTrabajo.obtenerHash(bloqueAMinar);
            bloqueAMinar.getHeader().setHashPropio(hashBloqueGenesis);

            this.repositorioBloque.actualizarBloque(bloqueAMinar);
        }
        return MINADO_EXITOSO;
    }

    public String ejecutar(String llavePublica) {
        return agregarACadena(llavePublica);
    }
}
