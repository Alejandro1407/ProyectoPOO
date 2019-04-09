/*
Victor Alejandro Alejo Galvez AG181471
Matthew Emilio Gaitan Ramos GR180499
Dennis Enrique Cruz Inestrosa CI180440
Marco Antonio Hernandez Hernandez HH182006
Javier Ernesto Perez Pablo PP180605
*/
package GUI.Administrador;

import Datos.Conexion;
import java.sql.*;
import Objetos.*;
import java.awt.HeadlessException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Mantenimientodepartamentos extends javax.swing.JFrame {
    private ResultSet Data;
    
    public Mantenimientodepartamentos() {
        initComponents();
        txtid.setVisible(false);
        setLocationRelativeTo(null);
        getData();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setText(".::DEPARTAMENTOS::.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 32));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(238, 112, 82))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(238, 112, 82));
        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Descripcion:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
        });
        jPanel2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 180, 70));

        txtid.setEditable(false);
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 180, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 310, 200));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 74, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 74, -1, -1));

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 31, -1, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 74, 66, -1));

        btnAnterior.setText("Anterior");
        btnAnterior.setEnabled(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel3.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 31, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 31, 60, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 310, 130));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 37, 37));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8-reply-arrow-32.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 30, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_Multiply_32px.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean IsNumeric(String x){
        try{
            int y = Integer.parseInt(x);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    private void getData(){
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(true);
        btnAgregar.setEnabled(false);
        try{
            Connection conn = Conexion.Conectarse();
            if(conn == null){
               throw new Exception("No se pudo Conectar");
            }
            CallableStatement proc;
            proc = conn.prepareCall("{call  mostrar_departamento }");
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
             Data.previous();
        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Fallo al recuperar la informacion");
            this.dispose();
        }
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
           if(txtNombre.getText().equals("") || IsNumeric(txtNombre.getText())){
               JOptionPane.showMessageDialog(this,"Nombre no puede estar vacio o ser numerico");
               return;
           }
           if(txtDescripcion.getText().equals("") || IsNumeric(txtDescripcion.getText())){
               JOptionPane.showMessageDialog(this,"Descripcion no puede estar vacio o ser numerico");
               return;
           }
        
            try{
                Connection conn = Conexion.Conectarse();
                if(conn == null){
                    throw new Exception("No se pudo Conectar");
                }
                CallableStatement proc; //Declara un objeto de CallableStatement
                proc = conn.prepareCall("{call insertar_departamento (?,?) }"); //Se encierra entre { la instruccion call y el procedimiento}
                proc.setString(1,txtNombre.getText());
                proc.setString(2,txtDescripcion.getText());
                ResultSet rs = proc.executeQuery();
                JOptionPane.showMessageDialog(rootPane, "Registro exitoso");
                 getData();
            }catch(Exception e){
               System.out.println(e.getMessage());
                getData();
               JOptionPane.showMessageDialog(rootPane, "Registro exitoso");
           }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       if(JOptionPane.showConfirmDialog(this, "Seguro desea Eliminar el registro Actual") != JOptionPane.YES_OPTION){
            return;
       }
        try{ 
            Connection conn = Conexion.Conectarse(); //Obtenemos la conexion
            if(conn == null){
               throw new Exception("No se Pudo Conectar");
            }
            CallableStatement proc; //Declara un objeto de CallableStatement
            proc = conn.prepareCall("{call eliminar_departamento (?) }"); //Se encierra entre { la instruccion call y el procedimiento}
            proc.setInt(1,Integer.parseInt(txtid.getText()));
            ResultSet rs = proc.executeQuery();
            rs.next();
            JOptionPane.showMessageDialog(this,rs.getString(1));
            getData();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
             if(txtNombre.getText().equals("") || IsNumeric(txtNombre.getText())){
               JOptionPane.showMessageDialog(this,"Nombre no puede estar vacio o ser numerico");
               return;
           }
           if(txtDescripcion.getText().equals("") || IsNumeric(txtDescripcion.getText())){
               JOptionPane.showMessageDialog(this,"Descripcion no puede estar vacio o ser numerico");
               return;
           }
        if(JOptionPane.showConfirmDialog(this,"¿Seguro desea Actualizar este registro?") != JOptionPane.YES_OPTION){
            return;
        } 
        try{ 
            Connection conn = Conexion.Conectarse(); //Obtenemos la conexion
            if(conn == null){
               throw new Exception("No se Pudo Conectar");
            }
            CallableStatement proc; //Declara un objeto de CallableStatement
            proc = conn.prepareCall("{call  actualizar_departamento(?,?,?)}"); //Se encierra entre { la instruccion call y el procedimiento}
            proc.setInt(1,Integer.parseInt(txtid.getText()));
            proc.setString(2,txtNombre.getText());
            proc.setString(3,txtDescripcion.getText());
            proc.executeQuery();
                JOptionPane.showMessageDialog(this,"Actualizado con Exito");
                getData();
        }catch(Exception e){
            System.out.println(e.getMessage());
            getData();
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       txtNombre.setText("");
       txtDescripcion.setText("");
       btnAgregar.setEnabled(true);
       btnEditar.setEnabled(false);
       btnEliminar.setEnabled(false);
       try{Data.beforeFirst();}catch(SQLException e){}
       btnAnterior.setEnabled(false);
       btnSiguiente.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        try{
           
            btnAnterior.setEnabled(true);
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnAgregar.setEnabled(false);
            if(Data.next()){
            txtid.setText(Data.getString(1));
            txtNombre.setText(Data.getString(2));
            txtDescripcion.setText(Data.getString(3));
            if(!Data.next()){
                btnSiguiente.setEnabled(false);
            }
             Data.previous();
            
          }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        try{
            
            btnSiguiente.setEnabled(true);
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnAgregar.setEnabled(false);
            
            if(Data.previous()){
                txtid.setText(Data.getString(1));
                txtNombre.setText(Data.getString(2));
                txtDescripcion.setText(Data.getString(3));
            if(!Data.previous()){
                  btnAnterior.setEnabled(false);
            }
            Data.next();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       String var = JOptionPane.showInputDialog(this,"Ingrese Nombre del Departamento");
       if(var == null){
           System.out.println("Error Buscando");
           return;
       }
       try{
            Connection conn = Conexion.Conectarse();
            CallableStatement proc = conn.prepareCall("{call buscar_departamento(?)}");
            proc.setString(1, var);
            ResultSet rs =  proc.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(this,"Busqueda no Obtuvo Resultados");
                return;
            }
            Data.first();
            txtid.setText(rs.getString(1));
            txtNombre.setText(rs.getString(2));
            txtDescripcion.setText(rs.getString(3));
            Data.beforeFirst();
            btnSiguiente.setEnabled(true);
            btnAnterior.setEnabled(false);
       }catch(HeadlessException | SQLException e){
          JOptionPane.showMessageDialog(this,"Ha Ocurrido un error");
         System.out.print(e.getMessage());
       
       }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
         btnAgregar.setEnabled(true);
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyPressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.setState(MantenimientoRoles.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir del login?", "Exit", dialog);

        if(result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel9MouseClicked
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
            java.util.logging.Logger.getLogger(Mantenimientodepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mantenimientodepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mantenimientodepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mantenimientodepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Mantenimientodepartamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
