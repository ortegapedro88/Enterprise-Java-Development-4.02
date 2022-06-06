package com.hospital.demo.models;

import com.hospital.demo.enums.Status;

import javax.persistence.*;


import java.util.List;

@Entity
public class Doctor {
    @Id
    private long idEmployee;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany (mappedBy = "admittedBy")
    private List<Patient> patientsList;

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}