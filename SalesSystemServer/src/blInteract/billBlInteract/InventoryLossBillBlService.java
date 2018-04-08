package blInteract.billBlInteract;

import java.util.ArrayList;

import assistant.type.BillStateEnum;
import po.InventoryLossBillPO;
import po.UserInfoPO;

public interface InventoryLossBillBlService {
	/**
	 * ����һ���µĿ�汨�𵥡�<br/>
	 * @param InventoryLossBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean createBill(InventoryLossBillPO bill);
	
	/**
	 * ����һ���µĿ�汨�𵥲ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param InventoryLossBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean saveAsDraftBill(InventoryLossBillPO bill) ;
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param InventoryLossBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean updateDraftBill(InventoryLossBillPO bill);
	
	/**
	 * ͨ��Idɾ��һ�ſ�汨��
	 * @param String billId ��Ҫɾ���Ĳݸ嵥��Id
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	 public boolean deleteDraftBill(String billId);
	 
	 /**
	  * ע�⣺��������ڸõ��ݲݸ壬����ύʧ��
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ��汨��ȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	public boolean submitBill(String billId);
		
	/**
	 * ����Idͨ��һ�ݿ�汨�𵥵�����
	 * @param InventoryLossBillPO bill ��Ҫ����ͨ���ĵ���
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	public boolean passBill(InventoryLossBillPO bill) ;

	/**
	 * @param InventoryLossBillPO bill ��Ҫ�ܾ�����ͨ���ĵ���
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	public boolean denyBill(InventoryLossBillPO bill);

	/**
	 * @param InventoryLossBillPO bill ����ɵĵ���
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	public boolean doneBill(InventoryLossBillPO bill) ;

	/**
	 * @param InventoryLossBillPO bill ��Ҫ����ɾ�ĵ���
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	public boolean hideBill(InventoryLossBillPO bill) ;

	/**
	 * ���ݵ���Id��ȡһ�ſ�汨�𵥡�<br/>
	 * @param billId Ҫ��ȡ�Ŀ�汨��Id
	 * @return BillPo��ȡ�ĵ���
	 */
	public InventoryLossBillPO getBillById(String billId);
	
	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ�п�汨�𵥡�<br/>
	 * @param billState Ҫ��ȡ�Ŀ�汨��״̬
	 * @return ArrayList<InventoryLossBillPO>��ȡ�Ŀ�汨���б�
	 */
	public ArrayList<InventoryLossBillPO> getBillListByState(BillStateEnum billState) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�п�汨�𵥲ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryLossBillPO>��ȡ�Ŀ�汨�𵥲ݸ��б�
	 */
	public ArrayList<InventoryLossBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ������汨�𵥡�<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryLossBillPO>��Ҫ��ȡ��δ������汨���б�
	 */
	public ArrayList<InventoryLossBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�еĿ�汨�𵥡�<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryLossBillPO>��ȡ����Ҫִ�еĿ�汨���б�
	 */
	public ArrayList<InventoryLossBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ��Ŀ�汨�𵥡�<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryLossBillPO>��ȡ������δͨ���Ŀ�汨���б�
	 */
	public ArrayList<InventoryLossBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo);


	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵĿ�汨�𵥡�<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryLossBillPO>��ȡ���Ѿ���ɵĿ�汨���б�
	 */
	public ArrayList<InventoryLossBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo);
	
}
