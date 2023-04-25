package com.ty.power_chart_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.power_chart_app.dto.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{

}
