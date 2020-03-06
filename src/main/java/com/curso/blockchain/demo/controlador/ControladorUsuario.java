package com.curso.blockchain.demo.controlador;

import com.curso.blockchain.demo.servicio.ServicioListarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    @Autowired
    private ServicioListarUsuario servicioListarUsuario;

    @GetMapping
    public String obtenerUsuarios() {
        return servicioListarUsuario.ejecutar("Jonathansoski");
    }
}
