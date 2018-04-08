package blService.billService.billStateBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.BillStateEnum;
import vo.CashExpenseBillVO;
import vo.PaymentBillVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.ReceiptBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;

/**
 * ���������Ա����״̬�߼��ӿ�
 * @author guxinyu
 * @version 2017.12.9
 *
 */
public interface FinancialStaffBillStateBlService extends Remote{

	/**
	 *��ȡ������Ա���ƶ��ĵ����б�<br>
	 *�տ��������ֽ���õ�����Ϣ���Խ������������˻��������۵������۽�����<br>
	 *��������ȡ����ɵĽ�����<br>
	 * @return ������������ɵĽ�����<br>
	 * @throws RemoteException
	 * 
	 */
	public ArrayList<PurchaseBillVO> getPurchaseBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ��������ȡ����ɵĽ����˻���<br>
	 * @return ������������ɵĽ����˻���<br>
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ��������ȡ����ɵ����۵�<br>
	 * @return ������������ɵ����۵�<br>
	 * @throws RemoteException
	 */
	public ArrayList<SalesBillVO> getSalesBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ��������ȡ����ɵ������˻���<br>
	 * @return ������������ɵ������˻���<br>
	 * @throws RemoteException
	 */
	public ArrayList<SalesReturnBillVO> getSalesReturnBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 *��ȡ������Աδͨ����˵��ֽ���õ����б�<br>
	 * @return ����δͨ����˵��ֽ���õ�
	 * @throws RemoteException
	 */
	public ArrayList<CashExpenseBillVO> getCashExpenseBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ��ȡ������Աδͨ����˵ĸ�������б�<br>
	 * @return ����δͨ����˵ĸ��
	 * @throws RemoteException
	 */
	public ArrayList<PaymentBillVO> getPaymentBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ��ȡ������Աδͨ����˵��տ�����б�<br>
	 * @return ����δͨ����˵��տ
	 * @throws RemoteException
	 */
	public ArrayList<ReceiptBillVO> getReceiptBillList(BillStateEnum state) throws RemoteException;
	
	/**
	 * ɾ��δͨ�����ֽ���õ�
	 * @param toDelete Ҫ��ɾ���ĵ���
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deleteUnpassCashExpenseBill(CashExpenseBillVO toDelete) throws RemoteException;
	
	/**
	 * ɾ��δͨ���ĸ��
	 * @param toDelete Ҫ��ɾ���ĵ���
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deleteUnpassPaymentBill(PaymentBillVO toDelete) throws RemoteException;
	
	/**
	 * ɾ��δͨ�����տ
	 * @param toDelete Ҫ��ɾ���ĵ���
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deleteUnpassReceiptBill(ReceiptBillVO toDelete) throws RemoteException;
		
}
