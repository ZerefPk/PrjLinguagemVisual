/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Sala;
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
public class SalaDAO {
    private Connection conn;

    public SalaDAO() throws SQLException {
        this.conn = ConexaoFactory.getConnection();
    }
    
    public List <Sala> show(String tipo){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sala> salas = new ArrayList<>();
        String sql = "SELECT * FROM tb_sala WHERE tipo_sala = ?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipo);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Sala temp = new Sala(rs.getInt("id_sala"), rs.getString("numero_sala"), rs.getString("tipo_sala"));
                salas.add(temp);
            }
        } catch (SQLException ex) {
            System.err.println("Erro cod: "+ex);
        }finally{
            ConexaoFactory.closeConnection(conn, stmt, rs);
        }
    
        return salas;
    }
    
}
