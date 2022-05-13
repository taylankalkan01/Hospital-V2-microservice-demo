package com.example.HospitalV2doctorservice.controller;


import com.example.HospitalV2doctorservice.dto.CreateDoctorRequest;
import com.example.HospitalV2doctorservice.dto.DoctorDto;
import com.example.HospitalV2doctorservice.dto.UpdateDoctorRequest;
import com.example.HospitalV2doctorservice.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/doctor")
public class DoctorController {



    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody CreateDoctorRequest createDoctorRequest){
        return ResponseEntity.ok().body(doctorService.createDoctor(createDoctorRequest));
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        return ResponseEntity.ok().body(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable("id") String id){
        return ResponseEntity.ok().body(doctorService.getDoctorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable("id") String id,
                                                  @RequestBody UpdateDoctorRequest updateDoctorRequest){
        return ResponseEntity.ok().body(doctorService.updateDoctor(id,updateDoctorRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("id") String id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok().build();
    }
}

