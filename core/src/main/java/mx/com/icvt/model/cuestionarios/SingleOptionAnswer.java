package mx.com.icvt.model.cuestionarios;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public class SingleOptionAnswer extends Answer {

    private Integer answer;

    public SingleOptionAnswer(Long userId, Long questionId, Integer answer) {
        super(userId, questionId);

        if (answer == null) {
            throw new IllegalArgumentException("Argument answer cannot be null");
        }

        //TODO validar que la respuesta se encuentre en rango de respuestas.
        this.answer = answer;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}
