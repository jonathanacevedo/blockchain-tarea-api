package com.curso.blockchain.demo.configuracion;

import com.curso.blockchain.demo.repositorio.bloque.RepositorioBloque;
import com.curso.blockchain.demo.repositorio.transaccion.RepositorioTransaccion;
import com.curso.blockchain.demo.repositorio.usuario.RepositorioUsuario;
import com.curso.blockchain.demo.servicio.bloque.*;
import com.curso.blockchain.demo.servicio.transaccion.ServicioCrearTransaccion;
import com.curso.blockchain.demo.servicio.usuario.ServicioCrearUsuario;
import com.curso.blockchain.demo.servicio.usuario.ServicioListarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioListarUsuario servicioListarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioListarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearBloqueGenesis servicioCrearBloqueGenesis(RepositorioBloque repositorioBloque,
                                                                 RepositorioTransaccion repositorioTransaccion,
                                                                 ServicioObtenerHashRoot servicioObtenerHashRoot) {
        return new ServicioCrearBloqueGenesis(repositorioBloque, repositorioTransaccion, servicioObtenerHashRoot);
    }

    @Bean
    public ServicioCrearTransaccion servicioCrearTransaccion(RepositorioTransaccion repositorioTransaccion,
                                                             RepositorioBloque repositorioBloque,
                                                             ServicioCrearBloqueNuevo servicioCrearBloqueNuevo) {
        return new ServicioCrearTransaccion(repositorioTransaccion, repositorioBloque, servicioCrearBloqueNuevo);
    }

    @Bean
    public ServicioCrearBloqueNuevo servicioCrearBloqueNuevo(RepositorioBloque repositorioBloque, ServicioObtenerHashRoot servicioObtenerHashRoot) {
        return new ServicioCrearBloqueNuevo(repositorioBloque, servicioObtenerHashRoot);
    }

    @Bean
    public ServicioMinarBloque servicioMinarBloque(RepositorioBloque repositorioBloque, ServicioCrearBloqueGenesis servicioCrearBloqueGenesis) {
        return new ServicioMinarBloque(repositorioBloque, servicioCrearBloqueGenesis);
    }

    @Bean
    public ServicioListarBloques servicioListarBloques(RepositorioBloque repositorioBloque, RepositorioTransaccion repositorioTransaccion) {
        return new ServicioListarBloques(repositorioBloque, repositorioTransaccion);
    }

    @Bean
    public ServicioObtenerHashRoot servicioObtenerHashRoot() {
        return new ServicioObtenerHashRoot();
    }

}
