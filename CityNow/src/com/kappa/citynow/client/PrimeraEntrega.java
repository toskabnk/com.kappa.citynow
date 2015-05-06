package com.kappa.citynow.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PrimeraEntrega implements EntryPoint {

	public void onModuleLoad(){
	
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
	}
}
