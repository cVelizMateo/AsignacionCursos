
package asignacionCursos.Entidades;

public class Jornada {
    private int JornadaId;
    private String NombreJornada; 
    private Centro CentroJornada;

        public Jornada(){
    
}
        
        
    public Jornada(int JornadaId, String NombreJornada, Centro CentroJornada) {
        this.JornadaId = JornadaId;
        this.NombreJornada = NombreJornada;
        this.CentroJornada = CentroJornada;
    }

    public int getJornadaId() {
        return JornadaId;
    }

    public void setJornadaId(int JornadaId) {
        this.JornadaId = JornadaId;
    }

    public String getNombreJornada() {
        return NombreJornada;
    }

    public void setNombreJornada(String NombreJornada) {
        this.NombreJornada = NombreJornada;
    }

    public Centro getCentroJornada() {
        return CentroJornada;
    }

    public void setCentroJornada(Centro CentroJornada) {
        this.CentroJornada = CentroJornada;
    }
    
    
}
