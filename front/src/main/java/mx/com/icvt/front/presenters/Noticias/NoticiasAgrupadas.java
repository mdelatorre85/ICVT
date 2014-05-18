package mx.com.icvt.front.presenters.noticias;

import java.util.ArrayList;
import java.util.List;

public class NoticiasAgrupadas {
    private List<GrupoNoticias> noticias;

    public NoticiasAgrupadas() {
        noticias = new ArrayList<GrupoNoticias>();
    }

    public List<GrupoNoticias> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<GrupoNoticias> noticias) {
        this.noticias = noticias;
    }
}
