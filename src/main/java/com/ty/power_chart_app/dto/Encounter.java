package com.ty.power_chart_app.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;
//	@CreationTimestamp
//	private LocalDateTime timeofadmission;

	@ManyToOne
	@JoinColumn
	private Patient patient;

	@ManyToOne
	@JoinColumn
	private Branch branch;

	@OneToMany(mappedBy = "encounter")
	@JsonIgnore
	private List<Prescription> prescription;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(List<Prescription> prescription) {
		this.prescription = prescription;
	}
//	public LocalDateTime getTimeofadmission() {
//		return timeofadmission;
//	}
//
//	public void setTimeofadmission(LocalDateTime timeofadmission) {
//		this.timeofadmission = timeofadmission;
//	}

}
