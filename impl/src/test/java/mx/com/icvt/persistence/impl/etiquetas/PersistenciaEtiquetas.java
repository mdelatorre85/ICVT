package mx.com.icvt.persistence.impl.etiquetas;

import mx.com.icvt.persistence.impl.tags.Etiqueta;
import mx.com.icvt.persistence.impl.tags.EtiquetaPersister;
import mx.com.icvt.persistence.impl.tags.EtiquetaRetriever;
import mx.com.icvt.persistence.impl.utils.TestingDataProvider;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

public class PersistenciaEtiquetas {

    private EtiquetaPersister persister;
    private EtiquetaRetriever retriever;

    @Before
    public void init() {
        persister = new EtiquetaPersister();
        retriever = new EtiquetaRetriever();
    }

    @Test
    public void alGuardarEtiquetasSeRecuperanLaMismaCantidad() {
        List<Etiqueta> etiquetas = TestingDataProvider.ETIQUETAS;
        for (Etiqueta etiqueta : etiquetas) {
            persister.persist(etiqueta);
        }

        List<Etiqueta> persisted = retriever.getAllPersisted();
        assertEquals(etiquetas.size(), persisted.size());
        cleanDataStore();
    }

    @Test
    public void esPosibleBuscarUnaEtiquetaPorNombre() {
        List<Etiqueta> etiquetas = TestingDataProvider.ETIQUETAS;
        for (Etiqueta etiqueta : etiquetas) {
            persister.persist(etiqueta);
        }

        Etiqueta byValue = retriever.getByValue(etiquetas.get(0).getValor());
        assertNotNull(byValue);

        cleanDataStore();
    }

    @Test
    public void alBuscarPorNombreUnaEtiquetaInexistenteSeDevuelveNull() {
        Etiqueta noExistente = retriever.getByValue("ETIQUETA_NO_EXISTENTE");
        assertNull(noExistente);
    }

    @Test
    public void esPosibleRecuperarEtiquetaPorId() {
        List<Etiqueta> etiquetas = TestingDataProvider.ETIQUETAS;
        for (Etiqueta etiqueta : etiquetas) {
            persister.persist(etiqueta);
        }

        List<Etiqueta> persisted = retriever.getAllPersisted();
        Long id = persisted.get(0).getId();
        Etiqueta etiqueta = retriever.getById(id);
        assertEquals(persisted.get(0).getValor(), etiqueta.getValor());

        cleanDataStore();
    }

    private void cleanDataStore() {
        persister.removeAllPersisted();
    }
}
