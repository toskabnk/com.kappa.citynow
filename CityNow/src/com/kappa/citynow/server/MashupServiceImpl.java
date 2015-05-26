package com.kappa.citynow.server;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.restlet.resource.ClientResource;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.kappa.citynow.client.MashupService;
import com.kappa.citynow.shared.domain.eventful.EventSearch;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;
import com.kappa.citynow.shared.domain.openweather.WeatherSearch;

@RemoteServiceRelativePath("mashup")
public class MashupServiceImpl extends RemoteServiceServlet implements
		MashupService {
	
	//Serial
	private static final long serialVersionUID = -919722099361265127L;

	//APIKEYS
	
	private static final String EVENTFUL_API_KEY="hzN2JJ5PwTMfNfcx";
	private static final String FLICKR_API_KEY = "bcdc7a65f776350f829e8483df32bab2";
	
	//Eventos
	//TODO: Echar un vistazo a EventBrite
	public EventSearch getEvents(Double latitud, Double longitud) {
		
		ClientResource cr=null;
		
		cr = new ClientResource("http://api.eventful.com/json/events/search?&languages=spanish&app_key="+EVENTFUL_API_KEY+"&location="+latitud+","+longitud+"&date=Future");
		
		EventSearch res= cr.get(EventSearch.class);
		
		return res;
	}

	//Tiempo
	public WeatherSearch getWeather(Double latitud, Double longitud) {
		
		ClientResource cr=null;
		
		cr=new ClientResource("http://api.openweathermap.org/data/2.5/weather?lat="+latitud+"&lon="+longitud);
		
		WeatherSearch res= cr.get(WeatherSearch.class);
		
		return res;
	}
	
	//Fotos
	public PhotoSearch getPhotoFlickr(String city) {
		ClientResource cr = null;
	
		try {
			cr = new ClientResource("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key="+FLICKR_API_KEY+"&tags="+URLEncoder.encode(city, "UTF-8")+"&format=json&nojsoncallback=1");
		} 
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		PhotoSearch resultado = cr.get(PhotoSearch.class);

		return resultado;
}


}
