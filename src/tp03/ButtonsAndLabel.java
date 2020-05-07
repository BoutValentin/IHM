package tp03;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonsAndLabel extends Application{ 
		
	private double x;
	private boolean enMouvement;
	
	public void start(Stage stage) {
		Label label = new Label("0");
		label.setOnMouseClicked(e->{labelCliked(label, e);});
		label.setOnMouseDragged(e->{labelDragged(label, e);});
		label.setOnScroll(e->{labelScroll(label, e);});
		label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		label.setStyle("-fx-background-color: lightblue;"+"-fx-alignment: center;"+"-fx-font: 30px Verdana;");
		Button bmoins = new Button("  -  ");
		bmoins.setOnMouseClicked(e->{label.setText(""+(Integer.parseInt(label.getText())-1));});
		Button bplus = new Button("  +  ");
		bplus.setOnMouseClicked(e->{label.setText(""+(Integer.parseInt(label.getText())+1));});
		
		VBox vbox = new VBox(3);
		vbox.setPadding(new Insets(3,3,3,3));
		vbox.setAlignment(Pos.CENTER);
		HBox hbox = new HBox(3);
		hbox.getChildren().addAll(bmoins, bplus);
		vbox.getChildren().addAll(label, hbox);
		
		Scene scene = new Scene(vbox);
		stage.setTitle("Counter");
		stage.setScene(scene);
		stage.show();
	}
	private void labelScroll(Label l, ScrollEvent e) {
		
		int valueDeltaY = (int)(e.getDeltaY()/e.getMultiplierY());
		if(valueDeltaY<0) {
			l.setText(""+(Integer.parseInt(l.getText())-1));
		
		}else if(valueDeltaY>0) {
			l.setText(""+(Integer.parseInt(l.getText())+1));
		}
	}
	private void labelDragged(Label l, MouseEvent e) {
		this.enMouvement=true;
		System.out.println("VOici x " + x);
		System.out.println("voici get X"+ e.getX());
		System.out.println("Voici eX -x "+ (e.getX()-x));
		int value = (int) (e.getX()-x);
		if(value<0) {
			l.setText(""+(Integer.parseInt(l.getText())-1));
		}else if(value>0) {
			l.setText(""+(Integer.parseInt(l.getText())+1));
		}
		x=e.getX();
		//l.setText(""+value);
	}
	private void labelCliked(Label l, MouseEvent e) {
		if(!this.enMouvement) {
			x=e.getX();
			if(e.getButton()==MouseButton.PRIMARY) {
				l.setText(""+(Integer.parseInt(l.getText())+1));
			}else if(e.getButton()==MouseButton.SECONDARY) {
				l.setText(""+(Integer.parseInt(l.getText())-1));
			}
		}
		this.enMouvement=false;
		
	}
	public static void main(String[] args) {
		
		Application.launch(args);
	}
}
