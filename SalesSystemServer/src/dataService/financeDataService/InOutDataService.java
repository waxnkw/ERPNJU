package dataService.financeDataService;

import po.*;

/**
 * �������ݲ������ݿ�ӿ�
 * @author guxinyu
 * @version 2017.12.4
 *
 */
public interface InOutDataService{
	
	/**
	 * ��ȡ�˵��б�ÿ����˵��Ը��������������磺2016���˵�����Ϊ"2016"
	 * @return �˵����Ƶ�String����
	 */
	public String[] readInOutList();
	
	/**
	 * �����տ�͸��ͨ����˺󣬵��ô˽ӿ��ڸ����˵��в���ñʽ�����Ϣ
	 * @param toInsertΪ��Ҫ������ĵ��ʽ��׵�PO
	 * @return ���صĲ���ֵ�����Ƿ����ɹ�
	 */
	public boolean insert (SingleEntryPO toInsert);
	
	/**
	 * ���½��˵�ʱ�������ڳ���Ϣ�������ɸ����˵��ļ�
	 * @param toInsertΪҪ������ڳ���Ϣ��PO
	 * @return ���صĲ���ֵ�����Ƿ񱣴�ɹ�
	 */
	public boolean insert (InitialInfoPO toInsert);
	
	/**
	 * ��ȡĳһ���˵����ڳ���Ϣ
	 * @param inOutYea �˵����ƣ������
	 * @return �ڳ���ϢPO
	 */
	public InitialInfoPO readInitialInfo(String inOutYear);
	
	/**
	 * ��ȡĳһ���˵�����ϸ
	 * @param inOutYear �˵����ƣ������
	 * @return �˵���ϸPO
	 */
	public InOutDetailsPO readDetails(String inOutYear);

}
