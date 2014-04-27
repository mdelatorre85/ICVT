package mx.com.icvt.model.cuestionarios;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public abstract class Answer {

    private Long id;
    private Long quetionId;
    private Long userId;
    private Question question;

    public Answer(Long userId, Question question) {
        if (userId == null) {
            throw new IllegalArgumentException("Argument userId cannot be null.");
        }
        if (question == null) {
            throw new IllegalArgumentException("Argument question cannot be null.");
        }

        this.userId = userId;
        this.quetionId = question.getId();
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuetionId() {
        return quetionId;
    }

    public void setQuetionId(Long quetionId) {
        this.quetionId = quetionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Argument question cannot be null.");
        }
        this.question = question;
    }
}
