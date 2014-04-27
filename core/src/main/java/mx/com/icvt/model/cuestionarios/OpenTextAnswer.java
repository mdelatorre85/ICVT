package mx.com.icvt.model.cuestionarios;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public class OpenTextAnswer extends Answer {

    private String answer;

    public OpenTextAnswer(Long userId, Long questionId, String answer) {
        super(userId, questionId);

        if (answer == null || answer.length() <= 0) {
            throw new IllegalArgumentException("Argument answer cannot be null or empty.");
        }

        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
