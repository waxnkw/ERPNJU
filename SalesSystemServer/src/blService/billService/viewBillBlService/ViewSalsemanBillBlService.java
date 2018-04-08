package blService.billService.viewBillBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import vo.*;

/**
 * ������Ա�鿴������Ա�ƶ��ĵ�����Ϣ��ҵ���߼��ӿ�
 * @author ����һ
 * @version 2017.11.7
 *
 */

public interface ViewSalsemanBillBlService extends Remote{

	/**
	 * ��ȡ��Ӧ�̽���������Ϣ
	 * @param ���ݱ�ţ��ַ�����
	 * @return PurchaseBillVO
	 * @throws RemoteException
	 */
	public PurchaseBillVO getPurchaseBill(String billId) throws RemoteException;
	
	/**
	 * ��ȡ��Ӧ�̽����˻�������Ϣ
	 * @param ���ݱ�ţ��ַ�����
	 * @return PurchaseReturnBillVO
	 * @throws RemoteException
	 */
	public PurchaseReturnBillVO getPurchaseReturnBill(String billId) throws RemoteException;
	
	/**
	 * ��ȡ�����̳���������Ϣ
	 * @param ���ݱ�ţ��ַ�����
	 * @return SalesBillVO
	 * @throws RemoteException
	 */
	public SalesBillVO getSalesBill(String billId) throws RemoteException;
	
	/**
	 * ��ȡ�����̳����˻�������Ϣ
	 * @param ���ݱ�ţ��ַ�����
	 * @return SalesReturnBillVO
	 * @throws RemoteException
	 */
	public SalesReturnBillVO getSalesReturnBill(String billId) throws RemoteException;
}
