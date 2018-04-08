/**
 * 
 */
package ui.billUi.viewBillUi;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;

/**
 * @author ����һ
 *
 */
public class ViewSalesmanBillsUiStarter {

	private Stage stage=new Stage();
	
	public void viewPurchaseBill(String billId) {
		try {
			URL location = getClass().getResource("ViewSalesmanPurchaseBillUi.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			ViewSalesmanPurchaseBillUiController controller=loader.getController();
			controller.viewPurchaseBill("��Ӧ�̽�����", billId);
			
			stage.show();
		} catch (Exception e) {
			
		}
	}
	
	public void viewPurchaseReturnBill(String billId) {
		try {
			URL location = getClass().getResource("ViewSalesmanPurchaseBillUi.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			ViewSalesmanPurchaseBillUiController controller=loader.getController();
			controller.viewPurchaseBill("��Ӧ�̽����˻���", billId);
			
			stage.show();
		} catch (Exception e) {
			
		}
	}	
	
	public void viewSalesReturnBill(String billId) {
		try {
			URL location = getClass().getResource("ViewSalesmanPurchaseBillUi.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			ViewSalesmanPurchaseBillUiController controller=loader.getController();
			controller.viewPurchaseBill("�����̳����˻���", billId);
			
			stage.show();
		} catch (Exception e) {
			
		}
	}
	
	public void viewSalesBill(String billId) {
		try {
			URL location = getClass().getResource("ViewSalesmanSalesBillUi.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			ViewSalesmanSalesBillUiController controller=loader.getController();
			controller.viewSalesBill("�����̳�����", billId);
			
			stage.show();
		} catch (Exception e) {
			
		}
	}
	
}































