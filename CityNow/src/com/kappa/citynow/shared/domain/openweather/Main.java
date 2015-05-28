
package com.kappa.citynow.shared.domain.openweather;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Main implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 9149078818380575316L;
	private Number grnd_level;
   	private Number humidity;
   	private Number pressure;
   	private Number sea_level;
   	private Number temp;
   	private Number temp_max;
   	private Number temp_min;

 	public Number getGrnd_level(){
		return this.grnd_level;
	}
	public void setGrnd_level(Number grnd_level){
		this.grnd_level = grnd_level;
	}
 	public Number getHumidity(){
		return this.humidity;
	}
	public void setHumidity(Number humidity){
		this.humidity = humidity;
	}
 	public Number getPressure(){
		return this.pressure;
	}
	public void setPressure(Number pressure){
		this.pressure = pressure;
	}
 	public Number getSea_level(){
		return this.sea_level;
	}
	public void setSea_level(Number sea_level){
		this.sea_level = sea_level;
	}
 	public Number getTemp(){
		return this.temp;
	}
	public void setTemp(Number temp){
		this.temp = temp;
	}
 	public Number getTemp_max(){
		return this.temp_max;
	}
	public void setTemp_max(Number temp_max){
		this.temp_max = temp_max;
	}
 	public Number getTemp_min(){
		return this.temp_min;
	}
	public void setTemp_min(Number temp_min){
		this.temp_min = temp_min;
	}
}
