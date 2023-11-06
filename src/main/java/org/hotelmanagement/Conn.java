package org.hotelmanagement;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection con;
    Statement st;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root","*****" );
            st = con.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//
//    }
}
