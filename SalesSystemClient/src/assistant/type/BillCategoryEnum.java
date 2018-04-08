package assistant.type;
/**
 * @author zhangao 161250193
 * @version 2017.12.12
 * �������͵�ö������
 */
public enum BillCategoryEnum {
	CASH_EXPENSE_BILL//�ֽ���õ�
	,GIFT_BILL//������͵�
	,INVENTORY_LOSS_BILL//��汨��
	,INVENTORY_OVER_BILL//��汨�絥
	,INVENTORY_WARNING_BILL//��汨����
	,PAYMENT_BILL//���
	,PURCHASE_BILL//������
	,PURCHASE_RETURN_BILL//�����˻���
	,RECEIPT_BILL//�տ
	,SALES_BILL//���۵�
	,SALES_RETURN_BILL;//�����˻���
	
	/**
	 * ���ص�ǰ��������(��Ӧ���ݲ��ַ��)��<br/>
	 * @return String ��ǰ�ĵ��ݵ�����(Сд��ĸ����Ӧ����ļ�������)
	 */
	public String toString(){
		return this.name().toLowerCase();
	}
	
	/**
     * �õ��õ��ݵ�Id����
     * ����JHTHD-yyyyMMdd-�е�JHTHD����
     * @return ���ݵ�Id����
     */
	public String toBillIdPart(){
		switch(this){
		case GIFT_BILL:
			return "KCZSD";
		case CASH_EXPENSE_BILL:
			return "XJFYD";
		case INVENTORY_LOSS_BILL:
			return "KCBSD";
		case INVENTORY_OVER_BILL:
			return "KCBYD";
		case INVENTORY_WARNING_BILL:
			return "KCBJD";
		case PAYMENT_BILL:
			return "FKD";
		case RECEIPT_BILL:
			return "SKD";
		case PURCHASE_BILL:
			return "JHD";
		case PURCHASE_RETURN_BILL:
			return "JHTHD";
		case SALES_BILL:
			return "XSD";
		case SALES_RETURN_BILL:
			return "XSTHD";
		default :
			return "wrong";
		}
	}
	
	/**
	 * ���ص�ǰ������������
	 * @return ��������
	 */
	public String toChineseString(){
		switch(this){
		case GIFT_BILL:
			return "������͵�";
		case CASH_EXPENSE_BILL:
			return "�ֽ���õ�";
		case INVENTORY_LOSS_BILL:
			return "��汨��";
		case INVENTORY_OVER_BILL:
			return "��汨�絥";
		case INVENTORY_WARNING_BILL:
			return "��汨����";
		case PAYMENT_BILL:
			return "���";
		case RECEIPT_BILL:
			return "�տ";
		case PURCHASE_BILL:
			return "������";
		case PURCHASE_RETURN_BILL:
			return "�����˻���";
		case SALES_BILL:
			return "���۵�";
		case SALES_RETURN_BILL:
			return "�����˻���";
		default :
			return "����";
		}
	}
}
