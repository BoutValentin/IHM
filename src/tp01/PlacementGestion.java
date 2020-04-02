package tp01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PlacementGestion extends Application{
	
	public void start(Stage stage) {
		
		
		Pane root = new Pane();
		Button but1 = new Button("BUtton1");
		Button but2 = new Button("Button2");
		root.getChildren().add(but1);
		root.getChildren().add(but2);
		but1.setLayoutX(55);
		but1.setLayoutY(55);
		but2.setLayoutX(155);
		but2.setLayoutY(55);
		/*GridPane root = new GridPane();
		
		for(int i = 1; i<11; i++) {
			Button button = new Button("Button"+i);
			button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			if(i<5) {
				GridPane.setConstraints(button, i-1, 0);
			}else if(i==5) {
				GridPane.setConstraints(button, 0, 1);
				GridPane.setColumnSpan(button, 4);
			}else if(i==6) {
				GridPane.setConstraints(button, 0, 2);
				GridPane.setColumnSpan(button, 3);
				
				
			}else if(i==7) {
				GridPane.setConstraints(button, 3, 2);
			}else if(i==8) {
				GridPane.setConstraints(button, 0, 4);
				GridPane.setRowSpan(button, 2);
				
			}else if(i==9) {
				GridPane.setConstraints(button, 1, 4);
				GridPane.setColumnSpan(button, 3);
			}else if(i==10) {
				GridPane.setConstraints(button,1, 5);
				GridPane.setColumnSpan(button, 3);
			}
			root.getChildren().add(button);
		}*/
		//BorderPane root = new BorderPane();
		//Button button1 = new Button("Nord");
		//button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		//Button button2 = new Button("South");
		//button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		//Button button3 = new Button("Center");
		//button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		//Button button4 = new Button("East");
		//button4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		//Button button5 = new Button("West");
		//button5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		//root.setTop(button1);
		//root.setBottom(button2);
		//root.setLeft(button5);
		//root.setRight(button4);
		//root.setCenter(button3);
		/*for(Node n : root.getChildren()) {
			root.setMargin(n, new Insets(5.0,5.0,5.0,5.0));
			
		}*/
		Scene scene = new Scene(root, 300, 300);
		
		stage.setScene(scene);
		
		stage.setTitle("Hello JavaFx");
		stage.initStyle(StageStyle.DECORATED);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
