package mx.com.icvt.front.services;

import mx.com.icvt.model.Tweet;
import mx.com.icvt.persistence.impl.tweets.TweetsDataRetriever;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("/tweets")
public class TweetsService {
    private static final int NUMERO_TWEETS = 12;
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @POST
    @Path("/retrieve")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Tweet> getTweets(@FormParam("fechaInicio") String fechaInicioParam,
                                 @FormParam("fechaFin") String fechaFinParam,
                                 @FormParam("numeroTweets") String numeroTweetsParam) {
        int numeroTweets = NUMERO_TWEETS;

        if (numeroTweetsParam != null) {
            try {
                numeroTweets = Integer.parseInt(numeroTweetsParam);
            } catch (NumberFormatException ignored) {
                numeroTweets = NUMERO_TWEETS;
            }
        }

        DateFilter filter = getDateFilter(fechaInicioParam, fechaFinParam);
        TweetsDataRetriever retriever = new TweetsDataRetriever();
        List<Tweet> retrieved;

        if (filter != null) {
            retrieved = retriever.getByDate(filter.getFechaInicio(), filter.getFechaFin(), numeroTweets);
        } else {
            retrieved = retriever.getRecent(numeroTweets);
        }

        return retrieved;
    }


    private DateFilter getDateFilter(String fechaInicioParam, String fechaFinParam) {
        DateFilter filter = null;

        if (fechaInicioParam != null && fechaFinParam != null) {
            try {
                Date fechaInicio = FORMAT.parse(fechaInicioParam);
                Date fechaFin = FORMAT.parse(fechaFinParam);
                filter = new DateFilter(fechaInicio, fechaFin);
            } catch (ParseException e) {
                System.err.println("Las fechas proporcionadas no tiene el formato correcto");
            }
        }

        return filter;
    }

    private class DateFilter {
        private Date fechaInicio;
        private Date fechaFin;

        private DateFilter(Date fechaInicio, Date fechaFin) {
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
        }

        public Date getFechaInicio() {
            return fechaInicio;
        }

        public Date getFechaFin() {
            return fechaFin;
        }
    }
}
