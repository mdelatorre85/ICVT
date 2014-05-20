package mx.com.icvt.front.services;

import mx.com.icvt.model.common.Etiqueta;
import mx.com.icvt.persistence.impl.tags.EtiquetaRetriever;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/etiquetas")
public class EtiquetasService {
    @GET
    @Path("/list")
    public List<Etiqueta> getAll() {
        return new EtiquetaRetriever().getAllPersisted();
    }
}
