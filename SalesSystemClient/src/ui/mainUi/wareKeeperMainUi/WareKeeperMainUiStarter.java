/**
 * �ֿ����Ա��½�������棬����������������в����İ�ť
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package ui.mainUi.wareKeeperMainUi;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;

public class WareKeeperMainUiStarter {
	//��ʼ���ֿ������Ա������
	public void wareKeeperMainUi(Stage stage,String name,String ID){
		try{
			FXMLLoader loader=new FXMLLoader(getClass().getResource("WareKeeperMainUi.fxml"));
			Parent root=loader.load();
			
			WareKeeperMainUiController controller=loader.getController();
			controller.setInitInfor(name, ID,stage);


			Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);
            stage.setScene(scene);
			stage.setTitle("�ֿ����");
			stage.show();
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}
