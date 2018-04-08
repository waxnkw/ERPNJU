/**
 * �鿴�ֿ����Ա�ƶ��ĵ��ݽ��棬������汨��������汨�𵥡���汨�����Ľ���
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package ui.billUi.viewBillUi;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;

public class ViewWareKeeperBillUiStarter {
	private Stage billStage=new Stage();
	public void viewInventoryWarningBill(String billID){
	//��汨��������
	   try{
		   FXMLLoader loader=new FXMLLoader(getClass().getResource("WareKeeperBillsUi.fxml"));



		   Parent root=loader.load();
		   ViewWareKeeperBillUiController controller=loader.getController();
		   controller.setInventoryWarningBill(billStage, billID);
		   //��bill���������ú�
		   Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);

		   billStage.setScene(scene);
		   billStage.setTitle("�鿴��汨����");
		   billStage.show();
	   }catch(IOException e){
		   e.printStackTrace();
	   }
	}

	public void viewInventoryLossBill(String billID){
	//��汨�𵥽���
		try{
			   FXMLLoader loader=new FXMLLoader(getClass().getResource("WareKeeperBillsUi.fxml"));

			   //��bill���������ú�

			   Parent root=loader.load();

			   ViewWareKeeperBillUiController controller=loader.getController();
			   controller.setInventoryLossBill(billStage, billID);
			   Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);

			   billStage.setScene(scene);
			   billStage.setTitle("�鿴��汨��");
			   billStage.show();
		   }catch(IOException e){
			   e.printStackTrace();
		   }
	}

	public void viewInventoryOverBill(String billID){
	//��汨�絥
		try{
			   FXMLLoader loader=new FXMLLoader(getClass().getResource("WareKeeperBillsUi.fxml"));

			   //��bill���������ú�

			   Parent root=loader.load();
               ViewWareKeeperBillUiController controller=loader.getController();
			   controller.setInventoryOverBill(billStage, billID);
			   Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);

			   billStage.setScene(scene);
			   billStage.setTitle("�鿴��汨�絥");
			   billStage.show();
		   }catch(IOException e){
			   e.printStackTrace();
		   }
	}
}
