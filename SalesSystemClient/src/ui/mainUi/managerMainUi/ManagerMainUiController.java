package ui.mainUi.managerMainUi;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import ui.approveBillUi.ApproveBillUiStarter;
import ui.promotionUi.PromotionUiStarter;
import vo.UserInfoVO;

/**
 * 总经理的主界面控制器
 * @author 张傲  161250193
 * @version 2017.12.10
 */
public class ManagerMainUiController implements Initializable{
	private UserInfoVO user;//用户信息
	
	@FXML
	private Text userNameText;//用户名称的text信息
	@FXML
	private Text userIdText;//用户id的text信息
	
	@FXML
	private Button promotionButton;//用户促销策略按钮
	@FXML
	private Button approveBillButton;//审批单据按钮
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//userNameText.setText(user.getName());
		//userIdText.setText(user.getId());
	}

	public void setUser(UserInfoVO user){
		this.user = user; 
		userNameText.setText(user.getName());
		userIdText.setText(user.getId());
	}
	
	@FXML
	protected void promotionButtonListener(){
		PromotionUiStarter starter =new PromotionUiStarter();
		starter.start(user);
	}  
	
	@FXML
	protected void approveBillButtonListener(){
		ApproveBillUiStarter approveBillUiStarter = new ApproveBillUiStarter();
		approveBillUiStarter.start(user);
	} 
}
