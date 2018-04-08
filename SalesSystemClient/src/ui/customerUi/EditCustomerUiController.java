/**
 * 
 */
package ui.customerUi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;

import assistant.type.CustomerLevelEnum;
import blService.customerBlService.CustomerBlService;
import blService.logBlService.LogBlService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;
import rmi.remoteHelper.CustomerRemoteHelper;
import rmi.remoteHelper.LogRemoteHelper;
import rmi.remoteHelper.RemoteHelperFactory;
import vo.CustomerVO;
import vo.UserInfoVO;

/**
 * @author ����һ
 *
 */
public class EditCustomerUiController {
	
	private Stage stage;
	
	private SelectCustomerUiController selectCustomerUiController;
	
	private CustomerVO oriCustomer;
	
	private CustomerVO changedCustomer;

	@FXML
	private TextField idTextField;
	
	@FXML
	private TextField typeTextField;
	
	@FXML
	private ComboBox<String> levelComboBox;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField telTextField;
	
	@FXML
	private TextField addressTextField;
	
	@FXML
	private TextField postTextField;
	
	@FXML
	private TextField emailTextField;
	
	@FXML
	private TextField businessmanTextField;
	
	@FXML
	private Text shouldReceiveText;
	
	@FXML
	private Text shouldPayText;
	
	@FXML
	private TextField shouldReceiveCreditTextField;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancleButton;
	
	ObservableList<String> options=FXCollections.observableArrayList(
			CustomerLevelEnum.VIP1.toString(),
			CustomerLevelEnum.VIP2.toString(),
			CustomerLevelEnum.VIP3.toString(),
			CustomerLevelEnum.VIP4.toString(),
			CustomerLevelEnum.VIP5.toString()
		);
	boolean isChanged=false;
	
	private CustomerRemoteHelper customerRemoteHelper=RemoteHelperFactory.getCustomerRemoteHelper();
	
	private LogRemoteHelper logRemoteHelper=RemoteHelperFactory.getLogRemoteHelper();
	
	private CustomerBlService service=customerRemoteHelper.getCustomerBlService();
	//private CustomerBlService service=new CustomerBlService_Stub();
	
	private LogBlService verifyService=logRemoteHelper.getLogBlService();
	//private LogBlService verifyService=new LogBlService_Stub();
	
	public void init(SelectCustomerUiController selectCustomerUiController, CustomerVO customerVO, Stage stage) {
		
		this.selectCustomerUiController=selectCustomerUiController;
		this.oriCustomer=customerVO;
		this.stage=stage;
		
		
		idTextField.setText(oriCustomer.getId());
		typeTextField.setText(oriCustomer.getType());
		
		levelComboBox.setItems(options);
		levelComboBox.setEditable(true);
		
		levelComboBox.setValue(oriCustomer.getLevel().toString());
		levelComboBox.setOnAction(eve->{
			changedCustomer.setLevel(CustomerLevelEnum.valueOf(levelComboBox.getSelectionModel().getSelectedItem()));
		});
		
		nameTextField.setText(oriCustomer.getName());
		addressTextField.setText(oriCustomer.getAddress());
		emailTextField.setText(oriCustomer.getEmail());
		telTextField.setText(oriCustomer.getTel());
		postTextField.setText(oriCustomer.getPost());
		shouldReceiveText.setText(oriCustomer.getShouldReceive()+"");
		shouldPayText.setText(oriCustomer.getShouldPay()+"");
		shouldReceiveCreditTextField.setText(oriCustomer.getShouldReceiveCredit()+"");
		shouldReceiveCreditTextField.setEditable(false);
	}
	
	@FXML
	protected void confirmButtonListener() {
		if(isChanged) {
			changedCustomer.setId(idTextField.getText());
			changedCustomer.setType(typeTextField.getText());
			changedCustomer.setLevel(CustomerLevelEnum.valueOf(levelComboBox.getValue()));
			changedCustomer.setName(nameTextField.getText());
			changedCustomer.setAddress(addressTextField.getText());
			changedCustomer.setEmail(emailTextField.getText());
			changedCustomer.setTel(telTextField.getText());
			changedCustomer.setPost(postTextField.getText());
			String businessmanStr=businessmanTextField.getText();
			
			try {
				
				ArrayList<UserInfoVO> userList=new ArrayList<>();
				userList=service.GetUsers();
				
				//Ӧ����null������ʱҪ��
				boolean isExist=false;
				for(int i=0;i<userList.size();i++) {
					if(userList.get(i).getName().equals(businessmanStr)) {
						//UserVOתUserInfoVO
						UserInfoVO toFillin=new UserInfoVO();
						toFillin.setId(userList.get(i).getId());
						toFillin.setName(businessmanStr);
						toFillin.setUserPositionEnum(userList.get(i).getUserPositionEnum());
						changedCustomer.setDefaultSalesman(toFillin);
						isExist=true;
						break;
					}
				}
				if(!isExist) {
					//TODO Ӧ������ʾ�����ڸ�ҵ��Ա
					Alert alert=new Alert(AlertType.ERROR);
					alert.setTitle("����");
					alert.setHeaderText(null);
					alert.setContentText("�����ڸ�ҵ��Ա!");
					alert.showAndWait();
					changedCustomer.setDefaultSalesman(oriCustomer.getDefaultSalesman());
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			changedCustomer.setShouldReceive(oriCustomer.getShouldReceive());
			changedCustomer.setShouldPay(oriCustomer.getShouldPay());
			changedCustomer.setShouldReceiveCredit(Double.parseDouble(shouldReceiveCreditTextField.getText()));
			//������ʾȷ��
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("ϵͳ��Ϣ");
			alert.setHeaderText(null);
			alert.setContentText("�޸Ŀͻ���Ϣ�ɹ�!");
			alert.showAndWait();
			selectCustomerUiController.changeCustomer(oriCustomer, changedCustomer);
			stage.close();
			
		}else {
			stage.close();
		}
	}
	
	@FXML
	protected void cancleButtonListener() {
		//������ʾ ȷ��ȡ����
		Alert confirmation=new Alert(AlertType.CONFIRMATION);
		confirmation.setTitle("ϵͳ��Ϣ");
		confirmation.setHeaderText(null);
		confirmation.setContentText("��ȷ��Ҫȡ���༭��");
		Optional<ButtonType> result=confirmation.showAndWait();
		if(result.get()==ButtonType.OK) {
			stage.close();
		}else {
			confirmation.close();
		}
	}
	
	@FXML
	protected void commonInfoChanged() {
		isChanged=true;
	}
	
	@FXML
	protected void shouldReceiveCreditChanged() {
		Dialog<Pair<String, String>> dialog=new Dialog<>();
		dialog.setTitle("�����֤");
		dialog.setHeaderText("��ȷ������Ȩ��");
		
		ButtonType loginButtonType=new ButtonType("ȷ��", ButtonData.OK_DONE);
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
			//��֤�˺�����
			String id=idPw.getKey();
			String pw=idPw.getValue();
			//���Ȩ��
			try {
				if(verifyService.isValidUser(id, pw)) {
					ArrayList<UserInfoVO> userInfoVOs=new ArrayList<>();
					userInfoVOs=service.GetUsers();
					for(int i=0;i<userInfoVOs.size();i++) {
						UserInfoVO user=userInfoVOs.get(i);
						if(user.getId().equals(id)) {
							if(user.getUserPositionEnum().toString().equals("manager")) {
								shouldReceiveCreditTextField.setEditable(true);
								dialog.close();
							}else {
								dialog.setContentText("��û��Ȩ��");
							}
						}
					}
					
				}else {
					dialog.setContentText("�˺Ż��������");
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});

	}
	
			
	
}
































