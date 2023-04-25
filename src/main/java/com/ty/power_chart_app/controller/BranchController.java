package com.ty.power_chart_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.power_chart_app.dto.Branch;
import com.ty.power_chart_app.dto.ResponseStructure;
import com.ty.power_chart_app.service.BranchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/branches")
public class BranchController  {

	@Autowired
	private BranchService branchService;

	@ApiOperation(value = "save Branch", notes = "input is Branch obj and return Branch obj with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@ApiOperation(value = "get Branch by id", notes = "input is id of the branch and return branch obj with id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Branch>> findBranchById(@PathVariable int id) {
		return branchService.findBranchById(id);
	}

	@ApiOperation(value = "delete branch", notes = "input is id of the branch and output is string")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteBranchById(@PathVariable int id) {
		return branchService.deleteBranchById(id);
	}

	@ApiOperation(value = "Update Branch", notes = "input is Branch obj and return Branch obj with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch) {
		return branchService.updateBranch(branch);
	}
}
