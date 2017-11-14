package com.cog.motion.model;

import java.math.BigDecimal;

public class LinearMotionModel {
	
	private BigDecimal initialVelocity;
	public BigDecimal getInitialVelocity() {
		return initialVelocity;
	}
	public void setInitialVelocity(BigDecimal initialVelocity) {
		this.initialVelocity = initialVelocity;
	}
	public BigDecimal getFinalVelocity() {
		return finalVelocity;
	}
	public void setFinalVelocity(BigDecimal finalVelocity) {
		this.finalVelocity = finalVelocity;
	}
	
	public BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	public BigDecimal getTime() {
		return time;
	}
	public void setTime(BigDecimal time) {
		this.time = time;
	}
	private BigDecimal finalVelocity;
	private BigDecimal acceleration;
	public BigDecimal getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(BigDecimal acceleration) {
		this.acceleration = acceleration;
	}
	private BigDecimal  distance;
	private BigDecimal time;
	
	

}
