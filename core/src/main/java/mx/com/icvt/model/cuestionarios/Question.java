package mx.com.icvt.model.cuestionarios;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public abstract class Question<U extends Answer> {

    private Long id;
    private String textQuestion;

    public Question(String textQuestion){
        if (textQuestion == null || textQuestion.length() <= 0) {
            throw new IllegalArgumentException("Argument textQuestion cannot be null or empty");
        }
        this.textQuestion = textQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

}
