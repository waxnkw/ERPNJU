package dataStubs.financeDataStubs;

import dataService.financeDataService.InOutDataService;
import po.InitialInfoPO;
import po.SingleEntryPO;

/**
 * �������ݲ������ݿ�ӿڵ�׮
 * @author guxinyu
 * @version 2017.11.7
 *
 */
public class InOutDataService_Stub implements InOutDataService{
	
	@Override
	public String[] readInOutList(){
		String[] list={"2010","2011","2012","2013","2014","2015","2016","2017"};
		
		return list;
	}
	
	@Override
	public boolean insert (SingleEntryPO toInsert){
		System.out.println("Is inserted.");
		return true;
	}
	
	@Override
	public boolean insert (InitialInfoPO toInsert){
		System.out.println("Is inserted.");
		return true;
	}
	
}
