package com.example.HospitalV2doctorservice.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDoctorRequest extends BaseDoctorRequest {
    private String id;

}
