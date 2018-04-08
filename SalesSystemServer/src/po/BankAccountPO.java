package po;

import java.io.Serializable;

/**
 * �����˻�
 * @author guxinyu 
 * @version 2017.11.7
 *
 */
public class BankAccountPO implements Serializable{
	
	private static final long serialVersionUID = -5809782578272943999L;
	
	private String accountName;
	private double remainingSum;
	

	public BankAccountPO(){
		
	}

	public BankAccountPO(String accN, double remSum){
		setAccountName(accN);
		setRemainingSum(remSum);
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;//�貹�䣺�����˻����Ƿ��Ѿ�����
	}

	public double getRemainingSum() {
		return remainingSum;
	}

	public void setRemainingSum(double remainingSum) {
		this.remainingSum = remainingSum;
	}
}
