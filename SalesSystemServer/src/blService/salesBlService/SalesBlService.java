package blService.salesBlService;

import java.rmi.Remote;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.UserInfoVO;
import vo.PurchaseReturnBillVO;
import vo.GoodsVO;
import vo.PurchaseBillVO;
import vo.SalesReturnBillVO;
import vo.SalesBillVO;

/**
 * ����������Ա�ƶ����ݵ�ҵ���߼��ӿ�
 * @author ����һ
 * @version 2017.11.7
 *
 */

public interface SalesBlService extends Remote {

	/**
	 * �½�һ�Ź�Ӧ�̽�����
	 * @param PurchaseBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 * @throws RemoteException
	 */
	public boolean NewPurchase(PurchaseBillVO vo) throws RemoteException;
	
	/**
	 * �½�һ�Ź�Ӧ�̽������ݸ�
	 * @param PurchaseBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean NewPurchaseDraft(PurchaseBillVO vo) throws RemoteException;
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param PurchaseBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean UpdatePurchaseDraft(PurchaseBillVO vo) throws RemoteException;
	
	/**
	 * ͨ��Idɾ��һ�Ž������ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean DeletePurchaseDraft(String Id) throws RemoteException;
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean SubmitPurchase(String Id) throws RemoteException;
	
	/**
	 * �½�һ�Ź�Ӧ�̽����˻���
	 * @param PurchaseReturnBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 * @throws RemoteException
	 */
	public boolean NewPurReturn(PurchaseReturnBillVO vo) throws RemoteException;
	
	/**
	 * �½�һ�Ź�Ӧ�̽����˻����ݸ�
	 * @param PurchaseReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean NewPurReturnDraft(PurchaseReturnBillVO vo) throws RemoteException;
	
	/**
	 * ����һ�Ź�Ӧ�̽����˻����ݸ�
	 * @param PurchaseReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean UpdatePurReturnDraft(PurchaseReturnBillVO vo) throws RemoteException;
	
	/**
	 * ͨ��Idɾ��һ�Ž����˻����ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean DeletePurReturnDraft(String Id) throws RemoteException;
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean SubmitPurReturn(String Id) throws RemoteException;
	
	/**
	 * �½�һ�������̳�����
	 * @param SalesBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 * @throws RemoteException
	 */
	public boolean NewSales(SalesBillVO vo) throws RemoteException;
	
	/**
	 * ��òݸ�
	 * @param UserInfoVO
	 * @return ArrayList<PurchaseBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseBillVO> getPurchaseDraftBillsList(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��ô���������
	 * @param UserInfo
	 * @return ArrayList<PurchaseBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseBillVO> getPurchaseTBDBillsList(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��þܾ�����
	 * @param UserInfo
	 * @return ArrayList<PurchaseBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseBillVO> getPurchaseDeniedBillsListByCreater(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��òݸ�
	 * @param UserInfoVO
	 * @return ArrayList<PurchaseReturnBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnDraftBillsList(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��ô���������
	 * @param UserInfo
	 * @return ArrayList<PurchaseReturnBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnTBDBillsList(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��þܾ�����
	 * @param UserInfo
	 * @return ArrayList<PurchaseReturnBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnDeniedBillsListByCreater(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��òݸ�
	 * @param UserInfoVO
	 * @return ArrayList<SalesBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<SalesBillVO> getSalesDraftBillsList(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��ô���������
	 * @param UserInfo
	 * @return ArrayList<SalesBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<SalesBillVO> getSalesTBDBillsList(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��þܾ�����
	 * @param UserInfo
	 * @return ArrayList<SalesReturnBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<SalesReturnBillVO> getSalesReturnDeniedBillsListByCreater(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��òݸ�
	 * @param UserInfoVO
	 * @return ArrayList<SalesReturnBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<SalesReturnBillVO> getSalesReturnDraftBillsList(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��ô���������
	 * @param UserInfo
	 * @return ArrayList<SalesReturnBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<SalesReturnBillVO> getSalesReturnTBDBillsList(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * ��þܾ�����
	 * @param UserInfo
	 * @return ArrayList<SalesBillPO>
	 * @throws RemoteException
	 */
	public ArrayList<SalesBillVO> getSalesDeniedBillsListByCreater(UserInfoVO UserInfo) throws RemoteException;
	
	/**
	 * �½�һ�������̳������ݸ�
	 * @param SalesBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean NewSalesDraft(SalesBillVO vo) throws RemoteException;
	
	/**
	 * ����һ�������̳������ݸ�
	 * @param SalesBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean UpdateSalesDraft(SalesBillVO vo) throws RemoteException;
	
	/**
	 * ͨ��Idɾ��һ�ų������ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean DeleteSalesDraft(String Id) throws RemoteException;
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean SubmitSales(String Id) throws RemoteException;
	
	/**
	 * �½�һ�������̳����˻���
	 * @param SalesReturnBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 * @throws RemoteException
	 */
	public boolean NewSalReturn(SalesReturnBillVO vo) throws RemoteException;
	
	/**
	 * �½�һ�������̳����˻����ݸ�
	 * @param SalesReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean NewSalReturnDraft(SalesReturnBillVO vo) throws RemoteException;
	
	/**
	 * ����һ�������̳����˻����ݸ�
	 * @param SalesReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean UpdateSalReturnDraft(SalesReturnBillVO vo) throws RemoteException;
	
	/**
	 * ͨ��Idɾ��һ�ų����˻����ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean DeleteSalReturnDraft(String Id) throws RemoteException;
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	public boolean SubmitSalReturn(String Id) throws RemoteException;
	
	/**
	 * �ƶ�����ʱ�ṩ��Ʒ�б�
	 * @return ArrayList<GoodsVO>��ArrayList��ÿһ��Ϊһ����Ʒ
	 * @throws RemoteException
	 */
	public ArrayList<GoodsVO> CommoditySelect() throws RemoteException;
}
