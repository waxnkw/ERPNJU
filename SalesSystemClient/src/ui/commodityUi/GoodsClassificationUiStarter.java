/**
 * �ֿ����Ա���п��������Ľ���
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

public class GoodsClassificationUiStarter {
	private Stage currentStage;
	public void initGoodsClassificationUi(Stage stage){
		//����������ʼ��
		if(stage==null){
			//�Ӳֿ����Ա��ʼ�������ʱ��û��stage�ģ���Ҫ�Լ�new
			currentStage=new Stage();
		}else{
			//�������������Ľ����˻��������ʱ���ǻᴫͬһ��stage��
			currentStage=stage;
		}
			try{
			FXMLLoader loader=new FXMLLoader(getClass().getResource("GoodsClassificationUi0.fxml"));
			Parent root=loader.load();

			GoodsClassificationUiController controller=loader.getController();
			controller.setStage(stage);
			controller.initAndUpdateClassificationTree();

			Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);
            controller.setStage(currentStage);

			currentStage.setScene(scene);
			currentStage.setTitle("��Ʒ�������");
			currentStage.show();
			}catch(IOException e){
				e.printStackTrace();
			}

		}
}
