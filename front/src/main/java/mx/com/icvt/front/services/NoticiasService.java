package mx.com.icvt.front.services;

import mx.com.icvt.front.presenters.noticias.GrupoNoticias;
import mx.com.icvt.front.presenters.noticias.Noticia;
import mx.com.icvt.front.presenters.noticias.NoticiasAgrupadas;
import mx.com.icvt.front.services.filters.DateFilter;
import mx.com.icvt.front.services.filters.FilterConstructor;
import mx.com.icvt.front.services.filters.LabelFilter;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.impl.news.NewsDataRetriever;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Path("/noticias")
public class NoticiasService {
    public static final int NUMERO_MAXIMO_NOTICIAS = 6;
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @POST
    @Path("/agrupadas")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public NoticiasAgrupadas getNews(@FormParam("numeroNoticias") int numeroNoticias,
                                     @FormParam("fechaInicio") String fechaInicio,
                                     @FormParam("fechaFin") String fechaFin,
                                     @FormParam("etiquetas") String etiquetasParam) {
        System.out.printf("Número de noticias solicitadas por grupo: %s \n", numeroNoticias);
        System.out.printf("Fecha inicio: %s\n", fechaInicio);
        System.out.printf("Fecha fin: %s\n", fechaFin);
        System.out.printf("Etiquetas seleccionadas: %s\n", etiquetasParam);

        FilterConstructor filterConstructor = new FilterConstructor();

        DateFilter dateFilter = filterConstructor.getDateFilter(fechaInicio, fechaFin);
        LabelFilter labelFilter = filterConstructor.getLabelFilter(etiquetasParam);

        NoticiasAgrupadas noticiasAgrupadas = new NoticiasAgrupadas();
        NewsDataRetriever retriever = new NewsDataRetriever();
        GrupoNoticias grupoNoticias;

        Calendar calendar = Calendar.getInstance();
        List<News> retrieved;
        if (dateFilter == null && labelFilter == null) {
            System.out.printf("Realizando búsqueda por default");
            Date current = new Date();
            calendar.setTime(current);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);

            Date hoy = calendar.getTime();
            System.out.printf("Buscando noticias entre %s y %s\n", FORMAT.format(hoy), FORMAT.format(current));
            retrieved = retriever.getAllEnabledByDate(hoy, current);
            System.out.printf("Se encontraron %d noticias\n", retrieved.size());
            grupoNoticias = crearGrupoNoticias(current, retrieved);
            noticiasAgrupadas.getNoticias().add(grupoNoticias);

            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date ayer = calendar.getTime();
            System.out.printf("Buscando noticias entre %s y %s\n", FORMAT.format(ayer), FORMAT.format(hoy));
            retrieved = retriever.getAllEnabledByDate(ayer, hoy);
            System.out.printf("Se encontraron %d noticias\n", retrieved.size());
            grupoNoticias = crearGrupoNoticias(ayer, retrieved);
            noticiasAgrupadas.getNoticias().add(grupoNoticias);

            System.out.printf("Buscando noticias máximo al %s\n", FORMAT.format(ayer));
            retrieved = retriever.getAllEnabledByDate(ayer);
            System.out.printf("Se encontraron %d noticias\n", retrieved.size());
            grupoNoticias = crearGrupoNoticias(ayer, retrieved);
            noticiasAgrupadas.getNoticias().add(grupoNoticias);
        } else {
            if (dateFilter != null && labelFilter != null) {
                System.out.println("Realizando búsqueda por fechas y etiquetas");
                System.out.printf("Buscando noticias entre %s y %s\n", FORMAT.format(dateFilter.getFechaInicio()), FORMAT.format(dateFilter.getFechaFin()));
                retrieved = retriever.getAllEnabledByLabelsAndDate(labelFilter.getEtiquetas(), dateFilter.getFechaInicio(), dateFilter.getFechaFin());
            } else if (dateFilter != null) {
                System.out.println("Realizando búsqueda por fechas");
                System.out.printf("Buscando noticias entre %s y %s\n", FORMAT.format(dateFilter.getFechaInicio()), FORMAT.format(dateFilter.getFechaFin()));
                retrieved = retriever.getAllEnabledByDate(dateFilter.getFechaInicio(), dateFilter.getFechaFin());
            } else {
                System.out.println("Realizando búsqueda por etiquetas");
                retrieved = retriever.getAllEnabledByLabels(labelFilter.getEtiquetas());
            }
            System.out.printf("Se encontraron %d noticias\n", retrieved.size());
            grupoNoticias = crearGrupoNoticias(new Date(), retrieved);
            noticiasAgrupadas.getNoticias().add(grupoNoticias);
        }

        return noticiasAgrupadas;
    }

    private GrupoNoticias crearGrupoNoticias(Date fecha, List<News> noticias) {
        GrupoNoticias grupoNoticias = new GrupoNoticias();
        grupoNoticias.setFecha(FORMAT.format(fecha));

        int counter = 0;
        for (News news : noticias) {
            if (counter > NUMERO_MAXIMO_NOTICIAS) {
                break;
            }

            grupoNoticias.getNoticias().add(crearNoticia(news));
            counter++;
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
        noticia.setEtiquetas(news.getEtiquetas());

        return noticia;
    }
}
