
package com.kappa.citynow.shared.domain.eventful;

import java.io.Serializable;

public class Event implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String all_day;
   	private String calendar_count;
   	private String calendars;
   	private String city_name;
   	private String comment_count;
   	private String country_abbr;
   	private String country_abbr2;
   	private String country_name;
   	private String created;
   	private String description;
   	private String geocode_type;
   	private String going;
   	private String going_count;
   	private String groups;
   	private String id;
   	private Image image;
   	private String latitude;
   	private String link_count;
   	private String longitude;
   	private String modified;
   	private String olson_path;
   	private String owner;
   	private Performers performers;
   	private String postal_code;
   	private String privacy;
   	private String recur_string;
   	private String region_abbr;
   	private String region_name;
   	private String start_time;
   	private String stop_time;
   	private String title;
   	private String tz_city;
   	private String tz_country;
   	private String tz_id;
   	private String tz_olson_path;
   	private String url;
   	private String venue_address;
   	private String venue_display;
   	private String venue_id;
   	private String venue_name;
   	private String venue_url;
   	private String watching_count;

 	public String getAll_day(){
		return this.all_day;
	}
	public void setAll_day(String all_day){
		this.all_day = all_day;
	}
 	public String getCalendar_count(){
		return this.calendar_count;
	}
	public void setCalendar_count(String calendar_count){
		this.calendar_count = calendar_count;
	}
 	public String getCalendars(){
		return this.calendars;
	}
	public void setCalendars(String calendars){
		this.calendars = calendars;
	}
 	public String getCity_name(){
		return this.city_name;
	}
	public void setCity_name(String city_name){
		this.city_name = city_name;
	}
 	public String getComment_count(){
		return this.comment_count;
	}
	public void setComment_count(String comment_count){
		this.comment_count = comment_count;
	}
 	public String getCountry_abbr(){
		return this.country_abbr;
	}
	public void setCountry_abbr(String country_abbr){
		this.country_abbr = country_abbr;
	}
 	public String getCountry_abbr2(){
		return this.country_abbr2;
	}
	public void setCountry_abbr2(String country_abbr2){
		this.country_abbr2 = country_abbr2;
	}
 	public String getCountry_name(){
		return this.country_name;
	}
	public void setCountry_name(String country_name){
		this.country_name = country_name;
	}
 	public String getCreated(){
		return this.created;
	}
	public void setCreated(String created){
		this.created = created;
	}
 	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
 	public String getGeocode_type(){
		return this.geocode_type;
	}
	public void setGeocode_type(String geocode_type){
		this.geocode_type = geocode_type;
	}
 	public String getGoing(){
		return this.going;
	}
	public void setGoing(String going){
		this.going = going;
	}
 	public String getGoing_count(){
		return this.going_count;
	}
	public void setGoing_count(String going_count){
		this.going_count = going_count;
	}
 	public String getGroups(){
		return this.groups;
	}
	public void setGroups(String groups){
		this.groups = groups;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public Image getImage(){
		return this.image;
	}
	public void setImage(Image image){
		this.image = image;
	}
 	public String getLatitude(){
		return this.latitude;
	}
	public void setLatitude(String latitude){
		this.latitude = latitude;
	}
 	public String getLink_count(){
		return this.link_count;
	}
	public void setLink_count(String link_count){
		this.link_count = link_count;
	}
 	public String getLongitude(){
		return this.longitude;
	}
	public void setLongitude(String longitude){
		this.longitude = longitude;
	}
 	public String getModified(){
		return this.modified;
	}
	public void setModified(String modified){
		this.modified = modified;
	}
 	public String getOlson_path(){
		return this.olson_path;
	}
	public void setOlson_path(String olson_path){
		this.olson_path = olson_path;
	}
 	public String getOwner(){
		return this.owner;
	}
	public void setOwner(String owner){
		this.owner = owner;
	}
 	public Performers getPerformers(){
		return this.performers;
	}
	public void setPerformers(Performers performers){
		this.performers = performers;
	}
 	public String getPostal_code(){
		return this.postal_code;
	}
	public void setPostal_code(String postal_code){
		this.postal_code = postal_code;
	}
 	public String getPrivacy(){
		return this.privacy;
	}
	public void setPrivacy(String privacy){
		this.privacy = privacy;
	}
 	public String getRecur_string(){
		return this.recur_string;
	}
	public void setRecur_string(String recur_string){
		this.recur_string = recur_string;
	}
 	public String getRegion_abbr(){
		return this.region_abbr;
	}
	public void setRegion_abbr(String region_abbr){
		this.region_abbr = region_abbr;
	}
 	public String getRegion_name(){
		return this.region_name;
	}
	public void setRegion_name(String region_name){
		this.region_name = region_name;
	}
 	public String getStart_time(){
		return this.start_time;
	}
	public void setStart_time(String start_time){
		this.start_time = start_time;
	}
 	public String getStop_time(){
		return this.stop_time;
	}
	public void setStop_time(String stop_time){
		this.stop_time = stop_time;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
 	public String getTz_city(){
		return this.tz_city;
	}
	public void setTz_city(String tz_city){
		this.tz_city = tz_city;
	}
 	public String getTz_country(){
		return this.tz_country;
	}
	public void setTz_country(String tz_country){
		this.tz_country = tz_country;
	}
 	public String getTz_id(){
		return this.tz_id;
	}
	public void setTz_id(String tz_id){
		this.tz_id = tz_id;
	}
 	public String getTz_olson_path(){
		return this.tz_olson_path;
	}
	public void setTz_olson_path(String tz_olson_path){
		this.tz_olson_path = tz_olson_path;
	}
 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
 	public String getVenue_address(){
		return this.venue_address;
	}
	public void setVenue_address(String venue_address){
		this.venue_address = venue_address;
	}
 	public String getVenue_display(){
		return this.venue_display;
	}
	public void setVenue_display(String venue_display){
		this.venue_display = venue_display;
	}
 	public String getVenue_id(){
		return this.venue_id;
	}
	public void setVenue_id(String venue_id){
		this.venue_id = venue_id;
	}
 	public String getVenue_name(){
		return this.venue_name;
	}
	public void setVenue_name(String venue_name){
		this.venue_name = venue_name;
	}
 	public String getVenue_url(){
		return this.venue_url;
	}
	public void setVenue_url(String venue_url){
		this.venue_url = venue_url;
	}
 	public String getWatching_count(){
		return this.watching_count;
	}
	public void setWatching_count(String watching_count){
		this.watching_count = watching_count;
	}
}
