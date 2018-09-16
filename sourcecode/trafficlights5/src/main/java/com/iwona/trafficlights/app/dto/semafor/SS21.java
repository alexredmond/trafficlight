package com.iwona.trafficlights.app.dto.semafor;

import org.springframework.stereotype.Component;

@Component
public class SS21 extends Semafor {

	private final SemaforType semaforType = SemaforType.SIDE_STREET;
	private final String semaforName = "S21";

	@Override
	SemaforType getSemaforType() {
		return semaforType;
	}

	@Override
	String getSemaforName() {
		return semaforName;
	}

}
