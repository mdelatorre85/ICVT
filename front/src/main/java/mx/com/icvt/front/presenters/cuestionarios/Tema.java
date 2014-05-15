package mx.com.icvt.front.presenters.cuestionarios;

import java.util.ArrayList;
import java.util.List;

public class Tema {

    private Long id;
    private List<Pregunta> preguntas;
    private String titulo;

    public Tema(){
        preguntas= new ArrayList<Pregunta>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
