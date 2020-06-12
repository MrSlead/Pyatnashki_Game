package application;

/**
 * Декстопное приложение "Пятнашки" написано с использованием JavaFX + Scene Builder.
 * Смысл игры заключается в том, чтобы разместить числа по порядку слева направо.
 * 
 * Состоит из 1 fxml файла, содержащего 3 pane, одно из которых является родительским
 * для всех компонентов, другое для таймера, последнее для шагов.
 * Кнопка начала игры - startButton, Текст - "Шаг", MenuButton - выбор размерности игры,
 * Текст - время, пройденное после начала игры.
 * 
 * @author Alex
 * @version 1.0
 */

import java.util.Map;
import event.TimerEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	/** Мап, хранящий все fxml элементы */
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
			
			/** Остановить таймер времени после закрытия приложения */
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
