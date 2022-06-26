
package asignacionCursos.Entidades;


public class Departamento {
    private int DepartamentoID;
    private String nombreDepartamento;

    
    public Departamento() {
    }
    
    public Departamento(int DepartamentoID, String nombreDepartamento) {
        this.DepartamentoID = DepartamentoID;
        this.nombreDepartamento = nombreDepartamento;
    }

    public int getDepartamentoID() {
        return DepartamentoID;
    }

    public void setDepartamentoID(int DepartamentoID) {
        this.DepartamentoID = DepartamentoID;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    
    
}
