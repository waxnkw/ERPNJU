package blInteract.financeInteract;

import blImpl.financeBl.BankAccountBlController;
import blImpl.financeBl.InOutBlController;

/**
 * �������߼����ڽ����ӿڹ���
 * @author guxinyu
 * @version 2017.12.23
 *
 */
public class FinanceBlFactory {
	public BankAccountSumUpdateBlService getBankAccountSumUpdateBlService(){
		BankAccountSumUpdateBlService service=new BankAccountBlController();
		
		return service;
	}
	
	public AutoAddEntryService getAutoAddEntryService(){
		AutoAddEntryService service=new InOutBlController();
		
		return service;
	}
}
