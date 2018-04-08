package ui.commodityUi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import assistant.type.BillCategoryEnum;
import assistant.utility.Date;
import blService.commodityBlService.DeleteGoodsBlService;
import blService.commodityBlService.GoodsInforBlService;
import blService.commodityBlService.SaveBillBlService;
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

public class StockOutUiController {
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
	@FXML private TextField inputCurrentSellingPriceOfStock;
	@FXML private TextField productionDateOfStock;
	//properties of stock out

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
public void initDeleteUiInfor(GoodsVO goods){
	//��Ʒ�������
	    theGoods=goods;

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
@FXML protected void confirmStocKOut(){
	 String StockAmount=stockAmount.getText();
    String productionDate=productionDateOfStock.getText();
    String currentSellingPrice=inputCurrentSellingPriceOfStock.getText();

    boolean amountFormat=true;
    boolean productionDateFormat=true;
    boolean currentSellingPriceFormat=true;

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
   if(currentSellingPrice.equals("")){

   }else{
         if(Double.parseDouble(currentSellingPrice)<0.0){
  	  //Ĭ������������֡�������
     //����ļ۸�Ϊ��
  	      currentSellingPriceFormat=false;
  	      Alert priceFormatErr=new Alert(Alert.AlertType.ERROR,"��Ʒ������ۼ۲����Ǹ���");
  	      priceFormatErr.showAndWait();
         }else{

         }
   }

   if(amountFormat&&productionDateFormat&currentSellingPriceFormat){
   	//���и�ʽ����ȷ��������������С���ҷǸ����������ڷ���yyyy-MM-dd��ʽ��������۷Ǹ�
       //֮����д������
   	 stockOut();
   	 Alert deleteGoodsSuccess=new Alert(Alert.AlertType.INFORMATION,"��Ʒ�ɹ����⣡");
  	    deleteGoodsSuccess.showAndWait();
  	     //�ɹ�����֮�󣬼��warningֵ
        int dValue=compareWarning();
        if(dValue<=0){
       	 //��ǰ���С�ھ���ֵ�����ɿ�汨����
       	 newWarningBill(dValue);
       	 Alert inventoryWarning=new Alert(Alert.AlertType.INFORMATION,"����Ʒ��ǰ������(����)����ֵ�����Զ����ɿ�汨������");
	   	 inventoryWarning.showAndWait();
        }else{
       	 //dValue>0 ˵���ִ�����ھ���ֵ���������ɿ�汨����
        }
        //�ɹ����⣬������������󣬻ص�deleteGoodsUi0
        backToDeleteGoodsUi();
    }

}
private void stockOut(){
	   String StockAmount=stockAmount.getText();
	   String productionDate=productionDateOfStock.getText();
	   String currentSellingPrice=inputCurrentSellingPriceOfStock.getText();

      StockInOutVO stock=new StockInOutVO();
      stock.setAmount((Integer.parseInt(StockAmount))*(-1));
      //����������intΪ����
      if(currentSellingPrice.equals("")){
   	   //��������˿�汨�𡢱��絥�����ģ�������Ʒ����ʱ���ǲ���۸�ͳ������ڵ�
   	   //��ʱ����ʾ������¼��ʱ�򣬿�汨��۸�����Ϊ��Ʒ��Ϣ��������ۼۣ����������ڲ�����ʾ�ģ����֪���ǿ�汨����
   	   //������ʵ���Ǹ��ݵ��ݽ������ģ����������м۸�ģ�����ͨ��currentSellingPrice�϶������ǡ���
   	   stock.setCurrentSellingPrice(theGoods.getCurrentSellingPrice());
      }else{
   	   stock.setCurrentSellingPrice(currentSellingPrice);
      }
      stock.setCurrentCostPrice(null);
      stock.setGoodsID(theGoods.getNumber());
      stock.setGoodsName(theGoods.getName());
      stock.setOperatorName(operatorName);
      if(productionDate.equals("")){
   	   stock.setProductionDate(null);
      }else{
   	   stock.setProductionDate(productionDate);
      }
      Date currentTime=new Date();
      stock.setTime(currentTime);

      try{
      DeleteGoodsBlService deleteGoodsSer=CommodityRemoteHelper.getInstance().getDeleteGoodsBlService();
      deleteGoodsSer.delete(stock);
      }catch(RemoteException e){
   	   e.printStackTrace();
      }

}

private int compareWarning(){
	//��Ʒ����֮���뾯��ֵ�Ƚ�
	//�����뾯��ֵ�Ĳ�ֵ
	String GoodsID=theGoods.getNumber();
	int preAmount=theGoods.getAmount();
	String stockAmoun=stockAmount.getText();
	int currentAmount=preAmount-Integer.parseInt(stockAmoun);
	int dValue=0;
	try{
	DeleteGoodsBlService deleteGoodsSer=CommodityRemoteHelper.getInstance().getDeleteGoodsBlService();
    dValue=deleteGoodsSer.compareTowarning(GoodsID, currentAmount);
	}catch(RemoteException e){
		e.printStackTrace();
	}
	return dValue;
	}

private void newWarningBill(int dValue){

	InventoryWarningBillVO warningBill=new InventoryWarningBillVO();

	UserInfoVO operator=new UserInfoVO();
	operator.setId(operatorID);
	operator.setName(operatorName);

	warningBill.setCreater(operator);
	warningBill.setCategoryEnum(BillCategoryEnum.INVENTORY_WARNING_BILL);
	warningBill.setGoodsID(theGoods.getNumber());
	warningBill.setGoodsType(theGoods.getType());
	warningBill.setGoodsName(theGoods.getName());
	if(inputCurrentSellingPriceOfStock.getText().equals("")){
		//����ǿ�汨�����Ļ�������Ա������������ۼۣ�������Ϊ��Ʒ��������ۼ�
		warningBill.setGoodsPrice(theGoods.getCurrentSellingPrice());
	}else{
	warningBill.setGoodsPrice(inputCurrentSellingPriceOfStock.getText());
	}

	int preAmount=theGoods.getAmount();
	String stockAmoun=stockAmount.getText();
	int currentAmount=preAmount-Integer.parseInt(stockAmoun);
	int warningAmount=currentAmount+(-dValue);
	warningBill.setSystemAmount(String.valueOf(currentAmount));
	warningBill.setWarningAmount(String.valueOf(warningAmount));
	warningBill.setLossAmount(String.valueOf(-dValue));
	//lossAmount is active
	try{
	SaveBillBlService saveBillSer=CommodityRemoteHelper.getInstance().getSaveBillBlService();
	saveBillSer.saveInventoryWarningBill(warningBill);
	}catch(RemoteException e){
		e.printStackTrace();
	}


}

@FXML protected void cancelStockOut(){
	backToDeleteGoodsUi();
}

@FXML protected void obsoleteTheGoods(){
//ɾ����Ʒ����
	if(theGoods.getAmount()>0){
		Alert existGoodsError=new Alert(Alert.AlertType.ERROR,"�ֿ��л����ڸ���Ʒ������ȫ���������ɾ������Ʒ��");
		existGoodsError.showAndWait();
  	    //���������Ʒ���͵���ȫ������󣬲���ɾ������Ʒ
	}else{
	Alert obsoleteGoodsConfirm=new Alert(Alert.AlertType.CONFIRMATION,"��ȷ��Ҫ����ɾ�������Ʒ��");
	    Optional<ButtonType> choice=obsoleteGoodsConfirm.showAndWait();
	    if(choice.isPresent()&&(choice.get()==ButtonType.OK)){
	    	//�û�ѡ��ȷ��ɾ������Ʒ
	    	obsolete();
	    	Alert obsoleteGoodsSuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ�ɾ������Ʒ��");
	  	    obsoleteGoodsSuccess.showAndWait();
	  	    //ɾ������Ʒ��ص�deleteGoodsUi0
	  	  backToDeleteGoodsUi();
	  	 }else{

	    }
	}
}
private void obsolete(){
	String GoodsID=theGoods.getNumber();
	try{
	GoodsInforBlService goodsInforSer=CommodityRemoteHelper.getInstance().getGoodsInforBlService();
	GoodsVO theGoods=goodsInforSer.goodsINfor(GoodsID);
	DeleteGoodsBlService deleteGoodsSer=CommodityRemoteHelper.getInstance().getDeleteGoodsBlService();
   deleteGoodsSer.obsoleteGoods(theGoods);
}catch(RemoteException e){
	e.printStackTrace();
}
}

private void backToDeleteGoodsUi(){
	DeleteGoodsUiStarter starter=new DeleteGoodsUiStarter();
	starter.initDeleteGoodsUi(currentStage, operatorID, operatorName);
}
}
