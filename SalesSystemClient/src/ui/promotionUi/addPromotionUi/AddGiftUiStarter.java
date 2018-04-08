package ui.promotionUi.addPromotionUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.GiftVO;

public class AddGiftUiStarter {
	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�
	private PromotionUiForGiftsUiController controller;
	private GiftVO goods;//ҳ���ʼ��ʱ��Ҫ��ʵ��goods
	
   /**
   * �޲������췽��
   */
	public AddGiftUiStarter(PromotionUiForGiftsUiController controller){
		this(new Stage(),controller);
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public AddGiftUiStarter(Stage stage,PromotionUiForGiftsUiController controller){
		this.controller = controller;
		this.stage = stage;
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(){
		try {
			URL location = getClass().getResource("AddGiftUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
			
			//����controller���ҳ�ʼ��
			AddGiftUiController contoller = flLoader.getController();
			contoller.setAddPromotionUiController(this.controller);
			contoller.init();
			if(goods!=null){
				contoller.setCurrentShowGoods(goods);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startAndShowGoods(GiftVO goods){
		this.goods = goods;
		start();
	}
}
