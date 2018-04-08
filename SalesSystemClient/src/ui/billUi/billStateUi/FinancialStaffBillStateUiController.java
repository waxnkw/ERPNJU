package ui.billUi.billStateUi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import assistant.type.BillStateEnum;
import blService.billService.billStateBlService.FinancialStaffBillStateBlService;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import rmi.remoteHelper.BillStateRemoteHelper;
import rmi.remoteHelper.RemoteHelperFactory;
import ui.billUi.viewBillUi.ViewFinancialStaffBillUiStarter;
import ui.financeUi.NewFinanceBillsUiStarter;
import ui.mainUi.financialStaffMainUi.FinancialStaffMainUiStarter;
import ui.uiAssistants.StageSize;
import vo.CashExpenseBillVO;
import vo.PaymentBillVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.ReceiptBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;
import vo.UserInfoVO;

/**
 * ������Ա����״̬����controller
 * @author guxinyu
 * @version 2017.12.9
 *
 */
public class FinancialStaffBillStateUiController {
	@FXML
	private Button toMakeButton;
	
	@FXML
	private Button unpassButton;
	
	@FXML
	private Button passButton;
	
	@FXML
	private Button doneButton;
	
	@FXML
	private HBox billsHBox;
	
	private BillStateRemoteHelper remoteHelper=RemoteHelperFactory.getBillStateRemoteHelper();
	
//	private FinancialStaffBillStateBlService billStateBl=new FinancialStaffBillStateBlService_Stub();
	
	private FinancialStaffBillStateBlService billStateBl=remoteHelper.getFinancialStaffBillStateBlService();
	
	private UserInfoVO user;
	
	public void init(UserInfoVO u){
		user=u;
	}
	
	private void threeBox(BillStateEnum state){
		Separator sep1=new Separator();
		sep1.setOrientation(Orientation.VERTICAL);
		Separator sep2=new Separator();
		sep2.setOrientation(Orientation.VERTICAL);
		Separator sep3=new Separator();
		sep3.setOrientation(Orientation.VERTICAL);
		
		//�ⲿVBox
		VBox cashOuterBox=new VBox();
		VBox paymentOuterBox=new VBox();
		VBox receiptOuterBox=new VBox();
		
		//��С
		int boxWidth=350;
		cashOuterBox.setPrefSize(boxWidth, 786);
		cashOuterBox.setMaxSize(boxWidth, 786);
		cashOuterBox.setMinSize(boxWidth, 786);
		paymentOuterBox.setPrefSize(boxWidth, 786);
		paymentOuterBox.setMaxSize(boxWidth, 786);
		paymentOuterBox.setMinSize(boxWidth, 786);
		receiptOuterBox.setPrefSize(boxWidth, 786);
		receiptOuterBox.setMaxSize(boxWidth, 786);
		receiptOuterBox.setMinSize(boxWidth, 786);
		
		//�ڱ߾�
		cashOuterBox.setPadding(new Insets(20,0,0,0));
		paymentOuterBox.setPadding(new Insets(20,0,0,0));
		receiptOuterBox.setPadding(new Insets(20,0,0,0));
		
		//��������
		cashOuterBox.setSpacing(20);
		paymentOuterBox.setSpacing(20);
		receiptOuterBox.setSpacing(20);
		
		//��������뷽ʽ
		cashOuterBox.setAlignment(Pos.TOP_CENTER);
		paymentOuterBox.setAlignment(Pos.TOP_CENTER);
		receiptOuterBox.setAlignment(Pos.TOP_CENTER);
		
		//��ʾLabel
		Label cashPrompt=new Label("�ֽ���õ�");
		cashPrompt.setFont(Font.font(29));
		Label paymentPrompt=new Label("���");
		paymentPrompt.setFont(Font.font(29));
		Label receiptPrompt=new Label("�տ");
		receiptPrompt.setFont(Font.font(29));
		
		//�ڲ�ScollPane
		ScrollPane cashScroll=new ScrollPane();
		cashScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		ScrollPane paymentScroll=new ScrollPane();
		paymentScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		ScrollPane receiptScroll=new ScrollPane();
		receiptScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		//ScrollPane��С�̶�
		cashScroll.setPrefSize(boxWidth, 650);
		cashScroll.setMaxSize(boxWidth, 650);
		cashScroll.setMinSize(boxWidth, 650);
		paymentScroll.setPrefSize(boxWidth, 650);
		paymentScroll.setMaxSize(boxWidth, 650);
		paymentScroll.setMinSize(boxWidth, 650);
		receiptScroll.setPrefSize(boxWidth, 650);
		receiptScroll.setMaxSize(boxWidth, 650);
		receiptScroll.setMinSize(boxWidth, 650);
		
		//�ڲ�VBox
		VBox cashInnerBox=new VBox();
		VBox paymentInnerBox=new VBox();
		VBox receiptInnerBox=new VBox();
		
		cashScroll.setContent(cashInnerBox);
		paymentScroll.setContent(paymentInnerBox);
		receiptScroll.setContent(receiptInnerBox);
		
		cashInnerBox.setPrefSize(boxWidth, 650);
		paymentInnerBox.setPrefSize(boxWidth, 650);
		receiptInnerBox.setPrefSize(boxWidth, 650);
	
		cashInnerBox.setSpacing(10);
		paymentInnerBox.setSpacing(10);
		receiptInnerBox.setSpacing(10);
		
		cashInnerBox.setAlignment(Pos.TOP_CENTER);
		paymentInnerBox.setAlignment(Pos.TOP_CENTER);
		receiptInnerBox.setAlignment(Pos.TOP_CENTER);
		
		cashOuterBox.getChildren().addAll(cashPrompt,cashScroll);
		paymentOuterBox.getChildren().addAll(paymentPrompt,paymentScroll);
		receiptOuterBox.getChildren().addAll(receiptPrompt,receiptScroll);
		
		billsHBox.getChildren().addAll(sep1, cashOuterBox, sep2, paymentOuterBox, sep3, receiptOuterBox);
		
		ArrayList<CashExpenseBillVO> cashExpenseBills=null;
		ArrayList<PaymentBillVO> paymentBills=null;
		ArrayList<ReceiptBillVO> receiptBills=null;
		try {
			cashExpenseBills=billStateBl.getCashExpenseBillList(state);
			paymentBills=billStateBl.getPaymentBillList(state);
			receiptBills=billStateBl.getReceiptBillList(state);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		if(cashExpenseBills!=null){
			//��ʾ�ֽ���õ�
			for(int i=0;i<cashExpenseBills.size();i++){
				CashExpenseBillVO thisBill=cashExpenseBills.get(i);
			
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
			
				Text billId=new Text(thisBill.getId());
				billId.setFont(Font.font(15));
			
				each.getChildren().add(billId);
			
				if(state==BillStateEnum.DENIED){//δͨ�����
					Button edit=new Button("�޸�");
					edit.setFont(Font.font(15));
					Button delete=new Button("ɾ��");
					delete.setFont(Font.font(15));
					each.getChildren().addAll(edit, delete);
				
					edit.setOnAction(oa ->{
						NewFinanceBillsUiStarter starter=new NewFinanceBillsUiStarter(user);
						starter.editCashExpenseBill(thisBill);
					});
				
					delete.setOnAction(oa->{
						try {
							if(billStateBl.deleteUnpassCashExpenseBill(thisBill))
								cashInnerBox.getChildren().remove(each);
							else{
							
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					});
				}else if(state==BillStateEnum.TODO){//ͨ�����
					Button view=new Button("�鿴");
					view.setFont(Font.font(15));
					Button print=new Button("��ӡ");
					print.setFont(Font.font(15));
					each.getChildren().addAll(view, print);
				
					view.setOnAction(oa ->{
						ViewFinancialStaffBillUiStarter starter=new ViewFinancialStaffBillUiStarter();
						starter.viewCashExpenseBill(thisBill.getId());
					});
				
					print.setOnAction(oa ->{
					
					});
				}else if(state==BillStateEnum.DONE){//�������
					Button view=new Button("�鿴");
					view.setFont(Font.font(15));
				
					each.getChildren().add(view);
					
					view.setOnAction(oa ->{
						ViewFinancialStaffBillUiStarter starter=new ViewFinancialStaffBillUiStarter();
						starter.viewCashExpenseBill(thisBill.getId());
					});
				}
			
				cashInnerBox.getChildren().add(each);
			}
		}
		
		if(paymentBills!=null){
			//��ʾ���
			for(int i=0;i<paymentBills.size();i++){
				PaymentBillVO thisBill=paymentBills.get(i);
			
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
			
				Text billId=new Text(thisBill.getId());
				billId.setFont(Font.font(15));
			
				each.getChildren().add(billId);
			
				if(state==BillStateEnum.DENIED){//δͨ�����
					Button edit=new Button("�޸�");
					edit.setFont(Font.font(15));
					Button delete=new Button("ɾ��");
					delete.setFont(Font.font(15));
					each.getChildren().addAll(edit, delete);
				
					edit.setOnAction(oa ->{
						NewFinanceBillsUiStarter starter=new NewFinanceBillsUiStarter(user);
						starter.editPaymentBill(thisBill);
					});
				
					delete.setOnAction(oa->{
						try {
							if(billStateBl.deleteUnpassPaymentBill(thisBill))
								paymentInnerBox.getChildren().remove(each);
							else{
							
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					});
				}else if(state==BillStateEnum.TODO){//ͨ�����
					Button view=new Button("�鿴");
					view.setFont(Font.font(15));
					Button print=new Button("��ӡ");
					print.setFont(Font.font(15));
					each.getChildren().addAll(view, print);
				
					view.setOnAction(oa ->{
						ViewFinancialStaffBillUiStarter starter=new ViewFinancialStaffBillUiStarter();
						starter.viewPaymentBill(thisBill.getId());
					});
				
					print.setOnAction(oa ->{
					
					});
				}else if(state==BillStateEnum.DONE){//�������
					Button view=new Button("�鿴");
					view.setFont(Font.font(15));
				
					each.getChildren().add(view);
				
					view.setOnAction(oa ->{
						ViewFinancialStaffBillUiStarter starter=new ViewFinancialStaffBillUiStarter();
						starter.viewPaymentBill(thisBill.getId());
					});
				}
			
				paymentInnerBox.getChildren().add(each);
			}
		}
		
		if(receiptBills!=null){
			//��ʾ�տ
			for(int i=0;i<receiptBills.size();i++){
				ReceiptBillVO thisBill=receiptBills.get(i);
			
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
			
				Text billId=new Text(thisBill.getId());
				billId.setFont(Font.font(15));
			
				each.getChildren().add(billId);
			
				if(state==BillStateEnum.DENIED){//δͨ�����
					Button edit=new Button("�޸�");
					edit.setFont(Font.font(15));
					Button delete=new Button("ɾ��");
					delete.setFont(Font.font(15));
					each.getChildren().addAll(edit, delete);
				
					edit.setOnAction(oa ->{
						NewFinanceBillsUiStarter starter=new NewFinanceBillsUiStarter(user);
						starter.editReceiptBill(thisBill);
					});
				
					delete.setOnAction(oa->{
						try {
							if(billStateBl.deleteUnpassReceiptBill(thisBill))
								receiptInnerBox.getChildren().remove(each);
							else{
							
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					});
				}else if(state==BillStateEnum.TODO){//ͨ�����
					Button view=new Button("�鿴");
					view.setFont(Font.font(15));
					Button print=new Button("��ӡ");
					print.setFont(Font.font(15));
					each.getChildren().addAll(view, print);
					
					view.setOnAction(os ->{
						ViewFinancialStaffBillUiStarter starter=new ViewFinancialStaffBillUiStarter();
						starter.viewReceiptBill(thisBill.getId());
					});
				
					print.setOnAction(oa ->{
					
					});
				}else if(state==BillStateEnum.DONE){//�������
					Button view=new Button("�鿴");
					view.setFont(Font.font(15));
				
					each.getChildren().add(view);
				
					view.setOnAction(oa ->{
						ViewFinancialStaffBillUiStarter starter=new ViewFinancialStaffBillUiStarter();
						starter.viewReceiptBill(thisBill.getId());
					});
				}
			
				receiptInnerBox.getChildren().add(each);
			}
		}
		
	}
	
	@FXML
	protected void toMakeButtonListener() throws Exception{
		billsHBox.getChildren().clear();
		
		Separator sep1=new Separator();
		sep1.setOrientation(Orientation.VERTICAL);
		Separator sep2=new Separator();
		sep2.setOrientation(Orientation.VERTICAL);
		Separator sep3=new Separator();
		sep3.setOrientation(Orientation.VERTICAL);
		Separator sep4=new Separator();
		sep4.setOrientation(Orientation.VERTICAL);
		
		//�ⲿVBox
		VBox purchaseOuterBox=new VBox();
		VBox purchaseReOuterBox=new VBox();
		VBox salesOuterBox=new VBox();
		VBox salesReOuterBox=new VBox();
		
		//��С
		int boxWidth=265;
		purchaseOuterBox.setPrefSize(boxWidth, StageSize.STAGE_HEIGHT);
		purchaseOuterBox.setMaxSize(boxWidth, StageSize.STAGE_HEIGHT);
		purchaseOuterBox.setMinSize(boxWidth, StageSize.STAGE_HEIGHT);
		purchaseReOuterBox.setPrefSize(boxWidth, StageSize.STAGE_HEIGHT);
		purchaseReOuterBox.setMaxSize(boxWidth, StageSize.STAGE_HEIGHT);
		purchaseReOuterBox.setMinSize(boxWidth, StageSize.STAGE_HEIGHT);
		salesOuterBox.setPrefSize(boxWidth, StageSize.STAGE_HEIGHT);
		salesOuterBox.setMaxSize(boxWidth, StageSize.STAGE_HEIGHT);
		salesOuterBox.setMinSize(boxWidth, StageSize.STAGE_HEIGHT);
		salesReOuterBox.setPrefSize(boxWidth, StageSize.STAGE_HEIGHT);
		salesReOuterBox.setMaxSize(boxWidth, StageSize.STAGE_HEIGHT);
		salesReOuterBox.setMinSize(boxWidth, StageSize.STAGE_HEIGHT);
		
		//�ڱ߾�
		purchaseOuterBox.setPadding(new Insets(20,0,0,0));
		purchaseReOuterBox.setPadding(new Insets(20,0,0,0));
		salesOuterBox.setPadding(new Insets(20,0,0,0));
		salesReOuterBox.setPadding(new Insets(20,0,0,0));
		
		//��������
		purchaseOuterBox.setSpacing(20);
		purchaseReOuterBox.setSpacing(20);
		salesOuterBox.setSpacing(20);
		salesReOuterBox.setSpacing(20);
		
		//��������뷽ʽ
		purchaseOuterBox.setAlignment(Pos.TOP_CENTER);
		purchaseReOuterBox.setAlignment(Pos.TOP_CENTER);
		salesOuterBox.setAlignment(Pos.TOP_CENTER);
		salesReOuterBox.setAlignment(Pos.TOP_CENTER);
		
		//��ʾLabel
		Label purchasePrompt=new Label("������");
		purchasePrompt.setFont(Font.font(29));
		Label purchaseRePrompt=new Label("�����˻���");
		purchaseRePrompt.setFont(Font.font(29));
		Label salesPrompt=new Label("���۵�");
		salesPrompt.setFont(Font.font(29));
		Label salesRePrompt=new Label("�����˻���");
		salesRePrompt.setFont(Font.font(29));
		
		//�ڲ�ScollPane
		ScrollPane purchaseScroll=new ScrollPane();
		purchaseScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		ScrollPane purchaseReScroll=new ScrollPane();
		purchaseReScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		ScrollPane salesScroll=new ScrollPane();
		salesScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		ScrollPane salesReScroll=new ScrollPane();
		salesReScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		//ScrollPane��С�̶�
		purchaseScroll.setPrefSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		purchaseScroll.setMaxSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		purchaseScroll.setMinSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		purchaseReScroll.setPrefSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		purchaseReScroll.setMaxSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		purchaseReScroll.setMinSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		salesScroll.setPrefSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		salesScroll.setMaxSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		salesScroll.setMinSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		salesReScroll.setPrefSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		salesReScroll.setMaxSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		salesReScroll.setMinSize(boxWidth, StageSize.STAGE_HEIGHT-156);
		
		//�ڲ�VBox
		VBox purchaseInnerBox=new VBox();
		VBox purchaseReInnerBox=new VBox();
		VBox salesInnerBox=new VBox();
		VBox salesReInnerBox=new VBox();
		
		purchaseScroll.setContent(purchaseInnerBox);
		purchaseReScroll.setContent(purchaseReInnerBox);
		salesScroll.setContent(salesInnerBox);
		salesReScroll.setContent(salesReInnerBox);
		
		purchaseInnerBox.setPrefSize(boxWidth, 650);
		purchaseReInnerBox.setPrefSize(boxWidth, 650);
		salesInnerBox.setPrefSize(boxWidth, 650);
		salesReInnerBox.setPrefSize(boxWidth, 650);
		
		purchaseInnerBox.setSpacing(10);
		purchaseReInnerBox.setSpacing(10);
		salesInnerBox.setSpacing(10);
		salesReInnerBox.setSpacing(10);
		
		purchaseInnerBox.setAlignment(Pos.TOP_CENTER);
		purchaseReInnerBox.setAlignment(Pos.TOP_CENTER);
		salesInnerBox.setAlignment(Pos.TOP_CENTER);
		salesReInnerBox.setAlignment(Pos.TOP_CENTER);
		
		purchaseOuterBox.getChildren().addAll(purchasePrompt,purchaseScroll);
		purchaseReOuterBox.getChildren().addAll(purchaseRePrompt,purchaseReScroll);
		salesOuterBox.getChildren().addAll(salesPrompt,salesScroll);
		salesReOuterBox.getChildren().addAll(salesRePrompt,salesReScroll);
		
		billsHBox.getChildren().addAll(
				sep1, purchaseOuterBox, sep2, purchaseReOuterBox, sep3, salesOuterBox, sep4, salesReOuterBox);
		
		ArrayList<PurchaseBillVO> purchaseBills=null;
		ArrayList<PurchaseReturnBillVO> purchaseReturnBills=null;
		ArrayList<SalesBillVO> salesBills=null;
		ArrayList<SalesReturnBillVO> salesReturnBills=null;
		try {
			purchaseBills=billStateBl.getPurchaseBillList(BillStateEnum.DONE);
			purchaseReturnBills=billStateBl.getPurchaseReturnBillList(BillStateEnum.DONE);
			salesBills=billStateBl.getSalesBillList(BillStateEnum.DONE);
			salesReturnBills=billStateBl.getSalesReturnBillList(BillStateEnum.DONE);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(purchaseBills!=null){
			//��ʾ������
			for(int i=0;i<purchaseBills.size();i++){
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
			
				Text billId=new Text(purchaseBills.get(i).getId());
				billId.setFont(Font.font(15));
			
				Button view=new Button("�鿴");
				view.setFont(Font.font(15));
			
				each.getChildren().addAll(billId, view);
			
				purchaseInnerBox.getChildren().add(each);
			
				view.setOnAction(oa ->{
				
				});
			}
		}
		
		
		if(purchaseReturnBills!=null){
			//��ʾ�����˻���
			for(int i=0;i<purchaseReturnBills.size();i++){
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
			
				Text billId=new Text(purchaseReturnBills.get(i).getId());
				billId.setFont(Font.font(15));
			
				Button view=new Button("�鿴");
				view.setFont(Font.font(15));
			
				each.getChildren().addAll(billId, view);
			
				purchaseReInnerBox.getChildren().add(each);
			
				view.setOnAction(oa ->{
				
				});
			}
		}
		
		if(salesBills!=null){
			//��ʾ���۵�
			for(int i=0;i<salesBills.size();i++){
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
				
				Text billId=new Text(salesBills.get(i).getId());
				billId.setFont(Font.font(15));
			
				Button view=new Button("�鿴");
				view.setFont(Font.font(15));
			
				each.getChildren().addAll(billId, view);
			
				salesInnerBox.getChildren().add(each);
			
				view.setOnAction(oa ->{
				
				});
			}
		}
		
		if(salesReturnBills!=null){
			//��ʾ�����˻���
			for(int i=0;i<salesReturnBills.size();i++){
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
			
				Text billId=new Text(salesReturnBills.get(i).getId());
				billId.setFont(Font.font(15));
			
				Button view=new Button("�鿴");
				view.setFont(Font.font(15));
			
				each.getChildren().addAll(billId, view);
			
				salesReInnerBox.getChildren().add(each);
			
				view.setOnAction(oa ->{
				
				});
			}
		}
	}
	
	@FXML
	protected void unpassButtonListener() throws Exception{
		billsHBox.getChildren().clear();
		threeBox(BillStateEnum.DENIED);
	}
	
	@FXML
	protected void passButtonListener() throws Exception{
		billsHBox.getChildren().clear();
		threeBox(BillStateEnum.TODO);
	}
	
	@FXML
	protected void doneButtonListener() throws Exception{
		billsHBox.getChildren().clear();
		threeBox(BillStateEnum.DONE);
	}
	
	@FXML
	protected void backButtonListener(){
		FinancialStaffMainUiStarter starter=new FinancialStaffMainUiStarter();
		starter.mainUi();
	}
}
