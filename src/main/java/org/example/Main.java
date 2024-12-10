package org.example;

import org.example.Controller.ControllerCustomer;
import org.example.Controller.ControllerDB;
import org.example.Controller.ControllerFilm;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ControllerDB controllerDB = new ControllerDB();
        ControllerFilm controllerFilm = new ControllerFilm();
        ControllerCustomer controllerCustomer = new ControllerCustomer();


        Connection con = controllerDB.connectDB();

        controllerFilm.showMovieOneHundred(controllerFilm.getMovieOneHundred(con));
        controllerCustomer.showClientInactivos(controllerCustomer.getClientInactivos(con));
        controllerCustomer.showClientActivosTienda2Ascendente(controllerCustomer.getClientActivosTienda2Ascendente(con));
        controllerFilm.showMovieContentFigh(controllerFilm.getMovieContentFigh(con));

        controllerDB.closeDB();
    }
}