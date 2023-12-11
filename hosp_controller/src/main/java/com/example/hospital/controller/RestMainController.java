package com.example.hospital.controller;

import java.util.List;

import com.example.hospital.service.DoctorService;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.exception.DoctorException;
import com.example.hospital.exception.DoctorFieldInvalid;
import com.example.hospital.exception.DoctorNotExists;
import com.example.hospital.exception.PatientException;
import com.example.hospital.exception.PatientFieldInvalid;
import com.example.hospital.exception.PatientNotExists;
import com.example.hospital.modell.Doctor;
import com.example.hospital.modell.Patient;

@RestController
@RequestMapping("/api")
public class RestMainController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public List<Doctor> doctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("/doctors/{id}")
    public Doctor doctors(@PathVariable int id) throws DoctorNotExists {
        return doctorService.getDoctor(id);
    }

    @PostMapping("/api/doctors")
    public Doctor doctors(@RequestBody Doctor doctor) throws DoctorFieldInvalid, DoctorException {
        return doctorService.save(doctor);
    }

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> patients() {
        return patientService.getPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient patients(@PathVariable int id) throws PatientNotExists {
        return patientService.getPatient(id);
    }

    @PostMapping("/patients")
    public Patient patients(@RequestBody Patient patient) throws PatientFieldInvalid, PatientException {
        return patientService.save(patient);
    }
    
    @GetMapping("/patients/locality/{locality}")
    public List<Patient> findPatientsByLocality(@PathVariable String locality) {
    	return patientService.getPatientByLocality(locality);
    }
}
