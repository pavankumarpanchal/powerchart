package com.ty.power_chart_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.power_chart_app.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
