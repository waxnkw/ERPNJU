/**
 * ��Ʒ���ݰ�
 * @author BeibeiZhang
 * @version 2017.11.26
 *
 */
package dataImpl.commodityData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dataService.commodityDataService.GoodsDataService;
import po.GoodsPO;

public class GoodsData implements GoodsDataService{
	private ArrayList<GoodsPO> allGoods=new ArrayList<GoodsPO>();
	private final String lastFilePath="data/goods";

	public ArrayList<GoodsPO> finds(){
		readGoodsPOs();
		return allGoods;
	}

	public ArrayList<GoodsPO> fuzzyFinds(String keyWord){
		//�ؼ�����id���������еĹؼ���
		readGoodsPOs();
		ArrayList<GoodsPO> relatedGoods=new ArrayList<GoodsPO>();
		for(int i=0;i<=allGoods.size()-1;i++){
			GoodsPO good=allGoods.get(i);
			String id=good.getNumber();
			String name=good.getName();
			if(id.equals(keyWord)||name.contains(keyWord)){
				relatedGoods.add(good);
			}
		}
		return relatedGoods;
		//���û�ҵ���Ӧ����Ʒ�����ص�ArrayList��size����0
		//bl��/ui���0�����б𣬵�֪��������Ӧ��goods����ʾ��Ӧ������Ϣ
	}
    public GoodsPO find(String goodsName,String goodsType){
    	readGoodsPOs();
    	GoodsPO targetGoods=new GoodsPO();
    	for(int i=0;i<=allGoods.size()-1;i++){
    		GoodsPO good=allGoods.get(i);
    		String name=good.getName();
    		String type=good.getType();
    		if((name.equals(goodsName))&&(type.equals(goodsType))){
    			return good;
    		}
    	}
    	return null;
    	//���û�ҵ���Ӧ����Ʒ���ͷ���null
        //bl��/ui���null�����б𣬵�֪��������Ӧ��goods����ʾ��Ӧ������Ϣ
        }
	public GoodsPO find(String goodsID){
		readGoodsPOs();
		GoodsPO targetGoods=new GoodsPO();
		for(int i=0;i<=allGoods.size()-1;i++){
			GoodsPO good=allGoods.get(i);
			String number=good.getNumber();
			if(number.equals(goodsID)){
				return good;
			}
		}
		return null;
		//���û�ҵ���Ӧ����Ʒ���ͷ���null
		//bl��/ui���null�����б𣬵�֪��������Ӧ��goods����ʾ��Ӧ������Ϣ
	}
	public boolean insert(GoodsPO po){
		readGoodsPOs();
		allGoods.add(po);
		writeGoodsPOs();
		return true;
	}
	public boolean delete(GoodsPO po){
	    readGoodsPOs();
	    String targetID=po.getNumber();
	    for(int i=0;i<=allGoods.size()-1;i++){
	    	GoodsPO good=allGoods.get(i);
	    	String id=good.getNumber();
	    	if(id.equals(targetID)){
	    		allGoods.remove(i);
	    		writeGoodsPOs();
	    		return true;
	    	}
	    }
		return false;
		//���û�ҵ���Ӧ����Ʒ���ͷ���false
		//bl��/ui���false�����б𣬵�֪��������Ӧ��goods����ʾ��Ӧ������Ϣ
	}
	public boolean update(GoodsPO po){
		readGoodsPOs();
		String number=po.getNumber();
		for(int i=0;i<=allGoods.size()-1;i++){
			GoodsPO good=allGoods.get(i);
			if(number.equals(good.getNumber())){
				allGoods.set(i, po);
				writeGoodsPOs();
				return true;
			}
		}
		return false;
		//���û�ҵ���Ӧ����Ʒ���ͷ���false
		//bl��/ui���false�����б𣬵�֪��������Ӧ��goods����ʾ��Ӧ������Ϣ
	}
	private void readGoodsPOs(){
		allGoods.clear();
		File lastFile=new File(lastFilePath);
		lastFile.mkdirs();
		File[] goodsFiles=lastFile.listFiles();
		if(goodsFiles.length==0){

		}else{
			try{
			for(int i=0;i<=goodsFiles.length-1;i++){
				File goodFile=goodsFiles[i];
				FileInputStream fis=new FileInputStream(goodFile);
				ObjectInputStream ois=new ObjectInputStream(fis);
				GoodsPO good=(GoodsPO)ois.readObject();
				allGoods.add(good);
				ois.close();
				fis.close();
			}
			}catch(ClassNotFoundException e1){
				e1.printStackTrace();
			}catch(FileNotFoundException e2){
				e2.printStackTrace();
			}catch(IOException e3){
				e3.printStackTrace();
			}
		}
	}
	private void writeGoodsPOs(){
		File lastFile=new File(lastFilePath);
		lastFile.mkdirs();
		File[] goodsFiles=lastFile.listFiles();
		if(goodsFiles.length==0){

		}else{
			for(int i=0;i<=goodsFiles.length-1;i++){
				goodsFiles[i].delete();
			}
		}
		String lastFileAbsolutePath=lastFile.getAbsolutePath();
		for(int i=0;i<=allGoods.size()-1;i++){
			try{
			GoodsPO goodObj=allGoods.get(i);
			File goodFile=new File(lastFileAbsolutePath+"/"+goodObj.getNumber());
			goodFile.createNewFile();
			FileOutputStream fos=new FileOutputStream(goodFile);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(goodObj);
			oos.close();
			fos.close();
			}catch(IOException e){
				e.printStackTrace();
			}

		}
	}
}
