package com.example.HospitalV2doctorservice.service;

import com.example.HospitalV2doctorservice.TestSupport;
import com.example.HospitalV2doctorservice.dto.CreateDoctorRequest;
import com.example.HospitalV2doctorservice.dto.DoctorDto;
import com.example.HospitalV2doctorservice.dto.DoctorDtoConverter;
import com.example.HospitalV2doctorservice.dto.UpdateDoctorRequest;
import com.example.HospitalV2doctorservice.exception.DoctorNotFoundException;
import com.example.HospitalV2doctorservice.model.Doctor;
import com.example.HospitalV2doctorservice.repos.DoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoctorServiceTest extends TestSupport {
    private DoctorService doctorService;

    private DoctorRepository doctorRepository;
    private DoctorDtoConverter doctorDtoConverter;

    @BeforeEach
    void setUp() {
        doctorDtoConverter = Mockito.mock(DoctorDtoConverter.class);
        doctorRepository = Mockito.mock(DoctorRepository.class);

        doctorService = new DoctorService(doctorRepository,doctorDtoConverter);
    }

    @Test
    void testCreateDoctor_whenCreateDoctorRequestIsValid_thenReturnDoctorDto(){
        CreateDoctorRequest createDoctorRequest = generateCreateDoctorRequest();
        Doctor doctor = generateDoctor();
        DoctorDto doctorDto = generateDoctorDto();

        Mockito.when(doctorRepository.save(doctor)).thenReturn(doctor);
        Mockito.when(doctorDtoConverter.converter(doctor)).thenReturn(doctorDto);

        DoctorDto result = doctorService.createDoctor(createDoctorRequest);

        assertEquals(doctorDto,result);

        Mockito.verify(doctorRepository).save(doctor);
        Mockito.verify(doctorDtoConverter).converter(doctor);
    }

    @Test
    void testGetAllDoctors_thenReturnDoctorDto(){
        Doctor doctor = generateDoctor();
        DoctorDto doctorDto = generateDoctorDto();
        List<Doctor> doctorList = generateDoctors();
        List<DoctorDto> doctorDtoList = generateDoctorDtos();

        Mockito.when(doctorRepository.findAll()).thenReturn(doctorList);
        Mockito.when(doctorDtoConverter.converter(doctor)).thenReturn(doctorDto);

        List<DoctorDto> result = doctorService.getAllDoctors();
        assertEquals(doctorDtoList,result);

        Mockito.verify(doctorRepository).findAll();
        Mockito.verify(doctorDtoConverter).converter(doctor);
    }

    @Test
    void testDoctorById_whenDoctorIdExist_thenReturnDoctorDto(){
        Doctor doctor = generateDoctor();
        DoctorDto doctorDto = generateDoctorDto();

        Mockito.when(doctorRepository.findById("id")).thenReturn(java.util.Optional.ofNullable(doctor));
        Mockito.when(doctorDtoConverter.converter(doctor)).thenReturn(doctorDto);

        DoctorDto result = doctorService.getDoctorById("id");
        assertEquals(doctorDto, result);

        Mockito.verify(doctorRepository).findById("id");
        Mockito.verify(doctorDtoConverter).converter(doctor);
    }

    @Test
    void testDoctorById_whenDoctorIdNotExist_thenThrowDoctorNotFoundException(){

        Mockito.when(doctorRepository.findById("id")).thenThrow(DoctorNotFoundException.class);

        assertThrows(DoctorNotFoundException.class, ()-> doctorService.getDoctorById("id"));
        Mockito.verify(doctorRepository).findById("id");
    }

    @Test
    void testUpdateDoctor_whenDoctorIdExist_thenReturnDoctorDto(){
        Doctor doctor = generateDoctor();
        DoctorDto doctorDto = generateDoctorDto();
        UpdateDoctorRequest updateDoctorRequest = generateUpdateDoctorRequest();

        Mockito.when(doctorRepository.findById("id")).thenReturn(java.util.Optional.ofNullable(doctor));
        Mockito.when(doctorRepository.save(doctor)).thenReturn(doctor);
        Mockito.when(doctorDtoConverter.converter(doctor)).thenReturn(doctorDto);

        DoctorDto result = doctorService.updateDoctor("id",updateDoctorRequest);
        assertEquals(doctorDto,result);

        Mockito.verify(doctorRepository).findById("id");
        Mockito.verify(doctorRepository).save(doctor);
        Mockito.verify(doctorDtoConverter).converter(doctor);

    }

    @Test
    void testUpdateDoctor_whenDoctorIdNotExists_thenThrowDoctorNotFoundException(){
        UpdateDoctorRequest updateDoctorRequest =generateUpdateDoctorRequest();

        Mockito.when(doctorRepository.findById("id")).thenThrow(DoctorNotFoundException.class);

        assertThrows(DoctorNotFoundException.class,()->doctorService.updateDoctor("id",updateDoctorRequest));

        Mockito.verify(doctorRepository).findById("id");
        Mockito.verifyNoInteractions(doctorDtoConverter);
    }

    @Test
    void testDeleteDoctor_whenDoctorIdExist_thenReturnVoid(){
        Doctor doctor = generateDoctor();

        Mockito.when(doctorRepository.findById("id")).thenReturn(java.util.Optional.ofNullable(doctor));

        doctorService.deleteDoctor("id");

        Mockito.verify(doctorRepository).deleteById("id");
    }

    @Test
    void testDeleteDoctor_whenDoctorIdNotExist_thenThrowDoctorNotFoundException(){

        Mockito.when(doctorRepository.findById("id")).thenThrow(DoctorNotFoundException.class);

        assertThrows(DoctorNotFoundException.class,()->doctorService.deleteDoctor("id"));

        Mockito.verify(doctorRepository).deleteById("id");
    }


}
