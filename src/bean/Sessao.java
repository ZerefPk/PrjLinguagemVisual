/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;



/**
 *
 * @author ezequ
 */
public class Sessao {
    
    private int id;
    private Filme codFilme;
    private Sala codsala;
    private String dataSessao;
    private String horaSessao;

    public Sessao() {
    }

    public Sessao(Filme codFilme, Sala codsala, String dataSessao, String horaSessao) {
        this.codFilme = codFilme;
        this.codsala = codsala;
        this.dataSessao = dataSessao;
        this.horaSessao = horaSessao;
    }

    public Sessao(int id, Filme codFilme, Sala codsala, String dataSessao, String horaSessao) {
        this.id = id;
        this.codFilme = codFilme;
        this.codsala = codsala;
        this.dataSessao = dataSessao;
        this.horaSessao = horaSessao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getCodFilme() {
        return codFilme;
    }

    public void setCodFilme(Filme codFilme) {
        this.codFilme = codFilme;
    }

    public Sala getCodsala() {
        return codsala;
    }

    public void setCodsala(Sala codsala) {
        this.codsala = codsala;
    }

    public String getDataSessao() {
        return dataSessao;
    }

    public void setDataSessao(String dataSessao) {
        this.dataSessao = dataSessao;
    }

    public String getHoraSessao() {
        return horaSessao;
    }

    public void setHoraSessao(String horaSessao) {
        this.horaSessao = horaSessao;
    }
    
   
}
