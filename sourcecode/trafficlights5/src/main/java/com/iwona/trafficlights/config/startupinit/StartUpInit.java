package com.iwona.trafficlights.config.startupinit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iwona.trafficlights.app.dto.configuration.CurrentProgramSetUp;
import com.iwona.trafficlights.app.dto.configuration.ProgramConfiguration;
import com.iwona.trafficlights.app.manager.LightManager;
import com.iwona.trafficlights.app.service.ProgramService;

@Component
public class StartUpInit {

	private ProgramService programService;
	private ProgramConfiguration programConfiguration;
	private CurrentProgramSetUp currentProgramSetUp;
	private LightManager lightManager;
	private SemaforRegistry semaforRegistry;

	@Autowired
	public StartUpInit(ProgramService programService, ProgramConfiguration programConfiguration,
			CurrentProgramSetUp currentProgramSetUp, LightManager lightManager, SemaforRegistry semaforRegistry) {
		super();
		this.programService = programService;
		this.programConfiguration = programConfiguration;
		this.currentProgramSetUp = currentProgramSetUp;
		this.lightManager = lightManager;
		this.semaforRegistry = semaforRegistry;
	}

	@PostConstruct
	public void initializeConfiguration() {
		programConfiguration.setProgramList(programService.loadPrograms());
		programConfiguration.setProgramSchedule(programService.loadSchedule());
		currentProgramSetUp.setNextProgram(programConfiguration.getProgramById(Integer.valueOf(1)));
		currentProgramSetUp.setCurrentProgram(programConfiguration.getProgramById(Integer.valueOf(1)));
		semaforRegistry.registerSemafors();
		lightManager.manageLight();
	}

}
