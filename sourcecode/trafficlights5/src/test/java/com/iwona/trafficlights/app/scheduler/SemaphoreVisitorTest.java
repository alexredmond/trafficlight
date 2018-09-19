package com.iwona.trafficlights.app.scheduler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.iwona.trafficlights.app.dto.configuration.CurrentProgramSetUp;
import com.iwona.trafficlights.app.dto.configuration.ProgramConfiguration;
import com.iwona.trafficlights.app.dto.semaphore.SM11;
import com.iwona.trafficlights.app.dto.semaphore.SM12;
import com.iwona.trafficlights.app.dto.semaphore.SS21;
import com.iwona.trafficlights.app.dto.semaphore.SS22;
import com.iwona.trafficlights.app.entity.program.Program;

public class SemaphoreVisitorTest {


	private SemaphoreVisitor semaphoreVisitor;
	private final SM11 sm11 = new SM11();
	private final SM12 sm12= new SM12();
	private final SS21 ss21= new SS21();
	private final SS22 ss22= new SS22();

	@Before
	public void setUp() {
		semaphoreVisitor = new SemaphoreVisitor(sm11, sm12, ss21, ss22);
	}

	@Test
	public void testVisit() {
		assertEquals("M11 : BLA",	semaphoreVisitor.visit(sm11));
		assertEquals("M12 : BLA",	semaphoreVisitor.visit(sm12));
		assertEquals("S21 : BLA",	semaphoreVisitor.visit(ss21));
		assertEquals("S22 : BLA",	semaphoreVisitor.visit(ss22));
	}

}
