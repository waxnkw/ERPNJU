package ui.approveBillUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.BillVO;
import vo.UserInfoVO;

public class AssignUiStarter {
	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�
	   /**
	   * �޲������췽��
	   */
		public AssignUiStarter(){
			this(new Stage());
		}
		
		/**
		* stage�ڽ���scene�л�
		* @param stage Ҫ�л���stage
		*/
		public AssignUiStarter(Stage stage){
			this.stage = stage;
		}
		
		/**
		* �½�һ���ܾ���������
		*/
		public void startAndWait(BillVO bill){
			try {
				URL location = getClass().getResource("AssignUi.fxml");
				FXMLLoader flLoader = new FXMLLoader(location);
				Parent root = flLoader.load();
				
				Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
				stage.setScene(scene);
				//stage.setTitle(user.getName()+"     "+user.getId());
				AssignController controller = flLoader.getController();
				controller.init(bill);
				stage.showAndWait();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
}
