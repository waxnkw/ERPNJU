package dataDrivers.adminDataDrivers;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.UserPositionEnum;
import dataImpl.userData.UserData;
import dataService.userDataService.UserDataService;
import po.UserPO;

public class AdminDataService_Driver {

	UserDataService service= new UserData();
	
	public void driveGetUser(){
		
	}
	
	public void driveAddUser() throws RemoteException{
		UserPO po = new UserPO();
		po.setAge(20);
		po.setDescription("�������Ӱ���");
		po.setId("00005");
		po.setName("С��");
		po.setPosition(UserPositionEnum.WAREKEPPER);
		service.addUser(po);
	}
	
	public void driveDriverGetUserList() throws RemoteException{
		ArrayList<UserPO> pos = service.getUserList();
		for(UserPO po:pos){
			System.out.println(po.getName());
		}
	}
	
	public static void main(String []args) throws RemoteException{
		AdminDataService_Driver driver = new AdminDataService_Driver();
		//driver.driveAddUser();
		driver.driveDriverGetUserList();
	}
}
