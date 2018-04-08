package blInteract.billBlInteract;

import java.util.ArrayList;

import assistant.type.BillStateEnum;
import po.InventoryOverBillPO;
import po.UserInfoPO;

public interface InventoryOverBillBlService {
	/**
	 * ����һ���µĿ�汨�絥��<br/>
	 * @param InventoryOverBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean createBill(InventoryOverBillPO bill);
	
	/**
	 * ����һ���µĿ�汨�絥�ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param InventoryOverBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean saveAsDraftBill(InventoryOverBillPO bill) ;
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param InventoryOverBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean updateDraftBill(InventoryOverBillPO bill);
	
	/**
	 * ͨ��Idɾ��һ�ſ�汨�絥
	 * @param String billId ��Ҫɾ���Ĳݸ嵥��Id
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	 public boolean deleteDraftBill(String billId);
	 
	 /**
	  * ע�⣺��������ڸõ��ݲݸ壬����ύʧ��
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ��汨�絥ȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	public boolean submitBill(String billId);
		
	/**
	 * ����Idͨ��һ�ݿ�汨�絥������
	 * @param InventoryOverBillPO bill ��Ҫ����ͨ���ĵ���
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	public boolean passBill(InventoryOverBillPO bill) ;

	/**
	 * @param InventoryOverBillPO bill ��Ҫ�ܾ�����ͨ���ĵ���
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	public boolean denyBill(InventoryOverBillPO bill);

	/**
	 * @param InventoryOverBillPO bill ����ɵĵ���
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	public boolean doneBill(InventoryOverBillPO bill) ;

	/**
	 * @param InventoryOverBillPO bill ��Ҫ����ɾ�ĵ���
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	public boolean hideBill(InventoryOverBillPO bill) ;


	/**
	 * ���ݵ���Id��ȡһ�ſ�汨�絥��<br/>
	 * @param billId Ҫ��ȡ�Ŀ�汨�絥Id
	 * @return BillPo��ȡ�ĵ���
	 */
	public InventoryOverBillPO getBillById(String billId);
	
	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ�п�汨�絥��<br/>
	 * @param billState Ҫ��ȡ�Ŀ�汨�絥״̬
	 * @return ArrayList<InventoryOverBillPO>��ȡ�Ŀ�汨�絥�б�
	 */
	public ArrayList<InventoryOverBillPO> getBillListByState(BillStateEnum billState) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�п�汨�絥�ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryOverBillPO>��ȡ�Ŀ�汨�絥�ݸ��б�
	 */
	public ArrayList<InventoryOverBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ������汨�絥��<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryOverBillPO>��Ҫ��ȡ��δ������汨�絥�б�
	 */
	public ArrayList<InventoryOverBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�еĿ�汨�絥��<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryOverBillPO>��ȡ����Ҫִ�еĿ�汨�絥�б�
	 */
	public ArrayList<InventoryOverBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ��Ŀ�汨�絥��<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryOverBillPO>��ȡ������δͨ���Ŀ�汨�絥�б�
	 */
	public ArrayList<InventoryOverBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo);


	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵĿ�汨�絥��<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryOverBillPO>��ȡ���Ѿ���ɵĿ�汨�絥�б�
	 */
	public ArrayList<InventoryOverBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo);
	
}
