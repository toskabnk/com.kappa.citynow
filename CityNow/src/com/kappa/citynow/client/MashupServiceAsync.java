package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.kappa.citynow.shared.domain.eventful.EventSearch;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;
import com.kappa.citynow.shared.domain.openweather.WeatherSearch;

public interface MashupServiceAsync {

	void getEvents(Double latidud, Double longitud,
			AsyncCallback<EventSearch> callback);

	void getWeather(Double latitud, Double longitud,
			AsyncCallback<WeatherSearch> callback);

	void getPhotoFlickr(String city, AsyncCallback<PhotoSearch> callback);

}
