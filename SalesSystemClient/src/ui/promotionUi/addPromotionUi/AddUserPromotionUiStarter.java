package ui.promotionUi.addPromotionUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.promotionUi.PromotionUiController;
import ui.uiAssistants.StageSize;


public class AddUserPromotionUiStarter {
	
		private PromotionUiController promotionUiController;//��������controller������
		//private UserStrategyVO userStrategyVO;//�˽���Ҫ��ʾ��userstrategy��Ϣ
	
		private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�

	   /**
	   * �޲������췽��
	   */
		public AddUserPromotionUiStarter(PromotionUiController promotionUiController){
			this(new Stage(),promotionUiController);
		}
		
		/**
		* stage�ڽ���scene�л�
		* @param stage Ҫ�л���stage
		*/
		public AddUserPromotionUiStarter(Stage stage,PromotionUiController promotionUiController){
			this.promotionUiController = promotionUiController;
			this.stage = stage;
		}
		
		/**
		* �½�һ���ܾ���������
		*/
		public void start(){
			try {
				URL location = getClass().getResource("AddUserPromotionUi.fxml");
				FXMLLoader flLoader = new FXMLLoader(location);
				Parent root = flLoader.load();
				
				Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
				stage.setScene(scene);
				stage.show();
				
				//����controller���ҳ�ʼ��
				AddUserPromotionUiContoller contoller = flLoader.getController();
				contoller.setPromotionUiController(promotionUiController);
				contoller.init();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
}
