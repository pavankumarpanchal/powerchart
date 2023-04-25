package com.ty.power_chart_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.power_chart_app.dao.BranchDao;
import com.ty.power_chart_app.dto.Branch;
import com.ty.power_chart_app.dto.ResponseStructure;
import com.ty.power_chart_app.exception.IdNotFoundException;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> findBranchById(int id) {
		Branch branch = branchDao.findBranchById(id);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		if (branch != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(branch);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<String>> deleteBranchById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		if (branchDao.deleteBranchById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(null);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch) {

		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch1 = branchDao.findBranchById(branch.getId());
		if (branch1 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(branchDao.saveBranch(branch));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}

	}
}
