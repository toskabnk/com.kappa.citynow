package com.kappa.citynow.client;


import com.kappa.citynow.shared.domain.flickr.Photo;
import com.kappa.citynow.shared.domain.flickr.PhotoSearch;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CityNow implements EntryPoint {

	

	
	/*public void onModuleLoad() {
		
		
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
		});*/

	private Button searchButton = new Button("Search");
	private TextBox searchField = new TextBox();
	private HorizontalPanel searchPanel = new HorizontalPanel();
	private Label statusLabel = new Label();

	private final MashupServiceAsync mashupService = GWT
			.create(MashupService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		searchField.setText("City");

		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		searchPanel.add(statusLabel);

		// Add panel to the page
		RootPanel.get("form").add(searchPanel);

		// Focus the cursor on the name field when the app loads
		searchField.setFocus(true);
		searchField.selectAll();

		searchButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				statusLabel.setText("Searching...");

				final String city = searchField.getText();
				RootPanel.get("flickr").clear();


				
				mashupService.getPhotoFlickr(city,
						new AsyncCallback<PhotoSearch>() {


							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onSuccess(PhotoSearch result) {
								showFotos(city, result);
								statusLabel.setText("");
								
							}
						});

			}
		});

	}

	private void showFotos(String city, PhotoSearch result) {

		String output="<fieldset>";
		output += "<legend>" + city + " albums</legend>";
        if (result != null) {
        	for (Photo p: result.getPhotos().getPhoto()) {
        		output +="<img src='http://farm"+p.getFarm()+".staticflickr.com/"+p.getServer()+"/"+p.getId()+"_"+p.getSecret()+".jpg'/>";
        	}
        }else
        	output="<span> No results </span>";
	
        output +="</fieldset>";
        
        HTML fotos = new HTML(output);
        
        RootPanel.get("flickr").add(fotos);
	}
}
		



