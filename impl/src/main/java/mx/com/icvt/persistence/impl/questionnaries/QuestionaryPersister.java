package mx.com.icvt.persistence.impl.questionnaries;

import mx.com.icvt.model.cuestionarios.Questionary;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 * Created by miguelangeldelatorre on 18/05/14.
 */
public class QuestionaryPersister {

    public int deleteAllPersisted() {
        int deleted;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("DELETE FROM cuestionarios c");
        deleted = query.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        return deleted;
    }


    public void persist(Questionary questionary) {
        if (questionary == null) {
            throw new IllegalArgumentException("Argument questionary cannot be null or empty");
        }

        QuestionaryRetriever retriever = new QuestionaryRetriever();
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        Cuestionario cuestionario = new Cuestionario(questionary);
/*
        for (Tema tema : cuestionario.getTemas()){
            for (Pregunta pregunta : tema.getPreguntas()){
                if (pregunta.getId() != null){
                    //if ( manager.find(Pregunta.class,pregunta.getId()) == null){
                      //  manager.persist(pregunta);
                    //}else {
                        manager.merge(pregunta);
                    //}
                } else {
                    manager.persist(pregunta);
                }

            }
        }

*/



        manager.persist(cuestionario);
/*
        if (cuestionario.getTemas().size() > 0) {
            for (Tema tema : cuestionario.getTemas()) {
                tema.setCuestionario(cuestionario);
            }
        }
*/

        manager.getTransaction().commit();
        manager.close();
    }
}
