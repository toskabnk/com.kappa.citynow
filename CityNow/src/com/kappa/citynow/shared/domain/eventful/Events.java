
package com.kappa.citynow.shared.domain.eventful;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Events implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Event> event;

 	public List<Event> getEvent(){
		return this.event;
	}
	public void setEvent(List<Event> event){
		this.event = event;
	}
}
