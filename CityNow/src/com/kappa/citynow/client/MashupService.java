package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.kappa.citynow.shared.domain.eventful.EventSearch;

@RemoteServiceRelativePath("mashup")
public interface MashupService extends RemoteService {
	EventSearch getEvents(String city);
	
}
