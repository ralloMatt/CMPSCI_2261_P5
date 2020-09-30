import javafx.scene.shape.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
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
// importing everything


public class main extends Application { // extending application
	
	Stage window; // creating global stage so I can switch scenes

	
	public void start(Stage primaryStage) {
		
		window = primaryStage; // name of the stage i will be referring to
		BorderPane layout1 = new BorderPane(); // my first layout or scene
		
		HBox top = new HBox(); // creating top of the border pane so I can have a title
		top.setAlignment(Pos.CENTER);
		
		//this is the title
		Text title = new Text("Please Select A Shape!!!");
		title.setFont(new Font(20));
		top.getChildren().add(title);
		layout1.setTop(top); // settign the title to the top of the border pane
		
		
		
		HBox center = new HBox(15); // creating the center of the border pane that will contain the buttons
		center.setSpacing(30);
		center.setAlignment(Pos.CENTER);
		
		// my buttons
		Button circlebut = new Button("Circle");
		Button squarebut = new Button("Square");
		Button rectbut = new Button("Rectangle");
		
		// my handlers
		CircleHandler handler1 = new CircleHandler();
		circlebut.setOnAction(handler1);
		 
		SquareHandler handler2 = new SquareHandler();
		squarebut.setOnAction(handler2);
		
		RectangleHandler handler3 = new RectangleHandler();
		rectbut.setOnAction(handler3);
		
		// adding buttons to the hbox and putting in center of border pane
		center.getChildren().addAll(circlebut, squarebut, rectbut);
		layout1.setCenter(center);
		
		// setting the scene and title
		Scene scene1 = new Scene(layout1, 400, 400);
		window.setTitle("Lots of Shapes");
		window.setScene(scene1);
		window.show();
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////// 
// Handles the event if circle is clicked
	
class CircleHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			
		
			// creating gridpane to show textboxes
			GridPane layout2 = new GridPane();
			layout2.setAlignment(Pos.CENTER);
			layout2.setPadding(new Insets(11, 12, 13, 14));
			layout2.setHgap(6);
			layout2.setVgap(6);
			
			// my text fields
			TextField x1 = new TextField();
			TextField x2 = new TextField();
			TextField y1 = new TextField();
			TextField y2 = new TextField();
			TextField radius1 = new TextField();
			TextField radius2 = new TextField();
			
			layout2.add(new Label("Enter your Data for the circle"), 0, 0);
			
			// getting user input
			layout2.add(new Label("X-Coordinate 1"), 0, 1);
			layout2.add(x1, 1, 1);

			layout2.add(new Label("Y-Coordinate 1"), 0, 2);
			layout2.add(y1, 1, 2);
			
			layout2.add(new Label("Radius 1"), 0, 3);
			layout2.add(radius1, 1, 3);
			
			layout2.add(new Label("X-Coordinate 2"), 0, 4);
			layout2.add(x2, 1, 4);

			layout2.add(new Label("Y-Coordinate 2"), 0, 5);
			layout2.add(y2, 1, 5);
			
			layout2.add(new Label("Radius 2"), 0, 6);
			layout2.add(radius2, 1, 6);

			Button submit = new Button("Submit");
			layout2.add(submit, 0, 7);
			
			// creating scence for the information to show
			Scene scene2 = new Scene(layout2, 400, 400);
			window.setScene(scene2);

			// when the button is clicked start making shapes
			submit.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					// turing the strings to ints for data for circle
					int xcord1 = Integer.parseInt(x1.getText());
					int ycord1 = Integer.parseInt(y1.getText());
					ycord1 = ycord1 * -1; // setting negative because the y is weird
					int r1 = Integer.parseInt(radius1.getText());
					
					int xcord2 = Integer.parseInt(x2.getText());
					int ycord2 = Integer.parseInt(y2.getText());
					ycord2 = ycord2 * -1; // setting negative because the y is weird
					int r2 = Integer.parseInt(radius2.getText());
					
					
					// creating my circles
					Circle circle1 = new Circle();
					
					// center is at 200, 200 because width of scece was 400, 400
					circle1.setCenterX(200 + xcord1); 
					circle1.setCenterY(200 + ycord1);
					circle1.setRadius(r1);
					
					circle1.setStroke(Color.BLACK);
					circle1.setFill(null);
					
					Circle circle2 = new Circle();
					circle2.setCenterX(200 + xcord2);
					circle2.setCenterY(200 + ycord2);
					circle2.setRadius(r2);
					
					circle2.setStroke(Color.BLACK);
					circle2.setFill(null);
					
					// putting the shapes in group pane
					Group shapes = new Group();
					shapes.getChildren().add(circle1);
					shapes.getChildren().add(circle2);
					
					// creating label for overlapping response
					Label overlap = new Label();
					overlap.setFont(new Font(20));
					
					  if (checkoverlap(xcord1, ycord1, r1,xcord2, ycord2, r2)) { // calling my function down below
			                overlap.setText("Your Circles OVERLAP");
			            } else {
			                overlap.setText("Your Circles do not OVERLAP");
			            }
					
					
					
					BorderPane layout3 = new BorderPane(); // creating borderpane to display the shapes and overlapping truth value
					layout3.setCenter(shapes);
					layout3.setBottom(overlap);
					
					// creating scence to show everything
					Scene scene3 = new Scene(layout3, 400, 400);
					window.setScene(scene3);
					
				}
			
			}); // closes submit hadle button
			
		}
}

/////////////////////////////////////////////////////////////////////////////////////////////////
//Handles the event if Square is clicked
class SquareHandler implements EventHandler<ActionEvent> { // this function is very similar to the circle one so i don't want to be redundant 
			
			@Override
			public void handle(ActionEvent e) {
					
				
				GridPane layout2 = new GridPane();
				layout2.setAlignment(Pos.CENTER);
				layout2.setPadding(new Insets(11, 12, 13, 14));
				layout2.setHgap(6);
				layout2.setVgap(6);
				
				TextField x1 = new TextField();
				TextField x2 = new TextField();
				TextField y1 = new TextField();
				TextField y2 = new TextField();
				TextField size1 = new TextField();
				TextField size2 = new TextField();
				
				layout2.add(new Label("Enter your Data for the Square"), 0, 0);
				
				layout2.add(new Label("X-Coordinate 1"), 0, 1);
				layout2.add(x1, 1, 1);

				layout2.add(new Label("Y-Coordinate 1"), 0, 2);
				layout2.add(y1, 1, 2);
				
				layout2.add(new Label("Width/Height 1"), 0, 3);
				layout2.add(size1, 1, 3);
				
				layout2.add(new Label("X-Coordinate 2"), 0, 4);
				layout2.add(x2, 1, 4);

				layout2.add(new Label("Y-Coordinate 2"), 0, 5);
				layout2.add(y2, 1, 5);
				
				layout2.add(new Label("Width/Height 2"), 0, 6);
				layout2.add(size2, 1, 6);

				Button submit = new Button("Submit");
				layout2.add(submit, 0, 7);
				
				Scene scene2 = new Scene(layout2, 400, 400);
				window.setScene(scene2);
				
				submit.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						
						int xcord1 = Integer.parseInt(x1.getText());
						int ycord1 = Integer.parseInt(y1.getText());
						ycord1 = ycord1 * -1;
						int s1 = Integer.parseInt(size1.getText());
						
						int xcord2 = Integer.parseInt(x2.getText());
						int ycord2 = Integer.parseInt(y2.getText());
						ycord2 = ycord2 * -1;
						int s2 = Integer.parseInt(size2.getText());
						
						
						
						Rectangle square1 = new Rectangle();
						square1.setX(200 + xcord1);
						square1.setY(200 + ycord1);
						square1.setWidth(s1);
						square1.setHeight(s1);
						
						square1.setStroke(Color.BLACK);
						square1.setFill(null);
						
						Rectangle square2 = new Rectangle();
						square2.setX(200 + xcord2);
						square2.setY(200 + ycord2);
						square2.setWidth(s2);
						square2.setHeight(s2);
						
						square2.setStroke(Color.BLACK);
						square2.setFill(null);
						
						
						Group shapes = new Group();
						shapes.getChildren().add(square1);
						shapes.getChildren().add(square2);
						
						Label overlap = new Label();
						overlap.setFont(new Font(20));
						
						  if (checkoverlap2(xcord1, xcord2, ycord1, ycord2)) { // callign the overlap function 2 for squares and rectangles
				                overlap.setText("Your Squares OVERLAP");
				            } else {
				                overlap.setText("Your Squares do not OVERLAP");
				            }
						
						BorderPane layout3 = new BorderPane();
						layout3.setCenter(shapes);
						layout3.setBottom(overlap);
						
						Scene scene3 = new Scene(layout3, 400, 400);
						window.setScene(scene3);
						
					}
				
				}); // closes submit hadle button

			}
			
		}
		
	


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Handles the event if Rectangle is clicked
class RectangleHandler implements EventHandler<ActionEvent> { // again this is very similar to my previous ones so I don't want to be redundant
		
		@Override
		public void handle(ActionEvent e) {

			GridPane layout2 = new GridPane();
			layout2.setAlignment(Pos.CENTER);
			layout2.setPadding(new Insets(11, 12, 13, 14));
			layout2.setHgap(6);
			layout2.setVgap(6);
			
			TextField x1 = new TextField();
			TextField x2 = new TextField();
			TextField y1 = new TextField();
			TextField y2 = new TextField();
			TextField w1 = new TextField();
			TextField w2 = new TextField();
			TextField h1 = new TextField();
			TextField h2 = new TextField();
			
			layout2.add(new Label("Enter your Data for the Square"), 0, 0);
			
			layout2.add(new Label("X-Coordinate 1"), 0, 1);
			layout2.add(x1, 1, 1);

			layout2.add(new Label("Y-Coordinate 1"), 0, 2);
			layout2.add(y1, 1, 2);
			
			layout2.add(new Label("Width 1"), 0, 3);
			layout2.add(w1, 1, 3);
			
			layout2.add(new Label("Height 1"), 0, 4);
			layout2.add(h1, 1, 4);
			
			
			layout2.add(new Label("X-Coordinate 2"), 0, 5);
			layout2.add(x2, 1, 5);

			layout2.add(new Label("Y-Coordinate 2"), 0, 6);
			layout2.add(y2, 1, 6);
			
			layout2.add(new Label("Width 2"), 0, 7);
			layout2.add(w2, 1, 7);
			
			layout2.add(new Label("Height 2"), 0, 8);
			layout2.add(h2, 1, 8);

			Button submit = new Button("Submit");
			layout2.add(submit, 0, 9);
			
			Scene scene2 = new Scene(layout2, 400, 400);
			window.setScene(scene2);
			
			submit.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					int xcord1 = Integer.parseInt(x1.getText());
					int ycord1 = Integer.parseInt(y1.getText());
					
					int width1 = Integer.parseInt(w1.getText());
					int height1 = Integer.parseInt(h1.getText());
					
					int xcord2 = Integer.parseInt(x2.getText());
					int ycord2 = Integer.parseInt(y2.getText());
					ycord2 = ycord2 * -1;
					int width2 = Integer.parseInt(w2.getText());
					int height2 = Integer.parseInt(h2.getText());
					
					
					Rectangle rect1 = new Rectangle();
					rect1.setX(200 + xcord1);
					rect1.setY(200 + ycord1);
					rect1.setWidth(width1);
					rect1.setHeight(height1);
					
					rect1.setStroke(Color.BLACK);
					rect1.setFill(null);
					
					Rectangle rect2 = new Rectangle();
					rect2.setX(200 + xcord2);
					rect2.setY(200 + ycord2);
					rect2.setWidth(width2);
					rect2.setHeight(height2);
					
					rect2.setStroke(Color.BLACK);
					rect2.setFill(null);
					
					
					Group shapes = new Group();
					shapes.getChildren().add(rect1);
					shapes.getChildren().add(rect2);
					
					Label overlap = new Label();
					overlap.setFont(new Font(20));
					
					  if (checkoverlap2(xcord1, xcord2, ycord1, ycord2)) {
			                overlap.setText("Your Rectangles OVERLAP");
			            } else {
			                overlap.setText("Your Rectangles do not OVERLAP");
			            }
					
					
					
					
					BorderPane layout3 = new BorderPane();
					layout3.setCenter(shapes);
					layout3.setBottom(overlap);
					
					Scene scene3 = new Scene(layout3, 400, 400);
					window.setScene(scene3);
					
				}
			
			}); // closes submit hadle button

		}
		
		
}
	

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// checking overlap for circles
public boolean checkoverlap(double x1, double y1, double r1, double x2, double y2, double r2) {

		// getting distances between coordinates
        double dx = x2 - x1;
        double dy = y2 - y1;

        // Distance between circles
        double d = Math.sqrt((dy * dy) + (dx * dx));

        // seeing if there is overlapping
        
        if (d > (r1 + r2)) {
           // no way they can overlap
            return false;
            
        } else if (d < Math.abs(r1 - r2)) {
            // they do indeed overlap
            return true;
        } else {
            return true;
        }

    }
	
//////////////////////////////////////////////////////////////////////////////////////////////////////	
	
public boolean checkoverlap2(int x1, int x2, int y1, int y2){ // method to see if square or rectangle overlap
	
	// Online it says this is how you see if two rectangle overlap
	if(x1 > x2 || y1 > y2)
		return false; // they don't overlap
	
	if(x1 < x2 || y1 < y2)
		return false; // they don't overlap
	
	return true; // they do overlap
	
	
	
}
	
	/////////////////////////////////////////////////
public static void main(String[] args){  // my main
		Application.launch(args); // calling application to show the box
	}

}
