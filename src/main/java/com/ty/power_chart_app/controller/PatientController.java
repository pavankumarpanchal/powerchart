package com.ty.power_chart_app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.power_chart_app.dto.Patient;
import com.ty.power_chart_app.dto.ResponseStructure;
import com.ty.power_chart_app.service.PatientService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@ApiOperation(value = "save Patient", notes = "input is Patient obj and return Patient obj with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody @Valid Patient patient) {
		return patientService.savePatient(patient);
	}

	@ApiOperation(value = "Find Patient by phone number", notes = "input is phone number and return Patient obj with id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(value = "/phone/{phone}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Patient>> findPatientByPhone(@PathVariable long phone) {
		return patientService.findPatientByPhone(phone);
	}

	@ApiOperation(value = "Find Patient by Email", notes = "input is Email Id and return Patient obj")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(value = "/email/{email}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Patient>> findPatientByEmail(@PathVariable String email) {
		return patientService.findPatientByEmail(email);
	}

	@ApiOperation(value = "Find Patient", notes = "input is Patient id ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(value = "/id/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Patient>> findPatientById(@PathVariable int id) {
		return patientService.findPatientById(id);
	}
	
	@ApiOperation(value = "Delete Patient", notes = "input is Patient id ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfull"),
			@ApiResponse(code = 404, message = "Not Found") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deletePatientById(@PathVariable int id) {
		return patientService.deletePatientById(id);
	}
}
