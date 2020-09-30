import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class runner extends Application {
	
	
	Stage window;
	Scene scene1, scene2, scene3;
	 
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		BorderPane layout1 = new BorderPane();
		
		HBox top = new HBox();
		top.setAlignment(Pos.CENTER);
		
		Text title = new Text("Please Select A Shape!!!");
		title.setFont(new Font(20));
		top.getChildren().add(title);
		layout1.setTop(top);
		
		
		
		HBox center = new HBox(15);
		center.setSpacing(30);
		center.setAlignment(Pos.CENTER);
		
		
		Button circlebut = new Button("Circle");
		Button squarebut = new Button("Square");
		Button rectbut = new Button("Rectangle");
		
		CircleHandler handler1 = new CircleHandler();
		circlebut.setOnAction(handler1);
		
		SquareHandler handler2 = new SquareHandler();
		squarebut.setOnAction(handler2);
		
		RectangleHandler handler3 = new RectangleHandler();
		rectbut.setOnAction(handler3);
		
		center.getChildren().addAll(circlebut, squarebut, rectbut);
		
		
		layout1.setCenter(center);
		
		 
		// Creating Scene
		scene1 = new Scene(layout1, 400, 400);
		window.setTitle("Lots of Shapes");
		window.setScene(scene1);
		window.show();
		
		
	}
	
	
	class CircleHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent e) {
		
			System.out.println("yo");
			/*
			submit.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					HBox shapes = new HBox();
					shapes.setAlignment(Pos.CENTER);
					
					int xcord1 = Integer.parseInt(XCoordinate1.getText());
					int ycord1 = Integer.parseInt(YCoordinate1.getText());
					int r1 = Integer.parseInt(radius1.getText());
					
					int xcord2 = Integer.parseInt(XCoordinate2.getText());
					int ycord2 = Integer.parseInt(YCoordinate2.getText());
					int r2 = Integer.parseInt(radius2.getText());
					
					
					
					Circle circle1 = new Circle();
					circle1.setCenterX(xcord1);
					circle1.setCenterY(ycord1);
					circle1.setRadius(r1);
					
					circle1.setStroke(Color.BLACK);
					circle1.setFill(Color.AQUA);
					
					shapes.getChildren().addAll(circle1);
					
					border.setCenter(shapes);
					
				}
				
				
				
				
			});*/
			
			
			

			
			
			
			
			
			
			
		}
		
	}
		
		
	
	
	class SquareHandler implements EventHandler<ActionEvent> {
			
			@Override
			public void handle(ActionEvent e) {
				System.out.println("yo");
			}
			
		}
		
		
	class RectangleHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent e) {
			System.out.println("yo");
		} 
		
	}
	

	public void main(String[] args) {
		Application.launch(args);
	}
	
}



