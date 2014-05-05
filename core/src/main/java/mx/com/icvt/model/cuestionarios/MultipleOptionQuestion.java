package mx.com.icvt.model.cuestionarios;

import java.util.ArrayList;

/**
 * Created by miguelangeldelatorre on 27/04/14.
 */
public class MultipleOptionQuestion extends Question {

    private ArrayList<String> possibleOptions;

    public MultipleOptionQuestion(String textQuestion) {
        super(textQuestion);
        possibleOptions = new ArrayList<String>();
    }

    /**
     * @return a Copy of the arraylist of possible options. To modify the options you must use this object methods
     */
    public ArrayList<String> getPossibleOptions() {
        ArrayList<String> retorno = new ArrayList<String>();
        for (String s : possibleOptions) {
            retorno.add(s.trim());
        }
        return retorno;
    }

    public int getPossibleOptionsSize() {
        return possibleOptions.size();
    }

    public void clearPossibleOptions() {
        possibleOptions = new ArrayList<String>();
    }

    public void addPossibleOptions(String possibleOption) {
        if (possibleOption == null || possibleOption.length() == 0) {
            throw new IllegalArgumentException("Argument possibleOption cannot be null or empty");
        }
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
