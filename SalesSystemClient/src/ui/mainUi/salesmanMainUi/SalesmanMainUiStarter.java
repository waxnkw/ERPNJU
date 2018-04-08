package ui.mainUi.salesmanMainUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.loginUi.LoginUiController;
import vo.UserInfoVO;

//���۽�����Ա������
public class SalesmanMainUiStarter {

	private Stage stage=new Stage();
	
	UserInfoVO user;
	
	public void startSalesman(UserInfoVO vo) {
		user=vo;
		
		try {
			URL location = getClass().getResource("SalesmanMainUi.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root,600,400);
			stage.setScene(scene);
			
			SalesmanMainUiController controller=loader.getController();
			controller.init(user);
			stage.show();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
