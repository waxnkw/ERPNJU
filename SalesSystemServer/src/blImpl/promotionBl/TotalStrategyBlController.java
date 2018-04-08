package blImpl.promotionBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.TotalStrategyPOVOConvertor;
import assistant.exception.Myexception;
import assistant.type.StrategyCategoryEnum;
import blInteract.commodityInteract.CommodityBlInteractServiceFactory;
import blInteract.commodityInteract.GoodsListService;
import blService.promotionBlService.TotalStrategyBlService;
import po.TotalStrategyPO;
import vo.GoodsVO;
import vo.TotalStrategyVO;

public class TotalStrategyBlController implements TotalStrategyBlService{
	private PromotionBl bl = new PromotionBl();//����������Ե�ҵ���߼�����
	private static final StrategyCategoryEnum STRATEGY_TYPE = StrategyCategoryEnum.TOTALSTRATEGY;//���ݵ�����
	
	
	/**
	 * �õ��������е��ܼ۴��������嵥
	 * @return ArrayList<TotalStrategyVO> �ܼ۴��������嵥
	 */
	@Override
	public ArrayList<TotalStrategyVO> getStrategyList() throws RemoteException,Myexception {
		return bl.getTotalStrategyList();
	}
	

	/**
	 * ɾ����������
	 * @return boolean�Ƿ�ɾ���ɹ�
	 */
	@Override
	public boolean deleteStrategy(String strategyId) throws RemoteException,Myexception {
		return bl.deleteStrategy(STRATEGY_TYPE, strategyId);
	}

	/**
	 * �����ܼ۴�������
	 * @param TotalStrategyVO strategy �������ܼ۴�������
	 * @return boolean�Ƿ������ɹ�
	 */
	@Override
	public boolean addStrategy(TotalStrategyVO strategy) throws RemoteException,Myexception {
		return bl.addTotalStrategy(strategy);
	}

	/**
	 * �����ܼ۴�������
	 * @param TotalStrategyVO strategy �������ܼ۴�������
	 * @return boolean�Ƿ������ɹ�
	 */
	@Override
	public boolean updateStrategy(TotalStrategyVO newPromotionStrategyVO) throws RemoteException,Myexception {
		TotalStrategyPO po = TotalStrategyPOVOConvertor.voToPO(newPromotionStrategyVO);
		return bl.updateStrategy(STRATEGY_TYPE, po.getId(), po);
	}

	/**
	 * �õ�������Ʒ����Ϣ
	 * @return GoodsVO ��Ʒ����Ϣ
	 */
	@Override
	public ArrayList<GoodsVO> getGoodsList() throws RemoteException,Myexception {
		 CommodityBlInteractServiceFactory factory = new CommodityBlInteractServiceFactory();
		GoodsListService service = factory.getGoodsListBlService();
		return service.getGoodsList();
	}

	
}
