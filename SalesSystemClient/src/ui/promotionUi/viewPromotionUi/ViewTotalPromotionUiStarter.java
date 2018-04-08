package ui.promotionUi.viewPromotionUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.TotalStrategyVO;

public class ViewTotalPromotionUiStarter {
	private TotalStrategyVO totalStrategyVO;//�˽���Ҫ��ʾ��TotalStrategy��Ϣ

	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�

   /**
   * �޲������췽��
   */
	public ViewTotalPromotionUiStarter(TotalStrategyVO vo){
		this(new Stage(),vo);
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public ViewTotalPromotionUiStarter (Stage stage,TotalStrategyVO vo){
		this.stage = stage;
		this.totalStrategyVO = vo;
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(){
		try {
			URL location = getClass().getResource("ViewTotalPromotionUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
			
			//����controller���ҳ�ʼ��
			ViewTotalPromotionUiController contoller = flLoader.getController();
			contoller.setTotalStrategy(totalStrategyVO);
			contoller.init();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
