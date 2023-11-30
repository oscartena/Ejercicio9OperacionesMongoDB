package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;



public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("org.mongodb.driver");

        Escuderia seat = new Escuderia("sea","seat","spanish","seat.com");
        Piloto sainz = new Piloto();
        sainz.setDriverid(2);
        //OperacionesCRUDPilotos.crearPiloto(sainz);
        System.out.println(OperacionesCRUDPilotos.leerPiloto(2));

    }
}