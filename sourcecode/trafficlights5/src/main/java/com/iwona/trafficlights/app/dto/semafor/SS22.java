package com.iwona.trafficlights.app.dto.semafor;

import org.springframework.stereotype.Component;

@Component
public class SS22 extends Semafor {

	private final SemaforType semaforType = SemaforType.SIDE_STREET;
	private final String semaforName = "S22";

	@Override
	SemaforType getSemaforType() {
		return semaforType;
	}

	@Override
	String getSemaforName() {
		return semaforName;
	}

}
