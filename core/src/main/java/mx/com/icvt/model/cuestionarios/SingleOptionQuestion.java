package mx.com.icvt.model.cuestionarios;

import java.util.ArrayList;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public class SingleOptionQuestion extends Question<SingleOptionAnswer> {

    private String textQuestion;
    private ArrayList<String> posibleAnswers;

    public SingleOptionQuestion(String textQuestion, ArrayList<String> posibleAnswers) {
        if (textQuestion == null || textQuestion.length() <= 0) {
            throw new IllegalArgumentException("Argument textQuestion cannot be null or empty");
        }

        if (posibleAnswers != null && posibleAnswers.size() <= 0) {
            throw new IllegalArgumentException("Argument textQuestion cannot be null or empty");
        }

        this.textQuestion = textQuestion;
        this.posibleAnswers = posibleAnswers;
    }
}
