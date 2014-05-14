package mx.com.icvt.model.cuestionarios;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by miguelangeldelatorre on 13/05/14.
 */
public class QuestionaryTest {

    public void testQuestionary(){
        int topics = 5;
        int questionsForTopic = 15;
        Long userID = 666l;

        Questionary questionary = new Questionary();
        for (int i = 0; i < topics; i++) {
            Topic topic = new Topic(questionary);
            questionary.addTopic(topic);
            for (int j = 0; j < questionsForTopic; j++) {
                int luck = (int)Math.floor(Math.random()*10);
                if (luck<3 ){
                    OpenTextQuestion question = new OpenTextQuestion("¿Que fue primero el huevo o la gallina?");
                    question.setAnswer(new OpenTextAnswer(userID,question ,"El huevo de otra ave"));
                    topic.addQuestion(question);
                }else if(luck<6){
                    SingleOptionQuestion q = new SingleOptionQuestion("If man evolved from apes why do we still have apes?");
                    q.addPossibleOptions("Opción Uno");
                    q.addPossibleOptions("Opción Dos");
                    q.addPossibleOptions("Opción Tres");
                    q.addPossibleOptions("Opción Cuatro");
                    q.addPossibleOptions("Todas las Anteriores");
                    q.addPossibleOptions("Ninguna de las Anteriores");

                    SingleOptionAnswer multipleOptionAnswer = new SingleOptionAnswer(userID,q);
                    multipleOptionAnswer.setAnswer(luck);
                    topic.addQuestion(q);
                } else{
                    MultipleOptionQuestion q = new MultipleOptionQuestion("If man evolved from apes why do we still have apes?");
                    q.addPossibleOptions("Opción Uno");
                    q.addPossibleOptions("Opción Dos");
                    q.addPossibleOptions("Opción Tres");
                    q.addPossibleOptions("Opción Cuatro");
                    q.addPossibleOptions("Todas las Anteriores");

                    MultipleOptionAnswer multipleOptionAnswer = new MultipleOptionAnswer(userID,q);
                    multipleOptionAnswer.addAnswer(0);
                    multipleOptionAnswer.addAnswer(1);
                    multipleOptionAnswer.addAnswer(2);
                    multipleOptionAnswer.addAnswer(3);
                    multipleOptionAnswer.addAnswer(4);
                    topic.addQuestion(q);
                }
            }
        }

        assertNotNull(questionary);

    }

}
