/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Categoria;
import bean.Diretor;
import bean.Filme;
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
public class FilmeDAO {
    private Connection conn;
    
    public FilmeDAO() throws SQLException{
        conn = ConexaoFactory.getConnection();
    }
    
    public int insert(Filme filme){
        PreparedStatement stmt = null;
        int r = 0;
        String sql = "INSERT INTO tb_filme VALUES(DEFAULT, ?,?,?,?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, filme.getNomeFilme());
            stmt.setString(2,filme.getAnoLancamento());
            stmt.setInt(3, filme.getDireitor().getId());
            stmt.setInt(4, filme.getCategoria().getId());
            r = stmt.executeUpdate();
                    
                    
        } catch (SQLException ex) {
            System.err.println("erro codigo: "+ex);
        }finally{
            ConexaoFactory.closeConnection(conn, stmt);
        }
        
        return r;
        
        
    }
    public List <Filme> showFilmes(){
        
        List <Filme> filmes = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String sql = "SELECT F.id_filme, F.titulo_filme,"
                + "F.ano_lancamento, C.id_categoria, C.nome_categoria, "
                + "D.id_diretor, D.nom_diretor FROM tb_filme F "
                + "INNER JOIN tb_categoria C ON C.id_categoria = F.cod_categoria " 
                + "INNER JOIN tb_diretor D ON D.id_diretor = F.cod_diretor; ";
        
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while( rs.next()){
                Diretor diretor = new Diretor(rs.getInt("id_diretor"),rs.getString("nom_diretor"));
                Categoria categoria = new Categoria(rs.getInt("id_categoria"), rs.getString("nome_categoria"));
                
                Filme filme;
                filme = new Filme(rs.getString("titulo_filme"), categoria, diretor,rs.getString("ano_lancamento"),
                rs.getInt("id_filme"));
                
                filmes.add(filme);
                
                
            }
        } catch (SQLException ex) {
            System.err.println("erro codigo: "+ex);
        }finally{
            ConexaoFactory.closeConnection(conn, stmt, rs);
        }
        
        return filmes;
                
    }
    public List <Filme> showFilmesBusca(String chave){
        List <Filme> filmes = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String sql = "SELECT F.id_filme, F.titulo_filme,"
                + "F.ano_lancamento, C.id_categoria, C.nome_categoria, "
                + "D.id_diretor, D.nom_diretor FROM tb_filme F "
                + "INNER JOIN tb_categoria C ON C.id_categoria = F.cod_categoria " 
                + "INNER JOIN tb_diretor D ON D.id_diretor = F.cod_diretor"
                + " WHERE F.titulo_filme LIKE ?; ";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, '%'+chave+'%');
            rs = stmt.executeQuery();
            while( rs.next()){
                Diretor diretor = new Diretor(rs.getInt("id_diretor"),rs.getString("nom_diretor"));
                Categoria categoria = new Categoria(rs.getInt("id_categoria"), rs.getString("nome_categoria"));
                
                Filme filme;
                filme = new Filme(rs.getString("titulo_filme"), categoria, diretor,rs.getString("ano_lancamento"),
                rs.getInt("id_filme"));
                
                filmes.add(filme);
                
                
            }
        } catch (SQLException ex) {
            System.err.println("erro codigo: "+ex);
        }finally{
            ConexaoFactory.closeConnection(conn, stmt, rs);
        }
        
        return filmes;
    
    }
    public List <Filme> showFilmesBusca(int chave){
        List <Filme> filmes = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String sql = "SELECT F.id_filme, F.titulo_filme,"
                + "F.ano_lancamento, C.id_categoria, C.nome_categoria, "
                + "D.id_diretor, D.nom_diretor FROM tb_filme F "
                + "INNER JOIN tb_categoria C ON C.id_categoria = F.cod_categoria " 
                + "INNER JOIN tb_diretor D ON D.id_diretor = F.cod_diretor"
                + " WHERE F.cod_categoria =  ?; ";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, chave);
            rs = stmt.executeQuery();
            while( rs.next()){
                Diretor diretor = new Diretor(rs.getInt("id_diretor"),rs.getString("nom_diretor"));
                Categoria categoria = new Categoria(rs.getInt("id_categoria"), rs.getString("nome_categoria"));
                
                Filme filme;
                filme = new Filme(rs.getString("titulo_filme"), categoria, diretor,rs.getString("ano_lancamento"),
                rs.getInt("id_filme"));
                
                filmes.add(filme);
                
                
            }
        } catch (SQLException ex) {
            System.err.println("erro codigo: "+ex);
        }finally{
            ConexaoFactory.closeConnection(conn, stmt, rs);
        }
        
        return filmes;
    
    }
}
