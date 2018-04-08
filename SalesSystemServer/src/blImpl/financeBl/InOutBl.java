package blImpl.financeBl;

import dataImpl.financeData.InOutData;
import dataService.financeDataService.InOutDataService;
import po.InOutDetailsPO;
import po.InitialInfoPO;
import po.SingleEntryPO;


/**
 * �˵�������ز���������߼�ʵ��
 * @author guxinyu
 * @version 2017.12.4
 *
 */
public class InOutBl {
	
	private static InOutBl inOutBl=new InOutBl();//����ʵ��
	
	private InOutDataService inOutData=new InOutData();
	
	private InOutBl(){
		
	}
	
	public static InOutBl getInstance(){//�����ṩ����ʵ��
		return inOutBl;
	}
	
	//�����½����˵�
	public boolean saveInOut(InitialInfoPO toSave){
		if(inOutData.insert(toSave))
			return true;
		else
			return false;
	}
	
	//��ȡ�ڳ���Ϣ
	public InitialInfoPO getInitialInformation(String inOutYear){
		InitialInfoPO po=inOutData.readInitialInfo(inOutYear);
		return po;
	}
	
	//��ȡ�˵���ϸ
	public InOutDetailsPO getInOutDetails(String inOutYear){
		InOutDetailsPO po=inOutData.readDetails(inOutYear);
		return po;
	}
	
	//��һ���˵���������Ŀ
	public boolean addEntry(SingleEntryPO toAdd){
		if(inOutData.insert(toAdd))
			return true;
		else
			return false;
	}
	
	//��ȡ�˵��б�
	public String[] getInOutList(){
		String[] list=inOutData.readInOutList();
		return list;
	}
}
