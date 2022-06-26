
package asignacionCursos.Conexiones;


import static asignacionCursos.Conexiones.Conexion.getConection;
import asignacionCursos.Entidades.Centro;
import java.sql.*;
import javax.swing.JOptionPane;

public class CentroDAO {
    private String Select = String.format("SELECT CENTROID,NOMBRECENTRO FROM CENTRO WHERE DEPARTAMENTO_DEPARTAMENTO_ID = ? ");
    private String Insert = String.format( "INSERT INTO CENTRO (CENTROID,NOMBRECENTRO,DEPARTAMENTO_DEPARTAMENTO_ID,UNIVERSIDAD_U_ID) "
                + "VALUES(INCREMENTO.NEXTVAL,?,?,?)");
    private String Update =  String.format("UPDATE CENTRO SET NOMBRECENTRO = ? WHERE CENTROID = ?");
    
    private String Delete =  String.format("DELETE FROM CENTRO WHERE CENTROID = ?");
    Conexion A = new Conexion();
    Connection c = null;
    PreparedStatement pstm = null;
    
    ResultSet rs = null;
    
    public void AgregarCentro(Centro centro){
       
        int registros =0;
        
        try {
            //retornamos la conexion 
            c = getConection();// a nuestra variable c le retornamos la conexion que creamos en Conexion ( ahi se retorna con link , usuario y contraseña);
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Insert);
            
            // Le seteamos los datos a las columnas formateadas ;
            pstm.setString(1, centro.getNombreCentro());
            pstm.setInt(2, centro.getDepartCentro().getDepartamentoID());
            pstm.setInt(3, centro.getUniCentro().getUniversidadId());
            
            // le damos ejecutar al Query con los datos anteriormente seteados 
            rs = pstm.executeQuery();
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"Centro Cargado a la base de datos !!");
            A.Close(pstm);
            A.Close(c);
            
        }
        // Si sale mal nos sale el siguiente dialogo con su respectiva excepcion
        catch(SQLException e ){
             JOptionPane.showMessageDialog(null,"NO SE PUDO INGRESAR EL CENTRO A LA DB "+e.getMessage());
                }
    }


// LE PASAMOS UN OBJETO DE TIPO CENTRO 
    public void ModificarCentro (Centro centro){
       
        
        try {
            c = getConection();
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Update);
            
            // Le seteamos los datos a las columnas formateadas ;
            
            pstm.setString(1, centro.getNombreCentro());
            pstm.setInt(2, centro.getCentroId());
            
            // le damos ejecutar al Query ya completado arriba 
            rs = pstm.executeQuery();
            
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"CENTRO MODIFICADO !!");
            A.Close(pstm);
            A.Close(c);
        }
        // Si sale mal nos sale 
        catch(SQLException e ){
             JOptionPane.showMessageDialog(null,"NO SE PUDO ACTUALIZAR EL CENTRO A LA DB "+e.getMessage());
                }
    
    }
    
    
    
    public void EliminarCentro(int id){
        
        try {
            c = getConection();
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Delete);
            
            // Le seteamos los datos a las columnas formateadas ;
            
            pstm.setInt(1, id);
            
            // le damos ejecutar al Query ya completado arriba 
            rs = pstm.executeQuery();
            
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"CENTRO ELIMINADO !!");
            A.Close(pstm);
            A.Close(c);
        }
        // Si sale mal nos sale 
        catch(SQLException e ){
             JOptionPane.showMessageDialog(null,"NO SE PUDO ELIMINAR EL CENTRO EN LA DB "+e.getMessage());
                }
        
    }
    
    public void ConsultarCentro(int DepartamentoId){
    
        try{
            c = getConection();
            pstm = c.prepareStatement(Select);
            
            pstm.setInt(1, DepartamentoId);

            rs = pstm.executeQuery();
            System.out.println("----------------------------------\n");
            System.out.println("NO.         CENTROS     \n");
            System.out.println("----------------------------------\n");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"       "+rs.getString(2)+"\n");
                
            }
            A.Close(pstm);
            A.Close(c);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se ha podido conectar a la base de Datos !!" +e);
        }
    }
    
}
