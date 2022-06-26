
package asignacionCursos.Entidades;

public class Seccion {
    private int SeccionId;
    private String NombreSeccion;

    
    public Seccion(){
        
    }
    
    public Seccion(int SeccionId, String NombreSeccion) {
        this.SeccionId = SeccionId;
        this.NombreSeccion = NombreSeccion;
    }

    public int getSeccionId() {
        return SeccionId;
    }

    public void setSeccionId(int SeccionId) {
        this.SeccionId = SeccionId;
    }

    public String getNombreSeccion() {
        return NombreSeccion;
    }

    public void setNombreSeccion(String NombreSeccion) {
        this.NombreSeccion = NombreSeccion;
    }
    
    
}
