/**
 * 
 */
package ui.loginUi;

import java.rmi.RemoteException;

import blService.logBlService.LogBlService;
import blStubs.logBlStubs.LogBlService_Stub;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author cosx
 *
 */
public class RegisterUiController {

	Stage stage;
	
	@FXML
	private TextField userIdTextField;
	
	@FXML
	private Text oldPwPromptText;
	
	@FXML
	private PasswordField oldPwTextField;
	
	@FXML
	private Text newPwPromptText;
	
	@FXML
	private PasswordField newPwTextField;
	
	@FXML
	private Text promptText;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancleButton;
	
	LogBlService loginService=new LogBlService_Stub();
	
	boolean registered=false;
	
	public void init(Stage stage, boolean m_registered) {
		this.stage=stage;
		registered=m_registered;
		if(!registered) {
			oldPwPromptText.setText("��֤���룺");
			oldPwTextField.setPromptText("�������ʼ����");
			
			newPwPromptText.setVisible(false);
			newPwTextField.setVisible(false);
		}else {
			String userId="";
			String oldPassword="";
			changePassword(userId, oldPassword);
		}
		
	}
	
	@FXML
	private void confirm() {
		String userId=userIdTextField.getText();
		String oldPassword=oldPwTextField.getText();
		if(!registered) {
			try {
				if(loginService.registerUser(userId, oldPassword)) {
					changePassword(userId, oldPassword);
				}else {
					promptText.setText("����Ա��δע�ᣡ");
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				promptText.setText("ע��ʧ�ܣ������ԣ�");
			}
		}
		
		
	}
	
	@FXML
	private void cancle() {
		LoginUiStarter starter=new LoginUiStarter();
		starter.setStage(stage);
		starter.startLogin();
	}
	
	private void changePassword(String userId, String oldPassword) {
		if(userId.equals("")&&oldPassword.equals("")) {
			
		}else {
			oldPwPromptText.setText("�����룺");
			oldPwTextField.setText(oldPassword);
			
			newPwPromptText.setVisible(true);
			newPwTextField.setVisible(true);
		}
		String newPassword=newPwTextField.getText();
		try {
			if(loginService.changePassword(userId, oldPassword, newPassword)) {
				promptText.setText("��������ɹ��������µ�¼");
			}else {
				promptText.setText("��������ʧ��");
				oldPwPromptText.setText("");
				newPwPromptText.setText("");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}



















