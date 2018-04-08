package po;

import java.util.ArrayList;

/**
 * gxy����
 * @author Lenovo
 *
 */
public class PurchaseReturnBillPO extends BillPO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerPO supplier;//��Ӧ��
	private int ware;//�ֿ�
	private ArrayList<SalesGoodsPO> goodsList;//�����Ʒ�б�
	private double money;//�ܶ�ϼ�
	
	public PurchaseReturnBillPO(){
		
	}
	
	public PurchaseReturnBillPO(CustomerPO cus, int w, ArrayList<SalesGoodsPO> list,
			double m){
		setSupplier(cus);
		setWare(w);
		setGoodsList(list);
		setMoney(m);
	}

	public CustomerPO getSupplier() {
		return supplier;
	}

	public void setSupplier(CustomerPO supplier) {
		this.supplier = supplier;
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
