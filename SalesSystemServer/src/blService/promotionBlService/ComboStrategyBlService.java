package blService.promotionBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.ArrayList;

import assistant.exception.Myexception;
import vo.ComboStrategyVO;
import vo.GoodsVO;

public interface ComboStrategyBlService extends Remote{
	/**
	 * �õ��������е���ϴ��������嵥
	 * @return ArrayList<ComboStrategyVO> ��ϴ��������嵥
	 */
	public ArrayList<ComboStrategyVO> getStrategyList() throws RemoteException,Myexception; 
		
	/**
	 * ɾ����������
	 * @return boolean�Ƿ�ɾ���ɹ�
	 */
	public boolean deleteStrategy(String strategyId) throws RemoteException,Myexception; 
		

	/**
	 * ������ϴ�������
	 * @param ComboStrategyVO strategy ��������ϴ�������
	 * @return boolean�Ƿ������ɹ�
	 */
	public boolean addStrategy(ComboStrategyVO strategy) throws RemoteException,Myexception; 
		

	/**
	 * ������ϴ�������
	 * @param ComboStrategyVO strategy ��������ϴ�������
	 * @return boolean�Ƿ������ɹ�
	 */
	public boolean updateStrategy(ComboStrategyVO newPromotionStrategyVO) throws RemoteException,Myexception; 
		
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
