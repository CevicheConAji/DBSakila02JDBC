package org.example;

import org.example.Controller.ControllerDB;
import org.example.Controller.ControllerFilm;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ControllerDB controllerDB = new ControllerDB();
        ControllerFilm controllerFilm = new ControllerFilm();
        Connection con = controllerDB.connectDB();

        controllerFilm.showMovieOneHundred(controllerFilm.getMovieOneHundred(con));

        controllerDB.closeDB();
    }
}