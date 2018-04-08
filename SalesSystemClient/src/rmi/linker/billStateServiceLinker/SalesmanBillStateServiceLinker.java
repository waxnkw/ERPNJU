package rmi.linker.billStateServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.billService.billStateBlService.SalesmanBillStateBlService;

public class SalesmanBillStateServiceLinker {
	private static SalesmanBillStateServiceLinker linker;
	private Remote remote;
	
	private SalesmanBillStateServiceLinker(){
		setRemote();
	}
	
	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:8005/SalesmanBillStateRemoteObject");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static SalesmanBillStateServiceLinker getInstance(){
		if(linker==null){
			linker=new SalesmanBillStateServiceLinker();
		}
		return linker;
	}
	
	public SalesmanBillStateBlService getSalesmanBillStateBlService(){
		return (SalesmanBillStateBlService)remote;
	} 
}
