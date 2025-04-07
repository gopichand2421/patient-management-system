package com.patientmanagement.patientservice.model;

import lombok.Data;

@Data
public class PatientDTO {

    private String patientName;
    private String email;
    private String address;
    private String phone;
}
