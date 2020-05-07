package tp03;

import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeviseConverter extends Application {
	
	private final double tauxConversionVersLivres = 0.872813;
	private final double tauxConversionVersEuros = 1.14572;
	private double tauxActuelle = 0.872813;
	private boolean interfaceSImple = true;
	private double euros;
	private double livres;
	
	public void start(Stage stage) {
		Label labelEuro = new Label("€");
		Label labelLivre = new Label("£");
		Label labelEuroC = new Label("€");
		Label labelLivreC = new Label("£");
		TextField areaEuro = new TextField("0");
		TextField areaLivre = new TextField("0");
		TextField areaEuroC = new TextField("0");
		TextField areaLivreC = new TextField("0");
		areaEuro.textProperty().addListener(e->{if(areaEuro.getText().length()!=0 && areaEuro.isFocused())setLivres(areaEuro, areaLivre);});
		areaLivre.textProperty().addListener(e->{if(areaLivre.getText().length()!=0 && areaLivre.isFocused())setEuros(areaEuro, areaLivre);});
		areaEuroC.textProperty().addListener(e->{if(areaEuroC.getText().length()!=0 && areaEuroC.isFocused()) allConversion(areaEuroC, areaLivreC, this.tauxActuelle);});
		//Button livresToEuros = new Button("£ -> €"); 
		//livresToEuros.setOnMouseClicked(e->{setEuros(areaEuro, areaLivre);});
		//Button eurosToLivres = new Button("€ -> £");
		//eurosToLivres.setOnMouseClicked(e->{setLivres(areaEuro, areaLivre);});
		//VBox buttonBox = new VBox();
		//buttonBox.getChildren().addAll(livresToEuros, eurosToLivres);
		ToggleGroup groupButtonRadio = new ToggleGroup();
		RadioButton rb1 = new RadioButton("Combo screen");
		RadioButton rb2 = new RadioButton("Simple screen");
		rb1.setToggleGroup(groupButtonRadio);
		
		rb1.setUserData(true);
		rb2.setToggleGroup(groupButtonRadio);
		rb2.setUserData(false);
		HBox  toggleBox = new  HBox();
		toggleBox.setAlignment(Pos.CENTER );
		toggleBox.getChildren().add(rb1);
		toggleBox.getChildren().add(rb2);
		groupButtonRadio.selectedToggleProperty().addListener((v,o,n)->changePreferences(n));
		
		ToggleGroup groupButtonRadioC = new ToggleGroup();
		RadioButton rb1C = new RadioButton("Combo screen");
		RadioButton rb2C = new RadioButton("Simple screen");
		rb1C.setToggleGroup(groupButtonRadioC);
		
		rb1C.setUserData(true);
		rb2C.setToggleGroup(groupButtonRadioC);
		rb2C.setUserData(false);
		HBox  toggleBoxC = new  HBox();
		toggleBoxC.setAlignment(Pos.CENTER );
		toggleBoxC.getChildren().add(rb1C);
		toggleBoxC.getChildren().add(rb2C);
		groupButtonRadioC.selectedToggleProperty().addListener((v,o,n)->changePreferences(n));
		
		ComboBox<DollarsConversion> comboBox = new ComboBox<DollarsConversion>();
		comboBox.getItems().addAll(DollarsConversion.values());
		comboBox.getSelectionModel().selectedItemProperty().addListener(e->{allConversion(areaEuroC, areaLivreC, comboBox.getSelectionModel().getSelectedItem().getConv());labelLivreC.setText(comboBox.getSelectionModel().getSelectedItem().getTo());labelEuroC.setText(comboBox.getSelectionModel().getSelectedItem().getFrom());});
		
		HBox everyoneSimple = new HBox();
		everyoneSimple.getChildren().addAll(areaEuro, labelEuro, areaLivre, labelLivre);
		
		HBox everyoneCombo = new HBox();
		everyoneCombo.getChildren().addAll(areaEuroC, labelEuroC, comboBox, areaLivreC, labelLivreC);
		Button changeInterfaceToSimple = new Button("InterfaceSimple");
		Button changeInterfaceCombo = new  Button("InterfaceCombo");
		
		VBox simpleInterface= new VBox();
		simpleInterface.getChildren().addAll(everyoneSimple, changeInterfaceCombo, toggleBox);
		
		VBox comboInterface = new VBox();
		comboInterface.getChildren().addAll(everyoneCombo,changeInterfaceToSimple, toggleBoxC);
		boolean pref = Preferences.userRoot().node("ConverterPreferences").getBoolean("parametre1", false);
		
		Scene scene = new Scene(pref?simpleInterface:comboInterface);
		changeInterfaceCombo.setOnMouseClicked(e->scene.setRoot(comboInterface));
		changeInterfaceToSimple.setOnMouseClicked(e->scene.setRoot(simpleInterface));
		
		stage.setTitle("Converter");
		stage.setScene(scene);
		stage.show();	
	}
	private void changePreferences(Toggle n) {
		Preferences prefs = Preferences.userRoot().node("ConverterPreferences");
		prefs.putBoolean("parametre1", (boolean)n.getUserData());
	}
	private void allConversion(TextField euros, TextField livres, double conversion) {
		this.tauxActuelle=conversion;
		double value = Double.parseDouble(euros.getText())*conversion;
		livres.setText(""+value);
	}
	private void setLivres(TextField euros, TextField livres) {
		double value = Double.parseDouble(euros.getText())*this.tauxActuelle;
		livres.setText(""+value);
	}
	private void setEuros(TextField euros, TextField livres) {
		double value = Double.parseDouble(livres.getText())*tauxConversionVersEuros;
		euros.setText(""+value);
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
