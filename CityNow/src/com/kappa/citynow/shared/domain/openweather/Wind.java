
package com.kappa.citynow.shared.domain.openweather;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)


public class Wind implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = -4377289407669899994L;
	private Number deg;
   	private Number speed;

 	public Number getDeg(){
		return this.deg;
	}
	public void setDeg(Number deg){
		this.deg = deg;
	}
 	public Number getSpeed(){
		return this.speed;
	}
	public void setSpeed(Number speed){
		this.speed = speed;
	}
}
