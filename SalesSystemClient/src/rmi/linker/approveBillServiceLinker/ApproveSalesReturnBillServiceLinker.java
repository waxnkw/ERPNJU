 package rmi.linker.approveBillServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.billService.approveBillBlService.ApproveSalesReturnBillBlService;

public class ApproveSalesReturnBillServiceLinker {
	private static ApproveSalesReturnBillServiceLinker linker ;
	private Remote remote ;
	
	private ApproveSalesReturnBillServiceLinker(){
		setRemote();
	}
	
	/**
	 * �󶨶˿��õ�remote
	 * */
	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:7711/ApproveSalesReturnBillRemoteObject");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ApproveSalesReturnBillServiceLinker getInstance(){
		if(linker==null){
			linker = new ApproveSalesReturnBillServiceLinker();
		}
		return linker;
	}
	
	public ApproveSalesReturnBillBlService  getApproveSalesReturnBillBlService(){
		return (ApproveSalesReturnBillBlService)remote;
	}
}
