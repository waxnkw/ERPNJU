package assistant.type;

import java.io.Serializable;
/**
 * @author zhangao 161250193
 * @version 2017.11.8
 * �û�ְλ��ö������
 */
public enum UserPositionEnum implements Serializable {
	MANAGER,//�ܾ���
	WAREKEPPER,//��������Ա
	FINANCE,//������Ա
	ADMIN,//����Ա
	SALESMAN;//������Ա
	
	/**
	 * ����ְλ����(��Ӧ���ݲ��ļ�����)��<br/>
	 * @return String ְλ����
	 */
	public String toString(){
		return this.name().toLowerCase();
	}
}
