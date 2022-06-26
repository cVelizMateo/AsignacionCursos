
package asignacionCursos.Entidades;

public class Curso {
    private int CursoId;
    private String NombreCurso;
    private Jornada JornadaCurso;
    private Semestre SemCurso;
    private Seccion SecCurso;

    public Curso(){
        
    }
    
    
    
    public Curso(int CursoId, String NombreCurso, Jornada JornadaCurso, Semestre SemCurso, Seccion SecCurso) {
        this.CursoId = CursoId;
        this.NombreCurso = NombreCurso;
        this.JornadaCurso = JornadaCurso;
        this.SemCurso = SemCurso;
        this.SecCurso = SecCurso;
    }

    public int getCursoId() {
        return CursoId;
    }

    public void setCursoId(int CursoId) {
        this.CursoId = CursoId;
    }

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public Jornada getJornadaCurso() {
        return JornadaCurso;
    }

    public void setJornadaCurso(Jornada JornadaCurso) {
        this.JornadaCurso = JornadaCurso;
    }

    public Semestre getSemCurso() {
        return SemCurso;
    }

    public void setSemCurso(Semestre SemCurso) {
        this.SemCurso = SemCurso;
    }

    public Seccion getSecCurso() {
        return SecCurso;
    }

    public void setSecCurso(Seccion SecCurso) {
        this.SecCurso = SecCurso;
    }
    
    
}
