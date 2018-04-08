package rmi.linker.approveBillServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.billService.approveBillBlService.ApproveGiftBillBlService;
import blService.billService.approveBillBlService.ApproveInventoryLossBillBlService;

public class ApproveInventoryLossBillServiceLinker {
	private static ApproveInventoryLossBillServiceLinker linker ;
	private Remote remote ;
	
	private ApproveInventoryLossBillServiceLinker(){
		setRemote();
	}
	
	/**
	 * �󶨶˿��õ�remote
	 * */
	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:7703/ApproveInventoryLossBillRemoteObject");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ApproveInventoryLossBillServiceLinker getInstance(){
		if(linker==null){
			linker = new ApproveInventoryLossBillServiceLinker();
		}
		return linker;
	}
	
	public ApproveInventoryLossBillBlService  getApproveInventoryLossBillBlService(){
		return (ApproveInventoryLossBillBlService)remote;
	}
	
}
