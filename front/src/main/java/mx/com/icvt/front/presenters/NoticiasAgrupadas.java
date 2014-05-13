package mx.com.icvt.front.presenters;

import java.util.ArrayList;

public class NoticiasAgrupadas {
    private String fecha;
    private ArrayList<Long> ids;

    public NoticiasAgrupadas() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Long> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Long> ids) {
        this.ids = ids;
    }
}
