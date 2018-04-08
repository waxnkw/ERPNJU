package blInteract.billBlInteract;

import java.util.ArrayList;

import assistant.type.BillStateEnum;
import po.SalesReturnBillPO;
import po.UserInfoPO;

public interface SalesReturnBillBlService {
	/**
	 * ����һ���µ����۵���<br/>
	 * @param SalesReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean createBill(SalesReturnBillPO bill);
	
	/**
	 * ����һ���µ����۵��ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param SalesReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean saveAsDraftBill(SalesReturnBillPO bill) ;
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param SalesReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean updateDraftBill(SalesReturnBillPO bill);
	
	/**
	 * ͨ��Idɾ��һ���˻������˻���
	 * @param String billId ��Ҫɾ���Ĳݸ嵥��Id
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	 public boolean deleteDraftBill(String billId);
	 
	 /**
	  * ע�⣺��������ڸõ��ݲݸ壬����ύʧ��
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ����۵�ȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	public boolean submitBill(String billId);
		
	/**
	 * ����Idͨ��һ�����۵�������
	 * @param SalesReturnBillPO bill ��Ҫ����ͨ���ĵ���
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	public boolean passBill(SalesReturnBillPO bill) ;

	/**
	 * @param SalesReturnBillPO bill ��Ҫ�ܾ�����ͨ���ĵ���
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	public boolean denyBill(SalesReturnBillPO bill);

	/**
	 * @param SalesReturnBillPO bill ����ɵĵ���
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	public boolean doneBill(SalesReturnBillPO bill) ;

	/**
	 * @param SalesReturnBillPO bill ��Ҫ����ɾ�ĵ���
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	public boolean hideBill(SalesReturnBillPO bill) ;

	/**
	 * ���ݵ���Id��ȡһ�����۵���<br/>
	 * @param billId Ҫ��ȡ�Ľ����˻���Id�˻�
	 * @return BillPo��ȡ�ĵ���
	 */
	public SalesReturnBillPO getBillById(String billId);
	
	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ�����۵���<br/>
	 * @param billState Ҫ��ȡ�����۵�״̬
	 * @return ArrayList<SalesReturnBillPO>��ȡ�Ľ����˻����б��˻�
	 */
	public ArrayList<SalesReturnBillPO> getBillListByState(BillStateEnum billState) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�����۵��ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<SalesReturnBillPO>��ȡ�Ľ����˻����ݸ��б��˻�
	 */
	public ArrayList<SalesReturnBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ�������۵���<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<SalesReturnBillPO>��Ҫ��ȡ��δ���������˻����б��˻�
	 */
	public ArrayList<SalesReturnBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�е����۵���<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<SalesReturnBillPO>��ȡ����Ҫִ�еĽ����˻����б��˻�
	 */
	public ArrayList<SalesReturnBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ������۵���<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<SalesReturnBillPO>��ȡ������δͨ���Ľ����˻����б��˻�
	 */
	public ArrayList<SalesReturnBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo);


	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵ����۵���<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<SalesReturnBillPO>��ȡ���Ѿ���ɵĽ����˻����б��˻�
	 */
	public ArrayList<SalesReturnBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo);
	
}
