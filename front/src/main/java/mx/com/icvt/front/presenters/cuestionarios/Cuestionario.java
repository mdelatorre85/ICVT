package mx.com.icvt.front.presenters.cuestionarios;

public class Cuestionario {

    private Long id;
    private String titulo;

    private Tema[] temas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tema[] getTemas() {
        return temas;
    }

    public void setTemas(Tema[] temas) {
        this.temas = temas;
    }

}
