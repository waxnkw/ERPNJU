package blImpl.bill.viewBillBl;

import java.rmi.RemoteException;

import assistant.convertors.GiftBillPOVOConvertor;
import assistant.exception.Myexception;
import blImpl.bill.billBl.GiftBillBl;
import blInteract.billBlInteract.GiftBillBlService;
import blService.billService.viewBillBlService.ViewGiftBillBlService;
import po.GiftBillPO;
import vo.GiftBillVO;

/**
 * @author zhangao 
 * @version 2017.12.28
 * */
public class ViewGiftBillBlController implements ViewGiftBillBlService {

	/**
	 * ���ݵ���Id�õ�һ��giftBill
	 * @param billId���ݵ�ID
	 * @return GiftVO �ñ�ŵĵ���
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣
	 * */
	@Override
	public GiftBillVO getGiftBill(String billId) throws RemoteException, Myexception {
		GiftBillBlService service = new GiftBillBl();
		GiftBillPO po = service.getBillById(billId);
		GiftBillVO vo = GiftBillPOVOConvertor.giftBillPOtoVO(po);
		return vo;
	}
	
}
