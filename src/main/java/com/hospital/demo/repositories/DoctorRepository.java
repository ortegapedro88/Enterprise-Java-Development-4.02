package com.hospital.demo.repositories;


import com.hospital.demo.enums.Status;
import com.hospital.demo.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    public List<Doctor> findByDepartment(String department);
    public Optional<Doctor> findById(Long id);
    public List<Doctor> findByStatus(Status status);
}