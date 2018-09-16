package com.iwona.trafficlights.app.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.iwona.trafficlights.app.dto.semafor.SM11;
import com.iwona.trafficlights.app.dto.semafor.SM12;
import com.iwona.trafficlights.app.dto.semafor.SS21;
import com.iwona.trafficlights.app.dto.semafor.SS22;
import com.iwona.trafficlights.app.dto.semafor.Semafor;

@Configuration
@EnableScheduling
public class SemaforVisitor implements SemaforWatch {

	private static final Logger LOGGER = LogManager.getLogger(SemaforVisitor.class);

	private final SM11 sm11;
	private final SM12 sm12;
	private final SS21 ss21;
	private final SS22 ss22;


	public SemaforVisitor(SM11 sm11,
			SM12 sm12, SS21 ss21, SS22 ss22) {
		super();
		this.sm11 = sm11;
		this.sm12 = sm12;
		this.ss21 = ss21;
		this.ss22 = ss22;
	}

	@Scheduled(cron = "${scheduler.semafor.visitor.cron}")
	public void watchSemaforStatus() {
		LOGGER.info(
				"Semafors watch:\t" + visit(sm11) + "\t" + visit(sm12) + "\t" + visit(ss21) + "\t"
						+ visit(ss22));
	}

	@Override
	public String visit(Semafor semafor) {
		return semafor.getNameWithColour();
	}

}
