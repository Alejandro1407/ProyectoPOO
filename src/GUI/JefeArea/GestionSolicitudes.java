/*
Victor Alejandro Alejo Galvez AG181471
Matthew Emilio Gaitan Ramos GR180499
Dennis Enrique Cruz Inestrosa CI180440
Marco Antonio Hernandez Hernandez HH182006
Javier Ernesto Perez Pablo PP180605
*/
package GUI.JefeArea;

import Datos.Conexion;
import java.sql.*;
import Objetos.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class GestionSolicitudes extends javax.swing.JFrame {
    private ResultSet Data;
    private int idDepartamento;
    
    public GestionSolicitudes() {
        initComponents();
        //txtid.setVisible(false);
        setLocationRelativeTo(null);
        txtid.setVisible(false);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Multiply_32px.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 30, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText(".::Solicitudes::.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Solicitud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(238, 112, 82))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setEditable(false);
        txtNombre.setBorder(null);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 220, 20));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 220, 20));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(238, 112, 82));
        jLabel10.setText("Nombre:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        txtid.setEnabled(false);
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 40, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Estado:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 112, 82));
        jLabel4.setText("Descripción:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel2.setText("En espera de repuesta");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 370, 220));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(238, 112, 82))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(238, 112, 82));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAnterior.setText("Anterior");
        btnAnterior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAnterior.setContentAreaFilled(false);
        btnAnterior.setEnabled(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel3.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 60, 30));

        btnSiguiente.setText("Siguiente");
        btnSiguiente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 70, 30));

        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 70, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 270, 100));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 20));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8-reply-arrow-32.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean IsNumeric(String x){
        try{
            int y = Integer.parseInt(x);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public void setidDepartamento(int idDepartamento){
        this.idDepartamento = idDepartamento;
    }
    
    private void getData(){
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(true);
       try{
            Connection conn = Conexion.Conectarse();
            if(conn == null){
               throw new Exception("No se pudo Conectar");
            }
            CallableStatement proc = conn.prepareCall("{call mostrar_solicitudes (?)}");
            proc.setInt(1, idDepartamento);
            this.Data = proc.executeQuery();
           if(!Data.next()){
                JOptionPane.showMessageDialog(this,"No Hay Solicitudes");
                this.dispose();
                return;
           }
            Data.beforeFirst();
            Data.next();
            txtid.setText(Data.getString(1));
            txtNombre.setText(Data.getString(2));
            txtDescripcion.setText(Data.getString(3));
            if(!Data.next()){
                btnSiguiente.setEnabled(false);
            }
            Data.previous();
            }catch(Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Fallo al recuperar la informacion");
                this.dispose();
                return;
            }
    }
    
    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        try{
            btnSiguiente.setEnabled(true);
            if(Data.previous()){
                txtid.setText(Data.getString(1));
                txtNombre.setText(Data.getString(2));
                txtDescripcion.setText(Data.getString(3));
                 if(!Data.previous()){
                    btnAnterior.setEnabled(false);
                }
                Data.next();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setState(Solicitudes.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir del login?", "Exit", dialog);

        if(result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
            try{
            btnAnterior.setEnabled(true);
            if(Data.next()){
                txtid.setText(Data.getString(1));
                txtNombre.setText(Data.getString(2));
                txtDescripcion.setText(Data.getString(3));
                if(!Data.next()){
                    btnSiguiente.setEnabled(false);
                }
                Data.previous();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getData();  
    }//GEN-LAST:event_formWindowOpened

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       int result =  JOptionPane.showConfirmDialog(this,"Seguro desea cancelar esta solicitud");
       if(result != JOptionPane.YES_OPTION){
           return;
       }
       try{
           Connection conn = Conexion.Conectarse();
           if(conn == null){
               JOptionPane.showMessageDialog(this,"Hubo un error al conectar");
               return;
           }
           CallableStatement proc = conn.prepareCall("{ call cancelar_soli (?)}");
           proc.setInt(1,Integer.parseInt(txtid.getText()));
           proc.execute();
           JOptionPane.showMessageDialog(this,"La solicitud fue cancelada");
           getData();
       }catch(Exception e){
           JOptionPane.showMessageDialog(this,"No se pudo cancelar");
       }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked
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
            java.util.logging.Logger.getLogger(GestionSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionSolicitudes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
