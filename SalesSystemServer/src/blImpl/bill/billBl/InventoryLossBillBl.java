
package blImpl.bill.billBl;

import po.InventoryLossBillPO;
import java.util.ArrayList;
import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.InventoryLossBillBlService;
import dataImpl.billData.CreateBillData;
import dataImpl.billData.SaveAsDraftBillData;
import dataService.billDataService.CreateBillDataService;
import dataService.billDataService.SaveAsDraftBillDataService;
import po.BillPO;
import po.UserInfoPO;

/**
 * InventoryLossBillBl�߼��࣬�ṩ��ɾ�Ĳ飬�ݸ崴������ؿ�汨�𵥲���
 * @author �Ű�  161250193
 * @version 2017.12.1
 */

public class InventoryLossBillBl implements InventoryLossBillBlService{
	static final BillCategoryEnum BILL_CATEGORY_ENUM = BillCategoryEnum.INVENTORY_LOSS_BILL;//��ǰ���ݵ�����
	static final String BILL_NAME = BILL_CATEGORY_ENUM.toString();//��ǰ���ݵ�����
	
	GetBillBl getBillBl = new GetBillBl();//��ѯ���ݵ��߼������
	
	private CreateBillDataService createBillDataService =  new CreateBillData();//���ݲ����
	private SaveAsDraftBillDataService saveAsDraftBillDataService = new SaveAsDraftBillData();//���ݲ����
	
	/**
	 * ����һ���µĿ�汨�𵥡�<br/>
	 * @param InventoryLossBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean createBill(InventoryLossBillPO bill) {
		Date nowDate =new Date();
		bill.setCreateDate(nowDate);//���ô�������
		bill.setCategoryEnum(BILL_CATEGORY_ENUM);//���õ������ͣ��Է���һ
		bill.setBillStateEnum(BillStateEnum.TBD);//���õ���״̬Ϊδ����
		SetBillIdBl.getInstance().setBillIdAndUpdateRecord(bill);//����Id������Id��¼
		boolean isSuccessedCreation = createBillDataService.createInventoryLossBill(bill);
		return isSuccessedCreation;
	}
	
	/**
	 * ����һ���µĿ�汨�𵥲ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param InventoryLossBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean saveAsDraftBill(InventoryLossBillPO bill) {
		Date nowDate =new Date();
		bill.setCreateDate(nowDate);//���ô�������
		bill.setCategoryEnum(BILL_CATEGORY_ENUM);//���õ������ͣ��Է���һ
		bill.setBillStateEnum(BillStateEnum.DRAFT);//���õ���״̬Ϊ�ݸ�
		SetBillIdBl.getInstance().setDraftBillId(bill);//���òݸ��Id
		return saveAsDraftBillDataService.saveAsDraftInventoryLossBill(bill);
	}
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param InventoryLossBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 @Override
	public boolean updateDraftBill(InventoryLossBillPO bill){
		return saveAsDraftBill(bill);
	}
	
	/**
	 * ͨ��Idɾ��һ�ſ�汨��
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
	  * ���ݵ���Id�ύһ���Ѵ��ڵĲݸ��汨��ȥ����
	 * @param String billId ��Ҫ�ɲݸ��ύΪ����ģʽ�ĵ���Id
	 * @return boolean �Ƿ��ύ�ɹ�
	 * @
	 */
	 @Override
	public boolean submitBill(String billId){
		InventoryLossBillPO bill = getBillById(billId);
		if(bill==null){return false;}
		deleteDraftBill(billId);//ɾ���òݸ�
		createBill(bill);//�����ÿ�汨�𵥵�δ����״̬����
		return true;
	}
		
	/**
	 * ����Idͨ��һ�ݿ�汨�𵥵�����
	 * @param String billId ��Ҫ����ͨ���ĵ���Id
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	 @Override
	public boolean passBill(InventoryLossBillPO bill) {
		return ProcessBillBl.getInstance().passBill(bill);
	}

	/**
	 * @param String billId ��Ҫ�ܾ�����ͨ���ĵ���Id
	 * @return boolean �Ƿ�ܾ��ɹ�
	 */
	 @Override
	public boolean denyBill(InventoryLossBillPO bill) {
		return ProcessBillBl.getInstance().denyBill(bill);
	}

	/**
	 * @param String billId ����ɵĵ���Id
	 * @return boolean �Ƿ�ɹ���ǳ����״̬
	 */
	 @Override
	public boolean doneBill(InventoryLossBillPO bill) {
		return ProcessBillBl.getInstance().doneBill(bill);
	}

	/**
	 * @param String billId ��Ҫ����ɾ�ĵ���Id
	 * @return boolean �Ƿ�ɹ���ɾ
	 */
	 @Override
	public boolean hideBill(InventoryLossBillPO bill) {
		return	ProcessBillBl.getInstance().hideBill(bill);
	}
	
	/**
	 * ���ݵ���Id��ȡһ�ſ�汨�𵥡�<br/>
	 * @param billId Ҫ��ȡ�Ŀ�汨��Id
	 * @return BillPo��ȡ�ĵ���
	 */
	 @Override
	public InventoryLossBillPO getBillById(String billId) {
		InventoryLossBillPO bill = (InventoryLossBillPO) getBillBl.getBillByNameAndId(BILL_NAME, billId);
		return bill;
	} 
	
	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ�п�汨�𵥡�<br/>
	 * @param billState Ҫ��ȡ�Ŀ�汨��״̬
	 * @return ArrayList<InventoryLossBillPO>��ȡ�Ŀ�汨���б�
	 */
	 @Override
	public ArrayList<InventoryLossBillPO> getBillListByState(BillStateEnum billState) {
		
		ArrayList<BillPO> bills = getBillBl.getBillListByStateAndName(billState.toString(),BILL_NAME);
		ArrayList<InventoryLossBillPO> targetBills = new ArrayList<InventoryLossBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(BillPO billPO : bills){
			targetBills.add((InventoryLossBillPO)billPO);
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�п�汨�𵥲ݸ塣<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ����ֽ���õ��ݸ�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryLossBillPO>��ȡ�Ŀ�汨�𵥲ݸ��б�
	 */
	 @Override
	public ArrayList<InventoryLossBillPO> getDraftBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<InventoryLossBillPO> bills = getBillListByState(BillStateEnum.DRAFT);
		ArrayList<InventoryLossBillPO> targetBills = new ArrayList<InventoryLossBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(InventoryLossBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((InventoryLossBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ��δ������汨�𵥡�<br/>
	 * ר������billState���֣����������Ա��ȡ�Լ��ƶ�����δ�������ĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryLossBillPO>��Ҫ��ȡ��δ������汨���б�
	 */
	 @Override
	public ArrayList<InventoryLossBillPO> getTBDBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<InventoryLossBillPO> bills = getBillListByState(BillStateEnum.TBD);
		ArrayList<InventoryLossBillPO> targetBills = new ArrayList<InventoryLossBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(InventoryLossBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((InventoryLossBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ����Ҫִ�еĿ�汨�𵥡�<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ�Ҫȥִ�еĵ���
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryLossBillPO>��ȡ����Ҫִ�еĿ�汨���б�
	 */
	 @Override
	public ArrayList<InventoryLossBillPO> getToDoBillsListByExecutor(UserInfoPO targetUserInfo) {
		ArrayList<InventoryLossBillPO> bills = getBillListByState(BillStateEnum.TODO);
		ArrayList<InventoryLossBillPO> targetBills = new ArrayList<InventoryLossBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(InventoryLossBillPO billPO : bills){
			UserInfoPO user = billPO.getExecutor();
			if(user==null){
				System.out.println("������ִ����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((InventoryLossBillPO)billPO);
			}
		}
		return targetBills;
	}
	
	/**
	 * ���ݵ��ݴ����߶�ȡһϵ�б��ܾ��Ŀ�汨�𵥡�<br/>
	 * ר������billState����,���������Ա��ȡ��Ҫ�Լ��ύ��������δͨ���ĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryLossBillPO>��ȡ������δͨ���Ŀ�汨���б�
	 */
	 @Override
	public ArrayList<InventoryLossBillPO> getDeniedBillsListByCreater(UserInfoPO targetUserInfo) {
		ArrayList<InventoryLossBillPO> bills = getBillListByState(BillStateEnum.DENIED);
		ArrayList<InventoryLossBillPO> targetBills = new ArrayList<InventoryLossBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(InventoryLossBillPO billPO : bills){
			UserInfoPO user = billPO.getCreater();
			if(user==null){
				System.out.println("�����ڴ�����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((InventoryLossBillPO)billPO);
			}
		}
		return targetBills;
	}


	/**
	 * ���ݵ���ִ���߶�ȡһϵ�б���ɵĿ�汨�𵥡�<br/>
	 * ר������billState����,���������Ա��ȡ�Ѿ����Լ���ɵĵ����б�
	 * @param userName ɸѡ�ĵ��ݴ����ߵ�����
	 * @param userId ɸѡ�ĵ��ݴ����ߵ�Id
	 * @param userRole ɸѡ�ĵ��ݴ����ߵ�ְλ
	 * @return ArrayList<InventoryLossBillPO>��ȡ���Ѿ���ɵĿ�汨���б�
	 */
	 @Override
	public ArrayList<InventoryLossBillPO> getDoneBillsListByExecutor(UserInfoPO targetUserInfo) {
		ArrayList<InventoryLossBillPO> bills = getBillListByState(BillStateEnum.DONE);
		ArrayList<InventoryLossBillPO> targetBills = new ArrayList<InventoryLossBillPO>();//��Ҫ���صĵ����嵥
		//��ʽǿ������ת����ɸѡ
		for(InventoryLossBillPO billPO : bills){
			UserInfoPO user = billPO.getExecutor();
			if(user==null){
				System.out.println("������ִ����");
				continue;
			}
			if(user.equals(targetUserInfo)){
				targetBills.add((InventoryLossBillPO)billPO);
			}
		}
		return targetBills;
	}
}
