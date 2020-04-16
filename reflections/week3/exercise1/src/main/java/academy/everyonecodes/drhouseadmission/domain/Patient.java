package academy.everyonecodes.drhouseadmission.domain;

import java.util.Objects;

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

    public Patient(String uuid, String name, String symptoms) {
        this.name = name;
        this.symptoms = symptoms;
        this.uuid = uuid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(uuid, patient.uuid) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(symptoms, patient.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, symptoms);
    }
}
