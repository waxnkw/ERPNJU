package assistant.convertors;

import java.util.ArrayList;

import po.GiftPO;
import vo.GiftVO;
/**
 * @author zhangao 161250193
 * @version 2017.12.27
 * GiftListPO��VO��ת����
 */
public class GiftListPOVOConvertor {
	
	/**
	 * ��giftList��poת��Ϊvo
	 * @param posҪת����po list
	 * @return ArrayList<GiftVO> ת�����vo��list
	 * */
	public static ArrayList<GiftVO> giftListPOToVO(ArrayList<GiftPO> pos){
		if(pos==null){return null;}
		ArrayList<GiftVO> vos = new ArrayList<>();
		for(GiftPO po:pos){
			GiftVO vo = GiftPOVOConvertor.giftPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}
	
	/**
	 * ��giftList��voת��Ϊpo
	 * @param vosҪת����vo list
	 * @return ArrayList<GiftPO> ת�����po��list
	 * */
	public static ArrayList<GiftPO> giftListVOToPO(ArrayList<GiftVO> vos){
		if(vos==null){return null;}
		ArrayList<GiftPO> pos= new ArrayList<>();
		for(GiftVO vo:vos){
			GiftPO po = GiftPOVOConvertor.giftVOtoVPO(vo);
			pos.add(po);
		}
		return pos;
	}
}
