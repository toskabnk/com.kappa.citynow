
package com.kappa.citynow.shared.domain.eventful;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Image implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String caption;
   	private String height;
   	private Medium medium;
   	private Small small;
   	private Thumb thumb;
   	private String url;
   	private String width;

 	public String getCaption(){
		return this.caption;
	}
	public void setCaption(String caption){
		this.caption = caption;
	}
 	public String getHeight(){
		return this.height;
	}
	public void setHeight(String height){
		this.height = height;
	}
 	public Medium getMedium(){
		return this.medium;
	}
	public void setMedium(Medium medium){
		this.medium = medium;
	}
 	public Small getSmall(){
		return this.small;
	}
	public void setSmall(Small small){
		this.small = small;
	}
 	public Thumb getThumb(){
		return this.thumb;
	}
	public void setThumb(Thumb thumb){
		this.thumb = thumb;
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
