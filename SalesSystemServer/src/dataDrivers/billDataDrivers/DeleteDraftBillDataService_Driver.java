package dataDrivers.billDataDrivers;

import dataImpl.billData.DeleteDraftBillData;
import dataService.billDataService.DeleteDraftBillDataService;

/**
 * @author zhangao 161250193
 * @version 2017.11.22
 * ɾ���ݸ嵥�ݵ�����
 */

public class DeleteDraftBillDataService_Driver {
	
	DeleteDraftBillDataService deleteDraftBillDataService =new DeleteDraftBillData();
	
	/**
	 * �������Ը��ݵ������ƺ�Idɾ��һ�Ųݸ�״̬�ĵ��ݡ�<br/>
	 */
	public void driveDeleteDraftBill(){
		String billName ;
		String billId ; 
		billName = "gift_bill";
		billId = "KCZSD_2017-11-21_16_42_59";
		deleteDraftBillDataService.deleteDraftBill(billName, billId);
	}
	
	public static void main(String [] args){
		DeleteDraftBillDataService_Driver deleteDraftBillDataService_Driver
			= new DeleteDraftBillDataService_Driver();
		deleteDraftBillDataService_Driver.driveDeleteDraftBill();
	}
}
