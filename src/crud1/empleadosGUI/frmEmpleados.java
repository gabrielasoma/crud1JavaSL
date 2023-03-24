
package crud1.empleadosGUI;
import crud1.empleadoBL.empleadosBL;
import crud1.empleadosDAL.conectar;
import crud1.empleadosDAL.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//flaticon , iconos
//si queremos bloquear campos es directamente desde la GUI, hay que darle a editable en caso del txtId

public class frmEmpleados extends javax.swing.JFrame {
    //para llenar o modificar info en la tabla
    DefaultTableModel modelo;
   
    //constructor
    public frmEmpleados() {
        initComponents();
        
        //para tabla
        String[] titulos ={"ID","Nombre","Correo"};
        modelo = new DefaultTableModel(null,titulos);
        //con esto cambiamos a la tabla los titulos
        tblEmpleados.setModel(modelo);
        
        //metodo de mostrar datos
        this.mostrarDatosTabla();
        this.limpiar();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID:");

        txtId.setEditable(false);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/agregar-archivo.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Correo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(25, 25, 25)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnBorrar)
                    .addComponent(btnCancelar))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton editar
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       //Copiamos lo mismo del botón agregar
        conexion con = new conexion();
        con.conectar();
        empleadosBL oEmpleados=  recuperarDatosGui();
        
        //preguntamos si quiere hacer insert
        int respuesta = JOptionPane.showConfirmDialog(this,"¿Estás seguro de que quieres editar este usuario?","ConfirM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
          
        
        //recupera los datos y ejecuta la sentencia NUEVA LINEA
        String strSentenciaInsert = String.format("UPDATE Empleados SET Nombre='%s', Correo='%s' WHERE ID=%d", oEmpleados.getNombre(),oEmpleados.getCorreo(),oEmpleados.getID());
        
        //Lineas del btn agregar
        con.ejecutarSentenciaSQL(strSentenciaInsert);
        
        JOptionPane.showMessageDialog(null, "Se ha editado el registro", "Editar", JOptionPane.INFORMATION_MESSAGE);
        this.mostrarDatosTabla();
        limpiar();
       
        System.out.println("Yes");
      
        }else if(respuesta==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operación cancelada", "Editar", JOptionPane.ERROR_MESSAGE);
            limpiar(); 
            System.out.println("No");
        }else if(respuesta==JOptionPane.CLOSED_OPTION){
            limpiar();  
            System.out.println("Close");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
      
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
         boolean cargando =true;
        conexion con = new conexion();
        con.conectar();//conexion a base de datos, FUNDAMENTAL
       
        
        //Caso 1
        //Cuando escribamos info en la gui llama al metodo de recuperar datos y apareceran en la caja de texto 
        empleadosBL oEmpleados=  recuperarDatosGui();
        
        //no ponemos el id porque es null
        //recupera los datos y ejecuta la sentencia
        String strSentenciaInsert = String.format("INSERT INTO Empleados (ID,Nombre,Correo) "
                + "VALUES (NULL,'%s','%s')",oEmpleados.getNombre(),oEmpleados.getCorreo());
        
        
        
        //preguntamos si quiere hacer insert
        int respuesta = JOptionPane.showConfirmDialog(this,"¿Estás seguro de que quieres añadir este usuario?","ConfirM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            
        //insertamos desde la gui y podemos ver los datos en consola
        con.ejecutarSentenciaSQL(strSentenciaInsert);
        
        //caso 2
        //INSERTAR ESTATICA
        //con.ejecutarSentenciaSQL("INSERT INTO Empleados (ID,Nombre,Correo) VALUES (NULL,'Sebas','pepe@gmail.com')");
        
       
        //MUESTRA DATOS  EN CONSOLA, CON EL METODO DE CONSULTAR
        try {
            //selec de nuestra tabla de sqlite
            ResultSet resultado = con.consultarRegistros("SELECT * FROM Empleados");
            
            //recuperamos la info y consultamos 1 pòr 1 , se muestra en consola
            while(resultado.next()){
                System.out.println(resultado.getString("ID"));
                System.out.println(resultado.getString("Nombre"));
                System.out.println(resultado.getString("Correo"));
            }
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        JOptionPane.showMessageDialog(null, "Se ha añadido el registro", "Añadir", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Yes");
        this.mostrarDatosTabla();
        limpiar();
         
        }else if(respuesta==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operación cancelada", "Añadir", JOptionPane.ERROR_MESSAGE);
            limpiar(); 
            System.out.println("No");
        }else if(respuesta==JOptionPane.CLOSED_OPTION){
            limpiar();  
            System.out.println("Close");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    
    //cuando pulsamos la tabla RECUPERA SUS DATOS
    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
    
    btnAgregar.setEnabled(false);
    btnEditar.setEnabled(true);  
    btnBorrar.setEnabled(true);
   
    //nos dice cuando hemos hecho 1 click
        if(evt.getClickCount()==1){
            //obtiene toda la info de ese click 
            JTable receptor = (JTable)evt.getSource();
            //Dentro del set,recepcionamos sus valores de ese click de toda la fila de la fila 0(ID)
            txtId.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),0).toString());
            txtNombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),1).toString());
            txtCorreo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),2).toString());
       }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
         //Boton borrar
        //copiamos los datos del boton agregar
        conexion con = new conexion();
        con.conectar();//conexion a base de datos, FUNDAMENTAL
       
        
        //Caso 1
        //Cuando escribamos info en la gui llama al metodo de recuperar datos y apareceran en la caja de texto 
        empleadosBL oEmpleados=  recuperarDatosGui();
        
        //no ponemos el id porque es null
        
        int respuesta = JOptionPane.showConfirmDialog(this,"¿Estás seguro de que quieres eliminar este usuario?","ConfirM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
        
        //recupera los datos y ejecuta la sentencia CAMBIAMOS ESTA LINEA
        String strSentenciaInsert = String.format("DELETE FROM Empleados WHERE ID=%d",oEmpleados.getID());
        
        //insertamos desde la gui y podemos ver los datos en consola
        con.ejecutarSentenciaSQL(strSentenciaInsert);
        
        JOptionPane.showMessageDialog(null, "Se ha eliminado el registro", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Yes");
        //AÑADIMOS ESTA LINEA
        this.mostrarDatosTabla();
        limpiar();

         
        }else if(respuesta==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operación cancelada", "Eliminar", JOptionPane.ERROR_MESSAGE);
            limpiar(); 
            System.out.println("No");
        }else if(respuesta==JOptionPane.CLOSED_OPTION){
            limpiar();  
            System.out.println("Close");
        }
        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
      this.limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    
    
    //importamos nuestra clase de trabajo
    //el metodo tiene toda nuestra info grafica
    public empleadosBL recuperarDatosGui(){
        conexion con = new conexion();
        con.conectar();//conexion a base de datos, FUNDAMENTAL
       
        //creamos objetos
       empleadosBL oEmpleados= new empleadosBL();
       
       //recuperamos la info de la gui , del id
       int ID = (txtId.getText().isEmpty()?0: Integer.parseInt(txtId.getText()));
       
       oEmpleados.setID(ID);
      
       oEmpleados.setNombre(txtNombre.getText());
       oEmpleados.setCorreo(txtCorreo.getText());
       
       //retornamos el objeto
       return oEmpleados;
    }
    
    //mostramos los datos de la tabla
    public void mostrarDatosTabla(){
        //limpiar tabla
        //si la tabla tiene registros, entonces se borran
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        
    conexion con = new conexion();
    con.conectar();//conexion a base de datos, FUNDAMENTAL
          
    //conexion oTabla = new conexion();
    
    //copiamos lo de arriba, esto recoge datos 
    try {
            //selec de nuestra tabla de sqlite
            ResultSet resultado = con.consultarRegistros("SELECT * FROM Empleados");
            
            //recuperamos la info y consultamos 1 pòr 1 , se muestra en consola
            while(resultado.next()){
                System.out.println(resultado.getString("ID"));
                System.out.println(resultado.getString("Nombre"));
                System.out.println(resultado.getString("Correo"));
                
                //nueva linea, recuperamos la info
                Object[] oUsuario={resultado.getString("ID"),resultado.getString("Nombre"),resultado.getString("Correo")};
                
                modelo.addRow(oUsuario);
               
            }
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    
    public void limpiar(){
        txtId.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        
        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnBorrar.setEnabled(false);    
    }
    
    
    public static void main(String args[]) {
        conexion con = new conexion();
        con.conectar();//conexion a base de datos, FUNDAMENTAL
        //con.cerrarConexion();//CERRAMOS BD
      
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
            java.util.logging.Logger.getLogger(frmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEmpleados().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
