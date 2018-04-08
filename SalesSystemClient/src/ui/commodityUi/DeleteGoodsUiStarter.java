/**
 * �ֿ����Ա������Ʒɾ������Ʒ����Ľ���
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

public class DeleteGoodsUiStarter {
	private Stage currentStage;
	public void initDeleteGoodsUi(Stage stage,String operatorid,String operatorname){
		//ɾ����Ʒ��ʼ����
			try{
				if(stage==null){
					currentStage=new Stage();
				}else{
					currentStage=stage;
				}

				FXMLLoader loader=new FXMLLoader(getClass().getResource("DeleteGoodsUi0.fxml"));
				Parent root=loader.load();
				Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);

				DeleteGoodsUiController controller=loader.getController();
				controller.setStage(currentStage);
				controller.setOperator(operatorid, operatorname);

				currentStage.setTitle("������Ʒ");
				currentStage.setScene(scene);
				currentStage.show();
				}catch(IOException e){
					e.printStackTrace();
				}
		}
}
