package mx.com.icvt.front.services;

import mx.com.icvt.front.presenters.GrupoNoticias;
import mx.com.icvt.front.presenters.Noticia;
import mx.com.icvt.front.presenters.NoticiasAgrupadas;
import mx.com.icvt.persistence.impl.tags.Etiqueta;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("/noticias")
public class NoticiasService {
    @POST
    @Path("/agrupadas")
    @Produces(MediaType.APPLICATION_JSON)
    public NoticiasAgrupadas getNews(@FormParam("numeroNoticias") int numeroNoticias,
                                     @FormParam("fechaInicio") String fechaInicio,
                                     @FormParam("fechaFin") String fechaFin,
                                     @FormParam("etiquetas") String etiquetas) {
        System.out.println("Número de noticias solicitadas por grupo:" + numeroNoticias);
        System.out.println("Fecha inicio:" + fechaInicio);
        System.out.println("Fecha fin:" + fechaFin);
        System.out.println("Etiquetas seleccionadas:" + etiquetas);

        NoticiasAgrupadas noticiasAgrupadas = new NoticiasAgrupadas();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha;
        Noticia noticia;
        Etiqueta etiqueta;

        GrupoNoticias hoy = new GrupoNoticias();
        fecha = new Date();
        hoy.setFecha(format.format(fecha));

        noticia = new Noticia();
        noticia.setId(1l);
        noticia.setTitulo("Dragon Mart afectara mas a sectores joyero, textil y calzado");
        noticia.setDescripcion("Dragon Mart afectara mas a sectores joyero, textil y calzado. En tanto, de acuerdo con datos de la Camara Nacional de la Industria Textil y de la Camara Nacional de la Industria del Vestido, esta cadena productiva genera cerca de 420 mil empleos directos, que representan 10 por ciento del empleo manufacturero ... ");
        noticia.setImagen("");
        noticia.setFuente("Criterio Hidalgo");
        noticia.setUrl("");

        hoy.getNoticias().add(noticia);
        hoy.getNoticias().add(noticia);
        hoy.getNoticias().add(noticia);
        hoy.getNoticias().add(noticia);
        hoy.getNoticias().add(noticia);
        hoy.getNoticias().add(noticia);

        noticiasAgrupadas.getNoticias().add(hoy);

        GrupoNoticias ayer = new GrupoNoticias();
        fecha = new Date();
        fecha.setTime(fecha.getTime() - (1000l * 60l * 60l * 24l));
        ayer.setFecha(format.format(fecha));

        ayer.getNoticias().add(noticia);
        ayer.getNoticias().add(noticia);
        ayer.getNoticias().add(noticia);
        ayer.getNoticias().add(noticia);
        ayer.getNoticias().add(noticia);
        ayer.getNoticias().add(noticia);

        noticiasAgrupadas.getNoticias().add(ayer);

        GrupoNoticias resto = new GrupoNoticias();
        fecha = new Date();
        fecha.setTime(fecha.getTime() - (1000l * 60l * 60l * 24l * 2l));
        resto.setFecha(format.format(fecha));

        resto.getNoticias().add(noticia);
        resto.getNoticias().add(noticia);
        resto.getNoticias().add(noticia);
        resto.getNoticias().add(noticia);
        resto.getNoticias().add(noticia);
        resto.getNoticias().add(noticia);

        noticiasAgrupadas.getNoticias().add(resto);

        return noticiasAgrupadas;
    }
}
