package com.curso.blockchain.demo.modelo.blockchain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Transaccion {
    private String origen;
    private String destino;
    private Date fecha;
    private Long valor;
}
