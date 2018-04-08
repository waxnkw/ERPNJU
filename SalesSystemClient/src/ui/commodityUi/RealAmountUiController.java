package ui.commodityUi;

import java.io.IOException;
import java.rmi.RemoteException;

import assistant.type.BillCategoryEnum;
import blService.commodityBlService.ActualInventoryCheckBlService;
import blService.commodityBlService.SaveBillBlService;
import blStubs.commodityBlStubs.ActualInventoryCheckService_Stub;
import blStubs.commodityBlStubs.SaveBillService_Stub;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rmi.remoteHelper.CommodityRemoteHelper;
import ui.uiAssistants.StageSize;
import vo.GoodsVO;
import vo.InventoryLossBillVO;
import vo.InventoryOverBillVO;
import vo.UserInfoVO;

public class RealAmountUiController {

	@FXML private Text goodsName;
	@FXML private Text goodsID;
	@FXML private Text classification;
	@FXML private Text type;
	@FXML private Text amount;
	@FXML private Text costPrice;
	@FXML private Text sellingPrice;
	@FXML private Text currentCostPrice;
	@FXML private Text currentSellingPrice;
	@FXML private TextField realAmount;

private Stage currentStage;
private String operatorID;
private String operatorName;
private GoodsVO theGoods;
public void setStage(Stage stage){
	currentStage=stage;
}
public void setOperator(String id,String name){
	operatorID=id;
	operatorName=name;
}

public void initRealAmountCheckUi(GoodsVO vo){
	theGoods=vo;

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

@FXML protected void confirmRealAmount(){
    String realAmountStr=realAmount.getText();
    double realAmount=Double.parseDouble(realAmountStr);
    if((double)(realAmount-(int)realAmount)!=0.0){
  	  Alert inputDoubleError=new Alert(Alert.AlertType.ERROR,"������Ʒ����������С��");
  	  inputDoubleError.showAndWait();
    }else{
  	  if(realAmount<0.0){
  	   Alert negativeInputError=new Alert(Alert.AlertType.ERROR,"������Ʒ���������Ǹ���");
  	   negativeInputError.showAndWait();
  	  }else{
  		  int dValue=0;
  			try{
  			  	ActualInventoryCheckBlService actulInvenService=CommodityRemoteHelper.getInstance().getActualInventoryCheckBlService();
  			    dValue=actulInvenService.actualInventoryCheck(theGoods.getNumber(), (int)realAmount);
  			    //dValue=actualAmount-systemAmount
 			  	}catch(RemoteException e){
			  		e.printStackTrace();
			  	}
  	    	   if(dValue>0){
  	    		   //get the inventoryOverBillVO
  	    		   //ֻ���������úñ����ڷ�������������ʱ��ʾ�ڽ��棬���ǿ���ͨ���鿴����ȥ��
  	    		   //�������Ľ����˵��ݣ��ǵü�ʱ��ʾһ���Ի�����߲���Աһ�¾�����
  	    		   newInventoryOverBill(dValue);
  	    		   Alert inventoryOver=new Alert(Alert.AlertType.INFORMATION,"����Ʒʵ�ʿ�泬��ϵͳ��棬���Զ����ɿ�汨�絥��");
  	    	   	   inventoryOver.showAndWait();
  	    	   	   backToActualInveCheckUi();

  	    	   }else if(dValue<0){
  	    		 //get the inventoryLossBillVO
  	    		   newInventoryLossBill(dValue);
  	    		   Alert inventoryLoss=new Alert(Alert.AlertType.INFORMATION,"����Ʒʵ�ʿ������ϵͳ��棬���Զ����ɿ�汨�𵥣�");
  	    	   	   inventoryLoss.showAndWait();
  	    	   	   backToActualInveCheckUi();
  	    	   }else{
  	    		   Alert inventoryEqual=new Alert(Alert.AlertType.INFORMATION,"����Ʒʵ�ʿ�����ϵͳ��棬δ�����κο�汨����������");
  	    	   	   inventoryEqual.showAndWait();
  	    	   	   backToActualInveCheckUi();
  	    	   }
  	  }
    }
	}

	private void newInventoryOverBill(int dValue){
		InventoryOverBillVO overBill=new InventoryOverBillVO();

  	UserInfoVO operator=new UserInfoVO();
  	operator.setId(operatorID);
  	operator.setName(operatorName);

  	overBill.setCreater(operator);
  	overBill.setCategoryEnum(BillCategoryEnum.INVENTORY_OVER_BILL);
  	overBill.setGoodsID(theGoods.getNumber());
  	overBill.setGoodsName(theGoods.getName());
  	overBill.setGoodsType(theGoods.getType());
  	if(theGoods.getCurrentCostPrice()==null){
  		overBill.setGoodsPrice(theGoods.getCurrentSellingPrice());
  	}else{
  		overBill.setGoodsPrice(theGoods.getCurrentCostPrice());
  	}
  	overBill.setSystemAmount(String.valueOf(theGoods.getAmount()));
  	overBill.setRealAmount(String.valueOf(realAmount.getText()));
  	overBill.setOverAmount(String.valueOf(dValue));
  	try{
  	SaveBillBlService saveBillSer=CommodityRemoteHelper.getInstance().getSaveBillBlService();
  	saveBillSer.saveInventoryOverBill(overBill);
  	}catch(RemoteException e){
  		e.printStackTrace();
  	}

	}
  private void newInventoryLossBill(int dValue){
  	InventoryLossBillVO lossBill=new InventoryLossBillVO();

  	UserInfoVO operator=new UserInfoVO();
  	operator.setId(operatorID);
  	operator.setName(operatorName);

  	lossBill.setCreater(operator);
  	lossBill.setCategoryEnum(BillCategoryEnum.INVENTORY_LOSS_BILL);
  	lossBill.setGoodsID(theGoods.getNumber());
  	lossBill.setGoodsName(theGoods.getName());
  	lossBill.setGoodsType(theGoods.getType());
  	if(theGoods.getCurrentSellingPrice()==null){
  		lossBill.setGoodsPrice(theGoods.getCurrentCostPrice());
  	}else{
  		lossBill.setGoodsPrice(theGoods.getCurrentSellingPrice());
  	}
  	lossBill.setSystemAmount(String.valueOf(theGoods.getAmount()));
  	lossBill.setRealAmount(String.valueOf(realAmount.getText()));
  	lossBill.setLossAmount(String.valueOf(-dValue));
  	try{
  	SaveBillBlService saveBillSer=CommodityRemoteHelper.getInstance().getSaveBillBlService();
  	saveBillSer.saveInventoryLossBill(lossBill);
  	}catch(RemoteException e){
  		e.printStackTrace();
  	}
}

  @FXML protected void cancelRealAmountUi(){
		//back to actualInvenCheck0UI
		backToActualInveCheckUi();
	}
	private void backToActualInveCheckUi(){
		ActualInventoryCheckUiStarter starter=new ActualInventoryCheckUiStarter();
		starter.initActualInventoryCheckUi(currentStage, operatorName, operatorID);
	}

}
