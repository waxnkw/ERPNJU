package ui.billUi.billStateUi;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;


/**
 * 仓库管理员单据状态界面
 * @author guxinyu
 * @version 2017.12.19
 *
 */
public class WareKeeperBillStateUiStarter {
	private Stage stage=new Stage();
	
	public void wareKeeperBillStateUi(){
		URL location = getClass().getResource("WareKeeperBillStateUi.fxml");
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(location);
	    loader.setBuilderFactory(new JavaFXBuilderFactory());
		Parent root=null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		Scene scene=new Scene(root, StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
		stage.setScene(scene);
		
		WareKeeperBillStateUiController controller=new WareKeeperBillStateUiController();
		controller.init();
		
		stage.show();
	}
}
