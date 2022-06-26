
package asignacionCursos.Entidades;

public class DetAsignacion {
    private int DetalleId;
    private Asignacion Asignacion;
    private Curso Curso;
    
    public DetAsignacion(){
        
    }

    public DetAsignacion(int DetalleId, Asignacion Asignacion, Curso Curso) {
        this.DetalleId = DetalleId;
        this.Asignacion = Asignacion;
        this.Curso = Curso;
    }

    public int getDetalleId() {
        return DetalleId;
    }

    public void setDetalleId(int DetalleId) {
        this.DetalleId = DetalleId;
    }

    public Asignacion getAsignacion() {
        return Asignacion;
    }

    public void setAsignacion(Asignacion Asignacion) {
        this.Asignacion = Asignacion;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }
    
    
}
