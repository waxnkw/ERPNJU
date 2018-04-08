package ui.listUi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import assistant.utility.Date;
import blService.salesBlService.SalesBlService;
import blStubs.salesBlStubs.SalesBlService_Stub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import vo.SalesBillVO;
import vo.SalesGoodsVO;

public class EditSalesBillUiController {
	@FXML
	private Text createTimeText;
	
	@FXML
	private Text customerText;
	
	@FXML
	private Text businessmanText;
	
	@FXML
	private Text wareText;
	
	@FXML
	private TextField beforeDiscountSumText;
	
	@FXML
	private TextField discountText;
	
	@FXML
	private TextField couponText;
	
	@FXML
	private TextField afterDiscountText;
	
	@FXML
	private TextField actualMoneyText;
	
	@FXML
	private TextArea commentArea;
	
	@FXML
	private TableView<SalesGoodsVO> entryTable;
	
	@FXML
	private TableColumn<SalesGoodsVO, String> commodityIdColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, String> commodityNameColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, String> commodityTypeColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, Integer> numColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, Double> unitPriceColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, Double> sumColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, String> commentColumn;
	
	//�Ҳ�
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
	
	private ObservableList<SalesGoodsVO> items=FXCollections.observableArrayList();
	 
	private SalesBillVO currentBill=null;
	
	public void init(SalesBillVO bill, String operation){
		currentBill=bill;
		
		//��ʼ��Text
		Date date=new Date();
		createTimeText.getText();
		createTimeText.setText(date.getDate());
		businessmanText.setText(bill.getBusinessman().getName()+" "+bill.getBusinessman().getId());
		customerText.setText(bill.getCustomer().getName()+" "+bill.getCustomer().getId());
		wareText.setText(String.valueOf(bill.getWare()));
		commentArea.setText(bill.getCreaterComment());
		
		approverText.setText(bill.getApprover().getName()+" "+bill.getApprover().getId());
		executorText.setText(bill.getExecutor().getName()+" "+bill.getExecutor().getId());
		approveDateText.setText(bill.getApproveDate().getDate());
		finishDateText.setText(bill.getFinishDate().getDate());
		approverCommentArea.setText(bill.getApproverComment());
		
		//��ʼ��TextField
		if(operation.equals("��岢����")){
			beforeDiscountSumText.setText(String.valueOf(bill.getOriMoney()));
			discountText.setText(String.valueOf(bill.getDiscount()));
			couponText.setText(String.valueOf(bill.getCoupon()));
			afterDiscountText.setText(String.valueOf(bill.getMoney()));
			actualMoneyText.setText(String.valueOf(bill.getActualMoney()));
		}else if(operation.equals("���")){
			beforeDiscountSumText.setText("-"+String.valueOf(bill.getOriMoney()));
			discountText.setText("-"+String.valueOf(bill.getDiscount()));
			couponText.setText("-"+String.valueOf(bill.getCoupon()));
			afterDiscountText.setText("-"+String.valueOf(bill.getMoney()));
			actualMoneyText.setText("-"+String.valueOf(bill.getActualMoney()));
		}
		
		//��ʼ��Table
		ArrayList<SalesGoodsVO> goodsList=bill.getGoodsList();
		
		commodityIdColumn.setCellValueFactory(
				new PropertyValueFactory<SalesGoodsVO, String>("goodsId"));
		commodityNameColumn.setCellValueFactory(
				new PropertyValueFactory<SalesGoodsVO, String>("goodsName"));
		commodityTypeColumn.setCellValueFactory(
				new PropertyValueFactory<SalesGoodsVO, String>("goodsType"));
		numColumn.setCellValueFactory(
				new PropertyValueFactory<SalesGoodsVO, Integer>("number"));
		unitPriceColumn.setCellValueFactory(
				new PropertyValueFactory<SalesGoodsVO, Double>("unitPrice"));
		sumColumn.setCellValueFactory(
				new PropertyValueFactory<SalesGoodsVO, Double>("sum"));
		commentColumn.setCellValueFactory(
				new PropertyValueFactory<SalesGoodsVO, String>("comment"));
		
		if(operation.equals("���")){
			for(int i=0;i<goodsList.size();i++){
				SalesGoodsVO goods=goodsList.get(i);
				goods.setNumber(-goods.getNumber());
				goods.setUnitPrice(-goods.getUnitPrice());
				goods.setSum(goods.getSum());
			}
		}
		
		numColumn.setCellFactory(col->{
			TextFieldTableCell<SalesGoodsVO, Integer> tableCell = new TextFieldTableCell<SalesGoodsVO, Integer>(new IntegerStringConverter());
			tableCell.setEditable(true);
			return tableCell;
		});
		
		unitPriceColumn.setCellFactory(col->{
			TextFieldTableCell<SalesGoodsVO, Double> tableCell = new TextFieldTableCell<SalesGoodsVO, Double>(new DoubleStringConverter());
			tableCell.setEditable(true);
			return tableCell;
		});
		
		sumColumn.setCellFactory(col->{
			TextFieldTableCell<SalesGoodsVO, Double> tableCell = new TextFieldTableCell<SalesGoodsVO, Double>(new DoubleStringConverter());
			tableCell.setEditable(true);
			return tableCell;
		});
		
		items.addAll(goodsList);
		entryTable.setItems(items);
	}
	
	@FXML
	protected void numColumnOnEditCommit(CellEditEvent<TextFieldTableCell<Integer, Integer>, Integer> event) throws Exception{
		int oldValue=event.getOldValue();
		int newValue=event.getNewValue();
		
		if(oldValue!=newValue){
			int rowIndex=event.getTablePosition().getRow();
			SalesGoodsVO entry=items.get(rowIndex);
			entry.setNumber(newValue);
		}
	}
	
	@FXML
	protected void unitPriceColumnOnEditCommit(CellEditEvent<TextFieldTableCell<Double, Double>, Double> event) throws Exception{
		double oldValue=event.getOldValue();
		double newValue=event.getNewValue();
		
		if(oldValue!=newValue){
			int rowIndex=event.getTablePosition().getRow();
			SalesGoodsVO entry=items.get(rowIndex);
			entry.setUnitPrice(newValue);
		}
	}
	
	@FXML
	protected void sumColumnOnEditCommit(CellEditEvent<TextFieldTableCell<Double, Double>, Double> event){
		double oldValue=event.getOldValue();
		double newValue=event.getNewValue();
		
		if(oldValue!=newValue){
			int rowIndex=event.getTablePosition().getRow();
			SalesGoodsVO entry=items.get(rowIndex);
			entry.setSum(newValue);
		}
	}
	
	@FXML
	protected void submitButtonListener(){
		ArrayList<SalesGoodsVO> newGoodsList=new ArrayList<SalesGoodsVO>();
		newGoodsList.addAll(items);
		
		currentBill.setCreateDate(new Date());
		currentBill.setOriMoney(Double.parseDouble(beforeDiscountSumText.getText()));
		currentBill.setDiscount(Double.parseDouble(discountText.getText()));
		currentBill.setCoupon(Double.parseDouble(couponText.getText()));
		currentBill.setMoney(Double.parseDouble(afterDiscountText.getText()));
		currentBill.setActualMoney(Double.parseDouble(actualMoneyText.getText()));
		
		currentBill.setGoodsList(newGoodsList);
		
		SalesBlService service=new SalesBlService_Stub();
		
		try {
			service.NewSales(currentBill);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
 