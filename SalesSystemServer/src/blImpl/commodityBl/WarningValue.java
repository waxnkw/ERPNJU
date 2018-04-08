/**
 * ����ĳ����Ʒ�ľ���ֵ��������Ʒ�����Ŀ����
 * @author BeibeiZhang
 * @version 2017.11.28
 *
 */
package blImpl.commodityBl;

import java.util.ArrayList;

import dataImpl.commodityData.StockInOutRecord;
import po.StockInOutPO;

public class WarningValue {
	public int getWarningValue(String goodsID){
		//��������������%30Ϊ����Ʒ�Ŀ�澯��ֵ,ȡint
		StockInOutRecord stockData=new StockInOutRecord();
		ArrayList<StockInOutPO> stocksOfTheGoods=stockData.finds(goodsID);
		int outAmountTotal=0;
		for(int i=0;i<=stocksOfTheGoods.size()-1;i++){
			StockInOutPO record=stocksOfTheGoods.get(i);
			int stockAmount=record.getAmount();
			if(stockAmount<0){
				outAmountTotal=outAmountTotal+(-stockAmount);
			}
		}
		int warning=(int)(outAmountTotal*0.3);
		return warning;
	}
}
