/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ezequ
 */
public class ConexaoFactory {
    private static final String DRIVER      = "com.mysql.jdbc.Driver";
    private static final String URL         = "jdbc:mysql://localhost:3306/db_cinema";
    private static final String USER        = "root";
    private static final String PASSWORD    = "";
    
    public static Connection getConnection() throws SQLException{
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao", ex);
        }
        
    
    }
    public static void closeConnection(Connection con){
        //Fechar conecao com banco
        
        //verificar se a conexao esta aberta
        if (con !=  null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar conexao: "+ex);
            }
            
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt){
        //Fechar Statement
        
        //verificar se Statement  esta aberta
        if (stmt !=  null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar Statement: "+ex);
            }
            
        }
        closeConnection(con);
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        //Fechar Result set
        
        //verificar se Result set  esta aberta
        if (rs !=  null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar Result Set: "+ex);
            }
            
        }
        closeConnection(con, stmt);
    }
    
}
