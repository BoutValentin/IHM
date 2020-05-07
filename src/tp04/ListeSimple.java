package tp04;


import java.io.File;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ListeSimple extends Application{
	private final String pathBegin = "/home/valentin";
	 Label label;
	 ListView<File> secondList;
	  class MonListChangeListener implements ListChangeListener<File> {
	    public void onChanged(javafx.collections.ListChangeListener.Change<? extends File> c){
	      label.setText("Selection de " + c.getList().get(0));
	      
	      if(c.getList().get(0).isDirectory()) {
	    	  label.setText("Selection de is directory " + c.getList().get(0).toString().substring(pathBegin.length()));
	    	  secondList.getItems().addAll(c.getList().get(0).listFiles());
	    	  secondList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	    	  secondList.getSelectionModel().getSelectedItems().addListener(new SecondListChangeListener());
	    	  
	      }
	    }
	  }
	  class SecondListChangeListener implements ListChangeListener<File>{
		  public void onChanged(javafx.collections.ListChangeListener.Change<? extends File> c) {
			  label.setText("Selection de " + c.getList().toString().substring(pathBegin.length()+2,c.getList().toString().length()-1));
		  }
	  }

	  public void start(Stage stage) {
		File path = new File(pathBegin);
		File[] filelist = path.listFiles();
	    label = new Label("Aucune selection");
	    ListView<File> list = new ListView<File>();
	    secondList = new ListView<File>();
	    list.getItems().addAll(filelist);
	    list.getSelectionModel().getSelectedItems().addListener(new MonListChangeListener());
	    
	    HBox root = new HBox();
	    root.setAlignment(Pos.CENTER_LEFT);
	    root.setSpacing(10.0);
	    root.setPadding(new Insets(3, 3, 3, 3));
	    root.getChildren().addAll(list,secondList,label);

	    Scene scene = new Scene(root, 400, 150);
	    stage.setTitle("Simple liste");
	    stage.setScene(scene);
	    stage.show();
	  }

	  public static void main(String[] args) {
	    Application.launch(args);
	  }
}
