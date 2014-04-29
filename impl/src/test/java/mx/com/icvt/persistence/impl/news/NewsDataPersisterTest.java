package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.extraction.impl.news.NewsResultData;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.impl.tags.Etiqueta;
import mx.com.icvt.persistence.impl.tags.EtiquetaPersister;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class NewsDataPersisterTest {
    private NewsDataPersister dataPersister;
    private NewsDataRetriever dataRetriever;
    private NewsResultData resultData;

    @Before
    public void setUp() {
        dataPersister = new NewsDataPersister();
        dataRetriever = new NewsDataRetriever();
        resultData = creaResulDataNoticias(1, 5);
    }

    @Test
    public void alProporcionarNoticiasNoDuplicadasSePersistenTodasLasNoticias() {
        dataPersister.persist(resultData);

        List<News> persisted = dataRetriever.retrieveAllEnabled();
        assertTrue(resultData.getResults().size() == persisted.size());

        cleanDataStore();
    }

    @Test
    public void alPersistirUnaNoticiaLaPuedoRecuperarPorSuUrl(){
        resultData = creaResulDataNoticias(1, 1);
        dataPersister.persist(resultData);
        News byUrl = dataRetriever.getByUrl("http://1.com");
        assertNotNull(byUrl);

        cleanDataStore();
    }

    @Test
    public void alConsultarUnaNoticiaNoPersistidaPorUrlSeDevuelveNull(){
        resultData = creaResulDataNoticias(1, 1);
        dataPersister.persist(resultData);
        News byUrl = dataRetriever.getByUrl("http://1000.com");
        assertNull(byUrl);

        cleanDataStore();
    }

    @Test
    public void alConsultaPorFechaSeDevuelvenLasNoticiasQueCumplenConElCriterio() throws ParseException {
        String beginDate = "2014-03-02 00:00:00";
        String endDate = "2014-03-04 00:00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        resultData = creaResulDataNoticias(1, 5);
        dataPersister.persist(resultData);
        List<News> enabledByDate = dataRetriever.getAllEnabledByDate(dateFormat.parse(beginDate), dateFormat.parse(endDate));
        assertEquals(2, enabledByDate.size());

        cleanDataStore();
    }

    @Test
    public void alConsultarPorListaDeIdsSeDevuelvenLasNoticiasQueCumplenConElCriterio(){
        resultData = creaResulDataNoticias(1, 5);
        dataPersister.persist(resultData);

        List<News> allEnabled = dataRetriever.retrieveAllEnabled();

        List<Long> ids = new ArrayList<Long>();
        for (News n : allEnabled){
            ids.add(n.getID());
        }

        List<News> byId = dataRetriever.getAllById(ids);

        assertEquals(ids.size(), byId.size());

        cleanDataStore();
    }

    @Test
    public void alAgregarEtiquetaANoticiaSeCrearUnaEntradaEnNoticiaEtiqueta(){
        resultData = creaResulDataNoticias(1, 5);
        dataPersister.persist(resultData);
        List<News> persisted = dataRetriever.retrieveAllEnabled();

        EtiquetaPersister etiquetaPersister = new EtiquetaPersister();
        List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
        etiquetas.add(new Etiqueta("Economia"));
        etiquetas.add(new Etiqueta("Seguridad"));
        etiquetas.add(new Etiqueta("Exportaciones"));
        etiquetas.add(new Etiqueta("Regulaciones"));
        etiquetas.add(new Etiqueta("Tecnología"));

        for (Etiqueta etiqueta : etiquetas){
            etiquetaPersister.persist(etiqueta);
        }

        Long idNoticia;
        Long idEtiqueta;
        for (News news : persisted){
            idNoticia = news.getID();
            idEtiqueta = etiquetaPersister.getIdByValue("Economia");
            System.out.println("Id de la etiqueta Economia: " + idEtiqueta);
            System.out.println("Id de noticia " + news.getID());
            dataPersister.addLabel(idNoticia, idEtiqueta);
        }

        for (News news : persisted){
            System.out.println("Obteniendo etiquetas para la noticia: " + news.getID());
            assertEquals(1, dataPersister.getLabels(news.getID()).size());
        }
    }

    @Test
    public void siRecibeNoticiaDuplicadaMasCompletaGuardaNuevaNoticia() {
        dataPersister.persist(resultData);
        resultData = new NewsResultData() {
            @Override
            public List<News> getResults() {
                ArrayList<News> noticias = new ArrayList<News>();
                News noticia;

                String url = "http://1.com";
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

        List<News> persisted = dataRetriever.retrieveAllEnabled();
        assertTrue(resultData.getResults().size() == persisted.size());

        Long deleted = dataPersister.deleteAllPersisted();
        assertTrue(deleted == persisted.size());

        cleanDataStore();
    }

    @Test
    public void siRecibeNoticiaDuplicadasMenosCompletaConservaNoticiaOriginal() {

    }

    private NewsResultData creaResulDataNoticias(final int indiceInicio, final int indiceFinal) {
        NewsResultData resultData = new NewsResultData(){
            @Override
            public List<News> getResults() {
                ArrayList<News> noticias = new ArrayList<News>();
                News noticia;

                for (int index = indiceInicio; index <= indiceFinal; index++) {
                    String title = "Título Noticia " + index;
                    String url = "http://" + index + ".com";
                    String descripcion = "Descripción Noticia " + index;
                    String fechaPublicacion = "Wed, " + index + " Mar 2014 17:34:34 GMT";
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
