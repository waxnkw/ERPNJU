package blImpl.bill.billBl;

import assistant.type.BillStateEnum;
import assistant.utility.Date;
import dataImpl.billData.ProcessBillData;
import dataService.billDataService.ProcessBillDataService;
import po.BillPO;

/**
 * @author zhangao 161250193
 * ͨ�����������ľ������
 * @version 2017.11.30
 */


public class ProcessBillBl {
	
	private static ProcessBillBl processBillBl;//��������
	
 //	private GetBillDataService getBillDataService = new GetBillData();//�鵥�ݵ����ݲ�ӿڶ���
	private ProcessBillDataService processBillDataService = new ProcessBillData();//�ı䵥��״̬�����ݲ�ӿڶ���
	
	//���췽��
	private ProcessBillBl(){
	}
	//ȡ�õ�������
	public static ProcessBillBl getInstance(){
		if(processBillBl == null){
			processBillBl = new ProcessBillBl();
		}
		return processBillBl;
	}
	

	/**
	 * ���ݵ��ݵ�����(����)����� ͨ��ĳһ�ŵĵ���������<br/>
	 * @param String billName ���ݵ�����(����)
	 * @param String billId ���ݵı��
	 * @return boolean �Ƿ�ͨ�������ɹ�
	 */
	public boolean passBill(BillPO bill) {
		BillStateEnum from = bill.getBillStateEnum();
		BillStateEnum to = BillStateEnum.TODO;//�ύ���Ϊ����ͨ��������δִ�е���
		return processBillDataService.changeBillState(bill, from, to);
	}

	/**
	 * ���ݵ��ݵ�����(����)����� �ܾ�ͨ��ĳһ�ŵĵ���������<br/>
	 * @param String billName ���ݵ�����(����)
	 * @param String billId ���ݵı��
	 * @return boolean �Ƿ�ܾ�ͨ�������ɹ�
	 */
	public boolean denyBill(BillPO bill) {
		BillStateEnum from = bill.getBillStateEnum();
		BillStateEnum to = BillStateEnum.DENIED;//�ύ���Ϊ����δͨ������
		
		Date approveDate =new Date();
		bill.setApproveDate(approveDate);//���������������
		bill.setFinishDate(approveDate);//�����������δ��������
		
		return processBillDataService.changeBillState(bill, from, to);
	}

	/**
	 * ���ݵ��ݵ�����(����)����� ��ĳһ�ŵĵ��ݱ��Ϊ���״̬��<br/>
	 * @param String billName ���ݵ�����(����)
	 * @param String billId ���ݵı��
	 * @return boolean �Ƿ�ĳһ�ŵĵ��ݱ��Ϊ���״̬�ɹ�
	 */
	public boolean doneBill(BillPO bill) {
		BillStateEnum from = bill.getBillStateEnum();
		BillStateEnum to = BillStateEnum.DONE;//�ύ���Ϊ����ɵ���
		bill.setFinishDate(new Date());//�����������
		return processBillDataService.changeBillState(bill, from, to);
	}

	/**
	 * ���ݵ��ݵ�����(����)����� ����ĳһ�ŵĵ���������<br/>
	 * @param billҪ���صĵ���
	 * @return boolean �Ƿ����سɹ�
	 */
	public boolean hideBill(BillPO bill) {
		BillStateEnum from = bill.getBillStateEnum();
		BillStateEnum to = BillStateEnum.HIDDEN;//�ύ���Ϊ���ص���
		return processBillDataService.changeBillState(bill, from, to);
	}
}


