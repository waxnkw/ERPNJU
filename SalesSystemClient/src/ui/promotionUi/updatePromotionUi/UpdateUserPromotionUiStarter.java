package ui.promotionUi.updatePromotionUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.promotionUi.PromotionUiController;
import ui.uiAssistants.StageSize;
import vo.UserStrategyVO;


public class UpdateUserPromotionUiStarter {
	
		private PromotionUiController promotionUiController;//��������controller������
		private UserStrategyVO userStrategyVO;//�˽���Ҫ��ʾ��userStrategy��Ϣ
	
		private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�

	   /**
	   * �޲������췽��
	   */
		public UpdateUserPromotionUiStarter(PromotionUiController promotionUiController,UserStrategyVO vo){
			this(new Stage(),promotionUiController,vo);
		}
		
		/**
		* stage�ڽ���scene�л�
		* @param stage Ҫ�л���stage
		*/
		public UpdateUserPromotionUiStarter(Stage stage,PromotionUiController promotionUiController,UserStrategyVO vo){
			this.promotionUiController = promotionUiController;
			this.stage = stage;
			this.userStrategyVO= vo;
		}
		
		/**
		* �½�һ���ܾ���������
		*/
		public void start(){
			try {
				URL location = getClass().getResource("UpdateUserPromotionUi.fxml");
				FXMLLoader flLoader = new FXMLLoader(location);
				Parent root = flLoader.load();
				
				Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
				stage.setScene(scene);
				stage.show();
				
				//����controller���ҳ�ʼ��
				UpdateUserPromotionUiContoller contoller = flLoader.getController();
				contoller.setPromotionUiController(promotionUiController);
				contoller.setUserStrategyVO(userStrategyVO);
				contoller.init();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
}
