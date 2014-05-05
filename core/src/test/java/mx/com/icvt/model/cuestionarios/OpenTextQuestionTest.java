package mx.com.icvt.model.cuestionarios;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by miguelangeldelatorre on 05/05/14.
 */
public class OpenTextQuestionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testWrongInstantationNullQuestion(){
        new OpenTextQuestion(null);
    }

    @Test
    public void testCorrectInstantation(){
        OpenTextQuestion question = new OpenTextQuestion("If man evolved from apes why do we still have apes?");
        assertNotNull(question);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongSetAnswerNullAnswer(){
        OpenTextQuestion question = new OpenTextQuestion("If man evolved from apes why do we still have apes?");
        question.setAnswer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongSetAnswerWrongAnswerClass(){
        OpenTextQuestion question = new OpenTextQuestion("If man evolved from apes why do we still have apes?");
        SingleOptionAnswer soa = new SingleOptionAnswer(1l, new SingleOptionQuestion("Pregunta de una sola opción"));
        question.setAnswer(soa);
    }


    @Test
    public void testCorrectSetAnswer(){
        OpenTextQuestion question = new OpenTextQuestion("If man evolved from apes why do we still have apes?");
        OpenTextAnswer ota = new OpenTextAnswer(1l, question,"La respuesta");
        question.setAnswer(ota);
        assertNotNull(question);
        assertNotNull(ota);
    }
}
