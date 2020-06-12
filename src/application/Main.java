package application;
	
import java.util.Map;
import event.TimerEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	private static Map<String, Object> fxmlNamespace;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/main.fxml"));
			fxmlNamespace = loader.getNamespace();
			Pane root = (Pane) loader.load();
			Scene scene = new Scene(root, 700, 600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Пятнашки");
			primaryStage.setResizable(false);
			
			primaryStage.setOnCloseRequest(e -> TimerEvent.stopTime());
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Map<String, Object> getFXMLNamespace() {
		return fxmlNamespace;
	}
}
