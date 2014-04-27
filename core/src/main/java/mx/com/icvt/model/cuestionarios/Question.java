package mx.com.icvt.model.cuestionarios;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public abstract class Question<U extends Answer> {

    private Long id;
    private Answer answer;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
