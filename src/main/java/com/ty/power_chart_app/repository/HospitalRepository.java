package com.ty.power_chart_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.power_chart_app.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
