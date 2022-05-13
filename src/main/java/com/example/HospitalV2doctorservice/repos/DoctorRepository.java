package com.example.HospitalV2doctorservice.repos;


import com.example.HospitalV2doctorservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,String> {
}
