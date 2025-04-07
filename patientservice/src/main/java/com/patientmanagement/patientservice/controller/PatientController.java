package com.patientmanagement.patientservice.controller;


import com.patientmanagement.patientservice.entities.Patient;
import com.patientmanagement.patientservice.model.PatientDTO;
import com.patientmanagement.patientservice.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllpatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable UUID uuid){
        Optional<Patient> patient = patientService.getPaitent(uuid);
        return patient.map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Patient savePatient(@RequestBody PatientDTO patientDTO){
        return patientService.savPatient(patientDTO);
    }
}
