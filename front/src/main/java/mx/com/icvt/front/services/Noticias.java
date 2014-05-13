package mx.com.icvt.front.services;

import mx.com.icvt.front.presenters.NoticiasAgrupadas;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/noticias")
public class Noticias {
    @POST
    @Path("/agrupadas")
    @Produces(MediaType.APPLICATION_JSON)
    public NoticiasAgrupadas getNews() {
        NoticiasAgrupadas noticiasAgrupadas = new NoticiasAgrupadas();
        noticiasAgrupadas.setFecha("2014-01-01");
        ArrayList<Long> ids = new ArrayList<Long>();
        ids.add(1l);
        ids.add(2l);
        noticiasAgrupadas.setIds(ids);
        return noticiasAgrupadas;
    }
}
