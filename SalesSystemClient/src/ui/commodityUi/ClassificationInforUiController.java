package ui.commodityUi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;

import blService.commodityBlService.GoodsClassificationBlService;
import blStubs.commodityBlStubs.GoodsClassificationService_Stub;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rmi.remoteHelper.CommodityRemoteHelper;
import ui.uiAssistants.StageSize;
import vo.ClassificationVO;

public class ClassificationInforUiController {
	@FXML private Text classificationName;
	@FXML private Text classificationID;
	@FXML private Text fatherClassification;
	@FXML private Text sonClassificationListLabel;
	@FXML private Text goodsListLabel;
	@FXML private VBox sonClassificationID;
	@FXML private VBox sonClassificationName;
	@FXML private VBox sonGoodsID;
	@FXML private VBox sonGoodsName;
	@FXML private VBox sonGoodsType;
	@FXML private ScrollPane scrollpane;

	private Stage currentStage;
	private ClassificationVO classification;
public void setStage(Stage stage){
	currentStage=stage;
}
public void setClassification(String id){
	try{
	GoodsClassificationBlService classificationSer=CommodityRemoteHelper.getInstance().getGoodsClassificationBlService();
    classification=classificationSer.classificationInfor(id);
	}catch(RemoteException e){
		e.printStackTrace();
	}
}
public void initAndUpdateClassificationInfor(){
	//��ʼ�������Ϣ
    //Ҳ����Ϊ�����ɾ��֮����������Ϣ������
         String name=classification.getName();
         String id=classification.getNumber();
         String father=classification.getFatherClassification();
         classificationID.setText("����ţ�"+id);
         classificationName.setText("������ƣ�"+name);
         if(father==null){
        	 fatherClassification.setText("�������");
         }else{
         fatherClassification.setText("�����"+father);
         }

         ArrayList<String> sonClassifications=classification.getSonClassifacation();
         ArrayList<String> sonGoods=classification.getGoodsList();

         if(sonClassifications==null||((sonClassifications!=null)&&(sonClassifications.size()==0))){
             sonClassificationListLabel.setText("������б���");
         }else{
        	 Label sonIDLabel=new Label();
             sonIDLabel.setId("sonIDLabel");
             sonIDLabel.setText("�������");
             sonIDLabel.setFont(Font.font(18));
             sonClassificationID.getChildren().removeAll();
             sonClassificationID.getChildren().add(sonIDLabel);
             Label sonNameLabel=new Label();
             sonNameLabel.setId("sonNameLabel");
             sonNameLabel.setText("���������");
             sonNameLabel.setFont(Font.font(18));
             sonClassificationName.getChildren().removeAll();
             sonClassificationName.getChildren().add(sonNameLabel);

        	 for(int i=0;i<=sonClassifications.size()-1;i++){
        		 String son=sonClassifications.get(i);
        		 String[] sonInfors=son.split("-");
        		 String sonId=sonInfors[0];
        		 String sonName=sonInfors[1];
        		 Text sonID=new Text();
        		 sonID.setText(sonId);
        		 sonID.setFont(Font.font(18));
        		 sonClassificationID.getChildren().add(sonID);
        		 Text sonNAME=new Text();
        		 sonNAME.setText(sonName);
        		 sonNAME.setFont(Font.font(18));
        		 sonClassificationName.getChildren().add(sonNAME);
        	 }
         }
         if(sonGoods==null||((sonGoods!=null)&&(sonGoods.size()==0))){
        	 goodsListLabel.setText("����Ʒ�б���");
         }else{
        	 Label sonGoodsIDLabel=new Label();
             sonGoodsIDLabel.setId("ssonGoodsIDLabel");
             sonGoodsIDLabel.setText("����Ʒ���");
             sonGoodsIDLabel.setFont(Font.font(18));
             sonGoodsID.getChildren().removeAll();
             sonGoodsID.getChildren().add(sonGoodsIDLabel);
             Label sonGoodsNameLabel=new Label();
             sonGoodsNameLabel.setId("sonGoodsNameLabel");
             sonGoodsNameLabel.setText("����Ʒ����");
             sonGoodsNameLabel.setFont(Font.font(18));
             sonGoodsName.getChildren().removeAll();
             sonGoodsName.getChildren().add(sonGoodsNameLabel);
             Label sonGoodsTypeLabel=new Label();
             sonGoodsTypeLabel.setId("sonGoodsTypeLabel");
             sonGoodsTypeLabel.setText("����Ʒ�ͺ�");
             sonGoodsTypeLabel.setFont(Font.font(18));
             sonGoodsType.getChildren().removeAll();
             sonGoodsType.getChildren().add(sonGoodsTypeLabel);
        	 for(int i=0;i<=sonGoods.size()-1;i++){
        		 String good=sonGoods.get(i);
        		 String[] goodInfors=good.split("-");
        		 String goodId=goodInfors[0];
        		 String goodName=goodInfors[1];
        		 String goodType=goodInfors[2];
        		 Text goodID=new Text();
        		 goodID.setText(goodId);
        		 goodID.setFont(Font.font(18));
        		 sonGoodsID.getChildren().add(goodID);
        		 Text goodNAME=new Text();
        		 goodNAME.setText(goodName);
        		 goodNAME.setFont(Font.font(18));
        		 sonGoodsName.getChildren().add(goodNAME);
        		 Text goodTYPE=new Text();
        		 goodTYPE.setText(goodType);
        		 goodTYPE.setFont(Font.font(18));
        		 sonGoodsType.getChildren().add(goodTYPE);
        	 }
         }
}

@FXML protected void initAddClassificationUi(){
	//�����µ���������
AddSonClassificationUiStarter starter=new AddSonClassificationUiStarter();
starter.initAddClassifictaionUi(currentStage, classification.getNumber(),classification.getName());

	}

@FXML protected void deleteClassification(){
	//ɾ���ɵ�������
	//ֻ��ɾ��û����Ʒ��Ҷ�ڵ㣬��������������׼��������ɾ��
ArrayList<String> sonClassifications=classification.getSonClassifacation();
ArrayList<String> goodsList=classification.getGoodsList();
if(sonClassifications==null||((sonClassifications!=null)&&(sonClassifications.size()==0))){
	if(goodsList==null||((goodsList!=null)&&(goodsList.size()==0))){
		Alert obsoleteClassificationConfirm=new Alert(Alert.AlertType.CONFIRMATION,"��ȷ��Ҫ����ɾ��������");
  	    Optional<ButtonType> choice=obsoleteClassificationConfirm.showAndWait();
  	    if(choice.isPresent()&&(choice.get()==ButtonType.OK)){
  	    	//�û�ѡ��ȷ��ɾ�������
  	    	try{
  	    		GoodsClassificationBlService classificationSer=CommodityRemoteHelper.getInstance().getGoodsClassificationBlService();
  	    		classificationSer.deleteClassification(classification);
  	    	}catch(RemoteException e){
  	    		e.printStackTrace();
  	    	}

  	    	Alert obsoleteClassificationSuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ�ɾ�������");
  	  	    obsoleteClassificationSuccess.showAndWait();

  	  	    backToGoodsClassificationUi();
         //�ɹ�ɾ�������󣬻ص�classificationScene0������Ui
  	  	 }else{

  	    }
	}else{
		Alert goodsExistErr=new Alert(Alert.AlertType.ERROR,"������´�����Ʒ����ɾ��ȫ����Ʒ���޸���Ʒ���֮����ɾ�������");
		goodsExistErr.showAndWait();
	}
}else{
	Alert sonClassExistErr=new Alert(Alert.AlertType.ERROR,"������´����������ɾ��ȫ���������޸���������������֮����ɾ�������");
	sonClassExistErr.showAndWait();
}
	}

@FXML protected void initModifyClassificationUi(){
	//�޸������棬ֻ���޸����������븸���
   ModifyClassificationUiStarter starter=new ModifyClassificationUiStarter();
   starter.initModifyClassifictaionUi(currentStage, classification);
	}


@FXML protected void confirmClassification(){
	//ȷ�ϸ������Ϣ
	backToGoodsClassificationUi();
	//û���κβ�����ֱ�ӻص�classificationScene0
}
private void backToGoodsClassificationUi(){
	GoodsClassificationUiStarter starter=new GoodsClassificationUiStarter();
	starter.initGoodsClassificationUi(currentStage);
}
}
