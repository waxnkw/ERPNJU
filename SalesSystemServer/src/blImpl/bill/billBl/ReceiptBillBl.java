package blImpl.bill.billBl;

import java.util.ArrayList;
import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.ReceiptBillBlService;
import dataImpl.billData.CreateBillData;
import dataImpl.billData.SaveAsDraftBillData;
import dataService.billDataService.CreateBillDataService;
import dataService.billDataService.SaveAsDraftBillDataService;
import po.BillPO;
import po.ReceiptBillPO;
import po.UserInfoPO;

/**
 * ReceiptBillBl�߼��࣬�ṩ��ɾ�Ĳ飬�ݸ崴��������տ����
 * @author �Ű�  161250193
 * @version 2017.12.1
 */

public class ReceiptBillBl implements ReceiptBillBlService{
	
	static final BillCategoryEnum BILL_CATEGORY_ENUM = BillCategoryEnum.RECEIPT_BILL;//��ǰ���ݵ�����
	static final String BILL_NAME = BILL_CATEGORY_ENUM.toString();//��ǰ���ݵ�����
	
	GetBillBl getBillBl = new GetBillBl();//��ѯ���ݵ��߼������
	
	private CreateBillDataService createBillDataService =  new CreateBillData();//���ݲ����
	private SaveAsDraftBillDataService saveAsDraftBillDataService = new SaveAsDraftBillData();//���ݲ����
	
	/**
	 * ����һ���µ��տ��<br/>
	 * @param ReceiptBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean createBill(ReceiptBillPO bill) {
		Date nowDate =new Date();
		bill.setCreateDate(nowDate);//���ô�������
		bill.setCategoryEnum(BILL_CATEGORY_ENUM);//���õ������ͣ��Է���һ
		bill.setBillStateEnum(BillStateEnum.TBD);//���õ���״̬Ϊδ����
		SetBillIdBl.getInstance().setBillIdAndUpdateRecord(bill);//����Id������Id��¼
		boolean isSuccessedCreation = createBillDataService.createReceiptBill(bill);
		return isSuccessedCreation;
	}
	
	/**
	 * ����һ���µ��տ�ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param ReceiptBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean saveAsDraftBill(ReceiptBillPO bill) {
		Date nowDate =new Date();
		bill.setCreateDate(nowDate);//���ô�������
		bill.setCategoryEnum(BILL_CATEGORY_ENUM);//���õ������ͣ��Է���һ
		bill.setBillStateEnum(BillStateEnum.DRAFT);//���õ���״̬Ϊ�ݸ�
		SetBillIdBl.getInstance().setDraftBillId(bill);//���òݸ��Id
		return saveAsDraftBillDataService.saveAsDraftReceiptBill(bill);
	}
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param ReceiptBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean updateDraftBill(ReceiptBillPO bill){
		return saveAsDraftBill(bill);
	}
	
	/**
	 * ͨ��Idɾ��һ���տ
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
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ��տȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	 @Override
	public boolean submitBill(String billId){
		ReceiptBillPO bill = getBillById(billId);
		if(bill==null){return false;}
		deleteDraftBill(billId);//ɾ���òݸ�
		createBill(bill);//�������տ��δ����״̬����
		return true;
	}
		
	/**
	 * ����Idͨ��һ���տ������
	 * @param String billId ��Ҫ����ͨ���ĵ���Id
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	 @Override
	public boolean passBill(ReceiptBillPO bill) {
		return ProcessBillBl.getInstance().passBill(bill);
	}

	/**
	 * @param String billId ��Ҫ�ܾ�����ͨ���ĵ���Id
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	 @Override
	public boolean denyBill(ReceiptBillPO bill) {
		return ProcessBillBl.getInstance().denyBill(bill);
	}

	/**
	 * @param String billId ����ɵĵ���Id
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	 @Override
	public boolean doneBill(ReceiptBillPO bill) {
		return ProcessBillBl.getInstance().doneBill(bill);
	}

	/**
	 * @param String billId ��Ҫ����ɾ�ĵ���Id
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	 @Override
	public boolean hideBill(ReceiptBillPO bill) {
		return	ProcessBillBl.getInstance().hideBill(bill);
	}
	
	/**
	 * ���ݵ���Id��ȡһ���տ��<br/>
	 * @param billId Ҫ��ȡ���տId
	 * @return BillPo��ȡ�ĵ���
	 */
	 @Override
	public ReceiptBillPO getBillById(String billId) {
		ReceiptBillPO bill = (ReceiptBillPO) getBillBl.getBillByNameAndId(BILL_NAME, billId);
		return bill;
	} 
	
	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ���տ��<br/>
	 * @param billState Ҫ��ȡ���տ״̬
	 * @return ArrayList<ReceiptBillPO>��ȡ���տ�б�
	 */
	 @Override
	public ArrayList<ReceiptBillPO> getBillListByState(BillStateEnum billState) {
		
		ArrayList<BillPO> bills = getBillBl.getBillListByStateAndName(billState.toString(),BILL_NAME);
		ArrayList<ReceiptBillPO> targetBills = new ArrayList<ReceiptBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(BillPO billPO : bills){
			targetBills.add((ReceiptBillPO)billPO);
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ���տ�ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<ReceiptBillPO>��ȡ���տ�ݸ��б�
	 */
	 @Override
	public ArrayList<ReceiptBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<ReceiptBillPO> bills = getBillListByState(BillStateEnum.DRAFT);
		ArrayList<ReceiptBillPO> targetBills = new ArrayList<ReceiptBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(ReceiptBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((ReceiptBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ�����տ��<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<ReceiptBillPO>��Ҫ��ȡ��δ�����տ�б�
	 */
	 @Override
	public ArrayList<ReceiptBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<ReceiptBillPO> bills = getBillListByState(BillStateEnum.TBD);
		ArrayList<ReceiptBillPO> targetBills = new ArrayList<ReceiptBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(ReceiptBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((ReceiptBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�е��տ��<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<ReceiptBillPO>��ȡ����Ҫִ�е��տ�б�
	 */
	 @Override
	public ArrayList<ReceiptBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo) {
		ArrayList<ReceiptBillPO> bills = getBillListByState(BillStateEnum.TODO);
		ArrayList<ReceiptBillPO> targetBills = new ArrayList<ReceiptBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(ReceiptBillPO billPO : bills){
			UserInfoPO user = billPO.getExecutor();
			if(user==null){
				System.out.println("������ִ����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((ReceiptBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ����տ��<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<ReceiptBillPO>��ȡ������δͨ�����տ�б�
	 */
	 @Override
	public ArrayList<ReceiptBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<ReceiptBillPO> bills = getBillListByState(BillStateEnum.DENIED);
		ArrayList<ReceiptBillPO> targetBills = new ArrayList<ReceiptBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(ReceiptBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((ReceiptBillPO)billPO);
			}
		}
		return targetBills;
	}


	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵ��տ��<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<ReceiptBillPO>��ȡ���Ѿ���ɵ��տ�б�
	 */
	 @Override
	public ArrayList<ReceiptBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo) {
		ArrayList<ReceiptBillPO> bills = getBillListByState(BillStateEnum.DONE);
		ArrayList<ReceiptBillPO> targetBills = new ArrayList<ReceiptBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(ReceiptBillPO billPO : bills){
			UserInfoPO user = billPO.getExecutor();
			if(user==null){
				System.out.println("������ִ����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((ReceiptBillPO)billPO);
			}
		}
		return targetBills;
	}
	
}
