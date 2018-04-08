package dataService.customerDataService;

import java.util.ArrayList;

import po.CustomerPO;
/**
 * 
 * @author ����һ 161250140
 * @version 2017.11.7
 */

public interface CustomerDataService{

	/**
	 * �����ͻ�
	 * @param CustomerPO po��Ҫ�����Ŀͻ�
	 * @return boolean true��ʾ�ɹ�
	 */
	public boolean insert(CustomerPO po);
	
	/**
	 * ɾ��һ���ͻ���Ҫ��������ID��ȫƥ��
	 * @param number
	 * @param name
	 * @return boolean true��ʾ�ɹ�
	 */
	public boolean delete(String number, String name);
	
	/**
	 * ����һ���ͻ�����Ϣ
	 * @param po
	 * @return boolean true��ʾ�ɹ�
	 */
	public boolean update(CustomerPO po);
	
	/**
	 * ��ѯ�ͻ���Ϣ��֧�ֹؼ��ֲ���
	 * @param name
	 * @return ArrayList<CustomerPO>
	 */
	public ArrayList<CustomerPO> find(String name);
	
	/**
	 * �õ����пͻ���Ϣ
	 * @return ArrayList<CustomerPO>
	 */
	public ArrayList<CustomerPO> getAll();
}