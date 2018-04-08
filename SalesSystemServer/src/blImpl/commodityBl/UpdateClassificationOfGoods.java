package blImpl.commodityBl;

import java.util.ArrayList;

import dataImpl.commodityData.GoodsClassificationData;
import dataImpl.commodityData.GoodsData;
import po.ClassificationPO;
import po.GoodsPO;
import assistant.convertors.CommodityPOVOConvertor;
import vo.GoodsVO;

public class UpdateClassificationOfGoods {

	public boolean updateOldClassification(GoodsVO goods){
		//�������Ʒ�����������Ʒ�б�ɾ��

		//ע��������޸���Ʒ���
		//ע���������һ��Ҫ�ڸ��ĸ���Ʒ�ĸ����updateGoodsClassification(GoodsVO goods)��֮ǰ����
		//ע����Ϊ��ʱ�����goodsvo�Ѿ��ǵĸ�����Ѿ�������𣬵������ļ��л�û����
		//ע���ʸ�������id�ҵ����������ļ��б���po���ҵ�����ԭ���ĸ���
		//ע���������ĸ�����Ѿ�������

		//ע�������������ɾ����Ʒ
		//ע������ֱ��ʹ���������������

		String goodsID=goods.getNumber();
		GoodsData goodsData=new GoodsData();
		GoodsPO preGoods=goodsData.find(goodsID);
		String preClassification=preGoods.getClassification();
		GoodsClassificationData classificationData=new GoodsClassificationData();
		ClassificationPO preClassificationObj=classificationData.find(preClassification);
		ArrayList<String> goodsList=preClassificationObj.getGoodsList();
		if(goodsList==null){

		}else{
			for(int i=0;i<=goodsList.size()-1;i++){
				String currentGoods=goodsList.get(i);
				String[] currentGoodsInfor=currentGoods.split("-");
				String currentGoodsID=currentGoodsInfor[0];
				if(currentGoodsID.equals(goodsID)){
					goodsList.remove(i);
					break;
				}
			}
		}
		preClassificationObj.setGoodsList(goodsList);
		classificationData.update(preClassificationObj);
		return true;
	}

	public boolean updateNewClassification(GoodsVO goods){
		//�������Ʒ�����������Ʒ�б���

		//ע��������޸���Ʒ���
		//ע���������һ��Ҫ�ڸ��ĸ���Ʒ�ĸ����updateGoodsClassification(GoodsVO goods)��֮�����
		//ע����Ϊ�Ƕ������Ʒ���µĸ������в�����

		//ע���������������������Ʒ
		//ע������ֱ��ʹ���������������
		String newClassification=goods.getClassification();
		GoodsClassificationData classificationData=new GoodsClassificationData();
		ClassificationPO newClassificationObj=classificationData.find(newClassification);
		ArrayList<String> goodsList=newClassificationObj.getGoodsList();

		String goodsID=goods.getNumber();
		String goodsName=goods.getName();
		String goodsType=goods.getType();
		String goodsInfor=goodsID+"-"+goodsName+"-"+goodsType;

		if(goodsList==null){
			ArrayList<String> iniGoodsList=new ArrayList<String>();
			iniGoodsList.add(goodsInfor);
			newClassificationObj.setGoodsList(iniGoodsList);
		}else{
			goodsList.add(goodsInfor);
			newClassificationObj.setGoodsList(goodsList);
		}
		classificationData.update(newClassificationObj);
		return true;
	}

	public boolean updateGoodsClassification(GoodsVO goods){
		//���¸���Ʒ
		CommodityPOVOConvertor turn=new CommodityPOVOConvertor();
		GoodsPO goodsPO=turn.GoodsVOtoPO(goods);
		GoodsData goodsData=new GoodsData();
		goodsData.update(goodsPO);
		return true;
	}

	public boolean updateClassificationOfGoods(GoodsVO goods){
		//to use the other three functions
		//�����޸���Ʒ���
		//��updateOldClassification(GoodsVO goods)�ھɵĸ������ɾ������Ʒ
		//Ȼ��updateGoodsClassification(GoodsVO goods)���¸���Ʒ�ĸ����
		//���updateNewClassification(GoodsVO goods)���µĸ�����м������Ʒ
		updateOldClassification(goods);
		updateGoodsClassification(goods);
		updateNewClassification(goods);

		return true;
	}
}
