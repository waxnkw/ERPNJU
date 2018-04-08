package rmi.register.adminRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.dataRemoteObject.adminRemoteObject.AdminRemoteObject;

public class AdminBlRegister {
	public void register(){
		AdminRemoteObject remoteObject;
		try {
			remoteObject = new AdminRemoteObject();
			LocateRegistry.createRegistry(7200);
			Naming.bind("rmi://127.0.0.1:7200/AdminRemoteObject",
					remoteObject);
			System.out.println("管理员服务注册成功");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
