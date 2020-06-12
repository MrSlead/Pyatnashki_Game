package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import event.MenuButtonEvent;
import event.TimerEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * Класс MainController является контроллером графического api, содержащий все элементы fxml.
 * @author Alex
 * @version 1.0
 */
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
	
    
	/** 
	 * При нажатии на кнопку НАЧАЛО скрывается эта кнопка и меню с выбором размерности игры.
	 * Появляется pane с текстом ШАГ и pane с текстом времени.
	 * @param event - сихронизация метода с нажатием на кнопку установлена в main.fxml "onAction="#clickStartButton""
	 */
	@FXML
	private void clickStartButton(ActionEvent event) {
		if(!gridPane.getChildren().isEmpty()) {
			startButton.setVisible(false);
			menuButton.setVisible(false);
			textPane.setVisible(true);
			timePane.setVisible(true);
			TimerEvent.startTime();
			
			/** Снимается блокировка с кнопок, поэтому на них можно будет нажимать. */
			gridPane.getChildren()
			.stream()
			.forEach(item ->
				((Button) item).setDisable(false));
		}
	}

	/** При выборе режима 3x3 или другого фомируются на окне выбранная размерность кнопок в случайном порядке. */
	@FXML
	private void clickMenuItem() {
		MenuButtonEvent.setTextAndGenerateButton();
	}
	
	
	/** Инициализируется во время открытия данного окна, так как это окно открывается при запуске программы, то инициализируется  
	 * во время запуска программы. */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/** Режимы для игры, размерность */
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
