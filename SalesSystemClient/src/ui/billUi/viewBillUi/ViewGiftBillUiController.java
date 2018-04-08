package ui.billUi.viewBillUi;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.exception.Myexception;
import assistant.utility.Date;
import blService.billService.viewBillBlService.ViewGiftBillBlService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import vo.GiftBillVO;
import vo.GiftVO;
import vo.UserInfoVO;

public class ViewGiftBillUiController {
	private GiftBillVO giftBill;//��ʾ��giftBill
	private ObservableList<GiftVO> giftsList = FXCollections.observableArrayList();//��Ʒ�嵥
	private  ViewGiftBillBlService service;//TODO
	
	/**
	 * ��Ʒ��Ϣ
	 * */
	@FXML
	Text nameText;
	@FXML
	Text idText;
	@FXML
	Text amountText;
	@FXML
	Text singlePriceText;
	@FXML 
	Text giftTotalCostText;
	
	private void showGiftInfo(GiftVO gift){
		nameText.setText(gift.getName());
		idText.setText(gift.getId());
		amountText.setText(gift.getGiftAmount()+"");
		singlePriceText.setText(gift.getPrice()+"");
		giftTotalCostText.setText(gift.getTotalPrice()+"");
	}
	
	
	/**
	 * ������Ϣ
	 * */
	@FXML
	Text billIdText;
	@FXML 
	Text createrText;
	@FXML
	Text createDateText;
	@FXML 
	Text approverText;
	@FXML
	Text approveDateText;
	@FXML
	Text executorText;
	@FXML
	Text totalPriceText;
	@FXML
	TextArea approverCommentTextArea;
	private void  initText(){
		billIdText.setText(giftBill.getId());
		
		UserInfoVO creater = giftBill.getCreater();
		createrText.setText(creater.getName()+" "+creater.getId());
		
		Date createDate = giftBill.getCreateDate();
		createDateText.setText(createDate.getYMDDate());
		
		UserInfoVO approver = giftBill.getApprover();
		approverText.setText(approver.getName()+" "+approver.getId());
		
		Date approveDate = giftBill.getApproveDate();
		approveDateText.setText(approveDate.getYMDDate());
		
		UserInfoVO executor = giftBill.getExecutor();
		executorText.setText(executor.getName()+" "+executor.getId());
		
		totalPriceText.setText(giftBill.getTotalPrice()+"");
		
		approverCommentTextArea.setText(giftBill.getApproverComment());
		approverCommentTextArea.setEditable(false);
	}
	
	/**
	 * ��Ʒ�嵥
	 * */
	@FXML 
	TableView<GiftVO> giftTableView;
	@FXML
	TableColumn<GiftVO, String> giftTableColumn;
	
	private void initGiftTableView(){
		giftTableColumn.setCellFactory(col->{
			//TableCell<GiftVO, String> tableCell = new TableCell<>();
			TextFieldTableCell<GiftVO, String> tableCell =new TextFieldTableCell<>();
			tableCell.setOnMouseClicked(e->{
				int i=0;
				if(e.getButton().equals(MouseButton.PRIMARY)
						&&e.getClickCount()==2
						&&(i=tableCell.getIndex())<giftsList.size()){
					GiftVO gift = giftsList.get(i);
					showGiftInfo(gift);
				}
			});
			return tableCell;
		});
		giftTableColumn.setCellValueFactory(cellDataFeatures->{
			GiftVO gift = cellDataFeatures.getValue();
			ObservableValue<String> name = new SimpleStringProperty(gift.getName());
			return name;
		});
		giftTableView.setItems(giftsList);
		giftTableView.refresh();
	}
	
	/**
	 * ҳ��رհ�ť
	 * */
	@FXML
	protected void quitButtonListener(Event e){
		((Node)e.getSource()).getScene().getWindow().hide();
	}
	
	/**
	 * ҳ���ʼ��
	 * */
	protected void init(String  billId){
		initGiftBill(billId);
		initGiftsList();
		initGiftTableView();
		initText();
	}
	
	private void initGiftBill(String billId){
		try {
			this.giftBill = service.getGiftBill(billId);
		} catch (Myexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (RemoteException e){
			
		}
	}
	
	private void initGiftsList(){
		ArrayList<GiftVO> gifts = giftBill.getGifts();
		if(gifts!=null){
			giftsList.addAll(gifts);
		}
	}
}