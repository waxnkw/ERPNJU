/**
 * �ֿ����Ա������Ʒ��Ϣ�������
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

public class GoodsInforManagementUiStarter {
	private Stage currentStage;
	public void initGoodsInforManagementUi(Stage stage){
		//��ʼ����Ʒ��Ϣ�������
			try{
			if(stage==null){
				currentStage=new Stage();
			}else{
				currentStage=stage;
			}
			FXMLLoader loader=new FXMLLoader(getClass().getResource("GoodsInforManaUi0.fxml"));
			Parent root=loader.load();

			Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);

			GoodsInforManagementUiController controller=loader.getController();
			controller.setStage(currentStage);

			currentStage.setTitle("��Ʒ��Ϣ����");
			currentStage.setScene(scene);
			currentStage.show();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
}
