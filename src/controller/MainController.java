package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import event.ButtonEvent;
import event.GridItemEvent;
import event.MenuButtonEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MainController implements Initializable  {

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
	
	private final Timer timer = new Timer();
    private TimerTask timerTask;
    
	@FXML
	private void clickStartButton(ActionEvent event) {

        timerTask = new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(() -> {
                	if(!(startButton.getTranslateY() == 400))
                		startButton.setTranslateY(startButton.getTranslateY() + 1);
                	else timer.cancel();
                });
            }
        };
        timer.schedule(timerTask, 0L, 5L);
        
        if(startButton.getTranslateY() == 400) timerTask.cancel();
        System.out.println("clickStartButton");
   
	}

	@FXML
	private void clickMenuItem() {
		MenuButtonEvent.setTextAndGenerateButton(menuButton, gridPane);
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
