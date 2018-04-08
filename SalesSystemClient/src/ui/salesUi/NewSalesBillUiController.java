/**
 * 
 */
package ui.salesUi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;

import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blService.customerBlService.CustomerBlService;
import blService.salesBlService.SalesBlService;
import blStubs.customerBlStubs.CustomerBlService_Stub;
import blStubs.salesBlStubs.SalesBlService_Stub;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import rmi.remoteHelper.CustomerRemoteHelper;
import rmi.remoteHelper.RemoteHelperFactory;
import rmi.remoteHelper.SalesRemoteHelper;
import vo.BillVO;
import vo.CustomerVO;
import vo.GoodsVO;
import vo.SalesBillVO;
import vo.SalesGoodsVO;
import vo.UserInfoVO;

/**
 * @author 王宁一
 * @version 2017.12.27
 * 销售单
 *
 */
public class NewSalesBillUiController {

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
	private TextField oriMoneyText;
	
	@FXML
	private TextField discountText;
	
	@FXML
	private TextField couponText;
	
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
	
	private double oriAmount=0;
	
	private double discount=0;
	
	private double limit=0;
	
	private double amount=0;
	
	private UserInfoVO businessman;
	
	private CustomerVO customer;
	
	private boolean isSaved=true;
	
	Date date=new Date();
	
	public void init(UserInfoVO user) {
		userInfoVO=user;
		
		userIdText.setText(user.getId());
		billIdText.setPromptText("XSD-YYYYMMDD-XXXXX");
		
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
				
				discountText.textProperty().addListener(new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
						// TODO Auto-generated method stub
						isSaved=false;
					}
				});
				
				couponText.textProperty().addListener(new ChangeListener<String>() {

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
				
			//草稿箱
			draftListTable.setItems(drafts);
			ArrayList<SalesBillVO> bills=service.getSalesDraftBillsList(user);
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
							if(service.DeleteSalesDraft(bill.getId())){
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
							showContent((SalesBillVO)bill);
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
			e.printStackTrace();
		}
	}
	
	public void showContent(SalesBillVO bill) {
		billIdText.setText(bill.getId());
		userIdText.setText(userInfoVO.getId());
		sellerText.setText(bill.getCustomer().getName());
		businessManText.setText(bill.getBusinessman().getName());
		wareText.setText(""+bill.getWare());
		oriMoneyText.setText(""+bill.getOriMoney());
		discountText.setText(""+bill.getDiscount());
		couponText.setText(""+bill.getCoupon());
		moneyText.setText(""+bill.getMoney());
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
			billIdText.setText("XSD-"+dateTexts[0]+dateTexts[1]+dateTexts[2]+"-"+idText);
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
		
		SalesBillVO draft=new SalesBillVO();
		draft.setCreater(userInfoVO);
		draft.setCreateDate(date);
		draft.setCategoryEnum(BillCategoryEnum.SALES_BILL);
		draft.setBillStateEnum(BillStateEnum.DRAFT);
		draft.setId(billId);
		draft.setGoodsList(goodsVOs);
		draft.setWare(ware);
		draft.setCreaterComment(comment);
		draft.setOriMoney(oriAmount);
		draft.setCoupon(Double.parseDouble(couponText.getText()));
		draft.setMoney(amount);
		draft.setCustomer(customer);
		//TODO : 缺张傲的类
		//bill.setBusinessman(businessman);
		
		try {
			if(service.NewSalesDraft(draft)) {
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
		
		SalesBillVO bill=new SalesBillVO();
		bill.setCreater(userInfoVO);
		bill.setCreateDate(date);
		bill.setCategoryEnum(BillCategoryEnum.SALES_BILL);
		bill.setBillStateEnum(BillStateEnum.TBD);
		bill.setId(billId);
		bill.setGoodsList(goodsVOs);
		bill.setWare(ware);
		bill.setCreaterComment(comment);
		bill.setOriMoney(oriAmount);
		bill.setCoupon(Double.parseDouble(couponText.getText()));
		bill.setMoney(amount);
		bill.setCustomer(customer);
		//TODO : 缺张傲的类
		//bill.setBusinessman(businessman);
		
		try {
			if(service.NewSales(bill)) {
				isSaved=true;
			}
		} catch (Exception e) {
			
		}
	}
	
	public void choose(int position) {
		//Start
		ChooseUiStarter starter=new ChooseUiStarter();
		starter.salesStart(this, position);
				
	}
	
	public void replaceGoodsData(int position, GoodsVO goodsChoosed) {
		SalesGoodsVO toReplace=goods.get(position);
				
		toReplace.setGoodsName(goodsChoosed.getName());
		toReplace.setGoodsId(goodsChoosed.getNumber());
		toReplace.setGoodsType(goodsChoosed.getType());
		toReplace.setUnitPrice(Double.parseDouble(goodsChoosed.getSellingPrice()));//售价，复制时需注意
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
	protected void getDiscountNum() {
		double tempResult=Double.parseDouble(discountText.getText());
		switch (userInfoVO.getUserPositionEnum()) {
		case SALESMAN:
			limit=1000;
			verify();
			break;
		default:
			break;
		}
		
		switch (userInfoVO.getUserPositionEnum()) {
		case MANAGER://任意金额折让
			discount=tempResult;
			break;
		default:
			if(limit<tempResult) {
				discount=limit;
				discountText.setText(""+limit);
			}else {
				discount=tempResult;
			}
			break;	
		}
//		discount=Double.parseDouble(discountText.getText());
		amount=oriAmount-discount;
		if(amount<0) {
			amount=0;
		}
		moneyText.setText(""+amount);
	}
	
	private void verify() {
		
		Dialog<Pair<String, String>> dialog=new Dialog<>();
		dialog.setTitle("身份验证");
		dialog.setHeaderText("请确认您的权限");
		
		ButtonType loginButtonType=new ButtonType("确认", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField userId = new TextField();
		userId.setPromptText("UserID");
		PasswordField password = new PasswordField();
		password.setPromptText("Password");

		grid.add(new Label("UserID:"), 0, 0);
		grid.add(userId, 1, 0);
		grid.add(new Label("Password:"), 0, 1);
		grid.add(password, 1, 1);

		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);
		
		userId.textProperty().addListener((observable, oldValue, newValue) -> {
		    loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		Platform.runLater(()->userId.requestFocus());
		
		dialog.setResultConverter(dialogButton->{
			if(dialogButton==loginButtonType) {
				return new Pair<>(userId.getText(),password.getText());
			}
			return null;
		});
		
		Optional<Pair<String, String>> result=dialog.showAndWait();
		
		result.ifPresent(idPw->{
			//验证账号密码
			String id=idPw.getKey();
			String pw=idPw.getValue();
			//最高权限
			if(userInfoVO.getUserPositionEnum().toString().equals("manager")) {
				limit=5000;
				dialog.close();
			}else {
				dialog.setContentText("您没有权限");
			}
		});
	}
	
	@FXML
	//可以去掉
	protected void getCouponNum() {
		double coupon=Double.parseDouble(couponText.getText());
		amount=oriAmount-discount;
		if(amount<0) {
			amount=0;
		}
		moneyText.setText(""+amount);
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
			
			oriAmount=0;
			for(int i=0;i<goods.size();i++) {
				oriAmount+=goods.get(i).getSum();
			}
			
			amount=oriAmount-discount;
			if(amount<0) {
				amount=0;
			}
			oriMoneyText.setText(""+oriAmount);
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
			
			oriAmount=0;
			for(int i=0;i<goods.size();i++) {
				oriAmount+=goods.get(i).getSum();
			}

			amount=oriAmount-discount;
			if(amount<0) {
				amount=0;
			}
			oriMoneyText.setText(""+oriAmount);
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






























