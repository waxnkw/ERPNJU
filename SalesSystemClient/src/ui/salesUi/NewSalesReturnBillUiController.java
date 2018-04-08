/**
 * 
 */
package ui.salesUi;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blService.customerBlService.CustomerBlService;
import blService.salesBlService.SalesBlService;
import blStubs.customerBlStubs.CustomerBlService_Stub;
import blStubs.salesBlStubs.SalesBlService_Stub;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import rmi.remoteHelper.CustomerRemoteHelper;
import rmi.remoteHelper.RemoteHelperFactory;
import rmi.remoteHelper.SalesRemoteHelper;
import vo.BillVO;
import vo.CustomerVO;
import vo.GoodsVO;
import vo.SalesGoodsVO;
import vo.SalesReturnBillVO;
import vo.UserInfoVO;

/**
 * @author 王宁一
 * @version 2012.12.27
 *
 */
public class NewSalesReturnBillUiController {

	@FXML
	private TextField billIdText; 
	
	@FXML
	private Label userIdText;
	
	@FXML
	private TableView<BillVO> draftListTable;
	
	@FXML
	private TableColumn<BillVO, Button> draftDeleteColumn;
	
	@FXML
	private TableColumn<BillVO, Button> draftViewColumn;
	
	@FXML
	private TableColumn<BillVO, String> draftColumn;
	
	@FXML
	private TableView<SalesGoodsVO> goodsInfoTable;
	
	@FXML
	private TableColumn<SalesGoodsVO, Button> chooseButtonColumn;
	
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
	private TextField sellerText;
	
	@FXML
	private TextField businessManText;//默认业务员
	
	@FXML
	private TextField wareText;

	@FXML
	private TextField commentText;
	
	@FXML
	private TextField moneyText;//折让后总额
	
	@FXML 
	private Button submitButton;
	
	@FXML
	private Button saveAsDraftButton;
	
	@FXML
	private Button newGoodsListButton;
	
	private UserInfoVO userInfoVO;
	
	private ObservableList<BillVO> drafts=FXCollections.observableArrayList();
	
	private ObservableList<SalesGoodsVO> goods=FXCollections.observableArrayList();
	
	//private SalesBlService service=new SalesBlService_Stub();
	
	private SalesRemoteHelper salesRemoteHelper=RemoteHelperFactory.getSalesRemoteHelper();
		
	private SalesBlService service=salesRemoteHelper.getSalesBlService();
		
	//private CustomerBlService customerService=new CustomerBlService_Stub();
		
	private CustomerRemoteHelper customerRemoteHelper=RemoteHelperFactory.getCustomerRemoteHelper();
		
	private CustomerBlService customerService=customerRemoteHelper.getCustomerBlService();
	
	private int ware=0;
	
	private double amount=0;
	
	private CustomerVO customer;
	
	private boolean isSaved=true;
	
	Date date=new Date();
	
	public void init(UserInfoVO user) {
		userInfoVO=user;
		//初始化Text
		
		userIdText.setText(user.getId());
		billIdText.setPromptText("XSTHD-YYYYMMDD-XXXXX");
		
		ArrayList<SalesGoodsVO> goodsInfo=new ArrayList<>();
		
		goodsInfoTable.setItems(goods);
		goods.addAll(goodsInfo);
		
		//初始化SalesGoods, 商品信息列表
		
			chooseButtonColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SalesGoodsVO,Button>, ObservableValue<Button>>() {

				@Override
				public ObservableValue<Button> call(CellDataFeatures<SalesGoodsVO, Button> param) {
					SalesGoodsVO goodsVO=param.getValue();
					Button chooseButton=new Button("选择");
					
					chooseButton.setOnAction(paramx->{
						int position=goods.indexOf(goodsVO);
						
						choose(position);
					});
						
					return new SimpleObjectProperty<Button>(chooseButton);
				}
			});		
			
		goodsIdColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsId"));
			
		goodsNameColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsName"));
			
		goodsTypeColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("goodsType"));
			
		goodsNumColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Integer>("number"));
		goodsNumColumn.setCellFactory(col->{
			TextFieldTableCell<SalesGoodsVO, Integer> tableCell=new TextFieldTableCell<SalesGoodsVO, Integer>(new IntegerStringConverter());
			tableCell.setEditable(true);
			return tableCell;
			}		
		);
			
		goodsUnitPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Double>("unitPrice"));
		goodsUnitPriceColumn.setCellFactory(col->{
			TextFieldTableCell<SalesGoodsVO, Double> tableCell=new TextFieldTableCell<SalesGoodsVO, Double>(new DoubleStringConverter());
			tableCell.setEditable(true);
			return tableCell;
		});
			
		goodsSumPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,Double>("sum"));
			
		goodsCommentColumn.setCellValueFactory(new PropertyValueFactory<SalesGoodsVO,String>("comment"));
			
		goodsCommentColumn.setCellFactory(TextFieldTableCell.forTableColumn());						
		
		try {
			billIdText.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					isSaved=false;
				}
			});
			
			sellerText.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					isSaved=false;
				}
			});
			
			businessManText.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					isSaved=false;
				}
			});
			
			wareText.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					isSaved=false;
				}
			});
			
			commentText.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					isSaved=false;
				}
			});
			
			moneyText.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					isSaved=false;
				}
			});
			
			//草稿箱
			draftListTable.setItems(drafts);
			ArrayList<SalesReturnBillVO> bills=service.getSalesReturnDraftBillsList(user);
			
			drafts.addAll(bills);
			
			draftColumn.setCellValueFactory(new PropertyValueFactory<BillVO,String>("Id"));
			draftDeleteColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BillVO,Button>, ObservableValue<Button>>() {
				
				@Override
				public ObservableValue<Button> call(CellDataFeatures<BillVO, Button> param) {
					// TODO Auto-generated method stub
					BillVO bill=param.getValue();
					
					Button delete=new Button("删除");
					
					delete.setOnAction(oa ->{
						try {
							if(service.DeletePurchaseDraft(bill.getId())){
								drafts.remove(bill);
							}else{
								/**
								 * 错误提示
								 */
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					});
					return new SimpleObjectProperty<Button>(delete);
				}
			});
			
			draftViewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BillVO,Button>, ObservableValue<Button>>() {

				@Override
				public ObservableValue<Button> call(CellDataFeatures<BillVO, Button> param) {
					// TODO Auto-generated method stub
					BillVO bill=param.getValue();
					Button view=new Button("查看");
					
					view.setOnAction(paramx->{
						if(isSaved) {
							showContent((SalesReturnBillVO)bill);
						}else {
							warn();
						}
				
						isSaved=true;
					});
					
					return new SimpleObjectProperty<Button>(view);
				}
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}
	
	public void showContent(SalesReturnBillVO bill) {
		billIdText.setText(bill.getId());
		userIdText.setText(userInfoVO.getId());
		sellerText.setText(bill.getCustomer().getName());
		businessManText.setText(bill.getBusinessman().getName());
		wareText.setText(""+bill.getWare());
		commentText.setText(bill.getCreaterComment());
		moneyText.setText(""+bill.getMoney());
		ArrayList<SalesGoodsVO> goodsInfo=bill.getGoodsList();
		goods.addAll(goodsInfo);
		
		goods.clear();
		ArrayList<SalesGoodsVO> toShows=bill.getGoodsList();
		for(int i=0;i<toShows.size();i++) {
			goods.add(toShows.get(i));
		}
	}
	
	@FXML
	public void createBillId() {
		
		String idText=billIdText.getText();
		boolean isValid=true;
		if(idText.length()>5) {
			isValid=false;
		}
		for(int i=0;i<idText.length();i++) {
			if(!(idText.charAt(i)<='9'&&idText.charAt(i)>='0')) {
				isValid=false;
				break;
			}
		}
		if(isValid) {
			if(idText.length()<5) {
				for(int i=0;i<5-idText.length();i++) {
					idText="0"+idText;
				}
			}
			if(Integer.parseInt(idText)==00000) {
				isValid=false;
			}
		}		
		if(isValid) {
			String[] dateTexts=date.getYMDDate().split("\\.");
			billIdText.setText("XSTHD-"+dateTexts[0]+dateTexts[1]+dateTexts[2]+"-"+idText);
		}else {
			billIdText.setText("请重新输入！");
		}
		
	}
	
	@FXML
	public void saveAsDraft() {
		String billId=billIdText.getText();
		if(billId.equals("请重新输入！")) {
			billId="";
		}
		ArrayList<SalesGoodsVO> goodsVOs=new ArrayList<>();
		goodsVOs.addAll(goods);
		String comment=commentText.getText();
		//amount已计算好
		
		SalesReturnBillVO draft=new SalesReturnBillVO();
		draft.setCreater(userInfoVO);
		draft.setCreateDate(date);
		draft.setCategoryEnum(BillCategoryEnum.SALES_RETURN_BILL);
		draft.setBillStateEnum(BillStateEnum.DRAFT);
		draft.setId(billId);
		draft.setGoodsList(goodsVOs);
		draft.setWare(ware);
		draft.setCreaterComment(comment);
		draft.setMoney(amount);
		draft.setCustomer(customer);
		//TODO 等待张傲的类
		//draft.setBusinessman(businessman);
		
		try {
			if(service.NewSalReturnDraft(draft)) {
				isSaved=true;
				drafts.add(draft);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@FXML
	public void submit() {
		String billId=billIdText.getText();
		if(billId.equals("请重新输入！")) {
			billId="";
		}
		ArrayList<SalesGoodsVO> goodsVOs=new ArrayList<>();
		goodsVOs.addAll(goods);
		String comment=commentText.getText();
		//amount已计算好
		
		SalesReturnBillVO draft=new SalesReturnBillVO();
		draft.setCreater(userInfoVO);
		draft.setCreateDate(date);
		draft.setCategoryEnum(BillCategoryEnum.SALES_RETURN_BILL);
		draft.setBillStateEnum(BillStateEnum.TBD);
		draft.setId(billId);
		draft.setGoodsList(goodsVOs);
		draft.setWare(ware);
		draft.setCreaterComment(comment);
		draft.setMoney(amount);
		draft.setCustomer(customer);
		//TODO 等待张傲的类
		//draft.setBusinessman(businessman);
		
		try {
			if(service.NewSalReturn(draft)) {
				isSaved=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void choose(int position) {
		//Start
		ChooseUiStarter starter=new ChooseUiStarter();
		starter.salesReturnStart(this, position);				
	}
	
	public void replaceGoodsData(int position, GoodsVO goodsChoosed) {
		SalesGoodsVO toReplace=goods.get(position);
		//test
				
		toReplace.setGoodsName(goodsChoosed.getName());
		toReplace.setGoodsId(goodsChoosed.getNumber());
		toReplace.setGoodsType(goodsChoosed.getType());
		toReplace.setUnitPrice(Double.parseDouble(goodsChoosed.getSellingPrice()));
		goods.set(position, toReplace);
	}
	
	public void warn() {
		Stage warnStage=new Stage();
		
		VBox rootBox=new VBox();
		rootBox.setSpacing(30);
		rootBox.setAlignment(Pos.CENTER);
		
		Scene warnScene=new Scene(rootBox, 600,400);
		warnStage.setScene(warnScene);
		
		Text warn=new Text("是否保存当前单据至草稿箱？");
		warn.setFont(Font.font(20));
		
		HBox buttons=new HBox();
		buttons.setSpacing(50);
		buttons.setAlignment(Pos.CENTER);
		
		Button yesButton=new Button("是");
		yesButton.setFont(Font.font(20));
		yesButton.setPrefSize(80, 50);
		yesButton.setMaxSize(80, 50);
		yesButton.setMinSize(80, 50);
		Button noButton=new Button("否");
		noButton.setFont(Font.font(20));
		noButton.setPrefSize(80, 50);
		noButton.setMaxSize(80, 50);
		noButton.setMinSize(80, 50);
		Button cancelButton=new Button("取消");
		cancelButton.setFont(Font.font(20));
		cancelButton.setPrefSize(80, 50);
		cancelButton.setMaxSize(80, 50);
		cancelButton.setMinSize(80, 50);
		
		buttons.getChildren().addAll(yesButton, noButton, cancelButton);
		
		rootBox.getChildren().addAll(warn, buttons);
		
		warnStage.show();
		
		yesButton.setOnAction(oa->{
			saveAsDraft();
		}
		);
		
		warnStage.close();
		isSaved=true;
	}
	
	@FXML
	protected void getWareNum() {
		int result=0;
		try {
			result=Integer.parseInt(wareText.getText());
		} catch (Exception e) {
			// TODO: handle exception
			wareText.setText("请重新输入！");
		}
		if(!(result<=5&&result>0)) {
			wareText.setText("请重新输入！");
		}
	}
	
	@FXML
	protected void getCustomerInfo() {
		String name=sellerText.getText();
		try {
			customer=customerService.QueryCustomer(name).get(0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sellerText.setText("未找到客户!");
		}
	}
	
	@FXML
	protected void newGoodsList() {
		SalesGoodsVO vo=new SalesGoodsVO();
		goods.add(vo);
	}
	
	@FXML
	protected void numColumnEdited(CellEditEvent<TextFieldTableCell<Integer, Integer>, Integer> event)throws RemoteException {

		int oldValue=event.getOldValue();
		int newValue=event.getNewValue();
		
		if(!(oldValue==newValue)) {
			int rowIndex=event.getTablePosition().getRow();
			SalesGoodsVO good=goods.get(rowIndex);
			if(newValue<0) {
				newValue=0;
			}
			good.setNumber(newValue);
			double money=newValue*good.getUnitPrice();
			good.setSum(money);
			goods.set(rowIndex, good);
			
			amount=0;
			for(int i=0;i<goods.size();i++) {
				amount+=goods.get(i).getSum();
			}
			moneyText.setText(""+amount);
		}
	}
	
	
	@FXML
	protected void unitPriceColumnEdited(CellEditEvent<TextFieldTableCell<Double, Double>, Double> event)throws RemoteException {
		double oldValue=event.getOldValue();
		double newValue=event.getNewValue();
		
		if(!(oldValue==newValue)) {
			int rowIndex=event.getTablePosition().getRow();
			SalesGoodsVO good=goods.get(rowIndex);
			if(newValue<0) {
				newValue=0;
			}
			good.setUnitPrice(newValue);
			good.setSum(good.getNumber()*newValue);
			goods.set(rowIndex, good);
			
			amount=0;
			for(int i=0;i<goods.size();i++) {
				amount+=goods.get(i).getSum();
			}
			moneyText.setText(""+amount);
		}
	}
	
	@FXML
	protected void commentColumnEdited(CellEditEvent<TextFieldTableCell<String, String>, String> event)throws RemoteException {
		String oldValue=event.getOldValue();
		String newValue=event.getNewValue();
		
		if(!oldValue.equals(newValue)) {
			int rowIndex=event.getTablePosition().getRow();
			SalesGoodsVO good=goods.get(rowIndex);
			good.setComment(newValue);
			goods.set(rowIndex, good);
		}
	}
	
	
	
}






























