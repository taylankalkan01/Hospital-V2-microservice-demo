package com.example.HospitalV2doctorservice.dto;

import com.example.HospitalV2doctorservice.model.Department;
import com.example.HospitalV2doctorservice.model.NamePrefix;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseDoctorRequest {
    private String name;
    private NamePrefix namePrefix;
    private Department department;
    private Integer dateOfGraduate;
    private Integer dateOfStart;
}