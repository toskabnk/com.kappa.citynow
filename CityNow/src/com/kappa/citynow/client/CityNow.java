package com.kappa.citynow.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.kappa.citynow.shared.domain.openweather.Weather;
import com.kappa.citynow.shared.domain.openweather.WeatherSearch;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CityNow implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private  TextBox searchField = new TextBox();
	private Label statusLabel = new Label();
	private HorizontalPanel searchPanel = new HorizontalPanel();
	@SuppressWarnings("unused")
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final MashupServiceAsync mashupService = GWT
			.create(MashupService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		
		//CodigoEntrega 1
		final Button groupButton = new Button("Integrantes del Grupo");
		final Button infoButton = new Button("Info del Trabajo"); //Creado Boton para enviar la busqueda
		final Button searchButton = new Button("Buscar"); //Creado el cuadro de busqueda
	

		//Stylenames para los botones
		groupButton.addStyleName("groupButton");
		infoButton.addStyleName("infoButton");
		//searchButton.addStyleName("searchButton"); 
		//searchField.addStyleName("searchField");
		//statusLabel.addStyleName("statusLabel");
		searchPanel.add(searchButton);
		searchPanel.add(searchField);
		searchPanel.add(statusLabel);

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("groupButtonContainer").add(groupButton);
		RootPanel.get("infoButtonContainer").add(infoButton);
		//RootPanel.get("searchButton").add(searchButton); //Añadido Boton para enviar la busqueda
		//RootPanel.get("searchField").add(searchField);  //Añadido el cuadro de busqueda
		//RootPanel.get("statusLabel").add(statusLabel); //Añadido label de status (Opcional)
		searchField.setText("Ciudad"); //Setear un texto predeterminado
		RootPanel.get("form").add(searchPanel);

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
		
		searchField.setFocus(true);
		searchField.selectAll();
		
		searchButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				statusLabel.setText("Nuestros monetes estan buscando...");
				RootPanel.get("eventful").clear();
				final String city = searchField.getText();
				mashupService.getWeather(city, new AsyncCallback<WeatherSearch>() {
					public void onSuccess(WeatherSearch result) {
						showWeather(city, result);
						statusLabel.setText("");

					}

					@Override
					public void onFailure(Throwable caught) {
						statusLabel.setText("Error"+caught.getMessage());

					}
				});
			}
		});
		
		
		
		
		
		

/*		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			*//**
			 * Fired when the user clicks on the sendButton.
			 *//*
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}
			*//**
			 * Fired when the user types in the nameField.
			 *//*
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}
			*//**
			 * Send the name from the nameField to the server and wait for a response.
			 *//*
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}
				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}
							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}
		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);*/
		
		
		
		
	}
	
	private void showWeather(String weather, WeatherSearch result){
		String output="<fieldset>";
		output+= "<legend>"+weather+" weather</legend>";
		if(result!=null){
			for(Weather tiempo:result.getWeather()){
				output+=tiempo.getDescription();
			}
		}
		else{
			output="<span> No results </span>";
		}
		output+="</fieldset>";
		HTML eventos = new HTML(output);
		
		RootPanel.get("weather").add(eventos);
	}
	
}