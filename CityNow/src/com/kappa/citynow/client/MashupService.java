package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.RemoteService;

public interface MashupService extends RemoteService {	
	EventSearch getEventos(String nombreCiudad);
	
	WeatherSearch getTiempo(String nombreCiudad);
	
	PhotoSearch getFotos(String nombreCiudad);
}
