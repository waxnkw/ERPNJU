
package blImpl.bill.billBl;

import java.util.ArrayList;

import dataImpl.billData.GetBillData;
import dataService.billDataService.GetBillDataService;
import po.BillPO;

/**
 * @author zhangao 161250193
 * @version 2017.11.19
 * �õ����ݵľ���ʵ��
 */


public class GetBillBl {

	GetBillDataService getBillDataService = new GetBillData();//���ҵ��ݵ����ݲ����
	
	/**
	 * ���ݵ������ƺ�Id��ȡһ�ŵ��ݡ�<br/>
	 * @param billName Ҫ��ȡ�ĵ�������
	 * @param billId Ҫ��ȡ�ĵ���Id
	 * @return BillVo��ȡ�ĵ���
	 */
	public BillPO getBillByNameAndId(String billName, String billId) {
		BillPO billPO = getBillDataService.getBillByNameAndId(billName, billId);
		return billPO;
	}


	/**
	 * ���ݵ���״̬��ȡһϵ�е��ݡ�<br/>
	 * @param billState Ҫ��ȡ�ĵ���״̬
	 * @return ArrayList<BillPO>��ȡ�ĵ����б�
	 */
	public ArrayList<BillPO> getBillListByState(String billState) {
		ArrayList<BillPO> billPOs = getBillDataService.getBillListByState(billState);
		return billPOs;
	}


	/**
	 * ���ݵ������ƺ�״̬��ȡһϵ�е��ݡ�<br/>
	 * ר������billState����
	 * @param billState Ҫ��ȡ�ĵ���״̬
	 * @param billName Ҫ��ȡ�ĵ�������
	 * @return ArrayList<BillPO>��ȡ�ĵ����б�
	 */
	public ArrayList<BillPO> getBillListByStateAndName(String billState, String billName) {
		ArrayList<BillPO> billPOs = getBillDataService.getBillListByStateAndName(billState, billName);
		return billPOs;
	}

}
