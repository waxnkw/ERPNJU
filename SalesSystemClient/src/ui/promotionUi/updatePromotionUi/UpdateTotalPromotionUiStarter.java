package ui.promotionUi.updatePromotionUi;

import java.net.URL;
import java.util.ResourceBundle.Control;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.promotionUi.PromotionUiController;
import ui.uiAssistants.StageSize;
import vo.TotalStrategyVO;

public class UpdateTotalPromotionUiStarter {
	private PromotionUiController promotionUiController;//��������controller������
	private TotalStrategyVO totalStrategyVO;//�˽���Ҫ��ʾ��totalStrategy��Ϣ

	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�

   /**
   * �޲������췽��
   */
	public UpdateTotalPromotionUiStarter(PromotionUiController promotionUiController,TotalStrategyVO vo){
		this(new Stage(),promotionUiController,vo);
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public UpdateTotalPromotionUiStarter (Stage stage,PromotionUiController promotionUiController,TotalStrategyVO vo){
		this.promotionUiController = promotionUiController;
		this.stage = stage;
		this.totalStrategyVO =vo;
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(){
		try {
			URL location = getClass().getResource("UpdateTotalPromotionUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			
			//����controller���ҳ�ʼ��
			UpdateTotalPromotionUiController contoller = flLoader.getController();
			contoller.setPromotionUiController(promotionUiController);
			contoller.setTotalStrategyVO(totalStrategyVO);
			contoller.init();
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
