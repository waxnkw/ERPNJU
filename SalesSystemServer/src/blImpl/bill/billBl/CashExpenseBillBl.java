package blImpl.bill.billBl;

import java.util.ArrayList;
import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.CashExpenseBillBlService;
import dataImpl.billData.CreateBillData;
import dataImpl.billData.SaveAsDraftBillData;
import dataService.billDataService.CreateBillDataService;
import dataService.billDataService.SaveAsDraftBillDataService;
import po.BillPO;
import po.CashExpenseBillPO;
import po.UserInfoPO;

/**
 * CashExpenseBillBl�߼��࣬�ṩ��ɾ�Ĳ飬�ݸ崴��������ֽ���õ�����
 * @author �Ű�  161250193
 * @version 2017.12.1
 */

public class CashExpenseBillBl implements CashExpenseBillBlService{
	
	static final BillCategoryEnum BILL_CATEGORY_ENUM = BillCategoryEnum.CASH_EXPENSE_BILL
			;//��ǰ���ݵ�����
	static final String BILL_NAME = BILL_CATEGORY_ENUM.toString();//��ǰ���ݵ�����
	
	GetBillBl getBillBl = new GetBillBl();//��ѯ���ݵ��߼������
	
	private CreateBillDataService createBillDataService =  new CreateBillData();//���ݲ����
	private SaveAsDraftBillDataService saveAsDraftBillDataService = new SaveAsDraftBillData();//���ݲ����
	

	/**
	 * ����һ���µ��ֽ���õ���<br/>
	 * @param CashExpenseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean createBill(CashExpenseBillPO bill) {
		Date nowDate =new Date();
		bill.setCreateDate(nowDate);//���ô�������
		bill.setCategoryEnum(BILL_CATEGORY_ENUM);//���õ������ͣ��Է���һ
		bill.setBillStateEnum(BillStateEnum.TBD);//���õ���״̬Ϊδ����
		SetBillIdBl.getInstance().setBillIdAndUpdateRecord(bill);//����Id������Id��¼
		boolean isSuccessedCreation = createBillDataService.createCashExpenseBill(bill);
		return isSuccessedCreation;
	}
	

	/**
	 * ����һ���µ��ֽ���õ��ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param CashExpenseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean saveAsDraftBill(CashExpenseBillPO bill) {
		Date nowDate =new Date();
		bill.setCreateDate(nowDate);//���ô�������
		bill.setCategoryEnum(BILL_CATEGORY_ENUM);//���õ������ͣ��Է���һ
		bill.setBillStateEnum(BillStateEnum.DRAFT);//���õ���״̬Ϊ�ݸ�
		SetBillIdBl.getInstance().setDraftBillId(bill);//���òݸ��Id
		return saveAsDraftBillDataService.saveAsDraftCashExpenseBill(bill);
	}
	

	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param CashExpenseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean updateDraftBill(CashExpenseBillPO bill){
		return saveAsDraftBill(bill);
	}
	

	/**
	 * ͨ��Idɾ��һ���ֽ���õ�
	 * @param String billId ��Ҫɾ���Ĳݸ嵥��Id
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */

@Override	 public boolean deleteDraftBill(String billId) {
		 System.out.println(billId);
		return DeleteDraftBillBl.getInstance().deleteDraftBill(BILL_NAME, billId);
	}
	 
	
	 /**
	  * ע�⣺��������ڸõ��ݲݸ壬����ύʧ��
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ��ֽ���õ�ȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	 @Override
	public boolean submitBill(String billId){
		CashExpenseBillPO bill = getBillById(billId);
		if(bill==null){return false;}
		deleteDraftBill(billId);//ɾ���òݸ�
		createBill(bill);//�������ֽ���õ���δ����״̬����
		return true;
	}

	
	/**
	 * ����Idͨ��һ���ֽ���õ�������
	 * @param String billId ��Ҫ����ͨ���ĵ���Id
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	 @Override
	public boolean passBill(CashExpenseBillPO bill) {
		return ProcessBillBl.getInstance().passBill(bill);
	}

	/**
	 * @param String billId ��Ҫ�ܾ�����ͨ���ĵ���Id
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	 @Override
	public boolean denyBill(CashExpenseBillPO bill) {
		return ProcessBillBl.getInstance().denyBill(bill);
	}

	/**
	 * @param String billId ����ɵĵ���Id
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	 @Override
	public boolean doneBill(CashExpenseBillPO bill) {
		return ProcessBillBl.getInstance().doneBill(bill);
	}

	/**
	 * @param String billId ��Ҫ����ɾ�ĵ���Id
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	 @Override
	public boolean hideBill(CashExpenseBillPO bill) {
		return	ProcessBillBl.getInstance().hideBill(bill);
	}
	

	/**
	 * ���ݵ���Id��ȡһ���ֽ���õ���<br/>
	 * @param billId Ҫ��ȡ���ֽ���õ�Id
	 * @return BillPo��ȡ�ĵ���
	 */
	 @Override
	public CashExpenseBillPO getBillById(String billId) {
		CashExpenseBillPO bill = (CashExpenseBillPO) getBillBl.getBillByNameAndId(BILL_NAME, billId);
		return bill;
	} 
	

	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ���ֽ���õ���<br/>
	 * @param billState Ҫ��ȡ���ֽ���õ�״̬
	 * @return ArrayList<CashExpenseBillPO>��ȡ���ֽ���õ��б�
	 */
	 @Override
	public ArrayList<CashExpenseBillPO> getBillListByState(BillStateEnum billState) {
		
		ArrayList<BillPO> bills = getBillBl.getBillListByStateAndName(billState.toString(),BILL_NAME);
		ArrayList<CashExpenseBillPO> targetBills = new ArrayList<CashExpenseBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(BillPO billPO : bills){
			targetBills.add((CashExpenseBillPO)billPO);
		}
		return targetBills;
	}
	

	/**
	 * ���ݵ��ݴ����߶�ȡһϵ���ֽ���õ��ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<CashExpenseBillPO>��ȡ���ֽ���õ��ݸ��б�
	 */
	 @Override
	public ArrayList<CashExpenseBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<CashExpenseBillPO> bills = getBillListByState(BillStateEnum.DRAFT);
		ArrayList<CashExpenseBillPO> targetBills = new ArrayList<CashExpenseBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(CashExpenseBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((CashExpenseBillPO)billPO);
			}
		}
		return targetBills;
	}
	

	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ�����ֽ���õ���<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<CashExpenseBillPO>��Ҫ��ȡ��δ�����ֽ���õ��б�
	 */
	 @Override
	public ArrayList<CashExpenseBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<CashExpenseBillPO> bills = getBillListByState(BillStateEnum.TBD);
		ArrayList<CashExpenseBillPO> targetBills = new ArrayList<CashExpenseBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(CashExpenseBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((CashExpenseBillPO)billPO);
			}
		}
		return targetBills;
	}
	

	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�е��ֽ���õ���<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<CashExpenseBillPO>��ȡ����Ҫִ�е��ֽ���õ��б�
	 */
	 @Override
	public ArrayList<CashExpenseBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo) {
		ArrayList<CashExpenseBillPO> bills = getBillListByState(BillStateEnum.TODO);
		ArrayList<CashExpenseBillPO> targetBills = new ArrayList<CashExpenseBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(CashExpenseBillPO billPO : bills){
			UserInfoPO user = billPO.getExecutor();
			if(user==null){
				System.out.println("������ִ����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((CashExpenseBillPO)billPO);
			}
		}
		return targetBills;
	}
	

	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ����ֽ���õ���<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<CashExpenseBillPO>��ȡ������δͨ�����ֽ���õ��б�
	 */
	 @Override
	public ArrayList<CashExpenseBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<CashExpenseBillPO> bills = getBillListByState(BillStateEnum.DENIED);
		ArrayList<CashExpenseBillPO> targetBills = new ArrayList<CashExpenseBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(CashExpenseBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((CashExpenseBillPO)billPO);
			}
		}
		return targetBills;
	}

	

	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵ��ֽ���õ���<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<CashExpenseBillPO>��ȡ���Ѿ���ɵ��ֽ���õ��б�
	 */
	 @Override
	public ArrayList<CashExpenseBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo) {
		ArrayList<CashExpenseBillPO> bills = getBillListByState(BillStateEnum.DONE);
		ArrayList<CashExpenseBillPO> targetBills = new ArrayList<CashExpenseBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(CashExpenseBillPO billPO : bills){
			UserInfoPO user = billPO.getExecutor();
			if(user==null){
				System.out.println("������ִ����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((CashExpenseBillPO)billPO);
			}
		}
		return targetBills;
	}
	
}
