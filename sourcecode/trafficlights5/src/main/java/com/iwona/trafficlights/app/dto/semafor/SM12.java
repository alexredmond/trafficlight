package com.iwona.trafficlights.app.dto.semafor;

import org.springframework.stereotype.Component;

@Component
public class SM12 extends Semafor {

	private final SemaforType semaforType = SemaforType.MAIN_STREET;
	private final String semaforName = "M12";

	@Override
	SemaforType getSemaforType() {
		return semaforType;
	}

	@Override
	String getSemaforName() {
		return semaforName;
	}
	
}
