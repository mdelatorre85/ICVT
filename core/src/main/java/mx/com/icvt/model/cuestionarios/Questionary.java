package mx.com.icvt.model.cuestionarios;

import mx.com.icvt.model.EconomicUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguelangeldelatorre on 27/04/14.
 */
public class Questionary {

    private Long id;
    private List<Topic> topics;
    private List<EconomicUnit> economicUnits;
    private String tittle;

    public Questionary() {
        topics = new ArrayList<Topic>();
        economicUnits = new ArrayList<EconomicUnit>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Topic> getTopics() {
        ArrayList<Topic> retorno = new ArrayList<Topic>();
        for (Topic topic : topics) {
            retorno.add(topic);
        }
        return topics;
    }

    public int getTopicsSize() {
        return topics.size();
    }

    public void clearTopics() {
        topics = new ArrayList<Topic>();
    }

    public void addTopic(Topic topic) {

        if (topic == null) {
            throw new IllegalArgumentException("Argument topic cannot be null or empty.");
        }
        topics.add(topic);
    }

    public Topic getTopic(int index) {
        return topics.get(index);
    }

    public void removeTopic(Topic topic) {
        if (topic == null) {
            throw new IllegalArgumentException("Argument topic cannot be null or empty.");
        }
        topics.remove(topic);
    }

    public void removeTopic(int index) {
        topics.remove(index);
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public List<EconomicUnit> getEconomicUnits() {
        return economicUnits;
    }

    public void setEconomicUnits(List<EconomicUnit> economicUnits) {
        this.economicUnits = economicUnits;
    }
}
