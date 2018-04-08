package rmi.register.commodityRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.dataRemoteObject.commodityRemoteObject.ActualInventoryCheckRemoteObject;

public class ActualInventoryCheckRegister {
public ActualInventoryCheckRegister(){

	}

	public void register(){
		ActualInventoryCheckRemoteObject remoteObject=null;
		try {
			remoteObject = new ActualInventoryCheckRemoteObject();
			LocateRegistry.createRegistry(6001);
			Naming.bind("rmi://127.0.0.1:6001/ActualInventoryCheckRemoteObject",
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
