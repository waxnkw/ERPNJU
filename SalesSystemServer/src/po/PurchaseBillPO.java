package po;

import java.util.ArrayList;

/**
 * gxy����
 * @author Lenovo
 *
 */
public class PurchaseBillPO extends BillPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerPO supplier;//��Ӧ��
	private int ware;//�ֿ�
	private ArrayList<SalesGoodsPO> goodsList;//�����Ʒ�б�
	private double money;//�ܶ�ϼ�
	
	public void setSupplier(CustomerPO supplier) {
		this.supplier = supplier;
	}
	public CustomerPO getSupplier() {
		return supplier;
	}
	public int getWare() {
		return ware;
	}
	public void setWare(int ware) {
		this.ware = ware;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public ArrayList<SalesGoodsPO> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(ArrayList<SalesGoodsPO> goodsList) {
		this.goodsList = goodsList;
	}
}
