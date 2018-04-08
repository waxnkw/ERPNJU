package dataImpl.promotionData;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import assistant.type.StrategyCategoryEnum;
import assistant.utility.DeleteFileUtility;
import assistant.utility.ReadAndWritePromotionPOSerUtility;
import dataService.promotionDataService.PromotionDataService;
import po.BillPO;
import po.ComboStrategyPO;
import po.PromotionStrategyPO;
import po.TotalStrategyPO;
import po.UserStrategyPO;
import vo.ComboStrategyVO;
import vo.PromotionStrategyVO;
import vo.TotalStrategyVO;
import vo.UserStrategyVO;

/**
 * @author zhangao 161250193
 * @version 2017.11.24
 * �������Ե���ɾ�Ĳ�
 */

public class PromotionData implements PromotionDataService{
	
	private static final String ROOT_PATH = "data"+File.separator+"promotion"+File.separator;//��Ŀ¼��ַ
	private static final String USER_STRATEGY_PATH 
		= ROOT_PATH +StrategyCategoryEnum.USRESTRATEGY.toString()
		+File.separator;//�û���������·��
	private static final String TOTAL_STRATEGY_PATH 
		= ROOT_PATH +StrategyCategoryEnum.TOTALSTRATEGY.toString()
		+File.separator;//�û���������·��
	private static final String COMBO_STRATEGY_PATH 
		= ROOT_PATH +StrategyCategoryEnum.COMBOSTRATEGY.toString()
		+File.separator;//�û���������·��
	private static final String FILE_EXTENSION = ".ser";
	
	
	/**
	 * �õ��������е��û����������嵥
	 * @return ArrayList<UserStrategyPO> �û����������嵥
	 */
	@Override
	public ArrayList<UserStrategyPO> getUserStrategyList() {
		ArrayList<UserStrategyPO> list = new ArrayList<UserStrategyPO>();
		String path = USER_STRATEGY_PATH;
		File file = new File(path);
		String[] filesName = file.list();//�����û����������ļ���
		for(String eachFileName:filesName){
			String filePath = path + eachFileName;
			UserStrategyPO po = (UserStrategyPO)readObj(filePath);
			list.add(po);
		}
		return list;
	}

	
	/**
	 * �õ��������е��ܼ۴��������嵥
	 * @return ArrayList<TotalStrategyPO> �ܼ۴��������嵥
	 */
	@Override
	public ArrayList<TotalStrategyPO> getTotalStrategyList() {
		ArrayList<TotalStrategyPO> list = new ArrayList<TotalStrategyPO>();
		String path = TOTAL_STRATEGY_PATH;
		File file = new File(path);
		String[] filesName = file.list();//�����û����������ļ���
		for(String eachFileName:filesName){
			String filePath = path + eachFileName;
			TotalStrategyPO po = (TotalStrategyPO)readObj(filePath);
			list.add(po);
		}
		return list;
	}

	
	/**
	 * �õ��������е��ܼ۴��������嵥
	 * @return ArrayList<TotalStrategyPO> �ܼ۴��������嵥
	 */
	@Override
	public ArrayList<ComboStrategyPO> getComboStrategyList() {
		ArrayList<ComboStrategyPO> list = new ArrayList<ComboStrategyPO>();
		String path = COMBO_STRATEGY_PATH;
		File file = new File(path);
		String[] filesName = file.list();//�����û����������ļ���
		for(String eachFileName:filesName){
			String filePath = path + eachFileName;
			ComboStrategyPO po = (ComboStrategyPO)readObj(filePath);
			list.add(po);
		}
		return list;
	}

	/**
	 * ɾ��ĳһ����������
	 * @param String strategyType ��Ҫ���µĴ������Ե�����
	 * @param String strategyId ��Ҫ���µĴ������Ե�Id
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	@Override
	public boolean deleteStrategy(String strategyType, String strategyId) {
		String path = ROOT_PATH + strategyType + File.separator + strategyId + FILE_EXTENSION; 
		return DeleteFileUtility.deleteFile(path);//ɾ���ļ�
	}

	/**
	 * ���µ�ǰ�Ĵ�������
	 * @param String strategyType ��Ҫ���µĴ������Ե�����
	 * @param String strategyId ��Ҫ���µĴ������Ե�Id
	 * @return boolean �Ƿ���³ɹ�
	 */
	@Override
	public boolean updateStrategy(String strategyType, String strategyId, PromotionStrategyPO newPromotionStrategyPO) {
		String path = ROOT_PATH + strategyType + File.separator + strategyId + FILE_EXTENSION; 
		//System.out.println(path);
		return writeObj(newPromotionStrategyPO, path);
	}

	/**
	 * ����һ���µ��û���������
	 * @param UserStrategyPO strategy �û���������
	 * @return boolean �Ƿ������ɹ�
	 */
	@Override
	public boolean addUserStrategy(UserStrategyPO strategy) {
		String path = "";
		path += USER_STRATEGY_PATH + strategy.getId() + FILE_EXTENSION;
		//System.out.println(path);
		return writeObj(strategy, path);
	}

	/**
	 * ����һ���µ��ܼ۴�������
	 * @param TotalStrategyPO strategy �ܼ۴�������
	 * @return boolean �Ƿ������ɹ�
	 */
	@Override
	public boolean addTotalStrategy(TotalStrategyPO strategy) {
		String path = "";
		path += TOTAL_STRATEGY_PATH + strategy.getId() + FILE_EXTENSION;
		return writeObj(strategy, path);
	}

	/**
	 * ����һ���µ���ϴ�������
	 * @param ComboStrategyPO strategy ��ϴ�������
	 * @return boolean �Ƿ������ɹ�
	 */
	@Override
	public boolean addComboStrategy(ComboStrategyPO strategy) {
		String path = "";
		path += COMBO_STRATEGY_PATH + strategy.getId() + FILE_EXTENSION;
		return writeObj(strategy, path);
	}
	
	/**
	 * дpromotion��ser�ļ���<br/>
	 * @param PromotionStrategyPO promotion ��Ҫд�Ĵ������� 
	 * @return boolean �Ƿ�д�ļ��ɹ�
	 */
	public boolean writeObj(PromotionStrategyPO promotion,String path){
		return ReadAndWritePromotionPOSerUtility.writeObj(promotion, path);
	}
	
	/**
	 * ��ȡһ���������ԡ�<br/>
	 * @param path Ҫ��ȡ�Ĵ�������·��
	 * @return PromotionStrategyPO��ȡ�Ĵ�������
	 */
	public  PromotionStrategyPO readObj(String path){
		return ReadAndWritePromotionPOSerUtility.readObj(path);
	}
}
