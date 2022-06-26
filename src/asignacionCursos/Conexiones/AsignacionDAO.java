
package asignacionCursos.Conexiones;

import static asignacionCursos.Conexiones.Conexion.getConection;
import asignacionCursos.Entidades.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author WINDOWS 10
 */
public class AsignacionDAO {
    private String Insert = String.format( "INSERT INTO ASIGNACION (ASIGNACION_ID,CATEDRATICOS_IDEMPLEADO)  VALUES(ASIGNACIONSEQ.NEXTVAL, ?)");
    private String max = String.format("SELECT MAX(Asignacion_id) FROM ASIGNACION ");
    private String Retorno  = String.format("SELECT  CATEDRATICOS_IDEMPLEADO FROM ASIGNACION WHERE ASIGNACION_ID = ?");
    
    Asignacion a = new Asignacion();
   
    Empleado e = new Empleado ();
      
    Conexion A = new Conexion();
    Connection c = null;
    PreparedStatement pstm = null;
    
    ResultSet rs = null;
    public void AgregarAsignacion(Asignacion asignacion){
        try {
            //retornamos la conexion
            c = getConection();// a nuestra variable c le retornamos la conexion que creamos en Conexion ( ahi se retorna con link , usuario y contraseña);
            
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Insert);
            // Le seteamos los datos a las columnas formateadas ;
            pstm.setInt(1, asignacion.getEmplAsignacion().getIDEmpleado());
            // le damos ejecutar al Query con los datos anteriormente seteados 
            rs = pstm.executeQuery();
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"ASIGNACION  GENERADA  !!");
            A.Close(pstm);
            A.Close(c);
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"No se ha podido conectar a la base de Datos !!" +ex);
        }
    }
    
    
   public int MaxIdAsignacion(){
        int m1 = 0;
       try {
           
            c = getConection();
            pstm = c.prepareStatement(max);

            rs = pstm.executeQuery();
             while(rs.next()){
               m1=rs.getInt(1);                
            }
             
        } catch (SQLException ex) {
            
        }
       
       
       return m1;
   }
   
   public int maxIdCatedraticoAsignacion(){
     int  IdAsignacionMax = 0 ; 
     int   IdCatedraticoMax = 0 ;
          IdAsignacionMax = MaxIdAsignacion(); 
            
        try {
           
            c = getConection();
            pstm = c.prepareStatement(Retorno);
            
            pstm.setInt(1, IdAsignacionMax);

            rs = pstm.executeQuery();
            while(rs.next()){
                IdCatedraticoMax=rs.getInt(1);                
            }
       
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"No se ha podido conectar a la base de Datos !!" +ex);
        }
       
      
      return IdCatedraticoMax; //vamos a retornar la ultima asignacion realizada ... la cual setearemos en detAsignacion 
   }
           
    
}
