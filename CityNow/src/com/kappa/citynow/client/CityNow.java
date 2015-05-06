package com.kappa.citynow.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
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
				final String city = searchBox.getText();
				getEvents(city);
				getWeather(city);
				getPhotos(city);
			}
		});
		
	}
	
	
	
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
				output+=tiempo.getDescription();
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
		output += "<legend>" + city + "</legend>";
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

}
