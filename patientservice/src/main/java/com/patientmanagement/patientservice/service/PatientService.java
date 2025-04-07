package com.patientmanagement.patientservice.service;


import com.patientmanagement.patientservice.entities.Patient;
import com.patientmanagement.patientservice.model.PatientDTO;
import com.patientmanagement.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {


    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllpatients(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getPaitent(UUID uuid){
        return patientRepository.findById(uuid);
    }

    @Transactional
    public Patient savPatient(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setPatientName(patientDTO.getPatientName());
        patient.setPhone(patientDTO.getPhone());
        patient.setAddress(patientDTO.getAddress());
        patient.setEmail(patientDTO.getEmail());
        System.out.println(patient.toString());
        return patientRepository.save(patient);
    }

    public void deletePatient(UUID uuid){
        patientRepository.deleteById(uuid);
    }
}
