package com.iwona.trafficlights.config.startupinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iwona.trafficlights.app.dto.semafor.SM11;
import com.iwona.trafficlights.app.dto.semafor.SM12;
import com.iwona.trafficlights.app.dto.semafor.SS21;
import com.iwona.trafficlights.app.dto.semafor.SS22;
import com.iwona.trafficlights.app.manager.LightManager;

@Component
public class SemaforRegistry {

	private final LightManager lightManager;
	private final SM11 sm11;
	private final SM12 sm12;
	private final SS21 ss21;
	private final SS22 ss22;

	@Autowired
	public SemaforRegistry(LightManager lightManager, SM11 sm11, SM12 sm12, SS21 ss21, SS22 ss22) {
		super();
		this.lightManager = lightManager;
		this.sm11 = sm11;
		this.sm12 = sm12;
		this.ss21 = ss21;
		this.ss22 = ss22;
	}

	public void registerSemafors() {
		lightManager.addPropertyChangeListener(sm11);
		lightManager.addPropertyChangeListener(sm12);
		lightManager.addPropertyChangeListener(ss21);
		lightManager.addPropertyChangeListener(ss22);
	}

}
