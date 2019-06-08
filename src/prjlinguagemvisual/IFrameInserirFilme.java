/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjlinguagemvisual;

import bean.Categoria;
import bean.Diretor;
import bean.Filme;
import dao.CategoriaDAO;
import dao.DiretorDAO;
import dao.FilmeDAO;
import java.awt.Container;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author ezequ
 */
public class IFrameInserirFilme extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFrameInserirFilme
     */
    javax.swing.JDesktopPane pane;
    public IFrameInserirFilme(javax.swing.JDesktopPane pane) {
        initComponents();
        this.pane = pane;
        this.setFrameIcon(null);
        BasicInternalFrameUI f = (BasicInternalFrameUI) this.getUI();
        Container north = (Container) f.getNorthPane();
        north.remove (0);
        try {
            DiretorDAO diretores = new DiretorDAO();
            diretores.show().stream().forEach((Diretor d) -> {
                
                cbDiretor.addItem(d);
            });
        } catch (SQLException ex) {
            System.err.println("ERRO: "+ex);
        }
       try {
            CategoriaDAO categorias = new CategoriaDAO();
            categorias.show().stream().forEach((Categoria c) -> {
                cbCategoria.addItem(c);
            });
        } catch (SQLException ex) {
            System.err.println("ERRO: "+ex);
        }
    }
    public void sair(){
        if (txtLancamento.getText().length()>0 || txtTitulo.getText().length()>0) {
            int r = JOptionPane.showConfirmDialog(rootPane, "tem certeza que deseja sair?");
            if (r==0) {
                IFrameMenu menu = new IFrameMenu(pane);
                pane.add(menu);
                menu.setVisible(true);
                this.dispose();
            }
        }
        else{
            IFrameMenu menu = new IFrameMenu(pane);
            pane.add(menu);
            menu.setVisible(true);
            this.dispose();
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtLancamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbDiretor = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setEnabled(false);
        setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setText("Inserir Novo Filme");

        btnVoltar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel2.setText("Titulo:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setText("Lancamento:");

        txtTitulo.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtLancamento.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtLancamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("Categoria:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel5.setText("Diretor:");

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnVoltar)
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(0, 478, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLancamento))
                        .addGap(152, 152, 152))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addGap(29, 29, 29)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbDiretor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, 419, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtLancamento))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(135, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77))))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        sair();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        int c = cbCategoria.getSelectedIndex();
        int d = cbDiretor.getSelectedIndex();
        int r = 0;
        Filme filme;
        filme = new Filme(txtTitulo.getText(), cbCategoria.getItemAt(c), cbDiretor.getItemAt(d),
                txtLancamento.getText());
        FilmeDAO dao;
        if(txtTitulo.getText().trim().length()>0  && txtLancamento.getText().trim().length()>0 ){
            try {
                dao = new FilmeDAO();
                r = dao.insert(filme);
            
            
            } catch (SQLException ex) {
                System.err.println("Erro codigo: "+ex);
            }
            if (r>0) {
                txtLancamento.setText(null);
                txtTitulo.setText(null);
            
                int res = JOptionPane.showConfirmDialog(rootPane, "Filme Salvo\nDeseja Continuar?", "Messagem", 1);

              
                if (res==0) {
                    IFrameMenu menu = new IFrameMenu(pane);
                    pane.add(menu);
                    menu.setVisible(true);
                    this.dispose();
                }
        
        else{
            IFrameMenu menu = new IFrameMenu(pane);
            pane.add(menu);
            menu.setVisible(true);
            this.dispose();
        }
                
               
            } else {
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatorios!!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        sair();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<Categoria> cbCategoria;
    private javax.swing.JComboBox<Diretor> cbDiretor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtLancamento;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
