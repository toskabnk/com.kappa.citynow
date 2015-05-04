package com.kappa.citynow.server;

import org.restlet.resource.ClientResource;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.kappa.citynow.client.MashupService;
import com.kappa.citynow.shared.domain.eventful.EventSearch;

@RemoteServiceRelativePath("mashup")
public class MashupServiceImpl extends RemoteServiceServlet implements
		MashupService {
	
	private static final long serialVersionUID = -2946593634055232962L;

	private static final String EVENTFUL_API_KEY="hzN2JJ5PwTMfNfcx";
	
	public EventSearch getEvents(String city) {
		
		ClientResource cr=null;
		
	
		cr = new ClientResource("http://api.eventful.com/json/events/search?&languages=spanish&app_key="+EVENTFUL_API_KEY+"&location="+city+"&date=Future");
		
		
		EventSearch res= cr.get(EventSearch.class);
		
		return res;
	}

}
