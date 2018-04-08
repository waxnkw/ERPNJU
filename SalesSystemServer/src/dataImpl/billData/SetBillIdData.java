package dataImpl.billData;

import java.io.File;

import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import assistant.utility.ReadAndWriteTxtUtility;
import dataService.billDataService.SetBillIdDataService;
import po.BillPO;

public class SetBillIdData implements SetBillIdDataService{

	private static final String ROOT_PATH = "data"+File.separator+"bill"+File.separator;//��Ŀ¼��ַ
	private static final String STATE_PATH = "tbd"+File.separator;//��Ӧ��״̬�ļ��е�ַ
	public static final String CREATE_RECORD = "create_record.txt" ;
	private static final int BILL_ID_LENGTH=5;//���ݱ�ŵĳ��ȣ�����Ϊ5.��KCZSD-20171108-00001��00001����

	/**
	 * ���µ�ǰ��bill����record��<br/>
	 * @param String path Ҫ����ļ���λ��
	 * @param String content Ҫ׷�ӵļ�¼
	 * @return boolean �Ƿ���³ɹ�
	 */
	public boolean updateRecord(BillPO bill){
		BillCategoryEnum billCategoryEnum = bill.getCategoryEnum();
		String path = ROOT_PATH + billCategoryEnum.toString()+ File.separator + STATE_PATH;//���¼�¼��λ��
		String record = bill.getId();
		path += CREATE_RECORD;
		record += System.lineSeparator();
		return	ReadAndWriteTxtUtility.writeTxtAppend(path, record);
	}


	/**
	 * ����bill��Id��<br/>
	 * @param GiftBillPO bill ��Ҫ�趨Id�ĵ���
	 * @return void
	 */
	public void setBillId(BillPO bill){
		BillCategoryEnum category = bill.getCategoryEnum();
		String path =  ROOT_PATH + category.toString()+File.separator+STATE_PATH+File.separator ;
		path += CREATE_RECORD;
//		File dir = new File(path);
//		String [] filesName = dir.list();//�õ���ǰ�ļ���

		String content = ReadAndWriteTxtUtility.readTxt(path);//��ȡ�����ļ���¼
		String [] filesName = content.split(System.lineSeparator());//�õ���ǰ�ļ���

		int newId=1;//������Id�ı����ֵ
		Date createDate = bill.getCreateDate();
		String todayDateString=createDate.getBillIdPart();//�õ������IdӦ�е����ڲ���

		for(int i=0;i<filesName.length;i++){
			String fName = filesName[i];
			if(!fName.contains("-")){continue;}
			String dateString = fName.split("-")[1];//�õ�KCZSD-20171108-00001�е����ڲ���,��20171108
			if(dateString.equals(todayDateString)){newId++;}
		}

		//���ɵ�ǰId��String��ʽ
		String newIdString = ""+newId;
		int len = (BILL_ID_LENGTH-newIdString.length());
		for(int i=0;i<len;i++){
			newIdString="0".concat(newIdString);
		}

		//���õ�ǰ����Id
		bill.setId(category.toBillIdPart()+"-"+todayDateString+"-"+newIdString);
	}
}
