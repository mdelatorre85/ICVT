package mx.com.icvt.model.cuestionarios;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public abstract class Answer {

    private Long id;
    private Long quetionId;
    private Long userId;

    public Answer(Long userId, Long questionId) {
        if (userId == null) {
            throw new IllegalArgumentException("Argument userId cannot be null.");
        }
        if (questionId == null) {
            throw new IllegalArgumentException("Argument questionId cannot be null.");
        }

        this.userId = userId;
        this.quetionId = questionId;
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
}
