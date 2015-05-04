package com.kappa.citynow.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;

@RemoteServiceRelativePath("mashup")
public interface MashupService extends RemoteService{
	PhotoSearch getPhotoFlickr(String city);
}
