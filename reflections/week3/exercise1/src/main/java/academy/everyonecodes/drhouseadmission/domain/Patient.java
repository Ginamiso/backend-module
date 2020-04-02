package academy.everyonecodes.drhouseadmission;

public class Patient {

    private String uuid;
    private String name;
    private String symptoms;

    public Patient() {
    }

    public Patient(String uuid, String name, String symptoms) {
        this.uuid = uuid;
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

    void setUuid(String uuid) {
        this.uuid = uuid;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
