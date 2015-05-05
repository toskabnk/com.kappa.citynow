package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.kappa.citynow.shared.domain.openweather.WeatherSearch;

public interface MashupServiceAsync {

	void getWeather(String weather, AsyncCallback<WeatherSearch> callback);

}
