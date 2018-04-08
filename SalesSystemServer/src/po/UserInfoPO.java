package po;

import java.io.Serializable;

import assistant.type.UserPositionEnum;

/**
 * UserInfoPO������
 * �����û����ƺ�Id�����ڵ����д�������Ϣ��
 * @author �Ű�  161250193
 * @version 2017.12.1
 */

public class UserInfoPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118414849207336385L;
	private String name;//�û�����
	private String Id;//�û���Id
	private UserPositionEnum userPosition;//�û�ְλ
	
	/**
	 * ���û���Ϣ���û� ���� id ְλ�ıȽϣ��ж��Ƿ���� 
	 * @param UserInfoPO userInfoPOҪ�Ƚϵ��û���Ϣ
	 * @return boolean �����û���Ϣ�Ƿ����
	 */
	public boolean equals(UserInfoPO userInfoPO){
		if(userInfoPO.getId().equals(this.Id)
				&&userInfoPO.getName().equals(this.name)
				&&userInfoPO.getUserPositionEnum()==this.userPosition){
			return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public UserPositionEnum getUserPositionEnum() {
		return userPosition;
	}
	public void setUserPositionEnum(UserPositionEnum userPositionEnum) {
		this.userPosition = userPositionEnum;
	}
	
}
