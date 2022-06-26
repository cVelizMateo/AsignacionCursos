
package asignacionCursos.Entidades;

public class Semestre {
    private int SemestreId;
    private String DescripcionSemestre;

    public Semestre(){
    }
    
    public Semestre(int SemestreId, String DescripcionSemestre) {
        this.SemestreId = SemestreId;
        this.DescripcionSemestre = DescripcionSemestre;
    }

    public int getSemestreId() {
        return SemestreId;
    }

    public void setSemestreId(int SemestreId) {
        this.SemestreId = SemestreId;
    }

    public String getDescripcionSemestre() {
        return DescripcionSemestre;
    }

    public void setDescripcionSemestre(String DescripcionSemestre) {
        this.DescripcionSemestre = DescripcionSemestre;
    }
    
    
}
