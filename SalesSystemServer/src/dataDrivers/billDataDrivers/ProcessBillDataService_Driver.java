package dataDrivers.billDataDrivers;

import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import dataImpl.billData.ProcessBillData;
import dataService.billDataService.ProcessBillDataService;
import po.BillPO;

/**
 * @author zhangao 161250193
 * @version 2017.11.8
 * �ı䵥��״̬������
 */

public class ProcessBillDataService_Driver{
	
	ProcessBillDataService billDataService = new ProcessBillData();
	
	/**
	 * �������Ըı�һ�ŵ��ݵ�״̬�ʹ����λ�á�<br/>
	 */
	public void driveProcessBill(){
		BillPO billPO;
		BillStateEnum from;
		BillStateEnum to;
		
//		billPO = new BillPO();
//		billPO.setCategoryEnum(BillCategoryEnum.GIFT_BILL);
//		billPO.setId("KCZSD-20171119-00001");
//		billPO.setBillStateEnum(BillStateEnum.TBD);
//		from = BillStateEnum.TBD;
//		to = BillStateEnum.DENIED;
//		billDataService.changeBillState(billPO,from , to);
		
		billPO = new BillPO();
		billPO.setCategoryEnum(BillCategoryEnum.CASH_EXPENSE_BILL);
		billPO.setId("XJFYD-20171119-00003");
		billPO.setBillStateEnum(BillStateEnum.TBD);
		from = BillStateEnum.TBD;
		to = BillStateEnum.DENIED;
		billDataService.changeBillState(billPO,from , to);
	}
	
	public static void main(String [] args){
		ProcessBillDataService_Driver processBillDataService_Driver = new ProcessBillDataService_Driver();
		processBillDataService_Driver.driveProcessBill();
	}

}
