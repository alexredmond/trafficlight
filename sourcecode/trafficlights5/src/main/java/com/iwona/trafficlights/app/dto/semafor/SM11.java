package com.iwona.trafficlights.app.dto.semafor;

import org.springframework.stereotype.Component;

@Component
public class SM11 extends Semafor {

	private final SemaforType semaforType = SemaforType.MAIN_STREET;
	private final String semaforName = "M11";

	@Override
	SemaforType getSemaforType() {
		return semaforType;
	}

	@Override
	String getSemaforName() {
		return semaforName;
	}

}
