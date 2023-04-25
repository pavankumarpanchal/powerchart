package com.ty.power_chart_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.power_chart_app.dto.Encounter;
import com.ty.power_chart_app.repository.EncounterRepository;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepository encounterRepository;

	public Encounter saveEnounter(Encounter encounter) {
		return encounterRepository.save(encounter);
	}
}
