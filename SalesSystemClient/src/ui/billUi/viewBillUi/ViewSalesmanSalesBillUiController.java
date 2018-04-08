/**
 * 
 */
package ui.billUi.viewBillUi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import blService.billService.viewBillBlService.ViewSalsemanBillBlService;
import blStubs.billStubs.viewBillBlStubs.ViewSalsemanBillBlService_Stub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.SalesBillVO;
import vo.SalesGoodsVO;

/**
 * @author ÍõÄþÒ»
 *
 */
public class ViewSalesmanSalesBillUiController {

	@FXML
	private Label categoryLabel;
	
	@FXML
	private Label billIdLabel;
	
	@FXML
	private Label creatDateLabel;
	
	@FXML
	private Label creatorLabel;
	
	@FXML
	private Label customerLabel;
	
	@FXML
	private Label wareLabel;
	
	@FXML
	private Label oriMoneyLabel;
	
	@FXML
	private Label discountLabel;
	
	@FXML
	private Label couponLabel;
	
	@FXML
	private Label moneyLabel;
	
	@FXML
	private TableView<SalesGoodsVO> goodsInfoTable;
	
	@FXML
	private TableColumn<SalesGoodsVO, String> goodsIdColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, String> goodsNameColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, String> goodsTypeColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, Integer> goodsNumColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, Double> goodsUnitPriceColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, Double> goodsSumPriceColumn;
	
	@FXML
	private TableColumn<SalesGoodsVO, String> goodsCommentColumn;
	
	@FXML
	private TextArea creatorCommentTextArea;
	
	@FXML
	private Label approverLabel;
	
	@FXML
	private Label executorLabel;
	
	@FXML
	private Label approveDateLabel;
	
	@FXML
	private Label finishDateLabel;
	
	@FXML
	private TextArea approverCommentText;
	
	private ViewSalsemanBillBlService service=new ViewSalsemanBillBlService_Stub(); 
	
	private ObservableList<SalesGoodsVO> goods=FXCollections.observableArrayList();
	
	public void viewSalesBill(String category, String idString) {
		//state´ýÓÃ
		categoryLabel.setText(category);
		billIdLabel.setText(idString);
		SalesBillVO salesBill=new SalesBillVO();
		try {
			salesBill=service.getSalesBill(idString);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		creatDateLabel.setText(salesBill.getCreateDate().getDate());
		creatorLabel.setText(salesBill.getCreater().getName());
		customerLabel.setText(salesBill.getCustomer().getName());
		wareLabel.setText(salesBill.getWare()+"");
		oriMoneyLabel.setText(salesBill.getOriMoney()+"");
		discountLabel.setText(salesBill.getDiscount()+"");
		couponLabel.setText(salesBill.getCoupon()+"");
		moneyLabel.setText(salesBill.getMoney()+"");
		
		goodsInfoTable.setItems(goods);
		ArrayList<SalesGoodsVO> salesGoodsInfo=salesBill.getGoodsList();
		goods.addAll(salesGoodsInfo);
		
		goodsIdColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsId"));
		
		goodsNameColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsName"));
		
		goodsTypeColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsType"));
		
		goodsNumColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Integer>("number"));
		
		goodsUnitPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Double>("unitPrice"));
		
		goodsSumPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Double>("sum"));
		
		goodsCommentColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("comment"));
		
		creatorCommentTextArea.setText(salesBill.getCreaterComment());
		approverLabel.setText(salesBill.getApprover().getName());
		approveDateLabel.setText(salesBill.getApproveDate().getDate());
		approverCommentText.setText(salesBill.getApproverComment());
		executorLabel.setText(salesBill.getExecutor().getName());
		finishDateLabel.setText(salesBill.getFinishDate().getDate());
		
	}
	
	
	
}


































