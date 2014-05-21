package mx.com.icvt.model.cuestionarios;

import java.util.ArrayList;

/**
 * Created by miguelangeldelatorre on 25/04/14.
 */
public class SingleOptionQuestion extends Question {

    private ArrayList<String> possibleOptions;

    public SingleOptionQuestion(String textQuestion) {
        super(textQuestion);
        possibleOptions = new ArrayList<String>();
    }

    public ArrayList<String> getPossibleOptions() {
            return possibleOptions;
    }

    public int posibleOptionsSize() {
        return possibleOptions.size();
    }

    public void clearPossibleOptions() {
        possibleOptions = new ArrayList<String>();
    }

    public void addPossibleOptions(String possibleOption) {
        if (possibleOption == null || possibleOption.length() == 0) {
            throw new IllegalArgumentException("Argument possibleOption cannot be null or empty");
        }
        possibleOptions.add(possibleOption);
    }

    public String getPossibleOption(int index) {
        return possibleOptions.get(index);
    }

    public void setPosibleOption(String possibleOption, int index) {
        if (possibleOption == null || possibleOption.length() == 0) {
            throw new IllegalArgumentException("Argument possibleOption cannot be null or empty");
        }
        possibleOptions.set(index, possibleOption);
    }

    public void removePossibleOption(String possibleOption) {
        if (possibleOption == null || possibleOption.length() == 0) {
            throw new IllegalArgumentException("Argument possibleOption cannot be null or empty");
        }
        possibleOptions.remove(possibleOption);
    }

    public void removePossibleOption(int index) {
        possibleOptions.remove(index);
    }
}
