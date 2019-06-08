/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.ConexaoFactory;

/**
 *
 * @author ezequ
 */
public class UserDAO {
    private Connection conn = null;
    
    
    public UserDAO() throws SQLException{
        
        conn = ConexaoFactory.getConnection();
    
    }
    
    public boolean login( String email, String senha){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int cont = 0;
        String $sql = "SELECT id_user_auth FROM tb_user_auth "
                + "WHERE nickname = ? AND senha = ?;";
    
        try {
            stmt = conn.prepareStatement($sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            rs.next();
            cont = rs.getRow();
            
            
        } catch (SQLException ex) {
            System.err.println("erro codigo: "+ex);
            
        }finally{
            ConexaoFactory.closeConnection(conn, stmt, rs);
        
        }
        return cont > 0;
        
    }
    
}
