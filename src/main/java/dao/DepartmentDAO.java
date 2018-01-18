/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import entity.Department; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author St0rm
 */

public class DepartmentDAO {
    private Connection connection;
    public DepartmentDAO(){
        
    }
    public DepartmentDAO(Connection connection){
        this.connection = connection;
    }
    public Department Save(Department dep) throws SQLException{
        String sqlInsert = ""
                +"insert into departments(department_id, department_name, location_id)"
                +"values (nextval('departments_department_id_seq'),?,?)";
        PreparedStatement preparedstatement = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
        preparedstatement.setString(1, dep.getNama());
        preparedstatement.setInt(2, dep.getLocationID());
        preparedstatement.executeUpdate();
        ResultSet primaryKey = preparedstatement.getGeneratedKeys();
        if(primaryKey.next()){
            
        }
        preparedstatement.close();
        
}
