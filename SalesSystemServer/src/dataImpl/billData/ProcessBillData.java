package dataImpl.billData;

import java.io.File;

import assistant.type.BillStateEnum;
import assistant.utility.ReadAndWriteBillPOSerUtility;
import dataService.billDataService.ProcessBillDataService;
import po.BillPO;

/**
 * @author zhangao 161250193
 * @version 2017.11.9
 * ����״̬�ĸı�
 * ���ڵ�������ͨ����������ͨ��֮��Ĳ���
 */

public class ProcessBillData implements ProcessBillDataService{
	private static final String ROOT_PATH = "data"+File.separator+"bill"+File.separator;//��Ŀ¼��ַ
	private static final String FILE_EXTENSION = ".ser";
	
	
	/**
	 * �ı䵥�ݵ�״̬��<br/>
	 * ��������״̬�ʹ����λ��
	 * @param BillPO bill Ҫ�ı�ĵ�����Ϣ
	 * @param BillStateEnum from �ı�ǰ�ĵ���״̬
	 * @param BillStateEnum to Ŀ�굥��״̬(�ı��ĵ���״̬)
	 * @return boolean ��д�ļ��ɹ�
	 */
	@Override
	public boolean changeBillState(BillPO bill, BillStateEnum from, BillStateEnum to) {
		String billCategory = bill.getCategoryEnum().toString() + File.separator;//���ݵ�ַ�����Ͳ���
		String fromBillState = from.toString() + File.separator;//���ݵ�ַ�����еĵ���״̬����
		String toBillState = to.toString() + File.separator;//���ݵ�ַ��Ŀ�굥��״̬����
		String billId = bill.getId() + FILE_EXTENSION;//���ݵ�ַ�е���Id����
		String fromPath = ROOT_PATH + billCategory +fromBillState + billId;
		String toPath = ROOT_PATH + billCategory +toBillState + billId;
		File file = new File(fromPath);
		if(!file.exists()){return false;}//ԭ�еĵ��ݲ�����

		bill.setBillStateEnum(to);//����״̬�ı�ΪĿ��״̬
		file.delete();//ɾ�����ļ�
		if(from!=BillStateEnum.DENIED){writeObj(bill, toPath);}//д�µ��ļ�,���������δͨ��������ɾ��
		return true;
	}
	
	
	/**
	 * дbill��ser�ļ���<br/>
	 * @param GiftBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean ��д�ļ��ɹ�
	 */
	private boolean writeObj(BillPO bill,String path){
		return ReadAndWriteBillPOSerUtility.writeObj(bill, path);
	}
}
