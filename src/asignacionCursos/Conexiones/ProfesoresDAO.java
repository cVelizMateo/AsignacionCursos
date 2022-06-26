
package asignacionCursos.Conexiones;

import static asignacionCursos.Conexiones.Conexion.getConection;
import asignacionCursos.Entidades.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class ProfesoresDAO {
    //pendiente usar el idempleado como filtrador IDEMPLEADO = ? AND
    private String Select = String.format("select c.idempleado id , c.nombreempleado nombre,d.nombredepartamento departamento from catedraticos c,departamento d  where c.departamento_departamento_id = ? and c.departamento_departamento_id=d.departamento_id");
    
    private String Insert = String.format( "INSERT INTO CATEDRATICOS (IDEMPLEADO,NOMBREEMPLEADO,DEPARTAMENTO_DEPARTAMENTO_ID) "
            + "VALUES (PROFESORESSEQ.NEXTVAL,?,?)");
    
    private String Update =  String.format("UPDATE CATEDRATICOS SET NOMBREEMPLEADO  = ?,DEPARTAMENTO_DEPARTAMENTO_ID = ? "
            + "WHERE IDEMPLEADO = ? ");
    
    private String Delete =  String.format("DELETE FROM CATEDRATICOS WHERE IDEMPLEADO = ?");
    Conexion A = new Conexion();
    Connection c = null;
    PreparedStatement pstm = null;
    
    ResultSet rs = null;
    
    
    public void AgregarProfesores(Empleado profesor){
       
        int registros =0;
        
        try {
            //retornamos la conexion 
            c = getConection();// a nuestra variable c le retornamos la conexion que creamos en Conexion ( ahi se retorna con link , usuario y contraseña);
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Insert);
            
            // Le seteamos los datos a las columnas formateadas ; 
            pstm.setString(1, profesor.getNombreEmpleado());
            pstm.setInt(2, profesor.getDepartEmpleado().getDepartamentoID());
          
            // le damos ejecutar al Query con los datos anteriormente seteados 
            rs = pstm.executeQuery();
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"PROFESOR Cargado a la base de datos !!");
            A.Close(pstm);
            A.Close(c);
            
        }
        // Si sale mal nos sale el siguiente dialogo con su respectiva excepcion
        catch(SQLException e ){
             JOptionPane.showMessageDialog(null,"NO SE PUDO INGRESAR EL PROFESOR A LA DB "+e.getMessage());
                }
    }


// LE PASAMOS UN OBJETO DE TIPO CENTRO 
    public void ModificarProfesor(Empleado profesor,int idModifica){
       
        
        try {
            c = getConection();
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Update);
            
            // Le seteamos los datos a las columnas formateadas ;
            
            pstm.setString(1, profesor.getNombreEmpleado());
            pstm.setInt(2, profesor.getDepartEmpleado().getDepartamentoID());
            pstm.setInt(3, idModifica);
            
            // le damos ejecutar al Query ya completado arriba 
            rs = pstm.executeQuery();
            
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"PROFESOR MODIFICADO / ACTUALIZADO !!");
            A.Close(pstm);
            A.Close(c);
        }
        // Si sale mal nos sale 
        catch(SQLException e ){
             JOptionPane.showMessageDialog(null,"NO SE PUDO ACTUALIZAR LOS DATOS DEL PROFESOR EN LA DB "+e.getMessage());
                }
    
    }
    
    
    
    public void EliminarProfesor(int id){
        
        try {
            c = getConection();
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Delete);
            
            // Le seteamos los datos a las columnas formateadas ;
            
            pstm.setInt(1, id);
            
            // le damos ejecutar al Query ya completado arriba 
            rs = pstm.executeQuery();
            
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"PROFESOR DADO DE BAJA !!");
            A.Close(pstm);
            A.Close(c);
        }
        // Si sale mal nos sale 
        catch(SQLException e ){
             JOptionPane.showMessageDialog(null,"NO SE PUDO ELIMINAR AL PROFESOR DE LA DB "+e.getMessage());
                }
        
    }
    
    public void ConsultarProfesor(int DepartamentoId){
    
        try{
            c = getConection();
            pstm = c.prepareStatement(Select);
            
            //FILTRAMOS LOS RESULTADOS POR NO. DE DEPARTAMENTO;
            pstm.setInt(1, DepartamentoId);

            rs = pstm.executeQuery();
            System.out.println("--------------------------------------------------------------------------------\n");
            System.out.println("ID.           NOMBRE DEL PROFESOR                   Departamento  \n");
            System.out.println("-----------------------------------------------------------------------------\n");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"       "+rs.getString(2)+"         "+rs.getString(3)+ "\n");
                
            }
            A.Close(pstm);
            A.Close(c);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se ha podido conectar a la base de Datos !!" +e);
        }
    }
    
}
