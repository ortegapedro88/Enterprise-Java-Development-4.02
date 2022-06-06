package com.hospital.demo.controllers;

import com.hospital.demo.models.Doctor;
import com.hospital.demo.models.Patient;
import com.hospital.demo.repositories.DoctorRepository;
//import com.hospital.demo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class Controller {
    @Autowired
    DoctorRepository doctorRepository;
   // PatientRepository patientRepository;


    @GetMapping("/doctor/all")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctor/id/{id}")
    public Doctor getById(@PathVariable long id) {
        if (doctorRepository.findById(id).isPresent()) {
            return doctorRepository.findById(id).get();
        } else return null;
    }

    @GetMapping("/doctor/department/{department}")
    public List<Doctor> getByDepartment(@PathVariable String department) {
        return doctorRepository.findByDepartment(department);
    }

  /*
    @GetMapping("/patient/all")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
   */

   /* @GetMapping("/patients/id/{id}")
    public Patients getByPatientId(@PathVariable long id) {
        if (doctorsRepository.findById(id).isPresent()) {
              return patientsRepository.findById(id).get();
             }else return ;
        }
    }*/
}