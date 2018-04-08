package blImpl.adminBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.UserPOVOConvertor;
import assistant.exception.Myexception;
import dataImpl.userData.GenerateIdData;
import dataImpl.userData.UserData;
import dataService.userDataService.UserDataService;
import po.UserPO;
import vo.UserVO;

public class AdminBl {
	
	UserDataService service =  new UserData();//数据层对象
	
	public UserVO getUser( String userId) throws RemoteException, Myexception{
		UserPO po = service.getUser(userId);
		return UserPOVOConvertor.poToVO(po);
	}

	public ArrayList<UserVO> getUserList() throws RemoteException, Myexception{
		ArrayList<UserVO> vos = new ArrayList<>();
		ArrayList<UserPO> pos = service.getUserList();
		for(UserPO po:pos){
			UserVO vo = UserPOVOConvertor.poToVO(po);
			vos.add(vo);
		}
		return vos;
	}
	
	public String addUser(UserVO user) throws RemoteException, Myexception{
		//待写设置Id TODO
		String id = SetUserIdBl.getInstance().generateId();
		UserPO po = UserPOVOConvertor.voToPO(user);
		po.setId(id);
		service.addUser(po);
		return id;
	}

	
	public boolean deleteUser( String userId) throws RemoteException, Myexception{
		return service.deleteUser(userId);
	}

	
	public boolean updateUser(UserVO user) throws RemoteException, Myexception{
		UserPO po = UserPOVOConvertor.voToPO(user);
		return service.updateUser(po);
	}
}
