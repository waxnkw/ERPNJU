/**
 * 
 */
package ui.loginUi;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author cosx
 *
 */
public class RegisterUiStarter {
	
	private Stage stage;
	
	public void setStage(Stage s){
		stage=s;
	}
	
	public void startRegister(boolean registered) {
			try {
				URL location = getClass().getResource("RegisterUi.fxml");
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(location);
				Parent root=loader.load();
				
				Scene scene=new Scene(root);
				stage.setScene(scene);
				
				RegisterUiController controller=loader.getController();
				controller.init(stage, registered);
	
				stage.show();
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
}
