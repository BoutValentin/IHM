package tp04;


import java.io.File;
import java.util.Iterator;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListeSimple extends Application{
	private final String pathBegin = "/home/valentin";
	 Label label;
	 ListView<File> secondList;
	  class MonListChangeListener implements ListChangeListener<File> {
	    public void onChanged(javafx.collections.ListChangeListener.Change<? extends File> c){
	      label.setText("Selection de " + c.getList().get(0).getName());
	      
	      if(c.getList().get(0).isDirectory()) {
	    	  secondList.getItems().clear();
	    	  secondList.getItems().addAll(c.getList().get(0).listFiles());
	    	  secondList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	    	  secondList.getSelectionModel().getSelectedItems().addListener(new SecondListChangeListener());
	    	  
	      }else {
	    	  secondList.getItems().clear();
	      }
	    }
	  }
	  class SecondListChangeListener implements ListChangeListener<File>{
		  public void onChanged(javafx.collections.ListChangeListener.Change<? extends File> c) {
			  label.setText("Selection de : ");
			  for(int i =0; i<c.getList().size();i++) {
				  label.setText(label.getText()+c.getList().get(i).getName());
				  if(i<c.getList().size()-1)label.setText(label.getText()+",");
			  }
			  
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
	    list.setCellFactory(new Callback<ListView<File>, ListCell<File>>() {
			
			@Override
			public ListCell<File> call(ListView<File> list) {
				// TODO Auto-generated method stub
				return new RenderCell();
			}
		});
	    secondList.setCellFactory(new Callback<ListView<File>, ListCell<File>>() {
	    	public ListCell<File> call(ListView<File> list){
	    		return new RenderCell();
	    	}
		});
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
