/**
 * 
 */
package blInteract.customerInteract;

/**
 * �޸Ŀͻ���Ӧ��Ӧ����ҵ���߼��ӿ�
 * @author ����һ
 * @version 2017.11.7
 *
 */
public interface ModifyCustomerMoneyService {

	/**
	 * �޸Ŀͻ���Ӧ��Ӧ��
	 * @param �ͻ���ţ��ַ�����
	 * @param �޸ĵ�����
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	public boolean ModifyCustomerMoney(String number, double amount);
}
