package dataImpl.customerData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import assistant.utility.ReadAndWriteTxtUtility;
import dataService.customerDataService.CustomerDataService;
import po.CustomerPO;
import vo.CustomerVO;

/**
 * 
 * @author ����һ 161250140
 * @version 2017.11.21
 */

public class CustomerData implements CustomerDataService, Serializable {

	private static String ROOT_PATH="data"+File.separator+"customer"+File.separator;//��Ŀ¼
	public static String RECORD_PATH="record.txt";//ֻ��ID���������
	
	/**
	 * �����ͻ�
	 * @see dataService.customerDataService.CustomerDataService#insert(po.CustomerPO)
	 * @param CustomerPO po��Ҫ�����Ŀͻ�
	 * @return boolean true��ʾ�ɹ�
	 */
	@Override
	public boolean insert(CustomerPO po){
		// TODO Auto-generated method stub		
		String Id=po.getId();
		if(findRecord(Id)) {//�ͻ��Ѵ��ڣ��Ͳ��ܲ���
			return false;			
		}
		creatRecord(Id);//������¼
		
		String path=ROOT_PATH+po.getId()+".ser";
		ObjectOutputStream oStream;
		
		try {
			oStream=new ObjectOutputStream(new FileOutputStream(path));
			oStream.writeObject(po);
			oStream.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ɾ��һ���ͻ���Ҫ��������ID��ȫƥ��
	 * @see dataService.customerDataService.CustomerDataService#delete(java.lang.String, java.lang.String)
	 * @param Id
	 * @param name
	 * @return boolean true��ʾ�ɹ�
	 */
	@Override
	public boolean delete(String Id, String name){//δ���
		// TODO Auto-generated method stub
		if(!findRecord(Id)) {//��������Ӧ�ͻ�
			return false;
		}
		CustomerPO po=find(Id).get(0);
		if(po.getName().equals(name)) {
			//��ɾ����¼���Id
			ArrayList<String> content=new ArrayList<String>();
			File recordFile=new File(ROOT_PATH+RECORD_PATH);
			try {
				FileInputStream inputStream=new FileInputStream(recordFile);
				BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream));
				String str=null;
				while((str=bf.readLine())!=null) {
					if(!str.equals(Id)) {
						content.add(str);
					}
				}
				
				FileWriter fw=new FileWriter(recordFile);
				fw.write("");
				fw.flush();
				
				inputStream.close();
				bf.close();
				fw.close();
				for(int i=0;i<content.size();i++) {
					creatRecord(content.get(i));
				}
								
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			//ɾ������
			Id+=".ser";
			File dir=new File(ROOT_PATH);
			String[] filesName=dir.list();
			for(int i=0;i<filesName.length;i++) {
				if(Id.equals(filesName[i])) {
					File delFile=new File(ROOT_PATH+Id);
					delFile.delete();
					return true;
				}
			}
		}
		
		return false;
	}

	/**
	 * ����һ���ͻ�����Ϣ
	 * @see dataService.customerDataService.CustomerDataService#update(po.CustomerPO)
	 * @param po
	 * @return boolean true��ʾ�ɹ�
	 */
	@Override
	public boolean update(CustomerPO po) {
		// TODO Auto-generated method stub
		String Id=po.getId();
		if(!findRecord(Id)) {
			return false;
		}else {
			String path=ROOT_PATH+Id+".ser";			
			File delFile=new File(path);
			delFile.delete();
			
			ObjectOutputStream oStream;			
			try {
				oStream = new ObjectOutputStream(new FileOutputStream(path));
				oStream.writeObject(po);
				oStream.close();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}
	}

	/**
	 * ��ѯ�ͻ���Ϣ��֧�ֹؼ��ֲ���
	 * @see dataService.customerDataService.CustomerDataService#find(java.lang.String)
	 * @param name
	 * @return ArrayList<CustomerPO>
	 */
	@Override
	public ArrayList<CustomerPO> find(String name){//�ؼ��ֲ��ң���Id
		// TODO Auto-generated method stub
		//1. �ж��Ƿ���id���ǵĻ����������idFind
		//2. �ؼ���
		//3. ��, ȫ��
		ArrayList<CustomerPO> result=new ArrayList<CustomerPO>();
		boolean none=true;
		int idLength=6;//id 6 λ
		if(name.length()==idLength) {
			if(idFind(name)!=null) {
				result.add(idFind(name));
				return result;
			}
			return null;
			
		}else {//�ؼ���
			if(name.length()==0) {
				result=getAll();
				return result;
			}else {
				File folder=new File(ROOT_PATH);
				String[] filesName=folder.list();
				CustomerPO po=null;
				for(int i=0;i<filesName.length;i++) {
					if(filesName[i].contains(".ser")) {
						po=readInfo(ROOT_PATH+filesName[i]);
						if(po.getName()!=null&&po.getName().contains(name)) {//�����ؼ���
							result.add(po);
							none=false;
						}
					}
				}
				
				if(none) {
					return null;
				}else {
					return result;
				}
			}			
		}
	}

	/**
	 * ����Id���ҿͻ�
	 * @param Id
	 * @return boolean true��ʾ�ɹ�
	 */
	private CustomerPO idFind(String Id) {//ͨ��Id����
		File folder=new File(ROOT_PATH);
		String[] filesName=folder.list();
		String target=Id+".ser";
		for(int i=0;i<filesName.length;i++) {
			if(target.equals(filesName[i])) {
				return readInfo(ROOT_PATH+filesName[i]);
			}
		}
		return null;
	}
	
	/**
	 * �����ͻ�Id��¼�������ѯ
	 * @param Id
	 */
	private void creatRecord(String Id) {//recordֻ��ID
		String path=ROOT_PATH+RECORD_PATH;
		File file=new File(path);
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			String record=Id+System.lineSeparator();
			ReadAndWriteTxtUtility.writeTxtAppend(path, record);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ����Id��ѯ�ͻ��Ƿ����
	 * @param Id
	 * @return boolean, true��ʾ�ɹ�
	 */
	private boolean findRecord(String Id) {//�жϿͻ��Ƿ��Ѵ��ڣ�true��ʾ�Ѵ���
		String path=ROOT_PATH+RECORD_PATH;
		File file=new File(path);
		try {
			if(!file.exists()) {
				return false;
			}
			FileInputStream inputStream=new FileInputStream(file);
			BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream));
			
			String str=null;
			while((str=bf.readLine())!=null) {
				if(str.equals(Id)) {//�ҵ���¼
					inputStream.close();
					bf.close();
					return true;
				}
			}
			inputStream.close();
			bf.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ��ȡ����ԭ�����л�������Ϣ
	 * @param path
	 * @return CustomerPO����
	 */
	private CustomerPO readInfo(String path) {
		CustomerPO po=null;
		ObjectInputStream iStream;
		try {
			iStream=new ObjectInputStream(new FileInputStream(path));
			po=(CustomerPO)iStream.readObject();
			iStream.close();
			return po;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * �õ����пͻ���Ϣ
	 * @see dataService.customerDataService.CustomerDataService#getAll()
	 * @return ArrayList<CustomerPO>
	 */
	@Override
	public ArrayList<CustomerPO> getAll() {
		// TODO Auto-generated method stub
		ArrayList<CustomerPO> result=new ArrayList<CustomerPO>();
		
		File folder=new File(ROOT_PATH);
		String[] filesName=folder.list();
		CustomerPO po=null;
		for(int i=0;i<filesName.length;i++) {
			if(filesName[i].contains(".ser")) {
				po=readInfo(ROOT_PATH+filesName[i]);
				result.add(po);
			}				
		}
		return result;
	}
}


