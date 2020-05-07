package td03;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo1 extends Application {

	protected Slider sld;
	protected TextField txt;

	@Override
	public void start(Stage stage) throws Exception {
		sld = new Slider(0, 100, 25);
		txt = new TextField("25.0");
		sld.valueProperty().addListener(e->{txt.setText(""+sld.getValue());});
		txt.textProperty().addListener(e->{sld.setValue((double)Double.parseDouble(txt.getText().length()==0?"0":txt.getText()));});
		VBox root = new VBox();
		root.setSpacing(10.0);
		root.setPadding(new Insets(3, 3, 3, 3));
		root.getChildren().addAll(sld, txt);

		Scene scene = new Scene(root);
		stage.setTitle("Ajout item liste");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}