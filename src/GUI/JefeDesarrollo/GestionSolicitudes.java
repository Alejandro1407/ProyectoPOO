package GUI.JefeDesarrollo;

import GUI.Administrador.*;
import GUI.JefeArea.Solicitudes;
import Datos.Conexion;
import java.sql.*;
import Objetos.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.util.Date;

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
        txtObservaciones = new javax.swing.JTextArea();
        txtid = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnRechazar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Solicitud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(238, 112, 82))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(238, 112, 82));
        jLabel2.setText("Observaciones:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txtNombre.setEditable(false);
        txtNombre.setBorder(null);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 220, 20));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(238, 112, 82));
        jLabel5.setText("Fecha Limite:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(238, 112, 82));
        jLabel6.setText("Tester:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        cmbTester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione Uno" }));
        jPanel2.add(cmbTester, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 150, -1));

        cmbProgramador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione Uno" }));
        jPanel2.add(cmbProgramador, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 150, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 220, 20));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(238, 112, 82));
        jLabel10.setText("Nombre:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        txtObservaciones.setText("(Opcional)");
        txtObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtObservacionesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtObservacionesFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtObservaciones);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        txtid.setEnabled(false);
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 40, -1));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(238, 112, 82));
        jLabel11.setText("Programador:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txtFecha.setText("YYYY-MM-DD");
        txtFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaFocusLost(evt);
            }
        });
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 150, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Descripción:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 370, 410));

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
        jPanel3.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 60, 30));

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

        btnRechazar.setText("Rechazar");
        btnRechazar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRechazar.setContentAreaFilled(false);
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRechazar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 70, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 270, 100));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 610));

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
                JOptionPane.showMessageDialog(this,"No Hay Solicitudes pendientes de Aprobación");
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
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
         DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        try{ 
            Date fecha = format.parse(txtFecha.getText());
            System.out.println(fecha);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Formato de Fecha Invalido\n(YYYY-MM-DD)");
            return;
        }
        if(cmbProgramador.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this,"Dese asignar un programador para el caso");
            return;
        }
        if(cmbTester.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this,"Debe asignar un Tester al caso");
            return;
        }
        try{
            Connection conn = Conexion.Conectarse();
            if(conn ==  null){
                JOptionPane.showMessageDialog(this, "Ocurrio un error al conectarse");
                return;
            }
            CallableStatement proc = conn.prepareCall(" { call crear_caso (?,?,?,?,?) }");
            proc.setInt(1,Integer.parseInt(txtid.getText()));
            proc.setString(2,txtFecha.getText());
            proc.setInt(3,((Empleado) cmbProgramador.getSelectedItem()).getId() );
            proc.setInt(4,((Empleado)cmbTester.getSelectedItem()).getId());
            if(txtObservaciones.getText().equals("(Opcional)")){
                proc.setString(5,"");
            }else{
                proc.setString(5,txtObservaciones.getText());
            }
            ResultSet answer = proc.executeQuery();
            //JOptionPane.showMessageDialog(this,answer.getString(1));
                JOptionPane.showMessageDialog(this, "Se Acepto Correctamente");
            getData();
        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }     
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        try{
            btnSiguiente.setEnabled(true);
            txtObservaciones.setText("(Opcional)");
            if(Data.previous()){
                txtid.setText(Data.getString(1));
                txtNombre.setText(Data.getString(2));
                txtDescripcion.setText(Data.getString(3));
                txtFecha.setText("YYYY-MM-DD");
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

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
            try{
            btnAnterior.setEnabled(true);
            txtObservaciones.setText("(Opcional)");
            if(Data.next()){
                txtid.setText(Data.getString(1));
                txtNombre.setText(Data.getString(2));
                txtDescripcion.setText(Data.getString(3));
                txtFecha.setText("YYYY-MM-DD");
                cmbTester.setSelectedIndex(0);
                cmbProgramador.setSelectedIndex(0);
                if(!Data.next()){
                    btnSiguiente.setEnabled(false);
                }
                Data.previous();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed
        String Motivo = JOptionPane.showInputDialog(this,"Dinos el Motivo");
        if(Motivo == null){
           return;
        }
        try{
            Connection conn = Conexion.Conectarse();
            CallableStatement proc = conn.prepareCall("{call crear_rechazo (?,?)}");
            proc.setInt(1, Integer.parseInt(txtid.getText()));
            proc.setString(2, Motivo);
            ResultSet answer = proc.executeQuery();
            JOptionPane.showMessageDialog(this, answer.getString(1));
            getData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btnRechazarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getProgramadores();
        getTesters();
        getData();  
    }//GEN-LAST:event_formWindowOpened

    private void txtFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFocusLost
        if(txtFecha.getText().equals("")){
            txtFecha.setText("YYYY-MM-DD");
        }
    }//GEN-LAST:event_txtFechaFocusLost

    private void txtFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFocusGained
       if(txtFecha.getText().equals("YYYY-MM-DD")){
           txtFecha.setText("");
       }
    }//GEN-LAST:event_txtFechaFocusGained

    private void txtObservacionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObservacionesFocusGained
        if(txtObservaciones.getText().equals("(Opcional)")){
            txtObservaciones.setText("");
        }
    }//GEN-LAST:event_txtObservacionesFocusGained

    private void txtObservacionesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObservacionesFocusLost
        if(txtObservaciones.getText().equals("")){
            txtObservaciones.setText("(Opcional)");
        }
    }//GEN-LAST:event_txtObservacionesFocusLost
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
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cmbProgramador;
    private javax.swing.JComboBox<String> cmbTester;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
