/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConexaoFactory;

/**
 *
 * @author ezequ
 */
public class CategoriaDAO {

    private Connection conn = null;

    public CategoriaDAO() throws SQLException {
        conn = ConexaoFactory.getConnection();
    }
    
    public List <Categoria> show(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Categoria> categorias =  new ArrayList<>();
        
        String sql = "SELECT "
                + "id_categoria, nome_categoria "
                + "From tb_categoria ORDER BY nome_categoria";
                
                
 
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while( rs.next()){
                Categoria temp = new Categoria();
                temp.setId(rs.getInt("id_categoria"));
                temp.setNomeCategoria(rs.getString("nome_categoria"));
                
                categorias.add(temp);
            
            }
        } catch (SQLException ex) {
            System.err.println("ERRO: "+ex);
        }finally{
            ConexaoFactory.closeConnection(conn, stmt, rs);
        
        }
        return categorias;
    
    } 
    
}
