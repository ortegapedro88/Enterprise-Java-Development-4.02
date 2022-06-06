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
}