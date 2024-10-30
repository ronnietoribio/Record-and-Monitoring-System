/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitoring_system;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class Database {
    
   public static Connection connectDB(){
   
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connect = DriverManager.getConnection("jdbc:mysql:///cas","root","");
           return connect;
       }catch(Exception e){e.printStackTrace();}
       
       return null;
   
   }
}
