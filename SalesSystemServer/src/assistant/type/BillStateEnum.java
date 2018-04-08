package assistant.type;

import java.io.Serializable;
/**
 * @author zhangao 161250193
 * @version 2017.11.8
 * ����״̬��ö������
 */
public enum BillStateEnum implements Serializable {
	DONE,//����ͨ�������
	DENIED,//������ͨ��
	TODO,//����ͨ����δ���
	TBD,//������
	HIDDEN,//����ͨ����ͨ��ʱ�����м�ɾ����������ʾ
	DRAFT;//�ݸ�״̬
	
	/**
	 * ���ص�ǰ����״̬(��Ӧ���ݲ��ļ�����)��<br/>
	 * @return String ��ǰ�ĵ��ݵ�״̬(Сд��ĸ����Ӧ����ļ�������)
	 */
	public String toString(){
		return this.name().toLowerCase();
	}
}
