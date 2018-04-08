/**
 * �ֿ����Ա������Ʒ���Ӻ����Ľ���
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

public class AddGoodsUiStarter {
	private Stage currentStage;
	public void initAddGoodsUi(Stage stage,String operatorName){
		//�ֿ����Ա������Ʒ�ĳ�ʼ���棬�ӵ��÷����뵱ǰ����Ա����
		if(stage==null){
			currentStage=new Stage();
		}else{
			currentStage=stage;
		}
			try{
			FXMLLoader loader=new FXMLLoader(getClass().getResource("AddGoodsUi0.fxml"));
			Parent root=loader.load();

			Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);

			AddGoodsUiController controller=loader.getController();
			controller.setStage(currentStage);
			controller.setOperator(operatorName);

			currentStage.setTitle("������Ʒ");
			currentStage.setScene(scene);
			currentStage.show();
			}catch(IOException e){
				e.printStackTrace();
			}
		}

}
