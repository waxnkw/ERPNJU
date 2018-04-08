package blImpl.financeBl;

import java.util.ArrayList;
import assistant.exception.AccountNameExistException;
import dataImpl.financeData.BankAccountData;
import dataService.financeDataService.BankAccountDataService;
import po.BankAccountPO;

/**
 * �����˻���ز���������߼�ʵ��
 * @author guxinyu
 * @version 2017.12.30
 *
 */
public class BankAccountBl {
	
	private static BankAccountBl bankAccountBl; //��������
	
	private static BankAccountDataService bankAccountDataService=new BankAccountData();
	
	private BankAccountBl(){
		
	}
	
	public static BankAccountBl getInstance(){
		if(bankAccountBl==null){
			bankAccountBl=new BankAccountBl();
		}
		
		return bankAccountBl;
	}
	
	public boolean saveAccount(BankAccountPO toSave) throws AccountNameExistException{
		if(bankAccountDataService.insert(toSave))
			return true;
		else
			return false;
	}
	
	public ArrayList<BankAccountPO> getAccounts(){
		ArrayList<BankAccountPO> accounts=bankAccountDataService.readBankAccounts();
		
		return accounts;
	}
	
	public boolean updateAccount(String oldAccountName, String newAccountName)throws AccountNameExistException{
		if(bankAccountDataService.updateName(oldAccountName, newAccountName))
			return true;
		else
			return false;
	}
	
	public boolean deleteAccount(String toDelete){
		if(bankAccountDataService.delete(toDelete))
			return true;
		else
			return false;
	}
	
	public boolean updateRemainingSum(String accountName, double change){
		if(bankAccountDataService.updateMoney(accountName, change))
			return true;
		else
			return false;
	}
}
