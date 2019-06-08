/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Diretor;
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
public class DiretorDAO {
    private Connection con = null;

    public DiretorDAO() throws SQLException {
        con = ConexaoFactory.getConnection();
    }
    
    public List <Diretor> show(){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Diretor> diretores =  new ArrayList<>();
        
        String sql = "SELECT "
                + "id_diretor, nom_diretor  "
                + "From tb_diretor ORDER BY nom_diretor";
                
                
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while( rs.next()){
                Diretor diretor = new Diretor();
                diretor.setId(rs.getInt("id_diretor"));
                diretor.setNomeDiretor(rs.getString("nom_diretor"));
                
                diretores.add(diretor);
            
            }
        } catch (SQLException ex) {
            System.err.println("ERRO: "+ex);
        }finally{
            ConexaoFactory.closeConnection(con, stmt, rs);
        
        }
        return diretores;
    }
}
