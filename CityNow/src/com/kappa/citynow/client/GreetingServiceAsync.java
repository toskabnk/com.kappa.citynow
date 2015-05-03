package com.kappa.citynow.client;


import com.google.gwt.user.client.rpc.AsyncCallback;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	void getFotoFlickr(String artist, AsyncCallback<PhotoSearch> asyncCallback);
}
