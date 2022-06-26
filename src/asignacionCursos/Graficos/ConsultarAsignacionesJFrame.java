
package asignacionCursos.Graficos;

import asignacionCursos.Entidades.*;
import asignacionCursos.Conexiones.*;
import static asignacionCursos.Conexiones.Conexion.getConection;
import static java.lang.Integer.parseInt;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;


public class ConsultarAsignacionesJFrame extends javax.swing.JFrame {
    Conexion A = new Conexion();
    Connection c = null;
    PreparedStatement pstm = null;
    
    ResultSet rs = null;
    //d.catedraticos_idempleado = ? agregar al final 
    String SELECTDETALLE = "SELECT TO_CHAR(C3.CENTROID ||'-'||J.JORNADA_ID ||'-'|| C2.ID_CURSO ) ,C2.NOMBRECURSO , S.NOMSECCION , C1.NOMBREEMPLEADO "
            + "FROM DETASIGNACION D , SECCION S , CATEDRATICOS C1,CURSOS C2 ,CENTRO C3,JORNADA J "
            + "WHERE C2.ID_CURSO = D.CURSOS_ID_CURSO AND C2.SECCION_SECCION_ID = S.SECCION_ID AND d.catedraticos_idempleado = C1.IDEMPLEADO and  C2.JORNADA_JORNADA_ID=J.JORNADA_ID AND J.CENTRO_CENTROID=C3.CENTROID and d.catedraticos_idempleado = ?   ORDER BY ID_CURSO ASC";
        
    
    /**
     * Creates new form ConsultarAsignacionesJFrame
     */
    public ConsultarAsignacionesJFrame() {
        initComponents();
        
    }
 public void mostrarJornadas(int id){
        DefaultTableModel detAsignacion = new DefaultTableModel();
        detAsignacion.addColumn("ID CURSO");
        detAsignacion.addColumn("CURSO");
        detAsignacion.addColumn("SECCION ");
        detAsignacion.addColumn("CATEDRATICO ");
        
        
        TablaConsultaAsignaciones.setModel(detAsignacion);
        
        
         try{
            c = getConection();
            pstm = c.prepareStatement(SELECTDETALLE);
            pstm.setInt(1,id);
            
            
            
            rs = pstm.executeQuery();
            String [] datos = new String[4]  ;
            
            while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);       
                datos[2]= rs.getString(3);      
                datos[3]= rs.getString(4);       
                
                detAsignacion.addRow(datos);
            }
            TablaConsultaAsignaciones.setModel(detAsignacion);
            
            A.Close(pstm);
            A.Close(c);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se ha podido conectar a la base de Datos !!" +e);
        }
        
        
        
        
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaConsultaAsignaciones = new javax.swing.JTable();
        TxtConsultaAsignaciones = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        BtnConsultaAsignacion = new javax.swing.JButton();
        BtnConsultaAsignacion1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setText("Consultar Asignaciones");

        TablaConsultaAsignaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaConsultaAsignaciones);

        TxtConsultaAsignaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtConsultaAsignacionesActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField2.setText("Inserte ID de Catedratico");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        BtnConsultaAsignacion.setText("Regresar");
        BtnConsultaAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConsultaAsignacionActionPerformed(evt);
            }
        });

        BtnConsultaAsignacion1.setText("Consultar");
        BtnConsultaAsignacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConsultaAsignacion1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtConsultaAsignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnConsultaAsignacion1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BtnConsultaAsignacion)
                            .addGap(44, 44, 44))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnConsultaAsignacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtConsultaAsignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnConsultaAsignacion1))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void BtnConsultaAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultaAsignacionActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BtnConsultaAsignacionActionPerformed

    private void BtnConsultaAsignacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultaAsignacion1ActionPerformed
        // TODO add your handling code here:
        if(this.TxtConsultaAsignaciones.getText().length()>0){
        mostrarJornadas(parseInt(TxtConsultaAsignaciones.getText()));
        }
        else {
            JOptionPane.showMessageDialog(null,"Campos de llenado vacios  !!");
           

        }
    }//GEN-LAST:event_BtnConsultaAsignacion1ActionPerformed

    private void TxtConsultaAsignacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtConsultaAsignacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtConsultaAsignacionesActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarAsignacionesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarAsignacionesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarAsignacionesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarAsignacionesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarAsignacionesJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConsultaAsignacion;
    private javax.swing.JButton BtnConsultaAsignacion1;
    private javax.swing.JTable TablaConsultaAsignaciones;
    private javax.swing.JTextField TxtConsultaAsignaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
