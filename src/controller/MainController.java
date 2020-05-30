package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import event.GridItemEvent;
import event.MenuButtonEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MainController implements Initializable {

	@FXML
	private Pane rootPane;

	@FXML
	private GridPane gridPane;

	@FXML
	private Button startButton;

	@FXML
	private MenuButton menuButton;

	@FXML
	private SplitMenuButton splitMenuButton;

	private List<MenuItem> items;

	@FXML
	private void clickStartButton(ActionEvent event) {
	}

	@FXML
	private void clickMenuItem() {
		MenuButtonEvent.setText(menuButton, gridPane);
	}
	
	@FXML
	private void clickGridItem() {
		GridItemEvent.moveButton(gridPane);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		items = new ArrayList<>(Arrays.asList(
				new MenuItem("3x3"),
				new MenuItem("4x4"),
				new MenuItem("5x5")
				//new MenuItem("6x6")
		));

		menuButton.getItems().addAll(items);

	}

	@FXML
	public void initialize() {

	}

}
