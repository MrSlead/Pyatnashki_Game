package event;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GridItemEvent {
	public static void moveButton(GridPane gridPane) {
		gridPane.getChildren().stream().forEach(item -> {
			((Button) item).setOnAction(event -> {
				
			});
		}); 
	}
}
