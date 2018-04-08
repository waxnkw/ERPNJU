package blImpl.commodityBl;

import java.util.ArrayList;

import dataImpl.commodityData.GoodsClassificationData;
import po.ClassificationPO;
import po.GoodsPO;

public class ID {
	public String rootClassificationID(){
		//�����ID��C+��λʮ�������������������������
		int numOfRoots=0;
		GoodsClassificationData classificationData=new GoodsClassificationData();
		ArrayList<ClassificationPO> allClassifications=classificationData.finds();
		for(int i=0;i<=allClassifications.size()-1;i++){
			ClassificationPO classification=allClassifications.get(i);
			String father=classification.getFatherClassification();
			if(father==null){
				numOfRoots++;
			}
		}
		numOfRoots++;
		//��������µ����֮�����������
		String newRootClassificationID="C"+String.format("%02d",numOfRoots);
		return newRootClassificationID;
	}
	public String sonClassificationID(String fatherClassification){
		//�����ID��C+�����ID+��λʮ��������������������������������������
		String[] inforOfFather=fatherClassification.split("-");
		String fatherID=inforOfFather[0];
		GoodsClassificationData classificationData=new GoodsClassificationData();
		ClassificationPO fatherObj=classificationData.find(fatherID);
		ArrayList<String> sonClassificationList=fatherObj.getSonClassifacation();
		int numOfClassifications=0;
		if(sonClassificationList==null){

		}else{
			numOfClassifications=sonClassificationList.size();
		}
		numOfClassifications++;
		//��������µ����֮������������
		String newSonClassificationID="C"+fatherID.substring(1, fatherID.length())+String.format("%02d",numOfClassifications);
		//fatherID.substring(1, fatherID.length()):ȥ��fatherID�е�C��ֻ��������
		return newSonClassificationID;
	}
	public String newGoodsID(String classification){
		//����ƷID��G+�������ID+��λʮ���������������������Ʒ������������
		//������ͬ�������ͺŲ�ͬҲ�ǲ�ͬ����Ʒ
		GoodsClassificationData classificationData=new GoodsClassificationData();
		ClassificationPO classificationObj=classificationData.find(classification);
		String classificationID=classificationObj.getNumber();
		ArrayList<String> goodsList=classificationObj.getGoodsList();
		int numOfGoods=0;
		if(goodsList==null){

		}else{
			numOfGoods=goodsList.size();
		}
		numOfGoods++;
		//��������µ���Ʒ֮������Ʒ������
		String newGoodsID="G"+classificationID.substring(1, classificationID.length())+String.format("%02d", numOfGoods);
		//classificationID.substring(1, classificationID.length()):ȥ��classificationID�е�C,ֻ��������
		return newGoodsID;
	}
}
