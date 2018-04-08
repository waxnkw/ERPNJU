package ui.billUi.billStateUi;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.UserInfoVO;

/**
 * ���۽�����Ա����״̬����
 * @author guxinyu
 * @version 2017.12.19
 *
 */
public class SalesmanBillStateUiStarter{
	private Stage stage=new Stage();
	
	private UserInfoVO user;
	
	public void setUser(UserInfoVO user){
		this.user=user;
	}
	
	public SalesmanBillStateUiStarter(UserInfoVO u){
		user=u;
	}
	
	public void salesmanBillStateUi(){
		URL location = getClass().getResource("SalesmanBillStateUi.fxml");
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(location);
	    loader.setBuilderFactory(new JavaFXBuilderFactory());
		Parent root=null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
		stage.setScene(scene);
		
		SalesmanBillStateUiController controller=new SalesmanBillStateUiController();
		controller.init(user);
		
		stage.show();
	}
}
