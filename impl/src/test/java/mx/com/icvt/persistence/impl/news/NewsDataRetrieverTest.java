package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.extraction.ResultData;
import mx.com.icvt.model.News;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NewsDataRetrieverTest {

    private NewsDataRetriever retriever;
    private NewsDataPersister persister;

    @Before
    public void init(){
        retriever = new NewsDataRetriever();
        persister = new NewsDataPersister();
    }

    @Test
    public void noticiaRecuperadaPorUrlEsIgualANoticiaPersistida() {
//        ResultData<News> newsResultData = creaResulDataNoticias(1, 1);
//        persister.persist(newsResultData);
//        retriever.retrieve(newsResultData.getResults().get(0).getUrl());
    }

    private ResultData<News> creaResulDataNoticias(final int indiceInicio, final int indiceFinal) {
        ResultData<News> resultData = new ResultData<News>() {
            @Override
            public List<News> getResults() {
                List<News> noticias = new ArrayList<News>();
                News noticia;

                for (int index = indiceInicio; index < indiceFinal; index++) {
                    String url = "URL Noticia " + index;
                    String title = "Título Noticia " + index;
                    String descripcion = "Descripción Noticia " + index;
                    String fechaPublicacion = "Wed, 26 Mar 2014 17:34:34 GMT";
                    String urlImage = "URL Imagen " + index;
                    try {
                        noticia = new News(title, url, fechaPublicacion, descripcion, urlImage);
                        noticias.add(noticia);
                    } catch (ParseException e) {
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                return noticias;
            }
        };

        return resultData;
    }
}
