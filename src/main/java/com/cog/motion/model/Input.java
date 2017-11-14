package com.cog.motion.model;


public class Input {
	
	private Double initialVelocity;
	public Double getInitialVelocity() {
		return initialVelocity;
	}
	public void setInitialVelocity(Double initialVelocity) {
		this.initialVelocity = initialVelocity;
	}
	public Double getFinalVelocity() {
		return finalVelocity;
	}
	public void setFinalVelocity(Double finalVelocity) {
		this.finalVelocity = finalVelocity;
	}
	public Double getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(Double acceleration) {
		this.acceleration = acceleration;
	}
	public Double getTime() {
		return time;
	}
	public void setTime(Double time) {
		this.time = time;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	private Double finalVelocity;
	private Double acceleration;
	private Double time;
	private Double distance;
	

}
