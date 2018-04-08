package ui.commodityUi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import assistant.utility.Date;
import blService.commodityBlService.AddGoodsBlService;
import blService.commodityBlService.GoodsClassificationBlService;
import blService.commodityBlService.GoodsInforBlService;
import blStubs.commodityBlStubs.AddGoodsService_Stub;
import blStubs.commodityBlStubs.GoodsClassificationService_Stub;
import blStubs.commodityBlStubs.GoodsInforService_Stub;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rmi.remoteHelper.CommodityRemoteHelper;
import ui.uiAssistants.StageSize;
import vo.ClassificationVO;
import vo.GoodsVO;
import vo.StockInOutVO;

public class AddNewGoodsUiController {
	@FXML private TextField goodsNameOfNewGoods;
	@FXML private TextField classificationOfNewGoods;
	@FXML private TextField goodsTypeOfNewGoods;
	@FXML private TextField amountOfNewGoods;
	@FXML private TextField costPriceOfNewGoods;
	@FXML private TextField sellingPriceOfNewGoods;
	@FXML private TextField currentCostPriceOfNewGoods;
	@FXML private TextField currentSellingPriceOfNewGoods;
	@FXML private TextField productionDateOfNewGoods;
	//properties of add new goods


private Stage currentStage;
private String operator;
public void setStage(Stage stage){
	currentStage=stage;
}
public void setOperator(String operatorName){
	operator=operatorName;
}

@FXML protected void confirmAddNewGoods(){
    String GoodsName=goodsNameOfNewGoods.getText();
    String Classification=classificationOfNewGoods.getText();
    String GoodsType=goodsTypeOfNewGoods.getText();
    String Amount=amountOfNewGoods.getText();
    String CostPrice=costPriceOfNewGoods.getText();
    String SellingPrice=sellingPriceOfNewGoods.getText();
    String CurrentCostPrice=currentCostPriceOfNewGoods.getText();
    String CurrentSellingPrice=currentSellingPriceOfNewGoods.getText();
    String ProductionDate=productionDateOfNewGoods.getText();

    boolean goodsExist=true;
    boolean classificationExist=true;
    boolean amountFormat=true;
    boolean costPriceFormat=true;
    boolean sellingPriceFormat=true;
    boolean cuCostPriFormat=true;
    boolean cuSellPriFormat=true;
    boolean productionDateFormat=true;

    GoodsInforBlService goodsInforSer=CommodityRemoteHelper.getInstance().getGoodsInforBlService();
    try{
    goodsExist=goodsInforSer.ifGoodsExist(GoodsName, GoodsType);
    }catch(RemoteException e){
  	  e.printStackTrace();
    }

    if(goodsExist){
  	  Alert goodsExistErr=new Alert(Alert.AlertType.ERROR,"����Ʒ�Ѵ���");
  	  goodsExistErr.showAndWait();
    }

    GoodsClassificationBlService classificationSer=CommodityRemoteHelper.getInstance().getGoodsClassificationBlService();
    try{
    classificationExist=classificationSer.ifClassificationExist(Classification);
    }catch(RemoteException e){
       e.printStackTrace();
  	  }

    if(classificationExist==false){
  	  Alert classNotExistErr=new Alert(Alert.AlertType.ERROR,"������𲻴���");
  	  classNotExistErr.showAndWait();
    }

    double amountDouble=Double.parseDouble(Amount);
    if((double)(amountDouble-(int)amountDouble)!=0.0){
  	  //���������amount��С��
  	  amountFormat=false;
  	  Alert amountFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ����������С��");
  	  amountFormatErr.showAndWait();
    }else{
  	  int amountInteger=Integer.parseInt(Amount);
  	  if(amountInteger<0){
  		  //���������amount�Ǹ���
  		  amountFormat=false;
  		  Alert amountFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ���������Ǹ���");
      	  amountFormatErr.showAndWait();
  	  }else{

  	  }
    }

    if(Double.parseDouble(CostPrice)<0.0){
  	  //Ĭ������������֡�������
  	  //����ļ۸�Ϊ��
  	  costPriceFormat=false;
  	  Alert priceFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ���۲����Ǹ���");
  	  priceFormatErr.showAndWait();
    }else{

    }

    if(Double.parseDouble(SellingPrice)<0.0){
  	  //Ĭ������������֡�������
  	  //���������Ʒ��������Ա���ۼ������
  	  //����ļ۸�Ϊ��
  	  sellingPriceFormat=false;
  	  Alert priceFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ���ۼ۲����Ǹ���");
  	  priceFormatErr.showAndWait();
    }else{

    }

    if(Double.parseDouble(CurrentCostPrice)<0.0){
  	  //Ĭ������������֡�������
  	  //���������Ʒ��������Ա������������
  	  //����ļ۸�Ϊ��
  	  cuCostPriFormat=false;
  	  Alert priceFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ������۲����Ǹ���");
  	  priceFormatErr.showAndWait();
    }else{

    }

    if(Double.parseDouble(CurrentSellingPrice)<0.0){
  	  //Ĭ������������֡�������
  	  //���������Ʒ��������Ա������ۼ������ۼ�
  	  //����ļ۸�Ϊ��
  	  cuSellPriFormat=false;
  	  Alert priceFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ������ۼ۲����Ǹ���");
  	  priceFormatErr.showAndWait();
    }else{

    }

    try{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		format.parse(ProductionDate);
		}catch(ParseException e){
			//��Ʒ�ĳ������ڲ���yyyy-MM-dd��ʽ
			productionDateFormat=false;
			Alert dateFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ�������ڸ�ʽ����");
    	    dateFormatErr.showAndWait();
		}

    if((goodsExist==false)&&classificationExist&&amountFormat&&costPriceFormat&&sellingPriceFormat&&cuCostPriFormat&&cuSellPriFormat&&productionDateFormat){
     //���и�ʽ����ȷ������Ʒ�����ڣ������������ڣ�������int�ҷǸ������ۡ����ۼۡ�������ۡ�������ۼ۶��ǷǸ�����������Ҳ��yyyy-MM-dd��ʽ
     //֮����д������
     addNewGoods();
     Alert addNewGoodsSuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ���������Ʒ����⣡");
	   addNewGoodsSuccess.showAndWait();
	   //�ɹ���������Ʒ֮�󷵻�addGoodsUi0
	   backToAddGoodsUi();
     }


}

private void addNewGoods(){
	String GoodsName=goodsNameOfNewGoods.getText();
    String Classification=classificationOfNewGoods.getText();
    String GoodsType=goodsTypeOfNewGoods.getText();
    String Amount=amountOfNewGoods.getText();
    String CostPrice=costPriceOfNewGoods.getText();
    String SellingPrice=sellingPriceOfNewGoods.getText();
    String CurrentCostPrice=currentCostPriceOfNewGoods.getText();
    String CurrentSellingPrice=currentSellingPriceOfNewGoods.getText();
    String ProductionDate=productionDateOfNewGoods.getText();
    String classificationName=" ";
    try{
    GoodsClassificationBlService classificationSer=CommodityRemoteHelper.getInstance().getGoodsClassificationBlService();
    ClassificationVO classificationVO=classificationSer.classificationInfor(Classification);
    classificationName=classificationVO.getName();
    }catch(RemoteException e){
  	   e.printStackTrace();
     }

    GoodsVO newGoods=new GoodsVO();
    newGoods.setAmount(Integer.parseInt(Amount));
    newGoods.setClassification(classificationName);
    newGoods.setCostPrice(CostPrice);
    newGoods.setCurrentCostPrice(CurrentCostPrice);
    newGoods.setCurrentSellingPrice(CurrentSellingPrice);
    newGoods.setName(GoodsName);
    newGoods.setSellingPrice(SellingPrice);
    newGoods.setType(GoodsType);

    StockInOutVO stock=new StockInOutVO();
    stock.setAmount(Integer.parseInt(Amount));
    stock.setCurrentCostPrice(CurrentCostPrice);
    stock.setCurrentSellingPrice(null);
    stock.setGoodsName(GoodsName);
    stock.setOperatorName(operator);
    stock.setProductionDate(ProductionDate);
    Date currentTime=new Date();
    stock.setTime(currentTime);

    try{
    	AddGoodsBlService addGoodsSer=CommodityRemoteHelper.getInstance().getAddGoodsBlService();
    	 addGoodsSer.addNewGoods(newGoods, stock);
      }catch(RemoteException e){
 	   e.printStackTrace();
    }


}

@FXML protected void cancelAddNewGoods(){
	backToAddGoodsUi();
}

private void backToAddGoodsUi(){
	AddGoodsUiStarter starter=new AddGoodsUiStarter();
	starter.initAddGoodsUi(currentStage, operator);
}

}
