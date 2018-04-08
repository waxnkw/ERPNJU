package rmi.linker.listServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import blService.listBlService.BusinessConditionListBlService;

public class BusinessConditionListServiceLinker {
	private static BusinessConditionListServiceLinker linker;
	private Remote remote;
	
	private BusinessConditionListServiceLinker(){
		setRemote();
	}
	
	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:8010/BusinessConditionListRemoteObject");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static BusinessConditionListServiceLinker getInstance(){
		if(linker==null){
			linker=new BusinessConditionListServiceLinker();
		}
		return linker;
	}
	
	public BusinessConditionListBlService getBusinessConditionListBlService(){
		return (BusinessConditionListBlService)remote;
	}
}
