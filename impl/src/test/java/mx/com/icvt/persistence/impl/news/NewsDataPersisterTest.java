package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.extraction.impl.news.NewsResultData;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.impl.tags.Etiqueta;
import mx.com.icvt.persistence.impl.tags.EtiquetaPersister;
import mx.com.icvt.persistence.impl.tags.EtiquetaRetriever;
import mx.com.icvt.persistence.impl.utils.TestingDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;
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
        int originalSize = resultData.getResults().size();

        List<News> persisted = dataRetriever.retrieveAllEnabled();
        assertTrue(originalSize == persisted.size());

        resultData = creaResulDataNoticias(6, 6);
        dataPersister.persist(resultData);

        originalSize += resultData.getResults().size();

        persisted = dataRetriever.retrieveAllEnabled();
        assertTrue(originalSize == persisted.size());

        cleanDataStore();
    }

    @Test
    public void alPersistirUnaNoticiaLaPuedoRecuperarPorSuUrl() {
        resultData = creaResulDataNoticias(1, 1);
        dataPersister.persist(resultData);
        News byUrl = dataRetriever.getByUrl("http://1.com");
        assertNotNull(byUrl);

        cleanDataStore();
    }

    @Test
    public void alConsultarUnaNoticiaNoPersistidaPorUrlSeDevuelveNull() {
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
    public void alConsultarPorListaDeIdsSeDevuelvenLasNoticiasQueCumplenConElCriterio() {
        resultData = creaResulDataNoticias(1, 5);
        dataPersister.persist(resultData);

        List<News> allEnabled = dataRetriever.retrieveAllEnabled();

        List<Long> ids = new ArrayList<Long>();
        for (News n : allEnabled) {
            ids.add(n.getID());
        }

        List<News> byId = dataRetriever.getAllById(ids);

        assertEquals(ids.size(), byId.size());

        cleanDataStore();
    }

    @Test
    public void esPosibleAgregarYRecuperarEtiquetaDeNoticias() {
        NewsResultData data = creaResulDataNoticias(1, 1);
        dataPersister.persist(data);

        EtiquetaPersister etiquetaPersister = new EtiquetaPersister();
        EtiquetaRetriever etiquetaRetriever = new EtiquetaRetriever();

        List<Etiqueta> etiquetas = TestingDataProvider.ETIQUETAS;

        for (Etiqueta e : etiquetas){
            etiquetaPersister.persist(e);
        }

        Etiqueta etiqueta = etiquetaRetriever.getByValue(etiquetas.get(0).getValor());
        assertNotNull(etiqueta);

        News news = dataRetriever.getByUrl(createUrlDummy(1));
        assertNotNull(news);

        dataPersister.addLabel(news.getID(), etiqueta.getId());

       // News noticiaConEtiqueta = dataRetriever.getById(news.getID());
       // assertTrue(noticiaConEtiqueta.getEtiquetas().containsValue(etiqueta.getValor()));

        cleanDataStore();
    }

    @Test
    @Ignore
    public void siRecibeNoticiaDuplicadaMarcadaComoDeshabilitadaEntoncesNoActualizoNada(){
        /*
        * Crear dataset noticia
        * persistir
        * deshabilitar noticia
        * crear dataset noticia con modificación
        * persistir
        * verificar que no se actualizaron datos
        * */
    }

    @Test
    @Ignore
    public void siRecibeNoticiaDuplicadaConMejorImagenYHayModificacionPorAdministradorSeActualizaImagen(){
        /*
        * Crear dataset noticia
        * persistir
        * Modificar título y/o descripción
        * crear dataset noticia con modificación (mejor imagen)
        * persistir
        * verificar que se actualice sólo la imagen
        * */
    }

    @Test
    @Ignore
    public void siRecibeNoticiaDuplicadaSinMejorImagenYHayModificacionPorAdministradorNoSeActualizanDatos(){
        /*
        * Crear dataset noticia
        * persistir
        * Modificar título y/o descripción
        * crear dataset noticia con modificación (no mejor imagen)
        * persistir
        * verificar que no se actualice ningún dato
        * */
    }

    @Test
    @Ignore
    public void siRecibeNoticiaDuplicadaMasCompletaGuardaNuevaNoticia() {
        /*
        * Crear dataset noticia
        * persistir
        * crear dataset noticia con modificaciones (mejor título y/o mejor descripción y/o mejor imagen)
        * persistir
        * verificar que no se actualizaron datos
        * */
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
                } catch (MalformedURLException e) {
                    e.printStackTrace();
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
    @Ignore
    public void siRecibeNoticiaDuplicadasMenosCompletaConservaNoticiaOriginal() {
        /*
        * Crear dataset noticia
        * persistir
        * crear dataset noticia con modificaciones (menor título y/o menor descripción y/o menor imagen)
        * persistir
        * verificar que no se actualizaron datos
        * */
    }

    private NewsResultData creaResulDataNoticias(final int indiceInicio, final int indiceFinal) {
        NewsResultData resultData = new NewsResultData() {
            @Override
            public List<News> getResults() {
                ArrayList<News> noticias = new ArrayList<News>();
                News noticia;

                for (int index = indiceInicio; index <= indiceFinal; index++) {
                    String title = "Título Noticia " + index;
                    String url = createUrlDummy(index);
                    String descripcion = "Descripción Noticia " + index;
                    String fechaPublicacion = "Wed, " + index + " Mar 2014 17:34:34 GMT";
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

    private String createUrlDummy(int index){
        return "http://" + index + ".com";
    }

    @After
    public void tearDown(){
        cleanDataStore();
    }

    private void cleanDataStore() {
        dataPersister.deleteAllPersisted();
        new EtiquetaPersister().removeAllPersisted();
    }
}
