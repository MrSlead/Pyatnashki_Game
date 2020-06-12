package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import application.Main;
import event.ButtonEvent;
import event.GridItemEvent;
import event.MenuButtonEvent;
import event.TimerEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MainController implements Initializable  {

	@FXML
	private Pane rootPane;
	
	@FXML
	private Pane textPane;
	
	@FXML
	private Pane timePane;

	@FXML
	public GridPane gridPane;

	@FXML
	private Button startButton;

	@FXML
	public MenuButton menuButton;
	
	@FXML
	private Text stepText;
	
	@FXML
	private Text timeText;

	@FXML
	private SplitMenuButton splitMenuButton;

	private List<MenuItem> items;
	
    
	@FXML
	private void clickStartButton(ActionEvent event) {
		if(!gridPane.getChildren().isEmpty()) {
			startButton.setVisible(false);
			menuButton.setVisible(false);
			textPane.setVisible(true);
			timePane.setVisible(true);
			TimerEvent.startTime();
			
			gridPane.getChildren()
			.stream()
			.forEach(item ->
				((Button) item).setDisable(false));
		}
	}

	@FXML
	private void clickMenuItem() {
		MenuButtonEvent.setTextAndGenerateButton();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		items = new ArrayList<>(
				Arrays.asList(
						new MenuItem("3x3"),
						new MenuItem("4x4"),
						new MenuItem("5x5")
		// new MenuItem("6x6")
		));

		menuButton.getItems().addAll(items);
	}
}
