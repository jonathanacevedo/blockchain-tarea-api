package com.curso.blockchain.demo.servicio.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Transaccion;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

public class ServicioObtenerHashRoot {

    public ServicioObtenerHashRoot() {}

    public String ejecutar(List<Transaccion> listaTransacciones) {

        return DigestUtils.sha256Hex(listaTransacciones.toString());
    }
}
