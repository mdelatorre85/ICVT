package mx.com.icvt.model.common;

public class Etiqueta {
    private Long id;
    private String valor;
    private String color;

    public Etiqueta(Long id, String valor, String color) {
        this.id = id;
        this.valor = valor;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
