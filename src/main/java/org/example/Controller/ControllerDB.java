package org.example.Controller;

import org.example.DB.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControllerDB {
    private ConnectDB connectDB = new ConnectDB();
    private Connection con = connectDB.getConnection();

    public Connection connectDB(){
        try{
            con = DriverManager.getConnection(connectDB.getJdbc(),connectDB.getUser(),connectDB.getPassword());
            System.out.println("Connected to database");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }

        return con;
    }
    public void closeDB(){
        try{
            con.close();
            System.out.println("Disconnected from database");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
