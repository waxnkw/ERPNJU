package blImpl.commodityBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blService.commodityBlService.GoodsInforBlService;
import dataImpl.commodityData.GoodsData;
import po.GoodsPO;
import assistant.convertors.CommodityPOVOConvertor;
import vo.GoodsVO;

public class GoodsInforController implements GoodsInforBlService{

	@Override
	public boolean ifGoodsExist(String goodsName,String goodsType) throws RemoteException{
		GoodsData goodsData=new GoodsData();
		GoodsPO goodsPO=goodsData.find(goodsName,goodsType);
		if(goodsPO==null){
			return false;
		}else{
			return true;
		}
	}
	public boolean ifGoodsExist(String goodsID) throws RemoteException {
		// TODO Auto-generated method stub
		GoodsData goodsData=new GoodsData();
		GoodsPO goodsPO=goodsData.find(goodsID);
		if(goodsPO==null){
			return false;
		}else{
			return true;
		}
	}

	public ArrayList<GoodsVO> fuzzyEnquiry(String keyWord) throws RemoteException{
		//keyword��id���������еĹؼ���
		ArrayList<GoodsVO> relatedGoodsVOs=new ArrayList<GoodsVO>();
		GoodsData goodsData=new GoodsData();
		ArrayList<GoodsPO> relatedGoodsPOs=goodsData.fuzzyFinds(keyWord);
		for(int i=0;i<=relatedGoodsPOs.size()-1;i++){
			GoodsPO theGoodsPO=relatedGoodsPOs.get(i);
			CommodityPOVOConvertor poTOvo=new CommodityPOVOConvertor();
			GoodsVO theGoodsVO=poTOvo.GoodsPOtoVO(theGoodsPO);
			relatedGoodsVOs.add(theGoodsVO);
		}
		return relatedGoodsVOs;
		//���û����ص���Ʒ����ôrelatedGoodsVOs��size�����0��������null
	}

	@Override
	public GoodsVO goodsINfor(String goodsID) throws RemoteException {
		// TODO Auto-generated method stub
		GoodsData goodsData=new GoodsData();
		GoodsPO theGoodsPO=goodsData.find(goodsID);
		CommodityPOVOConvertor poTOvo=new CommodityPOVOConvertor();
		GoodsVO theGoodsVO=poTOvo.GoodsPOtoVO(theGoodsPO);
		return theGoodsVO;
	}



	@Override
	public boolean modifyGoodsInfor(GoodsVO vo) throws RemoteException {
		// TODO Auto-generated method stub
			UpdateClassificationOfGoods updateClassificationOfGoods=new UpdateClassificationOfGoods();
			updateClassificationOfGoods.updateClassificationOfGoods(vo);
			//�����������Ʒ������𣬸���ԭ��������¸�������Ʒ�嵥����������Ʒ
			//���û�и�����Ʒ�������Ҳ����һ�鸸�����Ϊ��Ʒ���������ͺſ��ܷ����仯������ɾ���������һ��

		return true;
	}


}
