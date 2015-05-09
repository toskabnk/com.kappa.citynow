package com.kappa.citynow.client;


import com.kappa.citynow.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeControlOptions;
import com.google.maps.gwt.client.MapTypeControlStyle;
import com.google.maps.gwt.client.MapTypeId;
import com.google.maps.gwt.client.ZoomControlStyle;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CityNow implements EntryPoint {
	
	private TextBox searchTextBoxLat= new TextBox();
	private TextBox searchTextBoxLong= new TextBox();
	private Button searchButton=new Button();
	private HorizontalPanel searchPannel= new HorizontalPanel();
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		
		//CodigoEntrega 1
		final Button groupButton = new Button("Integrantes del Grupo");
		final Button infoButton = new Button("Info del Trabajo");

		//Stylenames para los botones
		groupButton.addStyleName("groupButton");
		infoButton.addStyleName("infoButton");
		

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("groupButtonContainer").add(groupButton);
		RootPanel.get("infoButtonContainer").add(infoButton);


		// Create the popup dialog box
		final DialogBox groupBox = new DialogBox();
		groupBox.setText("Informacion del grupo");
		groupBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Cerrar");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		VerticalPanel verticalInfoPanel = new VerticalPanel();
		verticalInfoPanel.addStyleName("verticalInfoPanel");
		verticalInfoPanel.add(new HTML("<b>El grupo esta formado por:</b>"));
		verticalInfoPanel.add(new HTML("<br><b>Antonio de la Rosa Santiago<br>Antonio Castroviejo Naranjo<br>Manu Perez Carmona<br>Daniel Gomez Vela</b>"));
		verticalInfoPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		verticalInfoPanel.add(closeButton);
		groupBox.setWidget(verticalInfoPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				groupBox.hide();
				infoButton.setEnabled(true);
				groupButton.setEnabled(true);
				groupButton.setFocus(true);
			}
		});
		
		final DialogBox infoBox = new DialogBox();
		infoBox.setText("Informacion del trabajo");
		infoBox.setAnimationEnabled(true);
		final Button closeButton1 = new Button("Cerrar");
		// We can set the id of a widget by accessing its Element
		closeButton1.getElement().setId("closeButton");
		VerticalPanel verticalInfoPanel1 = new VerticalPanel();
		verticalInfoPanel1.addStyleName("verticalInfoPanel1");
		verticalInfoPanel1.add(new HTML("<b>Con CityNow vas a poder conocer tu ciudad con imagenes,"
				+ "<br> el tiempo y eventos proximos.<br>Ademas de poder planificar una ruta<br>por las ciudades que introduzcas.<br>"
				+ "Todo ello, mostrado en un mapa interactivo.</b>"));
		verticalInfoPanel1.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		verticalInfoPanel1.add(closeButton1);
		infoBox.setWidget(verticalInfoPanel1);

		// Add a handler to close the DialogBox
		closeButton1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				infoBox.hide();
				infoButton.setEnabled(true);
				groupButton.setEnabled(true);
				infoButton.setFocus(true);
				
			}
		});
		
		groupButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				groupBox.center();
				closeButton.setFocus(true);
				infoButton.setEnabled(false);
				groupButton.setEnabled(false);
			}
		});
		
		infoButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				infoBox.center();
				closeButton1.setFocus(true);
				infoButton.setEnabled(false);
				groupButton.setEnabled(false);
			}
		});
		
		
		
		searchPannel.add(searchButton);
		searchPannel.add(searchTextBoxLat);
		searchPannel.add(searchTextBoxLong);
		
		RootPanel.get("maps").add(searchPannel);
		
		searchButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				String lat1= searchTextBoxLat.getText();
				Double lat=Double.parseDouble(lat1);
				String longg1= searchTextBoxLong.getText();
				Double longg=Double.parseDouble(longg1);
				RootPanel.get("map_canvas").clear();
				showMap(lat, longg);
			}
		});
		
		
	}
	
	private void showMap(Double lat, Double lonng){
		LatLng ciudad = LatLng.create(40.4404917 , -3.68981665  );
		MapOptions myOptions = MapOptions.create();
		myOptions.setZoom(8.0);
		myOptions.setCenter(ciudad);
		myOptions.setMapTypeId(MapTypeId.SATELLITE);
		
		
		/* MapTypeControlOptions myControlOptions = MapTypeControlOptions.create();
		myControlOptions.setStyle(MapTypeControlStyle.HORIZONTAL_BAR);
		myOptions.setMapTypeControlOptions(myControlOptions);
		
		myOptions.setZoomControl(true);
		com.google.maps.gwt.client.ZoomControlOptions myZoomOptions = 	com.google.maps.gwt.client.ZoomControlOptions.create();
		myZoomOptions.setStyle(ZoomControlStyle.LARGE);
		myOptions.setZoomControlOptions(myZoomOptions); */
		
		GoogleMap.create(Document.get().getElementById("map_canvas"), myOptions);
		
		
		
		
	}
	
	
}
