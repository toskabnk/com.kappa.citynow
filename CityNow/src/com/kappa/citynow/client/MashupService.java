package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.kappa.citynow.shared.domain.eventful.EventSearch;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;
import com.kappa.citynow.shared.domain.openweather.WeatherSearch;

@RemoteServiceRelativePath("mashup")
public interface MashupService extends RemoteService {	
	//EventFul
	EventSearch getEvents(Double latidud, Double longitud);
	//EventBrite
	//EventBriteSearch getEventsBrite(Double latitud, Double longitud);
	//Tiempo
	WeatherSearch getWeather(Double latitud, Double longitud);
	//Fotos
	PhotoSearch getPhotoFlickr(String city);
	
}
