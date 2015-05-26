package com.kappa.citynow.shared.domain.flickr;

import java.io.Serializable;

public class Photo implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 3999580170107667261L;
	private Number farm;
   	private String id;
   	private Number isfamily;
   	private Number isfriend;
   	private Number ispublic;
   	private String owner;
   	private String secret;
   	private String server;
   	private String title;

 	public Number getFarm(){
		return this.farm;
	}
	public void setFarm(Number farm){
		this.farm = farm;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public Number getIsfamily(){
		return this.isfamily;
	}
	public void setIsfamily(Number isfamily){
		this.isfamily = isfamily;
	}
 	public Number getIsfriend(){
		return this.isfriend;
	}
	public void setIsfriend(Number isfriend){
		this.isfriend = isfriend;
	}
 	public Number getIspublic(){
		return this.ispublic;
	}
	public void setIspublic(Number ispublic){
		this.ispublic = ispublic;
	}
 	public String getOwner(){
		return this.owner;
	}
	public void setOwner(String owner){
		this.owner = owner;
	}
 	public String getSecret(){
		return this.secret;
	}
	public void setSecret(String secret){
		this.secret = secret;
	}
 	public String getServer(){
		return this.server;
	}
	public void setServer(String server){
		this.server = server;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}

}
