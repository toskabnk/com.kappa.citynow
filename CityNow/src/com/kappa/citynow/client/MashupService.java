package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.RemoteService;

public interface MashupService extends RemoteService {	
	//EventFul
	EventSearch getEventos(String nombreCiudad);
	//Tiempo
	WeatherSearch getTiempo(String nombreCiudad);
	//Fotos
	PhotoSearch getFotos(String nombreCiudad);
	
}
