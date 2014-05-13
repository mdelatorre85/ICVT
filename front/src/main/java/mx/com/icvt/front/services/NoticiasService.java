package mx.com.icvt.front.services;

import mx.com.icvt.front.presenters.GrupoNoticias;
import mx.com.icvt.front.presenters.Noticia;
import mx.com.icvt.front.presenters.NoticiasAgrupadas;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.impl.news.NewsDataRetriever;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Path("/noticias")
public class NoticiasService {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private GrupoNoticias crearGrupoNoticias(Date fecha, List<News> noticias) {
        GrupoNoticias grupoNoticias = new GrupoNoticias();
        grupoNoticias.setFecha(FORMAT.format(fecha));

        for (News news : noticias) {
            grupoNoticias.getNoticias().add(crearNoticia(news));
        }

        return grupoNoticias;
    }

    private Noticia crearNoticia(News news) {
        Noticia noticia = new Noticia();
        noticia.setId(news.getID());
        noticia.setTitulo(news.getTitle());
        noticia.setDescripcion(news.getDescription());
        noticia.setUrl(news.getUrl());
        noticia.setFuente(news.getSource());
        noticia.setImagen(news.getImage());

        Set<Map.Entry<Long, String>> entries = news.getEtiquetas().entrySet();
        for (Map.Entry<Long, String> entry : entries) {
            noticia.getEtiquetas().add(new mx.com.icvt.front.presenters.Etiqueta(entry.getKey(), entry.getValue()));
        }

        return noticia;
    }

    @POST
    @Path("/agrupadas")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public NoticiasAgrupadas getNews(@FormParam("numeroNoticias") int numeroNoticias,
                                     @FormParam("fechaInicio") String fechaInicio,
                                     @FormParam("fechaFin") String fechaFin,
                                     @FormParam("etiquetas") String etiquetas) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.printf("Número de noticias solicitadas por grupo: %s \n", numeroNoticias);
        System.out.printf("Fecha inicio: %s\n", fechaInicio);
        System.out.printf("Fecha fin: %s\n", fechaFin);
        System.out.printf("Etiquetas seleccionadas: %s\n", etiquetas);

        int numeroMaximoNoticias = 6;
        Date inicio = null;
        Date fin = null;

        if (fechaInicio == null || fechaFin == null) {
            System.out.println("No se proporcionó fecha de búsqueda. Se realizará búsqueda por default");
        } else {
            try {
                inicio = format.parse(fechaInicio);
                fin = format.parse(fechaFin);
            } catch (ParseException e) {
                inicio = null;
                fin = null;
                System.out.println("Los parámetros de fecha de búsqueda son incorrectos. Se realizará búsqueda por default");
            }
        }

        NoticiasAgrupadas noticiasAgrupadas = new NoticiasAgrupadas();
        NewsDataRetriever retriever = new NewsDataRetriever();
        GrupoNoticias grupoNoticias;

        Calendar calendar = Calendar.getInstance();
        List<News> byDate;
        if (inicio == null || fin == null) {
            System.out.printf("Realizando búsqueda por default");
            Date current = new Date();
            calendar.setTime(current);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);

            Date hoy = calendar.getTime();
            System.out.printf("Buscando noticias entre %s y %s\n", FORMAT.format(hoy), FORMAT.format(current));
            byDate = retriever.getAllEnabledByDate(hoy, current);
            System.out.printf("Se encontraron %d noticias\n", byDate.size());
            grupoNoticias = crearGrupoNoticias(current, byDate);
            noticiasAgrupadas.getNoticias().add(grupoNoticias);

            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date ayer = calendar.getTime();
            System.out.printf("Buscando noticias entre %s y %s\n", FORMAT.format(ayer), FORMAT.format(hoy));
            byDate = retriever.getAllEnabledByDate(ayer, hoy);
            System.out.printf("Se encontraron %d noticias\n", byDate.size());
            grupoNoticias = crearGrupoNoticias(ayer, byDate);
            noticiasAgrupadas.getNoticias().add(grupoNoticias);

            System.out.printf("Buscando noticias máximo al %s\n", FORMAT.format(ayer));
            byDate = retriever.getAllEnabledByDate(ayer);
            System.out.printf("Se encontraron %d noticias\n", byDate.size());
            grupoNoticias = crearGrupoNoticias(ayer, byDate);
            noticiasAgrupadas.getNoticias().add(grupoNoticias);
        } else {
            System.out.printf("Realizando búsqueda por fechas\n");
            System.out.printf("Buscando noticias entre %s y %s\n", FORMAT.format(inicio), FORMAT.format(fin));
            byDate = retriever.getAllEnabledByDate(inicio, fin);
            System.out.printf("Se encontraron %d noticias\n", byDate.size());
            grupoNoticias = crearGrupoNoticias(inicio, byDate);
            noticiasAgrupadas.getNoticias().add(grupoNoticias);
        }

        return noticiasAgrupadas;
    }
}
