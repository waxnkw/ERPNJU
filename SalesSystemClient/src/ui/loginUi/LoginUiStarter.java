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
 * @author ����һ
 * @version 2017.12.27
 * ��¼����
 *
 */
public class LoginUiStarter {

	private Stage stage;
	
	public void setStage(Stage s){
		stage=s;
	}
	
	public void startLogin() {
		try {
			URL location = getClass().getResource("LoginUi.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root);
			stage.setScene(scene);
			LoginUiController controller=loader.getController();
			controller.init(stage);
			
			stage.getScene().setFill(null);
			stage.getScene().getRoot().setStyle(
					"-fx-background-color: transparent");
			
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
