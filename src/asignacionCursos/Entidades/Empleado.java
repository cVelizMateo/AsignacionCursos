
package asignacionCursos.Entidades;

public class Empleado {
    private int IDEmpleado;
    private String NombreEmpleado;
    private Departamento DepartEmpleado ;// para solicitar el id del departemento en el que vive 
    private String TipoEmpleado;// si es profesor o es coordinador
 
    public Empleado() {
      
    }
    
    
    public Empleado(int IDEmpleado, String NombreEmpleado, Departamento Departamento) {
        this.IDEmpleado = IDEmpleado;
        this.NombreEmpleado = NombreEmpleado;
        this.DepartEmpleado = Departamento;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }

    public Departamento getDepartEmpleado() {
        return DepartEmpleado;
    }

    public void setDepartEmpleado(Departamento DepartEmpleado) {
        this.DepartEmpleado = DepartEmpleado;
    }

    public String getTipoEmpleado() {
        return TipoEmpleado;
    }

    public void setTipoEmpleado(String TipoEmpleado) {
        this.TipoEmpleado = TipoEmpleado;
    }
    
    
}
