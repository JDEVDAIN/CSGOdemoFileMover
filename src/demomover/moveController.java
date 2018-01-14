package demomover;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;

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
	void move(ActionEvent event) {
		Move.demoScanner(selectedCsgoDirectory.toString());
		System.out.println("DONE");
	//System.out.println(Move.demoFilesScanned.length);
	//	Move.demoMover(selectedCsgoDirectory.toString(), selectedTargetDirectory.toString());

	}

}