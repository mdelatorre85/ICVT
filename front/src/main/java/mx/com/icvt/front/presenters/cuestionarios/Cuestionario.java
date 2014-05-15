package mx.com.icvt.front.presenters.cuestionarios;

import java.util.ArrayList;
import java.util.List;

public class Cuestionario {

    private Long id;
    private String titulo;
    private List<Tema> temas;

    public Cuestionario(){
        temas = new ArrayList<Tema>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
