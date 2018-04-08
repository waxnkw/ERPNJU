/**
 * �ֿ����Ա������Ʒɾ������Ʒ����Ľ���
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package ui.commodityUi;
//�������һ�����浥�ݵ��߼�������
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import assistant.type.BillCategoryEnum;
import assistant.utility.Date;
import blService.commodityBlService.GoodsInforBlService;
import blStubs.commodityBlStubs.DeleteGoodsService_Stub;
import blStubs.commodityBlStubs.GoodsInforService_Stub;
import blStubs.commodityBlStubs.SaveBillService_Stub;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rmi.remoteHelper.CommodityRemoteHelper;
import ui.uiAssistants.StageSize;
import vo.GoodsVO;
import vo.InventoryWarningBillVO;
import vo.StockInOutVO;
import vo.UserInfoVO;

public class DeleteGoodsUiController {
	@FXML TextField goodsID;

	private Stage currentStage;
	private String operatorName;
	private String operatorID;



	public void setStage(Stage stage){
		currentStage=stage;
	}
	public void setOperator(String id,String name){
		operatorName=name;
		operatorID=id;
	}
	@FXML protected void confirmGoodsID(){
		 boolean goodsExist=false;
		 String GoodsID=goodsID.getText();
		 GoodsInforBlService goodsInforSer=CommodityRemoteHelper.getInstance().getGoodsInforBlService();
        try{
       	 goodsExist=goodsInforSer.ifGoodsExist(GoodsID);

          if(goodsExist){
           GoodsVO goods=goodsInforSer.goodsINfor(GoodsID);
       	   initStockOutUi(goods);
          }else{
       	   Alert goodsNotExistErr=new Alert(Alert.AlertType.ERROR,"����Ʒ������");
      	   goodsNotExistErr.showAndWait();
          }
        }catch(RemoteException e){
        	  e.printStackTrace();
          }
	}

	@FXML protected void returnBack(){
		currentStage.close();
	}

	private void initStockOutUi(GoodsVO vo){
		StockOutUiStarter starter=new StockOutUiStarter();
		starter.initStockOutUi(currentStage, operatorID, operatorName, vo);
	}



}
