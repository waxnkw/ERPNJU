package rmi.linker.commodityServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.commodityBlService.ActualInventoryCheckBlService;
import blService.commodityBlService.DeleteGoodsBlService;

public class DeleteGoodsServiceLinker {
	private static DeleteGoodsServiceLinker linker;
	private Remote remote;

	private DeleteGoodsServiceLinker(){
		setRemote();
	}

	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:6003/DeleteGoodsRemoteObject");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public static DeleteGoodsServiceLinker getInstance(){
		if(linker==null){
			linker=new DeleteGoodsServiceLinker();
		}
		return linker;
	}

	public DeleteGoodsBlService getDeleteGoodsBlService(){
		return (DeleteGoodsBlService)remote;
	}
}
