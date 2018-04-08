/**
 * �ֿ����Ա����ʵ�ʿ������¼��Ľ���
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

public class ActualInventoryCheckUiStarter {
	private Stage currentStage;
	public void initActualInventoryCheckUi(Stage stage,String operatorName,String operatorID){
	//�ֿ����Աʵ�ʿ��ȷ�ϵĳ�ʼ����
		try{
			if(stage==null){
				currentStage=new Stage();
			}else{
				currentStage=stage;
			}
			FXMLLoader loader=new FXMLLoader(getClass().getResource("ActualInventoryCheckUi0.fxml"));
			Parent root=loader.load();

			Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);

			ActualInventoryCheckUiController controller=loader.getController();
			controller.setStage(currentStage);
			controller.setOperator(operatorID, operatorName);

			currentStage.setTitle("ʵ�ʿ���¼");
			currentStage.setScene(scene);
			currentStage.show();
			}catch(IOException e){
				e.printStackTrace();
			}
			//�����stage�з���fxml����ʾ����Ϊÿһ��������һ���µ�stage��
		    //�ֿ����Աʵ�ʿ��ȷ�ϵĳ�ʼ����
	}
}
