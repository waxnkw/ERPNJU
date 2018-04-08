/**
 * 
 */
package ui.mainUi.salesmanMainUi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ui.billUi.billStateUi.SalesmanBillStateUiStarter;
import ui.customerUi.AddCustomerUiStarter;
import ui.customerUi.SelectCustomerUiStarter;
import ui.salesUi.NewSalesmanBillsUiStarter;
import vo.UserInfoVO;

/**
 * @author ����һ
 *
 */
public class SalesmanMainUiController {

	private UserInfoVO user;
	
	@FXML
	private Label userNameLabel;
	
	@FXML
	private Label userIdLabel;
	
	public void init(UserInfoVO vo) {
		user=vo;
		
		userIdLabel.setText(vo.getId());
		
		userNameLabel.setText(vo.getName());
	}
	
	@FXML
	protected void viewCustomerButtonListener() {
		SelectCustomerUiStarter starter=new SelectCustomerUiStarter();
		
		Stage stage=new Stage();
		
		starter.setStage(stage);
		starter.selectCustomer(user);
	}
	
	@FXML
	protected void addCustomerButtonListener() {
		AddCustomerUiStarter starter=new AddCustomerUiStarter(user);
		
		Stage stage=new Stage();
		
		starter.setStage(stage);
		starter.addCustomer();
	}
	
	@FXML
	protected void newPurchaseButtonListener() {
		NewSalesmanBillsUiStarter starter=new NewSalesmanBillsUiStarter(user);
		
		Stage stage=new Stage();
		
		starter.setStage(stage);
		starter.newPurchaseBill();
	}
	
	@FXML
	protected void newPurchaseReturnButtonListener() {
		NewSalesmanBillsUiStarter starter=new NewSalesmanBillsUiStarter(user);
		
		Stage stage=new Stage();
		
		starter.setStage(stage);
		starter.newPurchaseReturnBill();
	}
	
	@FXML
	protected void newSalesButtonListener() {
		NewSalesmanBillsUiStarter starter=new NewSalesmanBillsUiStarter(user);
		
		Stage stage=new Stage();
		
		starter.setStage(stage);
		starter.newSalesBill();
	}
	
	@FXML
	protected void newSalesReturnButtonListener() {
		NewSalesmanBillsUiStarter starter=new NewSalesmanBillsUiStarter(user);
		
		Stage stage=new Stage();
		
		starter.setStage(stage);
		starter.newSalesReturnBill();
	}
	
	@FXML
	protected void billStateButtonListener() {
		SalesmanBillStateUiStarter starter=new SalesmanBillStateUiStarter(user);
		
		starter.setUser(user);
		starter.salesmanBillStateUi();
	}
	
}
