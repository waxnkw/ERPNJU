package vo;

import java.io.Serializable;

/**
 * �����൥�������Ŀ�嵥�е�һ��
 * @author guxinyu
 * @version 2017.12.28
 *
 */
public class BillEntryVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9069075274106636414L;
	private String entryName;
	private String entryMoney;
	
	public BillEntryVO(String name, String money){
		setEntryName(name);
		setEntryMoney(money);
	}
	
	public void setEntryName(String name){
		entryName=name;;
	}
	
	public String getEntryName(){
		return entryName;
	}
	
	public void setEntryMoney(String money){
		entryMoney=money;;
	}
	
	public String getEntryMoney(){
		return entryMoney;
	}

}

