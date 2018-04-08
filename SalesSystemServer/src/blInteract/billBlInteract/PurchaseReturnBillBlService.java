package blInteract.billBlInteract;

import java.util.ArrayList;

import assistant.type.BillStateEnum;
import po.PurchaseReturnBillPO;
import po.UserInfoPO;

public interface PurchaseReturnBillBlService {
	/**
	 * ����һ���µĽ����˻�����<br/>
	 * @param PurchaseReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean createBill(PurchaseReturnBillPO bill);
	
	/**
	 * ����һ���µĽ����˻����ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param PurchaseReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean saveAsDraftBill(PurchaseReturnBillPO bill) ;
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param PurchaseReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean updateDraftBill(PurchaseReturnBillPO bill);
	
	/**
	 * ͨ��Idɾ��һ���˻�������
	 * @param String billId ��Ҫɾ���Ĳݸ嵥��Id
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	 public boolean deleteDraftBill(String billId);
	 
	 /**
	  * ע�⣺��������ڸõ��ݲݸ壬����ύʧ��
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ�����˻���ȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	public boolean submitBill(String billId);
		
	/**
	 * ����Idͨ��һ�ݽ����˻���������
	 * @param PurchaseReturnBillPO bill ��Ҫ����ͨ���ĵ���
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	public boolean passBill(PurchaseReturnBillPO bill) ;

	/**
	 * @param PurchaseReturnBillPO bill ��Ҫ�ܾ�����ͨ���ĵ���
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	public boolean denyBill(PurchaseReturnBillPO bill);

	/**
	 * @param PurchaseReturnBillPO bill ����ɵĵ���
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	public boolean doneBill(PurchaseReturnBillPO bill) ;

	/**
	 * @param PurchaseReturnBillPO bill ��Ҫ����ɾ�ĵ���
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	public boolean hideBill(PurchaseReturnBillPO bill) ;

	/**
	 * ���ݵ���Id��ȡһ�Ž����˻�����<br/>
	 * @param billId Ҫ��ȡ�Ľ�����Id�˻�
	 * @return BillPo��ȡ�ĵ���
	 */
	public PurchaseReturnBillPO getBillById(String billId);
	
	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ�н����˻�����<br/>
	 * @param billState Ҫ��ȡ�Ľ����˻���״̬
	 * @return ArrayList<PurchaseReturnBillPO>��ȡ�Ľ������б��˻�
	 */
	public ArrayList<PurchaseReturnBillPO> getBillListByState(BillStateEnum billState) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�н����˻����ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PurchaseReturnBillPO>��ȡ�Ľ������ݸ��б��˻�
	 */
	public ArrayList<PurchaseReturnBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ���������˻�����<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PurchaseReturnBillPO>��Ҫ��ȡ��δ�����������б��˻�
	 */
	public ArrayList<PurchaseReturnBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�еĽ����˻�����<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PurchaseReturnBillPO>��ȡ����Ҫִ�еĽ������б��˻�
	 */
	public ArrayList<PurchaseReturnBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ��Ľ����˻�����<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PurchaseReturnBillPO>��ȡ������δͨ���Ľ������б��˻�
	 */
	public ArrayList<PurchaseReturnBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo);


	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵĽ����˻�����<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PurchaseReturnBillPO>��ȡ���Ѿ���ɵĽ������б��˻�
	 */
	public ArrayList<PurchaseReturnBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo);
	
}
