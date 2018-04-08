/**
 * �ֿ����Ա��½�������棬����������������в����İ�ť
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
	//��ʼ���ֿ������Ա������
	@FXML private Text operatorName;
	@FXML private Text operatorID;
	@FXML private Text Date;

	private Stage currentStage;
	private String opeName;
	private String opeID;

	public void setInitInfor(String name,String id,Stage stage){
		operatorName.setText("������Ա���ƣ�"+name);
		operatorID.setText("������Ա��ţ�"+id);
		Date date=new Date();
		Date.setText("���ڣ�"+date.getYMDDate());
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
	    //�κ�ʱ�򶼿��Խ��п���̵㣬ֻ����һ���������̵�Ƚ�ȫ�����
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
