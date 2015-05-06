
package com.kappa.citynow.shared.domain.eventful;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Performer implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = -8083534024161298782L;
	/**
	 * 
	 */
	private String creator;
   	private String id;
   	private String linker;
   	private String name;
   	private String short_bio;
   	private String url;

 	public String getCreator(){
		return this.creator;
	}
	public void setCreator(String creator){
		this.creator = creator;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public String getLinker(){
		return this.linker;
	}
	public void setLinker(String linker){
		this.linker = linker;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getShort_bio(){
		return this.short_bio;
	}
	public void setShort_bio(String short_bio){
		this.short_bio = short_bio;
	}
 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
}
