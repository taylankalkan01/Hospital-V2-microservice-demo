package com.example.HospitalV2doctorservice.service;

import com.example.HospitalV2doctorservice.dto.CreateDoctorRequest;
import com.example.HospitalV2doctorservice.dto.DoctorDto;
import com.example.HospitalV2doctorservice.dto.DoctorDtoConverter;
import com.example.HospitalV2doctorservice.dto.UpdateDoctorRequest;
import com.example.HospitalV2doctorservice.exception.DoctorNotFoundException;
import com.example.HospitalV2doctorservice.model.Doctor;
import com.example.HospitalV2doctorservice.repos.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorDtoConverter doctorDtoConverter;

    public DoctorService(DoctorRepository doctorRepository, DoctorDtoConverter doctorDtoConverter) {
        this.doctorRepository = doctorRepository;
        this.doctorDtoConverter = doctorDtoConverter;
    }


    public DoctorDto createDoctor(CreateDoctorRequest createDoctorRequest) {
        Doctor doctor = new Doctor();
        doctor.setId(createDoctorRequest.getId());
        doctor.setName(createDoctorRequest.getName());
        doctor.setDepartment(createDoctorRequest.getDepartment());
        doctor.setNamePrefix(createDoctorRequest.getNamePrefix());
        doctor.setDateOfStart(createDoctorRequest.getDateOfStart());
        doctor.setDateOfGraduate(createDoctorRequest.getDateOfGraduate());

        doctorRepository.save(doctor);
        return doctorDtoConverter.converter(doctor);
    }


    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorDtoConverter::converter)
                .collect(Collectors.toList());
    }

    public DoctorDto getDoctorById(String id) {
        return doctorRepository.findById(id)
                .map(doctorDtoConverter::converter)
                .orElseThrow(()->new DoctorNotFoundException("Doctor not found!"));
    }

    public DoctorDto updateDoctor(String id, UpdateDoctorRequest updateDoctorRequest) {
        Optional<Doctor> doctorOptional= doctorRepository.findById(id);
        doctorOptional.ifPresent(doctor -> {
            doctor.setName(updateDoctorRequest.getName());
            doctor.setNamePrefix(updateDoctorRequest.getNamePrefix());
            doctor.setDepartment(updateDoctorRequest.getDepartment());
            doctor.setDateOfGraduate(updateDoctorRequest.getDateOfGraduate());
            doctor.setDateOfStart(updateDoctorRequest.getDateOfStart());
        });
        return doctorOptional.map(doctorDtoConverter::converter)
                .orElseThrow(()->new DoctorNotFoundException("Doctor not found!"));
    }

    public void deleteDoctor(String id) {
        doctorRepository.findById(id).orElseThrow(()->new DoctorNotFoundException("Doctor not found!"));
        doctorRepository.deleteById(id);
    }
}

