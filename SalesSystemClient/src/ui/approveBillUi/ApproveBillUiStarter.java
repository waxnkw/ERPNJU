package ui.approveBillUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.UserInfoVO;

/**
 * �ܾ�����������ݽ���������
 * @author �Ű�  161250193
 * @version 2017.12.10
 */
public class ApproveBillUiStarter {
	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�

   /**
   * �޲������췽��
   */
	public ApproveBillUiStarter(){
		this(new Stage());
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public ApproveBillUiStarter(Stage stage){
		this.stage = stage;
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(UserInfoVO user){
		try {
			URL location = getClass().getResource("ApproveBillUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			//stage.setTitle(user.getName()+"     "+user.getId());
			ApproveBillUiController controller = flLoader.getController();
			controller.init(user);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
