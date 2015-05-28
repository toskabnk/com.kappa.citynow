
package com.kappa.citynow.shared.domain.openweather;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Sys implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 5121690181514976696L;
	private String country;
   	private Number message;
   	private Number sunrise;
   	private Number sunset;

 	public String getCountry(){
		return this.country;
	}
	public void setCountry(String country){
		this.country = country;
	}
 	public Number getMessage(){
		return this.message;
	}
	public void setMessage(Number message){
		this.message = message;
	}
 	public Number getSunrise(){
		return this.sunrise;
	}
	public void setSunrise(Number sunrise){
		this.sunrise = sunrise;
	}
 	public Number getSunset(){
		return this.sunset;
	}
	public void setSunset(Number sunset){
		this.sunset = sunset;
	}
}
