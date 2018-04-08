package blService.billService.billStateBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.BillStateEnum;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;

/**
 * ����������Ա����״̬�߼��ӿ�
 * @author guxinyu
 * @version 2017.12.20
 *
 */
public interface SalesmanBillStateBlService extends Remote{

	/**
	 *��������ȡ����ɵĽ�����<br>
	 * @return ������������ɵĽ�����<br>
	 * @throws RemoteException
	 * 
	 */
	public ArrayList<PurchaseBillVO> getPurchaseBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ɾ��δͨ����˵Ľ�����
	 * @param bill Ҫɾ���ĵ���
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deletePurchaseBill(PurchaseBillVO bill) throws RemoteException;
	
	/**
	 * ��������ȡ����ɵĽ����˻���<br>
	 * @return ������������ɵĽ����˻���<br>
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ɾ��δͨ����˵Ľ����˻���
	 * @param bill Ҫɾ���ĵ���
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deletePurchaseReturnBill(PurchaseReturnBillVO bill) throws RemoteException;
	
	
	/**
	 * ��������ȡ����ɵ����۵�<br>
	 * @return ������������ɵ����۵�<br>
	 * @throws RemoteException
	 */
	public ArrayList<SalesBillVO> getSalesBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ɾ��δͨ����˵����۵�
	 * @param bill Ҫɾ���ĵ���
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deleteSalesBill(SalesBillVO bill) throws RemoteException;
	
	/**
	 * ��������ȡ����ɵ������˻���<br>
	 * @return ������������ɵ������˻���<br>
	 * @throws RemoteException
	 */
	public ArrayList<SalesReturnBillVO> getSalesReturnBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ɾ��δͨ����˵������˻���
	 * @param bill Ҫɾ���ĵ���
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deleteSalesReturnBill(SalesReturnBillVO bill) throws RemoteException;
	
}
