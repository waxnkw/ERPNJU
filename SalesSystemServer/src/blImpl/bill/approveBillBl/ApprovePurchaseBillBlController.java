package blImpl.bill.approveBillBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.SalesmanBillsPOVOConvertor;
import assistant.convertors.UserInfoPOVOConvertor;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.PurchaseBillBlService;
import blInteract.financeInteract.BankAccountSumUpdateBlService;
import blInteract.financeInteract.FinanceBlFactory;
import blService.billService.approveBillBlService.ApprovePurchaseBillBlService;
import po.PurchaseBillPO;
import po.UserInfoPO;
import vo.PurchaseBillVO;
import vo.UserInfoVO;

/**
 * ���ݵ������������õ���Ҫ���������б�����pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */

public class ApprovePurchaseBillBlController implements ApprovePurchaseBillBlService{

    private PurchaseBillBlService service 
    	= new BillBlInteractServiceFactory().getPurchaseBillBlService();//�ֽ���õ���ز���
	
    /**
	 * �õ���Ҫ�����ĵ����б�
	 * @return ArrayList<PurchaseBillVO> ��Ҫ�����ĵ����б�
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseBillVO> getBillsList() throws RemoteException {
		ArrayList<PurchaseBillPO> list = service.getBillListByState(BillStateEnum.TBD);
		ArrayList<PurchaseBillVO> targetList =new ArrayList<PurchaseBillVO>();
		for(PurchaseBillPO po: list){
			PurchaseBillVO vo = SalesmanBillsPOVOConvertor.purchaseBillPOtoVO(po) ;
			targetList.add(vo);
		}
		return targetList;
	}

	  /**
	  * ����Idͨ�����ݵ�����
	  * @param String billId���ݵ�Id
	  * @param UserInfoVO approver ��������Ϣ
	  * @param String approverComment �����˵���ע 
	  * @throws RemoteException
	  */
	@Override
	public boolean passBill(String billId, UserInfoVO approver, String approverComment) throws RemoteException {
		PurchaseBillPO billPO = service.getBillById(billId);
		UserInfoPO approverPO = UserInfoPOVOConvertor.voToPO(approver);
		billPO.setApprover(approverPO);
		billPO.setApproveDate(new Date());
		billPO.setApproverComment(approverComment);
		service.passBill(billPO);
		return true;
	}

	 /**
	  * ����Id�ܾ�ͨ�����ݵ�����
	  * @param String billId���ݵ�Id
	  * @param UserInfoVO approver ��������Ϣ
	  * @param String approverComment �����˵���ע 
	  * @throws RemoteException
	  */
	@Override
	public boolean denyBill(String billId, UserInfoVO approver, String approverComment) throws RemoteException {
		PurchaseBillPO billPO = service.getBillById(billId);
		UserInfoPO approverPO = UserInfoPOVOConvertor.voToPO(approver);
		billPO.setApprover(approverPO);
		billPO.setApproveDate(new Date());
		billPO.setApproverComment(approverComment);
		service.denyBill(billPO);
		return true;
	}

}