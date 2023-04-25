package com.ty.power_chart_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.power_chart_app.dto.Prescription;
import com.ty.power_chart_app.repository.PrescriptionRepository;

@Repository
public class PrescriptionDao {

	@Autowired
	private PrescriptionRepository prescriptionRepository;

	public Prescription savePrescription(Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}

	public Prescription getPrescriptionById(int id) {
		Optional<Prescription> optional = prescriptionRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean deletePrescriptionById(int id) {
		Optional<Prescription> optional = prescriptionRepository.findById(id);
		if (optional.isPresent()) {
			prescriptionRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}
}
