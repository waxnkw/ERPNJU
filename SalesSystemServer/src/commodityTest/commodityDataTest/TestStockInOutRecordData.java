package commodityTest.commodityDataTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;

import assistant.utility.Date;
import dataImpl.commodityData.StockInOutRecord;
import po.StockInOutPO;

public class TestStockInOutRecordData {
public void testInsert(){
	StockInOutPO stock1=new StockInOutPO();
	stock1.setAmount(200);
	stock1.setCurrentCostPrice("500");
	stock1.setCurrentSellingPrice(null);
	stock1.setGoodsID("G010201");
	stock1.setGoodsName("ԭ��ɫӫ�ⱴ����");
	stock1.setOperatorName("zbb");
	stock1.setProductionDate("2017-12-12");
	try{
	Date date1=new Date("2018-01-02_16:24:34");
	//yyyy-MM-dd_HH:mm:ss
	stock1.setTime(date1);
	}catch(ParseException e){
		System.out.println("��ʽ����");
	}

/*	StockInOutPO stock2=new StockInOutPO();
	stock2.setAmount(-50);
	stock2.setCurrentCostPrice(null);
	stock2.setCurrentSellingPrice("700");
	stock2.setGoodsID("G010201");
	stock2.setGoodsName("ԭ��ɫӫ�ⱴ����");
	stock2.setOperatorName("zbb");
	stock2.setProductionDate("2018-1-2");
	try{
	Date date2=new Date("2018-01-02_19:37:12");
	//yyyy-MM-dd_HH:mm:ss
	stock2.setTime(date2);
	}catch(ParseException e){
		System.out.println("��ʽ����");
	}

/*	StockInOutPO stock3=new StockInOutPO();
	stock3.setAmount(10);
	stock3.setCurrentCostPrice("100");
	stock3.setCurrentSellingPrice(null);
	stock3.setGoodsID("G01010104");
	stock3.setGoodsName("���ͱ�����");
	stock3.setOperatorName("zbb");
	stock3.setProductionDate(null);
	try{
	Date date3=new Date("2017-12-20_18:00:00");
	//yyyy-MM-dd_HH:mm:ss
	stock3.setTime(date3);
	}catch(ParseException e){
		System.out.println("��ʽ����");
	}

	StockInOutPO stock4=new StockInOutPO();
	stock4.setAmount(-10);
	stock4.setCurrentCostPrice(null);
	stock4.setCurrentSellingPrice("200");
	stock4.setGoodsID("G01010105");
	stock4.setGoodsName("ӫ�ⱴ����");
	stock4.setOperatorName("zbb");
	stock4.setProductionDate(null);
	try{
	Date date4=new Date("2017-12-19_23:00:00");
	//yyyy-MM-dd_HH:mm:ss
	stock4.setTime(date4);
	}catch(ParseException e){
		System.out.println("��ʽ����");
	}
*/
	StockInOutRecord records=new StockInOutRecord();
	records.insert(stock1);
//	records.insert(stock2);
//	records.insert(stock3);
//	records.insert(stock4);
}
public void testFinds(String id){
	StockInOutRecord records=new StockInOutRecord();
	ArrayList<StockInOutPO> stocks=records.finds(id);
	if(stocks.size()==0){
		System.out.println("There are no stocks about the goods!");
	}else{
		for(int i=0;i<=stocks.size()-1;i++){
			StockInOutPO stock=stocks.get(i);
			System.out.println("name: "+stock.getGoodsName());
			System.out.println("ID: "+stock.getGoodsID());
			System.out.println("amount: "+stock.getAmount());
			System.out.println("currentSelling: "+stock.getCurrentSellingPrice());
			System.out.println("currentCost: "+stock.getCurrentCostPrice());
			System.out.println("productionDate: "+stock.getProductionDate());
			System.out.println("operator: "+stock.getOperatorName());
			System.out.println("time: "+stock.getTime().getDate());
			System.out.println();
		}
	}
}
public void testFinds(Date begin,Date end){
	StockInOutRecord records=new StockInOutRecord();
	ArrayList<StockInOutPO> stocks=records.finds(begin,end);
	if(stocks.size()==0){
		System.out.println("There are no stocks about the goods!");
	}else{
		for(int i=0;i<=stocks.size()-1;i++){
			StockInOutPO stock=stocks.get(i);
			System.out.println("name: "+stock.getGoodsName());
			System.out.println("ID: "+stock.getGoodsID());
			System.out.println("amount: "+stock.getAmount());
			System.out.println("currentSelling: "+stock.getCurrentSellingPrice());
			System.out.println("currentCost: "+stock.getCurrentCostPrice());
			System.out.println("productionDate: "+stock.getProductionDate());
			System.out.println("operator: "+stock.getOperatorName());
			System.out.println("time: "+stock.getTime().getDate());
			System.out.println();

	/*		if(stock.getAmount()<0){
				stocks.get(i).setCurrentCostPrice(null);
			}else{
				stocks.get(i).setCurrentSellingPrice(null);
			}*/
		}
/*		File lastFile=new File("data/stocks2");
		lastFile.mkdirs();
		File[] stockFiles=lastFile.listFiles();
		if(stockFiles.length==0){

		}else{
			for(int i=0;i<=stockFiles.length-1;i++){
				stockFiles[i].delete();
			}
		}
		String lastFileAbsolutePath=lastFile.getAbsolutePath();
		for(int i=0;i<=stocks.size()-1;i++){
			StockInOutPO stock=stocks.get(i);
			String time=stock.getTime().getDate();
			String stockFileName=time.replace(':', '-');
			//��ʱ����Ϊstock�ļ������֣���������ͬһ��ͬʱ��������������Բ�����ֳ�ͻ
			//ע���ļ����в��ܳ���":"
			//ע���ļ��������������㰴������Ⱥ��������л��ļ����Զ���ʱ������ģ�
			try{
			File stockFile=new File(lastFileAbsolutePath+"/"+stockFileName);
			stockFile.createNewFile();
			FileOutputStream fos=new FileOutputStream(stockFile);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(stock);
			oos.close();
			fos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}*/
	}
}
/*public void testFinds(){
	StockInOutRecord records=new StockInOutRecord();
	ArrayList<StockInOutPO> stocks=records.finds();
	if(stocks.size()==0){
		System.out.println("There are no stocks about the goods!");
	}else{
		for(int i=0;i<=stocks.size()-1;i++){
			StockInOutPO stock=stocks.get(i);
			System.out.println("name: "+stock.getGoodsName());
			System.out.println("ID: "+stock.getGoodsID());
			System.out.println("amount: "+stock.getAmount());
			System.out.println("currentSelling: "+stock.getCurrentSellingPrice());
			System.out.println("currentCost: "+stock.getCurrentCostPrice());
			System.out.println("productionDate: "+stock.getProductionDate());
			System.out.println("operator: "+stock.getOperatorName());
			System.out.println("time: "+stock.getTime().getDate());
			System.out.println();
		}
	}
}*/
public static void main(String[] args){
	TestStockInOutRecordData test=new TestStockInOutRecordData();
//	test.testInsert();
	try{
		Date begin=new Date("2017-12-17_15:00:00");
		Date end=new Date("2018-1-2_23:00:00");
		test.testFinds(begin, end);
	}catch(ParseException e){
		System.out.println("ʱ���ʽ����");
	}

//	test.testFinds("G010201");
//	test.testFinds("G00000000");
}
}
