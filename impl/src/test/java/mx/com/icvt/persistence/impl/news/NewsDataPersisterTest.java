package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.extraction.ResultData;
import mx.com.icvt.model.News;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class NewsDataPersisterTest {
    private NewsDataPersister dataPersister;
    private ResultData<News> resultData;

    @Before
    public void setUp() {
        dataPersister = new NewsDataPersister();
        resultData = creaResulDataNoticias(1, 5);
    }

    @Test
    public void alProporcionarNoticiasNoDuplicadasSePersistenTodasLasNoticias() {
        dataPersister.persist(resultData);

        List<News> persisted = dataPersister.getAllPersisted();
        assertTrue(resultData.getResults().size() == persisted.size());

        cleanDataStore();
    }

    @Test
    @Ignore
    public void siRecibeNoticiaDuplicadaMasCompletaGuardaNuevaNoticia() {
        dataPersister.persist(resultData);
        resultData = new ResultData<News>() {
            @Override
            public List<News> getResults() {
                List<News> noticias = new ArrayList<News>();
                News noticia;

                String url = "URL Noticia 1";
                String title = "Título Noticia 1";
                String descripcion = "Descripción Noticia 1";
                String fechaPublicacion = "Wed, 26 Mar 2014 17:34:34 GMT";
                String urlImage = "URL Imagen 1";
                try {
                    noticia = new News(title, url, fechaPublicacion, descripcion, urlImage);
                    noticias.add(noticia);
                } catch (ParseException e) {
                }

                return noticias;
            }
        };

        dataPersister.persist(resultData);

        List<News> persisted = dataPersister.getAllPersisted();
        assertTrue(resultData.getResults().size() == persisted.size());


        Long deleted = dataPersister.deleteAllPersisted();
        assertTrue(deleted == persisted.size());
    }

    @Test
    @Ignore
    public void siRecibeNoticiaDuplicadasMenosCompletaConservaNoticiaOriginal() {

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
                    }
                }
                return noticias;
            }
        };

        return resultData;
    }

    private void cleanDataStore(){
        dataPersister.deleteAllPersisted();
    }
}
