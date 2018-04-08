/**
 * 
 */
package vo;

import java.io.Serializable;

import assistant.type.CustomerLevelEnum;

/**
 * gxy����
 * @author ����һ
 * @version 2017.12.18
 * ��������Ա�Ŀͻ���Ϣ
 */
public class CustomerInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 10419021593395583L;
	private String Id;
	private String name;
	private String type;
	private CustomerLevelEnum level;
	
	public CustomerInfoVO(){
		
	}
	
	public CustomerInfoVO(String i,String n, String t, CustomerLevelEnum l){
		setId(i);
		setName(n);
		setType(t);
		setLevel(l);
	}
	
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CustomerLevelEnum getLevel() {
		return level;
	}

	public void setLevel(CustomerLevelEnum level) {
		this.level = level;
	}
	
	
}
