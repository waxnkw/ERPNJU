package ui.promotionUi;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.UserInfoVO;

/**
 * �ܾ���Ĵ������Խ���������
 * @author �Ű�  161250193
 * @version 2017.12.10
 */
public class PromotionUiStarter {
	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�

   /**
   * �޲������췽��
   */
	public PromotionUiStarter(){
		this(new Stage());
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public PromotionUiStarter(Stage stage){
		this.stage = stage;
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(UserInfoVO user){
		try {
			URL location = getClass().getResource("PromotionUi.fxml");
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
