package blService.promotionBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.exception.Myexception;
import vo.GoodsVO;
import vo.TotalStrategyVO;

public interface TotalStrategyBlService extends Remote{
	/**
	 * �õ��������е��ܼ۴��������嵥
	 * @return ArrayList<TotalStrategyVO> �ܼ۴��������嵥
	 */
	public ArrayList<TotalStrategyVO> getStrategyList() throws RemoteException,Myexception; 
		
	/**
	 * ɾ����������
	 * @return boolean�Ƿ�ɾ���ɹ�
	 */
	public boolean deleteStrategy(String strategyId) throws RemoteException,Myexception; 
		

	/**
	 * �����ܼ۴�������
	 * @param TotalStrategyVO strategy �������ܼ۴�������
	 * @return boolean�Ƿ������ɹ�
	 */
	public boolean addStrategy(TotalStrategyVO strategy) throws RemoteException,Myexception; 
		

	/**
	 * �����ܼ۴�������
	 * @param TotalStrategyVO strategy �������ܼ۴�������
	 * @return boolean�Ƿ������ɹ�
	 */
	public boolean updateStrategy(TotalStrategyVO newPromotionStrategyVO) throws RemoteException,Myexception; 
		
	/**
	 * �õ���Ʒ����Ϣ
	 * @param String goodsTag ��Ʒ�ı�ǩ
	 * @return GoodsVO ��Ʒ����Ϣ
	 */
	/**
	 * �õ���Ʒ����Ϣ
	 * @param String goodsTag ��Ʒ�ı�ǩ
	 * @return GoodsVO ��Ʒ����Ϣ
	 */
	public ArrayList<GoodsVO> getGoodsList() throws RemoteException,Myexception; 
		

}
