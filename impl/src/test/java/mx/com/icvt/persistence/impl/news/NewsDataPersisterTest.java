package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.extraction.ResultData;
import mx.com.icvt.model.News;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class NewsDataPersisterTest {
    private NewsDataPersister dataPersister;
    private ResultData<News> resultData;

    @Before
    public void setUp(){
        dataPersister = new NewsDataPersister();
        resultData = new ResultData<News>() {
            @Override
            public List<News> getResults() {
                List<News> noticias = new ArrayList<News>();
                News noticia;

                for (int index = 1; index < 5; index++){
                    String url = "URL Noticia "  + index;
                    String title = "Título Noticia "  + index;
                    String descripcion = "Descripción Noticia "  + index;
                    String fechaPublicacion = "Wed, 26 Mar 2014 17:34:34 GMT";
                    String urlImage = "URL Imagen " + index;
                    try {
                        noticia = new News(title, url, fechaPublicacion, descripcion, urlImage);
                        noticias.add(noticia);
                    } catch (ParseException e) {
                    }
                }
                return noticias;
            }
        };
    }

    @Test
    public void alProporcionarNoticiasNoDuplicadasSePersistenTodasLasNoticias(){
        dataPersister.persist(resultData);
        List<News> persisted = dataPersister.getAllPersisted();
        assertTrue(resultData.getResults().size() == persisted.size());

        Long deleted = dataPersister.deleteAllPersisted();
        assertTrue(deleted == persisted.size());
    }
}
