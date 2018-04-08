package blStubs.promotionBlStubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.CustomerLevelEnum;
import assistant.type.StrategyCategoryEnum;
import assistant.utility.Date;
import blService.promotionBlService.TotalStrategyBlService;
import vo.GiftVO;
import vo.GoodsVO;
import vo.TotalStrategyVO;

public class TotalStrategyBlService_Stub implements TotalStrategyBlService{

	@Override
	public ArrayList<TotalStrategyVO> getStrategyList() throws RemoteException {
		ArrayList<TotalStrategyVO> vos = new ArrayList<>();
		TotalStrategyVO vo = new TotalStrategyVO();
		vo.setCoupon(10000);
		vo.setDiscount(0.56);
		vo.setStartDate(new Date(2017,12,2,0,0));
		vo.setEndDate(new Date(2017,12,25,0,0));
		vo.setId("12345");
		vo.setName("总价促销策略");
		vo.setStrategyCategoryEnum(StrategyCategoryEnum.USRESTRATEGY);
		
		GiftVO giftVO = new GiftVO();
		giftVO.setName("a灯");
		giftVO.setId("00001");
		giftVO.setPrice(1000);
		giftVO.setGiftAmount(20);
		ArrayList<GiftVO> giftVOs= new ArrayList<>();
		giftVOs.add(giftVO);
		vo.setGifts(giftVOs);
		
		vos.add(vo);
		return vos;
	}

	@Override
	public boolean deleteStrategy(String strategyId) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStrategy(TotalStrategyVO strategy) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStrategy(TotalStrategyVO newPromotionStrategyVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<GoodsVO> getGoodsList() throws RemoteException {
		ArrayList<GoodsVO> vos =new ArrayList<>();
		GoodsVO g1 = new GoodsVO();
		g1.setAmount(10000);
		g1.setClassification("1类灯");
		g1.setCostPrice("1000");
		g1.setName("a灯");
		g1.setNumber("00001");
		g1.setSellingPrice("10000");
		g1.setType("好灯1");
		vos.add(g1);
		GoodsVO g2 = new GoodsVO();
		g2.setAmount(20000);
		g2.setClassification("2类灯");
		g2.setCostPrice("2000");
		g2.setName("b灯");
		g2.setNumber("00002");
		g2.setSellingPrice("20000");
		g2.setType("好灯2");
		vos.add(g2);
		return vos;
	}

}
