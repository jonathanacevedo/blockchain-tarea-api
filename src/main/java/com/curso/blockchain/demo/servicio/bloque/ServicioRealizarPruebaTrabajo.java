package com.curso.blockchain.demo.servicio.bloque;

import com.curso.blockchain.demo.modelo.blockchain.Bloque;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.Random;
import java.util.logging.Logger;

public class ServicioRealizarPruebaTrabajo {

    private static final int NUMERO_DE_CEROS = 3;
    private static final String NUMERO_DE_CEROS_BUSCADOS = "000";
    private static Logger log = Logger.getLogger("LoggerTarea");


    private ServicioRealizarPruebaTrabajo(){}

    public static String obtenerHash(Bloque bloque) {


        Long nonce;
        Random rand = new Random();
        String bloqueHash;

        while (true) {
            nonce = rand.nextLong();
            bloque.getHeader().setNonce(nonce);
            String sha256hex = DigestUtils.sha256Hex(bloque.toString());

            log.info(sha256hex);

            if (sha256hex.substring(0, NUMERO_DE_CEROS).equals(NUMERO_DE_CEROS_BUSCADOS)) {
                bloqueHash = sha256hex;
                break;
            }
        }

        return bloqueHash;
    }
}
