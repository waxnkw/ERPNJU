package vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ������ϸ��
 * @author guxinyu
 * @version 2017.12.11
 *
 */
public class SalesDetailsListVO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6780583279368261919L;
	private ArrayList<SalesDetailsListSalesBillVO> salesBills;//���۵�
  	
	 public SalesDetailsListVO(ArrayList<SalesDetailsListSalesBillVO> sales){
		setSalesBills(sales);
	}

	public ArrayList<SalesDetailsListSalesBillVO> getSalesBills() {
		return salesBills;
	}

	public void setSalesBills(ArrayList<SalesDetailsListSalesBillVO> salesBills) {
		this.salesBills = salesBills;
	}
	
}
