package com.curso.blockchain.demo.configuracion;

import com.curso.blockchain.demo.repositorio.usuario.RepositorioUsuario;
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

}
