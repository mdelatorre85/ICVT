package mx.com.icvt.front.services;

import mx.com.icvt.front.presenters.noticias.GrupoNoticias;
import mx.com.icvt.front.presenters.noticias.Noticia;
import mx.com.icvt.front.presenters.noticias.Etiqueta;
import mx.com.icvt.front.presenters.noticias.NoticiasAgrupadas;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.impl.news.NewsDataRetriever;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Path("/noticias")
public class NoticiasService {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final int NUMERO_MAXIMO_NOTICIAS = 6;

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

        Date inicio = null;
        Date fin = null;
        List<Long> idEtiquetas = null;

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

        if (etiquetas != null && !etiquetas.isEmpty()) {
            idEtiquetas = new LinkedList<Long>();
            String[] temp = etiquetas.split(",");
            for (String t : temp) {
                try {
                    idEtiquetas.add(Long.parseLong(t));
                } catch (NumberFormatException e) {
                    System.err.printf("No se pudo parsear el valor %s\n", t);
                }
            }
        }

        NoticiasAgrupadas noticiasAgrupadas = new NoticiasAgrupadas();
        NewsDataRetriever retriever = new NewsDataRetriever();
        GrupoNoticias grupoNoticias;

        Calendar calendar = Calendar.getInstance();
        List<News> retrieved;
        if (!esFiltradoPorFecha(inicio, fin) && !esFiltradoPorEtiquetas(idEtiquetas)) {
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
            if (esFiltradoPorFecha(inicio, fin) && esFiltradoPorEtiquetas(idEtiquetas)) {
                System.out.println("Realizando búsqueda por fechas y etiquetas");
                System.out.printf("Buscando noticias entre %s y %s\n", FORMAT.format(inicio), FORMAT.format(fin));
                retrieved = retriever.getAllEnabledByLabelsAndDate(idEtiquetas, inicio, fin);
            } else if (esFiltradoPorFecha(inicio, fin)) {
                System.out.println("Realizando búsqueda por fechas");
                System.out.printf("Buscando noticias entre %s y %s\n", FORMAT.format(inicio), FORMAT.format(fin));
                retrieved = retriever.getAllEnabledByDate(inicio, fin);
            } else {
                System.out.println("Realizando búsqueda por etiquetas");
                retrieved = retriever.getAllEnabledByLabels(idEtiquetas);
            }
            System.out.printf("Se encontraron %d noticias\n", retrieved.size());
            grupoNoticias = crearGrupoNoticias(new Date(), retrieved);
            noticiasAgrupadas.getNoticias().add(grupoNoticias);
        }

        return noticiasAgrupadas;
    }

    private boolean esFiltradoPorFecha(Date fechaInicio, Date fechaFin) {
        return fechaInicio != null && fechaFin != null;
    }

    private boolean esFiltradoPorEtiquetas(List<Long> idEtiquetas) {
        return idEtiquetas != null && !idEtiquetas.isEmpty();
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

        List<News.Etiqueta> etiquetas = news.getEtiquetas();
        for (News.Etiqueta etiqueta : etiquetas) {
            noticia.getEtiquetas().add(new Etiqueta(etiqueta));
        }

        return noticia;
    }
}
