package com.curso.blockchain.demo.modelo.blockchain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Header {
    private String hashPrevio;
    private String hashPropio;
    private Long nonce;
    private String hashRoot;

    @Override
    public String toString() {
        return "Header{" +
                "hashPrevio='" + hashPrevio + '\'' +
                ", hashPropio='" + hashPropio + '\'' +
                ", nonce=" + nonce +
                ", hashRoot='" + hashRoot + '\'' +
                '}';
    }
}
