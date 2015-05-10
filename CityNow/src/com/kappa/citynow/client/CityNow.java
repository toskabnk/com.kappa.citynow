package com.kappa.citynow.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.maps.gwt.client.Geocoder;
import com.google.maps.gwt.client.GeocoderRequest;
import com.google.maps.gwt.client.GeocoderResult;
import com.google.maps.gwt.client.GeocoderStatus;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;
import com.google.maps.gwt.client.Geocoder.Callback;
import com.kappa.citynow.shared.domain.eventful.Event;
import com.kappa.citynow.shared.domain.eventful.EventSearch;
import com.kappa.citynow.shared.domain.flickr.Photo;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;
import com.kappa.citynow.shared.domain.openweather.Weather;
import com.kappa.citynow.shared.domain.openweather.WeatherSearch;

public class CityNow implements EntryPoint {
	
	//Creamos el servicio de llamada al servidor
	private final MashupServiceAsync mashupService = GWT
			.create(MashupService.class);

	
	//Panel para los botones
	private HorizontalPanel searchPanel= new HorizontalPanel();
	private Label statusLabel = new Label();
	private static GoogleMap map;
	
	//Metodo EntryPoint
	public void onModuleLoad() {
		
		//Creamos los botones y el cuadro de texto
		final Button searchButton= new Button("Search");
		final TextBox searchBox = new TextBox();
		
		
		
		//Los añadimos al panel
		searchPanel.add(searchButton);
		searchPanel.add(searchBox);
		searchPanel.add(statusLabel);
		
		//Seteamos el focus en el cuadro de texto
		searchBox.setText("City");
		searchBox.setFocus(true);
		searchBox.selectAll();
	
		//Y lo añadimos al RootPanel
		RootPanel.get("searchPanelContainer").add(searchPanel);
		
		//Añadimos un evento al clickar el boton
		searchButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				statusLabel.setText("My monkeys are searching...");
				//Metodo para limpiar los paneles que muestran el tiempo, etc...
				limpiarPaneles();
				final String city = searchBox.getText();
				//La llamada a los metodos se hace por separado, mas que nada para tener un poco de orden
				getEvents(city);
				getWeather(city);
				getPhotos(city);
				showMap();
				showAddress(city);
			}
		});
		
	}
	
	private void limpiarPaneles(){
		RootPanel.get("weather").clear();
		RootPanel.get("eventful").clear();
		RootPanel.get("flickr").clear();
	}
	
	//M
	private void getEvents(String city){
		final String cityFinal = city;
		mashupService.getEvents(city, new AsyncCallback<EventSearch>() {
			public void onSuccess(EventSearch result) {
				statusLabel.setText("");
				showEvents(cityFinal, result);
			}
			
			public void onFailure(Throwable caught) {
				
			}
		});
	}
	
	private void getWeather(String city){
		final String cityFinal = city;
		mashupService.getWeather(cityFinal, new AsyncCallback<WeatherSearch>() {
			public void onSuccess(WeatherSearch result) {
				statusLabel.setText("");
				showWeather(cityFinal, result);
			}
			
			public void onFailure(Throwable caught) {
				
			}
		});
	}
	
	private void getPhotos(String city){
		final String cityFinal = city;
		mashupService.getPhotoFlickr(cityFinal, new AsyncCallback<PhotoSearch>() {
			public void onSuccess(PhotoSearch result) {
				statusLabel.setText("");
				showFotos(cityFinal, result);
			}
			
			public void onFailure(Throwable caught) {
				
			}
		});
	}
	
	private void showEvents(String city, EventSearch result){
		String output="<fieldset>";
		output+= "<legend>"+city+" events</legend>";
		if(result!=null){
			if(result.getEvents()!=null){
			for(Event event:result.getEvents().getEvent()){
				if(event.getImage()!=null){
					output+="<img src='"+event.getImage().getUrl()+"'/>"+event.getTitle()+event.getDescription();
				}
				
				else{
					output+=event.getTitle()+event.getDescription();

				}
			}
		}
			
		else{
				output="<span> No results </span>";
			}
		}
		else{
			output="<span> No results </span>";
		}
		output+="</fieldset>";
		HTML eventos = new HTML(output);
		
		RootPanel.get("eventful").add(eventos);
	}
	
	private void showWeather(String weather, WeatherSearch result){
		String output="<fieldset>";
		output+= "<legend>"+weather+" weather</legend>";
		if(result!=null){
			for(Weather tiempo:result.getWeather()){
				output+=tiempo.getDescription()+"<img src='http://openweathermap.org/img/w/"+tiempo.getIcon()+".png'/>";
			}
		}
		else{
			output="<span> No results </span>";
		}
		output+="</fieldset>";
		HTML eventos = new HTML(output);
		
		RootPanel.get("weather").add(eventos);
	}
	
	private void showFotos(String city, PhotoSearch result) {

		String output="<fieldset>";
		output += "<legend>" + city +" photos</legend>";
        if (result != null) {
        	for (Photo p: result.getPhotos().getPhoto()) {
        		output +="<img src='http://farm"+p.getFarm()+".staticflickr.com/"+p.getServer()+"/"+p.getId()+"_"+p.getSecret()+".jpg'/>";
        	}
        }else
        	output="<span> No results </span>";
	
        output +="</fieldset>";
        
        HTML fotos = new HTML(output);
        
        RootPanel.get("flickr").add(fotos);
	}
	
	/*private void showMap(Double lat, Double lonng){
		LatLng ciudad = LatLng.create(40.4404917 , -3.68981665  );
		MapOptions myOptions = MapOptions.create();
		myOptions.setZoom(8.0);
		myOptions.setCenter(ciudad);
		myOptions.setMapTypeId(MapTypeId.SATELLITE);
		
		
		/* MapTypeControlOptions myControlOptions = MapTypeControlOptions.create();
		myControlOptions.setStyle(MapTypeControlStyle.HORIZONTAL_BAR);
		myOptions.setMapTypeControlOptions(myControlOptions);
		
		myOptions.setZoomControl(true);
		com.google.maps.gwt.client.ZoomControlOptions myZoomOptions = 	com.google.maps.gwt.client.ZoomControlOptions.create();
		myZoomOptions.setStyle(ZoomControlStyle.LARGE);
		myOptions.setZoomControlOptions(myZoomOptions); *
		
		map=GoogleMap.create(Document.get().getElementById("map_canvas"), myOptions);
		
	}
*/
	
	public static void showMap() {
		/** TODO: Mostrar mapa */
		LatLng myLtLng= LatLng.create(37.25819, -5.98637);
		MapOptions myOptions=MapOptions.create();
		myOptions.setZoom(8.0);
		myOptions.setCenter(myLtLng);
		myOptions.setMapTypeId(MapTypeId.ROADMAP);
		map=GoogleMap.create(Document.get().getElementById("map_canvas"),myOptions);
	}
	
	private static void showAddress(String city) {
		/** TODO: Mostrar marcador en la dirección indicada por el usuario */
		Geocoder geocoder= Geocoder.create();
		
		GeocoderRequest request= GeocoderRequest.create();
		request.setAddress(city);
		geocoder.geocode(request, new Callback(){
			public void handle (JsArray<GeocoderResult>results,GeocoderStatus status){
				if(status==GeocoderStatus.OK){
					GeocoderResult location=results.get(0);
					map.setCenter(location.getGeometry().getLocation());
				}else{
					Window.alert("Geocode was not succesful for the following reason: "+status);
				}
			}
		});
	}

}
