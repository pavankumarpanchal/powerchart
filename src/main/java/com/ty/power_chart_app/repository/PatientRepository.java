package com.ty.power_chart_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.power_chart_app.dto.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Optional<Patient> findByEmail(String email);

	Optional<Patient> findByPhone(long phone);
}
