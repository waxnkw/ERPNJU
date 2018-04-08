package ui.financeUi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import assistant.type.BillCategoryEnum;
import assistant.utility.Date;
import blService.financeBlService.NewFinanceBillsBlService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import rmi.remoteHelper.FinanceRemoteHelper;
import rmi.remoteHelper.RemoteHelperFactory;
import ui.mainUi.financialStaffMainUi.FinancialStaffMainUiStarter;
import vo.BillEntryVO;
import vo.BillVO;
import vo.CashExpenseBillVO;
import vo.PaymentBillVO;
import vo.ReceiptBillVO;
import vo.UserInfoVO;

public class NewFinanceBillsUiController {
	@FXML
	private Text billTypePrompt;
	
	@FXML
	private TableView<BillEntryVO> entryTable;
	
	@FXML
	private TableColumn<BillEntryVO, String> entryNameColumn;
	
	@FXML
	private TableColumn<BillEntryVO, String> entryMoneyColumn;
	
	@FXML
	private Button submitButton;
	
	@FXML
	private Button saveDraftButton;
	
	@FXML
	private TableView<BillVO> draftListTable;
	
	@FXML
	private TableColumn<BillVO, Button> draftDeleteColumn;
	
	@FXML
	private TableColumn<BillVO, Button> draftViewColumn;
	
	@FXML
	private TableColumn<BillVO, String> draftColumn;
	
	@FXML
	private Text createTimeText;
	
	@FXML
	private TextField bankAccountTextField;
	
	@FXML
	private TextField sumTextField;
	
	@FXML
	private TextArea commentTextArea;
 	
	private String billType;
	
	private UserInfoVO creator;
	
	private ObservableList<BillEntryVO> entries=FXCollections.observableArrayList();
	
	private ObservableList<BillVO> drafts=FXCollections.observableArrayList();

	private FinanceRemoteHelper remoteHelper=RemoteHelperFactory.getFinanceRemoteHelper();
	
//	private NewFinanceBillsBlService newFinanceBillsBl=new NewFinanceBillsBlService_Stub();
	
	private NewFinanceBillsBlService newFinanceBillsBl=remoteHelper.getNewFinanceBillsBlService();
	
	private boolean isSaved=true;
	
	public void init(String type, UserInfoVO ctor){
		//��ʼ��ʱ��Text
		Date time=new Date();
		createTimeText.setText(time.getDate().toString());
		
		//����������Ϣ�仯
		bankAccountTextField.textProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				isSaved=false;
			}
			
		});
		
		sumTextField.textProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				isSaved=false;
			}
			
		});
		
		commentTextArea.textProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				isSaved=false;
			}
			
		});
		
		//��ʼ����Ŀ�嵥
		billTypePrompt.setText(type);
		billType=type;
		creator=ctor;
		
		entryNameColumn.setCellValueFactory(new PropertyValueFactory<>("entryName"));
		entryMoneyColumn.setCellValueFactory(new PropertyValueFactory<>("entryMoney"));
		
		entryNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		entryMoneyColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	
		for(int i=0;i<100;i++)
			entries.add(new BillEntryVO("",""));
		
		entryTable.setItems(entries);
		
		//��ʼ���ݸ���
		draftListTable.setItems(drafts);
		
		switch (billType){
			case "�ֽ���õ�":
				try {
					ArrayList<CashExpenseBillVO> bills=newFinanceBillsBl.getCashExpenseBillDraftList();
					
					drafts.addAll(bills);
			
					draftColumn.setCellValueFactory(
								new PropertyValueFactory<BillVO,String>("Id")
						);
						
					draftDeleteColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BillVO, Button>, ObservableValue<Button>>(){
							
						@Override
						public ObservableValue<Button> call(CellDataFeatures<BillVO, Button> param) {
							BillVO bill=param.getValue();
							
							Button delete=new Button("ɾ��");
							
							delete.setOnAction(oa ->{
								try {
									if(newFinanceBillsBl.deleteCashExpenseBillDraft((CashExpenseBillVO)bill)){
										drafts.remove(bill);
									}else{
										/**
										 * ������ʾ
										 */
									}
								} catch (RemoteException e) {
									e.printStackTrace();
								}
							});

								
							return new SimpleObjectProperty<Button>(delete);
						}
					});
						
					draftViewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BillVO, Button>, ObservableValue<Button>>(){

						@Override
						public ObservableValue<Button> call(CellDataFeatures<BillVO, Button> param) {
							BillVO bill=param.getValue();
							
							Button view=new Button("�鿴");
								
							view.setOnAction(oa ->{
								if(isSaved){
									showCashExpenseBillDraft((CashExpenseBillVO)bill);
								}else{
									savePrompt(bill);
								}
								
								isSaved=true;
							});
								
							return new SimpleObjectProperty<Button>(view);
						}
						
					});				
					
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
			case "�տ":
				try {
					ArrayList<ReceiptBillVO> bills=newFinanceBillsBl.getReceiptBillDraftList();
					
					drafts.addAll(bills);
				
					draftColumn.setCellValueFactory(
							new PropertyValueFactory<BillVO,String>("Id")
					);
						
					draftDeleteColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BillVO, Button>, ObservableValue<Button>>(){
							

						@Override
						public ObservableValue<Button> call(CellDataFeatures<BillVO, Button> param) {
							BillVO bill=param.getValue();
							
							Button delete=new Button("ɾ��");
							
							delete.setOnAction(oa ->{
								try {
									if(newFinanceBillsBl.deleteReceiptBillDraft((ReceiptBillVO)bill)){
										drafts.remove(bill);
									}else{
										
									}
								} catch (RemoteException e) {
									e.printStackTrace();
								}
							});

								
							return new SimpleObjectProperty<Button>(delete);
						}
					});
						
						draftViewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BillVO, Button>, ObservableValue<Button>>(){

							@Override
							public ObservableValue<Button> call(CellDataFeatures<BillVO, Button> param) {
								BillVO bill=param.getValue();
								
								Button view=new Button("�鿴");
								
								view.setOnAction(oa ->{
									if(isSaved){
										showReceiptBillDraft((ReceiptBillVO)bill);
									}else{
										savePrompt(bill);
									}
									
									isSaved=true;
								});
								
								return new SimpleObjectProperty<Button>(view);
							}
						
						});								
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
			case "���":
				try {
					ArrayList<PaymentBillVO> bills=newFinanceBillsBl.getPaymentBillDraftList();
					
					drafts.addAll(bills);
					
					draftColumn.setCellValueFactory(
							new PropertyValueFactory<BillVO,String>("Id")
					);
						
					draftDeleteColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BillVO, Button>, ObservableValue<Button>>(){
							
						@Override
						public ObservableValue<Button> call(CellDataFeatures<BillVO, Button> param) {
							BillVO bill=param.getValue();
							
							Button delete=new Button("ɾ��");
							
							delete.setOnAction(oa ->{
								try {
									if(newFinanceBillsBl.deletePaymentBillDraft((PaymentBillVO)bill)){
										drafts.remove(bill);
									}else{
										/**
										 * ������ʾ
										 */
									}
								} catch (RemoteException e) {
									e.printStackTrace();
								}
							});

								
								return new SimpleObjectProperty<Button>(delete);
							}
						});
						
						draftViewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BillVO, Button>, ObservableValue<Button>>(){

							@Override
							public ObservableValue<Button> call(CellDataFeatures<BillVO, Button> param) {
								BillVO bill=param.getValue();
								
								Button view=new Button("�鿴");
								
								view.setOnAction(oa ->{
									if(isSaved){
										showPaymentBillDraft((PaymentBillVO)bill);
									}else{
										savePrompt(bill);
									}
									
									isSaved=true;
								});
								
								return new SimpleObjectProperty<Button>(view);
							}
						
						});						
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
		}
	}
	
	//��ǰ�ݸ�δ���浫Ҫ�л�����ʱ������ʾ
	private void savePrompt(BillVO toShow){
		Stage promptStage=new Stage();
		
		VBox rootBox=new VBox();
		rootBox.setSpacing(30);
		rootBox.setAlignment(Pos.CENTER);
		
		Scene promptScene=new Scene(rootBox, 600,400);
		promptStage.setScene(promptScene);
		
		Text prompt=new Text("�Ƿ񱣴浱ǰ�������ݸ��䣿");
		prompt.setFont(Font.font(20));
		
		HBox buttons=new HBox();
		buttons.setSpacing(50);
		buttons.setAlignment(Pos.CENTER);
		
		Button yesButton=new Button("��");
		yesButton.setFont(Font.font(20));
		yesButton.setPrefSize(80, 50);
		yesButton.setMaxSize(80, 50);
		yesButton.setMinSize(80, 50);
		Button noButton=new Button("��");
		noButton.setFont(Font.font(20));
		noButton.setPrefSize(80, 50);
		noButton.setMaxSize(80, 50);
		noButton.setMinSize(80, 50);
		Button cancelButton=new Button("ȡ��");
		cancelButton.setFont(Font.font(20));
		cancelButton.setPrefSize(80, 50);
		cancelButton.setMaxSize(80, 50);
		cancelButton.setMinSize(80, 50);
		buttons.getChildren().addAll(yesButton, noButton, cancelButton);
		
		rootBox.getChildren().addAll(prompt, buttons);
		
		promptStage.show();
		
		yesButton.setOnAction(oa ->{
			//���浱ǰ�ݸ�
			saveDraft();
			
			switch (billType){
			case "�ֽ���õ�":
				showCashExpenseBillDraft((CashExpenseBillVO)toShow);
				break;
			case "���":
				showPaymentBillDraft((PaymentBillVO)toShow);
				break;
			case "�տ":
				showReceiptBillDraft((ReceiptBillVO)toShow);
				break;
			}
			
			promptStage.close();
			
			isSaved=true;
		});
		
		noButton.setOnAction(oa ->{
			switch (billType){
			case "�ֽ���õ�":
				showCashExpenseBillDraft((CashExpenseBillVO)toShow);
				break;
			case "���":
				showPaymentBillDraft((PaymentBillVO)toShow);
				break;
			case "�տ":
				showReceiptBillDraft((ReceiptBillVO)toShow);
				break;
			}
			
			promptStage.close();
			
			isSaved=true;
		});
		
		cancelButton.setOnAction(oa ->{
			promptStage.close();
		});
	}
	
	//�ֱ���ʾ���ŵ��ݵĲݸ�����
	public void showCashExpenseBillDraft(CashExpenseBillVO toShow){
		//��ʾ���ڡ������˻����ܶ��ע
		createTimeText.setText(toShow.getCreateDate().getDate());
		bankAccountTextField.setText(toShow.getBankAccount());
		sumTextField.setText(String.valueOf(toShow.getSum()));
		commentTextArea.setText(toShow.getCreaterComment());
			
		//����Table�������
		entries.clear();
		ArrayList<BillEntryVO> billEntries=toShow.getEntries();
		for(int j=0;j<billEntries.size();j++){
			entries.add(billEntries.get(j));
		}
	}
	
	public void showPaymentBillDraft(PaymentBillVO toShow){
		//��ʾ���ڡ������˻����ܶ��ע
		createTimeText.setText(toShow.getCreateDate().getDate());
		bankAccountTextField.setText(toShow.getBankAccount());
		sumTextField.setText(String.valueOf(toShow.getSum()));
		commentTextArea.setText(toShow.getCreaterComment());
			
		//����Table�������
		entries.clear();
		ArrayList<BillEntryVO> billEntries=toShow.getEntries();
		for(int j=0;j<billEntries.size();j++){
			entries.add(billEntries.get(j));
		}
	}
	
	public void showReceiptBillDraft(ReceiptBillVO toShow){
		//��ʾ���ڡ������˻����ܶ��ע
		createTimeText.setText(toShow.getCreateDate().getDate());
		bankAccountTextField.setText(toShow.getBankAccount());
		sumTextField.setText(String.valueOf(toShow.getSum()));
		commentTextArea.setText(toShow.getCreaterComment());
					
		//����Table�������
		entries.clear();
		ArrayList<BillEntryVO> billEntries=toShow.getEntries();
		for(int j=0;j<billEntries.size();j++){
			entries.add(billEntries.get(j));
		}
	}
	
	//���浱ǰ����Ϊ�ݸ�
	private void saveDraft(){
		String bankAccount=bankAccountTextField.getText();
		ArrayList<BillEntryVO> en=new ArrayList<BillEntryVO>();
		en.addAll(entries);
		double sum=Double.parseDouble(sumTextField.getText());
		String comment=commentTextArea.getText();
		
		switch (billType){
		case "�ֽ���õ�":
			CashExpenseBillVO ceBill=new CashExpenseBillVO();
			ceBill.setCategoryEnum(BillCategoryEnum.CASH_EXPENSE_BILL);
			ceBill.setSum(sum);
			ceBill.setBankAccount(bankAccount);
			ceBill.setEntries(en);
			ceBill.setCreaterComment(comment);
			ceBill.setCreater(creator);
			try {
				if(newFinanceBillsBl.saveCashExpenseBillDraft(ceBill))
					isSaved=true;
					ArrayList<CashExpenseBillVO> bills=newFinanceBillsBl.getCashExpenseBillDraftList();
					drafts.clear();
					drafts.addAll(bills);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case "���":
			PaymentBillVO pBill=new PaymentBillVO();
			pBill.setCategoryEnum(BillCategoryEnum.CASH_EXPENSE_BILL);
			pBill.setSum(sum);
			pBill.setBankAccount(bankAccount);
			pBill.setEntries(en);
			pBill.setCreaterComment(comment);
			try {
				if(newFinanceBillsBl.savePaymentBillDraft(pBill))
					isSaved=true;
					ArrayList<PaymentBillVO> bills=newFinanceBillsBl.getPaymentBillDraftList();
					drafts.clear();
					drafts.addAll(bills);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case "�տ":
			ReceiptBillVO rBill=new ReceiptBillVO();
			rBill.setCategoryEnum(BillCategoryEnum.CASH_EXPENSE_BILL);
			rBill.setSum(sum);
			rBill.setBankAccount(bankAccount);
			rBill.setEntries(en);
			rBill.setCreaterComment(comment);
			try {
				if(newFinanceBillsBl.saveReceiptBillDraft(rBill))
					isSaved=true;
					ArrayList<ReceiptBillVO> bills=newFinanceBillsBl.getReceiptBillDraftList();
					drafts.clear();
					drafts.addAll(bills);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	@FXML
	protected void columnOnEditCommit(CellEditEvent<TextFieldTableCell<String, String>, String> event) throws Exception{
		String oldValue=event.getOldValue();
		String newValue=event.getNewValue();
		
		if(!oldValue.equals(newValue)){
			int rowIndex=event.getTablePosition().getRow();
			int columnIndex=event.getTablePosition().getColumn();
			BillEntryVO entry=entries.get(rowIndex);
			if(columnIndex==0)
				entry.setEntryName(newValue);
			else
				entry.setEntryMoney(newValue);
		}
		
		isSaved=false;
	}
	
	@FXML
	protected void submitButtonListener(){
		String bankAccount=bankAccountTextField.getText();
		ArrayList<BillEntryVO> en=new ArrayList<BillEntryVO>();
		en.addAll(entries);
		double sum=Double.parseDouble(sumTextField.getText());
		String comment=commentTextArea.getText();
		
		switch (billType){
		case "�ֽ���õ�":
			CashExpenseBillVO ceBill=new CashExpenseBillVO();
			ceBill.setCategoryEnum(BillCategoryEnum.CASH_EXPENSE_BILL);
			ceBill.setSum(sum);
			ceBill.setBankAccount(bankAccount);
			ceBill.setEntries(en);
			ceBill.setCreaterComment(comment);
			ceBill.setCreater(creator);
			try {
				if(newFinanceBillsBl.newCashExpenseBill(ceBill)){
					isSaved=true;
					
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case "���":
			PaymentBillVO pBill=new PaymentBillVO();
			pBill.setCategoryEnum(BillCategoryEnum.CASH_EXPENSE_BILL);
			pBill.setSum(sum);
			pBill.setBankAccount(bankAccount);
			pBill.setEntries(en);
			pBill.setCreaterComment(comment);
			pBill.setCreater(creator);
			try {
				if(newFinanceBillsBl.newPaymentBill(pBill))
					isSaved=true;
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case "�տ":
			ReceiptBillVO rBill=new ReceiptBillVO();
			rBill.setCategoryEnum(BillCategoryEnum.CASH_EXPENSE_BILL);
			rBill.setSum(sum);
			rBill.setBankAccount(bankAccount);
		    rBill.setEntries(en);
			rBill.setCreaterComment(comment);
			rBill.setCreater(creator);
			try {
				if(newFinanceBillsBl.newReceiptBill(rBill))
					isSaved=true;
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	@FXML
	protected void saveDraftButtonListener(){
		saveDraft();
	}
	
	@FXML
	protected void backButtonListener(){
		if(!isSaved){
			Stage promptStage=new Stage();
			
			VBox rootBox=new VBox();
			rootBox.setSpacing(30);
			rootBox.setAlignment(Pos.CENTER);
			
			Scene promptScene=new Scene(rootBox, 600,400);
			promptStage.setScene(promptScene);
			
			Text prompt=new Text("�Ƿ񱣴浱ǰ�������ݸ��䣿");
			prompt.setFont(Font.font(20));
			
			HBox buttons=new HBox();
			buttons.setSpacing(50);
			buttons.setAlignment(Pos.CENTER);
			
			Button yesButton=new Button("��");
			yesButton.setFont(Font.font(20));
			yesButton.setPrefSize(80, 50);
			yesButton.setMaxSize(80, 50);
			yesButton.setMinSize(80, 50);
			Button noButton=new Button("��");
			noButton.setFont(Font.font(20));
			noButton.setPrefSize(80, 50);
			noButton.setMaxSize(80, 50);
			noButton.setMinSize(80, 50);
			Button cancelButton=new Button("ȡ��");
			cancelButton.setFont(Font.font(20));
			cancelButton.setPrefSize(80, 50);
			cancelButton.setMaxSize(80, 50);
			cancelButton.setMinSize(80, 50);
			buttons.getChildren().addAll(yesButton, noButton, cancelButton);
			
			rootBox.getChildren().addAll(prompt, buttons);
			
			promptStage.show();
			
			yesButton.setOnAction(oa ->{
				//���浱ǰ�ݸ�
				saveDraft();
				isSaved=true;
				
				FinancialStaffMainUiStarter starter=new FinancialStaffMainUiStarter();
				starter.mainUi();
			});
			
			noButton.setOnAction(oa ->{
				FinancialStaffMainUiStarter starter=new FinancialStaffMainUiStarter();
				starter.mainUi();
			});
			
			cancelButton.setOnAction(oa ->{
				promptStage.close();
			});
		}else{
			FinancialStaffMainUiStarter starter=new FinancialStaffMainUiStarter();
			starter.mainUi();
		}	
	}
}
