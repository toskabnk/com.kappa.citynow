package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.kappa.citynow.shared.domain.eventful.EventSearch;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;
import com.kappa.citynow.shared.domain.openweather.WeatherSearch;

@RemoteServiceRelativePath("mashup")
public interface MashupService extends RemoteService {	
	//EventFul
	EventSearch getEvents(String city);
	//Tiempo
	WeatherSearch getWeather(String city);
	//Fotos
	PhotoSearch getPhotoFlickr(String city);
	
}
