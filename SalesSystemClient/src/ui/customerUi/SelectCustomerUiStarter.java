/**
 * 
 */
package ui.customerUi;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;

import assistant.type.UserPositionEnum;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.UserInfoVO;

/**
 * @author ����һ 161250140
 *
 */
public class SelectCustomerUiStarter {

	private Stage stage;
	
	public void setStage(Stage stage) {
		this.stage=stage;
	}
	
	public void selectCustomer(UserInfoVO user) {
		try {
			
			URL location=getClass().getResource("SelectCustomerUi.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
		    loader.setBuilderFactory(new JavaFXBuilderFactory());
			Parent root = loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			SelectCustomerUiController controller=loader.getController();
			controller.init(user.getId(), user.getName(), user.getUserPositionEnum());
			
			stage.show();
			
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
