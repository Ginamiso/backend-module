package academy.everyonecodes.drhousediagnoses.domain;

import java.util.Objects;

public class Patient {

    private String uuid;
    private String name;
    private String symptoms;
    private String diagnosis;

    Patient() {
    }
    public Patient(String uuid, String name, String symptoms) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
    }

    public Patient(String uuid, String name, String symptoms, String diagnosis) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;

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

    public String getDiagnosis() {
        return diagnosis;
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

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(uuid, patient.uuid) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(symptoms, patient.symptoms) &&
                Objects.equals(diagnosis, patient.diagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, symptoms, diagnosis);
    }
}
