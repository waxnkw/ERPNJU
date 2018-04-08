package po;

import java.io.Serializable;

/**
 * �ڳ���Ϣ�пͻ���Ϣ�е�һ��
 * @author guxinyu
 * @version 2017.12.4
 *
 */
public class SingleCustomerInitialInfoPO implements Serializable{

	private static final long serialVersionUID = 7L;
	
	private String customerClass="";
	private String customerName="";
	private String customerContact="";
	private String customerReceive="";//Ӧ��
	private String customerPay="";//Ӧ��
	
	public SingleCustomerInitialInfoPO(){
		
	}
	
	public SingleCustomerInitialInfoPO(String cusClass, String cusName,String cusContact,String cusReceive,
			String cusPay){
		setCustomerClass(cusClass);
		setCustomerName(cusName);
		setCustomerContact(cusContact);
		setCustomerReceive(cusReceive);
		setCustomerPay(cusPay);
	}

	public String getCustomerClass() {
		return customerClass;
	}

	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerReceive() {
		return customerReceive;
	}

	public void setCustomerReceive(String customerReceive) {
		this.customerReceive = customerReceive;
	}

	public String getCustomerPay() {
		return customerPay;
	}

	public void setCustomerPay(String customerPay) {
		this.customerPay = customerPay;
	}
	
	
	
}
