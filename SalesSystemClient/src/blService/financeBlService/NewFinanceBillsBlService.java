package blService.financeBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.CashExpenseBillVO;
import vo.PaymentBillVO;
import vo.ReceiptBillVO;

/**
 * �½������൥�ݵ��߼��ӿ�
 * @author guxinyu
 * @version 2017.12.2
 *
 */
public interface NewFinanceBillsBlService extends Remote{
	/**
	 * �½��ֽ���õ����˽ӿڿɽ��ֽ���õ����沢�ύ���ܾ�������
	 * @param toSave��Ҫ��������ֽ���õ���VO
	 * @return ���صĲ���ֵ�����Ƿ񱣴�ɹ�
	 * @throws RemoteException
	 */
	public boolean newCashExpenseBill(CashExpenseBillVO toSave) throws RemoteException;
	
	/**
	 * �½��ֽ���õ����˽ӿڿɽ��ֽ���õ�����ݸ�
	 * @param toSave
	 * @return ���صĲ���ֵ�����Ƿ񱣴�ɹ�
	 * @throws RemoteException
	 */
	public boolean saveCashExpenseBillDraft(CashExpenseBillVO toSave) throws RemoteException;
	
	/**
	 * ����ֽ���õ��Ĳݸ�
	 * @return ���زݸ�״̬���ֽ���õ�����
	 * @throws RemoteException
	 */
	public ArrayList<CashExpenseBillVO> getCashExpenseBillDraftList() throws RemoteException;
	
	/**
	 * ɾ���ֽ���õ��ݸ�
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteCashExpenseBillDraft(CashExpenseBillVO toDelete) throws RemoteException;
	
	/**
	 * �½�������˽ӿڿɽ�������沢�ύ���ܾ�������
	 * @param toSave��Ҫ������ĸ������VO
	 * @return ���صĲ���ֵ�����Ƿ񱣴�ɹ�
	 * @throws RemoteException
	 */
	public boolean newPaymentBill(PaymentBillVO toSave) throws RemoteException;
	
	/**
	 *  �½�������˽ӿڿɽ��������ݸ�
	 * @param toSave
	 * @return ���صĲ���ֵ�����Ƿ񱣴�ɹ�
	 * @throws RemoteException
	 */
	public boolean savePaymentBillDraft(PaymentBillVO toSave) throws RemoteException;
	
	/**
	 * ��ø���Ĳݸ�
	 * @return ���زݸ�״̬�ĸ������
	 * @throws RemoteException
	 */
	public ArrayList<PaymentBillVO> getPaymentBillDraftList() throws RemoteException;
	
	/**
	 * ɾ������ݸ�
	 * @return
	 * @throws RemoteException
	 */
	public boolean deletePaymentBillDraft(PaymentBillVO toDelete) throws RemoteException;
	
	/**
	 * �½�������˽ӿڿɽ��տ���沢�ύ���ܾ�������
	 * @param toSave��Ҫ��������տ��VO
	 * @return ���صĲ���ֵ�����Ƿ񱣴�ɹ�
	 * @throws RemoteException
	 */
	public boolean newReceiptBill(ReceiptBillVO toSave) throws RemoteException;
	
	/**
	 * �½�������˽ӿڿɽ��տ����ݸ�
	 * @param toSave
	 * @return ���صĲ���ֵ�����Ƿ񱣴�ɹ�
	 * @throws RemoteException
	 */
	public boolean saveReceiptBillDraft(ReceiptBillVO toSave) throws RemoteException;
	
	/**
	 * ����տ�Ĳݸ�
	 * @return ���زݸ�״̬���տ����
	 * @throws RemoteException
	 */
	public ArrayList<ReceiptBillVO> getReceiptBillDraftList() throws RemoteException;
	
	/**
	 * ɾ���տ�ݸ�
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteReceiptBillDraft(ReceiptBillVO toDelete) throws RemoteException;
}
