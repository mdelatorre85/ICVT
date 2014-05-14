package mx.com.icvt.model.cuestionarios;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by miguelangeldelatorre on 13/05/14.
 */
public class SingleOptionQuestionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testWrongInstantationNullQuestion(){
        new SingleOptionQuestion(null);
    }

    @Test
    public void testCorrectInstantation(){
        SingleOptionQuestion question = new SingleOptionQuestion("If man evolved from apes why do we still have apes?");
        assertNotNull(question);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongSetAnswerNullAnswer(){
        SingleOptionQuestion question = new SingleOptionQuestion("If man evolved from apes why do we still have apes?");
        question.setAnswer(null);
    }

    @Test
    public void testCorrectSetAnswer(){
        SingleOptionQuestion q = new SingleOptionQuestion("If man evolved from apes why do we still have apes?");
        q.addPossibleOptions("Opción Uno");
        q.addPossibleOptions("Opción Dos");
        q.addPossibleOptions("Opción Tres");
        q.addPossibleOptions("Opción Cuatro");
        q.addPossibleOptions("Todas las Anteriores");

        SingleOptionAnswer multipleOptionAnswer = new SingleOptionAnswer(1l,q);
        multipleOptionAnswer.setAnswer(0);

        assertNotNull(q);
        assertNotNull(multipleOptionAnswer);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testWrongSetAnswerWrongAnswerOutOfBound(){
        SingleOptionQuestion q = new SingleOptionQuestion("If man evolved from apes why do we still have apes?");
        q.addPossibleOptions("Opción Uno");
        q.addPossibleOptions("Opción Dos");
        q.addPossibleOptions("Opción Tres");
        q.addPossibleOptions("Opción Cuatro");
        q.addPossibleOptions("Todas las Anteriores");

        SingleOptionAnswer multipleOptionAnswer = new SingleOptionAnswer(1l,q);
        multipleOptionAnswer.setAnswer(500);

        assertNotNull(q);
        assertNotNull(multipleOptionAnswer);

    }

    @Test
    public void testCorrectChangeAnswer(){
        SingleOptionQuestion q = new SingleOptionQuestion("If man evolved from apes why do we still have apes?");
        q.addPossibleOptions("Opción Uno");
        q.addPossibleOptions("Opción Dos");
        q.addPossibleOptions("Opción Tres");
        q.addPossibleOptions("Opción Cuatro");
        q.addPossibleOptions("Todas las Anteriores");

        SingleOptionAnswer singleOptionAnswer = new SingleOptionAnswer(1l,q);
        singleOptionAnswer.setAnswer(0);
        assertTrue(singleOptionAnswer.getAnswer().intValue()==0);

        singleOptionAnswer.setAnswer(3);
        assertTrue(singleOptionAnswer.getAnswer().intValue() == 3);

        assertNotNull(q);
        assertNotNull(singleOptionAnswer);
    }

}
