package blImpl.bill.billBl;

import java.util.ArrayList;
import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.PaymentBillBlService;
import dataImpl.billData.CreateBillData;
import dataImpl.billData.SaveAsDraftBillData;
import dataService.billDataService.CreateBillDataService;
import dataService.billDataService.SaveAsDraftBillDataService;
import po.BillPO;
import po.PaymentBillPO;
import po.UserInfoPO;

/**
 * PaymentBillBl�߼��࣬�ṩ��ɾ�Ĳ飬�ݸ崴������ظ������
 * @author �Ű�  161250193
 * @version 2017.12.1
 */

public class PaymentBillBl implements PaymentBillBlService{
	
	static final BillCategoryEnum BILL_CATEGORY_ENUM = BillCategoryEnum.PAYMENT_BILL
			;//��ǰ���ݵ�����
	static final String BILL_NAME = BILL_CATEGORY_ENUM.toString();//��ǰ���ݵ�����
	
	GetBillBl getBillBl = new GetBillBl();//��ѯ���ݵ��߼������
	
	private CreateBillDataService createBillDataService =  new CreateBillData();//���ݲ����
	private SaveAsDraftBillDataService saveAsDraftBillDataService = new SaveAsDraftBillData();//���ݲ����

	/**
	 * ����һ���µĸ����<br/>
	 * @param PaymentBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean createBill(PaymentBillPO bill) {
		Date nowDate =new Date();
		bill.setCreateDate(nowDate);//���ô�������
		bill.setCategoryEnum(BILL_CATEGORY_ENUM);//���õ������ͣ��Է���һ
		bill.setBillStateEnum(BillStateEnum.TBD);//���õ���״̬Ϊδ����
		SetBillIdBl.getInstance().setBillIdAndUpdateRecord(bill);//����Id������Id��¼
		boolean isSuccessedCreation = createBillDataService.createPaymentBill(bill);
		return isSuccessedCreation;
	}
	
	/**
	 * ����һ���µĸ���ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param PaymentBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean saveAsDraftBill(PaymentBillPO bill) {
		Date nowDate =new Date();
		bill.setCreateDate(nowDate);//���ô�������
		bill.setCategoryEnum(BILL_CATEGORY_ENUM);//���õ������ͣ��Է���һ
		bill.setBillStateEnum(BillStateEnum.DRAFT);//���õ���״̬Ϊ�ݸ�
		SetBillIdBl.getInstance().setDraftBillId(bill);//���òݸ��Id
		return saveAsDraftBillDataService.saveAsDraftPaymentBill(bill);
	}
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param PaymentBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean updateDraftBill(PaymentBillPO bill){
		return saveAsDraftBill(bill);
	}
	
	/**
	 * ͨ��Idɾ��һ�Ÿ��
	 * @param String billId ��Ҫɾ���Ĳݸ嵥��Id
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	 @Override
	 public boolean deleteDraftBill(String billId) {
		 System.out.println(billId);
		return DeleteDraftBillBl.getInstance().deleteDraftBill(BILL_NAME, billId);
	}
	 
	 /**
	  * ע�⣺��������ڸõ��ݲݸ壬����ύʧ��
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ帶�ȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	 @Override
	public boolean submitBill(String billId){
		PaymentBillPO bill = getBillById(billId);
		if(bill==null){return false;}
		deleteDraftBill(billId);//ɾ���òݸ�
		createBill(bill);//�����ø����δ����״̬����
		return true;
	}
		
	/**
	 * ����Idͨ��һ�ݸ��������
	 * @param String billId ��Ҫ����ͨ���ĵ���Id
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	 @Override
	public boolean passBill(PaymentBillPO bill) {
		return ProcessBillBl.getInstance().passBill(bill);
	}

	/**
	 * @param String billId ��Ҫ�ܾ�����ͨ���ĵ���Id
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	 @Override
	public boolean denyBill(PaymentBillPO bill) {
		return ProcessBillBl.getInstance().denyBill(bill);
	}

	/**
	 * @param String billId ����ɵĵ���Id
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	 @Override
	public boolean doneBill(PaymentBillPO bill) {
		return ProcessBillBl.getInstance().doneBill(bill);
	}

	/**
	 * @param String billId ��Ҫ����ɾ�ĵ���Id
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	 @Override
	public boolean hideBill(PaymentBillPO bill) {
		return	ProcessBillBl.getInstance().hideBill(bill);
	}
	
	/**
	 * ���ݵ���Id��ȡһ�Ÿ����<br/>
	 * @param billId Ҫ��ȡ�ĸ��Id
	 * @return BillPo��ȡ�ĵ���
	 */
	 @Override
	public PaymentBillPO getBillById(String billId) {
		PaymentBillPO bill = (PaymentBillPO) getBillBl.getBillByNameAndId(BILL_NAME, billId);
		return bill;
	} 
	
	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ�и����<br/>
	 * @param billState Ҫ��ȡ�ĸ��״̬
	 * @return ArrayList<PaymentBillPO>��ȡ�ĸ���б�
	 */
	 @Override
	public ArrayList<PaymentBillPO> getBillListByState(BillStateEnum billState) {
		
		ArrayList<BillPO> bills = getBillBl.getBillListByStateAndName(billState.toString(),BILL_NAME);
		ArrayList<PaymentBillPO> targetBills = new ArrayList<PaymentBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(BillPO billPO : bills){
			targetBills.add((PaymentBillPO)billPO);
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�и���ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PaymentBillPO>��ȡ�ĸ���ݸ��б�
	 */
	 @Override
	public ArrayList<PaymentBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<PaymentBillPO> bills = getBillListByState(BillStateEnum.DRAFT);
		ArrayList<PaymentBillPO> targetBills = new ArrayList<PaymentBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(PaymentBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((PaymentBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ���������<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PaymentBillPO>��Ҫ��ȡ��δ��������б�
	 */
	 @Override
	public ArrayList<PaymentBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<PaymentBillPO> bills = getBillListByState(BillStateEnum.TBD);
		ArrayList<PaymentBillPO> targetBills = new ArrayList<PaymentBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(PaymentBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((PaymentBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�еĸ����<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PaymentBillPO>��ȡ����Ҫִ�еĸ���б�
	 */
	 @Override
	public ArrayList<PaymentBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo) {
		ArrayList<PaymentBillPO> bills = getBillListByState(BillStateEnum.TODO);
		ArrayList<PaymentBillPO> targetBills = new ArrayList<PaymentBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(PaymentBillPO billPO : bills){
			UserInfoPO user = billPO.getExecutor();
			if(user==null){
				System.out.println("������ִ����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((PaymentBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ��ĸ����<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PaymentBillPO>��ȡ������δͨ���ĸ���б�
	 */
	 @Override
	public ArrayList<PaymentBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<PaymentBillPO> bills = getBillListByState(BillStateEnum.DENIED);
		ArrayList<PaymentBillPO> targetBills = new ArrayList<PaymentBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(PaymentBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((PaymentBillPO)billPO);
			}
		}
		return targetBills;
	}


	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵĸ����<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<PaymentBillPO>��ȡ���Ѿ���ɵĸ���б�
	 */
	 @Override
	public ArrayList<PaymentBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo) {
		ArrayList<PaymentBillPO> bills = getBillListByState(BillStateEnum.DONE);
		ArrayList<PaymentBillPO> targetBills = new ArrayList<PaymentBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(PaymentBillPO billPO : bills){
			UserInfoPO user = billPO.getExecutor();
			if(user==null){
				System.out.println("������ִ����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((PaymentBillPO)billPO);
			}
		}
		return targetBills;
	}
	
}
