package ui.customerUi;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;

import java.rmi.RemoteException;
import java.util.Optional;

import assistant.type.CustomerLevelEnum;
import assistant.type.UserPositionEnum;
import blService.customerBlService.CustomerBlService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.util.Pair;
import rmi.remoteHelper.CustomerRemoteHelper;
import rmi.remoteHelper.RemoteHelperFactory;
import ui.mainUi.salesmanMainUi.SalesmanMainUiStarter;
import vo.CustomerVO;
import vo.UserInfoVO;

/**
 * @author 王宁一
 *
 */
public class AddCustomerUiController {
	private UserInfoVO user;
	
	@FXML
	private Label userNameText;
	
	@FXML
	private TextField idText;
	
	@FXML
	private TextField typeText;
	
	@FXML
	private TextField levelText;
	
	@FXML
	private TextField nameText;
	
	@FXML
	private TextField telText;
	
	@FXML
	private TextField addressText;
	
	@FXML
	private TextField postText;
	
	@FXML
	private TextField emailText;
	
	@FXML
	private TextField defaultSalesmanText;
	
	@FXML
	private TextField shouldReceiveCreditText;
	
	@FXML
	private Text shouldReceive;
	
	@FXML
	private Text shouldPay;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancleButton;
	
	private CustomerRemoteHelper remoteHelper=RemoteHelperFactory.getCustomerRemoteHelper();
	
	private CustomerBlService service=remoteHelper.getCustomerBlService();
	
	//private CustomerBlService service=new CustomerBlService_Stub();
	
	public void init(String Id, String name, UserPositionEnum position) {
		
		userNameText.setText(Id+System.lineSeparator()+name);
		
		shouldReceive.setText("无数据");
		shouldPay.setText("无数据");
		
		if(position.equals(UserPositionEnum.MANAGER)) {//最高权限
			shouldReceiveCreditText.setEditable(true);
		}else {
			shouldReceiveCreditText.setEditable(false);
			shouldReceiveCreditText.setText("未达到权限");
		}
		//客户编号暂不自动生成
		
	}
	
	@FXML
	protected void confirmButtonListener() {
		CustomerVO customer=new CustomerVO();
		customer.setAddress(addressText.getText());
		//TODO
		//customer.setDefaultSalesman(defaultSalesmanText.getText());
		customer.setEmail(emailText.getText());
		customer.setId(idText.getText());
		CustomerLevelEnum level=CustomerLevelEnum.valueOf(levelText.getText());
		customer.setLevel(level);
		customer.setName(nameText.getText());
		customer.setPost(postText.getText());
		double credit=Double.valueOf(shouldReceiveCreditText.getText());
		customer.setShouldReceiveCredit(credit);
		customer.setTel(telText.getText());
		customer.setType(typeText.getText());
		try {
			service.AddCustomer(customer);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void cancleButtonListener(ActionEvent event) {
		SalesmanMainUiStarter starter=new SalesmanMainUiStarter();
		starter.startSalesman(user);
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	protected void shouldReceiveCreditChanged() {
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
			if(user.getUserPositionEnum().toString().equals("manager")) {
				shouldReceiveCreditText.setEditable(true);
				dialog.close();
			}else {
				dialog.setContentText("您没有权限");
			}
		});

	}

	/**
	 * @param user
	 */
	public void setUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		this.user=user;
	}
	
	
}
























