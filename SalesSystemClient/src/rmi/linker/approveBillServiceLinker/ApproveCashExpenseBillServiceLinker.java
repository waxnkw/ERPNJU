package rmi.linker.approveBillServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.billService.approveBillBlService.ApproveCashExpenseBillBlService;

public class ApproveCashExpenseBillServiceLinker {
	private static ApproveCashExpenseBillServiceLinker linker ;
	private Remote remote ;
	
	private ApproveCashExpenseBillServiceLinker(){
		setRemote();
	}
	
	/**
	 * �󶨶˿��õ�remote
	 * */
	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:7701/ApproveCashExpenseBillRemoteObject");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ApproveCashExpenseBillServiceLinker getInstance(){
		if(linker==null){
			linker = new ApproveCashExpenseBillServiceLinker();
		}
		return linker;
	}
	
	public ApproveCashExpenseBillBlService  getApproveCashExpenseBillBlService(){
		return (ApproveCashExpenseBillBlService)remote;
	}
	
}
