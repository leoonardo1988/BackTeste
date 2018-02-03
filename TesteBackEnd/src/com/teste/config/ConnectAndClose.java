
package com.teste.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectAndClose {

    /**
     * Metodo de conexão
     * @return 
     */
    public static Connection connection() throws SQLException, ClassNotFoundException {
       
        Connection connection = null;
                
         if (connection == null || connection.isClosed()) {


            String dbURL = "jdbc:mysql://localhost:3306/teste_backend";

            Properties properties = new Properties();
            properties.put("user", "root");
            properties.put("password", "");

            connection = DriverManager.getConnection(dbURL, properties);
            
        }

        return connection;
      
    }
    
    /**
     * Metodo que fecha conexões
     * @param conn
     * @param stmt
     * @param rs 
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn!= null) {
                conn.close();
            }
            if (stmt!= null) {
                stmt.close();
            }
            if (rs!= null) {
                rs.close();
            }
        } catch (SQLException e) {
        }
    }
   
}
