/**
 * ���ò����check��������������������
 * @author BeibeiZhang
 * @version 2017.11.28
 *
 */
package blImpl.commodityBl;

import java.text.DecimalFormat;
import java.util.ArrayList;

import assistant.utility.Date;
import dataImpl.commodityData.GoodsData;
import dataImpl.commodityData.StockInOutRecord;
import po.GoodsPO;
import po.StockInOutPO;
import vo.InventoryCheckSheetVO;
import vo.StockCheckSheetVO;

public class CheckSheet {
	/**
	 * public StockCheckSheetVO getStockCheckSheet(Date beginTime,Date endTime)
	 * @param1 Date:beginTime
	 * @param2 Date:endTime
	 * @return StockCheckSheetVO which has been set
	 * @version 2017.11.28
	 * @comment String[]:name ID time stock-in-amount cost-money stock-out-amount selling-money
	 *
	 */
	public StockCheckSheetVO getStockCheckSheet(Date beginTime,Date endTime){
		StockInOutRecord stockData=new StockInOutRecord();
		ArrayList<StockInOutPO> stockRecords=stockData.finds(beginTime, endTime);
		ArrayList<String[]> stockCheckContents=new ArrayList<String[]>();
		int stockInAmount=0;
		int addAmount=0;
		int stockOutAmount=0;
		int deleteAmount=0;
		double stockInMoney=0.0;
		double addMoney=0.0;
		double stockOutMoney=0.0;
		double deleteMoney=0.0;
	    for(int i=0;i<=stockRecords.size()-1;i++){
        	String[] contents=new String[8];

        	//contents[8]:name ID productionDate time  stock-in-amount cost-money stock-out-amount selling-money

        	StockInOutPO oneRecord=stockRecords.get(i);
        	contents[0]=oneRecord.getGoodsName();
        	contents[1]=oneRecord.getGoodsID();
        	contents[2]=oneRecord.getProductionDate();
        	contents[3]=(oneRecord.getTime()).getDate();
        	int stockAmount=oneRecord.getAmount();
        	if(stockAmount<0){
        		contents[4]=null;
        		contents[5]=null;
        		contents[6]=String.valueOf(-stockAmount);
        		contents[7]=oneRecord.getCurrentSellingPrice();
                String price=oneRecord.getCurrentSellingPrice();
                 if(oneRecord.getProductionDate()==null){
                	//�����������û��Ļ�����ζ���ǿ�汨����磬���ڷǽ����Եļ��ٻ�������Ʒ��������
                	deleteAmount=(-stockAmount)+deleteAmount;
                	deleteMoney=deleteMoney+(-stockAmount)*Double.parseDouble(price);
                }else{
        		stockOutAmount=(-stockAmount)+stockOutAmount;
        		stockOutMoney=stockOutMoney+(-stockAmount)*Double.parseDouble(price);
                }
        	}else{
        		contents[6]=null;
        		contents[7]=null;
        		contents[4]=String.valueOf(stockAmount);
        		contents[5]=oneRecord.getCurrentCostPrice();
        		String price=oneRecord.getCurrentCostPrice();
        		if(oneRecord.getProductionDate()==null){
        			//�����������û��Ļ�����ζ���ǿ�汨����磬���ڷǽ����Եļ��ٻ�������Ʒ��������
                	addAmount=stockAmount+addAmount;
                	addMoney=addMoney+stockAmount*Double.parseDouble(price);
        		}else{
        		stockInAmount=stockAmount+stockOutAmount;
        		stockInMoney=stockInMoney+stockAmount*Double.parseDouble(price);
        		}
        }
        	stockCheckContents.add(contents);
	    }
	    DecimalFormat df= new DecimalFormat("#.00");
	    String[] buzinessInAll=new String[4];
	    buzinessInAll[0]=String.valueOf(stockInAmount);
	    buzinessInAll[1]=String.valueOf(df.format(stockInMoney));
	    buzinessInAll[2]=String.valueOf(stockOutAmount);
	    buzinessInAll[3]=String.valueOf(df.format(stockOutMoney));
	    stockCheckContents.add(buzinessInAll);
	    //stockCheckContents�ĵ����ڶ�������Ϊ�����Գ������ֵ�������ۻ��Եĳ���⣩
	    //stockInAmount��stockInMoney��stockOutAmount��stockOutMoney

	    String[] notBuzinessInAll=new String[4];
	    notBuzinessInAll[0]=String.valueOf(addAmount);
	    notBuzinessInAll[1]=String.valueOf(df.format(addMoney));
	    notBuzinessInAll[2]=String.valueOf(deleteAmount);
	    notBuzinessInAll[3]=String.valueOf(df.format(deleteMoney));
	    stockCheckContents.add(notBuzinessInAll);
	    //stockCheckContents�����һ������Ϊ�ǽ����Գ������ֵ������汨�硢�����Եĳ���⣩
	    //addAmount��addMoney��deleteAmount��deleteMoney
	    //stockCheckContents��size������2
	    StockCheckSheetVO stoCheckSh=new StockCheckSheetVO();
		stoCheckSh.setStockCheckSheet(stockCheckContents);
		return stoCheckSh;
	}

	/**
	 * public ArrayList<String[]> getInventoryCheckSheet()
	 * @param null
	 * @return InventoryCheckSheetVO which has been set
	 * @version 2017.11.28
	 * @comment String[]:id name type amount averagePrice productionDate
	 */

	public InventoryCheckSheetVO getInventoryCheckSheet(){
		GoodsData goodsData=new GoodsData();
		ArrayList<GoodsPO> allGoods=goodsData.finds();
		ArrayList<String[]> inventoryCheckContents=new ArrayList<String[]>();
		for(int i=0;i<=allGoods.size()-1;i++){
			GoodsPO good=allGoods.get(i);
			String[] contents=new String[6];
			//contents[6]:id name type amount averagePrice productionDate
			contents[0]=good.getNumber();
			contents[1]=good.getName();
			contents[2]=good.getType();
			contents[3]=String.valueOf(good.getAmount());
			contents[4]=String.valueOf(getAveragePrice(good.getNumber()));
			contents[5]=getProductionDate(good.getNumber());
			inventoryCheckContents.add(contents);
		}
		InventoryCheckSheetVO inCheckSh=new InventoryCheckSheetVO();
		inCheckSh.setInventoryCheckSheet(inventoryCheckContents);
		return inCheckSh;
	}

	/**
	 * private int getAveragePrice(String goodsID)
	 * @param String:goodsID
	 * @return the averagePrice of the goods
	 * @version 2017.11.28
	 * @comment via calculating the average of the prices of all stocks of the goods
	 */
	public int getAveragePrice(String goodsID){
		//������֮��public��Ϊprivate
		//ƽ��ֵ����ȡ��������int��������double
		StockInOutRecord stockData=new StockInOutRecord();
		ArrayList<StockInOutPO> recordsOfTheGoods=stockData.finds(goodsID);
		int num=0;
		double sum=0.0;
		for(int i=0;i<=recordsOfTheGoods.size()-1;i++){
			StockInOutPO record=recordsOfTheGoods.get(i);
			String cuCostPriceStr=record.getCurrentCostPrice();
			String cuSellingPriceStr=record.getCurrentSellingPrice();
			if(cuCostPriceStr!=null){
			double cuCostPrice=Double.parseDouble(cuCostPriceStr);
			sum=sum+cuCostPrice;
			num++;
			}else{
				if(cuSellingPriceStr!=null){
                    double cuSellingPrice=Double.parseDouble(cuSellingPriceStr);
					sum=sum+cuSellingPrice;
					num++;
				}
			}
		}
		int average=0;
		if(num==0){
			//num==0��ζ�Ÿ���Ʒû�г�����¼����ô�͸�������ʼ�Ľ��ۺ����ۼۼ���ƽ��ֵ��
			GoodsData goodsData=new GoodsData();
			GoodsPO theGoods=goodsData.find(goodsID);
			String costPriceStr=theGoods.getCostPrice();
			String sellingPriceStr=theGoods.getSellingPrice();
			double sellingPrice=0.0;
			double costPrice=0.0;
			if(costPriceStr==null){
				if(sellingPriceStr==null){
					average=0;
				}else{
					sellingPrice=Double.parseDouble(sellingPriceStr);
					average=(int)sellingPrice;
				}
			}else{
				if(sellingPriceStr==null){
					costPrice=Double.parseDouble(costPriceStr);
					average=(int)costPrice;
				}else{
					sellingPrice=Double.parseDouble(sellingPriceStr);
					costPrice=Double.parseDouble(costPriceStr);
					average=(int)((sellingPrice+costPrice)/2);
				}
			}
		}else{
			average=(int)(sum/num);
		}
		return average;
	}

	/**
	 * private String getProductionDate(String goodsID)
	 * @param String:goodsID
	 * @return the productionDate of the goods
	 * @version 2017.11.28
	 * @comment actually productionDate is not the property of GoodsPO
	 * but it is the property of every stockRecord
	 * so i get the newest productionDate of the stocks of the goods
	 */
	public String getProductionDate(String goodsID){
		StockInOutRecord stockData=new StockInOutRecord();
		ArrayList<StockInOutPO> recordsOfTheGoods=stockData.finds(goodsID);
		String recentProductionDate="";
		for(int i=recordsOfTheGoods.size()-1;i>=0;i--){
			//��������Ʒ�ĳ�����¼���ܿ����ѡ�����µĳ������ڷ���
			//Ĭ�����³�����������������Ҳ�����µ�
		    StockInOutPO record=recordsOfTheGoods.get(i);
		    String productionDate=record.getProductionDate();
		    if(productionDate!=null){
		    	recentProductionDate=productionDate;
		    	return recentProductionDate;
		    }
		}
		return null;
		//�������null��ζ�Ÿ���Ʒ�ĳ�����¼��û�г������ڣ��������ǲ����ܵ�
		//���߸���Ʒû�г�����¼����������Ҳ�ǲ����ܵ�
		//�������ķ���null������Ϊnull����ui�Ͼ���ʾ��
	}
}
