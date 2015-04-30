
package com.kappa.citynow.shared.domain.eventful;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Thumb implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String height;
   	private String url;
   	private String width;

 	public String getHeight(){
		return this.height;
	}
	public void setHeight(String height){
		this.height = height;
	}
 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
 	public String getWidth(){
		return this.width;
	}
	public void setWidth(String width){
		this.width = width;
	}
}
