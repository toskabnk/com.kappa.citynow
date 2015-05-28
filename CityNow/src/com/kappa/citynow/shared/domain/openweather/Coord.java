
package com.kappa.citynow.shared.domain.openweather;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Coord implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = -4217610511219307420L;
	private Number lat;
   	private Number lon;

 	public Number getLat(){
		return this.lat;
	}
	public void setLat(Number lat){
		this.lat = lat;
	}
 	public Number getLon(){
		return this.lon;
	}
	public void setLon(Number lon){
		this.lon = lon;
	}
}
