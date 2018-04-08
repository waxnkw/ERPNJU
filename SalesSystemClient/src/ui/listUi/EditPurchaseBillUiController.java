package ui.listUi;

import java.util.ArrayList;

import assistant.utility.Date;
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
import vo.PurchaseBillVO;
import vo.SalesGoodsVO;

public class EditPurchaseBillUiController {
	@FXML
	private Text createTimeText;
	
	@FXML
	private Text customerText;

	@FXML
	private Text wareText;
	
	@FXML
	private TextField sumText;
	
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
	
	//右侧
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
	 
	private PurchaseBillVO currentBill=null;
	
	public void init(PurchaseBillVO bill, String operation){
		currentBill=bill;
		
		//初始化Text
		Date date=new Date();
		createTimeText.setText(date.getDate());
		customerText.setText(bill.getSupplier().getName()+" "+bill.getSupplier().getId());
		wareText.setText(String.valueOf(bill.getWare()));
		commentArea.setText(bill.getCreaterComment());
		
		approverText.setText(bill.getApprover().getName()+" "+bill.getApprover().getId());
		executorText.setText(bill.getExecutor().getName()+" "+bill.getExecutor().getId());
		approveDateText.setText(bill.getApproveDate().getDate());
		finishDateText.setText(bill.getFinishDate().getDate());
		approverCommentArea.setText(bill.getApproverComment());
		
		//初始化TextField
		if(operation.equals("红冲并复制")){
			sumText.setText(String.valueOf(bill.getMoney()));
		}else if(operation.equals("红冲")){
			sumText.setText("-"+String.valueOf(bill.getMoney()));
		}
		
		//初始化Table
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
		
		if(operation.equals("红冲")){
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
		Integer oldValue=event.getOldValue();
		Integer newValue=event.getNewValue();
		
		if(oldValue!=newValue){
			int rowIndex=event.getTablePosition().getRow();
			SalesGoodsVO entry=items.get(rowIndex);
			entry.setNumber(newValue);
		}
	}
	
	@FXML
	protected void unitPriceColumnOnEditCommit(CellEditEvent<TextFieldTableCell<Double, Double>, Double> event) throws Exception{
		Double oldValue=event.getOldValue();
		Double newValue=event.getNewValue();
		
		if(oldValue!=newValue){
			int rowIndex=event.getTablePosition().getRow();
			SalesGoodsVO entry=items.get(rowIndex);
			entry.setUnitPrice(newValue);
		}
	}
	
	@FXML
	protected void sumColumnOnEditCommit(CellEditEvent<TextFieldTableCell<Double, Double>, Double> event){
		Double oldValue=event.getOldValue();
		Double newValue=event.getNewValue();
		
		if(oldValue!=newValue){
			int rowIndex=event.getTablePosition().getRow();
			SalesGoodsVO entry=items.get(rowIndex);
			entry.setSum(newValue);
		}
	}
	
	@FXML
	protected void submitButtonListener(){
		
		currentBill.setCreateDate(new Date());
		ArrayList<SalesGoodsVO> newGoodsList=new ArrayList<SalesGoodsVO>();
		newGoodsList.addAll(items);
		
		currentBill.setMoney(Double.parseDouble(sumText.getText()));
		currentBill.setGoodsList(newGoodsList);
		
		/**
		 * 保存单据
		 */
	}
}
