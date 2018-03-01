package demomover;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;
import sun.print.resources.serviceui;

public class ConfirmController {

	@FXML
	private Label moveInfos;
	@FXML
	private Button yesButton;
	@FXML
	private Button noButton;
	@FXML
	private ProgressBar loadingBar;
	@FXML
	private Label wantToContinue;

	public void initialize() {

		moveInfos.setText(Move.infoForConfirm);
		System.out.println("demonumber" + Move.demoAmountForConfirm);
		if (Move.demoAmountForConfirm == 0) { // check if demos are found
			yesButton.setDisable(true);
		} else {
			yesButton.setDisable(false);
		}

		Thread loadingBarThread = new Thread() {
			public void run() {
				while (Move.moveCounter != Move.demoAmountForConfirm) {

					double test = 0;
					double demoPercentValue = 0;
					demoPercentValue = 100 / Move.demoAmountForConfirm;
					System.out.println("demoamounfforconfirm   " + Move.demoAmountForConfirm);

					test = (Move.moveCounter * demoPercentValue) / 100;
					System.out.println("value set for demo:" + test);
					System.out.println("movecounter: " + Move.moveCounter + "        demoamount for confirm: "
							+ Move.demoAmountForConfirm);
		

					loadingBar.setProgress(test);

					try {
						sleep(800);
					} catch (Exception e) {
						// TODO: handle exception
					}

				}

			}

		};

		loadingBarThread.start();
	}

	@FXML
	void letsGo(ActionEvent event) {
		System.out.println("lETSSEEE GOO");

		// TODO surround with thread
		Thread moverThread = new Thread() {
			public void run() {
				Move.demoMover(MoveController.selectedCsgoDirectory.toString(),
						MoveController.selectedTargetDirectory.toString());
				loadingBar.setProgress(1);

			}

		};

		moverThread.start();
	}

	@FXML
	void noAction(ActionEvent event) {
		System.out.println("abort mission");
		Move.demoAmountForConfirm = 0; //resets
		Move.moveCounter = 0; //resets
		Stage stage = (Stage) noButton.getScene().getWindow();
		stage.close();
	}
}
