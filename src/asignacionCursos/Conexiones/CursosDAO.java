/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacionCursos.Conexiones;

import static asignacionCursos.Conexiones.Conexion.getConection;
import asignacionCursos.Entidades.Curso;
import java.sql.*;
import javax.swing.JOptionPane;
public class CursosDAO {
    // con esta instruccion select nos sale concatenado el id del centro , la jornada y el codigo del curso en general 
    private String Select = String.format("SELECT (C2.CENTROID ||'-'||J.JORNADA_ID ||'-'|| C.ID_CURSO ) , C.NOMBRECURSO,S.DESCRIPCIONSEMESTRE ,T.NOMSECCION, J.JORNADA_NOMBRE || ' , ' ||C2.NOMBRECENTRO  FROM CURSOS C ,SEMESTRE S , SECCION T,JORNADA J ,CENTRO C2\n" +
"WHERE C.SEMESTRE_SEMESTRE_ID=S.SEMESTRE_ID AND C.SECCION_SECCION_ID= T.SECCION_ID AND C.JORNADA_JORNADA_ID=J.JORNADA_ID AND J.CENTRO_CENTROID=C2.CENTROID ORDER BY ID_CURSO ASC");
    private String Insert = String.format( " INSERT INTO CURSOS (ID_CURSO,NOMBRECURSO,SEMESTRE_SEMESTRE_ID,SECCION_SECCION_ID,JORNADA_JORNADA_ID) "
            + "VALUES(CURSOSQ.NEXTVAL,?,?,?,?)");
    private String Update =  String.format("UPDATE CURSOS SET NOMBRECURSO = ? , SEMESTRE_SEMESTRE_ID = ?, SECCION_SECCION_ID = ? WHERE ID_CURSO = ? ");
    
    private String Delete =  String.format("DELETE FROM CURSOS WHERE ID_CURSO = ?");
    Conexion A = new Conexion();
    Connection c = null;
    PreparedStatement pstm = null;
    
    ResultSet rs = null;
    
    
    
    public void AgregarCurso(Curso curso){
       
        int registros =0;
        
        try {
            //retornamos la conexion 
            c = getConection();// a nuestra variable c le retornamos la conexion que creamos en Conexion ( ahi se retorna con link , usuario y contraseña);
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Insert);
            
            // Le seteamos los datos a las columnas formateadas ;
            pstm.setString(1, curso.getNombreCurso());
            pstm.setInt(2, curso.getSemCurso().getSemestreId());
            pstm.setInt(3, curso.getSecCurso().getSeccionId());
            pstm.setInt(4, curso.getJornadaCurso().getJornadaId());
            // le damos ejecutar al Query con los datos anteriormente seteados 
            rs = pstm.executeQuery();
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"CURSO Cargado a la base de datos !!");
            A.Close(pstm);
            A.Close(c);
            
        }
        // Si sale mal nos sale el siguiente dialogo con su respectiva excepcion
        catch(SQLException e ){
             JOptionPane.showMessageDialog(null,"NO SE PUDO INGRESAR EL CURSO A LA DB "+e.getMessage());
                }
    }


// LE PASAMOS UN OBJETO DE TIPO CENTRO 
    public void ModificarCurso (Curso curso,int id ){
       
        
        try {
            c = getConection();
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Update);
            
            // Le seteamos los datos a las columnas formateadas ;
            
            pstm.setString(1, curso.getNombreCurso());
            pstm.setInt(2, curso.getSemCurso().getSemestreId());
            pstm.setInt(3, curso.getSecCurso().getSeccionId());
            pstm.setInt(4, id);
            
            
            // le damos ejecutar al Query ya completado arriba 
            rs = pstm.executeQuery();
            
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"CURSO MODIFICADO !!");
            A.Close(pstm);
            A.Close(c);
        }
        // Si sale mal nos sale 
        catch(SQLException e ){
             JOptionPane.showMessageDialog(null,"NO SE PUDO ACTUALIZAR EL CURSO EN LA DB "+e.getMessage());
                }
    
    }
    
    
    
    public void EliminarCurso(int id){
        
        try {
            c = getConection();
            // Preparamos la hoja con las instrucciones formateadas 
            pstm = c.prepareStatement(Delete);
            
            // Le seteamos los datos a las columnas formateadas ;
            
            pstm.setInt(1, id);
            
            // le damos ejecutar al Query ya completado arriba 
            rs = pstm.executeQuery();
            
            // Si todo sale bien , nos muestra el siguiente Dialogo 
            JOptionPane.showMessageDialog(null,"CURSO DADO DE BAJA !!");
            A.Close(pstm);
            A.Close(c);
        }
        // Si sale mal nos sale 
        catch(SQLException e ){
             JOptionPane.showMessageDialog(null,"NO SE PUDO ELIMINAR EL CURSO EN LA DB "+e.getMessage());
                }
        
    }
    
    public void ConsultarCurso(int DepartamentoId){
    
        try{
            c = getConection();
            pstm = c.prepareStatement(Select);
            
            pstm.setInt(1, DepartamentoId);

            rs = pstm.executeQuery();
            System.out.println("----------------------------------\n");
            System.out.println("NO.         CURSOS      \n");
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
