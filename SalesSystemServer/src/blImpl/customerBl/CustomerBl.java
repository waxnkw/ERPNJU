package blImpl.customerBl;

import java.security.Provider.Service;
import java.util.ArrayList;

import assistant.convertors.CustomerPOVOConvertor;
import blInteract.userInteract.GetUserService;
import blInteract.userInteract.GetUserServiceFactory;
import dataImpl.customerData.CustomerData;
import dataService.customerDataService.CustomerDataService;
import po.CustomerPO;
import vo.CustomerInfoVO;
import vo.CustomerVO;
import vo.UserInfoVO;
import vo.UserVO;

/**
 * ����������Ա�ͻ�����ľ���ʵ��
 * @author ����һ
 * @version 2017.11.7
 * 
 */
public class CustomerBl {

	private CustomerDataService data=new CustomerData();
	
	/**
	 * �޸Ŀͻ���Ӧ��Ӧ���ľ���ʵ��
	 * @param ID
	 * @param amount
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean ModifyCustomerMoney(String number, double amount) {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> customerArray = new ArrayList<CustomerVO>();
		customerArray=QueryCustomer(number);
		CustomerVO customer=customerArray.get(0);
		
		if(!customer.getId().equals(number)) {
			return false;
		}
		
		if(customer.getId().charAt(0)=='i') {//������ Ӧ��
			customer.setShouldPay(amount);
		}else {//������ Ӧ��
			customer.setShouldReceive(amount);
		}
//		customer.setShouldReceive(amount);
		boolean success=ModCustomer(customer);
		return success;
	}
	
	/**
	 * �����ͻ��ľ���ʵ��
	 * @param CustomerVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean AddCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		CustomerPO customer=CustomerPOVOConvertor.customerVOtoPO(vo);
		boolean success=data.insert(customer);
		return success;
	}
	
	/**
	 * ɾ���ͻ��ľ���ʵ��
	 * @param ID
	 * @param name
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean DelCustomer(String number, String name) {
		// TODO Auto-generated method stub
		boolean success=data.delete(number, name);
		return success;
	}
	
	/**
	 * �޸Ŀͻ���Ϣ�ľ���ʵ��
	 * @param CustomerVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean ModCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		CustomerPO customer=CustomerPOVOConvertor.customerVOtoPO(vo);
		boolean success=data.update(customer);
		return success;
	}
	
	/**
	 * ��ѯ�ͻ���Ϣ�ľ���ʵ��
	 * @param name(�ؼ���)
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected ArrayList<CustomerVO> QueryCustomer(String name) {
		// TODO Auto-generated method stub
		ArrayList<CustomerPO> initInfo=data.find(name);
		int size=initInfo.size();
		ArrayList<CustomerVO> info = new ArrayList<CustomerVO>();
		for(int i=0;i<size;i++) {
			info.add(CustomerPOVOConvertor.customerPOtoVO(initInfo.get(i)));
		}
		
		return info;
	}
		
	/**
	 * �õ�ҵ��Ա
	 * @return ArrayList<UserInfoVO>
	 */
	protected ArrayList<UserInfoVO> GetUsers() {
		GetUserServiceFactory factory=new GetUserServiceFactory();
		GetUserService userService=factory.getGetUserService();
		ArrayList<UserVO> userList=userService.getSalesman();
		
		ArrayList<UserInfoVO> users=new ArrayList<>();
		UserVO temp=new UserVO();
		UserInfoVO toFillIn=new UserInfoVO();
		for(int i=0;i<userList.size();i++) {
			temp=userList.get(i);
			toFillIn.setId(temp.getId());
			toFillIn.setName(temp.getName());
			toFillIn.setUserPositionEnum(temp.getPosition());
			users.add(toFillIn);
		}
		
		return users;
	}
	
	/**
	 * �õ����пͻ��Ĳ�����Ϣ����������Ա��
	 * @return ArrayList<CustomerInfoVO>
	 */
	protected ArrayList<CustomerInfoVO> GetCustomers(){
		
		ArrayList<CustomerPO> allInfos=new ArrayList<CustomerPO>();
		ArrayList<CustomerInfoVO> result=new ArrayList<CustomerInfoVO>();
		allInfos=data.getAll();
		
		CustomerPO now=new CustomerPO();
		CustomerInfoVO customer=new CustomerInfoVO();
		for(int i=0;i<allInfos.size();i++) {
			now=allInfos.get(i);			
			customer.setId(now.getId());
			customer.setName(now.getName());
			customer.setType(now.getType());		
			customer.setLevel(now.getLevel());
			result.add(customer);
		}
		return result;
	}
}
