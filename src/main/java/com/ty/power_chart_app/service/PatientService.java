package com.ty.power_chart_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.power_chart_app.dao.PatientDao;
import com.ty.power_chart_app.dto.Patient;
import com.ty.power_chart_app.dto.ResponseStructure;
import com.ty.power_chart_app.exception.EmailNotFoundException;
import com.ty.power_chart_app.exception.IdNotFoundException;
import com.ty.power_chart_app.exception.PhoneNotFoundException;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;

	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient) {
		ResponseStructure<Patient> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(patientDao.savePatient(patient));
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Patient>> findPatientByPhone(long phone) {
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>();
		Patient patient = patientDao.findPatientByPhone(phone);
		if (patient != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(patient);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new PhoneNotFoundException("Phone Number Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Patient>> findPatientByEmail(String email) {
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>();
		Patient patient = patientDao.findPatientByEmail(email);
		if (patient != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(patient);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmailNotFoundException("Email Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Patient>> findPatientById(int id) {
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>();
		if (patientDao.findPatientById(id)!=null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(patientDao.findPatientById(id));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}
	
	public ResponseEntity<ResponseStructure<String>> deletePatientById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (patientDao.deletePatientById(id)) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}
}
