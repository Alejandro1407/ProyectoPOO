package GUI.JefeDesarrollo;

import GUI.Administrador.*;
import GUI.JefeArea.Solicitudes;
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
        getData();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbTester = new javax.swing.JComboBox<>();
        cmbProgramador = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtid = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente1 = new javax.swing.JButton();
        btnAceptar1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnBuscar = new javax.swing.JButton();

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8-reply-arrow-32.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Solicitud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(238, 112, 82))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(238, 112, 82));
        jLabel2.setText("Descripción");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtNombre.setBorder(null);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 220, 20));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(238, 112, 82));
        jLabel5.setText("Programador:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(238, 112, 82));
        jLabel6.setText("Tester:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        cmbTester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione Uno" }));
        jPanel2.add(cmbTester, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 150, -1));

        cmbProgramador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione Uno" }));
        jPanel2.add(cmbProgramador, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 150, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 220, 20));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(238, 112, 82));
        jLabel10.setText("Nombre:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        txtid.setEnabled(false);
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 40, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, 290));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(238, 112, 82))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(238, 112, 82));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 60, 30));

        btnAnterior.setText("Anterior");
        btnAnterior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAnterior.setContentAreaFilled(false);
        btnAnterior.setEnabled(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel3.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 60, 30));

        btnSiguiente1.setText("Siguiente");
        btnSiguiente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSiguiente1.setContentAreaFilled(false);
        btnSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnSiguiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 70, 30));

        btnAceptar1.setText("Rechazar");
        btnAceptar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAceptar1.setContentAreaFilled(false);
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 70, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 370, 100));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 20));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 510));

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
        btnAceptar.setEnabled(true);
       
        try{
            Connection conn = Conexion.Conectarse();
            if(conn == null){
               throw new Exception("No se pudo Conectar");
            }
            CallableStatement proc = conn.prepareCall("{call mostrar_solicitudes (?)}");
            proc.setInt(1, WIDTH);
            this.Data = proc.executeQuery();
           if(!Data.next()){
                JOptionPane.showMessageDialog(this,"No Hay Registro que mostrar");
                return;
            }
            Data.beforeFirst();
            Data.next();
            txtid.setText(Data.getString(1));
            txtNombre.setText(Data.getString(2));
            txtDescripcion.setText(Data.getString(3));
            if(!Data.next()){
                btnAceptar.setEnabled(false);
            }
             Data.previous();
        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Fallo al recuperar la informacion");
            this.dispose();
        }
    }
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
         try{
            btnAnterior.setEnabled(true);
            if(Data.next()){
            txtid.setText(Data.getString(1));
            txtNombre.setText(Data.getString(2));
            txtDescripcion.setText(Data.getString(3));
            cmbTester.setSelectedIndex(0);
            cmbProgramador.setSelectedIndex(0);
            if(!Data.next()){
                btnAceptar.setEnabled(false);
            }
             Data.previous();
          }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        try{
            btnAceptar.setEnabled(true);
            if(Data.previous()){
                txtid.setText(Data.getString(1));
                txtNombre.setText(Data.getString(2));
                txtDescripcion.setText(Data.getString(3));
                cmbTester.setSelectedIndex(0);
                cmbProgramador.setSelectedIndex(0);
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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        JefeDesarrolloMain a = new JefeDesarrolloMain();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir del login?", "Exit", dialog);

        if(result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         String var = JOptionPane.showInputDialog(this,"Ingrese Nombre,Apellido o Email del Empleado");
       if(var == null){
           System.out.println("ño");
           return;
       }
       try{
            Connection conn = Conexion.Conectarse();
            CallableStatement proc = conn.prepareCall("{call buscar_empleados (?)}");
            proc.setString(1, var);
            ResultSet rs =  proc.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(this,"Busqueda no Obtuvo Resultados");
                return;
            }
            rs.first();
            txtid.setText(rs.getString(1));
            txtNombre.setText(rs.getString(2));
            txtDescripcion.setText(rs.getString(3));
            Data.beforeFirst();
            btnAceptar.setEnabled(true);
            btnAnterior.setEnabled(false);
       }catch(Exception e){
          JOptionPane.showMessageDialog(this,"Ha Ocurrido un error");
         System.out.print(e.getMessage());
       
       }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
       
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getProgramadores();
        getTesters();
    }//GEN-LAST:event_formWindowOpened
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
            java.util.logging.Logger.getLogger(MantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoEmpleado().setVisible(true);
            }
        });
    }
    
    private void getProgramadores(){
       DefaultComboBoxModel model = new DefaultComboBoxModel();
        cmbProgramador.setModel(model);
        model.addElement(new Empleado(-1, "-- Sin asignar"));
        try{
            Connection conn = Conexion.Conectarse();
           CallableStatement proc = conn.prepareCall("{call programadores_sin_caso (?)}");
           proc.setInt(1,idDepartamento);
            System.out.println(idDepartamento);
            ResultSet rs = proc.executeQuery();
           if(!rs.next()){
                JOptionPane.showMessageDialog(this,"Lo Sentimos no hay Programadores Disponibles");
                this.dispose();
            }
            rs.beforeFirst();
            while(rs.next()){
               model.addElement(new Empleado(rs.getInt(1),rs.getString(2)));
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//getDepartamentos
    
    private void getTesters(){
          DefaultComboBoxModel model = new DefaultComboBoxModel();
        cmbTester.setModel(model);
        model.addElement(new Empleado(-1, "-- Sin asignar"));
        try{
            Connection conn = Conexion.Conectarse();
            CallableStatement proc =  conn.prepareCall("{call empleados_sin_caso (?)}");
            proc.setInt(1,idDepartamento);
            ResultSet rs = proc.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(this,"Lo Sentimos no hay Testers Disponibles");
                this.dispose();
            }
           rs.beforeFirst();
            while(rs.next()){
                model.addElement(new Empleado(rs.getInt(1),rs.getString(2)));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSiguiente1;
    private javax.swing.JComboBox<String> cmbProgramador;
    private javax.swing.JComboBox<String> cmbTester;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
