package mx.com.icvt.front.presenters;

import java.util.LinkedList;
import java.util.List;

public class GrupoNoticias {
    private String fecha;
    private List<Noticia> noticias;

    public GrupoNoticias() {
        this.fecha = "";
        noticias = new LinkedList<Noticia>();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}
