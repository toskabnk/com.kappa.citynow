package com.kappa.citynow.server;

import org.restlet.resource.ClientResource;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.kappa.citynow.client.MashupService;
import com.kappa.citynow.shared.domain.openweather.WeatherSearch;
@RemoteServiceRelativePath("mashup")
public class MashupServiceImpl extends RemoteServiceServlet implements MashupService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5652370101066230806L;

	public WeatherSearch getWeather(String weather) {
		ClientResource cr7=null;
		cr7=new ClientResource("http://api.openweathermap.org/data/2.5/weather?q="+weather);
		return cr7.get(WeatherSearch.class);
	}

}
