package academy.everyonecodes.drhouseadmission.domain;

public class Patient {

    private String uuid;
    private String name;
    private String symptoms;

    public Patient() {
    }

    public Patient(String name, String symptoms) {
        this.name = name;
        this.symptoms = symptoms;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
