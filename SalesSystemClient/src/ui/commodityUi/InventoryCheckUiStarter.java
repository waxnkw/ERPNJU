/**
 * �ֿ����Ա���п���̵�Ľ���
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package ui.commodityUi;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;

public class InventoryCheckUiStarter {
	private Stage stage=new Stage();
	public void initInventoryCheckUi(){
	//��ʼ�����������
		try{
			FXMLLoader loader=new FXMLLoader(getClass().getResource("InventoryCheckUi.fxml"));
			Parent root=loader.load();

			InventoryCheckUiController controller=loader.getController();
			controller.setInventoryCheckSheetContents();
			stage.setTitle("����̵�");
			controller.setInitInfor(stage);


			Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
