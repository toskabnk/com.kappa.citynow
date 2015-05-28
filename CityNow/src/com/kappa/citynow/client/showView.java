package com.kappa.citynow.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.maps.gwt.client.Geocoder;
import com.google.maps.gwt.client.Geocoder.Callback;
import com.google.maps.gwt.client.GeocoderRequest;
import com.google.maps.gwt.client.GeocoderResult;
import com.google.maps.gwt.client.GeocoderStatus;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.InfoWindow;
import com.google.maps.gwt.client.InfoWindowOptions;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;
import com.google.maps.gwt.client.Marker;
import com.google.maps.gwt.client.MarkerOptions;
import com.google.maps.gwt.client.MouseEvent;
import com.kappa.citynow.shared.domain.eventful.Event;
import com.kappa.citynow.shared.domain.eventful.EventSearch;
import com.kappa.citynow.shared.domain.flickr.Photo;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;
import com.kappa.citynow.shared.domain.openweather.Weather;
import com.kappa.citynow.shared.domain.openweather.WeatherSearch;




public class showView extends Composite {

	private DockLayoutPanel mainPanel = new DockLayoutPanel(Unit.PCT);
	private LayoutPanel main = new LayoutPanel();
	
	private static HorizontalPanel tiempo = new HorizontalPanel();
	private static ScrollPanel event = new ScrollPanel();
	private static FlowPanel mapa = new FlowPanel();
	private ScrollPanel fotos = new ScrollPanel();
	
	private final static MashupServiceAsync mashupService = GWT.create(MashupService.class);
	private static Label statusLabel = new Label();
	private static GoogleMap map;
	private final Button back= new Button("Return");
	private static Double[] latlon = {0.,0.};
	
	private VerticalPanel volver = new VerticalPanel();
	
	
	public showView(String city, boolean unouotro){
		
		final String city2=city;
		initWidget(mainPanel);
		
		//======VOLVER AL PANEL DE BUSQUEDA========
		volver.add(back);
		mainPanel.addSouth(volver,10);
		back.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				mainPanel.clear();
				CityNow.go("init", null, false);
				
			}
		});
		//====================//=================
		
		//=======API DE MAPS===========
		new JsonpRequestBuilder().send("http://maps.googleapis.com/maps/api/js?sensor=false",
				new AsyncCallback<Void>(){
					public void onFailure(Throwable caught) {
						Window.alert("Error loading map: "+caught.getMessage());
					}
					public void onSuccess(Void result) {
						showMap(mapa);
						showAddress(city2);
					}
		});
		
		//==============//===============
		
		//============LLAMADA A LA API DE FOTOS==============
		getPhotos(city);
		
		//============PONER WIDGETS EN LA PAGINA=============
		main.add(event);
		//mainPanel.addNorth(tiempo, 10);
		main.add(fotos);
		main.add(mapa);
		
		main.setWidgetLeftWidth(event,1, Unit.PCT, 32, Unit.PCT );
		main.setWidgetLeftWidth(mapa, 34, Unit.PCT, 32, Unit.PCT);
		main.setWidgetLeftWidth(fotos, 67, Unit.PCT, 32, Unit.PCT);	
		mainPanel.add(main);
		
	}
	
	//======================//ACABA SHOWVIEW//==================================

	
	
	//============METODOS PARA CONSEGUIR LOS EVENTOS==========================
	
	private static void getEvents(String city,Double latitud, Double longitud){
		final String cityFinal=city;
		mashupService.getEvents(latitud,longitud, new AsyncCallback<EventSearch>() {
			public void onSuccess(EventSearch result) {
				statusLabel.setText("");
				showEvents(cityFinal, result);
			}
			
			public void onFailure(Throwable caught) {
				
			}
		});
	}

	private static void showEvents(String city, EventSearch result){
		String output="<fieldset>";
		output+= "<legend>"+city+" events</legend>";
		if(result!=null){
			if(result.getEvents()!=null){
			for(Event event:result.getEvents().getEvent()){
				if(event.getImage()!=null){
					output+="<img src='"+event.getImage().getUrl()+"'/>"+event.getTitle()+event.getDescription()+event.getLatitude()+event.getLongitude();
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
		event.add(eventos);
		
	}

	
	//============METODOS PARA CONSEGUIR EL TIEMPO==========================
	
	private static String htmltimepo;
	
	private static void getWeather(String city,Double latitud, Double longitud){
		final String cityFinal = city;
		mashupService.getWeather(latitud,longitud, new AsyncCallback<WeatherSearch>() {
			public void onSuccess(WeatherSearch result) {
				statusLabel.setText("");
				showWeather(cityFinal, result);
			}
			
			public void onFailure(Throwable caught) {
				
			}
			
			
		});
	}

	private static void showWeather(String weather, WeatherSearch result){
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
		
		htmltimepo=output;
		showSchool(latlngstatic, map, "Sevilla");
		
	}

	
	//============METODOS PARA CONSEGUIR LAS FOTOS==========================
	
	
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
	    
	  	this.fotos.add(fotos);
	    
	}

	
	//============METODOS PARA MOSTRAR EL MAPA==========================
	
	private static LatLng latlngstatic;
	
	public static void showMap(FlowPanel mapa) {
		/* Mostrar mapa */
		//LatLng myLtLng= LatLng.create(37.25819, -5.98637);
		MapOptions myOptions=MapOptions.create();
		myOptions.setZoom(8.0);
		//myOptions.setCenter(myLtLng);
		myOptions.setMapTypeId(MapTypeId.ROADMAP);
		map=GoogleMap.create(mapa.getElement(),myOptions);
		
	}

	private static void showAddress(String city) {
		/* Mostrar marcador en la dirección indicada por el usuario */
		final String cityFinal=city;
		Geocoder geocoder= Geocoder.create();
		GeocoderRequest request= GeocoderRequest.create();
		request.setAddress(city);
		geocoder.geocode(request, new Callback(){
			public void handle (JsArray<GeocoderResult>results,GeocoderStatus status){
				if(status==GeocoderStatus.OK){
					GeocoderResult location=results.get(0);
					map.setCenter(location.getGeometry().getLocation());
					System.out.println(location.getGeometry().getLocation().lat()+" este no es");
					System.out.println(location.getGeometry().getLocation().lng()+" este no es");
					latlon[0]=location.getGeometry().getLocation().lat();
					latlon[1]=location.getGeometry().getLocation().lng();
					latlngstatic=location.getGeometry().getLocation();
					
					
				}else{
					Window.alert("Geocode was not succesful for the following reason: "+status);
				}
				getEvents(cityFinal,latlon[0],latlon[1]);
				getWeather(cityFinal,latlon[0],latlon[1]);
			}
		});
		
		
	}
	
	private static void showSchool(LatLng location,GoogleMap map, String city) {
		
		final GoogleMap m=map;
		/** TODO: Mostrar marcador y ventana de información */
		location = latlngstatic;
		InfoWindowOptions infoWindowOpts=InfoWindowOptions.create();
		infoWindowOpts.setContent(htmltimepo);
		final InfoWindow infoWindow = InfoWindow.create(infoWindowOpts);
		
		MarkerOptions markerOpts= MarkerOptions.create();
		markerOpts.setPosition(location);
		markerOpts.setMap(map);
		markerOpts.setTitle(city+" weather:");
		final Marker marker = Marker.create(markerOpts);
		marker.addClickListener(new Marker.ClickHandler() {
			
			@Override
			public void handle(MouseEvent event) {
				infoWindow.open(m,marker);
			}
		});
	}
	
}









