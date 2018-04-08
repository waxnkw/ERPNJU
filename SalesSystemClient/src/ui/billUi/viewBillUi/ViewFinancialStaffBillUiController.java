package ui.billUi.viewBillUi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import blService.billService.viewBillBlService.ViewFinanceStaffBillBlService;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import rmi.remoteHelper.RemoteHelperFactory;
import rmi.remoteHelper.ViewBillRemoteHelper;
import vo.BillEntryVO;
import vo.CashExpenseBillVO;
import vo.PaymentBillVO;
import vo.ReceiptBillVO;
import vo.UserInfoVO;

/**
 * 查看财务类单据controller
 * @author guxinyu
 * @version 2017.12.6
 *
 */
public class ViewFinancialStaffBillUiController {
	@FXML
	private AnchorPane billAnchorPane;
	
	@FXML
	private ScrollPane billScrollPane;
	
	@FXML
	private Text billNameText;
	
	@FXML
	private Text billIdText;
	
	@FXML
	private Text createDateText;
	
	@FXML
	private Text makerText;
	
	@FXML
	private Text bankAccountText;
	
	@FXML
	private VBox entryVBox;
	
	@FXML
	private Text sumText;
	
	@FXML
	private Text makerCommentText;
	
	@FXML
	private Label billStateLabel;
	
	@FXML
	private Text approverText;
	
	@FXML
	private Text executorText;
	
	@FXML
	private Text approveDateText;
	
	@FXML
	private Text finishDateText;
	
	@FXML
	private TextArea approverCommentArea;
	
	private ViewBillRemoteHelper remoteHelper=RemoteHelperFactory.getViewBillRemoteHelper();
	
//	private ViewFinanceStaffBillBlService financeBillBl=new ViewFinanceStaffBillBlService_Stub();
	
	private ViewFinanceStaffBillBlService financeBillBl=remoteHelper.getViewFinanceStaffBillBlService();
	
	public void init(String billType, String billId){
		billNameText.setText("xxxx公司"+billType);
	
		switch (billType){
		case "现金费用单":
			CashExpenseBillVO ceBill=null;
			try {
				ceBill=financeBillBl.getCashExpenseBill(billId);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			billIdText.setText(ceBill.getId());
			createDateText.setText(ceBill.getCreateDate().getDate());
			UserInfoVO cmaker=ceBill.getCreater();
			makerText.setText(cmaker.getName()+" "+cmaker.getId());
			bankAccountText.setText(ceBill.getBankAccount());
			sumText.setText(String.valueOf(ceBill.getSum()));
			makerCommentText.setText(ceBill.getCreaterComment());
			billStateLabel.setText(ceBill.getBillStateEnum().toString());
			UserInfoVO capprover=ceBill.getApprover();
			approverText.setText(capprover.getName()+" "+capprover.getId());
			UserInfoVO cexecutor=ceBill.getExecutor();
			executorText.setText(cexecutor.getName()+" "+cexecutor.getId());
			approveDateText.setText(ceBill.getApproveDate().getDate());
			finishDateText.setText(ceBill.getFinishDate().getDate());
			approverCommentArea.setText(ceBill.getApproverComment());
			
			ArrayList<BillEntryVO> cbillEntries=ceBill.getEntries();
			
			for(int i=0;i<cbillEntries.size();i++){
				BillEntryVO eachEntry=cbillEntries.get(i);
				Text name=new Text(eachEntry.getEntryName());
				Text money=new Text(eachEntry.getEntryMoney());
				
				name.setFont(Font.font(20));
				money.setFont(Font.font(20));
				
				HBox entryHBox=new HBox();
				entryHBox.getChildren().addAll(name, money);
				entryHBox.setAlignment(Pos.CENTER);
				entryHBox.setSpacing(400);
				entryVBox.getChildren().add(entryVBox.getChildren().size()-1, entryHBox);
				
				if(i!=cbillEntries.size()-1){
					Separator hSep=new Separator();
					hSep.setPrefSize(920, 3);
					hSep.setMaxSize(920, 3);
					hSep.setMinSize(920, 3);
					entryVBox.getChildren().add(entryVBox.getChildren().size()-1, hSep);
				}
			}
			break;
		case "收款单":
			ReceiptBillVO rBill=null;
			try {
				rBill=financeBillBl.getReceiptBill(billId);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			billIdText.setText(rBill.getId());
			createDateText.setText(rBill.getCreateDate().getDate());
			UserInfoVO rmaker=rBill.getCreater();
			makerText.setText(rmaker.getName()+" "+rmaker.getId());
			bankAccountText.setText(rBill.getBankAccount());
			sumText.setText(String.valueOf(rBill.getSum()));
			makerCommentText.setText(rBill.getCreaterComment());
			billStateLabel.setText(rBill.getBillStateEnum().toString());
			UserInfoVO rapprover=rBill.getApprover();
			approverText.setText(rapprover.getName()+" "+rapprover.getId());
			UserInfoVO rexecutor=rBill.getExecutor();
			executorText.setText(rexecutor.getName()+" "+rexecutor.getId());
			approveDateText.setText(rBill.getApproveDate().getDate());
			finishDateText.setText(rBill.getFinishDate().getDate());
			approverCommentArea.setText(rBill.getApproverComment());
			
			ArrayList<BillEntryVO> rbillEntries=rBill.getEntries();
			
			for(int i=0;i<rbillEntries.size();i++){
				BillEntryVO eachEntry=rbillEntries.get(i);
				Text name=new Text(eachEntry.getEntryName());
				Text money=new Text(eachEntry.getEntryMoney());
				
				name.setFont(Font.font(20));
				money.setFont(Font.font(20));
				
				HBox entryHBox=new HBox();
				entryHBox.getChildren().addAll(name, money);
				entryHBox.setAlignment(Pos.CENTER);
				entryHBox.setSpacing(400);
				entryVBox.getChildren().add(entryVBox.getChildren().size()-1, entryHBox);
				
				if(i!=rbillEntries.size()-1){
					Separator hSep=new Separator();
					hSep.setPrefSize(920, 3);
					hSep.setMaxSize(920, 3);
					hSep.setMinSize(920, 3);
					entryVBox.getChildren().add(entryVBox.getChildren().size()-1, hSep);
				}
			}
			break;
		case "付款单":
			PaymentBillVO pBill=null;
			try {
				pBill=financeBillBl.getPaymentBill(billId);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			billIdText.setText(pBill.getId());
			createDateText.setText(pBill.getCreateDate().getDate());
			UserInfoVO pmaker=pBill.getCreater();
			makerText.setText(pmaker.getName()+" "+pmaker.getId());
			bankAccountText.setText(pBill.getBankAccount());
			sumText.setText(String.valueOf(pBill.getSum()));
			makerCommentText.setText(pBill.getCreaterComment());
			billStateLabel.setText(pBill.getBillStateEnum().toString());
			UserInfoVO papprover=pBill.getApprover();
			approverText.setText(papprover.getName()+" "+papprover.getId());
			UserInfoVO pexecutor=pBill.getExecutor();
			executorText.setText(pexecutor.getName()+" "+pexecutor.getId());
			approveDateText.setText(pBill.getApproveDate().getDate());
			finishDateText.setText(pBill.getFinishDate().getDate());
			approverCommentArea.setText(pBill.getApproverComment());
			
			ArrayList<BillEntryVO> pbillEntries=pBill.getEntries();
			
			for(int i=0;i<pbillEntries.size();i++){
				BillEntryVO eachEntry=pbillEntries.get(i);
				Text name=new Text(eachEntry.getEntryName());
				Text money=new Text(eachEntry.getEntryMoney());
				
				name.setFont(Font.font(20));
				money.setFont(Font.font(20));
				
				HBox entryHBox=new HBox();
				entryHBox.getChildren().addAll(name, money);
				entryHBox.setAlignment(Pos.CENTER);
				entryHBox.setSpacing(400);
				entryVBox.getChildren().add(entryVBox.getChildren().size()-1, entryHBox);
				
				if(i!=pbillEntries.size()-1){
					Separator hSep=new Separator();
					hSep.setPrefSize(920, 3);
					hSep.setMaxSize(920, 3);
					hSep.setMinSize(920, 3);
					entryVBox.getChildren().add(entryVBox.getChildren().size()-1, hSep);
				}
			}
			break;
		}
	}
	
	@FXML
	protected void printButtonListener() throws Exception{
		
	}
}
