package com.ty.power_chart_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.power_chart_app.dto.Patient;
import com.ty.power_chart_app.repository.PatientRepository;

@Repository
public class PatientDao {

	@Autowired
	private PatientRepository patientRespository;

	public Patient savePatient(Patient patient) {
		return patientRespository.save(patient);
	}

	public Patient findPatientByPhone(long phone) {
		Optional<Patient> patient = patientRespository.findByPhone(phone);
		if (patient.isPresent()) {
			return patient.get();
		} else {
			return null;
		}
	}

	public Patient findPatientByEmail(String email) {
		Optional<Patient> patient = patientRespository.findByEmail(email);
		if (patient.isPresent()) {
			return patient.get();
		} else {
			return null;
		}
	}

	public boolean deletePatientById(int id) {
		Optional<Patient> patient = patientRespository.findById(id);
		if (patient.isPresent()) {
			patientRespository.delete(patient.get());
			return true;
		} else {
			return false;
		}

	}

	public Patient findPatientById(int id) {
		Optional<Patient> patient = patientRespository.findById(id);
		if (patient.isPresent()) {
			return patient.get();

		} else {
			return null;
		}

	}
}
