package dataDrivers.billDataDrivers;

import java.util.ArrayList;

import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import dataImpl.billData.GetBillData;
import dataImpl.billData.SaveAsDraftBillData;
import dataService.billDataService.GetBillDataService;
import dataService.billDataService.SaveAsDraftBillDataService;
import po.BillPO;
import po.GiftBillPO;

/**
 * @author zhangao 161250193
 * @version 2017.11.21
 * �����ݴ���Ϊ�ݸ�״̬������
 */

public class SaveAsDraftBillDataService_Driver {
	
	private SaveAsDraftBillDataService saveAsDraftBillDataService
		=new SaveAsDraftBillData();
	
	/**
	 * �������Դ���һ�ſ�����͵��ݸ塣<br/>
	 */
	public void driveSaveDraftGiftBill(){
		GiftBillPO giftBillPO = new GiftBillPO();
		giftBillPO.setCreateDate(new Date());
		giftBillPO.setCategoryEnum(BillCategoryEnum.GIFT_BILL);
		giftBillPO.setCreaterComment("����һ���µĲݸ�");
		setBillId(giftBillPO);
		saveAsDraftBillDataService.saveAsDraftGiftBill(giftBillPO);
		
//		GetBillDataService getBillDataService = new GetBillData();
//		ArrayList<BillPO> bills;
//		bills=getBillDataService.getBillListByStateAndName(BillStateEnum.DRAFT.toString(), "gift_bill");
//		GiftBillPO giftBillPO2 = (GiftBillPO)bills.get(0);
//		System.out.println(giftBillPO2.getCreaterComment());
//		giftBillPO2.setCreaterComment("���Ǻ�Ĳݸ�");
//		saveAsDraftBillDataService.saveAsDraftGiftBill(giftBillPO2);
	}

	
	public static void main(String []args){
		SaveAsDraftBillDataService_Driver saveAsDraftBillDataService_Driver
			= new SaveAsDraftBillDataService_Driver();
		saveAsDraftBillDataService_Driver.driveSaveDraftGiftBill();;
	}
	
	/**
	 * ����draftģʽ�µ�bill��Id��<br/>
	 * Id�ĸ�ʽΪ ��������+�û��˺�+��-��+����������+Сʱ+����+�� ���磺KCZSD_12345-20170206-02-44-15
	 * @param GiftBillPO bill ��Ҫ�趨Id�ĵ��� 
	 * @return void
	 */
	private void setBillId(BillPO bill){
		
		if(bill.getId()!=null){return;}//�Ѿ����ù�Id,Ϊ�Ѵ��ڲݸ�
		String Id="";
		BillCategoryEnum category = bill.getCategoryEnum();
		Date createDate = bill.getCreateDate();
		Id += category.toBillIdPart()+"_";
		Id += createDate.getBillDraftIdPart();
		bill.setId(Id);
	}
}
