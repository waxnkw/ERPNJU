package dataDrivers.promotionDataDrivers;

import java.util.ArrayList;

import assistant.type.StrategyCategoryEnum;
import dataImpl.promotionData.PromotionData;
import dataService.promotionDataService.PromotionDataService;
import po.ComboStrategyPO;
import po.TotalStrategyPO;
import po.UserStrategyPO;

/**
 * @author zhangao 161250193
 * @version 2017.11.25
 * ������������PromotionDataService����������
 */


public class PromotionDataService_Driver{

	PromotionDataService promotionDataService =  new PromotionData();
	
	/**
	 * �������������û��������Է���
	 */
	private void driveAddUserStrategy(){
		UserStrategyPO po = new UserStrategyPO();
		po.setId("2017-1125-10-38");
		po.setName("�������û���������1");
		promotionDataService.addUserStrategy(po);
		
		UserStrategyPO po1 = new UserStrategyPO();
		po1.setId("2017-1125-10-39");
		po1.setName("�������û���������2");
		promotionDataService.addUserStrategy(po1);
		
		UserStrategyPO po2 = new UserStrategyPO();
		po2.setId("2017-1125-10-40");
		po2.setName("�������û���������3");
		promotionDataService.addUserStrategy(po2);
		System.out.println("driveAddUserStrategy���Խ���");
	}
	
	/**
	 * �������������ܼ۴������Է���
	 */
	private void driveAddTotalStrategy(){
		TotalStrategyPO po = new TotalStrategyPO();
		po.setId("2017-1125-10-38");
		po.setName("�������ܼ۴�������1");
		promotionDataService.addTotalStrategy(po);
		System.out.println("driveAddTotalStrategy���Խ���");
	}
	
	/**
	 * ��������������ϴ������Է���
	 */
	private void driveAddComboStrategy(){
		ComboStrategyPO po = new ComboStrategyPO();
		po.setId("2017-1125-10-38");
		po.setName("�������ܼ۴�������1");
		promotionDataService.addComboStrategy(po);
		System.out.println("driveAddComboStrategy���Խ���");
	}
	
	/**
	 * ��������ɾ���������Է���
	 */
	private void driveDeleteStrategy(){
		promotionDataService.deleteStrategy(
				StrategyCategoryEnum.USRESTRATEGY.toString(),"2017-1125-10-38");
		
	}
	
	/**
	 * �����������´������Է���
	 */
	private void driveUpdateStrategy(){
		UserStrategyPO po = new UserStrategyPO();
		po.setId("2017-1125-10-38");
		po.setName("�������û���������update1");
		promotionDataService.updateStrategy(StrategyCategoryEnum.USRESTRATEGY.toString(),po.getId(),po);
	}
	
	
	/**
	 * ���������õ����������û����Է���
	 */
	private void driveGetUserStrategyList(){
		ArrayList<UserStrategyPO> list = promotionDataService.getUserStrategyList();
		for(UserStrategyPO po:list){
			System.out.println(po.getName());
		}
	}
	
	public static void main(String [] args){
		PromotionDataService_Driver promotionDataService_Driver 
			= new PromotionDataService_Driver();
		//promotionDataService_Driver.driveAddUserStrategy();
		//promotionDataService_Driver.driveAddComboStrategy();
		//promotionDataService_Driver.driveAddTotalStrategy();
		//promotionDataService_Driver.driveDeleteStrategy();
		//promotionDataService_Driver.driveUpdateStrategy();
		//promotionDataService_Driver.driveGetUserStrategyList();
	}
}
