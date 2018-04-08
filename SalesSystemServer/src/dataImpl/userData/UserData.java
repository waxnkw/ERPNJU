package dataImpl.userData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.exception.CantFindUserException;
import assistant.exception.Myexception;
import assistant.utility.DeleteFileUtility;
import assistant.utility.ReadAndWriteTxtUtility;
import assistant.utility.ReadAndWriteUserPOSerUtility;
import dataService.userDataService.UserDataService;
import po.UserPO;

/**
 * �û�ע��͵�¼
 * @author ����һ 161250140
 * @version 2017.11.23
 */
public class UserData implements UserDataService{
	
	private static final String ROOT_PATH = "data" + File.separator + "user" + File.separator;//��·��
	private static final String RECORD_PATH="data"+File.separator+"user"+File.separator+"record.txt";//����û�����������ļ�
	
	/**
	 * ��ѯ�û���Ա��Ϣ
	 * @param userId �û����˻�Id
	 * @return UserPO �õ����û���ϢPO
	 */
	@Override
	public UserPO getUser(String userId) throws RemoteException,Myexception{
		String path = ROOT_PATH + userId;
		UserPO po = ReadAndWriteUserPOSerUtility.readObj(path);
		if(po==null){throw new CantFindUserException();}
		return po;
	}

	/**
	 * �õ�������Ա��Ϣ
	 * @param userId �û����˻�Id
	 * @return UserPO �õ����û���ϢPO
	 */
	@Override
	public ArrayList<UserPO> getUserList() throws RemoteException{
		ArrayList<UserPO> userPOs = new ArrayList<>();
		String path = ROOT_PATH;
		File file = new File(path);
		String [] usersNames = file.list();
		for(String userPath : usersNames){
			if("record.txt".equals(userPath)){continue;}
			String filePath = path+ userPath;
			UserPO po = ReadAndWriteUserPOSerUtility.readObj(filePath);
			userPOs.add(po);
		}
		return userPOs;
	}
	
	/**
	 * �����û���Ա��Ϣ
	 * @param UserPO user �������û���Ϣ
	 * @return boolean �Ƿ������ɹ�
	 */
	@Override
	public boolean addUser(UserPO user) throws RemoteException{
		String path = ROOT_PATH + user.getId();
		return ReadAndWriteUserPOSerUtility.writeObj(user, path);
	}

	/**
	 * ɾ���û���Ϣ
	 * @param String Id Ҫɾ�����û���Ϣ
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	@Override
	public boolean deleteUser(String Id) throws RemoteException{
		String path = ROOT_PATH + Id;
		//��д ɾ���û���������
		return DeleteFileUtility.deleteFile(path);
	}

	/**
	 * �����û���Ϣ
	 * @param UserPO userҪ���µ��û���Ϣ
	 * @return boolean �Ƿ���³ɹ�
	 * @throws Myexception 
	 */
	@Override
	public boolean updateUser(UserPO user) throws RemoteException, Myexception{
		String path = ROOT_PATH + user.getId();
		//�����ڸ��û����ܹ�����
		//if(getUser(path)==null){
		//	return false;
		//}
		return addUser(user);
	}

	/**
	 * ������Ա�������루�ǵ�һ�ε�¼��
	 * @see dataService.userDataService.UserDataService#changePassword(java.lang.String, java.lang.String, java.lang.String)
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean changePassword(String userId, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		String waitToCompare=userId+">>"+oldPassword;
		String waitToUpdate=userId+">>"+newPassword;
		
		if(!fetch(userId, oldPassword)) {//�����벻��ȷ
			return false;
		}
		
		if(oldPassword.equals(newPassword)) {//������;�������ͬ
			return false;
		}
		
		File file=new File(RECORD_PATH);
		ArrayList<String> content=new ArrayList<String>();
		
		try {
			FileInputStream iStream=new FileInputStream(file);
			BufferedReader bf=new BufferedReader(new InputStreamReader(iStream));
			String str=null;
			
			while((str=bf.readLine())!=null) {
				if(!str.equals(waitToCompare)) {
					content.add(str);
				}
			}
			iStream.close();
			bf.close();
			
			FileWriter fw=new FileWriter(file);
			fw.write("");
			fw.flush();
			fw.close();
			
			content.add(waitToUpdate);
			String input="";
			for(int i=0;i<content.size();i++) {
				input=content.get(i)+System.lineSeparator();
				ReadAndWriteTxtUtility.writeTxtAppend(RECORD_PATH, input);
			}
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ������Աע�᣺Ĭ��������û�����ͬ�����ǲ��ܵ�¼�������������
	 * @see dataService.userDataService.UserDataService#registerUser(java.lang.String, java.lang.String)
	 * @param userId
	 * @param password
	 * @return boolean, true��ʾ�����ɹ�, �����Ҫ������ת����������
	 */
	@Override
	public boolean registerUser(String userId, String password) {
		// TODO Auto-generated method stub
		if(!userId.equals(password)) {
			return false;
		}
		
		boolean valid=fetch(userId, password);
		if(valid) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * �ж��Ƿ�Ϸ��û�
	 * @see dataService.userDataService.UserDataService#isValidUser(java.lang.String, java.lang.String)
	 * @param userId
	 * @param password
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean isValidUser(String userId, String password) {
		// TODO Auto-generated method stub
		if(userId.equals(password)) {//�û�����������ͬ һ���Ǵ��
			return false;
		}
		
		boolean valid=fetch(userId, password);
		if(valid) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * �����жϼ�¼���Ƿ����û��Լ��û������Ƿ���ȷ
	 * @param userId
	 * @param password
	 * @return
	 */
	private boolean fetch(String userId, String password) {
		
		File file=new File(RECORD_PATH);
		try {
			FileInputStream inputStream=new FileInputStream(file);
			BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream));
			
			String str=null;
			String waitToCompare=userId+">>"+password;
			while((str=bf.readLine())!=null) {
				if(str.equals(waitToCompare)) {
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

}
