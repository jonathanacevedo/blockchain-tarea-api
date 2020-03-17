package com.curso.blockchain.demo.servicio.usuario;

import com.curso.blockchain.demo.repositorio.usuario.RepositorioUsuario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServicioCrearUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public String ejecutar(String nombreUsuario, String claveUsuario) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String strDate = dateFormat.format(date);
        int idGenerado = this.repositorioUsuario.crearUsuario(nombreUsuario, claveUsuario);
        return idGenerado+strDate;
    }
}
