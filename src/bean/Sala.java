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
public class Sala {
    private int id;
    private String numeroSala;
    private String tipoSala; 

    public Sala(String numeroSala, String tipoSala) {
       
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
    }
    public Sala(int id, String numeroSala, String tipoSala) {
        this.id = id;
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }
    @Override
    public String toString(){
        return getNumeroSala();
    }
    
    
}
