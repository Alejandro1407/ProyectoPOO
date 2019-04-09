/*
Victor Alejandro Alejo Galvez AG181471
Matthew Emilio Gaitan Ramos GR180499
Dennis Enrique Cruz Inestrosa CI180440
Marco Antonio Hernandez Hernandez HH182006
Javier Ernesto Perez Pablo PP180605
*/
package GUI.JefeDesarrollo;

import Datos.Conexion;
import GUI.JefeArea.*;
import GUI.Administrador.*;
import GUI.JefeArea.Solicitudes;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JOptionPane;
import GUI.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;

public class JefeDesarrolloMain extends javax.swing.JFrame {

    private int idDepartamento;
    private int idEmpleado;
    private String NombreDepartamento;
    private String NombreUser;
    private boolean HaveToChangePass;
    
    public JefeDesarrolloMain() {
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
        txtDepartamento = new javax.swing.JLabel();
        btnSolicitudes = new javax.swing.JButton();
        txtNombre = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        btnCasos = new javax.swing.JButton();
        btnContraseña3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setName("AdministradorMain"); // NOI18N
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(160, 160, 160));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDepartamento.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtDepartamento.setText("Administración");
        jPanel1.add(txtDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        btnSolicitudes.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnSolicitudes.setForeground(new java.awt.Color(238, 112, 82));
        btnSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8-add-list-filled-35.png"))); // NOI18N
        btnSolicitudes.setText("Ver Solicitudes");
        btnSolicitudes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSolicitudes.setContentAreaFilled(false);
        btnSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudesActionPerformed(evt);
            }
        });
        jPanel1.add(btnSolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 190, 81));

        txtNombre.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        txtNombre.setText("Alejandro Alejo");
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

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

        btnCasos.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnCasos.setForeground(new java.awt.Color(238, 112, 82));
        btnCasos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Casos.png"))); // NOI18N
        btnCasos.setText("Ver Casos");
        btnCasos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCasos.setContentAreaFilled(false);
        btnCasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasosActionPerformed(evt);
            }
        });
        jPanel1.add(btnCasos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 200, 81));

        btnContraseña3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnContraseña3.setForeground(new java.awt.Color(238, 112, 82));
        btnContraseña3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Key_32px.png"))); // NOI18N
        btnContraseña3.setText("Cambiar Contraseña");
        btnContraseña3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnContraseña3.setContentAreaFilled(false);
        btnContraseña3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContraseña3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnContraseña3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 230, 81));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudesActionPerformed
       GestionSolicitudes e = new GestionSolicitudes();
       e.setidDepartamento(getidDepartamento());
       e.setVisible(true);
    }//GEN-LAST:event_btnSolicitudesActionPerformed

    private void makevisible(){
        this.setVisible(true);
    }
    
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       txtNombre.setText(this.NombreUser);
        System.out.println(idEmpleado);
       txtDepartamento.setText(NombreDepartamento);
       if(HaveToChangePass){
           ChangePass();
       }
      
    }//GEN-LAST:event_formWindowOpened

    private void btnCasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasosActionPerformed
        GestionCasos c = new GestionCasos();
        c.setidDepartamento(idDepartamento);
        c.setVisible(true);
    }//GEN-LAST:event_btnCasosActionPerformed

    private void btnContraseña3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContraseña3ActionPerformed
        ChangePass();
    }//GEN-LAST:event_btnContraseña3ActionPerformed

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
            System.out.println(idEmpleado+" " + newPass);
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCasos;
    private javax.swing.JButton btnContraseña;
    private javax.swing.JButton btnContraseña1;
    private javax.swing.JButton btnContraseña3;
    private javax.swing.JButton btnSolicitudes;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txtDepartamento;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables
}
