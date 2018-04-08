package dataDrivers.financeDataDrivers;

import java.util.ArrayList;

import dataImpl.financeData.InOutData;
import dataService.financeDataService.InOutDataService;
import po.InitialInfoPO;
import po.SingleBankAccountInitialInfoPO;
import po.SingleCommodityInitialInfoPO;
import po.SingleCustomerInitialInfoPO;
import po.SingleEntryPO;

/**
 * ���ݿ��˵�������ز����ӿڵ�׮
 * @author guxinyu
 * @version 2017.12.4
 *
 */
public class InOutDataService_Driver {
	static InOutDataService test=new InOutData();
	
	public static void main(String[] args){
		test_insertInitialInfo();
	}
	
	public static void test_readInOutList(){
		String[] result=test.readInOutList();
		for(int i=0;i<result.length;i++)
			System.out.println(result[i]);
		
	}
	
	public static void test_insertSingleEntry(){
		SingleEntryPO entry1=new SingleEntryPO("2017","2017-12-4","�۳���ͷ���","+5000.0");
		test.insert(entry1);
	}
	
	public static void test_insertInitialInfo(){
		SingleCommodityInitialInfoPO com1=new SingleCommodityInitialInfoPO(
				"�����","���ҵ����","123-wsdyd","2000","3000","0","0"
				);
		SingleCustomerInitialInfoPO cus1=new SingleCustomerInitialInfoPO(
				"VIP","����","123456789","0","3000"
				);
		SingleBankAccountInitialInfoPO bank1=new SingleBankAccountInitialInfoPO(
				"account1","45615.5"
				);
		
		ArrayList<SingleCommodityInitialInfoPO> comList=new ArrayList<SingleCommodityInitialInfoPO>();
		comList.add(com1);
		
		ArrayList<SingleCustomerInitialInfoPO> cusList=new ArrayList<SingleCustomerInitialInfoPO>();
		cusList.add(cus1);
		
		ArrayList<SingleBankAccountInitialInfoPO> bankList=new ArrayList<SingleBankAccountInitialInfoPO>();
		bankList.add(bank1);
		
		InitialInfoPO initialInfoPO=new InitialInfoPO(comList, cusList, bankList);
		initialInfoPO.setYear("2017");
		
		if(test.insert(initialInfoPO))
			System.out.println("A new InOut is successfully inserted.");
		else
			System.out.println("Fail to insert a new InOut.");
	}
	
}
