package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.kappa.citynow.shared.domain.eventful.EventSearch;

public interface MashupServiceAsync {

	void getEvents(String city, AsyncCallback<EventSearch> callback);

}
