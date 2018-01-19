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
import org.apache.commons.dbcp2.BasicDataSource;
import entity.Department;
import dao.DepartmentDAO;
import java.util.List;

/**
 *
 * @author St0rm
 */
public class AplikasiUtama {
//    private final String url = "jdbc:postgresql://localhost:5432/hr";
//    private final String user = "hr";
//    private final String password = "hr";
//    
//    public Connection connect(){
//        Connection conn = null;
//            try {
//                conn = DriverManager.getConnection(url,user,password);
//                System.out.println("Berhasil Connect");
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());;
//            }
//        return conn;
//    }
    public static void koneksi(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("hr");
        ds.setPassword("hr");
        ds.setUrl("jdbc:postgresql://localhost:5432/hr");
        ds.setDriverClassName("org.postgresql.Driver");

        Connection connection = null;
        try{
            // membuka koneksi ke database
            connection = ds.getConnection();
            connection.setAutoCommit(false);
            System.out.println("berhasil koneksi ke database");
            DepartmentDAO dao = new DepartmentDAO(connection);

            //save nilai department
            Department departmentBaru = dao.Save(new Department(null, "Sistem Analis", 1000, null));
            System.out.println(departmentBaru.toString());
      
            dao.Save(new Department(null, "Sistem Analis", 1000, null));
            
            dao.delete(3003);
            //untuk ambil nilainya
            List<Department> daftarDepartment = dao.findAll();
            for (Department d : daftarDepartment) {
                System.out.println(d.toString());
            }
            connection.commit();
            connection.close();
        }catch(SQLException sqle){
            System.err.printf("tidak dapat koneksi ke databas!");
            sqle.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        koneksi();
    }
}
