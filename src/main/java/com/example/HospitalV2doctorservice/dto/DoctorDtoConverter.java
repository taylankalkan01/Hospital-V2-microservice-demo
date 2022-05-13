package com.example.HospitalV2doctorservice.dto;

import com.example.HospitalV2doctorservice.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorDtoConverter {

    public DoctorDto converter(Doctor doctor){
        return DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .namePrefix(doctor.getNamePrefix())
                .department(doctor.getDepartment())
                .dateOfGraduate(doctor.getDateOfGraduate())
                .dateOfStart(doctor.getDateOfStart())
                .build();
    }

}
