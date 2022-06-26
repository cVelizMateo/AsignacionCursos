
package asignacionCursos.Conexiones;



import static asignacionCursos.Conexiones.Conexion.getConection;
import asignacionCursos.Entidades.Asignacion;
import asignacionCursos.Entidades.*;
import java.sql.*;
import javax.swing.JOptionPane;


public class DetAsignacionDAO {
    
    
    private String Insert = String.format( "INSERT INTO DETASIGNACION (ID_DETALLE,CURSOS_ID_CURSO,ASIGNACION_ASIGNACION_ID,CATEDRATICOS_IDEMPLEADO)"
            + " VALUES(DETALLESEQ.NEXTVAL,?,?,?)");
    
    //CON ESTE QUERY O INSTRUCCION PEDIMOS EL DETALLE DE LA ASIGNACION FILTRANDOLO POR ID DE EMPLEADO ;
    private String Consultar = String.format("SELECT C2.NOMBRECURSO , S.NOMSECCION , C1.NOMBREEMPLEADO FROM DETASIGNACION D , SECCION S , CATEDRATICOS C1,CURSOS C2 WHERE C2.ID_CURSO = D.CURSOS_ID_CURSO AND C2.SECCION_SECCION_ID = S.SECCION_ID AND d.catedraticos_idempleado = C1.IDEMPLEADOd.catedraticos_idempleado = ?");
    
    AsignacionDAO asignacion = new AsignacionDAO();
    Conexion A = new Conexion();
    Connection c = null;
    PreparedStatement pstm = null;
    
    ResultSet rs = null;
    
    public void AgregarDetalle(int asignacionID,int asignacionIDEmpleado, Curso curso){
        try {
            
            //retornamos la conexion
            c = getConection();// a nuestra variable c le retornamos la conexion que creamos en Conexion ( ahi se retorna con link , usuario y contraseña);
            
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Insert);
            // Le seteamos los datos a las columnas formateadas ;
            pstm.setInt(1,curso.getCursoId());
            pstm.setInt(2,asignacion.MaxIdAsignacion());
            pstm.setInt(3,asignacion.maxIdCatedraticoAsignacion());
            
            rs = pstm.executeQuery();
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"CURSO ASIGNADO !!");
            A.Close(pstm);
            A.Close(c); 
            
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"No se ha podido conectar a la base de Datos !!" +ex);
        }
    }
    
}
