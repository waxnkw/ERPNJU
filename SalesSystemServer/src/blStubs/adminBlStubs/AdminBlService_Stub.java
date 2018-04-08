package blStubs.adminBlStubs;

import java.rmi.RemoteException;

import blService.adminBlService.AdminBlService;
import vo.UserVO;


public class AdminBlService_Stub implements AdminBlService {

	@Override
	public UserVO getUser(String userId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(UserVO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
