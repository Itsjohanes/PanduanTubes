/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.johanes.sihape.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class ConnectionDB {
    // Menyiapkan paramter JDBC untuk koneksi ke database
    static String DB="jdbc:mysql://localhost/si_tokohp"; // si_tokohp database
    static String user="root"; // user database
    static String pass=""; // password database
    private static Connection con;

    public static Connection getConnection() throws SQLException {
        if(con==null){
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                con = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (Exception e) {
                System.out.println("Database connection is failed");
            }
        }

       return con;
    }
    
}
