
package asignacionCursos.Entidades;

public class Universidad {
    private int UniversidadId;
    private String UniNombre;

    
    public Universidad() {
        
    }
    
    
    public Universidad(int UniversidadId, String UniNombre) {
        this.UniversidadId = UniversidadId;
        this.UniNombre = UniNombre;
    }

    public int getUniversidadId() {
        return UniversidadId;
    }

    public void setUniversidadId(int UniversidadId) {
        this.UniversidadId = UniversidadId;
    }

    public String getUniNombre() {
        return UniNombre;
    }

    public void setUniNombre(String UniNombre) {
        this.UniNombre = UniNombre;
    }
    
    
}
