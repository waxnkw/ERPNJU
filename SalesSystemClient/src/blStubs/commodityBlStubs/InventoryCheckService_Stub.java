package blStubs.commodityBlStubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blService.commodityBlService.InventoryCheckBlService;
import vo.InventoryCheckSheetVO;
//do some change 2017.11.06
public class InventoryCheckService_Stub implements InventoryCheckBlService{
	//id name type amount averagePrice productionDate
	public InventoryCheckSheetVO inventoryCheckSheet() throws RemoteException{
		InventoryCheckSheetVO inventoryCheckSheet=new InventoryCheckSheetVO();
		ArrayList<String[]> sheet=new ArrayList<String[]>();
		String[] infor1={"G01010101","���䱴����","T0001","100","100","2017-11-06"};
		String[] infor2={"G01010102","���䱴����","T0002","100","100","2017-11-06"};
		String[] infor3={"G01010103","ӫ�ⱴ����","T0001","100","100","2017-11-06"};
		String[] infor4={"G01010104","�Ųʱ�����","T0001","100","100","2017-11-06"};

		sheet.add(infor1);
		sheet.add(infor2);
		sheet.add(infor3);
		sheet.add(infor4);
		inventoryCheckSheet.setInventoryCheckSheet(sheet);
		return inventoryCheckSheet;
	}

}
