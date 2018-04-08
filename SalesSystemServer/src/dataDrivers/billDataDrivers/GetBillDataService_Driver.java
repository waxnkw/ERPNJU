package dataDrivers.billDataDrivers;

import java.util.ArrayList;
import assistant.type.UserPositionEnum;
import dataImpl.billData.GetBillData;
import dataService.billDataService.GetBillDataService;
import po.BillPO;
import po.CashExpenseBillPO;
import po.GiftBillPO;

public class GetBillDataService_Driver{
	
	GetBillDataService getBillDataService = new GetBillData();
	
	/**
	 * �������Ը��ݵ������ƺ�Id��ȡһ�ŵ��ݡ�<br/>
	 */
	public void driveGetBillByNameAndId(){
		String billName ;
		String billId ;
		BillPO billPO;
		
		billName = "gift_bill";
		billId = "KCZSD_2017-11-28_14_04_13";
		billPO = getBillDataService.getBillByNameAndId(billName, billId);
		if(billPO==null){System.out.println("�����ڸõ���");}
		else{System.out.println("�õ���Ϊ"+billPO.getId());}
		
//		billName = "gift_bill";
//		billId = "KCZSD-20171109-00003";
//		billPO = getBillDataService.getBillByNameAndId(billName, billId);
//		if(billPO==null){System.out.println("�����ڸõ���");}
//		else{System.out.println("�õ���Ϊ"+billPO.getId());}
		
//		billName = "cash_expense_bill";
//		billId = "XJFYD-20171119-00003";
//		billPO = getBillDataService.getBillByNameAndId(billName, billId);
//		if(billPO==null){System.out.println("�����ڸõ���");}
//		else{System.out.println("�õ���Ϊ"+billPO.getId()+" account"+((CashExpenseBillPO)billPO).getBankAccount());}
		
//		billName = "gift_bill";
//		billId = "KCZSD-20171119-00001";
//		billPO = getBillDataService.getBillByNameAndId(billName, billId);
//		if(billPO==null){System.out.println("�����ڸõ���");}
//		else{System.out.println("�õ���Ϊ"+billPO.getId()+" ����״̬Ϊ"+billPO.getBillStateEnum().toString());}
	}
	
	/**
	 * �������Ը��ݵ������ƺ�״̬��ȡһϵ�е��ݡ�<br/>
	 */
	public void driveGetBillListByStateAndName(){
		String billState = "tbd";
		String billName = "gift_bill";
		ArrayList<BillPO> bills = getBillDataService.getBillListByStateAndName(billState, billName);
		for(int i=0;i<bills.size();i++){
			System.out.println(bills.get(i).getId());
		}
	}
	
	/**
	 * �������Ը��ݵ���״̬��ȡһϵ�е��ݡ�<br/>
	 */
	public void driveGetBillListByState(){
		String billState = "tbd";
		ArrayList<BillPO> billPOs = getBillDataService.getBillListByState(billState);
		for(int i=0;i<billPOs.size();i++){
			System.out.println(billPOs.get(i).getId());
		}
	}
	
	public static void main(String [] args){
		GetBillDataService_Driver getBillDataService_Driver=new GetBillDataService_Driver();
		getBillDataService_Driver.driveGetBillByNameAndId();
	//	getBillDataService_Driver.driveGetBillListByStateAndName();
	//	getBillDataService_Driver.driveGetBillListByState();
	}
}
