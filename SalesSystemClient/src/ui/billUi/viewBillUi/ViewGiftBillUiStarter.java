package ui.billUi.viewBillUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.GiftBillVO;

public class ViewGiftBillUiStarter {
	private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�
	private String  billId;//ҳ���ʼ��ʱ��Ҫ��ʵ��goods
	
   /**
   * �޲������췽��
   */
	public ViewGiftBillUiStarter(String billId){
		this(new Stage(),billId);
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public ViewGiftBillUiStarter(Stage stage,String billId){
		this.stage = stage;
		this.billId = billId;
	}
	
	/**
	* �½�һ��giftBill���ݲ鿴����
	*/
	public void start(){
		try {
			URL location = getClass().getResource("ViewGiftBillUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			
			//����controller���ҳ�ʼ��
			ViewGiftBillUiController controller = flLoader.getController();
			controller.init(billId);
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
