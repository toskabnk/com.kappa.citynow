
package com.kappa.citynow.shared.domain.openweather;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Clouds implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = -6186665797430497898L;
	private Number all;

 	public Number getAll(){
		return this.all;
	}
	public void setAll(Number all){
		this.all = all;
	}
}
