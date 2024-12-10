package org.example.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerCustomer {

    public ResultSet getClientInactivos(Connection con) {
        String query = "SELECT * FROM customer WHERE active = 0";
        ResultSet rs = null;
        Statement stm;

        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            System.out.println("Clientes inactivos:");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return rs;
    }

    public void showClientInactivos(ResultSet rs) {
        try {
            System.out.printf("%-10s %-20s\n","ACTIVO", "NOMBRE");
            while (rs.next()) {
                boolean active = rs.getBoolean("active");
                String nombre = rs.getString("first_name") + " " + rs.getString("last_name") + "";
                System.out.printf("%-10s %-20s\n", active, nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public ResultSet getClientActivosTienda2Ascendente(Connection con){
        String query = "SELECT * From customer WHERE store_id = 2 ORDER BY first_name";
        ResultSet rs = null;
        Statement stm;

        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            System.out.println("Clientes activos de la tienda 2 ascendente:");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return rs;
    }
    public void showClientActivosTienda2Ascendente(ResultSet rs){
        try {
            System.out.printf("%-25s %-20s\n", "NOMBRE" , "TIENDA ID");
            while (rs.next()) {
                String nombre = rs.getString("first_name") + " " + rs.getString("last_name") + "";
                int store_id = rs.getInt("store_id");
                System.out.printf("%-25s %-20s\n", nombre, store_id);
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
