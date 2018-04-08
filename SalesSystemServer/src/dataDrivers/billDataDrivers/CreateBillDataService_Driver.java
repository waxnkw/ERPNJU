package dataDrivers.billDataDrivers;


import assistant.type.BillCategoryEnum;
import assistant.utility.Date;
import dataImpl.billData.CreateBillData;
import po.CashExpenseBillPO;
import po.GiftBillPO;

/**
 * @author zhangao 161250193
 * @version 2017.11.8
 * �������ݵ�����
 */

public class CreateBillDataService_Driver{
	/**
	 * �������Դ���������͵���<br/>
	 */
	public void driveCreateGiftBill(){
		GiftBillPO giftBillPO=new GiftBillPO();
		giftBillPO.setCategoryEnum(BillCategoryEnum.GIFT_BILL);
		giftBillPO.setApproveDate(new Date());
		giftBillPO.setCreateDate(new Date());
		new CreateBillData().createGiftBill(giftBillPO);
	}
	
	/**
	 * �������Դ���������͵���<br/>
	 */
	public void driveCashExpenseBill(){
		CashExpenseBillPO billPO=new CashExpenseBillPO(null,null, "bankaccount", null, 0, null);
		billPO.setCategoryEnum(BillCategoryEnum.CASH_EXPENSE_BILL);
		billPO.setApproveDate(new Date());
		billPO.setCreateDate(new Date());
		new CreateBillData().createCashExpenseBill(billPO);
	}
	
	public static void main(String [] args){
		CreateBillDataService_Driver cDataService_Driver=new CreateBillDataService_Driver();
		cDataService_Driver.driveCreateGiftBill();
	//	cDataService_Driver.driveCashExpenseBill();
	}
}
