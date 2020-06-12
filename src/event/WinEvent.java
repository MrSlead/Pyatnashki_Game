package event;


import javax.swing.JOptionPane;

import application.Main;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class WinEvent {
	public static boolean isWin(Button [][] buttons, int size) {
		int count = 1;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++, count++) {
				System.out.println(Integer.parseInt(buttons[i][j].getText()) + " equals " + count);
				if(i == size - 1 && j == size - 1) {
					return true;
				}
				if(Integer.parseInt(buttons[i][j].getText()) != count) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void win(Button [][] buttons, int size) {
		if(isWin(buttons, size)) {
			TimerEvent.stopTime();
			JOptionPane.showMessageDialog(null, "Вы победили " + ButtonEvent.getStep() + " шаг/а/ов", "Победа", 2);
			GridPane gridPane = (GridPane) Main.getFXMLNamespace().get("gridPane");
			
			gridPane.getChildren().
			stream().
			forEach(button ->
				((Button) button).setDisable(true));
		}
	}
}
