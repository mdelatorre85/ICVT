package mx.com.icvt.model.cuestionarios;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public class OpenTextQuestion extends Question {

    public OpenTextQuestion(String textQuestion) {
        super(textQuestion);
    }

    @Override
    public void setAnswer(Answer answer) {
        if (answer == null){
            throw new IllegalArgumentException("Argument answer cannot be null");
        }
        if(! (answer instanceof OpenTextAnswer)){
            throw new IllegalArgumentException("Argument answer must be a OpenTextAnswer");
        }
        super.setAnswer(answer);
    }
}
