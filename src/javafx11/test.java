package javafx11;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//--module-path /home/valentin/eclipse/externalJars/JavaFx/javafx-sdk-11.0.2/lib --add-modules="javafx.base,javafx.controls"
public class test extends Application {

  public void start(Stage stage) {
    VBox root = new VBox();
    Label msg = new Label("Hello JavaFX bkj");
    Button b = new Button("close me ");
    Alert a = new Alert(AlertType.CONFIRMATION, "Are you sure you want to format your system?");
    b.setOnAction(e->{ if(a.showAndWait().isPresent())stage.close();});
    root.getChildren().add(msg);
    root.getChildren().add(b);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("Hello JavaFX");
    stage.setMaximized(true);
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
