package mx.com.icvt.front.services;

import mx.com.icvt.model.common.Etiqueta;
import mx.com.icvt.persistence.impl.tags.EtiquetaRetriever;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/etiquetas")
public class EtiquetasService {
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Etiqueta> getAll() {
        return new EtiquetaRetriever().getAllPersisted();
    }
}
