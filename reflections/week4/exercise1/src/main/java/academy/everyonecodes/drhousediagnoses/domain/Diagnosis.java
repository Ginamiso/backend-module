package academy.everyonecodes.drhousediagnoses.domain;

public class Diagnosis {

    private String name;
    private String symptoms;

    Diagnosis() {
    }

    public Diagnosis(String name, String symptoms) {
        this.name = name;
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

}