package dataService.billDataService;

import java.util.ArrayList;
import assistant.type.UserPositionEnum;
import po.BillPO;

public interface GetBillDataService{
	 public BillPO getBillByNameAndId(String billName,String billId);
	 
	 //Ӧ����approve��list
	 public ArrayList<BillPO> getBillListByState(String billState);
	 public ArrayList<BillPO> getBillListByStateAndName(String billState,String billName);
}
