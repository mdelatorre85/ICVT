package mx.com.icvt.model.cuestionarios;

import java.util.ArrayList;

/**
 * Created by miguelangeldelatorre on 27/04/14.
 */
public class Topic {

    private Long id;
    private Long questionaryId;
    private ArrayList<Question> questions;
    private String tittle;

    private Questionary questionary;


    public Topic(Questionary questionary) {

        if (questionary == null) {
            throw new IllegalArgumentException("Argument questionary cannot be null or empty.");
        }

        this.questionaryId = questionary.getId();
        this.questionary = questionary;
        questions = new ArrayList<Question>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionaryId() {
        return questionaryId;
    }


    public Questionary getQuestionary() {
        return questionary;
    }

    public void setQuestionary(Questionary questionary) {
        if (questionary == null) {
            throw new IllegalArgumentException("Argument questionary cannot be null or empty.");
        }
        this.questionary = questionary;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int questionsSize() {
        return questions.size();
    }

    public void clearQuestions() {
        questions = new ArrayList<Question>();
    }

    public void addQuestion(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Argument question cannot be null or empty.");
        }
        questions.add(question);
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public void setQuestion(Question question, int index) {
        if (question == null) {
            throw new IllegalArgumentException("Argument question cannot be null or empty.");
        }
        questions.set(index, question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
        question.setTopic(null);
    }

    public void removeQuestion(int index) {
        questions.remove(index);
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
