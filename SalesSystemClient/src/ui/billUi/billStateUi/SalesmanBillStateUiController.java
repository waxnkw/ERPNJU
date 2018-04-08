package ui.billUi.billStateUi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import assistant.type.BillStateEnum;
import blService.billService.billStateBlService.SalesmanBillStateBlService;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import rmi.remoteHelper.BillStateRemoteHelper;
import rmi.remoteHelper.RemoteHelperFactory;
import ui.billUi.viewBillUi.ViewSalesmanBillsUiStarter;
import ui.salesUi.NewSalesmanBillsUiStarter;
import ui.uiAssistants.StageSize;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;
import vo.UserInfoVO;

/**
 * ���۽���Ա����״̬����controller
 * @author guxinyu
 * @version 2017.12.19
 *
 */
public class SalesmanBillStateUiController {
	private UserInfoVO user;
	
	@FXML
	private HBox billHBox;
	
	private BillStateRemoteHelper remoteHelper=RemoteHelperFactory.getBillStateRemoteHelper();
	
//	private SalesmanBillStateBlService billStateBl=new SalesmanBillStateBlService_Stub();

	private SalesmanBillStateBlService billStateBl=remoteHelper.getSalesmanBillStateBlService();
	
	public void init(UserInfoVO u){
		user=u;
	}
	
	private void fourBox(BillStateEnum state){
		billHBox.getChildren().clear();
		
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
		
		billHBox.getChildren().addAll(
				sep1, purchaseOuterBox, sep2, purchaseReOuterBox, sep3, salesOuterBox, sep4, salesReOuterBox);
		
		ArrayList<PurchaseBillVO> purchaseBills=null;
		ArrayList<PurchaseReturnBillVO> purchaseReturnBills=null;
		ArrayList<SalesBillVO> salesBills=null;
		ArrayList<SalesReturnBillVO> salesReturnBills=null;
		try {
			purchaseBills=billStateBl.getPurchaseBillList(state);
			purchaseReturnBills=billStateBl.getPurchaseReturnBillList(state);
			salesBills=billStateBl.getSalesBillList(state);
			salesReturnBills=billStateBl.getSalesReturnBillList(state);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		if(purchaseBills!=null){
			//��ʾ������
			for(int i=0;i<purchaseBills.size();i++){
				PurchaseBillVO bill=purchaseBills.get(i);
			
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
			
				Text billId=new Text(bill.getId());
				billId.setFont(Font.font(15));
			
				if(state==BillStateEnum.DENIED){
					Button edit=new Button("�޸�");
					edit.setFont(Font.font(15));
					Button delete=new Button("ɾ��");
					delete.setFont(Font.font(15));
				
					each.getChildren().addAll(billId, edit, delete);
			
					purchaseInnerBox.getChildren().add(each);
			
					edit.setOnAction(oa ->{
						NewSalesmanBillsUiStarter starter=new NewSalesmanBillsUiStarter(user);
						starter.editPurchaseBill(bill);
					});
				
					delete.setOnAction(oa ->{
						try {
							if(billStateBl.deletePurchaseBill(bill)){
								billHBox.getChildren().remove(each);
							}else{
								/**
								 * ����
								 */
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					});	
				
				}else if(state==BillStateEnum.DONE){
					Button view=new Button("�鿴");
					view.setFont(Font.font(15));
			
					each.getChildren().addAll(billId, view);
			
					purchaseInnerBox.getChildren().add(each);
			
					view.setOnAction(oa ->{
						ViewSalesmanBillsUiStarter starter=new ViewSalesmanBillsUiStarter();
						starter.viewPurchaseBill(bill.getId());
					});	
				}
			}
		}
		
		if(purchaseReturnBills!=null){
			//��ʾ�����˻���
			for(int i=0;i<purchaseReturnBills.size();i++){
				PurchaseReturnBillVO bill=purchaseReturnBills.get(i);
			
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
			
				Text billId=new Text(bill.getId());
				billId.setFont(Font.font(15));
			
				if(state==BillStateEnum.TODO){
					Button edit=new Button("�޸�");
					edit.setFont(Font.font(15));
					Button delete=new Button("ɾ��");
					delete.setFont(Font.font(15));
				
					each.getChildren().addAll(billId, edit, delete);
			
					purchaseInnerBox.getChildren().add(each);
			
					edit.setOnAction(oa ->{
						NewSalesmanBillsUiStarter starter=new NewSalesmanBillsUiStarter(user);
						starter.editPurchaseReturnBill(bill);
					});
				
					delete.setOnAction(oa ->{
						try {
							if(billStateBl.deletePurchaseReturnBill(bill)){
								billHBox.getChildren().remove(each);
							}else{
								/**
								 * ����
								 */
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					});	
				}else if(state==BillStateEnum.DONE){
					Button view=new Button("�鿴");
					view.setFont(Font.font(15));
			
					each.getChildren().addAll(billId, view);
			
					purchaseInnerBox.getChildren().add(each);
			
					view.setOnAction(oa ->{
						ViewSalesmanBillsUiStarter starter=new ViewSalesmanBillsUiStarter();
						starter.viewPurchaseReturnBill(bill.getId());
					});	
				}
			}
		}
		
		if(salesBills!=null){
			//��ʾ���۵�
			for(int i=0;i<salesBills.size();i++){
				SalesBillVO bill=salesBills.get(i);
			
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
			
				Text billId=new Text(bill.getId());
				billId.setFont(Font.font(15));
			
				if(state==BillStateEnum.TODO){
					Button edit=new Button("�޸�");
					edit.setFont(Font.font(15));
					Button delete=new Button("ɾ��");
					delete.setFont(Font.font(15));
				
					each.getChildren().addAll(billId, edit, delete);
			
					purchaseInnerBox.getChildren().add(each);
			
					edit.setOnAction(oa ->{
						NewSalesmanBillsUiStarter starter=new NewSalesmanBillsUiStarter(user);
						starter.editSalesBill(bill);
					});
				
					delete.setOnAction(oa ->{
						try {
							if(billStateBl.deleteSalesBill(bill)){
								billHBox.getChildren().remove(each);
							}else{
								/**
								 * ����
								 */
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					});	
				}else if(state==BillStateEnum.DONE){
					Button view=new Button("�鿴");
					view.setFont(Font.font(15));
			
					each.getChildren().addAll(billId, view);
			
					purchaseInnerBox.getChildren().add(each);
			
					view.setOnAction(oa ->{
						ViewSalesmanBillsUiStarter starter=new ViewSalesmanBillsUiStarter();
						starter.viewSalesBill(bill.getId());
					});	
				}
			}
		}
		
		if(salesReturnBills!=null){
			//��ʾ�����˻���
			for(int i=0;i<salesReturnBills.size();i++){
				SalesReturnBillVO bill=salesReturnBills.get(i);
			
				HBox each=new HBox();
				each.setAlignment(Pos.CENTER);
				each.setSpacing(20);
			
				Text billId=new Text(bill.getId());
				billId.setFont(Font.font(15));
			
				if(state==BillStateEnum.TODO){
					Button edit=new Button("�޸�");
					edit.setFont(Font.font(15));
					Button delete=new Button("ɾ��");
					delete.setFont(Font.font(15));
					
					each.getChildren().addAll(billId, edit, delete);
			
					purchaseInnerBox.getChildren().add(each);
			
					edit.setOnAction(oa ->{
						NewSalesmanBillsUiStarter starter=new NewSalesmanBillsUiStarter(user);
						starter.editSalesReturnBill(bill);
					});
				
					delete.setOnAction(oa ->{
						try {
							if(billStateBl.deleteSalesReturnBill(bill)){
								billHBox.getChildren().remove(each);
							}else{
								/**
								 * ����
								 */
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					});	
				}else if(state==BillStateEnum.DONE){
					Button view=new Button("�鿴");
					view.setFont(Font.font(15));
			
					each.getChildren().addAll(billId, view);
			
					purchaseInnerBox.getChildren().add(each);
			
					view.setOnAction(oa ->{
						ViewSalesmanBillsUiStarter starter=new ViewSalesmanBillsUiStarter();
						starter.viewSalesReturnBill(bill.getId());
					});	
				}
			}
		}
		
	}
	
	@FXML
	protected void unpassButtonListener(){
		billHBox.getChildren().clear();
		fourBox(BillStateEnum.DENIED);
	}
	
	@FXML
	protected void passButtonListener(){
		billHBox.getChildren().clear();
		fourBox(BillStateEnum.TODO);
	}
}
