package com.kappa.citynow.shared.domain.flickr;

import java.io.Serializable;


public class PhotoSearch implements Serializable{
	   	/**
		 * 
		 */
		private static final long serialVersionUID = 894616618036337342L;
		private Photos photos;
	   	private String stat;

	 	public Photos getPhotos(){
			return this.photos;
		}
		public void setPhotos(Photos photos){
			this.photos = photos;
		}
	 	public String getStat(){
			return this.stat;
		}
		public void setStat(String stat){
			this.stat = stat;
		}
	}

