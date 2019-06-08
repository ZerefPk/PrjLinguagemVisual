/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Categoria;
import bean.Diretor;
import bean.Filme;
import bean.Sala;
import bean.Sessao;
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
public class SessaoDAO {
    private Connection conn;

    public SessaoDAO() throws SQLException {
        conn = ConexaoFactory.getConnection();
    }
    
    public List <Sessao> show(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sessao> sessoes = new ArrayList<>();
        
        String sql = "SELECT SE.id_sessao, SA.numero_sala, SA.tipo_sala,"
                + " SE.data_sessao, SE.hora_sessao, F.titulo_filme, F.ano_lancamento, "
                + "C.nome_categoria, D.nom_diretor "
                + " FROM tb_sessao SE "
                + "INNER JOIN tb_sala SA ON SA.id_sala = SE.sala_id_sala "
                + " INNER JOIN tb_filme F ON F.id_filme = SE.filme_id_filme "
                + "INNER JOIN tb_categoria C ON C.id_categoria = F.cod_categoria "
                + "INNER JOIN tb_diretor D ON D.id_diretor = F.cod_diretor; ";
       
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala(rs.getString("numero_sala"), rs.getString("tipo_sala"));
                Diretor diretor = new Diretor();
                diretor.setNomeDiretor(rs.getString("nom_diretor"));
                Categoria categoria = new Categoria();
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                
                Filme filme = new Filme();
                filme.setNomeFilme(rs.getString("titulo_filme"));
                filme.setCategoria(categoria);
                filme.setDireitor(diretor);
                Sessao temp = new Sessao(rs.getInt("id_sessao"), 
                        filme, sala, rs.getString("data_sessao"), rs.getString("hora_sessao"));
                sessoes.add(temp);
            }
        } catch (SQLException ex) {
            System.err.println("erro cod: "+ex);
        }
        
        return sessoes;
        
    }
    public boolean insert(Sessao sessao){
    
        PreparedStatement stmt = null;
        String sql = "INSERT INTO tb_sessao VALUES(DEFAULT, ?,?,?,?)";
        int r = 0;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(2, sessao.getCodFilme().getId());
            stmt.setInt(1, sessao.getCodsala().getId());
            stmt.setString(3, sessao.getDataSessao());
            stmt.setString(4, sessao.getHoraSessao());
            
            r = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro cod: "+e);
        }
        return r>0;
    }
    public List <Sessao> showBusca(Sala busca){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sessao> sessoes = new ArrayList<>();
        
        String sql = "SELECT SE.id_sessao, SA.numero_sala, SA.tipo_sala,"
                + " SE.data_sessao, SE.hora_sessao, F.titulo_filme, F.ano_lancamento, "
                + "C.nome_categoria, D.nom_diretor "
                + " FROM tb_sessao SE "
                + "INNER JOIN tb_sala SA ON SA.id_sala = SE.sala_id_sala "
                + " INNER JOIN tb_filme F ON F.id_filme = SE.filme_id_filme "
                + "INNER JOIN tb_categoria C ON C.id_categoria = F.cod_categoria "
                + "INNER JOIN tb_diretor D ON D.id_diretor = F.cod_diretor"
                + " WHERE SA.id_sala = ?; ";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, busca.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala(rs.getString("numero_sala"), rs.getString("tipo_sala"));
                Diretor diretor = new Diretor();
                diretor.setNomeDiretor(rs.getString("nom_diretor"));
                Categoria categoria = new Categoria();
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                
                Filme filme = new Filme();
                filme.setNomeFilme(rs.getString("titulo_filme"));
                filme.setCategoria(categoria);
                filme.setDireitor(diretor);
                Sessao temp = new Sessao(rs.getInt("id_sessao"), 
                        filme, sala, rs.getString("data_sessao"), rs.getString("hora_sessao"));
                sessoes.add(temp);
            }
        } catch (SQLException ex) {
            System.err.println("erro cod: "+ex);
        }
        
        return sessoes;
        
    }
    
    
}
