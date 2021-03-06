/*
Victor Alejandro Alejo Galvez AG181471
Matthew Emilio Gaitan Ramos GR180499
Dennis Enrique Cruz Inestrosa CI180440
Marco Antonio Hernandez Hernandez HH182006
Javier Ernesto Perez Pablo PP180605
*/
package GUI.Administrador;

import Datos.Conexion;
import GUI.JefeArea.Solicitudes;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JOptionPane;
import GUI.*;
import java.sql.*;

public class AdministradorMain extends javax.swing.JFrame {
    
    private int idDepartamento;
    private int idEmpleado;
    private String NombreDepartamento;
    private String NombreUser;
    private boolean HaveToChangePass;
    
    public AdministradorMain() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void setidEmpleado(int id){
        this.idEmpleado = id;
    }
    public void setidDepartament(int idDepartamento){
           this.idDepartamento = idDepartamento;
    }
    public void setNombreDepartamento(String NombreDepartamento){
        this.NombreDepartamento = NombreDepartamento;
    }
    public void setNombreUser(String NombreUser){
        this.NombreUser =  NombreUser;
    }
    private int getidDepartamento(){
        return this.idDepartamento;
    }
    public void setHaveToChangePass(boolean haveto){
        this.HaveToChangePass = haveto;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtDepartamento = new javax.swing.JLabel();
        btnEmpleados = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtNombre = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        btnContraseña = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setName("AdministradorMain"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(238, 112, 82));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Departamento.png"))); // NOI18N
        jButton1.setText("Departamentos");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 190, 82));

        txtDepartamento.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtDepartamento.setText("Administración");
        jPanel1.add(txtDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        btnEmpleados.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(238, 112, 82));
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Empleados.png"))); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEmpleados.setContentAreaFilled(false);
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 180, 81));

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(238, 112, 82));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Roles.png"))); // NOI18N
        jButton3.setText("Roles");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 190, 81));

        txtNombre.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        txtNombre.setText("Alejandro Alejo");
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 30, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Multiply_32px.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 30, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 630, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8-exit-32.png"))); // NOI18N
        jLabel6.setText("Cerrar sesion");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        btnContraseña.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnContraseña.setForeground(new java.awt.Color(238, 112, 82));
        btnContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Key_32px.png"))); // NOI18N
        btnContraseña.setText("Cambiar Contraseña");
        btnContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnContraseña.setContentAreaFilled(false);
        btnContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(btnContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 81));

        btnReportes.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(238, 112, 82));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/reportes.png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnReportes.setContentAreaFilled(false);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel1.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 190, 81));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
       MantenimientoEmpleado e = new MantenimientoEmpleado();
       e.setVisible(true);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

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
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MantenimientoRoles MR = new MantenimientoRoles();
        MR.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtNombre.setText(this.NombreUser);
       txtDepartamento.setText(NombreDepartamento);
       if(HaveToChangePass){
           ChangePass();
       }
    }//GEN-LAST:event_formWindowOpened

    private void btnContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContraseñaActionPerformed
        ChangePass();
    }//GEN-LAST:event_btnContraseñaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Mantenimientodepartamentos MD = new Mantenimientodepartamentos();
        MD.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
       Reportes R =new  Reportes();
       R.setVisible(true);
    }//GEN-LAST:event_btnReportesActionPerformed
    private void ChangePass(){
        String newPass = JOptionPane.showInputDialog(this,"Ingrese nueva contraseña");
        if(newPass == null){
            if(HaveToChangePass){
                JOptionPane.showMessageDialog(this,"Decidio no actulizar su contraseña\nSe le preguntara el siguiente Login");
            }
          return;
        }
         if(newPass.equals("") || IsNumeric(newPass)){
             JOptionPane.showMessageDialog(this, "Contraseña no puede estar vacio o ser numerico");
             return;
         }
        try{
            Connection conn =  Conexion.Conectarse();
            if(conn == null){
                JOptionPane.showMessageDialog(this,"Fallo al conectarse");
                return;
            }
            CallableStatement proc = conn.prepareCall("{ call actualizar_contrasenia (?,?)}");
            proc.setInt(1, idEmpleado);
            proc.setString(2,newPass);
            proc.execute();
             JOptionPane.showMessageDialog(this,"Se actulizo la contraseña");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
     private boolean IsNumeric(String x){
        try{
            int y = Integer.parseInt(x);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
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
            java.util.logging.Logger.getLogger(AdministradorMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContraseña;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txtDepartamento;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables
}
