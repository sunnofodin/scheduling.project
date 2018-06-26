package andrewchristensonscheduling.model;

import java.sql.*;

// @author andrewchristenson

public class DBConnect {
    private static Connection conn;
    private Statement state;
    private ResultSet results;
    
    public DBConnect(){
        System.out.println("here");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U03tHU?"+ 
                    "user=U03tHU&password=53688079922");
            System.out.println("Success: You are now better at connecting databases..");
        } catch(Exception e){
            System.out.println("Error: You will get better at connecting databases.."+e);
    
        }
    
    }
    public static Connection getConnection(){
        return conn;
    }
}
