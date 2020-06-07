package event;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class MenuButtonEvent {
	private static List<Integer> randomNumberList;
	private static int size;
	private static int removeButtonIndex;
	
	public static void setTextAndGenerateButton(MenuButton menuButton, GridPane gridPane) {
		menuButton.getItems()
		.stream()
		.forEach(i -> i.setOnAction(e -> {
			menuButton.setText(i.getText());
			generateButton(menuButton, gridPane);
			
			GridItemEvent.moveButton(gridPane);
		}));
	}
	
	public static void generateButton(MenuButton menuButton, GridPane gridPane) {
		if (!menuButton.getText().equals("Размер")) {
			size = Integer.parseInt(String.valueOf(menuButton.getText().charAt(0)));
			randomNumberList = new ArrayList<>(
					Stream.iterate(1, n -> n+1)
					.limit(size*size-1)
					.collect(Collectors.toList()));

			deleteColumntAndRow(gridPane);
			generateColumntAndRow(menuButton, gridPane, size);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					Button b = new Button(String.valueOf(""));
					b.setPrefHeight(300);
					b.setPrefWidth(300);
					b.setFocusTraversable(false);
					b.setFont(Font.font(45));
					gridPane.add(b, j, i);
				}
			}
			removeButtonIndex = (int) (Math.random() * size*size);
			gridPane.getChildren().get(removeButtonIndex).setVisible(false);
			
			for(int i = 0; i < gridPane.getChildren().size(); i++) {
				Button button = (Button) gridPane.getChildren().get(i);
				if(button.isVisible() != false) {
					button.setText(String.valueOf(random(randomNumberList)));
				}
			}
		}
	}
	
	private static void deleteColumntAndRow(GridPane gridPane) {
		for(int i = 0; i < gridPane.getChildren().size();) {
			gridPane.getChildren().remove(0);
		}
		
		for(int i = 0; i < gridPane.getColumnConstraints().size();) {
			gridPane.getColumnConstraints().remove(0);
		}
		
		for(int i = 0; i < gridPane.getRowConstraints().size();) {
			gridPane.getRowConstraints().remove(0);
		}
	}
	
	private static void generateColumntAndRow(MenuButton menuButton, GridPane gridPane, int size) {
		for(int i = 0; i < size; i++) {
			ColumnConstraints col = new ColumnConstraints();
			col.setPrefWidth(400);
			col.setMinWidth(10);
			gridPane.getColumnConstraints().add(col);

			RowConstraints row = new RowConstraints();
			row.setPrefHeight(500);
			row.setMinHeight(10);
			gridPane.getRowConstraints().add(row);
		}
	}
	
	private static int random(List<Integer> list) {
		return list.remove((int) (Math.random() * list.size()));
	}
	
	public static int getSize() {
		return size;
	}
	
	public static int getRemoveButtonIndex() {
		return removeButtonIndex;
	}
}
