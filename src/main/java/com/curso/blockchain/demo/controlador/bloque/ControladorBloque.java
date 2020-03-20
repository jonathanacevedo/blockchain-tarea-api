package com.curso.blockchain.demo.controlador.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import com.curso.blockchain.demo.servicio.bloque.ServicioListarBloques;
import com.curso.blockchain.demo.servicio.bloque.ServicioMinarBloque;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloque")
@Api(tags = "Controlador Bloque")
public class ControladorBloque {

    @Autowired
    private ServicioMinarBloque servicioMinarBloque;

    @Autowired
    private ServicioListarBloques servicioListarBloques;

    @PostMapping
    @ApiOperation("Minar Bloque")
    public String minarBloque(@RequestParam("llavePublica") String llavePublica) {
        return this.servicioMinarBloque.ejecutar(llavePublica);
    }

    @GetMapping
    @ApiOperation("Listar Cadena de Bloques")
    public List<Bloque> obtenerBloques() {
        return this.servicioListarBloques.ejecutar();
    }
}
