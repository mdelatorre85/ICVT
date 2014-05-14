package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.model.News;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@Ignore
public class GenericTest {
    @Test
    public void esPosibleConsultarPorEtiquetas(){
        List<Long> ids = new ArrayList<Long>();
        ids.add(1l);
        ids.add(2l);
        NewsDataRetriever retriever = new NewsDataRetriever();
        List<News> byLabels = retriever.getAllEnabledByLabels(ids);
        assertNotNull(byLabels);
        assertTrue(!byLabels.isEmpty());
        assertTrue(byLabels.size() == 2);
    }

    @Test
    public void esPosibleConsultarPorEtiquetasYFechas(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date inicio = null, fin = null;

        try {
            inicio = format.parse("2014-05-08 00:00:00");
            fin = format.parse("2014-05-09 00:00:00");
        } catch (ParseException e) {
        }

        List<Long> ids = new ArrayList<Long>();
        ids.add(1l);
        ids.add(2l);

        NewsDataRetriever retriever = new NewsDataRetriever();

        List<News> byLabels = retriever.getAllEnabledByLabelsAndDate(ids, inicio, fin);

        assertNotNull(byLabels);
        assertTrue(!byLabels.isEmpty());
        assertTrue(byLabels.size() == 1);
    }
}
