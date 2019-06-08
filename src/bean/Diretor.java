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
public class Diretor {
    private int id;
    private String nomeDiretor;
    
    public Diretor(){
    
    }

    public Diretor(int id, String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    @Override
    public String toString() {
        return getNomeDiretor(); //To change body of generated methods, choose Tools | Templates.
    }
}
