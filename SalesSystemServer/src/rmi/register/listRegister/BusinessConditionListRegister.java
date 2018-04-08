package rmi.register.listRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import rmi.dataRemoteObject.listRemoteObject.BusinessConditionListRemoteObject;


public class BusinessConditionListRegister {
	public BusinessConditionListRegister(){
		
	}
	
	public void register(){
		BusinessConditionListRemoteObject remoteObject;
		try {
			remoteObject = new BusinessConditionListRemoteObject();
			LocateRegistry.createRegistry(8010);
			Naming.bind("rmi://127.0.0.1:8010/BusinessConditionListRemoteObject",
					remoteObject);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
