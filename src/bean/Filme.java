/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.time.Year;

/**
 *
 * @author ezequ
 */
public class Filme {
    private int id;
    private String nomeFilme;
    private String anoLancamento;
    private Categoria categoria;
    private Diretor direitor;
    
    public Filme(){
    }
    public Filme(String nomeFilme, Categoria categoria, Diretor direitor, String anoLancamento, int id) {
        this.nomeFilme = nomeFilme;
        this.categoria = categoria;
        this.anoLancamento =  anoLancamento;
        this.direitor = direitor;
        this.id = id;
    }
    
    public Filme(String nomeFilme, Categoria categoria, Diretor direitor, String anoLancamento ) {
        this.nomeFilme = nomeFilme;
        this.categoria = categoria;
        this.anoLancamento =  anoLancamento;
        this.direitor = direitor;
     
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Diretor getDireitor() {
        return direitor;
    }

    public void setDireitor(Diretor direitor) {
        this.direitor = direitor;
    }
    
    @Override
    public String toString(){
        return getNomeFilme();
    }
     
    
    
            
}
