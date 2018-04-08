package rmi.register.approveBillRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import rmi.dataRemoteObject.approveBillRemoteObject.ApproveGiftBillRemoteObject;
/**
 * ����ͨ�ŵ�ע����
 * @author zhangao
 * @version 2017.12.28
 * */
public class ApproveGiftBillRegister {
	public ApproveGiftBillRegister(){
		
	}
	
	/**
	 * �÷����ע�᷽��
	 * */
	public void register(){
		ApproveGiftBillRemoteObject remoteObject;
		try {
			remoteObject = new ApproveGiftBillRemoteObject();
			LocateRegistry.createRegistry(7702);
			Naming.bind("rmi://127.0.0.1:7702/ApproveGiftBillRemoteObject",
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
