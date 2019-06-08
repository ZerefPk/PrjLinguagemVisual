/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Sessao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ezequ
 */
public class Test {
    public static void main(String[] args) {
        SessaoDAO s;
        
        try {
            s = new SessaoDAO();
            s.show().stream().forEach((Sessao c)->{
            
                System.out.println(c.getCodFilme().getNomeFilme());
             });
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
