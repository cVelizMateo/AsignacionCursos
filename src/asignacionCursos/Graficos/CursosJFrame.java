
package asignacionCursos.Graficos;

import asignacionCursos.Entidades.*;
import asignacionCursos.Conexiones.*;
import static asignacionCursos.Conexiones.Conexion.getConection;
import static java.lang.Integer.parseInt;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

public class CursosJFrame extends javax.swing.JFrame {
     CursosDAO cursoDB = new CursosDAO();
     Curso curso = new Curso();
     Semestre sem = new Semestre();
     Seccion section = new Seccion();
     Jornada jornada = new Jornada();
     
    Conexion A = new Conexion();
    Connection c = null;
    PreparedStatement pstm = null;
    
    ResultSet rs = null;
     public void mostrarCursos(){
        DefaultTableModel cursos = new DefaultTableModel();
        cursos.addColumn("ID CURSO");
        cursos.addColumn("CURSO ");
        cursos.addColumn("SEMESTRE");
        cursos.addColumn("SECCION");
        cursos.addColumn("JORNADA");
        JTablaCursos.setModel(cursos);
        
         try{
            c = getConection();
            pstm = c.prepareStatement("SELECT TO_CHAR(C2.CENTROID ||'-'||J.JORNADA_ID ||'-'|| C.ID_CURSO ) , C.NOMBRECURSO,S.DESCRIPCIONSEMESTRE ,T.NOMSECCION, J.JORNADA_NOMBRE || ' , ' ||C2.NOMBRECENTRO  FROM CURSOS C ,SEMESTRE S , SECCION T,JORNADA J ,CENTRO C2 \n" +
"WHERE C.SEMESTRE_SEMESTRE_ID=S.SEMESTRE_ID AND C.SECCION_SECCION_ID= T.SECCION_ID AND C.JORNADA_JORNADA_ID=J.JORNADA_ID AND J.CENTRO_CENTROID=C2.CENTROID ORDER BY ID_CURSO ASC");
            
            
            
            //FILTRAMOS LOS RESULTADOS POR NO. DE DEPARTAMENTO;

            rs = pstm.executeQuery();
            String [] datos = new String[6]  ;
            
            while(rs.next()){
                datos[0]= (rs.getString(1));
                datos[1]= rs.getString(2);       
                datos[2]= rs.getString(3);       
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                       
                
                cursos.addRow(datos);
            }
            JTablaCursos.setModel(cursos);
            A.Close(pstm);
            A.Close(c);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se ha podido conectar a la base de Datos !!" +e);
        }
        
        
        
        
    }
    public CursosJFrame() {
        initComponents();
        mostrarCursos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablaCursos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtSemestreAgregar = new javax.swing.JTextField();
        TxtNomCursoAgregar = new javax.swing.JTextField();
        BtnAgregarCurso = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TxtSeccionAgregar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtJornadaAgregar = new javax.swing.JTextField();
        TxtNomCursoModificar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtSemestreModificar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtSeccionModificar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        BtnModificarCurso = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        TxtIdModificar = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        TxtIdCursoEliminar = new javax.swing.JTextField();
        BtnEliminarCurso = new javax.swing.JButton();
        BtnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        JTablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(JTablaCursos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Cursos ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Nombre del Curso  ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Semestre : ");

        TxtSemestreAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSemestreAgregarActionPerformed(evt);
            }
        });

        TxtNomCursoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNomCursoAgregarActionPerformed(evt);
            }
        });

        BtnAgregarCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnAgregarCurso.setText("Agregar");
        BtnAgregarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarCursoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Seccion");

        TxtSeccionAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSeccionAgregarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Jornada");

        TxtJornadaAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtJornadaAgregarActionPerformed(evt);
            }
        });

        TxtNomCursoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNomCursoModificarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Nombre del Curso  ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Semestre : ");

        TxtSemestreModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSemestreModificarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Seccion");

        TxtSeccionModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSeccionModificarActionPerformed(evt);
            }
        });

        BtnModificarCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnModificarCurso.setText("Modificar");
        BtnModificarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarCursoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("ID");

        TxtIdModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdModificarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("ID");

        TxtIdCursoEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdCursoEliminarActionPerformed(evt);
            }
        });

        BtnEliminarCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnEliminarCurso.setText("Eliminar");
        BtnEliminarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarCursoActionPerformed(evt);
            }
        });

        BtnRegresar.setBackground(new java.awt.Color(255, 153, 153));
        BtnRegresar.setText("Regresar");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(BtnRegresar)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtSemestreAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtSeccionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(TxtNomCursoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtJornadaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(BtnAgregarCurso)))
                        .addGap(76, 76, 76))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtIdModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnModificarCurso)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                                .addComponent(jSeparator1)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(TxtSemestreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel7)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(TxtSeccionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(TxtNomCursoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtIdCursoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnEliminarCurso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)))
                        .addGap(31, 31, 31)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnRegresar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNomCursoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSemestreAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSeccionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtJornadaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnAgregarCurso)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNomCursoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSemestreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSeccionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnModificarCurso)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtIdModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnEliminarCurso)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtIdCursoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtSemestreAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSemestreAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSemestreAgregarActionPerformed

    private void TxtNomCursoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomCursoAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNomCursoAgregarActionPerformed

    private void BtnAgregarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarCursoActionPerformed
        // TODO add your handling code here:
        
        //validando que los textfields no estén vacios 
        if(this.TxtNomCursoAgregar.getText().length()>0&&this.TxtSemestreAgregar.getText().length()>0
                &&this.TxtJornadaAgregar.getText().length()>0&&this.TxtSeccionAgregar.getText().length()>0){
            
            curso.setNombreCurso(TxtNomCursoAgregar.getText());
            sem.setSemestreId(parseInt(TxtSemestreAgregar.getText()));
            section.setSeccionId(parseInt(TxtSeccionAgregar.getText()));
            jornada.setJornadaId(parseInt(TxtJornadaAgregar.getText()));
            curso.setSemCurso(sem);
            curso.setSecCurso(section);
            curso.setJornadaCurso(jornada);
            
            cursoDB.AgregarCurso(curso);

        }
        else {
            JOptionPane.showMessageDialog(null,"Campos de llenado vacios  !!");
           

        }
        Borrar();
        mostrarCursos();
    }//GEN-LAST:event_BtnAgregarCursoActionPerformed

    private void TxtSeccionAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSeccionAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSeccionAgregarActionPerformed

    private void TxtJornadaAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtJornadaAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtJornadaAgregarActionPerformed

    private void TxtNomCursoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomCursoModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNomCursoModificarActionPerformed

    private void TxtSemestreModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSemestreModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSemestreModificarActionPerformed

    private void TxtSeccionModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSeccionModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSeccionModificarActionPerformed

    private void BtnModificarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarCursoActionPerformed
        // TODO add your handling code here:
        
          //validando que los textfields no estén vacios 
        if(this.TxtNomCursoModificar.getText().length()>0&&this.TxtSemestreModificar.getText().length()>0
                &&this.TxtIdModificar.getText().length()>0&&this.TxtSeccionModificar.getText().length()>0){
            
            curso.setNombreCurso(TxtNomCursoModificar.getText());
            sem.setSemestreId(parseInt(TxtSemestreModificar.getText()));
            section.setSeccionId(parseInt(TxtSeccionModificar.getText()));
            
            curso.setSemCurso(sem);
            curso.setSecCurso(section);
            curso.setJornadaCurso(jornada);
            curso.setCursoId(parseInt(TxtIdModificar.getText()));
            cursoDB.ModificarCurso(curso,parseInt(TxtIdModificar.getText()));
            
        Borrar();
        mostrarCursos();

        }
        else {
            JOptionPane.showMessageDialog(null,"Campos de llenado vacios  !!");
           

        }
        
    }//GEN-LAST:event_BtnModificarCursoActionPerformed

    private void TxtIdModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdModificarActionPerformed

    private void TxtIdCursoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdCursoEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdCursoEliminarActionPerformed

    private void BtnEliminarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarCursoActionPerformed
        // TODO add your handling code here:
        if(this.TxtIdCursoEliminar.getText().length()>0){
            
            cursoDB.EliminarCurso(parseInt(TxtIdCursoEliminar.getText()));
        }else {
             JOptionPane.showMessageDialog(null,"Campos de llenado vacios  !!");
           
        }
    }//GEN-LAST:event_BtnEliminarCursoActionPerformed

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BtnRegresarActionPerformed

    private void Borrar(){
        TxtNomCursoAgregar.setText("");
        TxtSemestreAgregar.setText("");
        TxtJornadaAgregar.setText("");
        TxtSeccionAgregar.setText("");
        
        TxtNomCursoModificar.setText("");
        TxtSemestreModificar.setText("");
        TxtIdModificar.setText("");
        TxtSeccionModificar.setText("");
        
        TxtIdCursoEliminar.setText("");
        
        
    }
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
            java.util.logging.Logger.getLogger(CursosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CursosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CursosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CursosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CursosJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarCurso;
    private javax.swing.JButton BtnEliminarCurso;
    private javax.swing.JButton BtnModificarCurso;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JTable JTablaCursos;
    private javax.swing.JTextField TxtIdCursoEliminar;
    private javax.swing.JTextField TxtIdModificar;
    private javax.swing.JTextField TxtJornadaAgregar;
    private javax.swing.JTextField TxtNomCursoAgregar;
    private javax.swing.JTextField TxtNomCursoModificar;
    private javax.swing.JTextField TxtSeccionAgregar;
    private javax.swing.JTextField TxtSeccionModificar;
    private javax.swing.JTextField TxtSemestreAgregar;
    private javax.swing.JTextField TxtSemestreModificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private String toString(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}