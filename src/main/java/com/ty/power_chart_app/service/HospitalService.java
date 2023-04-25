package com.ty.power_chart_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.power_chart_app.dao.HospitalDao;
import com.ty.power_chart_app.dto.Hospital;
import com.ty.power_chart_app.dto.ResponseStructure;
import com.ty.power_chart_app.exception.IdNotFoundException;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(int id) {
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		Hospital hospital = hospitalDao.findHospitalById(id);
		if (hospital != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(hospital);
			return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		Hospital hospital1 = hospitalDao.findHospitalById(hospital.getId());
		if (hospital1 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(hospitalDao.saveHospital(hospital));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}
}
