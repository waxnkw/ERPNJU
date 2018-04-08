package ui.mainUi.adminMainUi;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.UserInfoVO;

/**
 * �ܾ����������������
 * @author �Ű�  161250193
 * @version 2017.12.10
 */
public class AdminMainUiStarter {
	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�

   /**
   * �޲������췽��
   */
	public AdminMainUiStarter(){
		this(new Stage());
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public AdminMainUiStarter(Stage stage){
		this.stage = stage;
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(UserInfoVO user){
		try {
			Stage stage = new Stage();
			URL location = getClass().getResource("AdminMainUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
