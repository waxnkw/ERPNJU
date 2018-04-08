package vo;

import java.util.ArrayList;

import assistant.utility.Date;

/**
 * �ֽ���õ�
 * @author guxinyu
 * @version 2017.12.4
 *  
 */
public class CashExpenseBillVO extends BillVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7609249285451243185L;
	private String bankAccount;
	private ArrayList<BillEntryVO> entries;//��Ŀ�嵥
	private double sum;
	
	public CashExpenseBillVO(){
		
	}
	
	public CashExpenseBillVO(UserInfoVO optor, String bankAcc, ArrayList<BillEntryVO> entry, double s, String createrComment ,Date d){
		setCreater(optor);
		setBankAccount(bankAcc);
		setEntries(entry);
		setSum(s);
		setCreaterComment(createrComment);
		setCreateDate(d);
	}


	public String getBankAccount() {
		if(bankAccount==null)
			return "";
		else
			return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public ArrayList<BillEntryVO> getEntries() {
		return entries;
	}

	public void setEntries(ArrayList<BillEntryVO> entries) {
		this.entries = entries;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
}
