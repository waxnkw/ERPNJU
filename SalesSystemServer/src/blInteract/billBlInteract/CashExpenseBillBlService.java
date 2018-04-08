package blInteract.billBlInteract;

import java.util.ArrayList;

import assistant.type.BillStateEnum;
import po.CashExpenseBillPO;
import po.UserInfoPO;

public interface CashExpenseBillBlService {
	/**
	 * ����һ���µ��ֽ���õ���<br/>
	 * @param CashExpenseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean createBill(CashExpenseBillPO bill) ;
	
	/**
	 * ����һ���µ��ֽ���õ��ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param CashExpenseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean saveAsDraftBill(CashExpenseBillPO bill) ;
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param CashExpenseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean updateDraftBill(CashExpenseBillPO bill);
	
	/**
	 * ͨ��Idɾ��һ���ֽ���õ�
	 * @param String billId ��Ҫɾ���Ĳݸ嵥��Id
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	 public boolean deleteDraftBill(String billId);
	 /**
	  * ע�⣺��������ڸõ��ݲݸ壬����ύʧ��
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ��ֽ���õ�ȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	public boolean submitBill(String billId);
	
		
	/**
	 	/**
	 * ����ͨ��һ���ֽ���õ�������
	 * @param CashExpenseBillPO bill ��Ҫ����ͨ���ĵ���
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	public boolean passBill(CashExpenseBillPO bill);
	/**
	 * @param CashExpenseBillPO bill ��Ҫ�ܾ�����ͨ���ĵ���
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	public boolean denyBill(CashExpenseBillPO bill) ;

	/**
	 * @param CashExpenseBillPO bill ����ɵĵ���
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	public boolean doneBill(CashExpenseBillPO bill) ;
	/**
	 * @param CashExpenseBillPO bill ��Ҫ����ɾ�ĵ���
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	public boolean hideBill(CashExpenseBillPO bill) ;
	
	/**
	 * ���ݵ���Id��ȡһ���ֽ���õ���<br/>
	 * @param billId Ҫ��ȡ���ֽ���õ�Id
	 * @return BillPo��ȡ�ĵ���
	 */
	public CashExpenseBillPO getBillById(String billId);
	
	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ���ֽ���õ���<br/>
	 * @param billState Ҫ��ȡ���ֽ���õ�״̬
	 * @return ArrayList<CashExpenseBillPO>��ȡ���ֽ���õ��б�
	 */
	public ArrayList<CashExpenseBillPO> getBillListByState(BillStateEnum billState) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ���ֽ���õ��ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<CashExpenseBillPO>��ȡ���ֽ���õ��ݸ��б�
	 */
	public ArrayList<CashExpenseBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ�����ֽ���õ���<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<CashExpenseBillPO>��Ҫ��ȡ��δ�����ֽ���õ��б�
	 */
	public ArrayList<CashExpenseBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�е��ֽ���õ���<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<CashExpenseBillPO>��ȡ����Ҫִ�е��ֽ���õ��б�
	 */
	public ArrayList<CashExpenseBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ����ֽ���õ���<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<CashExpenseBillPO>��ȡ������δͨ�����ֽ���õ��б�
	 */
	public ArrayList<CashExpenseBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo);

	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵ��ֽ���õ���<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<CashExpenseBillPO>��ȡ���Ѿ���ɵ��ֽ���õ��б�
	 */
	public ArrayList<CashExpenseBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo);
	
}
