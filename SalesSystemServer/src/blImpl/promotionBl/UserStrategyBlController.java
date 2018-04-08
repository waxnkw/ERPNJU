package blImpl.promotionBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.UserStrategyPOVOConvertor;
import assistant.exception.Myexception;
import assistant.type.StrategyCategoryEnum;
import blInteract.commodityInteract.CommodityBlInteractServiceFactory;
import blInteract.commodityInteract.GoodsListService;
import blService.promotionBlService.UserStrategyBlService;
import po.UserStrategyPO;
import vo.GoodsVO;
import vo.UserStrategyVO;

public class UserStrategyBlController implements UserStrategyBlService{

	private PromotionBl bl = new PromotionBl();//����������Ե�ҵ���߼�����
	private static final StrategyCategoryEnum STRATEGY_TYPE = StrategyCategoryEnum.USRESTRATEGY;//���ݵ�����
	
	
	/**
	 * �õ��������е��û����������嵥
	 * @return ArrayList<UserStrategyVO> �û����������嵥
	 */
	@Override
	public ArrayList<UserStrategyVO> getStrategyList() throws RemoteException,Myexception {
		return bl.getUserStrategyList();
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
	 * �����û���������
	 * @param UserStrategyVO strategy �������û���������
	 * @return boolean�Ƿ������ɹ�
	 */
	@Override
	public boolean addStrategy(UserStrategyVO strategy) throws RemoteException,Myexception {
		return bl.addUserStrategy(strategy);
	}

	/**
	 * �����û���������
	 * @param UserStrategyVO strategy �������û���������
	 * @return boolean�Ƿ������ɹ�
	 */
	@Override
	public boolean updateStrategy(UserStrategyVO newPromotionStrategyVO) throws RemoteException,Myexception {
		UserStrategyPO po = UserStrategyPOVOConvertor.voToPO(newPromotionStrategyVO);
		return bl.updateStrategy(STRATEGY_TYPE, po.getId(), po);
	}

	/**
	 * �õ���Ʒ����Ϣ
	 * @param String goodsTag ��Ʒ�ı�ǩ
	 * @return GoodsVO ��Ʒ����Ϣ
	 */
	@Override
	public ArrayList<GoodsVO> getGoodsList() throws RemoteException,Myexception {
		CommodityBlInteractServiceFactory factory = new CommodityBlInteractServiceFactory();
		GoodsListService service = factory.getGoodsListBlService();
		return service.getGoodsList();
	}	

}
