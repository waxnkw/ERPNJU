package assistant.type;

import java.io.Serializable;

/**
 *@author zhangao 161250193
 *@version 2017.11.7
 *�������Ե�����ö��
 */

public enum StrategyCategoryEnum implements Serializable{
	/**
     * USRESTRATEGY �û���������
     * TOTALSTRATEGY �ܼ۴�������
     * COMBOSTRATEGY ��ϴ�������
     */
	USRESTRATEGY,TOTALSTRATEGY,COMBOSTRATEGY;
	public String toString(){
		switch (this) {
		case USRESTRATEGY:
			return "user_strategy";
		case TOTALSTRATEGY:
			return "total_strategy";
		case COMBOSTRATEGY:
			return "combo_strategy";
		default:
			return null;
		}
	}
	
	public String toChineseString(){
		switch (this) {
		case USRESTRATEGY:
			return "�û���������";
		case TOTALSTRATEGY:
			return "�ܼ۴�������";
		case COMBOSTRATEGY:
			return "��ϴ�������";
		default:
			return null;
		}
	}
}
