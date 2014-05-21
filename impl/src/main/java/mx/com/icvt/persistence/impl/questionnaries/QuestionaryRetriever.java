package mx.com.icvt.persistence.impl.questionnaries;

import mx.com.icvt.model.cuestionarios.Questionary;
import mx.com.icvt.persistence.impl.vocaciones.UnidadEconomica;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguelangeldelatorre on 18/05/14.
 */
public class QuestionaryRetriever {

    public List<Questionary> getAllQuestionnaires() {
        List<Questionary> questionnaires;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("Select c from cuestionarios c");
        List<Cuestionario> cuestionarios = query.getResultList();
        questionnaires = new ArrayList<Questionary>();
        for (Cuestionario cuestionario : cuestionarios) {
            questionnaires.add(cuestionario.toQuestionary());
        }
        return questionnaires;
    }

    public Questionary getById(Long idCuestionario) {
        Questionary q = null;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Cuestionario cuestionario = manager.find(Cuestionario.class, idCuestionario);
        if (cuestionario != null) {
            q = cuestionario.toQuestionary();
        }
        manager.close();
        return q;
    }

    public List<Questionary> getbyUnidadEconomicaID(Long idUnidadEconomica) {
        List<Questionary> q = new ArrayList<Questionary>();
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        UnidadEconomica unidadEconomica = manager.find(UnidadEconomica.class, idUnidadEconomica);
        List<Cuestionario> cuestionarios = unidadEconomica.getCuestionarios();
        if (cuestionarios != null && cuestionarios.size() > 0)
            for (Cuestionario cuestionario : cuestionarios) {
                q.add(cuestionario.toQuestionary());
            }
        return q;
    }

}
