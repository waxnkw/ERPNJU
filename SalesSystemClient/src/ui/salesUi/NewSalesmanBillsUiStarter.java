/**
 * 
 */
package ui.salesUi;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;
import vo.UserInfoVO;

/**
 * @author ����һ
 * @version 2017.12.24
 * ����������Ա�½����ݽ���������
 *
 */
public class NewSalesmanBillsUiStarter {
	private Stage stage=new Stage();
	
	private UserInfoVO user;
	
	public void setStage(Stage stage) {
		this.stage=stage;
	}
	
	public NewSalesmanBillsUiStarter(UserInfoVO user) {
		this.user=user;
	}
	
	public void newPurchaseBill() {
		try {
			
			URL location = getClass().getResource("NewPurchaseBill.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			NewPurchaseBillUiController controller=loader.getController();
			controller.init(user);
			
			stage.show();
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void editPurchaseBill(PurchaseBillVO bill) {
		
		try {
			
			URL location = getClass().getResource("NewPurchaseBill.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			NewPurchaseBillUiController controller=loader.getController();
			controller.init(user);
			controller.showContent(bill);
			
			stage.show();
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void newPurchaseReturnBill() {
		try {
			
			URL location = getClass().getResource("NewPurchaseReturnBill.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			NewPurchaseReturnBillUiController controller=loader.getController();
			controller.init(user);
			
			stage.show();
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void editPurchaseReturnBill(PurchaseReturnBillVO bill) {
		try {
			
			URL location = getClass().getResource("NewPurchaseReturnBill.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			NewPurchaseReturnBillUiController controller=loader.getController();
			controller.showContent(bill);
			
			stage.show();
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void newSalesBill() {
		try {
			
			URL location = getClass().getResource("NewSalesBill.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			NewSalesBillUiController controller=loader.getController();
			controller.init(user);
			
			stage.show();
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void editSalesBill(SalesBillVO bill) {
		try {
			
			URL location = getClass().getResource("NewSalesBill.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			NewSalesBillUiController controller=loader.getController();
			controller.init(user);
			controller.showContent(bill);
			
			stage.show();
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void newSalesReturnBill() {
		try {
			
			URL location = getClass().getResource("NewSalesReturnBill.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			NewSalesReturnBillUiController controller=loader.getController();
			controller.init(user);
			
			stage.show();
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void editSalesReturnBill(SalesReturnBillVO bill) {
		try {
			
			URL location = getClass().getResource("NewSalesReturnBill.fxml");
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(location);
			Parent root=loader.load();
			
			Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			
			NewSalesReturnBillUiController controller=loader.getController();
			controller.init(user);
			controller.showContent(bill);
			
			stage.show();
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
