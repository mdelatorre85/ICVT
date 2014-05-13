package mx.com.icvt.model.cuestionarios;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public class SingleOptionAnswer extends Answer {

    private Integer answer;

    public SingleOptionAnswer(Long userId, SingleOptionQuestion question) {
        super(userId, question);

    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        SingleOptionQuestion q = (SingleOptionQuestion) getQuestion();
        if (answer == null) {
            throw new IllegalArgumentException("Argument answer cannot be null");
        } else if (answer.intValue() >= 0 && answer.intValue() < q.posibleOptionsSize()) {
            this.answer = answer;
        } else {
            throw new IndexOutOfBoundsException("Answer must be in the range of the possible options for the question.");
        }
    }

    @Override
    public void setQuestion(Question question) {
        if (question != null && question instanceof SingleOptionQuestion) {
            super.setQuestion(question);
        } else {
            throw new IllegalArgumentException("Argument question cannot be null and most be a SingleOptionQuestion");
        }
        super.setQuestion(question);
    }
}
