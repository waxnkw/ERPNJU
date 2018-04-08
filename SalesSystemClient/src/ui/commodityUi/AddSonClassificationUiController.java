package ui.commodityUi;

import java.rmi.RemoteException;

import blService.commodityBlService.GoodsClassificationBlService;
import blStubs.commodityBlStubs.GoodsClassificationService_Stub;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rmi.remoteHelper.CommodityRemoteHelper;
import vo.ClassificationVO;


public class AddSonClassificationUiController {
	@FXML private TextField sonClassificationNameInput;

	private Stage currentStage;
	private String fatherClassificationID;
	private String fatherClassificationName;

	public void setStage(Stage stage){
		currentStage=stage;
	}
	public void setFather(String fatherID,String fatherName){
		fatherClassificationID=fatherID;
		fatherClassificationName=fatherName;
	}
	@FXML protected void confirmSonClassificationName(){
		 String nameInput=sonClassificationNameInput.getText();
	     try{
	   	  GoodsClassificationBlService classificationSer=CommodityRemoteHelper.getInstance().getGoodsClassificationBlService();
	   	  boolean ifNameExist=classificationSer.ifClassificationExist(nameInput);

	     if(ifNameExist){
	   	  //����������Ѵ���
	   	  Alert nameExistErr=new Alert(Alert.AlertType.ERROR,"����������Ѵ��ڣ�");
	   	  nameExistErr.showAndWait();
	     }else{
	   	  //��������Ʋ�����
	   	  ClassificationVO newSonClassification=new ClassificationVO();
	   	  newSonClassification.setName(nameInput);
	         newSonClassification.setFatherClassification(fatherClassificationID+"-"+fatherClassificationName);
	         newSonClassification.setSonClassification(null);
	         newSonClassification.setGoodsList(null);
	         classificationSer.addClassification(newSonClassification);
	         Alert addNewSonSuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ������µ�����Ʒ���");
	         addNewSonSuccess.showAndWait();

	        backToClassificationInforUi();
	         //�ɹ������µ������󣬻ص�classificationScene1������Ui
	     }
	     }catch(RemoteException e){
	   	  e.printStackTrace();
	     }
	}
	@FXML protected void cancelAddSonClassification(){
		 backToClassificationInforUi();
	    //�����κ��޸Ļص�classificationScene1����
	}
	private void backToClassificationInforUi(){
		ClassificationInforUiStarter starter=new ClassificationInforUiStarter();
		starter.initGoodsClassificationInfotUi(currentStage, fatherClassificationID);
	}


}
