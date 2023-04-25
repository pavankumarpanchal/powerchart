package com.ty.power_chart_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.power_chart_app.dao.PrescriptionDao;
import com.ty.power_chart_app.dto.Item;
import com.ty.power_chart_app.dto.Prescription;
import com.ty.power_chart_app.dto.ResponseStructure;
import com.ty.power_chart_app.exception.IdNotFoundException;

@Service
public class PrescriptionService {

	@Autowired 
	private PrescriptionDao prescriptionDao;

	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(Prescription prescription) {
		ResponseStructure<Prescription> responseStructure = new ResponseStructure<>();
		List<Item> items = prescription.getItem();
		int totalCost = 0;
		for (Item item : items) {
			totalCost += item.getCost() * item.getQuantity();
			item.setPrescription(prescription);
		}
		prescription.setTotalCost(totalCost);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("created");
		responseStructure.setData(prescriptionDao.savePrescription(prescription));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Prescription>> getPrescriptionById(int id) {
		ResponseStructure<Prescription> responseStructure = new ResponseStructure<>();
		Prescription prescription = prescriptionDao.getPrescriptionById(id);
		if (prescription != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(prescription);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<String>> deletePrescriptionById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		if (prescriptionDao.deletePrescriptionById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(null);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}
}
