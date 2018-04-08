package ui.promotionUi.updatePromotionUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.promotionUi.PromotionUiController;
import ui.uiAssistants.StageSize;
import vo.ComboStrategyVO;

public class UpdateComboPromotionUiStarter {
	private PromotionUiController promotionUiController;//��������controller������
	private ComboStrategyVO comboStrategyVO;//�˽���Ҫ��ʾ��userstrategy��Ϣ

	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�

   /**
   * �޲������췽��
   */
	public UpdateComboPromotionUiStarter(PromotionUiController promotionUiController,ComboStrategyVO vo){
		this(new Stage(),promotionUiController,vo);
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public UpdateComboPromotionUiStarter (Stage stage,PromotionUiController promotionUiController,ComboStrategyVO vo){
		this.promotionUiController = promotionUiController;
		this.stage = stage;
		this.comboStrategyVO = vo;
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(){
		try {
			URL location = getClass().getResource("UpdateComboPromotionUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
			
			//����controller���ҳ�ʼ��
			UpdateComboPromotionUiController contoller = flLoader.getController();
			contoller.setPromotionUiController(promotionUiController);
			contoller.setComboStrategyVO(comboStrategyVO);
			contoller.init();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
