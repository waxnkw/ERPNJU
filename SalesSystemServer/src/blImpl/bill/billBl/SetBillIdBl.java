package blImpl.bill.billBl;

import assistant.type.BillCategoryEnum;
import assistant.utility.Date;
import dataImpl.billData.SetBillIdData;
import dataService.billDataService.SetBillIdDataService;
import po.BillPO;

/**
 * ���õ���Id��һ������ģʽ��һ���߼���
 * @author zhangao 161250193
 * @version 2017.11.29
 * �õ�����
 */
public class SetBillIdBl {
	
	
	SetBillIdDataService setBillIdDataService = new SetBillIdData();
	private static SetBillIdBl setBillIdBl;//����ĵ�������
	
	//���캯��
	private SetBillIdBl(){
		
	}
	
	/**
	 * ȡ�õ����������õĽӿ�
	 */
	public static SetBillIdBl getInstance(){
		if(setBillIdBl==null){
			setBillIdBl = new SetBillIdBl();
		}
		return setBillIdBl;
	}
	
	/**
	 * @param BillPO bill��Ҫ����Id�ĵ���
	 * @return �Ƿ����óɹ�
	 */
	public boolean setBillIdAndUpdateRecord(BillPO bill){
		boolean isSuccessedSet = false; 
		setBillIdDataService.setBillId(bill);//�Ƿ����óɹ�
		isSuccessedSet = setBillIdDataService.updateRecord(bill);//�Ƿ����óɹ�
		return isSuccessedSet;
	}
	
	/**
	 * ����draftģʽ�µ�bill��Id��<br/>
	 * Id�ĸ�ʽΪ ��������+�û��˺�+��-��+����������+Сʱ+����+�� ���磺KCZSD_12345-20170206-02-44-15
	 * @param GiftBillPO bill ��Ҫ�趨Id�ĵ��� 
	 * @return void
	 */
	public void setDraftBillId(BillPO bill){

		if(!(bill.getId()==null||bill.getId().trim().equals(""))){return;}//�Ѿ����ù�Id,Ϊ�Ѵ��ڲݸ�
		String Id="";
		BillCategoryEnum category = bill.getCategoryEnum();
		Date createDate = bill.getCreateDate();
		Id += category.toBillIdPart()+"_";
		Id += createDate.getBillDraftIdPart();
		bill.setId(Id);
		
	}
	
}
