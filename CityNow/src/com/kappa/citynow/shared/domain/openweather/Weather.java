
package com.kappa.citynow.shared.domain.openweather;

import java.io.Serializable;

public class Weather implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = -7798078467199669788L;
	private String description;
   	private String icon;
   	private Number id;
   	private String main;

 	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
 	public String getIcon(){
		return this.icon;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public String getMain(){
		return this.main;
	}
	public void setMain(String main){
		this.main = main;
	}
}
