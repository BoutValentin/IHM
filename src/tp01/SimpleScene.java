package tp01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SimpleScene extends Application{
	
	public void start(Stage stage) {
		VBox root = new VBox();
		Label msg = new Label("Hello World");
		root.getChildren().add(msg);
		
		Scene scene = new Scene(root, 300, 900);
		Stage stage2 = new Stage();
		stage.setScene(scene);
		stage2.initOwner(stage);
		stage2.initModality(Modality.WINDOW_MODAL);
		stage2.setTitle("Another One");
		stage.setTitle("Hello JavaFx");
		stage.initStyle(StageStyle.DECORATED);
		stage.setResizable(false);
		stage2.setX(350);
		stage2.setY(350);
		stage2.show();
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
