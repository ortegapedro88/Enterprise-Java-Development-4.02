package com.hospital.demo.controllers;

import com.hospital.demo.enums.Status;
import com.hospital.demo.models.Doctor;
import com.hospital.demo.models.Patient;
import com.hospital.demo.repositories.DoctorRepository;
import com.hospital.demo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class Controller {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;


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

    @GetMapping("doctor/status/{status}")
    public List<Doctor> findDoctorByStatus(@PathVariable Status status){

            return doctorRepository.findByStatus(status);

    }


    @GetMapping("patient/find-By-Date/")
    public List<Patient> findByDateOfBirth(@RequestParam Date min, @RequestParam Date max){
        return patientRepository.findByBirthDateBetween(min,max);
    }

    @GetMapping("/patient/all")
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @GetMapping("patient/find-all-department/{department}")
    public List<Patient> getAllPatientByDepartment(@PathVariable String department){
        return patientRepository.findAllPatientByDepartment(department);
    }

@GetMapping("patient/find-all-status/off")
    public List<Patient> getAllPatientByStatusOff(){
    ArrayList<Patient> result = new ArrayList<>();
        for(Patient patient : patientRepository.findAll()){
            if(patient.getAdmittedBy().getStatus().equals(Status.OFF)){
                result.add(patient);
            }
        }return result;
}


}