package com.datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3308/tienda?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    
    
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement smtn) throws SQLException{
        smtn.close(); 
    }
    
    public static void close(PreparedStatement smtn) throws SQLException{
        smtn.close(); 
    }
    
    public static void close(Connection con) throws SQLException{
        con.close(); 
    }
}