package po;

import java.util.ArrayList;

import assistant.type.CustomerLevelEnum;

/**
 * @author zhangao 161250193
 * @version 2017.12.3
 * UserStrategyPO �û��������Ե�PO��
 */

public class UserStrategyPO extends  PromotionStrategyPO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7786109013185396959L;
	
	private CustomerLevelEnum customerLevel;//�ͻ�Vip�ȼ�
	private double discount;//�ۿ�
	private int coupon;//����ȯ
	private ArrayList<GiftPO> gifts;//�����嵥
	
	public UserStrategyPO(){
		
	}

	
	public CustomerLevelEnum getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(CustomerLevelEnum customerLevel) {
		this.customerLevel = customerLevel;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public ArrayList<GiftPO> getGifts() {
		return  gifts;
	}
	public void setGifts(ArrayList<GiftPO> gifts) {
		this.gifts = gifts;
	} 

}

