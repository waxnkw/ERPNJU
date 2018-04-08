package dataService.billDataService;

import po.BillPO;

public interface SetBillIdDataService {
	/**
	 * ���µ�ǰ��bill����record��<br/>
	 * @param BillPO��ǰ��Ҫ���µ�Bill��¼
	 * @return boolean �Ƿ���³ɹ�
	 */
	public boolean updateRecord(BillPO bill);
	
	/**
	 * ����bill��Id��<br/>
	 * @param GiftBillPO bill ��Ҫ�趨Id�ĵ��� 
	 * @return void
	 */
	public void setBillId(BillPO bill);
}
