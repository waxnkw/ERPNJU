package ui.mainUi.managerMainUi;

import javafx.application.Application;
import javafx.stage.Stage;
import vo.UserInfoVO;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		ManagerMainUiStarter starter = new ManagerMainUiStarter();
		UserInfoVO user = new UserInfoVO();
		user.setId("12345");
		user.setName("zhangao");
		starter.start(user);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
