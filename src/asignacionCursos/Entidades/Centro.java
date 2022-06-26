
package asignacionCursos.Entidades;

public class Centro {
private int CentroId;
private String NombreCentro;
private Departamento DepartCentro;
private Universidad UniCentro;



    public Centro() {
        
    }
    public Centro(int CentroId, String NombreCentro, Departamento DepartCentro, Universidad UniCentro) {
        this.CentroId = CentroId;
        this.NombreCentro = NombreCentro;
        this.DepartCentro = DepartCentro;
        this.UniCentro = UniCentro;
    }

    public int getCentroId() {
        return CentroId;
    }

    public void setCentroId(int CentroId) {
        this.CentroId = CentroId;
    }

    public String getNombreCentro() {
        return NombreCentro;
    }

    public void setNombreCentro(String NombreCentro) {
        this.NombreCentro = NombreCentro;
    }

    public Departamento getDepartCentro() {
        return DepartCentro;
    }

    public void setDepartCentro(Departamento DepartCentro) {
        this.DepartCentro = DepartCentro;
    }

    public Universidad getUniCentro() {
        return UniCentro;
    }

    public void setUniCentro(Universidad UniCentro) {
        this.UniCentro = UniCentro;
    }

    
}
