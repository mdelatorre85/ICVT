package mx.com.icvt.model.cuestionarios;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public class OpenTextQuestion extends Question<OpenTextAnswer> {


    private String textQuestion;

    public OpenTextQuestion(String textQuestion) {
        if (textQuestion == null || textQuestion.length() <= 0) {
            throw new IllegalArgumentException("Argument textQuestion cannot be null or empty");
        }
        this.textQuestion = textQuestion;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }


}
