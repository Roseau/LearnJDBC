/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author St0rm
 */
public class AplikasiUtama {
    private final String url = "jdbc:postgresql://localhost:5432/hr";
    private final String user = "hr";
    private final String password = "hr";
    
    public Connection connect(){
        Connection conn = null;
            try {
                conn = DriverManager.getConnection(url,user,password);
                System.out.println("Berhasil Connect");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());;
            }
        return conn;
    }
    public static void main(String[] args) {
        AplikasiUtama ap = new AplikasiUtama();
        ap.connect();
    }
}
