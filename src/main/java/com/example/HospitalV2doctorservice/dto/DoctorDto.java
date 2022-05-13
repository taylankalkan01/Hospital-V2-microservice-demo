package com.example.HospitalV2doctorservice.dto;

import com.example.HospitalV2doctorservice.model.Department;
import com.example.HospitalV2doctorservice.model.NamePrefix;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class DoctorDto {
    private String id;
    private String name;
    private NamePrefix namePrefix;
    private Department department;
    private Integer dateOfGraduate;
    private Integer dateOfStart;
}
