package ui.commodityUi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import assistant.utility.Date;
import blService.commodityBlService.AddGoodsBlService;
import blStubs.commodityBlStubs.AddGoodsService_Stub;
import blStubs.commodityBlStubs.GoodsInforService_Stub;
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
import vo.StockInOutVO;

public class StockInUiController {
	@FXML private Text goodsNameOfStock;
	@FXML private Text goodsIDOfStock;
	@FXML private Text classificationOfStock;
	@FXML private Text typeOfStock;
	@FXML private Text amountOfStock;
	@FXML private Text costPriceOfStock;
	@FXML private Text sellingPriceOfStock;
	@FXML private Text currentCostPriceOfStock;
	@FXML private Text currentSellingPriceOfStock;
    @FXML private TextField stockAmount;
	@FXML private TextField inputCurrentCostPriceOfStock;
	@FXML private TextField productionDateOfStock;
	//properties of stock in

	private Stage currentStage;
	private String operator;
	private GoodsVO theGoods;
public void setStage(Stage stage){
	currentStage=stage;
}
public void setOperator(String operatorName){
	operator=operatorName;
}
public void initAddUiInfor(GoodsVO vo){
//�ֿ����Ա������Ʒ���Ľ���
	theGoods=vo;
	goodsNameOfStock.setText("���ƣ�"+theGoods.getName());
	goodsIDOfStock.setText("��ţ�"+theGoods.getNumber());
	classificationOfStock.setText("�������"+theGoods.getClassification());
	typeOfStock.setText("�ͺţ�"+theGoods.getType());
	amountOfStock.setText(String.valueOf("���������"+theGoods.getAmount()));
	costPriceOfStock.setText("���ۣ�"+theGoods.getCostPrice());
	sellingPriceOfStock.setText("���ۼۣ�"+theGoods.getSellingPrice());
	currentCostPriceOfStock.setText("������ۣ�"+theGoods.getCurrentCostPrice());
	currentSellingPriceOfStock.setText("������ۼۣ�"+theGoods.getCurrentSellingPrice());
}

@FXML protected void confirmStocKIn(){
 String StockAmount=stockAmount.getText();
 String productionDate=productionDateOfStock.getText();
 String currentCostPrice=inputCurrentCostPriceOfStock.getText();

 boolean amountFormat=true;
 boolean productionDateFormat=true;
 boolean currentCostPriceFormat=true;

 double amountDouble=Double.parseDouble(StockAmount);
 if((double)(amountDouble-(int)amountDouble)!=0.0){
	  //���������amount��С��
	  amountFormat=false;
	  Alert amountFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ����������С��");
	  amountFormatErr.showAndWait();
 }else{
	  int amountInteger=Integer.parseInt(StockAmount);
	  if(amountInteger<0){
		  //���������amount�Ǹ���
		  amountFormat=false;
		  Alert amountFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ���������Ǹ���");
   	  amountFormatErr.showAndWait();
	  }else{

	  }
 }

 if(productionDate.equals("")){

 }else{
	 try{
   		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
   		format.parse(productionDate);
   		}catch(ParseException e){
   			//��Ʒ�ĳ������ڲ���yyyy-MM-dd��ʽ
   			productionDateFormat=false;
   			Alert dateFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ�������ڸ�ʽ����");
       	    dateFormatErr.showAndWait();
   		}
 }
if(currentCostPrice.equals("")){

}else{
      if(Double.parseDouble(currentCostPrice)<0.0){
	  //Ĭ������������֡�������
	  //���������Ʒ��������Ա������������
  //����ļ۸�Ϊ��
	      currentCostPriceFormat=false;
	      Alert priceFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ������۲����Ǹ���");
	      priceFormatErr.showAndWait();
      }else{

      }
}

if(amountFormat&&productionDateFormat&currentCostPriceFormat){
	//���и�ʽ����ȷ�������������С���ҷǸ����������ڷ���yyyy-MM-dd��ʽ��������۷Ǹ�
    //֮����д������
	 stockIn();
	 Alert addGoodsSuccess=new Alert(Alert.AlertType.INFORMATION,"��Ʒ�ɹ���⣡");
	     addGoodsSuccess.showAndWait();
	     //�ɹ����֮�󷵻�addGoodsUi0
	     backToAddGoodsUi();
 }

}

@FXML protected void cancelStockIn(){
	backToAddGoodsUi();
}

private void stockIn(){
   String StockAmount=stockAmount.getText();
   String productionDate=productionDateOfStock.getText();
   String currentCostPrice=inputCurrentCostPriceOfStock.getText();

   StockInOutVO stock=new StockInOutVO();
   stock.setAmount(Integer.parseInt(StockAmount));
   if(currentCostPrice.equals("")){
	 //��������˿�汨�𡢱��絥�����ģ�������Ʒ����ʱ���ǲ���۸�ͳ������ڵ�
	 //��ʱ����ʾ������¼��ʱ�򣬼۸�����Ϊ��Ʒ��Ϣ�е�������ۣ������ڻ���ʾΪnull����֪���ǿ�汨�絥��
	 //������ʵ���Ǹ��ݵ��ݽ������ģ����������м۸�ģ�����ͨ��currentSellingPrice�϶������ǡ���
	     stock.setCurrentCostPrice(theGoods.getCurrentCostPrice());
   }else{
	   stock.setCurrentCostPrice(currentCostPrice);
   }
   stock.setCurrentSellingPrice(null);
   stock.setGoodsID(theGoods.getNumber());
   stock.setGoodsName(theGoods.getName());
   stock.setOperatorName(operator);
   if(productionDate.equals("")){
	   stock.setProductionDate(null);
   }else{
	   stock.setProductionDate(productionDate);
   }
   Date currentTime=new Date();
   stock.setTime(currentTime);

   try{
   AddGoodsBlService addGoodsSer=CommodityRemoteHelper.getInstance().getAddGoodsBlService();
   addGoodsSer.add(stock);
   }catch(RemoteException e){
	   e.printStackTrace();
   }

}
private void backToAddGoodsUi(){
	AddGoodsUiStarter starter=new AddGoodsUiStarter();
	starter.initAddGoodsUi(currentStage, operator);
}

}
