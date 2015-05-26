package com.kappa.citynow.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class searchView extends Composite {
	
	private VerticalPanel vP = new VerticalPanel();
	private Button searchButton = new Button("Search");
	private TextBox searchBox = new TextBox();
	private CheckBox eventBrite = new CheckBox();
	private Image cityNow = new Image("/logo.png");
	private HTML unouotro = new HTML("EventFul/EventBrite");
	
	public searchView(){
		HorizontalPanel mainHPanel = new HorizontalPanel();
		
		initWidget(vP);
		
		unouotro.addStyleName("unouotro");
		searchButton.addStyleName("searchButton");
		cityNow.setStyleName("logoStyle");
		
		mainHPanel.add(searchBox);
		searchBox.setText("Ej: New York");
		searchBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				searchBox.setText("");
			}
		});
		
		mainHPanel.add(searchButton);
		mainHPanel.add(eventBrite);
		mainHPanel.add(unouotro);
		
		vP.add(cityNow);
		vP.add(mainHPanel);
		
		searchButton.setFocus(true);
		
		searchButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				if(searchBox.getText().isEmpty()){
					searchBox.setText("This cannot be empty");
					searchButton.setFocus(true);
				}
				else{
				CityNow.go("show", searchBox.getText(), eventBrite.getValue());
				}
			}
		});
		
	}
	
	
}
