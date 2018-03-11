
/********************************************************
 *
 *  Project :  <Name of project|assignment>
 *  File    :  PigLatinController.java
 *  Name    :  Alexander O'Dowd
 *  Date    :  Mar 11, 2018 3:51:40 AM
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

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PigLatinController
{
	String punctuation = "";

	@FXML
	private Button btnTranslate;

	@FXML
	private TextField txtInput;

	@FXML
	private MenuItem menuClose;

	@FXML
	private TextField txtOutput;

	@FXML
	private Button btnClear;

	@FXML
	private MenuItem menuAbout;

	@FXML
	void close(ActionEvent event)
	{
		System.exit(0);
	}

	@FXML
	void about(ActionEvent event)
	{
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("About.fxml"));
			/*
			 * if "fx:controller" is not set in fxml
			 * fxmlLoader.setController(NewWindowController);
			 */
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			stage.getIcons().add(new Image("about.png"));
			stage.setTitle("About");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void translate(ActionEvent event)
	{
		txtOutput.setText(convertToLatin(txtInput.getText()));
	}

	@FXML
	void clear(ActionEvent event)
	{
		txtInput.setText("");
		txtOutput.setText("");
	}

	private String convertToLatin(String input)
	{
		StringBuilder builder = new StringBuilder();
		String[] splitInput = input.split("\\s+");
		// String output = "";
		StringBuilder buffer = new StringBuilder();
		int arrayIndex;

		for (arrayIndex = 0; arrayIndex < splitInput.length; arrayIndex++)
		{
			if (arrayIndex == 0)
			{
				splitInput[0] = splitInput[0].toLowerCase();
			}
			if (arrayIndex != splitInput.length - 1)
			{

				builder.replace(0, builder.length(), splitInput[arrayIndex]);
				builder.replace(0, builder.length(), parsePunctuation(builder));
				builder.append(builder.charAt(0) + "ay" + punctuation);
				builder.deleteCharAt(0);
				buffer.append(builder.toString() + " ");
			}
			if (arrayIndex == splitInput.length - 1)
			{
				builder.replace(0, builder.length(), splitInput[arrayIndex]);
				builder.replace(0, builder.length(), parsePunctuation(builder));
				builder.append(builder.charAt(0) + "ay");
				builder.deleteCharAt(0);
				buffer.append(builder.toString() + punctuation);
			}
		}
		String b2 = buffer.toString();
		String output = Character.toUpperCase(b2.charAt(0)) + b2.substring(1);

		return output;
	}

	private String parsePunctuation(StringBuilder word)
	{
		if (checkPunctuation(word.toString()))
		{
			punctuation = word.charAt(word.length() - 1) + "";
			word.deleteCharAt(word.length() - 1);
		}
		else
		{
			punctuation = "";
		}

		return word.toString();
	}

	private boolean checkPunctuation(String punctuation)
	{
		boolean checked = false;
		if (punctuation.charAt(punctuation.length() - 1) == '!' | punctuation.charAt(punctuation.length() - 1) == '?'
				| punctuation.charAt(punctuation.length() - 1) == '.'
				| punctuation.charAt(punctuation.length() - 1) == ',')
		{
			checked = true;
		}

		return checked;
	}

}
