package tp01;

import java.io.InputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TextEditor extends Application{
	
	public void start(Stage stage) {
		VBox root = new VBox();
		
		MenuBar myMenu = new MenuBar();
		Menu menu1 = new Menu("File");
		MenuItem n1 = new MenuItem("New");
		MenuItem n2 = new MenuItem("Ouvrir");
		MenuItem n3 = new MenuItem("Enregistrer");
		MenuItem n4 = new MenuItem("Enregistrer sous");
		
		SeparatorMenuItem separ = new SeparatorMenuItem();
		
		MenuItem n5 = new MenuItem("Mise en page");MenuItem n6 = new MenuItem("Imprimer");
		SeparatorMenuItem separ2 = new SeparatorMenuItem();
		MenuItem n7 = new MenuItem("Quitter");
		menu1.getItems().addAll(n1,n2,n3,n4,separ,n5,n6,separ2,n7);
		Menu menu2 = new Menu("Edit");
		myMenu.getMenus().addAll(menu1,menu2);
		TextArea textArea = new TextArea();
		textArea.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		HBox bottom = new HBox();
		bottom.getChildren().add(new Label("Recherche :"));
		bottom.getChildren().add(new TextField());
		
		InputStream inputprev = getClass().getResourceAsStream("/previous_motif.png");
		InputStream inputnext = getClass().getResourceAsStream("/next_motif.png");
		
		Image prev = new Image(inputprev);
		Image next = new Image(inputnext);
		ImageView prevVie = new ImageView(prev);
		ImageView nextVie = new ImageView(next);
		Button left = new Button();
		left.setGraphic(prevVie);
		Button right = new Button();
		right.setGraphic(nextVie);
		bottom.getChildren().add(left);
		bottom.getChildren().add(right);
		bottom.getChildren().add(new Button("Tout surligner"));
		
		root.getChildren().add(myMenu);
		root.getChildren().add(textArea);
		root.getChildren().add(bottom);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Text Editor");
		stage.initStyle(StageStyle.DECORATED);
		stage.setMaximized(true);
		stage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
