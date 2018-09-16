package com.iwona.trafficlights.app.dto.semafor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.iwona.trafficlights.app.dto.colour.LightColour;
import com.iwona.trafficlights.app.scheduler.SemaforWatch;

public abstract class Semafor implements PropertyChangeListener {

	private static final Logger LOGGER = LogManager.getLogger(Semafor.class);

	private boolean red = false;
	private boolean yellow = false;
	private boolean green = false;

	public boolean isRed() {
		return red;
	}

	public void setRed(boolean red) {
		this.red = red;
	}

	public boolean isYellow() {
		return yellow;
	}

	public void setYellow(boolean yellow) {
		this.yellow = yellow;
	}

	public boolean isGreen() {
		return green;
	}

	public void setGreen(boolean green) {
		this.green = green;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		@SuppressWarnings("unchecked")
		Map<Integer, Integer> newStepConfigurationMap = (Map<Integer, Integer>) evt.getNewValue();
		Integer colourId = newStepConfigurationMap.get(getSemaforType().getId());
		populateLightColours(colourId);
		LOGGER.info("Applying colours " + getSemaforType().name() + "-" + getSemaforName() + ", " + toString());
	}

	abstract SemaforType getSemaforType();

	abstract String getSemaforName();

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public void accept(SemaforWatch v) {
		v.visit(this);
	}

	public String getNameWithColour() {
		return getSemaforName() + " : " + getColourName();
	}

	private void populateLightColours(Integer colourId) {
		if (LightColour.RED.getColourId().equals(colourId)) {
			this.red = true;
			this.yellow = false;
			this.green = false;
		} else if (LightColour.YELLOW.getColourId().equals(colourId)) {
			this.red = false;
			this.yellow = true;
			this.green = false;
		} else if (LightColour.GREEN.getColourId().equals(colourId)) {
			this.red = false;
			this.yellow = false;
			this.green = true;
		} else {
			this.red = false;
			this.yellow = false;
			this.green = false;
		}
	}

	private String getColourName() {
		if (red)
			return LightColour.RED.getShortName();
		if (yellow)
			return LightColour.YELLOW.getShortName();
		if (green)
			return LightColour.GREEN.getShortName();
		return LightColour.BLACK.getShortName();
	}

}
