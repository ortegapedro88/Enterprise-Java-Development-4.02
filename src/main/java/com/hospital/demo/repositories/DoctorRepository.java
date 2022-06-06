package com.hospital.demo.repositories;


import com.hospital.demo.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    public List<Doctor> findByDepartment(String department);
}