/*
Victor Alejandro Alejo Galvez AG181471
Matthew Emilio Gaitan Ramos GR180499
Dennis Enrique Cruz Inestrosa CI180440
Marco Antonio Hernandez Hernandez HH182006
Javier Ernesto Perez Pablo PP180605
*/
package GUI.JefeArea;

import GUI.Administrador.AdministradorMain;
import javax.swing.JOptionPane;
import java.sql.*;
import Datos.Conexion;

public class Solicitudes extends javax.swing.JFrame {

    private int idDepartamento;
    
    public Solicitudes() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
        private boolean IsNumeric(String x){
        try{
            int y = Integer.parseInt(x);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
     public void setidDepartamento(int idDepartamento){
        this.idDepartamento = idDepartamento;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(238, 112, 82));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText(".::Crear solicitud::.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 230, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 30, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Multiply_32px.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 30, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 580, 20));

        txtNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setBorder(null);
        txtNombre.setName("txtNombre"); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 200, 20));

        jLabel3.setBackground(new java.awt.Color(238, 112, 82));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Descripcion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        txtDescripcion.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(153, 153, 153));
        txtDescripcion.setBorder(null);
        txtDescripcion.setName("txtNombre"); // NOI18N
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 190, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 200, 20));

        jLabel4.setBackground(new java.awt.Color(238, 112, 82));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 112, 82));
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setText("Enviar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 130, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8-reply-arrow-32.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setState(Solicitudes.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir del login?", "Exit", dialog);

        if(result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtNombre.getText().equals("") || IsNumeric(txtNombre.getText())){
            JOptionPane.showMessageDialog(null, "El nombre no puede quedar vacio");
            return;
        }
        if(txtDescripcion.getText().equals("") || IsNumeric(txtDescripcion.getText())){
            JOptionPane.showMessageDialog(null, "La descripcion no puede quedar vacia");
            return;
        }
        
        try{
            Connection con = Conexion.Conectarse();
            if(con == null){
                throw new Exception("No se pudo Conectar");
            }
            CallableStatement proc;
            proc = con.prepareCall("{call realizar_solicitud (?,?,?) }");
            proc.setString(1, txtNombre.getText());
            proc.setString(2, txtDescripcion.getText());
            proc.setInt(3, idDepartamento);
            ResultSet rs = proc.executeQuery();
            rs.next();
            System.out.println(rs.getString(1));
            JOptionPane.showMessageDialog(this,rs.getString(1));
            this.dispose();
        }
        catch(Exception e){     
            JOptionPane.showMessageDialog(this, e.getMessage());
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Solicitudes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
