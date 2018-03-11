/********************************************************
 *
 *  Project :  <Name of project|assignment>
 *  File    :  PigLatin.java
 *  Name    :  Alexander O'Dowd
 *  Date    :  Mar 11, 2018 3:40:52 AM
 *
 *  Description : (Narrative desciption, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *
 *    2) What data-structures are used.
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *
 *    4) What methods are implemented (optional).
 *
 *  Changes :  <Description|date of modifications>
 *  Created java file | Mar 11, 2018
 *
 ********************************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PigLatin extends Application {
	   @Override
	   public void start(Stage stage) throws Exception {
	      Parent root = 
	         FXMLLoader.load(getClass().getResource("PigLatin.fxml"));

	      Scene scene = new Scene(root); // attach scene graph to scene
	      stage.getIcons().add(new Image("computer icon.png"));
	      stage.setTitle("Pig Latin"); // displayed in window's title bar
	      stage.setScene(scene); // attach scene to stage
	      stage.show(); // display the stage
	   }

	   public static void main(String[] args) {
	      // create a GUIDemo object and call its start method
	      launch(args); 
	   }
	}
