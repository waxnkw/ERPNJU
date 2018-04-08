package dataStubs.commodityDataStubs;

import java.util.ArrayList;

import dataService.commodityDataService.GoodsDataService;
import po.GoodsPO;

public class GoodsDataService_Stub implements GoodsDataService{
	public ArrayList<GoodsPO> finds(){
		ArrayList<GoodsPO> allGoods=new ArrayList<GoodsPO>();
		GoodsPO goods=new GoodsPO();
		goods.setName("AAa");
		goods.setNumber("11001");
		goods.setClassification("AA");
		goods.setType("00001A");
		goods.setAmount(100);
		goods.setCostPrice("100");
		goods.setSellingPrice("110");
		goods.setCurrentCostPrice("100");
		goods.setCurrentSellingPrice("110");
		allGoods.add(goods);
		return allGoods;
	}
	public GoodsPO find(String goodsName,String goodsType){
		GoodsPO goods=new GoodsPO();
		goods.setName("AAa");
		goods.setNumber("11001");
		goods.setClassification("AA");
		goods.setType("00001A");
		goods.setAmount(100);
		goods.setCostPrice("100");
		goods.setSellingPrice("110");
		goods.setCurrentCostPrice("100");
		goods.setCurrentSellingPrice("110");
		return goods;
	}
	public GoodsPO find(String goodsTag){
		GoodsPO goods=new GoodsPO();
		goods.setName("AAa");
		goods.setNumber("11001");
		goods.setClassification("AA");
		goods.setType("00001A");
		goods.setAmount(100);
		goods.setCostPrice("100");
		goods.setSellingPrice("110");
		goods.setCurrentCostPrice("100");
		goods.setCurrentSellingPrice("110");
		return goods;
	}
	public boolean insert(GoodsPO po){
		return true;
	}
	public boolean delete(GoodsPO po){
		return true;
	}
	public boolean update(GoodsPO po){
		return true;
	}

}
