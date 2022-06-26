
package asignacionCursos.Entidades;

public class Asignacion {
    private int AsignacionId;
    private Empleado EmplAsignacion;

    public Asignacion(){
        
    }
    
    public Asignacion(int AsignacionId, Empleado EmplAsignacion) {
        this.AsignacionId = AsignacionId;
        this.EmplAsignacion = EmplAsignacion;
    }

    public int getAsignacionId() {
        return AsignacionId;
    }

    public void setAsignacionId(int AsignacionId) {
        this.AsignacionId = AsignacionId;
    }

    public Empleado getEmplAsignacion() {
        return EmplAsignacion;
    }

    public void setEmplAsignacion(Empleado EmplAsignacion) {
        this.EmplAsignacion = EmplAsignacion;
    }
    
    
}
