package main.java.br.edu.ifba.view;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCadastroEmpresa extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaCadastroEmpresa() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new main.java.br.edu.ifba.components.PainelArredondado();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeEmpresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmailEmpresa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        psfSenhaEmpresa = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        psfRepetirSenhaEmpresa = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtEnderecoEmpresa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnCadastrarEmpresa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        fTxtCnpj = new javax.swing.JFormattedTextField();
        fTxtTelefoneEmpresa = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cadastro de Empresa");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome de Usuário:");

        txtNomeEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        txtNomeEmpresa.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        txtNomeEmpresa.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Email:");

        txtEmailEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        txtEmailEmpresa.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        txtEmailEmpresa.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Senha:");

        psfSenhaEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        psfSenhaEmpresa.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        psfSenhaEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        psfSenhaEmpresa.setText("jPasswordField1");
        psfSenhaEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                psfSenhaEmpresaMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Repita a senha:");

        psfRepetirSenhaEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        psfRepetirSenhaEmpresa.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        psfRepetirSenhaEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        psfRepetirSenhaEmpresa.setText("jPasswordField2");
        psfRepetirSenhaEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                psfRepetirSenhaEmpresaMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Endereço");

        txtEnderecoEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        txtEnderecoEmpresa.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        txtEnderecoEmpresa.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Telefone");

        btnCadastrarEmpresa.setText("Cadastrar");

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("CNPJ");

        fTxtCnpj.setBackground(new java.awt.Color(255, 255, 255));
        try {
            fTxtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        fTxtTelefoneEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        try {
            fTxtTelefoneEmpresa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+## ### #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNomeEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(txtEnderecoEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(fTxtCnpj)
                    .addComponent(fTxtTelefoneEmpresa))
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtEmailEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psfRepetirSenhaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(psfSenhaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnCadastrarEmpresa))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(psfSenhaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(psfRepetirSenhaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fTxtTelefoneEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnderecoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarEmpresa)
                    .addComponent(fTxtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnCadastrarEmpresa() {
        return btnCadastrarEmpresa;
    }

    public JPasswordField getPsfRepetirSenhaEmpresa() {
        return psfRepetirSenhaEmpresa;
    }

    public JPasswordField getPsfSenhaEmpresa() {
        return psfSenhaEmpresa;
    }

    public JFormattedTextField getfTxtCnpj() {
        return fTxtCnpj;
    }

    public JTextField getTxtEmailEmpresa() {
        return txtEmailEmpresa;
    }

    public JTextField getTxtEnderecoEmpresa() {
        return txtEnderecoEmpresa;
    }

    public JTextField getTxtNomeEmpresa() {
        return txtNomeEmpresa;
    }

    public JFormattedTextField getfTxtTelefoneEmmpresa() {
        return fTxtTelefoneEmpresa;
    }
    
    
    private void psfSenhaEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psfSenhaEmpresaMouseClicked
        this.psfSenhaEmpresa.setText("");
    }//GEN-LAST:event_psfSenhaEmpresaMouseClicked

    private void psfRepetirSenhaEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psfRepetirSenhaEmpresaMouseClicked
        this.psfRepetirSenhaEmpresa.setText("");
    }//GEN-LAST:event_psfRepetirSenhaEmpresaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarEmpresa;
    private javax.swing.JFormattedTextField fTxtCnpj;
    private javax.swing.JFormattedTextField fTxtTelefoneEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField psfRepetirSenhaEmpresa;
    private javax.swing.JPasswordField psfSenhaEmpresa;
    private javax.swing.JTextField txtEmailEmpresa;
    private javax.swing.JTextField txtEnderecoEmpresa;
    private javax.swing.JTextField txtNomeEmpresa;
    // End of variables declaration//GEN-END:variables
}
