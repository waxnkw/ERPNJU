package assistant.convertors;

import java.util.ArrayList;

import po.ComboStrategyPO;
import po.GiftPO;
import vo.ComboStrategyVO;
import vo.GiftVO;

/**
 * @author zhangao 161250193
 * @version 2017.12.3
 * ComboStrategyPO��VO��ת����
 */
public class ComboStrategyPOVOConvertor {
	/**
	 * ���û���������voת��Ϊpo
	 * @param ComboStrategyVO vo ��Ҫת����vo
	 * @return ComboStrategyPO ת��֮���PO
	 */
	public static ComboStrategyPO voToPO(ComboStrategyVO vo){
		if(vo==null){return null;}
		ComboStrategyPO po = new ComboStrategyPO();
		
		ArrayList<GiftVO> giftVOs = vo.getComboCommodityList();
		ArrayList<GiftPO> giftPOs = GiftListPOVOConvertor.giftListVOToPO(giftVOs);
		po.setComboCommodityList(giftPOs);
		
		po.setDiscount(vo.getDiscount());
		po.setEndDate(vo.getEndDate());
		po.setId(vo.getId());
		po.setName(vo.getName());
		po.setRemark(vo.getRemark());
		po.setStartDate(vo.getStartDate());
		po.setStrategyCategoryEnum(vo.getStrategyCategoryEnum());
		return po;
	}
	
	
	/**
	 * ���û���������poת��Ϊvo
	 * @param ComboStrategyPO po ��Ҫת����po
	 * @return ComboStrategyVO ת��֮���VO
	 */
	public static ComboStrategyVO poToVO(ComboStrategyPO po){
		if(po==null){return null;}
		ComboStrategyVO vo = new ComboStrategyVO();
		
		ArrayList<GiftPO> giftPOs = po.getComboCommodityList();
		ArrayList<GiftVO> giftVOs = GiftListPOVOConvertor.giftListPOToVO(giftPOs);
		vo.setComboCommodityList(giftVOs);
		
		vo.setDiscount(po.getDiscount());
		vo.setEndDate(po.getEndDate());
		vo.setId(po.getId());
		vo.setName(po.getName());
		vo.setRemark(po.getRemark());
		vo.setStartDate(po.getStartDate());
		vo.setStrategyCategoryEnum(po.getStrategyCategoryEnum());
		return vo;
	}
}
