package com.ty.power_chart_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.power_chart_app.dto.Encounter;
import com.ty.power_chart_app.dto.ResponseStructure;
import com.ty.power_chart_app.service.EncounterService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/encounters")
public class EncounterController {

	@Autowired
	private EncounterService encounterService;
	
	@ApiOperation(value = "save Encounter", notes = "input is Encounter obj and return Encounter obj with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
	produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Encounter>> saveEnounter(@RequestBody Encounter encounter){
		return encounterService.saveEnounter(encounter);
	}
}
