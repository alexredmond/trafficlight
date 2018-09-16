package com.iwona.trafficlights.app.dto.semafor;

public enum SemaforType {

	MAIN_STREET(Integer.valueOf(1)), 
	SIDE_STREET(Integer.valueOf(2));

	private Integer semaforTypeId;

	SemaforType(Integer semaforTypeId) {
		this.semaforTypeId = semaforTypeId;
	}

	public Integer getId() {
		return semaforTypeId;
	}

}
