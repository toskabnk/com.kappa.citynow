package com.kappa.citynow.server;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.restlet.resource.ClientResource;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.kappa.citynow.client.MashupService;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;


public class MashupServiceImpl  extends RemoteServiceServlet implements MashupService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FLICKR_API_KEY = "93326044c7f685d74c5a7557375e350d";
	
	


@Override
	public PhotoSearch getPhotoFlickr(String city) {
		ClientResource cr = null;
	
		try {
			cr = new ClientResource("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key="+FLICKR_API_KEY+"&tags="+URLEncoder.encode(city, "UTF-8")+"&format=json&nojsoncallback=1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		PhotoSearch resultado = cr.get(PhotoSearch.class);

		return resultado;
}

}
