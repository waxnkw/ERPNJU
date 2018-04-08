package ui.commodityUi;

import java.io.IOException;
import java.rmi.RemoteException;

import blService.commodityBlService.GoodsClassificationBlService;
import blService.commodityBlService.GoodsInforBlService;
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

public class ModifyGoodsUiController {
	@FXML private TextField newGoodsName;
	@FXML private TextField newGoodsType;
	@FXML private TextField newGoodsClassification;
	@FXML private TextField newCostPrice;
	@FXML private TextField newSellingPrice;
	@FXML private TextField newCurrentCostPrice;
	@FXML private TextField newCurrentSellingPrice;


private Stage currentStage;
private GoodsVO theGoods;
public void setStage(Stage stage){
	currentStage=stage;
}
public void initModifyGoodsInfor(GoodsVO goods){
	theGoods=goods;
	newGoodsName.setPromptText(theGoods.getName());
	newGoodsClassification.setPromptText(theGoods.getClassification());
	newGoodsType.setPromptText(theGoods.getType());
	newCostPrice.setPromptText(theGoods.getCostPrice());
	newSellingPrice.setPromptText(theGoods.getSellingPrice());
	newCurrentCostPrice.setPromptText(theGoods.getCurrentCostPrice());
	newCurrentSellingPrice.setPromptText(theGoods.getCurrentSellingPrice());
}

@FXML protected void confirmModifyGoodsInfor(){
	String newName=newGoodsName.getText();
	String newClassification=newGoodsClassification.getText();
	String newType=newGoodsType.getText();
	String newCost=newCostPrice.getText();
	String newSelling=newSellingPrice.getText();
	String newCurrentCost=newCurrentCostPrice.getText();
	String newCurrentSelling=newCurrentSellingPrice.getText();

	 boolean goodsExist=true;
     boolean classificationExist=true;
     boolean costPriceFormat=true;
     boolean sellingPriceFormat=true;
     boolean cuCostPriFormat=true;
     boolean cuSellPriFormat=true;

     GoodsInforBlService goodsInforSer=CommodityRemoteHelper.getInstance().getGoodsInforBlService();

	try{
		if(newName.equals("")||newName.equals(newGoodsName.getPromptText())){
		  if(newType.equals("")||newType.equals(newGoodsType.getPromptText())){
			  //���ֺ��ͺŶ�û��
            goodsExist=false;
		  }else{
			  //û�����֣������ͺ�
			String name=newGoodsName.getPromptText();
			goodsExist=goodsInforSer.ifGoodsExist(name,newType);
			if(goodsExist){
				 Alert goodsExistErr=new Alert(Alert.AlertType.ERROR,"����Ʒ�Ѵ���");
	        	 goodsExistErr.showAndWait();
			}else{
				theGoods.setType(newType);
			}
		  }
	    }else{
		  if(newType.equals("")||newType.equals(newGoodsType.getPromptText())){
			  //��������û���ͺ�
			  String goodsType=newGoodsType.getPromptText();
			  goodsExist=goodsInforSer.ifGoodsExist(newName,goodsType);
			  if(goodsExist){
					 Alert goodsExistErr=new Alert(Alert.AlertType.ERROR,"����Ʒ�Ѵ���");
		        	 goodsExistErr.showAndWait();
				}else{
					theGoods.setName(newName);
				}
		  }else{
			  //��������Ҳ�����ͺ�
			  goodsExist=goodsInforSer.ifGoodsExist(newName,newType);
			  if(goodsExist){
					 Alert goodsExistErr=new Alert(Alert.AlertType.ERROR,"����Ʒ�Ѵ���");
		        	 goodsExistErr.showAndWait();
				}else{
					theGoods.setName(newName);
					theGoods.setType(newType);
				}
		  }
	    }
	}catch(RemoteException e){
		e.printStackTrace();
	}
		//����µ���Ʒ����+�ͺŶ�Ӧ����Ʒ�Ƿ��Ѵ���
		if(newClassification.equals("")||newClassification.equals(newGoodsClassification.getPromptText())){

		}else{
			GoodsClassificationBlService classificationSer=CommodityRemoteHelper.getInstance().getGoodsClassificationBlService();
	          try{
	          classificationExist=classificationSer.ifClassificationExist(newClassification);
	          }catch(RemoteException e){
	             e.printStackTrace();
	        	  }

	          if(classificationExist==false){
	        	  Alert classNotExistErr=new Alert(Alert.AlertType.ERROR,"������𲻴���");
	        	  classNotExistErr.showAndWait();
	          }else{
	        	  try{
	    	          ClassificationVO classificationVO=classificationSer.classificationInfor(newClassification);
	    	          String newClassificationName=classificationVO.getName();
	    	          theGoods.setClassification(newClassificationName);
	    	          }catch(RemoteException e){
	    	             e.printStackTrace();
	    	        	  }

	          }
		}
        //����µĸ�����Ƿ����

		 if(newCost.equals("")||newCost.equals(newCostPrice.getPromptText())){

		 }else{
			 if(Double.parseDouble(newCost)<0.0){
	        	  //Ĭ������������֡�������
	        	  //����ļ۸�Ϊ��
	        	  costPriceFormat=false;
	        	  Alert priceFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ���۲����Ǹ���");
	        	  priceFormatErr.showAndWait();
	          }else{
                 theGoods.setCostPrice(newCost);
	          }
		 }

		 if(newSelling.equals("")||newSelling.equals(newSellingPrice.getPromptText())){

		 }else{
			 if(Double.parseDouble(newSelling)<0.0){
	        	  //Ĭ������������֡�������
	        	  //����ļ۸�Ϊ��
				  sellingPriceFormat=false;
	        	  Alert priceFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ���ۼ۲����Ǹ���");
	        	  priceFormatErr.showAndWait();
	          }else{
                theGoods.setSellingPrice(newSelling);
	          }
		 }

        if(newCurrentCost.equals("")||newCurrentCost.equals(newCurrentCostPrice.getPromptText())){

		 }else{
	          if(Double.parseDouble(newCurrentCost)<0.0){
	        	  //Ĭ������������֡�������
	        	  //���������Ʒ��������Ա������������
	        	  //����ļ۸�Ϊ��
	        	  cuCostPriFormat=false;
	        	  Alert priceFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ������۲����Ǹ���");
	        	  priceFormatErr.showAndWait();
	          }else{
                theGoods.setCurrentCostPrice(newCurrentCost);
	          }

		 }

        if(newCurrentSelling.equals("")||newCurrentSelling.equals(newCurrentSellingPrice.getPromptText())){

		 }else{
			 if(Double.parseDouble(newCurrentSelling)<0.0){
	        	  //Ĭ������������֡�������
	        	  //���������Ʒ��������Ա������ۼ������ۼ�
	        	  //����ļ۸�Ϊ��
	        	  cuSellPriFormat=false;
	        	  Alert priceFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ������ۼ۲����Ǹ���");
	        	  priceFormatErr.showAndWait();
	          }else{
                theGoods.setCurrentSellingPrice(newCurrentSelling);
	          }

		 }
        if((goodsExist==false)&&classificationExist&&costPriceFormat&&sellingPriceFormat&&cuCostPriFormat&&cuSellPriFormat){
            //���и�ʽ����ȷ������Ʒ�����ڣ������������ڣ����ۡ����ۼۡ�������ۡ�������ۼ۶��ǷǸ�
            //֮����д������
            try{

            	goodsInforSer.modifyGoodsInfor(theGoods);
            }catch(RemoteException e){
            	e.printStackTrace();
            }
            Alert modifyGoodsSuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ��޸���Ʒ��Ϣ��");
      	    modifyGoodsSuccess.showAndWait();
      	   //�ɹ��޸���Ʒ֮�󷵻�GoodsInforUi������ui��Ϣ
      	    backToGoodsInforUi();
            }

}

@FXML protected void cancelModifyGoodsInfor(){
	backToGoodsInforUi();
}
private void backToGoodsInforUi(){
	GoodsInforUiStarter starter=new GoodsInforUiStarter();
	starter.initGoodsInforUi(currentStage, theGoods.getNumber());
}
}
