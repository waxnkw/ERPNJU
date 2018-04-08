package ui.commodityUi;

import java.io.IOException;
import java.rmi.RemoteException;

import blService.commodityBlService.GoodsInforBlService;
import blStubs.commodityBlStubs.GoodsInforService_Stub;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rmi.remoteHelper.CommodityRemoteHelper;
import ui.uiAssistants.StageSize;
import vo.ClassificationVO;
import vo.GoodsVO;

public class GoodsInforUiController {
	@FXML private Text goodsName;
	@FXML private Text goodsID;
	@FXML private Text classification;
	@FXML private Text type;
	@FXML private Text amount;
	@FXML private Text costPrice;
	@FXML private Text sellingPrice;
	@FXML private Text currentCostPrice;
	@FXML private Text currentSellingPrice;

private Stage currentStage;
private GoodsVO theGoods;

public void setStage(Stage stage){
	currentStage=stage;
}
public void initGoodsInfor(String GoodsID){
	try{
        GoodsInforBlService goodsInfor=CommodityRemoteHelper.getInstance().getGoodsInforBlService();
        GoodsVO Goods=goodsInfor.goodsINfor(GoodsID);
        theGoods=Goods;
	}catch(RemoteException e){
		e.printStackTrace();
	}
        goodsName.setText("���ƣ�"+theGoods.getName());
		goodsID.setText("��ţ�"+theGoods.getNumber());
		classification.setText("�������"+theGoods.getClassification());
		type.setText("�ͺţ�"+theGoods.getType());
		amount.setText(String.valueOf("���������"+theGoods.getAmount()));
		costPrice.setText("���ۣ�"+theGoods.getCostPrice());
		sellingPrice.setText("���ۼۣ�"+theGoods.getSellingPrice());
		currentCostPrice.setText("������ۣ�"+theGoods.getCurrentCostPrice());
		currentSellingPrice.setText("������ۼۣ�"+theGoods.getCurrentSellingPrice());
}
@FXML protected void confirmGoodsInfor(){
	backToGoodsInforManaUi();
}

@FXML protected void initModifyGoodsInforUi(){
	//��ʼ����Ʒ��Ϣ�޸Ľ���
	ModifyGoodsUiStarter starter=new ModifyGoodsUiStarter();
	starter.initModifyGoodsUi(currentStage, theGoods);
}

private void backToGoodsInforManaUi(){
	GoodsInforManagementUiStarter starter=new GoodsInforManagementUiStarter();
	starter.initGoodsInforManagementUi(currentStage);
}
}
