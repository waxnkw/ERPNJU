package blImpl.adminBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.exception.Myexception;
import blService.adminBlService.AdminBlService;
import vo.UserVO;

public class AdminBlController implements AdminBlService {
	
	private AdminBl bl = new AdminBl();
	
	@Override
	public UserVO getUser(String userId) throws RemoteException,Myexception {
		return bl.getUser(userId);
	}

	@Override
	public String addUser(UserVO user)throws RemoteException,Myexception {
		
		return bl.addUser(user);
	}

	@Override
	public boolean deleteUser( String userId)throws RemoteException,Myexception {
		
		return bl.deleteUser(userId);
	}

	@Override
	public boolean updateUser(UserVO user)throws RemoteException,Myexception  {
		return bl.updateUser(user);
	}

	@Override
	public ArrayList<UserVO> getUserList()throws RemoteException,Myexception  {
		return bl.getUserList();
	}

}
