package mx.com.icvt.front.presenters.cuestionarios;

public class Tema {

    private Long id;
    private Pregunta[] preguntas;
    private String titulo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pregunta[] getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Pregunta[] preguntas) {
        this.preguntas = preguntas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
