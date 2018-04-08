package rmi.register.promotionRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.dataRemoteObject.promotionRemoteObject.UserStrategyRemoteObject;

public class UserStrategyRegister {
	public UserStrategyRegister(){
		
	}
	
	public void register(){
		UserStrategyRemoteObject remoteObject;
		try {
			remoteObject = new UserStrategyRemoteObject();
			LocateRegistry.createRegistry(7101);
			Naming.bind("rmi://127.0.0.1:7101/UserStrategyRemoteObject",
					remoteObject);
			System.out.println("�û��������Է���ע��ɹ�");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
