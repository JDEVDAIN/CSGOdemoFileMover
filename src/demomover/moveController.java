package demomover;

import java.io.File;
import java.io.IOException;

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

public class moveController {
	File selectedCsgoDirectory;
	File selectedTargetDirectory;
	@FXML
	private Label targetDirLabel;
	@FXML
	private Label csgoDirLabel;
	@FXML
	private Button startButton;
	@FXML
	private Button informationButton;
	
	@FXML
	void chooseCsgoDir(ActionEvent event) {

		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("choose CSGO folder");

		File likelyDefaultCsgofolder = new File("C:\\Steam\\steamapps\\common\\Counter-Strike Global Offensive\\csgo");

		if (likelyDefaultCsgofolder.exists()) {
			chooser.setInitialDirectory(likelyDefaultCsgofolder);
		}

		selectedCsgoDirectory = chooser.showDialog(MoverFxGui.primaryStage);
		if (selectedCsgoDirectory == null) {
			csgoDirLabel.setText("No Directory selected");
		} else {
			csgoDirLabel.setText(selectedCsgoDirectory.getAbsolutePath());

		}
		if (selectedCsgoDirectory != null && selectedTargetDirectory != null) {
			startButton.setDisable(false);
		} else {
			startButton.setDisable(true);
		}
	}

	@FXML
	void chooseTragetDir(ActionEvent event) {

		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("choose Target folder");

		selectedTargetDirectory = chooser.showDialog(MoverFxGui.primaryStage);
		if (selectedTargetDirectory == null) {
			targetDirLabel.setText("No Directory selected");
		} else {
		targetDirLabel.setText(selectedTargetDirectory.getAbsolutePath());

		}
		if (selectedCsgoDirectory != null && selectedTargetDirectory != null) {
			startButton.setDisable(false);
		} else {
			startButton.setDisable(true);
		}
	}

	@FXML
	void showInformation(ActionEvent event) {
		//works
		//TODO styling 
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText("I have a great message for you!");

		alert.showAndWait();
	}
	@FXML //startbutton
	void move(ActionEvent event) throws IOException {
		Move.demoScanner(selectedCsgoDirectory.toString());
		System.out.println("DONE");
		 Stage stage = new Stage();
         stage.setTitle("My New Stage Title");
         AnchorPane mainAnchorPane = (AnchorPane) FXMLLoader.load(MoverFxGui.class.getResource("moveConfirm.fxml"));
         stage.setScene(new Scene(mainAnchorPane, 283, 159)); //TODO check for borders
         stage.show();
		
	//System.out.println(Move.demoFilesScanned.length);
	//	Move.demoMover(selectedCsgoDirectory.toString(), selectedTargetDirectory.toString()); //TODO move in right class 

	}

}