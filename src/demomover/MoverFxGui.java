/**
 * 
 */
package demomover;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author JannisLaptop
 *
 */
public class MoverFxGui extends Application {
	static Stage primaryStage;

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane mainAnchorPane = (AnchorPane) FXMLLoader.load(MoverFxGui.class.getResource("moveWindow.fxml"));
		primaryStage.setScene(new Scene(mainAnchorPane));
		primaryStage.setResizable(false);
		primaryStage.setTitle("CSGODemoMover");
		
		primaryStage.show();

	}

}
