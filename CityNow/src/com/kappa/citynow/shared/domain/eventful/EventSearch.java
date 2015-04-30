
package com.kappa.citynow.shared.domain.eventful;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class EventSearch implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Events events;
   	private String first_item;
   	private String last_item;
   	private String page_count;
   	private String page_items;
   	private String page_number;
   	private String page_size;
   	private String search_time;
   	private String total_items;

 	public Events getEvents(){
		return this.events;
	}
	public void setEvents(Events events){
		this.events = events;
	}
 	public String getFirst_item(){
		return this.first_item;
	}
	public void setFirst_item(String first_item){
		this.first_item = first_item;
	}
 	public String getLast_item(){
		return this.last_item;
	}
	public void setLast_item(String last_item){
		this.last_item = last_item;
	}
 	public String getPage_count(){
		return this.page_count;
	}
	public void setPage_count(String page_count){
		this.page_count = page_count;
	}
 	public String getPage_items(){
		return this.page_items;
	}
	public void setPage_items(String page_items){
		this.page_items = page_items;
	}
 	public String getPage_number(){
		return this.page_number;
	}
	public void setPage_number(String page_number){
		this.page_number = page_number;
	}
 	public String getPage_size(){
		return this.page_size;
	}
	public void setPage_size(String page_size){
		this.page_size = page_size;
	}
 	public String getSearch_time(){
		return this.search_time;
	}
	public void setSearch_time(String search_time){
		this.search_time = search_time;
	}
 	public String getTotal_items(){
		return this.total_items;
	}
	public void setTotal_items(String total_items){
		this.total_items = total_items;
	}
}
