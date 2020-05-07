package tp04;


import java.io.File;
import java.io.InputStream;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;

public class RenderCell extends ListCell<File>{
	public void updateItem(File item, boolean empty ) {
		super.updateItem(item, empty);
		if(!empty) {
			this.setText(item.getName());
		
		Canvas c = new Canvas(20,20);
		GraphicsContext gc = c.getGraphicsContext2D();
		
		InputStream inputprev;
		if(item.isDirectory()) {
			inputprev = getClass().getResourceAsStream("/folder.png");
		}else {
			inputprev = getClass().getResourceAsStream("/file.png");
			
		}
		Image img = new Image(inputprev);
	
		gc.drawImage(img,-2,-2);
		setGraphic(c);
		}
	}
}
