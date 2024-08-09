package dao;

import java.sql.*;

public class ConexaoBD {
    private static final String URL_POSTGRES = 
            "jdbc:postgresql://localhost:5432/agenda";
    
    private static final String DRIVER_CLASS = 
            "org.postgresql.Driver";
    
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
//    private static final String PASS = "senac";
    
    public static Connection getConnection(){
        System.out.println("Conectando com o postgreSQL");
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(URL_POSTGRES, USER, PASS);
        } catch (SQLException e){
            e.getMessage();
        } catch(ClassNotFoundException e){
            e.getMessage();
        }
        return null;
    }
}
