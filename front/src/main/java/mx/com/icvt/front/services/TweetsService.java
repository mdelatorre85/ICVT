package mx.com.icvt.front.services;

import mx.com.icvt.front.services.filters.DateFilter;
import mx.com.icvt.front.services.filters.FilterConstructor;
import mx.com.icvt.model.Tweet;
import mx.com.icvt.persistence.impl.tweets.TweetsDataRetriever;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tweets")
public class TweetsService {
    private static final int NUMERO_TWEETS = 12;

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

        DateFilter filter = new FilterConstructor().getDateFilter(fechaInicioParam, fechaFinParam);
        TweetsDataRetriever retriever = new TweetsDataRetriever();
        List<Tweet> retrieved;

        if (filter != null) {
            retrieved = retriever.getByDate(filter.getFechaInicio(), filter.getFechaFin(), numeroTweets);
        } else {
            retrieved = retriever.getRecent(numeroTweets);
        }

        return retrieved;
    }
}
