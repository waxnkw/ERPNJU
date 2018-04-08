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
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.SalesGoodsVO;
import vo.SalesReturnBillVO;

/**
 * @author 王宁一
 *
 */
public class ViewSalesmanPurchaseBillUiController {

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
	private Label moneyCategoryLabel;
	
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
	
	public void viewPurchaseBill(String category, String idString) {
		//state待用
		categoryLabel.setText(category);
		billIdLabel.setText(idString);
		switch (category) {
		case "供应商进货单":
			PurchaseBillVO purchaseBill=new PurchaseBillVO();
			try {
				purchaseBill=service.getPurchaseBill(idString);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			creatDateLabel.setText(purchaseBill.getCreateDate().getDate());
			creatorLabel.setText(purchaseBill.getCreater().getName());
			customerLabel.setText(purchaseBill.getSupplier().getName());
			wareLabel.setText(purchaseBill.getWare()+"");
			moneyLabel.setText(purchaseBill.getMoney()+"");
			
			goodsInfoTable.setItems(goods);
			ArrayList<SalesGoodsVO> purchaseGoodsInfo=purchaseBill.getGoodsList();
			goods.addAll(purchaseGoodsInfo);
			
			goodsIdColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsId"));
			
			goodsNameColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsName"));
			
			goodsTypeColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsType"));
			
			goodsNumColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Integer>("number"));
			
			goodsUnitPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Double>("unitPrice"));
			
			goodsSumPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Double>("sum"));
			
			goodsCommentColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("comment"));
			
			creatorCommentTextArea.setText(purchaseBill.getCreaterComment());
			approverLabel.setText(purchaseBill.getApprover().getName());
			approveDateLabel.setText(purchaseBill.getApproveDate().getDate());
			approverCommentText.setText(purchaseBill.getApproverComment());
			executorLabel.setText(purchaseBill.getExecutor().getName());
			finishDateLabel.setText(purchaseBill.getFinishDate().getDate());
			break;

		case "供应商进货退货单":
			PurchaseReturnBillVO purchaseReturnBill=new PurchaseReturnBillVO();
			try {
				purchaseReturnBill=service.getPurchaseReturnBill(idString);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			creatDateLabel.setText(purchaseReturnBill.getCreateDate().getDate());
			creatorLabel.setText(purchaseReturnBill.getCreater().getName());
			customerLabel.setText(purchaseReturnBill.getSupplier().getName());
			wareLabel.setText(purchaseReturnBill.getWare()+"");
			moneyLabel.setText(purchaseReturnBill.getMoney()+"");
			
			goodsInfoTable.setItems(goods);
			ArrayList<SalesGoodsVO> purchaseReturnGoodsInfo=purchaseReturnBill.getGoodsList();
			goods.addAll(purchaseReturnGoodsInfo);
			
			goodsIdColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsId"));
			
			goodsNameColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsName"));
			
			goodsTypeColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsType"));
			
			goodsNumColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Integer>("number"));
			
			goodsUnitPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Double>("unitPrice"));
			
			goodsSumPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Double>("sum"));
			
			goodsCommentColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("comment"));
			
			creatorCommentTextArea.setText(purchaseReturnBill.getCreaterComment());
			approverLabel.setText(purchaseReturnBill.getApprover().getName());
			approveDateLabel.setText(purchaseReturnBill.getApproveDate().getDate());
			approverCommentText.setText(purchaseReturnBill.getApproverComment());
			executorLabel.setText(purchaseReturnBill.getExecutor().getName());
			finishDateLabel.setText(purchaseReturnBill.getFinishDate().getDate());
			
			break;
		case "销售商出货退货单":
			SalesReturnBillVO salesReturnBill=new SalesReturnBillVO();
			try {
				salesReturnBill=service.getSalesReturnBill(idString);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			creatDateLabel.setText(salesReturnBill.getCreateDate().getDate());
			creatorLabel.setText(salesReturnBill.getCreater().getName());
			customerLabel.setText(salesReturnBill.getCustomer().getName());
			wareLabel.setText(salesReturnBill.getWare()+"");
			moneyCategoryLabel.setText("折让后总额：");
			moneyLabel.setText(salesReturnBill.getMoney()+"");
			
			goodsInfoTable.setItems(goods);
			ArrayList<SalesGoodsVO> salesReturnGoodsInfo=salesReturnBill.getGoodsList();
			goods.addAll(salesReturnGoodsInfo);
			
			goodsIdColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsId"));
			
			goodsNameColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsName"));
			
			goodsTypeColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsType"));
			
			goodsNumColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Integer>("number"));
			
			goodsUnitPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Double>("unitPrice"));
			
			goodsSumPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Double>("sum"));
			
			goodsCommentColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("comment"));
			
			creatorCommentTextArea.setText(salesReturnBill.getCreaterComment());
			approverLabel.setText(salesReturnBill.getApprover().getName());
			approveDateLabel.setText(salesReturnBill.getApproveDate().getDate());
			approverCommentText.setText(salesReturnBill.getApproverComment());
			executorLabel.setText(salesReturnBill.getExecutor().getName());
			finishDateLabel.setText(salesReturnBill.getFinishDate().getDate());
			
			break;
		}
	}
}































