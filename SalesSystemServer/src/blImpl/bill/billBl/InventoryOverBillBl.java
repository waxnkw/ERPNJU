package blImpl.bill.billBl;

import java.util.ArrayList;
import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.InventoryOverBillBlService;
import dataImpl.billData.CreateBillData;
import dataImpl.billData.SaveAsDraftBillData;
import dataService.billDataService.CreateBillDataService;
import dataService.billDataService.SaveAsDraftBillDataService;
import po.BillPO;
import po.InventoryOverBillPO;
import po.UserInfoPO;

/**
 * InventoryOverBillBl�߼��࣬�ṩ��ɾ�Ĳ飬�ݸ崴������ؿ�汨�絥����
 * @author �Ű�  161250193
 * @version 2017.12.1
 */

public class InventoryOverBillBl implements InventoryOverBillBlService{
	
	static final BillCategoryEnum BILL_CATEGORY_ENUM = BillCategoryEnum.INVENTORY_OVER_BILL;//��ǰ���ݵ�����
	static final String BILL_NAME = BILL_CATEGORY_ENUM.toString();//��ǰ���ݵ�����
	
	GetBillBl getBillBl = new GetBillBl();//��ѯ���ݵ��߼������
	
	private CreateBillDataService createBillDataService =  new CreateBillData();//���ݲ����
	private SaveAsDraftBillDataService saveAsDraftBillDataService = new SaveAsDraftBillData();//���ݲ����
	
	/**
	 * ����һ���µĿ�汨�絥��<br/>
	 * @param InventoryOverBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createBill(InventoryOverBillPO bill) {
		Date nowDate =new Date();
		bill.setCreateDate(nowDate);//���ô�������
		bill.setCategoryEnum(BILL_CATEGORY_ENUM);//���õ������ͣ��Է���һ
		bill.setBillStateEnum(BillStateEnum.TBD);//���õ���״̬Ϊδ����
		SetBillIdBl.getInstance().setBillIdAndUpdateRecord(bill);//����Id������Id��¼
		boolean isSuccessedCreation = createBillDataService.createInventoryOverBill(bill);
		return isSuccessedCreation;
	}
	
	/**
	 * ����һ���µĿ�汨�絥�ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param InventoryOverBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftBill(InventoryOverBillPO bill) {
		Date nowDate =new Date();
		bill.setCreateDate(nowDate);//���ô�������
		bill.setCategoryEnum(BILL_CATEGORY_ENUM);//���õ������ͣ��Է���һ
		bill.setBillStateEnum(BillStateEnum.DRAFT);//���õ���״̬Ϊ�ݸ�
		SetBillIdBl.getInstance().setDraftBillId(bill);//���òݸ��Id
		return saveAsDraftBillDataService.saveAsDraftInventoryOverBill(bill);
	}
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param InventoryOverBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean updateDraftBill(InventoryOverBillPO bill){
		return saveAsDraftBill(bill);
	}
	
	/**
	 * ͨ��Idɾ��һ�ſ�汨�絥
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
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ��汨�絥ȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	@Override
	public boolean submitBill(String billId){
		InventoryOverBillPO bill = getBillById(billId);
		if(bill==null){return false;}
		deleteDraftBill(billId);//ɾ���òݸ�
		createBill(bill);//�����ÿ�汨�絥��δ����״̬����
		return true;
	}
		
	/**
	 * ����Idͨ��һ�ݿ�汨�絥������
	 * @param String billId ��Ҫ����ͨ���ĵ���Id
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	@Override
	public boolean passBill(InventoryOverBillPO bill) {
		return ProcessBillBl.getInstance().passBill(bill);
	}

	/**
	 * @param String billId ��Ҫ�ܾ�����ͨ���ĵ���Id
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	@Override
	public boolean denyBill(InventoryOverBillPO bill) {
		return ProcessBillBl.getInstance().denyBill(bill);
	}

	/**
	 * @param String billId ����ɵĵ���Id
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	@Override
	public boolean doneBill(InventoryOverBillPO bill) {
		return ProcessBillBl.getInstance().doneBill(bill);
	}

	/**
	 * @param String billId ��Ҫ����ɾ�ĵ���Id
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	@Override
	public boolean hideBill(InventoryOverBillPO bill) {
		return	ProcessBillBl.getInstance().hideBill(bill);
	}
	
	/**
	 * ���ݵ���Id��ȡһ�ſ�汨�絥��<br/>
	 * @param billId Ҫ��ȡ�Ŀ�汨�絥Id
	 * @return BillPo��ȡ�ĵ���
	 */
	@Override
	public InventoryOverBillPO getBillById(String billId) {
		InventoryOverBillPO bill = (InventoryOverBillPO) getBillBl.getBillByNameAndId(BILL_NAME, billId);
		return bill;
	} 
	
	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ�п�汨�絥��<br/>
	 * @param billState Ҫ��ȡ�Ŀ�汨�絥״̬
	 * @return ArrayList<InventoryOverBillPO>��ȡ�Ŀ�汨�絥�б�
	 */
	 @Override
	public ArrayList<InventoryOverBillPO> getBillListByState(BillStateEnum billState) {
		
		ArrayList<BillPO> bills = getBillBl.getBillListByStateAndName(billState.toString(),BILL_NAME);
		ArrayList<InventoryOverBillPO> targetBills = new ArrayList<InventoryOverBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(BillPO billPO : bills){
			targetBills.add((InventoryOverBillPO)billPO);
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�п�汨�絥�ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryOverBillPO>��ȡ�Ŀ�汨�絥�ݸ��б�
	 */
	 @Override
	public ArrayList<InventoryOverBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<InventoryOverBillPO> bills = getBillListByState(BillStateEnum.DRAFT);
		ArrayList<InventoryOverBillPO> targetBills = new ArrayList<InventoryOverBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(InventoryOverBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((InventoryOverBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ������汨�絥��<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryOverBillPO>��Ҫ��ȡ��δ������汨�絥�б�
	 */
	 @Override
	public ArrayList<InventoryOverBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<InventoryOverBillPO> bills = getBillListByState(BillStateEnum.TBD);
		ArrayList<InventoryOverBillPO> targetBills = new ArrayList<InventoryOverBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(InventoryOverBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((InventoryOverBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�еĿ�汨�絥��<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryOverBillPO>��ȡ����Ҫִ�еĿ�汨�絥�б�
	 */
	 @Override
	public ArrayList<InventoryOverBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo) {
		ArrayList<InventoryOverBillPO> bills = getBillListByState(BillStateEnum.TODO);
		ArrayList<InventoryOverBillPO> targetBills = new ArrayList<InventoryOverBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(InventoryOverBillPO billPO : bills){
			UserInfoPO user = billPO.getExecutor();
			if(user==null){
				System.out.println("������ִ����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((InventoryOverBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ��Ŀ�汨�絥��<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryOverBillPO>��ȡ������δͨ���Ŀ�汨�絥�б�
	 */
	 @Override
	public ArrayList<InventoryOverBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<InventoryOverBillPO> bills = getBillListByState(BillStateEnum.DENIED);
		ArrayList<InventoryOverBillPO> targetBills = new ArrayList<InventoryOverBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(InventoryOverBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((InventoryOverBillPO)billPO);
			}
		}
		return targetBills;
	}


	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵĿ�汨�絥��<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryOverBillPO>��ȡ���Ѿ���ɵĿ�汨�絥�б�
	 */
	 @Override
	public ArrayList<InventoryOverBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo) {
		ArrayList<InventoryOverBillPO> bills = getBillListByState(BillStateEnum.DONE);
		ArrayList<InventoryOverBillPO> targetBills = new ArrayList<InventoryOverBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(InventoryOverBillPO billPO : bills){
			UserInfoPO user = billPO.getExecutor();
			if(user==null){
				System.out.println("������ִ����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((InventoryOverBillPO)billPO);
			}
		}
		return targetBills;
	}
	
}
