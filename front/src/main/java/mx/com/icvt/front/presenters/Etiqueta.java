package mx.com.icvt.front.presenters;

import mx.com.icvt.model.News;

public class Etiqueta {
    private Long id;
    private String valor;
    private String color;

    public Etiqueta(News.Etiqueta etiqueta) {
        this.id = etiqueta.getId();
        this.valor = etiqueta.getValor();
        this.color = etiqueta.getColor();
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
