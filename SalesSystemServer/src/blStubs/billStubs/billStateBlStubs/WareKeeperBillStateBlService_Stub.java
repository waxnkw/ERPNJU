package blStubs.billStubs.billStateBlStubs;

import blService.billService.billStateBlService.WareKeeperBillStateBlService;

/**
 * ��������Ա����״̬�߼��ӿڵ�׮
 * @author guxinyu
 * @version 2017.11.7
 *
 */
public class WareKeeperBillStateBlService_Stub implements WareKeeperBillStateBlService{
	@Override
	//��ȡͨ����˴�����ĵ��ݵĵ��ݱ���б�
	public String[] getToDoList(){
		String[] toReturn={"PurchaseBill/JHD-20160530-00001",
				"SalesReturnBill/XSTHD-20160530-00002",
				"InventoryOverBill/KCBYD-20160530-00003"};
		
		return toReturn;
	}
		
	@Override
	//��ȡδͨ����˵ĵ��ݵĵ��ݱ���б�
	public String[] getUnpassedList(){
		String[] toReturn={"InventoryOverBill/KCBYD-20160530-00003",
				"InventoryLossBill/KCBSD-20160530-00005",
				"InventoryWarningBill/KCBJD-20160530-00004"};
		
		return toReturn;
	}
	
	@Override
	//�������ɵĵ��ݵĵ��ݵĵ��ݱ���б�
	public String[] getDoneList(){
		String[] toReturn={"PurchaseBill/JHD-20160530-00003",
				"SalesReturnBill/XSTHD-20160530-00004",
				"InventoryOverBill/KCBYD-20160530-00005"};
		
		return toReturn;
	}

}
