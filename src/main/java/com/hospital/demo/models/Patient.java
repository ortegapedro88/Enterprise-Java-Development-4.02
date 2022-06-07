package com.hospital.demo.models;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient {
    @Id
    private long patientId;
    private String name;
    private Date birthDate;
    @ManyToOne
    @JoinColumn(name= "admitted_by")
    private Doctor admittedBy;


    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Doctor getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Doctor admittedBy) {
        this.admittedBy = admittedBy;
    }
}