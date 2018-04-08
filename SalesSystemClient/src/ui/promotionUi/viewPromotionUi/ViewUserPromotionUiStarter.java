package ui.promotionUi.viewPromotionUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.UserStrategyVO;


public class ViewUserPromotionUiStarter {
	private UserStrategyVO userStrategyVO;//�˽���Ҫ��ʾ��userstrategy��Ϣ

	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�

   /**
   * �޲������췽��
   */
	public ViewUserPromotionUiStarter(UserStrategyVO vo){
		this(new Stage(),vo);
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public ViewUserPromotionUiStarter (Stage stage,UserStrategyVO vo){
		this.stage = stage;
		this.userStrategyVO = vo;
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(){
		try {
			URL location = getClass().getResource("ViewUserPromotionUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			

			//����controller���ҳ�ʼ��
			ViewUserPromotionUiContoller contoller = flLoader.getController();
			contoller.setUserStrategy(userStrategyVO);
			contoller.init();
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
