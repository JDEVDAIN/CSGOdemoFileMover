package demomover;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.Console;

import com.sun.org.apache.xerces.internal.dom.AbortException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import sun.print.resources.serviceui;

public class ConfirmController {
	// TODO make that you can only click  only this window 
	@FXML
	static  Label moveInfo;
	@FXML
	private Button yesButton;
	@FXML
	private Button noButton;
	@FXML
	static  ProgressBar loadingBar;
	@FXML
	private Label wantToContinue;

	
	@FXML
	void letsGo(ActionEvent event) {
		System.out.println("lETSSEEE GOO");
	//ConfirmController.loadingBar.setProgress(0.5); //test
		//TODO make progressbar work 
	}

	@FXML
	void noAction(ActionEvent event) {
		System.out.println("abort mission");
	}
}
