package blService.billService.billStateBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.BillStateEnum;
import vo.GiftBillVO;
import vo.InventoryLossBillVO;
import vo.InventoryOverBillVO;
import vo.InventoryWarningBillVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;

/**
 * �ֿ������Ա����״̬�߼��ӿ�
 * @author guxinyu
 * @version 2017.12.12
 *
 */
public interface WareKeeperBillStateBlService extends Remote{
	/**
	 * ����״̬��ȡ��汨�����б�
	 * @return ��汨�����б�
	 * @throws RemoteException
	 */
	public ArrayList<InventoryWarningBillVO> getInventoryWarningList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ɾ��δͨ����˵Ŀ�汨����
	 * @param bill Ҫɾ����
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deleteUnpassInventoryWarningBill(InventoryWarningBillVO bill) throws RemoteException;
	
	/**
	 * ����״̬��ȡ��汨���б�
	 * @return ��汨���б�
	 * @throws RemoteException
	 */
	public ArrayList<InventoryLossBillVO> getInventoryLossList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ɾ��δͨ����˵Ŀ�汨��
	 * @param bill Ҫɾ����
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deleteUnpassInventoryLossBill(InventoryLossBillVO bill) throws RemoteException;
	
	/**
	 * �����汨��
	 * @param bill ����ĵ���
	 * @return �Ƿ���ĳɹ�
	 * @throws RemoteException
	 */
	public boolean doneInventoryLossBill(InventoryLossBillVO bill) throws RemoteException;
	
	
	/**
	 * ����״̬��ȡ��汨�絥�б�
	 * @return ��汨�絥�б�
	 * @throws RemoteException
	 */
	public ArrayList<InventoryOverBillVO> getInventoryOverList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ɾ��δͨ����˵Ŀ�汨�絥
	 * @param bill Ҫɾ����
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deleteUnpassInventoryOverBill(InventoryOverBillVO bill) throws RemoteException;
	
	/**
	 * �����汨�絥
	 * @param bill ����ĵ���
	 * @return �Ƿ���ĳɹ�
	 * @throws RemoteException
	 */
	public boolean doneInventoryOverBill(InventoryOverBillVO bill) throws RemoteException;
	
	
	/**
	 *��������ȡ������<br>
	 * @return ������������ɵĽ�����<br>
	 * @throws RemoteException
	 * 
	 */
	public ArrayList<PurchaseBillVO> getPurchaseBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ���������
	 * @param bill ����ĵ���
	 * @return �Ƿ���ĳɹ�
	 * @throws RemoteException
	 */
	public boolean donePurchaseBill(PurchaseBillVO bill) throws RemoteException;
	
	
	/**
	 * ��������ȡ�����˻���<br>
	 * @return ������������ɵĽ����˻���<br>
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ��������˻���
	 * @param bill ����ĵ���
	 * @return �Ƿ���ĳɹ�
	 * @throws RemoteException
	 */
	public boolean donePurchaseReturnBill(PurchaseReturnBillVO bill) throws RemoteException;
	
	/**
	 * ��������ȡ���۵�<br>
	 * @return ������������ɵ����۵�<br>
	 * @throws RemoteException
	 */
	public ArrayList<SalesBillVO> getSalesBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * �������۵�
	 * @param bill ����ĵ���
	 * @return �Ƿ���ĳɹ�
	 * @throws RemoteException
	 */
	public boolean doneSalesBill(SalesBillVO bill) throws RemoteException;
	
	
	/**
	 * ��������ȡ�����˻���<br>
	 * @return ������������ɵ������˻���<br>
	 * @throws RemoteException
	 */
	public ArrayList<SalesReturnBillVO> getSalesReturnBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ���������˻���
	 * @param bill ����ĵ���
	 * @return �Ƿ���ĳɹ�
	 * @throws RemoteException
	 */
	public boolean doneSalesReturnBill(SalesReturnBillVO bill) throws RemoteException;
	
	/**
	 * ��������ȡ������͵�<br>
	 * @return ������������ɵĿ�����͵�<br>
	 * @throws RemoteException
	 */
	public ArrayList<GiftBillVO> getGiftBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ���������͵�
	 * @param bill ����ĵ���
	 * @return �Ƿ���ĳɹ�
	 * @throws RemoteException
	 */
	public boolean doneGiftBill(GiftBillVO bill) throws RemoteException;
	
}
