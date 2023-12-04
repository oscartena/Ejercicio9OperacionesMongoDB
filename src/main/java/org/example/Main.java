package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("org.mongodb.driver");

        Escuderia seat = new Escuderia("sea","seat","spanish","seat.com");
        Piloto sainz = new Piloto();
        sainz.setDriverid(0);

        OperacionesCRUDPilotos.crearPiloto(sainz);
        System.out.println(OperacionesCRUDPilotos.leerPiloto(8));

        List<Piloto> pilotos = OperacionesCRUDPilotos.leerPilotos();
        pilotos.forEach(piloto -> System.out.println(piloto));

        OperacionesCRUDPilotos.borrarPiloto(sainz);

        OperacionesCRUDPilotos.mostrarPilotosOrdenadosPorEdadDescendente();

        OperacionesCRUDPilotos.mostrarPilotosConEdadMayorQue(28);

    }
}