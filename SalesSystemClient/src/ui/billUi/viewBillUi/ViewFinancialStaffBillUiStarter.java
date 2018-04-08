package ui.billUi.viewBillUi;

import java.io.IOException;
import java.net.URL;
import assistant.type.BillStateEnum;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;

/**
 * �鿴�����൥�ݽ���starter
 * @author guxinyu
 * @version 2017.12.12
 *
 */
public class ViewFinancialStaffBillUiStarter{
	private Stage stage=new Stage();
	
	public void viewCashExpenseBill(String billId){
		URL location = getClass().getResource("ViewFinancialStaffBillUi.fxml");
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(location);
	    loader.setBuilderFactory(new JavaFXBuilderFactory());
		Parent root=null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
		stage.setScene(scene);
		
		ViewFinancialStaffBillUiController controller=loader.getController();
		controller.init("�ֽ���õ�", billId);
		
		stage.show();
	}
	
	public void viewReceiptBill(String billId){
		URL location = getClass().getResource("ViewFinancialStaffBillUi.fxml");
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(location);
	    loader.setBuilderFactory(new JavaFXBuilderFactory());
		Parent root=null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
		stage.setScene(scene);
		
		ViewFinancialStaffBillUiController controller=loader.getController();
		controller.init("�տ", billId);
		
		stage.show();
	}
	
	public void viewPaymentBill(String billId){
		URL location = getClass().getResource("ViewFinancialStaffBillUi.fxml");
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(location);
	    loader.setBuilderFactory(new JavaFXBuilderFactory());
		Parent root=null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
		stage.setScene(scene);
		
		ViewFinancialStaffBillUiController controller=loader.getController();
		controller.init("���", billId);
		
		stage.show();
	}
}
