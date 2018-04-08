package dataImpl.billData;

import java.io.File;

import assistant.utility.DeleteFileUtility;
import dataService.billDataService.DeleteDraftBillDataService;

/**
 * @author zhangao 161250193
 * @version 2017.11.22
 * �ݸ嵥�ݵ�ɾ��
 * ���ڷ����Ĳݸ�״̬���ݵ�ɾ��
 */

public class DeleteDraftBillData implements DeleteDraftBillDataService {
	
	private static final String ROOT_PATH = "data"+File.separator+"bill"+File.separator;//��Ŀ¼��ַ
	private static final String STATE_PATH = "draft"+File.separator;//��Ӧ��״̬�ļ��е�ַ
	private static final String FILE_EXTENSION = ".ser";
	
	@Override
	public boolean deleteDraftBill(String billName,String billId) {
		String path = ROOT_PATH +billName + File.separator + STATE_PATH + billId + FILE_EXTENSION;
	//	System.out.println(path);
		return DeleteFileUtility.deleteFile(path);//ɾ���ļ�
	}

}
