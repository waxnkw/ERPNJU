package blImpl.promotionBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.ComboStrategyPOVOConvertor;
import assistant.convertors.TotalStrategyPOVOConvertor;
import assistant.convertors.UserStrategyPOVOConvertor;
import assistant.type.StrategyCategoryEnum;
import dataImpl.promotionData.PromotionData;
import dataService.promotionDataService.PromotionDataService;
import po.ComboStrategyPO;
import po.PromotionStrategyPO;
import po.TotalStrategyPO;
import po.UserStrategyPO;
import vo.ComboStrategyVO;
import vo.TotalStrategyVO;
import vo.UserStrategyVO;
/**
 * @author zhangao 161250193
 * promotionBl��
 * @version 2017.12.3
 */

public class PromotionBl {
	
	private PromotionDataService service = new PromotionData();//���ݲ����
	
	/**
	 * �õ��������е��û����������嵥
	 * @return ArrayList<UserStrategyVO> �û����������嵥
	 */
	public ArrayList<UserStrategyVO> getUserStrategyList() throws RemoteException{
		ArrayList<UserStrategyPO> list = service.getUserStrategyList();
		ArrayList<UserStrategyVO> targetList = new ArrayList<UserStrategyVO>();
		for(UserStrategyPO po:list){
			UserStrategyVO vo = UserStrategyPOVOConvertor.poToVO(po);
			targetList.add(vo);
		}
		return targetList;
	}

	/**
	 * �õ��������е��û����������嵥
	 * @return ArrayList<TotalStrategyVO> �û����������嵥
	 */
	public ArrayList<TotalStrategyVO> getTotalStrategyList()throws RemoteException {
		ArrayList<TotalStrategyPO> list = service.getTotalStrategyList();
		ArrayList<TotalStrategyVO> targetList = new ArrayList<TotalStrategyVO>();
		for(TotalStrategyPO po:list){
			TotalStrategyVO vo = TotalStrategyPOVOConvertor.poToVO(po);
			targetList.add(vo);
		}
		return targetList;
	}

	/**
	 * �õ��������е��û����������嵥
	 * @return ArrayList<ComboStrategyVO> �û����������嵥
	 */
	public ArrayList<ComboStrategyVO> getComoboStrategyList()throws RemoteException {
		ArrayList<ComboStrategyPO> list = service.getComboStrategyList();
		ArrayList<ComboStrategyVO> targetList = new ArrayList<ComboStrategyVO>();
		for(ComboStrategyPO po:list){
			ComboStrategyVO vo = ComboStrategyPOVOConvertor.poToVO(po);
			targetList.add(vo);
		}
		return targetList;
	}

	/**
	 * ɾ����������
	 * @return boolean�Ƿ�ɾ���ɹ�
	 */
	public boolean deleteStrategy(StrategyCategoryEnum strategyType, String strategyId)throws RemoteException {
		return service.deleteStrategy(strategyType.toString(), strategyId);
	}
	
	
	/**
	 * ���´�������
	 * @param strategyType �������Ե�����
	 * @param strategyId ��������Id
	 * @param PromotionStrategyPO newPromotionStrategyPO�µĴ�������
	 * @return boolean �Ƿ������ɹ�
	 */
	 public boolean updateStrategy(StrategyCategoryEnum strategyType
		 , String strategyId
		 ,PromotionStrategyPO newPromotionStrategyPO) throws RemoteException{
		 
		return service.updateStrategy(strategyType.toString(), strategyId, newPromotionStrategyPO);
	 }
	
	/**
	 * �����û���������
	 * @param UserStrategyVO strategy �������û���������
	 * @return boolean �Ƿ������ɹ�
	 */
	public boolean addUserStrategy(UserStrategyVO strategy) throws RemoteException{
		UserStrategyPO po = UserStrategyPOVOConvertor.voToPO(strategy);
		SetPromotionIdBl.getInstance().setId(po);
		return service.addUserStrategy(po);
	}

	/**
	 * �����ܼ۴�������
	 * @param TotalStrategyVO strategy �������ܼ۴�������
	 * @return boolean �Ƿ������ɹ�
	 */
	public boolean addTotalStrategy(TotalStrategyVO strategy) throws RemoteException{
		TotalStrategyPO po = TotalStrategyPOVOConvertor.voToPO(strategy);
		SetPromotionIdBl.getInstance().setId(po);
		return service.addTotalStrategy(po);
	}

	/**
	 * ������ϴ�������
	 * @param ComboStrategyVO strategy ��������ϴ�������
	 * @return boolean �Ƿ������ɹ�
	 */
	public boolean addComoboStrategy(ComboStrategyVO strategy) throws RemoteException {
		ComboStrategyPO po = ComboStrategyPOVOConvertor.voToPO(strategy);
		SetPromotionIdBl.getInstance().setId(po);
		return service.addComboStrategy(po);
	}
	
	
}
