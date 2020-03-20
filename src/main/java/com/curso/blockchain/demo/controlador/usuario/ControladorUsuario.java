package com.curso.blockchain.demo.controlador.usuario;

import com.curso.blockchain.demo.modelo.usuario.Usuario;
import com.curso.blockchain.demo.modelo.usuario.dto.DtoUsuario;
import com.curso.blockchain.demo.servicio.usuario.ServicioCrearUsuario;
import com.curso.blockchain.demo.servicio.usuario.ServicioListarUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Controlador Usuario")
public class ControladorUsuario {

    @Autowired
    private ServicioCrearUsuario servicioCrearUsuario;

    @Autowired
    private ServicioListarUsuario servicioListarUsuario;

    @PostMapping
    @ApiOperation("Creación de Usuarios")
    public String obtenerUsuarios(@RequestBody Usuario usuario) {
        return servicioCrearUsuario.ejecutar(usuario);
    }

    @GetMapping
    @ApiOperation("Listado de Usuarios Registrados")
    public List<DtoUsuario> listarUsuarios() {
        return this.servicioListarUsuario.ejecutar();
    }
}
