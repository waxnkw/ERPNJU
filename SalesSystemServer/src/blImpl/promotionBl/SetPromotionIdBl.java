package blImpl.promotionBl;

import assistant.utility.Date;
import po.PromotionStrategyPO;

/**
 * �趨�������Ե�Id�ĵ�����
 * @author zhangao 161250193
 * @version 2017.12.3
 */

public class SetPromotionIdBl {
	private static SetPromotionIdBl setPromotionIdBl;//��������
	
	/**
	 * �õ�����id��������
	 * @return SetPromotionBl �������������
	 */
	public static SetPromotionIdBl getInstance(){
		if(setPromotionIdBl==null){
			setPromotionIdBl = new SetPromotionIdBl();
		}
		return setPromotionIdBl;
	}
	
	/**
	 * ���ô������Ե�ID
	 */
	public void setId(PromotionStrategyPO po){
		Date date = new Date();
		po.setId(date.toPromotionId());
	}
}
