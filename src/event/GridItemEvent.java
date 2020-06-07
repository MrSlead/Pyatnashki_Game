package event;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GridItemEvent {
	public static void moveButton(GridPane gridPane) {
		try {
			gridPane.getChildren().stream().forEach(item -> {
				((Button) item).setOnAction(event -> {
					ButtonEvent.move(gridPane, (Button) item);
				});
			}); 
			
		} catch(Exception e) {
			System.out.println("Not buttons");
		}
	}
}
