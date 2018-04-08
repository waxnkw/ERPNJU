package ui.commodityUi;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;

public class AddSonClassificationUiStarter {
	public void initAddClassifictaionUi(Stage stage,String fatherID,String fatherName){
		//����������ʼ��
			try{
			FXMLLoader loader=new FXMLLoader(getClass().getResource("AddSonClassificationUi.fxml"));
			Parent root=loader.load();

			AddSonClassificationUiController controller=loader.getController();
			controller.setStage(stage);
			controller.setFather(fatherID,fatherName);

			Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.setTitle("�����µ������");
			stage.show();
			}catch(IOException e){
				e.printStackTrace();
			}

		}
}
