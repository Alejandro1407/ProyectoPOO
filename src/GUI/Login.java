package GUI;

import Datos.Conexion;
import GUI.Administrador.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
            AdministradorMain m = new AdministradorMain();
                      m.setVisible(true);
                     this.dispose();
                     /* Debug */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnelContenedor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(360, 450));
        setResizable(false);
        setSize(new java.awt.Dimension(360, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        PnelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("MS PGothic", 1, 24)); // NOI18N
        jLabel2.setText("Iniciar Sesion");
        PnelContenedor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        txtPassword.setBorder(null);
        PnelContenedor.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 200, 30));

        txtUsuario.setBorder(null);
        PnelContenedor.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 200, 30));

        btnIniciarSesion.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnIniciarSesion.setContentAreaFilled(false);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        PnelContenedor.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 140, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_User_96px_2.png"))); // NOI18N
        PnelContenedor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 100, 80));

        jLabel5.setBackground(new java.awt.Color(238, 112, 82));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(238, 112, 82));
        jLabel5.setText("Usuario:");
        PnelContenedor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel6.setBackground(new java.awt.Color(238, 112, 82));
        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(238, 112, 82));
        jLabel6.setText("Contraseña:");
        PnelContenedor.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));
        PnelContenedor.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 230, 20));
        PnelContenedor.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 230, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_customer_32px_1.png"))); // NOI18N
        PnelContenedor.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 30, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Key_32px.png"))); // NOI18N
        PnelContenedor.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 30, 30));

        getContentPane().add(PnelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 360, 410));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Multiply_32px.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 30, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 30, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 360, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir del login?", "Exit", dialog);

        if(result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed

        if(txtUsuario.getText().equals("") || txtPassword.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Debe Ingresar Usuario y Contraseña");
           return;
       }
       try{
           
            Connection conn = Conexion.Conectarse(); //Obtenemos la conexion
            if(conn == null){
               throw new Exception("No se Pudo Conectar");
            }
            CallableStatement proc; //Declara un objeto de CallableStatement
            proc = conn.prepareCall("{call loguearse (?,?)}"); //Se encierra entre { la instruccion call y el procedimiento}
            proc.setString(1,txtUsuario.getText()); //Segun los ? se le asigna sus valores siguiendo el orden y su tipo
            proc.setString(2, txtPassword.getText()); //x2
            ResultSet rs =  proc.executeQuery(); //Si el procedimiento es un select se guarda en un rs y se executeQuery()
            if(rs.next()){
                rs.first();
                System.out.println(rs.getString(1));
                if(rs.getString(2).equals("Administrador")){
                      //AdministradorMain m = new AdministradorMain();
                      //m.setVisible(true);
                     //this.dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario y/o Constraseña Incorrecto");
            }
       }catch (Exception e){
           JOptionPane.showMessageDialog(null,"Ha Ocurrido un error al Conectarse");
           System.out.println(e.getMessage());
       }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnelContenedor;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
