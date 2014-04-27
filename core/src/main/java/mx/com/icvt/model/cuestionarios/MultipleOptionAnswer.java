package mx.com.icvt.model.cuestionarios;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by miguelangeldelatorre on 27/04/14.
 */
public class MultipleOptionAnswer extends Answer{

    private TreeSet<Integer> answers;

    public MultipleOptionAnswer(Long userId, SingleOptionQuestion question) {
        super(userId, question);
        answers = new TreeSet<Integer>();
    }

    /**
     *
     * @return A copy of the Answers currently stored. To modify the options you must use this object methods
     */
    public TreeSet<Integer> getAnswers() {
        TreeSet<Integer> retorno = new TreeSet<Integer>();
        Iterator<Integer> i = answers.iterator();
        while (i.hasNext()){
            retorno.add(i.next());
        }
        return retorno;
    }

    public int getAnswersSize(){
        return answers.size();
    }

    public void clearAnswers(){
        answers = new TreeSet<Integer>();
    }

    public void addAnswer(Integer answer){
        MultipleOptionQuestion q = (MultipleOptionQuestion)getQuestion();
        if(answer ==  null  ){
            throw new IllegalArgumentException("Argument answer cannot be null");
        }
        else if (answer.intValue()>=0 &&  answer.intValue()< q.getPossibleOptionsSize()){
            answers.add(answer);
        } else {
            throw new IndexOutOfBoundsException("Answer must be in the range of the possible options for the question.");
        }
    }

    public void removeAnswer(Integer answer){
        answers.remove(answer);
    }

    @Override
    public void setQuestion(Question question) {
        if (question != null && question instanceof MultipleOptionQuestion){
            super.setQuestion(question);
        }else {
            throw new IllegalArgumentException("Argument question cannot be null and most be a MultipleOptionQuestion");
        }
    }

}
