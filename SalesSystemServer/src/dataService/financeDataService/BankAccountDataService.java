package dataService.financeDataService;

import java.util.ArrayList;
import assistant.exception.AccountNameExistException;
import po.BankAccountPO;

/**
 * �����˻���ز������ݿ�ӿ�
 * @author guxinyu
 * @version 12.30
 *
 */
public interface BankAccountDataService {
	
	public boolean insert(BankAccountPO toInsert) throws AccountNameExistException;
	
	public ArrayList<BankAccountPO> readBankAccounts();
	
	public boolean updateName(String oldName, String newName)throws AccountNameExistException;
	
	public boolean updateMoney(String name, double change);
	
	public boolean delete(String toDelete);
}
