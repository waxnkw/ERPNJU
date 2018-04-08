package rmi.register.financeRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.dataRemoteObject.financeRemoteObject.BankAccountRemoteObject;


public class BankAccountRegister {
	
	public BankAccountRegister(){
		
	}

	public void register(){
		BankAccountRemoteObject remoteObject=null;
		try {
			remoteObject = new BankAccountRemoteObject();
			LocateRegistry.createRegistry(8001);
			Naming.bind("rmi://127.0.0.1:8001/BankAccountRemoteObject",
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
