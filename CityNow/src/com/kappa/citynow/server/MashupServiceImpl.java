package com.kappa.citynow.server;

import java.io.UnsupportedEncodingException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;

import org.restlet.resource.ClientResource;

public class MashupServiceImpl  extends RemoteServiceServlet implements MashupService {
	
	private static final String FLICKR_API_KEY = "";
	
	
public PhotoSearch getFotoFlickr(String tag){
		
		ClientResource cr = null;
		
		try {
			cr = new ClientResource("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key="+FLICKR_API_KEY+"&tags="+URLEncoder.encode(tag, "UTF-8")+"&format=json&nojsoncallback=1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PhotoSearch resultado = cr.get(PhotoSearch.class);

		return resultado;
		
	}

}
