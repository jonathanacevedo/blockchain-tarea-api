package com.curso.blockchain.demo.modelo.blockchain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bloque {
    private Long id;
    private Header header;
    private Body body;
    private Long bloqueAnterior;

    @Override
    public String toString() {
        return "Bloque{" +
                "header=" + header +
                ", body=" + body +
                ", bloqueAnterior=" + bloqueAnterior +
                '}';
    }
}
