package po;

import java.io.Serializable;

import assistant.utility.Date;

//do some changes 2017.11.06
public class StockInOutPO implements Serializable{
	private String operatorName;
	private Date time;
	private String goodsID;
	private String goodsName;
	private String productionDate;
    //������⣬��Ϊ�������ڣ��������⣬���ǲֿ����Ա�ֶ���д
	//��ȻҲ���ڿ�汨�硢���𡢺��ʱ�ĳ���⣬��ʱ��û�г������ڣ���Ϊnull
	private int amount;
    //can be negative
	//positive: stockIN
	//negative:stockOUT
	private String currentCostPrice;
    //�����⣬��Ϊ�ֿ����Ա�ֶ���д��������ۣ�������ۼ���Ϊ0����Ϊnull
	//��ȻҲ���ڿ�汨�����ʱ����⣬��ʱ��û��������ۣ�����Ϊnull
	private String currentSellingPrice;
    //������⣬��Ϊ�ֿ����Ա�ֶ���д��������ۼۣ����������Ϊ0����Ϊnull
	//��ȻҲ���ڿ�汨�����ʱ�ĳ��⣬��ʱ��û��������ۼۣ�����Ϊnull
    public void setOperatorName(String str){
       operatorName=str;
    }
    public void setTime(Date date){
       time=date;
    }
    public void setGoodsID(String str){
        goodsID=str;
     }
    public void setGoodsName(String str){
        goodsName=str;
     }
    public void setAmount(int amoun){
       amount=amoun;
    }
    public void setProductionDate(String productdate){
        productionDate=productdate;
     }
     public void setCurrentCostPrice(String str){
        currentCostPrice=str;
     }
     public void setCurrentSellingPrice(String str){
        currentSellingPrice=str;
     }
    public String getOperatorName(){
       return operatorName;
    }
    public Date getTime(){
       return time;
    }
    public String getGoodsID(){
        return goodsID;
     }
    public String getGoodsName(){
        return goodsName;
     }
    public int getAmount(){
       return amount;
    }
    public String getProductionDate(){
        return productionDate;
     }
     public String getCurrentCostPrice(){
        return currentCostPrice;
     }
     public String getCurrentSellingPrice(){
        return currentSellingPrice;
     }
}