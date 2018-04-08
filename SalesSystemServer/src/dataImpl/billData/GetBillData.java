package dataImpl.billData;

import java.io.File;
import java.util.ArrayList;

import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.ReadAndWriteBillPOSerUtility;
import dataService.billDataService.GetBillDataService;
import po.BillPO;

/**
 * @author zhangao 161250193
 * @version 2017.11.19
 * �õ�����
 */

public class GetBillData implements GetBillDataService{

	private static final String ROOT_PATH = "data"+File.separator+"bill"+File.separator;//��Ŀ¼��ַ
//	private static final String STATE_PATH = "tbd"+File.separator;//��Ӧ��״̬�ļ��е�ַ
	
	
	/**
	 * ���ݵ������ƺ�Id��ȡһ�ŵ��ݡ�<br/>
	 * @param billName Ҫ��ȡ�ĵ�������
	 * @param billId Ҫ��ȡ�ĵ���Id
	 * @return BillPo��ȡ�ĵ���
	 */
	@Override
	public BillPO getBillByNameAndId(String billName, String billId) {
		BillPO billPO=null;
		String path = ROOT_PATH+billName+File.separator;
		for(BillStateEnum state: BillStateEnum.values()){
			String filePath = path + state.toString() + File.separator + billId+".ser";
			System.out.println(filePath);
			billPO = readObj(filePath);
			if(billPO!=null){return billPO;}
		}
		return billPO;
	}
	
	/**
	 * ���ݵ���״̬��ȡһϵ�е��ݡ�<br/>
	 * @param billState Ҫ��ȡ�ĵ���״̬
	 * @return ArrayList<BillPO>��ȡ�ĵ����б�
	 */
	@Override
	public ArrayList<BillPO> getBillListByState(String billState) {
		ArrayList<BillPO> bills = new ArrayList<BillPO>();
		String path = ROOT_PATH;
		for(BillCategoryEnum category:BillCategoryEnum.values()){
			ArrayList<BillPO> categoryBills = getBillListByStateAndName(billState,category.toString());
			bills.addAll(categoryBills);
		}
		return bills;
	}

	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ�е��ݡ�<br/>
	 * ר������billState����
	 * @param billState Ҫ��ȡ�ĵ���״̬
	 * @param billName Ҫ��ȡ�ĵ�������
	 * @return ArrayList<BillPO>��ȡ�ĵ����б�
	 */
	@Override
	public ArrayList<BillPO> getBillListByStateAndName(String billState, String billName) {
		ArrayList<BillPO> bills = new ArrayList<BillPO>();
		String path = ROOT_PATH+billName+File.separator+billState+ File.separator;//�ļ��е�·������ȡ���ļ����������ļ�
		File dir = new File(path);
		String [] filesName = dir.list();//�õ���ǰ�ļ���
		//��ȡ��Щ�ļ�
		for(int i=0;i<filesName.length;i++){
			if(!filesName[i].contains("-")){continue;}
			bills.add(readObj(path+filesName[i]));
		}
		return bills;
	}
	

	/**
	 * ��ȡһ�ŵ��ݡ�<br/>
	 * @param path Ҫ��ȡ�ĵ���·��
	 * @return BillPo��ȡ�ĵ���
	 */
	private BillPO readObj(String path){
		return ReadAndWriteBillPOSerUtility.readObj(path);
	}
	
}
