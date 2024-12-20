package org.example.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerFilm {

    public ResultSet getMovieOneHundred(Connection con){
        String query = "SELECT * FROM film WHERE length >= 100 AND replacement_cost BETWEEN 15 AND 20";
        Statement stm;
        ResultSet rs = null;

        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            System.out.println("Contenido de la tabla:");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return rs;
    }
    public void showMovieOneHundred(ResultSet rs){

        try{
            System.out.printf("%-10s %-20s\n","DURACION","COSTO DE REEMPLAZO");
            while (rs.next()){
                String duracion = rs.getString("length");
                double costoReemplazo = rs.getDouble("replacement_cost");
                System.out.printf("%-10s %-20s\n",duracion,costoReemplazo);
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public ResultSet getMovieContentFigh(Connection con){
        String query = "Select * from film Where title Like '%Fight%'";
        ResultSet rs = null;
        Statement stm;
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            System.out.println("Contenido de la tabla:");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return rs;
    }
    public void showMovieContentFigh(ResultSet rs){
        try{
            System.out.printf("%-25s %-20s\n","TITULO","DURACION");
            while (rs.next()){
                String titulo = rs.getString("title");
                int duracion = rs.getInt("length");
                System.out.printf("%-25s %-20s\n",titulo,duracion);
            }
        }catch (SQLException e){}
    }

}
