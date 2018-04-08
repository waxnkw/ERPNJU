package blInteract.billBlInteract;

import java.util.ArrayList;

import assistant.type.BillStateEnum;
import po.PaymentBillPO;
import po.UserInfoPO;

public interface PaymentBillBlService {
	/**
	 * ����һ���µĸ����<br/>
	 * @param PaymentBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean createBill(PaymentBillPO bill);
	
	/**
	 * ����һ���µĸ���ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param PaymentBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean saveAsDraftBill(PaymentBillPO bill) ;
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param PaymentBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean updateDraftBill(PaymentBillPO bill);
	
	/**
	 * ͨ��Idɾ��һ�Ÿ��
	 * @param String billId ��Ҫɾ���Ĳݸ嵥��Id
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	 public boolean deleteDraftBill(String billId);
	 
	 /**
	  * ע�⣺��������ڸõ��ݲݸ壬����ύʧ��
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ帶�ȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	public boolean submitBill(String billId);
		
	/** ����Idͨ��һ�ݸ��������
	 * @param PaymentBillPO bill ��Ҫ����ͨ���ĵ���
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	public boolean passBill(PaymentBillPO bill) ;

	/**
	 * @param PaymentBillPO bill ��Ҫ�ܾ�����ͨ���ĵ���
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	public boolean denyBill(PaymentBillPO bill);

	/**
	 * @param PaymentBillPO bill ����ɵĵ���
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	public boolean doneBill(PaymentBillPO bill) ;

	/**
	 * @param PaymentBillPO bill ��Ҫ����ɾ�ĵ���
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	public boolean hideBill(PaymentBillPO bill) ;

	/**
	 * ���ݵ���Id��ȡһ�Ÿ����<br/>
	 * @param billId Ҫ��ȡ�ĸ��Id
	 * @return BillPo��ȡ�ĵ���
	 */
	public PaymentBillPO getBillById(String billId);
	
	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ�и����<br/>
	 * @param billState Ҫ��ȡ�ĸ��״̬
	 * @return ArrayList<PaymentBillPO>��ȡ�ĸ���б�
	 */
	public ArrayList<PaymentBillPO> getBillListByState(BillStateEnum billState) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�и���ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PaymentBillPO>��ȡ�ĸ���ݸ��б�
	 */
	public ArrayList<PaymentBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ���������<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PaymentBillPO>��Ҫ��ȡ��δ��������б�
	 */
	public ArrayList<PaymentBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo) ;
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�еĸ����<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PaymentBillPO>��ȡ����Ҫִ�еĸ���б�
	 */
	public ArrayList<PaymentBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo);
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ��ĸ����<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PaymentBillPO>��ȡ������δͨ���ĸ���б�
	 */
	public ArrayList<PaymentBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo);


	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵĸ����<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PaymentBillPO>��ȡ���Ѿ���ɵĸ���б�
	 */
	public ArrayList<PaymentBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo);
	
}
