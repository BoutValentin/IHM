package tp02;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.shape.*;

public class Pointing extends Application{
	private int width = 20;
	private double initX;
	private double initY;
	double lastx = 0.0;
	double lasty = 0.0;
	private Rectangle createRect(double x, double y) {
		Rectangle r =new Rectangle();
		r.setX(x);
		r.setY(y);
		r.setWidth(width);
		r.setHeight(width);
		return r;
	}
	private void clearRectangle(Rectangle drag, GraphicsContext gc) {
		gc.clearRect(drag.getX(), drag.getY(), drag.getWidth()+1, drag.getWidth()+1);
	}
	private Rectangle findRect(double x,double y, List<Rectangle> l) {
		for(Rectangle r : l) {
			if(x>r.getX()-width && x<r.getX()+width && y>r.getY()-width&& y<r.getY()+width) {
				return r;
			}
		}
		return null;
	}
	public void start(Stage stage) {
		VBox root = new VBox();
		Canvas canvas = new Canvas(300,300);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		List<Rectangle> listRect = new ArrayList<Rectangle>();
		List<Rectangle> listRectSelect = new ArrayList<Rectangle>();
		canvas.setOnMouseClicked(e->{
			
			if(e.isShiftDown()) {
				Rectangle remove = findRect(e.getX()-10, e.getY()-10, listRect);
				listRect.remove(remove);
				if(remove!=null) gc.clearRect(remove.getX(), remove.getY(), remove.getWidth()+1, remove.getWidth()+1);
				
			}else if(findRect(e.getX()-10, e.getY()-10, listRect)==null){
				System.out.println("create a new one bro");
				Rectangle r = createRect(e.getX()-10, e.getY()-10);
				listRect.add(r);
				
			}
		});
		canvas.setOnMouseReleased(e ->{
			if(e.isControlDown()) {
				Rectangle find = findRect(e.getX(), e.getY(), listRect);
				if(find!=null) {
				listRectSelect.add(find);
				}
				
				
			}else {
				listRectSelect.clear();
				initX=-1.0;
				initY=-1.0;
			}
			System.out.println("mouse released");
			System.out.println(listRectSelect);
			System.out.println(listRect);
			for(Rectangle rz : listRect) {
				gc.setFill(Color.ORANGE);
				gc.fillRect(rz.getX(), rz.getY(), rz.getWidth(), rz.getWidth());
				gc.setStroke(Color.BLACK);
				gc.strokeRect(rz.getX(), rz.getY(), rz.getWidth(), rz.getWidth());
			}
			for(Rectangle rz : listRectSelect) {
				gc.setFill(Color.GREEN);
				gc.fillRect(rz.getX(), rz.getY(), rz.getWidth(), rz.getWidth());
				gc.setStroke(Color.ALICEBLUE);
				gc.strokeRect(rz.getX(), rz.getY(), rz.getWidth(), rz.getWidth());}
		});
	
		canvas.setOnMouseDragged(e->{
			if(e.isControlDown()) {
				lastx=initX;
				lasty=initY;
				initX=e.getX();
				initY=e.getY();
				int i =0;
				for(Rectangle rect : listRectSelect) {
					System.out.println(""+rect+i);
					System.out.println(""+"getX"+e.getX());
					System.out.println(""+"initX"+initX);
					System.out.println(""+"lasstX"+lastx);
					System.out.println(""+"getY"+e.getY());
					System.out.println(""+"initY"+initY);
					System.out.println(""+"lastY"+lasty);
					System.out.println(rect.getX()+((initX-lastx)-10));
					System.out.println(rect.getY()+((initY-lasty)-10));
					clearRectangle(rect, gc);
					double deltaX=(initX-lastx);
					double deltaY=(initY-lasty);
					rect.setX(rect.getX()+(deltaX));
					rect.setY(rect.getY()+(deltaY));
					gc.setFill(Color.GREEN);
					gc.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getWidth());
					gc.setStroke(Color.ALICEBLUE);
					gc.strokeRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getWidth());		
					
					System.out.println("drag a selection");
					i++;
				}
				
				
			}else {
			Rectangle drag = findRect(initX-10, initY-10, listRect);
			System.out.println(drag);
			if(drag!=null) {
				clearRectangle(drag, gc);
				drag.setX(e.getX()-10);
				drag.setY(e.getY()-10);
				gc.setFill(Color.ORANGE);
				gc.fillRect(drag.getX(), drag.getY(), drag.getWidth(), drag.getWidth());
				gc.setStroke(Color.BLACK);
				gc.strokeRect(drag.getX(), drag.getY(), drag.getWidth(), drag.getWidth());		
				initX=e.getX();
				initY=e.getY();
				System.out.println("drag");
			}
			}
		});
		canvas.setOnMouseMoved( e -> {
			lastx=initX;
			lasty=initY;
			initX=e.getX();
			initY=e.getY();
			Rectangle r = findRect(e.getX(), e.getY(), listRect);
			if(r!=null) {
			
				gc.setFill(Color.ORANGERED);
				gc.clearRect(r.getX(), r.getY(), r.getWidth()+1, r.getWidth()+1);
				gc.fillRect(r.getX(), r.getY(), r.getWidth(), r.getWidth());
				gc.setStroke(Color.BLACK);
				gc.strokeRect(r.getX(), r.getY(), r.getWidth(), r.getWidth());
			}else {
				for(Rectangle rz : listRect) {
					gc.setFill(Color.ORANGE);
					gc.fillRect(rz.getX(), rz.getY(), rz.getWidth(), rz.getWidth());
					gc.setStroke(Color.BLACK);
					gc.strokeRect(rz.getX(), rz.getY(), rz.getWidth(), rz.getWidth());
				}
				for(Rectangle rz : listRectSelect) {
					gc.setFill(Color.GREEN);
					gc.fillRect(rz.getX(), rz.getY(), rz.getWidth(), rz.getWidth());
					gc.setStroke(Color.ALICEBLUE);
					gc.strokeRect(rz.getX(), rz.getY(), rz.getWidth(), rz.getWidth());
				}
			}
		});
		
		gc.setFill(Color.ORANGE);
		gc.fillRect(40, 100, 20, 20);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(40, 100, 20, 20);
		root.getChildren().add(canvas);
		
		Scene scene = new Scene(root);
		stage.setTitle("Helllo Paint");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
