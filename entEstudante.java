import java.io.Serializable;

public class entEstudante implements Serializable {

    //Atributos
    private String strACodigo;
    private String strANome;

    //Setters
    public void setCodigo(String pCodigo) {
        strACodigo = pCodigo;
    }

    public void setNome(String pNome) {
        strANome = pNome;
    }

    //Getters
    public String getCodigo() {
        return strACodigo;
    }

    public String getNome() {
        return strANome;
    }
}