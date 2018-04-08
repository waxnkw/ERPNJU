package vo;

import java.io.Serializable;

/**
 * ���ڴ洢������ϸ���е����۵�����Ϣ��VO
 * @author guxinyu
 * @version 2017.12.18
 *
 */
public class SalesDetailsListSalesBillVO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6497992795878332476L;
	//������Ҫ��ʾ����Ϣ
		private String date;//����
		private String commodityName;//��Ʒ����
		private String commodityType;//��Ʒ����
		private String number;//����
		private String unitPrice;//����
		private String sum;//�ܶ�
		
		//�����ϲ���ʾ��ɸѡ������Ҫ�е���Ϣ
		private String customerId;//�ͻ�
		private String operatorId;//ҵ��Ա
		private String ware;//�ֿ�
		
		private String billId;
		
		public SalesDetailsListSalesBillVO(){
			
		}
		
		public SalesDetailsListSalesBillVO(String d, String comName, String comType, 
				String num, String uPrice, String s, String cus, String opter, 
				String w, String bId){
			setDate(d);
			setCommodityName(comName);
			setCommodityType(comType);
			setNumber(num);
			setUnitPrice(uPrice);
			setSum(s);
			setCustomerId(cus);
			setOperatorId(opter);
			setWare(w);
			setBillId(bId);
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getCommodityName() {
			return commodityName;
		}

		public void setCommodityName(String commodityName) {
			this.commodityName = commodityName;
		}

		public String getCommodityType() {
			return commodityType;
		}

		public void setCommodityType(String commodityType) {
			this.commodityType = commodityType;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(String unitPrice) {
			this.unitPrice = unitPrice;
		}

		public String getSum() {
			return sum;
		}

		public void setSum(String sum) {
			this.sum = sum;
		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customer) {
			this.customerId = customer;
		}

		public String getOperatorId() {
			return operatorId;
		}

		public void setOperatorId(String operator) {
			this.operatorId = operator;
		}

		public String getWare() {
			return ware;
		}

		public void setWare(String ware) {
			this.ware = ware;
		}

		public String getBillId() {
			return billId;
		}

		public void setBillId(String billId) {
			this.billId = billId;
		}
}
