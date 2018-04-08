package blImpl.promotionBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.ComboStrategyPOVOConvertor;
import assistant.exception.Myexception;
import assistant.type.StrategyCategoryEnum;
import blInteract.commodityInteract.CommodityBlInteractServiceFactory;
import blInteract.commodityInteract.GoodsListService;
import blService.promotionBlService.ComboStrategyBlService;
import po.ComboStrategyPO;
import vo.ComboStrategyVO;
import vo.GoodsVO;

public class ComboStrategyBlController implements ComboStrategyBlService{
	
	private PromotionBl bl = new PromotionBl();//����������Ե�ҵ���߼�����
	private static final StrategyCategoryEnum STRATEGY_TYPE = StrategyCategoryEnum.COMBOSTRATEGY;//���ݵ�����
	
	/**
	 * �õ��������е���ϴ��������嵥
	 * @return ArrayList<ComboStrategyVO> ��ϴ��������嵥
	 */
	@Override
	public ArrayList<ComboStrategyVO> getStrategyList() throws RemoteException,Myexception{
		return bl.getComoboStrategyList();
	}
		
	/**
	 * ɾ����������
	 * @return boolean�Ƿ�ɾ���ɹ�
	 */
	@Override
	public boolean deleteStrategy(String strategyId) throws RemoteException,Myexception{
		return bl.deleteStrategy(STRATEGY_TYPE, strategyId);
	}
		

	/**
	 * ������ϴ�������
	 * @param ComboStrategyVO strategy ��������ϴ�������
	 * @return boolean�Ƿ������ɹ�
	 */
	@Override
	public boolean addStrategy(ComboStrategyVO strategy) throws RemoteException,Myexception{
		return bl.addComoboStrategy(strategy);
	} 
		

	/**
	 * ������ϴ�������
	 * @param ComboStrategyVO strategy ��������ϴ�������
	 * @return boolean�Ƿ������ɹ�
	 */
	@Override
	public boolean updateStrategy(ComboStrategyVO newPromotionStrategyVO) 
			throws RemoteException,Myexception{
		ComboStrategyPO po = ComboStrategyPOVOConvertor.voToPO(newPromotionStrategyVO);
		return bl.updateStrategy(STRATEGY_TYPE, po.getId(), po);
	} 

	/**
	 * �õ�������Ʒ����Ϣ
	 * @return GoodsVO ��Ʒ����Ϣ
	 */
	@Override
	public ArrayList<GoodsVO> getGoodsList() throws RemoteException,Myexception{
		 CommodityBlInteractServiceFactory factory = new CommodityBlInteractServiceFactory();
			GoodsListService service = factory.getGoodsListBlService();
			return service.getGoodsList();
	} 
		
}
