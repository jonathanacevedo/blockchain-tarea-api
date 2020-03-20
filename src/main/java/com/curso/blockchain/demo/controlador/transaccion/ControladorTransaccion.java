package com.curso.blockchain.demo.controlador.transaccion;

import com.curso.blockchain.demo.modelo.blockchain.Transaccion;
import com.curso.blockchain.demo.servicio.transaccion.ServicioCrearTransaccion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaccion")
@Api(tags = "Controlador Transacción")
public class ControladorTransaccion {

    private final ServicioCrearTransaccion servicioCrearTransaccion;

    public ControladorTransaccion(ServicioCrearTransaccion servicioCrearTransaccion) {
        this.servicioCrearTransaccion = servicioCrearTransaccion;
    }

    @PostMapping
    @ApiOperation("Crear Transacción")
    public String crearTransaccion(@RequestBody Transaccion transaccion) {
        return this.servicioCrearTransaccion.ejecutar(transaccion);
    }
}
