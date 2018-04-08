package assistant.convertors;

import java.util.ArrayList;

import po.GiftPO;
import po.UserStrategyPO;
import vo.GiftVO;
import vo.UserStrategyVO;

/**
 * @author zhangao 161250193
 * @version 2017.12.3
 * UserStrategyPO��VO��ת����
 */
public class UserStrategyPOVOConvertor {
	/**
	 * ���û���������voת��Ϊpo
	 * @param UserStrategyVO vo ��Ҫת����vo
	 * @return UserStrategyPO ת��֮���PO
	 */
	public static UserStrategyPO voToPO(UserStrategyVO vo){
		if(vo==null){return null;}
		UserStrategyPO po = new UserStrategyPO();
		po.setCoupon(vo.getCoupon());
		po.setCustomerLevel(vo.getCustomerLevel());
		po.setDiscount(vo.getDiscount());
		po.setEndDate(vo.getEndDate());

		ArrayList<GiftVO> giftVOs = vo.getGifts();
		ArrayList<GiftPO> giftPOs = GiftListPOVOConvertor.giftListVOToPO(giftVOs);
		po.setGifts(giftPOs);

		po.setId(vo.getId());
		po.setName(vo.getName());
		po.setRemark(vo.getRemark());
		po.setStartDate(vo.getStartDate());
		po.setStrategyCategoryEnum(vo.getStrategyCategoryEnum());
		return po;
	}
	
	/**
	 * ���û���������poת��Ϊvo
	 * @param UserStrategyPO po ��Ҫת����po
	 * @return UserStrategyVO ת��֮���VO
	 */
	public static UserStrategyVO poToVO(UserStrategyPO po){
		if(po==null){return null;}
		UserStrategyVO vo = new UserStrategyVO();
		vo.setCoupon(po.getCoupon());
		vo.setCustomerLevel(po.getCustomerLevel());
		vo.setDiscount(po.getDiscount());
		vo.setEndDate(po.getEndDate());
		
		ArrayList<GiftPO> giftPOs = po.getGifts();
		ArrayList<GiftVO> giftVOs = GiftListPOVOConvertor.giftListPOToVO(giftPOs);
		vo.setGifts(giftVOs);
		
		
		vo.setId(po.getId());
		vo.setName(po.getName());
		vo.setRemark(po.getRemark());
		vo.setStartDate(po.getStartDate());
		vo.setStrategyCategoryEnum(po.getStrategyCategoryEnum());
		return vo;
	}
}
