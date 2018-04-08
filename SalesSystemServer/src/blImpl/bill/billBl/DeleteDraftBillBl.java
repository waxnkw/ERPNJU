package blImpl.bill.billBl;
import dataImpl.billData.DeleteDraftBillData;
import dataService.billDataService.DeleteDraftBillDataService;

/**
 * ���õ���ģʽͳһ�Բݸ嵥�ݽ���ɾ��
 * @author zhangao 161250193
 * @version 2017.11.22
 * �ݸ嵥�ݵ�ɾ��
 * ���ڷ����Ĳݸ�״̬���ݵ�ɾ��
 */

public class DeleteDraftBillBl {
	private static DeleteDraftBillBl deleteDraftBillBl;//�������� 
	
	private DeleteDraftBillDataService deleteDraftBillDataService 
		= new DeleteDraftBillData();//ɾ���ݸ嵥�ݵ����ݲ����
	
	//���췽��
	private DeleteDraftBillBl(){
		
	}
	
	/**
	 * ȡ�õ����������õĽӿ�
	 */
	public static DeleteDraftBillBl getInstance(){
		if(deleteDraftBillBl==null){
			return new DeleteDraftBillBl();
		}
		return deleteDraftBillBl;
	}
	
	/**
	 * ���ݵ��ݵ�����(����)����� ɾ��ĳһ�ŵĵ��ݲݸ塣<br/>
	 * @param String billName ���ݵ�����(����)
	 * @param String billId ���ݵı��
	 * @return boolean �Ƿ����ӳɹ�
	 */
	 public boolean deleteDraftBill(String billName,String billId) {
			return deleteDraftBillDataService.deleteDraftBill(billName, billId);
	}
}
