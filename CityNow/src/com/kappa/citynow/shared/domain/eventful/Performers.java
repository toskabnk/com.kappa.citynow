
package com.kappa.citynow.shared.domain.eventful;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Performers implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Performer performer;

 	public Performer getPerformer(){
		return this.performer;
	}
	public void setPerformer(Performer performer){
		this.performer = performer;
	}
}
