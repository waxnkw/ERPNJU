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

public class AddRootClassificationUiController {
	@FXML private TextField classificationNameInput;

	private Stage currentStage;
	public void setStage(Stage stage){
	currentStage=stage;
}

@FXML protected void confirmNewRootClassificationName(){
    String nameInput=classificationNameInput.getText();
    try{
  	  GoodsClassificationBlService classificationSer=CommodityRemoteHelper.getInstance().getGoodsClassificationBlService();
  	  boolean ifNameExist=classificationSer.ifClassificationExist(nameInput);

    if(ifNameExist){
  	  //����������Ѵ���
  	  Alert nameExistErr=new Alert(Alert.AlertType.ERROR,"����������Ѵ��ڣ�");
  	  nameExistErr.showAndWait();
    }else{
  	  //��������Ʋ�����
  	  ClassificationVO newRootClassification=new ClassificationVO();
  	  newRootClassification.setName(nameInput);
        newRootClassification.setFatherClassification(null);
        newRootClassification.setSonClassification(null);
        newRootClassification.setGoodsList(null);
        classificationSer.addNewClassification(newRootClassification);
        Alert addNewRootSuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ������µĸ���Ʒ���");
        addNewRootSuccess.showAndWait();

        backToGoodsClassificationUi();
	      //�ɹ������µĸ����󣬻ص�classificationScene0������Ui
    }
    }catch(RemoteException e){
  	  e.printStackTrace();
    }
}

@FXML protected void cancelAddNewClassification(){
    backToGoodsClassificationUi();
     //û���κβ���ֱ�ӻص�classificationScene0
}

private void backToGoodsClassificationUi(){
	GoodsClassificationUiStarter starter=new GoodsClassificationUiStarter();
	starter.initGoodsClassificationUi(currentStage);
}

}
