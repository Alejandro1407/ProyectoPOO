package GUI.Administrador;

import Datos.Conexion;
import java.sql.*;
import Objetos.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class MantenimientoEmpleado extends javax.swing.JFrame {
    private ResultSet Data;
    
    public MantenimientoEmpleado() {
        initComponents();
        txtid.setVisible(false);
        setLocationRelativeTo(null);
        getDepartamentos();
        getRoles();
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
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        cmbDepartamento = new javax.swing.JComboBox<>();
        txtid = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
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
        jLabel1.setText(".::Empleados::.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(238, 112, 82))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(238, 112, 82));
        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 29, -1, -1));

        txtNombre.setBorder(null);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 220, 20));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Apellidos:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 81, -1, -1));

        txtApellidos.setBorder(null);
        jPanel2.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 220, 20));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 112, 82));
        jLabel4.setText("Email:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 129, -1, -1));

        txtEmail.setBorder(null);
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 240, 20));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(238, 112, 82));
        jLabel5.setText("Departamento:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 177, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(238, 112, 82));
        jLabel6.setText("Rol:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione Uno" }));
        jPanel2.add(cmbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 150, -1));

        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione Uno" }));
        jPanel2.add(cmbDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 150, -1));
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 220, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 240, 20));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 220, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, 290));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(238, 112, 82))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(238, 112, 82));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 60, 30));

        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 90, 30));

        btnSiguiente.setText("Siguiente");
        btnSiguiente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 70, 30));

        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEditar.setContentAreaFilled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 100, 30));

        btnAnterior.setText("Anterior");
        btnAnterior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAnterior.setContentAreaFilled(false);
        btnAnterior.setEnabled(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel3.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 60, 30));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 30));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 510));

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
    
    private void getData(){
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnEditar.setEnabled(true);
        try{
            Connection conn = Conexion.Conectarse();
            if(conn == null){
               throw new Exception("No se pudo Conectar");
            }
            CallableStatement proc;
            proc = conn.prepareCall("{call  mostrar_empleados }");
            this.Data = proc.executeQuery();
            //this.Data = Conexion.ExecuteQuery("SELECT e.id,e.nombre,e.apellidos,e.email,r.id,r.rol,d.id,d.Nombre FROM empleado e INNER JOIN rol r ON e.idRol = r.id INNER JOIN departamento d ON e.idDepartamento = d.id");//proc.executeQuery();
            if(!Data.next()){
                JOptionPane.showMessageDialog(this,"No Hay Registro que mostrar");
                return;
            }
            Data.beforeFirst();
            Data.next();
            txtid.setText(Data.getString(1));
            txtNombre.setText(Data.getString(2));
            txtApellidos.setText(Data.getString(3));
            txtEmail.setText(Data.getString(4));
            cmbRol.setSelectedItem(new Rol(Data.getInt(5),Data.getString(6)));
            cmbDepartamento.setSelectedItem(new Departamento(Data.getInt(7), Data.getString(8))); if(!Data.next()){
                btnSiguiente.setEnabled(false);
            }
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
           if(txtApellidos.getText().equals("") || IsNumeric(txtApellidos.getText())){
               JOptionPane.showMessageDialog(this,"Apellidos no puede estar vacio o ser numerico");
               return;
           }
           if(!txtEmail.getText().matches("^\\w{5,}@\\w{3,}((\\.)[A-Za-z]{2,3}){1,}$") || IsNumeric(txtEmail.getText())){
               JOptionPane.showMessageDialog(this,"Email Ingresado es Invalido o Numerico");
               return;
           }
           if(cmbDepartamento.getSelectedIndex() == 0){
               JOptionPane.showMessageDialog(this, "Debe Selecciona un Departamento");
               return;
           }
           if(cmbRol.getSelectedIndex() == 0){
               JOptionPane.showMessageDialog(this,"Debe Asignarle un Rol");
               return;
           }
        
            try{
                Connection conn = Conexion.Conectarse();
                if(conn == null){
                    throw new Exception("No se pudo Conectar");
                }
                CallableStatement proc; //Declara un objeto de CallableStatement
                proc = conn.prepareCall("{call insertar_empleado (?,?,?,?,?)}"); //Se encierra entre { la instruccion call y el procedimiento}
                proc.setString(1,txtNombre.getText());
                proc.setString(2, txtApellidos.getText());
                proc.setString(3, txtEmail.getText());
                proc.setInt(4, ((Rol)cmbRol.getSelectedItem()).getId());
                proc.setInt(5, ((Departamento)cmbDepartamento.getSelectedItem()).getId());
                ResultSet rs = proc.executeQuery();
                rs.next();
                JOptionPane.showMessageDialog(this,rs.getString(1));
                btnLimpiarActionPerformed(evt);
                getData();
                       
           }catch(Exception e){
               JOptionPane.showMessageDialog(this, e.getMessage());
               System.out.println(e.getMessage());
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
            proc = conn.prepareCall("{call eliminar_empleado (?)}"); //Se encierra entre { la instruccion call y el procedimiento}
            proc.setInt(1,Integer.parseInt(txtid.getText()));
            if(proc.execute()){
                JOptionPane.showMessageDialog(this,"Eliminado con Exito");
                getData();
            }else{throw new Exception("Fallo Al Eliminar");}
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            if(txtNombre.getText().equals("") || IsNumeric(txtNombre.getText())){
               JOptionPane.showMessageDialog(this,"Nombre no puede estar vacio o ser numerico");
               return;
           }
           if(txtApellidos.getText().equals("") || IsNumeric(txtApellidos.getText())){
               JOptionPane.showMessageDialog(this,"Apellidos no puede estar vacio o ser numerico");
               return;
           }
           if(!txtEmail.getText().matches("^\\w{5,}@\\w{3,}((\\.)[A-Za-z]{2,3}){1,}$") || IsNumeric(txtEmail.getText())){
               JOptionPane.showMessageDialog(this,"Email Ingresado es Invalido o Numerico");
               return;
           }
           if(cmbDepartamento.getSelectedIndex() == 0){
               JOptionPane.showMessageDialog(this, "Debe Selecciona un Departamento");
               return;
           }
           if(cmbRol.getSelectedIndex() == 0){
               JOptionPane.showMessageDialog(this,"Debe Asignarle un Rol");
               return;
           }
        
        if(JOptionPane.showConfirmDialog(this,"¿Seguro desea Actulizar este registro?") != JOptionPane.YES_OPTION){
            return;
        } 
        try{ 
            Connection conn = Conexion.Conectarse(); //Obtenemos la conexion
            if(conn == null){
               throw new Exception("No se Pudo Conectar");
            }
            CallableStatement proc; //Declara un objeto de CallableStatement
            proc = conn.prepareCall("{call  actualizar_empleado (?,?,?,?,?,?)}"); //Se encierra entre { la instruccion call y el procedimiento}
            proc.setInt(1,Integer.parseInt(txtid.getText()));
            proc.setString(2,txtNombre.getText());
            proc.setString(3,txtApellidos.getText());
            proc.setString(4,txtEmail.getText());
            proc.setInt(5, ((Rol)cmbRol.getSelectedItem()).getId());
            proc.setInt(6, ((Departamento)cmbDepartamento.getSelectedItem()).getId());
            if(proc.execute()){
                JOptionPane.showMessageDialog(this,"Actulizado con Exito");
                getData();
            }else{
                throw new Exception("Fallo Al Actulizar");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Ocurrio un error");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
              txtNombre.setText("");
       txtApellidos.setText("");
       txtEmail.setText("");
       cmbDepartamento.setSelectedIndex(0);
       cmbRol.setSelectedIndex(0);
       btnAgregar.setEnabled(true);
       btnEditar.setEnabled(false);
       btnEliminar.setEnabled(false);
       try{Data.beforeFirst();}catch(Exception e){}
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
            txtApellidos.setText(Data.getString(3));
            txtEmail.setText(Data.getString(4));
            cmbRol.setSelectedItem(new Rol(Data.getInt(5),Data.getString(6)));
            cmbDepartamento.setSelectedItem(new Departamento(Data.getInt(7), Data.getString(8)));
            if(!Data.next()){
                btnSiguiente.setEnabled(false);
            }
             Data.previous();
            
          }
        }catch(Exception e){
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
                txtApellidos.setText(Data.getString(3));
                txtEmail.setText(Data.getString(4));
                cmbRol.setSelectedItem(new Rol(Data.getInt(5),Data.getString(6)));
                cmbDepartamento.setSelectedItem(new Departamento(Data.getInt(7), Data.getString(8)));
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
        AdministradorMain a = new AdministradorMain();
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
            txtApellidos.setText(rs.getString(3));
            txtEmail.setText(rs.getString(4));
            cmbRol.setSelectedItem(new Rol(rs.getInt(5),rs.getString(6)));
            cmbDepartamento.setSelectedItem(new Departamento(rs.getInt(7),  rs.getString(8)));
            Data.beforeFirst();
            btnSiguiente.setEnabled(true);
            btnAnterior.setEnabled(false);
       }catch(Exception e){
          JOptionPane.showMessageDialog(this,"Ha Ocurrido un error");
         System.out.print(e.getMessage());
       
       }
    }//GEN-LAST:event_btnBuscarActionPerformed
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoEmpleado().setVisible(true);
            }
        });
    }
    
    private void getDepartamentos(){
       DefaultComboBoxModel model = new DefaultComboBoxModel();
        cmbDepartamento.setModel(model);
        model.addElement(new Departamento(-1, "-- Seleccione Uno"));
        try{
            ResultSet rs = Conexion.ExecuteQuery("SELECT * FROM departamento");
            if(!rs.next()){
                JOptionPane.showMessageDialog(this,"Lo Sentimos no hay Departamentos Registrados");
                this.dispose();
            }
            rs.beforeFirst();
            while(rs.next()){
               model.addElement(new Departamento(rs.getInt(1),rs.getString(3)));
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//getDepartamentos
    
    private void getRoles(){
          DefaultComboBoxModel model = new DefaultComboBoxModel();
        cmbRol.setModel(model);
        model.addElement(new Rol(-1, "-- Seleccione Uno"));
        try{
            ResultSet rs = Conexion.ExecuteQuery("SELECT * FROM rol");
            if(!rs.next()){
                JOptionPane.showMessageDialog(this,"Lo Sentimos no hay Roles Registrados");
                this.dispose();
            }
           rs.beforeFirst();
            while(rs.next()){
                model.addElement(new Rol(rs.getInt(1),rs.getString(2)));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
