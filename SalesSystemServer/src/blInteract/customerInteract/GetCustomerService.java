/**
 * 
 */
package blInteract.customerInteract;

import java.util.ArrayList;

import vo.CustomerInfoVO;

/**
 * �õ����пͻ��Ĳ�����Ϣ����������Ա��
 * @author ����һ
 * @version 2017.12.18
 *
 */
public interface GetCustomerService {

	/**
	 * ��������Ա���õ����еĿͻ��Ĳ�����Ϣ
	 * @return ArrayList<CustomerInfoVO>
	 */
	public ArrayList<CustomerInfoVO> GetCustomers();
}
