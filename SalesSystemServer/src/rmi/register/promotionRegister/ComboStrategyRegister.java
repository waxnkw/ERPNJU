package rmi.register.promotionRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.dataRemoteObject.promotionRemoteObject.ComboStrategyRemoteObject;

public class ComboStrategyRegister {
	public void register(){
		ComboStrategyRemoteObject remoteObject;
		try {
			remoteObject = new ComboStrategyRemoteObject();
			LocateRegistry.createRegistry(7100);
			Naming.bind("rmi://127.0.0.1:7100/ComboStrategyRemoteObject",
					remoteObject);
			System.out.println("��ϴ������Է���ע��ɹ�");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
