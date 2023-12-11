package com.example.hospital.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.hospital.modell.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
    Optional<Patient> findByNameAndLocalityAndBirthDate(String name, String locality, LocalDate birthDate);
    List<Patient> findByLocality(String locality);

    List<Patient> findByDoctorId(int doctorId);
}
