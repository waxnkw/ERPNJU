package po;

import java.io.Serializable;

/**
 * �˵��ڳ���Ϣ�������˻���Ϣ�е�һ��
 * @author guxinyu
 * @version 2017.12.4
 *
 */
public class SingleBankAccountInitialInfoPO implements Serializable{

	private static final long serialVersionUID = 5L;
	
	private String bankAccountName="";
	private String bankAccountSum="";
	
	public SingleBankAccountInitialInfoPO(){
		
	}
	
	public SingleBankAccountInitialInfoPO(String accName,String accSum){
		setBankAccountName(accName);
		setBankAccountSum(accSum);
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankAccountSum() {
		return bankAccountSum;
	}

	public void setBankAccountSum(String bankAccountSum) {
		this.bankAccountSum = bankAccountSum;
	}
	
	

}
