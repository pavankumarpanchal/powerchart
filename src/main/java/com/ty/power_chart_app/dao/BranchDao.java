package com.ty.power_chart_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.power_chart_app.dto.Branch;
import com.ty.power_chart_app.repository.BranchRepository;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepository branchRepository;

	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch findBranchById(int id) {
		Optional<Branch> branch = branchRepository.findById(id);
		if (branch.isPresent()) {
			return branch.get();
		} else {
			return null;
		}
	}

	public boolean deleteBranchById(int id) {
		Optional<Branch> branch = branchRepository.findById(id);
		if (branch.isPresent()) {
			branchRepository.delete(branch.get());
			return true;
		} else {
			return false;
		}
	}
}
