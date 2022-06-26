
package asignacionCursos.Conexiones;

import java.sql.*;



/**
 *
 * @Christofer Josué Véliz Mateo 
 * Conexión de tipo generica 
 */
public class Conexion {
    //Atributos de la clase 
    private static final String linkDB = "jdbc:oracle:thin:@localhost:1521:XE";//ruta principal de nuestra base de datos 
    private static final String user = "ASIGNACIONCURSOS";//usuario que creamos para el proyecto 
    private static final String pass = "proyectoprueba";// contraseña del proyecto ... 
   
    public static Connection getConection() throws SQLException{
        return DriverManager.getConnection(linkDB,user,pass);
    }
    
    
    public static void Close(ResultSet rst) throws SQLException{
        rst.close();
    }
    
    
    public static void Close(Statement stmt) throws SQLException{
        stmt.close();
    }
    
    
    public static void Close(PreparedStatement Pstmt) throws SQLException{
        Pstmt.close();
    }
    
    
    public static void Close(Connection conn) throws SQLException{
        conn.close();
    }

 
}
 