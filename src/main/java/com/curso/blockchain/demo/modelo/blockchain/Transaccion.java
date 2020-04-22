package com.curso.blockchain.demo.modelo.blockchain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Transaccion {
    private String origen;
    private String destino;
    private Date fecha;
    private Long valor;
}
