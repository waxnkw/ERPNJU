 package rmi.register.approveBillRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.dataRemoteObject.approveBillRemoteObject.ApproveInventoryWarningBillRemoteObject;
/**
InventoryWarning * ����ͨ�ŵ�ע����
 * @author zhangao
 * @version 2017.12.28
 * */
public class ApproveInventoryWarningBillRegister {
	public ApproveInventoryWarningBillRegister(){
		
	}
	
	/**
	InventoryWarning * �÷����ע�᷽��
	 * */
	public void register(){
		ApproveInventoryWarningBillRemoteObject remoteObject;
		try {
			remoteObject = new ApproveInventoryWarningBillRemoteObject();
			LocateRegistry.createRegistry(7705);
			Naming.bind("rmi://127.0.0.1:7705/ApproveInventoryWarningBillRemoteObject",
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