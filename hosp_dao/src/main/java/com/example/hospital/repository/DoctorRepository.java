package com.example.hospital.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.hospital.modell.Doctor;
import com.example.hospital.modell.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
        Optional<Doctor> findByNameAndSealNumberAndSalaryAndBirthDateAndPositionAndSchedule(String name, int sealNumber, int salary, LocalDate birthDate, String position, Schedule schedule);
        List<Doctor> findByPosition(String position);
    }
