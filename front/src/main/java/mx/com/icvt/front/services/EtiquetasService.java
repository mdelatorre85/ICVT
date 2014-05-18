package mx.com.icvt.front.services;

import mx.com.icvt.front.presenters.commons.Etiqueta;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.impl.tags.EtiquetaRetriever;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.LinkedList;
import java.util.List;

@Path("/etiquetas")
public class EtiquetasService {
    @GET
    @Path("/list")
    public List<Etiqueta> getAll() {
        List<Etiqueta> etiquetas = new LinkedList<Etiqueta>();
        News.Etiqueta temp;
        Etiqueta etiqueta;

        EtiquetaRetriever retriever = new EtiquetaRetriever();
        List<mx.com.icvt.persistence.impl.tags.Etiqueta> all = retriever.getAllPersisted();
        for (mx.com.icvt.persistence.impl.tags.Etiqueta e : all){
            //
        }

        return etiquetas;
    }
}
