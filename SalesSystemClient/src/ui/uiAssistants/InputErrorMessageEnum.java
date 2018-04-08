package ui.uiAssistants;

public enum InputErrorMessageEnum {
	Time_Format_Error,//ʱ���ʽ����
	Time_End_Less_Than_Start,//����ʱ��Ϳ�ʼʱ���ͻ
	
	Uncompleted_Error,//δ���
	
	Number_Format_Error,//���ָ�ʽ����
	Number_Out_Of_Bounds;//���ֲ���ȡֵ��Χ
	
	public String getErrorMessage(){
		switch (this) {
		case Time_Format_Error:
			return "��������ȷ��ʽʱ��";
		case Time_End_Less_Than_Start:
			return "����ʱ���뿪ʼʱ���ͻ";
		case Uncompleted_Error:
			return "����";
		case Number_Format_Error:
			return "�����ʽ����";
		case Number_Out_Of_Bounds:
			return "���벻����ȷ��Χ��";
		default:
			return"����û���������û�е�b����";
		}
	}
}
