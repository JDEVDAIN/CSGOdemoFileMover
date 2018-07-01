/**
 * 
 */
package demomover;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MoverFxGui extends Application {
	public static Stage primaryStage;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane mainAnchorPane = (AnchorPane) FXMLLoader.load(MoverFxGui.class.getResource("moveWindow.fxml"));
		primaryStage.setScene(new Scene(mainAnchorPane));
		primaryStage.setResizable(false);
		primaryStage.setTitle("CSGODemoMover");

		primaryStage.show();

	}

}
