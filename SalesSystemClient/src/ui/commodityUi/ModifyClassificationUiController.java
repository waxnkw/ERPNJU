package ui.commodityUi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blService.commodityBlService.GoodsClassificationBlService;
import blStubs.commodityBlStubs.GoodsClassificationService_Stub;
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

public class ModifyClassificationUiController {
	@FXML private TextField modifyClassificationName;
	@FXML private TextField modifyFatherClassification;
	private Stage currentStage;
	private ClassificationVO classification;
	public void setStage(Stage stage){
		currentStage=stage;

	}
	public void setClassification(ClassificationVO vo){
		classification=vo;
	}
	public void iniModifyClassificationUiInfor(){
		      modifyClassificationName.setPromptText(classification.getName());
		  if(classification.getFatherClassification()==null){
			  modifyFatherClassification.setPromptText("��");
		    }else{
		      modifyFatherClassification.setPromptText(classification.getFatherClassification());
		    }
	//����classificationName��fatherClassification��Ĭ��ֵ
		}

	@FXML protected void confirmModifyClassification(){
		String preName=modifyClassificationName.getPromptText();
		String preFather=modifyFatherClassification.getPromptText();
		String newName=modifyClassificationName.getText();
		String newFather=modifyFatherClassification.getText();
		boolean classExist=false;
		boolean fatherExist=true;
		try{
		GoodsClassificationBlService classificationSer=CommodityRemoteHelper.getInstance().getGoodsClassificationBlService();
		String preFatherID=" ";
		String preFatherName=" ";
		if(preFather.equals("��")){
			preFatherName="��";
		}else{
			preFatherID=preFather.split("-")[0];
			preFatherName=preFather.split("-")[1];
		}
		if(newFather.equals("")||newFather.equals(preFatherID)||newFather.equals(preFatherName)){
			//�����û�иı�
			if(newName.equals("")||newName.equals(preName)){
				//�������û�иı�
				Alert notModifyInfor=new Alert(Alert.AlertType.INFORMATION,"û�н����κ��޸ġ�");
				notModifyInfor.showAndWait();
				backToClassificationInforUi();
				//û���κβ�����ֱ�ӻص�classificationScene1
			}else{
				//������Ƹı�
			classExist=classificationSer.ifClassificationExist(newName);
			if(classExist==false){
				classification.setName(newName);
				classificationSer.modifyClassificationInfor(classification);
				Alert modifySuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ��޸�������ƣ�");
				modifySuccess.showAndWait();

				backToClassificationInforUi();
		         //�ɹ��޸����󣬻ص�classificationScene1��������Ϣ
			}else{
				Alert nameExistErr=new Alert(Alert.AlertType.ERROR,"����������Ѵ��ڣ�");
			   	nameExistErr.showAndWait();
			}
			}
		}else{
			//�����ı�
			fatherExist=classificationSer.ifClassificationExist(newFather);
			if(fatherExist){
				ClassificationVO newFatherVO=classificationSer.classificationInfor(newFather);
				ArrayList<String> sonGoodsList=newFatherVO.getGoodsList();
				if(sonGoodsList==null){
					if(newName.equals("")||newName.equals(preName)){
						//�������û�иı�
						classification.setFatherClassification(newFatherVO.getNumber()+"-"+newFatherVO.getName());
						classificationSer.modifyClassificationInfor(classification);
						Alert modifySuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ��޸ĸ����");
						modifySuccess.showAndWait();

						backToClassificationInforUi();
				         //�ɹ��޸����󣬻ص�classificationScene1��������Ϣ
					}else{
						//������Ƹı�
					classExist=classificationSer.ifClassificationExist(newName);
					if(classExist==false){
						classification.setName(newName);
						classification.setFatherClassification(newFatherVO.getNumber()+"-"+newFatherVO.getName());
						classificationSer.modifyClassificationInfor(classification);
						Alert modifySuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ��޸�������ƺ͸����");
						modifySuccess.showAndWait();

						backToClassificationInforUi();
				         //�ɹ��޸����󣬻ص�classificationScene1��������Ϣ
					}else{
						Alert nameExistErr=new Alert(Alert.AlertType.ERROR,"����������Ѵ��ڣ�");
					   	nameExistErr.showAndWait();
					}
					}
				}else{
					//�����������Ʒ�������������й�Ҳ�㣬�Ͳ�����������
					Alert goodsExistError=new Alert(Alert.AlertType.ERROR,"�ø�����´�����Ʒ��������������");
					goodsExistError.showAndWait();
				}
			}else{
				Alert fatherNotExistErr=new Alert(Alert.AlertType.ERROR,"�ø���𲻴��ڣ�");
			   	fatherNotExistErr.showAndWait();
			}
		}
				}catch(RemoteException exception){
					exception.printStackTrace();
				}
	}

	@FXML protected void cancelModifyClassification(){
		backToClassificationInforUi();
		//û���κβ�����ֱ�ӻص�classificationScene1
	}

	private void backToClassificationInforUi(){
		ClassificationInforUiStarter starter=new ClassificationInforUiStarter();
		starter.initGoodsClassificationInfotUi(currentStage, classification.getNumber());
	}



}
