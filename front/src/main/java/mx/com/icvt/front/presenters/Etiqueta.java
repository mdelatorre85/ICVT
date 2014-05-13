package mx.com.icvt.front.presenters;

public class Etiqueta {
    private Long id;
    private String valor;

    public Etiqueta() {
    }

    public Etiqueta(Long id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
