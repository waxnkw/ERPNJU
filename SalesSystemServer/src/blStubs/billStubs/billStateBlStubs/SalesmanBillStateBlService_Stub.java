package blStubs.billStubs.billStateBlStubs;

import blService.billService.billStateBlService.SalesmanBillStateBlService;

/**
 * ���۽�����Ա����״̬�߼��ӿ�׮
 * @author guxinyu
 * @version 2017.11.7
 *
 */
public class SalesmanBillStateBlService_Stub implements SalesmanBillStateBlService{
	  
		@Override
		//��ȡδͨ����˵ĵ��ݵĵ��ݱ���б�
		public String[] getUnpassedList(){
			String[] toReturn={"PurchaseBill/JHD-20160530-00001",
					"SalesBill/XSD-20160530-00002"};
			
			return toReturn;
		}
		
}
