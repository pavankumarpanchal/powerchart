package com.ty.power_chart_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.power_chart_app.dao.EncounterDao;
import com.ty.power_chart_app.dto.Encounter;
import com.ty.power_chart_app.dto.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	EncounterDao encounterDao;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEnounter(Encounter encounter){
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>(); 
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(encounterDao.saveEnounter(encounter));
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		}
	}

