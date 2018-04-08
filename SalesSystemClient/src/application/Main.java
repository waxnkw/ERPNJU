package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.loginUi.LoginUiStarter;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			LoginUiStarter starter=new LoginUiStarter();
			
			primaryStage.initStyle(StageStyle.TRANSPARENT);
	
			starter.setStage(primaryStage);
			starter.startLogin();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
