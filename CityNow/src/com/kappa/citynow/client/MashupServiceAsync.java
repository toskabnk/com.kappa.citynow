package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.kappa.citynow.shared.domain.eventful.EventSearch;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;
import com.kappa.citynow.shared.domain.openweather.WeatherSearch;

public interface MashupServiceAsync {

	void getEvents(String city, AsyncCallback<EventSearch> callback);

	void getWeather(String city, AsyncCallback<WeatherSearch> callback);

	void getPhotoFlickr(String city, AsyncCallback<PhotoSearch> callback);

}
