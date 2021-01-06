/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pousada;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Secundário
 */
public class AltMv extends javax.swing.JFrame {

    /**
     * Creates new form AddMv3
     */
    public AltMv() {
        initComponents();
        setLocationRelativeTo(null);
        URL url = this.getClass().getResource("logo-mobile.png"); 
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url); 
        this.setIconImage(iconeTitulo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabCli = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMv = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "codigo", "Conheceu Pousada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabCliMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabCli);
        if (tabCli.getColumnModel().getColumnCount() > 0) {
            tabCli.getColumnModel().getColumn(0).setResizable(false);
            tabCli.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setText("Texto:");

        txtMv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMvActionPerformed(evt);
            }
        });

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMv, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabCliMouseClicked
        String codigo = tabCli.getValueAt(tabCli.getSelectedRow(), 0).toString();
        System.out.println("código cliente: "+codigo);
        try {
            final String BANCO = "jdbc:mysql://localhost/pousada";
            final String USUARIO = "root";
            final String SENHA = "";

            Connection conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            PreparedStatement comando = conexao.prepareStatement("Select * from mot_viagem where cod_mv = ?");
            comando.setString(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado != null && resultado.next()) {
                txtMv.setText(resultado.getString("mot_viagem"));
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Verifique a conexão com o banco de dados."+ex, "Erro!!!", 2);
        }
    }//GEN-LAST:event_tabCliMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            final String BANCO = "jdbc:mysql://localhost/pousada";
            final String USUARIO = "root";
            final String SENHA = "";
       
            Connection conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            PreparedStatement comando = conexao.prepareStatement("Select * from mot_viagem order by cod_mv");
            ResultSet resultado = comando.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabCli.getModel();
            model.setNumRows(0);
            while (resultado.next()) {
                model.addRow(new Object[]{resultado.getString("cod_mv"), resultado.getString("mot_viagem"),});
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Verifique a conexão com o banco de dados.", "Erro!!!", 2);
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtMvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            final String BANCO = "jdbc:mysql://localhost/pousada";
            final String USUARIO = "root";
            final String SENHA = "";
       
            String codigo = tabCli.getValueAt(tabCli.getSelectedRow(), 0).toString();
            Connection conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            PreparedStatement comando = conexao.prepareStatement("update mot_viagem set mot_viagem=? where cod_mv =" + codigo);
            comando.setString(1, txtMv.getText());
            comando.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alteração efetuada!", "Ok", 1);
            txtMv.setText("");        
           
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Verifique a conexão com o banco de dados.", "Erro!!!", 2);
        }
        try {
            final String BANCO = "jdbc:mysql://localhost/pousada";
            final String USUARIO = "root";
            final String SENHA = "";
       
            Connection conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            PreparedStatement comando = conexao.prepareStatement("Select * from mot_viagem order by cod_mv");
            ResultSet resultado = comando.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabCli.getModel();
            model.setNumRows(0);
            while (resultado.next()) {
                model.addRow(new Object[]{resultado.getString("cod_mv"), resultado.getString("mot_viagem"),});
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Verifique a conexão com o banco de dados.", "Erro!!!", 2);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            final String BANCO = "jdbc:mysql://localhost/pousada";
            final String USUARIO = "root";
            final String SENHA = "";

            Connection conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            PreparedStatement comando = conexao.prepareStatement("delete from mot_viagem where cod_mv = ?");
            comando.setString(1, tabCli.getValueAt(tabCli.getSelectedRow(), 0).toString());
            comando.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão efetuada!", "Ok", 1);
            txtMv.setText("");

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Verifique a conexão com o banco de dados." + ex, "Erro!!!", 2);
        }
        try {
            final String BANCO = "jdbc:mysql://localhost/pousada";
            final String USUARIO = "root";
            final String SENHA = "";
       
            Connection conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            PreparedStatement comando = conexao.prepareStatement("Select * from mot_viagem order by cod_mv");
            ResultSet resultado = comando.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabCli.getModel();
            model.setNumRows(0);
            while (resultado.next()) {
                model.addRow(new Object[]{resultado.getString("cod_mv"), resultado.getString("mot_viagem"),});
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Verifique a conexão com o banco de dados.", "Erro!!!", 2);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AltMv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltMv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltMv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltMv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltMv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabCli;
    private javax.swing.JTextField txtMv;
    // End of variables declaration//GEN-END:variables
}
