package com.example.HospitalV2doctorservice;

import com.example.HospitalV2doctorservice.dto.CreateDoctorRequest;
import com.example.HospitalV2doctorservice.dto.DoctorDto;
import com.example.HospitalV2doctorservice.dto.UpdateDoctorRequest;
import com.example.HospitalV2doctorservice.model.Department;
import com.example.HospitalV2doctorservice.model.Doctor;
import com.example.HospitalV2doctorservice.model.NamePrefix;

import java.util.List;

public class TestSupport {

    public Doctor generateDoctor(){
        return new Doctor(
                "id","name", NamePrefix.PHD, Department.ORTHOPEDIC,2020,2020
        );
    }

    public DoctorDto generateDoctorDto(){
        return new DoctorDto(
                "id","name", NamePrefix.PHD, Department.ORTHOPEDIC,2020,2020
        );
    }

    public List<Doctor> generateDoctors(){
        Doctor doctor = generateDoctor();
        return List.of(doctor);
    }

    public List<DoctorDto> generateDoctorDtos(){
        DoctorDto doctorDto = generateDoctorDto();
        return List.of(doctorDto);
    }

    public CreateDoctorRequest generateCreateDoctorRequest(){
        return new CreateDoctorRequest(
                "id"
        );
    }

    public UpdateDoctorRequest generateUpdateDoctorRequest(){
        return new UpdateDoctorRequest();
    }

}
