package assistant.convertors;

import java.util.ArrayList;

import po.GiftPO;
import po.TotalStrategyPO;
import vo.GiftVO;
import vo.TotalStrategyVO;

/**
 * @author zhangao 161250193
 * @version 2017.12.3
 * TotalStrategyPO��VO��ת����
 */
public class TotalStrategyPOVOConvertor {
	/**
	 * ���û���������voת��Ϊpo
	 * @param TotalStrategyVO vo ��Ҫת����vo
	 * @return TotalStrategyPO ת��֮���PO
	 */
	public static TotalStrategyPO voToPO(TotalStrategyVO vo){
		if(vo==null){return null;}
		TotalStrategyPO po = new TotalStrategyPO();
		po.setCoupon(vo.getCoupon());
		po.setTotalConsumption(vo.getTotalConsumption());
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
	 * @param TotalStrategyPO po ��Ҫת����po
	 * @return TotalStrategyVO ת��֮���VO
	 */
	public static TotalStrategyVO poToVO(TotalStrategyPO po){
		if(po==null){return null;}
		TotalStrategyVO vo = new TotalStrategyVO();
		vo.setCoupon(po.getCoupon());
		vo.setTotalConsumption(po.getTotalConsumption());
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
