/**
 * 仓库管理员登陆后主界面，包括其可以做的所有操作的按钮
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package ui.mainUi.wareKeeperMainUi;

import assistant.utility.Date;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.billUi.billStateUi.WareKeeperBillStateUiStarter;
import ui.commodityUi.ActualInventoryCheckUiStarter;
import ui.commodityUi.AddGoodsUiStarter;
import ui.commodityUi.DeleteGoodsUiStarter;
import ui.commodityUi.GoodsClassificationUiStarter;
import ui.commodityUi.GoodsInforManagementUiStarter;
import ui.commodityUi.InventoryCheckUiStarter;
import ui.commodityUi.StockCheckUiStarter;

public class WareKeeperMainUiController {
	//初始化仓库管理人员主界面
	@FXML private Text operatorName;
	@FXML private Text operatorID;
	@FXML private Text Date;

	private Stage currentStage;
	private String opeName;
	private String opeID;

	public void setInitInfor(String name,String id,Stage stage){
		operatorName.setText("操作人员名称："+name);
		operatorID.setText("操作人员编号："+id);
		Date date=new Date();
		Date.setText("日期："+date.getYMDDate());
		currentStage=stage;

		opeName=name;
		opeID=id;

	}
	@FXML protected void toViewBills(){
        WareKeeperBillStateUiStarter starter=new WareKeeperBillStateUiStarter();
        starter.wareKeeperBillStateUi();
	}
	@FXML protected void toClassMana(){
          GoodsClassificationUiStarter starter=new GoodsClassificationUiStarter();
          starter.initGoodsClassificationUi(null);
	}
	@FXML protected void toAddGoods(){
          AddGoodsUiStarter starter=new AddGoodsUiStarter();
          starter.initAddGoodsUi(null,opeName);
	}
	@FXML protected void toDeleteGoods(){
		DeleteGoodsUiStarter starter=new DeleteGoodsUiStarter();
        starter.initDeleteGoodsUi(null,opeID, opeName);
	}
	@FXML protected void toGoodsInfor(){
          GoodsInforManagementUiStarter starter=new GoodsInforManagementUiStarter();
          starter.initGoodsInforManagementUi(null);

	}
	@FXML protected void toStoCheck(){
          StockCheckUiStarter starter=new StockCheckUiStarter();
          starter.initStockCheckUi(null);
	}
	@FXML protected void toInvenCheck(){
	    //任何时候都可以进行库存盘点，只不过一天结束后的盘点比较全面罢了
		InventoryCheckUiStarter starter=new InventoryCheckUiStarter();
        starter.initInventoryCheckUi();
	//	}
	}
	@FXML protected void toActualInven(){
         ActualInventoryCheckUiStarter starter=new ActualInventoryCheckUiStarter();
         starter.initActualInventoryCheckUi(null,opeName,opeID);
	}
	@FXML protected void exit(){
         currentStage.close();
	}

}
