package com.curso.blockchain.demo.configuracion;

import com.curso.blockchain.demo.repositorio.RepositorioUsuario;
import com.curso.blockchain.demo.servicio.ServicioListarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioListarUsuario servicioListarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioListarUsuario(repositorioUsuario);
    }

}