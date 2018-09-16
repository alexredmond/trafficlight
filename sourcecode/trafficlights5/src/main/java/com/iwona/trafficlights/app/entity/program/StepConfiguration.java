package com.iwona.trafficlights.app.entity.program;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Entity
@Table(name = "STEP_CONFIG", schema = "GLOBOFORCE")
public class StepConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "STEP_ID")
	private Integer stepId;
	@Column(name = "SEMAFOR_TYPE_ID")
	private Integer semaforTypeId;
	@Column(name = "COLOUR_ID")
	private Integer colourId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	public Integer getSemaforTypeId() {
		return semaforTypeId;
	}

	public void setSemaforTypeId(Integer semaforTypeId) {
		this.semaforTypeId = semaforTypeId;
	}

	public Integer getColourId() {
		return colourId;
	}

	public void setColourId(Integer colourId) {
		this.colourId = colourId;
	}


	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

