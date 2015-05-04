package com.kappa.citynow.client;



import com.google.gwt.user.client.rpc.AsyncCallback;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;

public interface MashupServiceAsync {
	void getPhotoFlickr(String city, AsyncCallback<PhotoSearch> asyncCallback);

}
