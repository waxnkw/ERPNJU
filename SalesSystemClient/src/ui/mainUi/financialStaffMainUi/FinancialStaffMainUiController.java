package ui.mainUi.financialStaffMainUi;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import ui.billUi.billStateUi.FinancialStaffBillStateUiStarter;
import ui.financeUi.BankAccountUiStarter;
import ui.financeUi.InOutUiStarter;
import ui.financeUi.NewFinanceBillsUiStarter;
import ui.listUi.BusinessConditionListUiStarter;
import ui.listUi.BusinessProcessListUiStarter;
import ui.listUi.SalesDetailsListUiStarter;
import vo.UserInfoVO;

public class FinancialStaffMainUiController {
	
	private static UserInfoVO user;
	
	@FXML
	private Text userNameTag;
	
	@FXML
	private Text userIdTag;
	
	public void init(UserInfoVO u){
		user=u;
		
		userNameTag.setText(user.getName());
		userIdTag.setText(user.getId());
	}
	
	@FXML
	protected void bankAccountButtonListener() throws Exception{
	//	ProgressIndicator indicator=new ProgressIndicator();
	//	indicator.setVisible(true);
		
	//	Popup pop=new Popup();
	//	pop.getContent().add(indicator);
	//	pop.show(stage);
		
		BankAccountUiStarter starter=new BankAccountUiStarter();
		starter.viewBankAccounts();
	}
	
	@FXML
	protected void newRecieptBillButtonListener() throws Exception{
		NewFinanceBillsUiStarter starter=new NewFinanceBillsUiStarter(user);
		
		starter.newReceiptBill();
	}
	
	@FXML
	protected void newPaymentBillButtonListener() throws Exception{
		NewFinanceBillsUiStarter starter=new NewFinanceBillsUiStarter(user);
		
		starter.newPaymentBill();
	}
	
	@FXML
	protected void newCashExpenseBillButtonListener() throws Exception{
		NewFinanceBillsUiStarter starter=new NewFinanceBillsUiStarter(user);

		starter.newCashExpenseBill();
	}
	
	@FXML
	protected void billStateButtonListener() throws Exception{
		FinancialStaffBillStateUiStarter starter=new FinancialStaffBillStateUiStarter();
		starter.setUser(user);
		
		starter.financialStaffBillStateUi();
	}
	
	@FXML
	protected void salesDetailsListButtonListener() throws Exception{
		SalesDetailsListUiStarter starter=new SalesDetailsListUiStarter();
		
		starter.salesDetailsListUi();
	}
	
	@FXML
	protected void businessProcessListButtonListener() throws Exception{
		BusinessProcessListUiStarter starter=new BusinessProcessListUiStarter();
		
		starter.businessProcessListUi();
	}
	
	@FXML
	protected void businessConditionListButtonListener() throws Exception{
		BusinessConditionListUiStarter starter=new BusinessConditionListUiStarter();
		
		starter.businessConditionListUi();
	}
	
	@FXML
	protected void inOutsButtonListener() throws Exception{
		InOutUiStarter starter=new InOutUiStarter();
		
		starter.viewInOuts();
	}
	
	@FXML
	protected void exitButtonListener() throws Exception{
		System.exit(0);
	}
}
