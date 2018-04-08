package ui.listUi;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.InventoryLossBillVO;
import vo.InventoryOverBillVO;
import vo.InventoryWarningBillVO;

public class EditInventoryBillUiStarter {
       public void editInventoryWarningBill(InventoryWarningBillVO billVO,String type){
    	   try{
    		   Stage editBillStage=new Stage();
//һ������һ�������Ĵ��ڣ�����stageд������
    		   FXMLLoader loader=new FXMLLoader(getClass().getResource("EditInventoryBillUi.fxml"));
    		   Parent root=loader.load();

    		   EditInventoryBillUiController controller=loader.getController();
    		   controller.editInventoryWarningBill(editBillStage, billVO,type);


    		   Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);
    		   editBillStage.setScene(scene);
    		   editBillStage.setTitle("�༭��汨����");
    		   editBillStage.show();

    	   }catch(IOException e){
    		   e.printStackTrace();
    	   }
       }
       public void editInventoryLossBill(InventoryLossBillVO billVO,String type){
    	   try{
    		   Stage editBillStage=new Stage();

    		   FXMLLoader loader=new FXMLLoader(getClass().getResource("EditInventoryBillUi.fxml"));
               Parent root=loader.load();

    		   EditInventoryBillUiController controller=loader.getController();
    		   controller.editInventoryLossBill(editBillStage, billVO,type);


    		   Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);
    		   editBillStage.setScene(scene);
    		   editBillStage.setTitle("�༭��汨��");
    		   editBillStage.show();

    	   }catch(IOException e){
    		   e.printStackTrace();
    	   }
       }
       public void editInventoryOverBill(InventoryOverBillVO billVO,String type){
    	   try{
    		   Stage editBillStage=new Stage();

    		   FXMLLoader loader=new FXMLLoader(getClass().getResource("EditInventoryBillUi.fxml"));
    		   Parent root=loader.load();

    		   EditInventoryBillUiController controller=loader.getController();
    		   controller.editInventoryOverBill(editBillStage, billVO,type);


    		   Scene scene=new Scene(root,StageSize.STAGE_WIDTH,StageSize.STAGE_HEIGHT);
    		   editBillStage.setScene(scene);
    		   editBillStage.setTitle("�༭��汨�絥");
    		   editBillStage.show();

    	   }catch(IOException e){
    		   e.printStackTrace();
    	   }
       }
}
