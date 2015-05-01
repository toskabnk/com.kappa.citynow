package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.kappa.citynow.shared.domain.eventful.EventSearch;

public interface MashupService extends RemoteService {
	EventSearch getEvents(String city);
	
}
