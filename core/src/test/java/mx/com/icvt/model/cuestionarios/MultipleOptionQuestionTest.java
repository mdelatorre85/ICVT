package mx.com.icvt.model.cuestionarios;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by miguelangeldelatorre on 13/05/14.
 */
public class MultipleOptionQuestionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testWrongInstantationNullQuestion(){
        new MultipleOptionQuestion(null);
    }

    @Test
    public void testCorrectInstantation(){
        MultipleOptionQuestion question = new MultipleOptionQuestion("If man evolved from apes why do we still have apes?");
        assertNotNull(question);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongSetAnswerNullAnswer(){
        MultipleOptionQuestion question = new MultipleOptionQuestion("If man evolved from apes why do we still have apes?");
        question.setAnswer(null);
    }


    @Test
    public void testCorrectSetAnswer(){
        MultipleOptionQuestion q = new MultipleOptionQuestion("If man evolved from apes why do we still have apes?");
        q.addPossibleOptions("Opción Uno");
        q.addPossibleOptions("Opción Dos");
        q.addPossibleOptions("Opción Tres");
        q.addPossibleOptions("Opción Cuatro");
        q.addPossibleOptions("Todas las Anteriores");

        MultipleOptionAnswer multipleOptionAnswer = new MultipleOptionAnswer(1l,q);
        multipleOptionAnswer.addAnswer(0);
        multipleOptionAnswer.addAnswer(1);
        multipleOptionAnswer.addAnswer(2);
        multipleOptionAnswer.addAnswer(3);
        multipleOptionAnswer.addAnswer(4);

        assertNotNull(q);
        assertNotNull(multipleOptionAnswer);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testWrongSetAnswerWrongAnswerOutOfBound(){
        MultipleOptionQuestion q = new MultipleOptionQuestion("If man evolved from apes why do we still have apes?");
        q.addPossibleOptions("Opción Uno");
        q.addPossibleOptions("Opción Dos");
        q.addPossibleOptions("Opción Tres");
        q.addPossibleOptions("Opción Cuatro");
        q.addPossibleOptions("Todas las Anteriores");

        MultipleOptionAnswer multipleOptionAnswer = new MultipleOptionAnswer(1l,q);
        multipleOptionAnswer.addAnswer(0);
        multipleOptionAnswer.addAnswer(1);
        multipleOptionAnswer.addAnswer(2);
        multipleOptionAnswer.addAnswer(3);
        multipleOptionAnswer.addAnswer(400);

    }

    @Test
    public void testCorrectRemoveAnswer(){
        MultipleOptionQuestion q = new MultipleOptionQuestion("If man evolved from apes why do we still have apes?");
        q.addPossibleOptions("Opción Uno");
        q.addPossibleOptions("Opción Dos");
        q.addPossibleOptions("Opción Tres");
        q.addPossibleOptions("Opción Cuatro");
        q.addPossibleOptions("Todas las Anteriores");

        MultipleOptionAnswer multipleOptionAnswer = new MultipleOptionAnswer(1l,q);
        multipleOptionAnswer.addAnswer(0);
        multipleOptionAnswer.removeAnswer(0);

        assertTrue(multipleOptionAnswer.getAnswers().size()==0);

        multipleOptionAnswer.addAnswer(0);
        multipleOptionAnswer.addAnswer(3);
        multipleOptionAnswer.removeAnswer(3);
        assertTrue(multipleOptionAnswer.getAnswers().size()==1);

        assertNotNull(q);
        assertNotNull(multipleOptionAnswer);
    }

}
