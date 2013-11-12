package conexion;

public class Campo {

    private String campo;
    private String valor;

    public Campo(String campo, String valor) {
        this.campo = campo;
        this.valor = valor;
    }

    public Campo() {
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}