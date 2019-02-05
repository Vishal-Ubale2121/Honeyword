/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author akshay
 */
public class Database {
    public Connection con = null;

    public Database() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");

        } catch (ClassNotFoundException e) {
            System.out.println("Connection Error :" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection Error :" + e.getMessage());
        }
    }

}
