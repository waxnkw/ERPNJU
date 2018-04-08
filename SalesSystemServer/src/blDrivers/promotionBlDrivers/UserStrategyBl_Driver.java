package blDrivers.promotionBlDrivers;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialArray;

import assistant.type.CustomerLevelEnum;
import assistant.type.StrategyCategoryEnum;
import assistant.utility.Date;
import blImpl.promotionBl.UserStrategyBlController;
import blService.promotionBlService.UserStrategyBlService;
import vo.UserStrategyVO;

public class UserStrategyBl_Driver {
	
	private UserStrategyBlService service = new UserStrategyBlController(); 
	
	public  void driveAddStrategy() throws RemoteException{
		UserStrategyVO vo = new UserStrategyVO();
		vo.setCoupon(1000);
		vo.setCustomerLevel(CustomerLevelEnum.VIP4);
		vo.setDiscount(0.8);
		vo.setStartDate(new Date(2017,12,4,2,52));
		vo.setEndDate(new Date(2017,12,27,2,52));
		vo.setName("用户促销策略Vip4");
		vo.setRemark("针对高端会员1");
		vo.setStrategyCategoryEnum(StrategyCategoryEnum.USRESTRATEGY);
		service.addStrategy(vo);
	}
	
	public void driveGetStrategyList() throws RemoteException{
		ArrayList<UserStrategyVO> list = service.getStrategyList();
		for(UserStrategyVO vo:list){
			System.out.println(vo.getName());
		}
	}
	
	public void driveDelete() throws RemoteException{
		service.deleteStrategy("2017-1204-02-58-48");
	}
	
	public void driveUpdate() throws RemoteException{
		UserStrategyVO vo = new UserStrategyVO();
		vo.setId("2017-1204-02-58-53");
		vo.setCoupon(1000);
		vo.setCustomerLevel(CustomerLevelEnum.VIP4);
		vo.setDiscount(0.8);
		vo.setStartDate(new Date(2017,12,4,2,52));
		vo.setEndDate(new Date(2017,12,27,2,52));
		vo.setName("update用户促销策略Vip4");
		vo.setRemark("针对高端会员1");
		vo.setStrategyCategoryEnum(StrategyCategoryEnum.USRESTRATEGY);
		service.updateStrategy(vo);
	}
	
	public static void main(String []args) throws RemoteException{
		UserStrategyBl_Driver userStrategyBl_Driver = new UserStrategyBl_Driver();
		//userStrategyBl_Driver.driveAddStrategy();
		//userStrategyBl_Driver.driveUpdate();
		//userStrategyBl_Driver.driveDelete();
		//userStrategyBl_Driver.driveGetStrategyList();
	}
}
