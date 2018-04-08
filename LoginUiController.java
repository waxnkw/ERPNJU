/**
 * 
 */
package ui.loginUi;

import java.rmi.RemoteException;

import blService.adminBlService.AdminBlService;
import blService.logBlService.LogBlService;
import blStubs.adminBlStubs.AdminBlService_Stub;
import blStubs.logBlStubs.LogBlService_Stub;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.adminUi.AdminUiStarter;
import ui.mainUi.financialStaffMainUi.FinancialStaffMainUiStarter;
import ui.mainUi.managerMainUi.ManagerMainUiStarter;
import ui.mainUi.wareKeeperMainUi.WareKeeperMainUiStarter;
import vo.UserInfoVO;
import vo.UserVO;

/**
 * @author ����һ
 * @version 2017.12.27
 * ��¼����Controller
 *
 */
public class LoginUiController {
	
	Stage stage=new Stage();
	
	@FXML
	private TextField userIdTextField;
	
	@FXML
	private PasswordField userPasswordTextField;
	
	@FXML
	private Text promptTextField;
	
	@FXML
	private Button registerButton;
	
	@FXML
	private Button LoginButton;

	/**
	 * ���ý���
	 */
	AdminBlService getUserService=new AdminBlService_Stub();
	LogBlService loginService=new LogBlService_Stub();
	public void init(Stage stage) {
		// TODO Auto-generated method stub
		this.stage=stage;
	}
	
	@FXML
	private void login() {
		String idString=userIdTextField.getText();
		String pwString=userPasswordTextField.getText();
		
		try {
			if(loginService.isValidUser(idString, pwString)) {
				UserVO userVO=getUserService.getUser(idString);
				UserInfoVO userInfoVO=new UserInfoVO();
				userInfoVO.setId(idString);
				userInfoVO.setName(userVO.getName());
				userInfoVO.setUserPositionEnum(userVO.getPosition());
				
				switch (userVO.getPosition()) {
				case MANAGER:
					ManagerMainUiStarter managerMainUiStarter=new ManagerMainUiStarter();
					managerMainUiStarter.start(userInfoVO);
					stage.close();
					break;
				case WAREKEPPER:
					WareKeeperMainUiStarter wareKeeperMainUiStarter=new WareKeeperMainUiStarter();
					wareKeeperMainUiStarter.wareKeeperMainUi(stage, userInfoVO.getName(), idString);
					stage.close();
					break;
				case FINANCE:
					FinancialStaffMainUiStarter financialStaffMainUiStarter=new FinancialStaffMainUiStarter(userInfoVO);
					financialStaffMainUiStarter.mainUi();
					stage.close();
					break;
				case ADMIN:
					AdminUiStarter adminUiStarter=new AdminUiStarter();
					adminUiStarter.start();
				case SALESMAN:
					//�����
					break;

				default:
					break;
				}
			}else {
				promptTextField.setText("������������������ע��");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void register() {
		RegisterUiStarter registerUiStarter=new RegisterUiStarter();
		registerUiStarter.startRegister(false);
	}

}

























