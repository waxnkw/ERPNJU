package blService.promotionBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.exception.Myexception;
import vo.GoodsVO;
import vo.UserStrategyVO;

public interface UserStrategyBlService extends Remote{
	/**
	 * �õ��������е��û����������嵥
	 * @return ArrayList<UserStrategyVO> �û����������嵥
	 */
	public ArrayList<UserStrategyVO> getStrategyList() throws RemoteException,Myexception; 
		
	/**
	 * ɾ����������
	 * @return boolean�Ƿ�ɾ���ɹ�
	 */
	public boolean deleteStrategy(String strategyId) throws RemoteException,Myexception; 
		

	/**
	 * �����û���������
	 * @param UserStrategyVO strategy �������û���������
	 * @return boolean�Ƿ������ɹ�
	 */
	public boolean addStrategy(UserStrategyVO strategy) throws RemoteException,Myexception; 
		

	/**
	 * �����û���������
	 * @param UserStrategyVO strategy �������û���������
	 * @return boolean�Ƿ������ɹ�
	 */
	public boolean updateStrategy(UserStrategyVO newPromotionStrategyVO) throws RemoteException,Myexception; 
		
	/**
	 * �õ���Ʒ����Ϣ
	 * @param String goodsTag ��Ʒ�ı�ǩ
	 * @return GoodsVO ��Ʒ����Ϣ
	 */
	public ArrayList<GoodsVO> getGoodsList() throws RemoteException,Myexception; 
		

}
