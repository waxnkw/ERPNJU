package po;

/**
 * gxy����
 * @author Lenovo
 *
 */
public class SalesGoodsPO {
	private String goodsId;
	private String goodsName;
	private String goodsType;
	private int number;
	private double unitPrice;
	private double sum;
	private String comment;
	
	public SalesGoodsPO(){
		
	}
	
	public SalesGoodsPO(String id, String name, String type, int num,
			double price, double s, String com){
		setGoodsId(goodsId);
		setGoodsName(name);
		setGoodsType(type);
		setNumber(num);
		setUnitPrice(price);
		setSum(s);
		setComment(com);
	}
	
	public String getGoodsId() {
		return goodsId;
	}
	
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public String getGoodsType() {
		return goodsType;
	}
	
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getSum() {
		return sum;
	}
	
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
}
