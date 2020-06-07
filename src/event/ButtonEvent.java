package event;

import java.util.List;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class ButtonEvent {
	private static int removeIndexX = -1;
	private static int removeIndexY = -1;
	private static Button buttons [][];
	private static int size;

	private static void definingEmptyButton(GridPane gridPane) {
		size = MenuButtonEvent.getSize();
		buttons = new Button[size][size];
		
		List<Node> list = gridPane.getChildren();
		
		removeIndexX = MenuButtonEvent.getRemoveButtonIndex() % size;
		removeIndexY = MenuButtonEvent.getRemoveButtonIndex() / size;
		int count = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++, count++) {
				//if((((Button) list.get(count)).isVisible()) != false) {
					/*if(i == removeIndexY && j == removeIndexX) {
						buttons[i][j] = null;
						count--;
					}
					else {*/
						buttons[i][j] = (Button) list.get(count);
					//}
				//}
			}
		}
	}
	
	public static void move(GridPane gridPane, Button moveButton) {
		if(removeIndexX == -1 && removeIndexY == -1 /*|| buttons[removeIndexX][removeIndexY] != moveButton*/) {
			definingEmptyButton(gridPane);
		}
		boolean move = false;
		for(int i = 0; i < size && !move; i++) {
			for(int j = 0; j < size; j++) {
				if(i == 0) {
					if(buttons[i][j].isVisible() == false && j == 0) {
						if(buttons[i][j+1] == moveButton || buttons[i+1][j] == moveButton) {
							System.out.println(true);
							move = true;
						}
						else System.out.println(false);
						break;
					}
					else if(buttons[i][j].isVisible() == false && j == size-1) {
						if(buttons[i][j-1] == moveButton || buttons[i+1][j] == moveButton) {
							System.out.println(true);
							move = true;
						}
						else System.out.println(false);
						break;
					}
					else {
						if(buttons[i][j].isVisible() == false) {
							if(buttons[i][j+1] == moveButton || buttons[i][j-1] == moveButton || buttons[i+1][j] == moveButton) {
								System.out.println(true);
								move = true;
							}
							else System.out.println(false);
							break;
						}
					}
				}
				
				else if(i == size-1) {
					if(buttons[i][j].isVisible() == false && j == 0) {
						if(buttons[i][j+1] == moveButton || buttons[i-1][j] == moveButton) {
							System.out.println(true);
							move = true;
						}
						else System.out.println(false);
						break;
						
					}
					else if(buttons[i][j].isVisible() == false && j == size-1) {
						if(buttons[i][j-1] == moveButton || buttons[i-1][j] == moveButton) {
							System.out.println(true);
							move = true;
						}
						else System.out.println(false);
						break;
					}
					else {
						if(buttons[i][j].isVisible() == false) {
							if(buttons[i][j+1] == moveButton || buttons[i][j-1] == moveButton || buttons[i-1][j] == moveButton) {
								System.out.println(true);
								move = true;
							}
							else System.out.println(false);
							break;
						}
					}
				}
				
				else {
					if(j == 0) {
						if(buttons[i][j].isVisible() == false) {
							if(buttons[i][j+1] == moveButton || buttons[i-1][j] == moveButton || buttons[i+1][j] == moveButton) {
								System.out.println(true);
								move = true;
							}
							else System.out.println(false);
							break;
						}
					}
					if(j == size-1) {
						if(buttons[i][j].isVisible() == false) {
							if(buttons[i][j-1] == moveButton || buttons[i-1][j] == moveButton || buttons[i+1][j] == moveButton) {
								System.out.println(true);
								move = true;
							}
							else System.out.println(false);
							break;
						}
					}
					else {
						if(buttons[i][j].isVisible() == false) {
							if(buttons[i][j+1] == moveButton || buttons[i][j-1] == moveButton || buttons[i+1][j] == moveButton || buttons[i-1][j] == moveButton) {
								System.out.println(true);
								move = true;
							}
							else System.out.println(false);
							break;
						}
					}
				}
				
			}
		}
		if(move) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					//buttons[removeIndexY][removeIndexX] = (Button) gridPane.getChildren().get(MenuButtonEvent.getRemoveButtonIndex());
					Button buttonRemove = buttons[removeIndexY][removeIndexX];
					newRemoveButton(moveButton);
					buttonRemove.setText(moveButton.getText());
					buttonRemove.setVisible(true);
					moveButton.setVisible(false);
					System.out.println("Win:" + win());
				}
			});
		}
		
	}
	
	private static void newRemoveButton(Button moveButton) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(buttons[i][j] == moveButton) {
					removeIndexX = j;
					removeIndexY = i;
				}
			}
		}
	}
	
	private static boolean win() {
		int count = 1;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++, count++) {
				System.out.println(Integer.parseInt(buttons[i][j].getText()) + " equals " + count);
				if(Integer.parseInt(buttons[i][j].getText()) != count) {
					return false;
				}
			}
		}
		return true;
	}
	
}
