package ui.commodityUi;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.ClassificationVO;

public class ModifyClassificationUiStarter {
	public void initModifyClassifictaionUi(Stage stage,ClassificationVO vo){
		//����������ʼ��
			try{
			FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifyClassificationUi.fxml"));
			Parent root=loader.load();

			ModifyClassificationUiController controller=loader.getController();
			controller.setStage(stage);
			controller.setClassification(vo);
			controller.iniModifyClassificationUiInfor();

			Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.setTitle("�޸������Ϣ");
			stage.show();
			}catch(IOException e){
				e.printStackTrace();
			}

		}
}
