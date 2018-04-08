package ui.promotionUi.viewPromotionUi;

import java.net.URL;

import javax.swing.text.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.promotionUi.PromotionUiController;
import ui.uiAssistants.StageSize;
import vo.ComboStrategyVO;
import vo.UserStrategyVO;

public class ViewComboPromotionUiStarter {
	private ComboStrategyVO comboStrategyVO;//�˽���Ҫ��ʾ��userstrategy��Ϣ

	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�

   /**
   * �޲������췽��
   */
	public ViewComboPromotionUiStarter(ComboStrategyVO vo){
		this(new Stage(),vo);
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public ViewComboPromotionUiStarter (Stage stage,ComboStrategyVO vo){
		this.stage = stage;
		this.comboStrategyVO=vo;
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(){
		try {
			URL location = getClass().getResource("ViewComboPromotionUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
			
			//����controller���ҳ�ʼ��
			ViewComboPromotionUiController contoller = flLoader.getController();
			contoller.setComboStrategy(comboStrategyVO);
			contoller.init();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
