package commodityTest.commodityDataTest;

import java.util.ArrayList;

import dataImpl.commodityData.GoodsClassificationData;
import po.ClassificationPO;

public class TestGoodsClassificationData {
 private void testInsert(){
	 ClassificationPO classification1=new ClassificationPO();
	 classification1.setName("ӫ�ⱴ����");
	 classification1.setNumber("C0102");
	 classification1.setFatherClassification("C01-������");
	 classification1.setSonClassification(null);
	 classification1.setGoodsList(null);

/*	 ClassificationPO classification2=new ClassificationPO();
	 classification2.setName("������11��");
	 classification2.setNumber("C0101");
	 classification2.setFatherClassification("C01-������1��");
	 ArrayList<String> sons2=new ArrayList<String>();
	 sons2.add("C010101-������111��");
	 classification2.setSonClassification(sons2);
	 classification2.setGoodsList(null);

	 ClassificationPO classification3=new ClassificationPO();
	 classification3.setName("������12��");
	 classification3.setNumber("C0102");
	 classification3.setFatherClassification("C01-������1��");
	 classification3.setSonClassification(null);
	 classification3.setGoodsList(null);

	 ClassificationPO classification4=new ClassificationPO();
	 classification4.setName("������111��");
	 classification4.setNumber("C010101");
	 classification4.setFatherClassification("C0101-������11��");
	 classification4.setSonClassification(null);
	 ArrayList<String> goods=new ArrayList<String>();
	 goods.add("G01010101-���䱴����-T0001");
	 goods.add("G01010102-���䱴����-T0002");
	 goods.add("G01010103-�ǿձ�����-T0001");
	 goods.add("G01010104-���ͱ�����-T0001");
	 goods.add("G01010105-ӫ�ⱴ����-T0001");
	 //�ͺţ�T+��λʮ��������ͬһ�����ֵ���ͬ�ͺţ����ɲ�ͬ����Ʒ
	 classification4.setGoodsList(goods);
*/
	 GoodsClassificationData data=new GoodsClassificationData();
	 data.insert(classification1);
	 /*
	 data.insert(classification2);
	 data.insert(classification3);
	 data.insert(classification4);
	 */
 
 }

 public void testFinds(){
	 GoodsClassificationData data=new GoodsClassificationData();
	 ArrayList<ClassificationPO> classifications=data.finds();
	 if(classifications.size()==0){
		 System.out.println("There are no classifications.");
	 }else{
		 for(int i=0;i<=classifications.size()-1;i++){
			 ClassificationPO classification=classifications.get(i);
			 System.out.println("name: "+classification.getName());
			 System.out.println("id: "+classification.getNumber());
			 if(classification.getFatherClassification()==null){
				 System.out.println("fatherClassificationId: "+"");
				 System.out.println("fatherClassificationName: "+"");

			 }else{
			 System.out.println("fatherClassificationId: "+classification.getFatherClassification().split("-")[0]);
			 System.out.println("fatherClassificationName: "+classification.getFatherClassification().split("-")[1]);
			 }
			 if(classification.getSonClassifacation()==null){
				 System.out.println("There are no son classifications.");
			 }else{
				 ArrayList<String> sons=classification.getSonClassifacation();
				 for(int j=0;j<=sons.size()-1;j++){
					 System.out.println("son:"+sons.get(j));
				 }
			 }
			 if(classification.getGoodsList()==null){
				 System.out.println("There are no goods.");
			 }else{
				 ArrayList<String> goods=classification.getGoodsList();
				 for(int k=0;k<=goods.size()-1;k++){
					 System.out.println("goods:"+goods.get(k));
				 }
			 }
			 System.out.println();
		 }
	 }
 }
 public void testFind(String tag){
	 GoodsClassificationData data=new GoodsClassificationData();
	 ClassificationPO classification=data.find(tag);
	 System.out.println("name: "+classification.getName());
	 System.out.println("id: "+classification.getNumber());
	 if(classification.getFatherClassification()==null){
		 System.out.println("fatherClassificationId: "+"");
		 System.out.println("fatherClassificationName: "+"");

	 }else{
	 System.out.println("fatherClassificationId: "+classification.getFatherClassification().split("-")[0]);
	 System.out.println("fatherClassificationName: "+classification.getFatherClassification().split("-")[1]);
	 }
	 if(classification.getSonClassifacation()==null){
		 System.out.println("There are no son classifications.");
	 }else{
		 ArrayList<String> sons=classification.getSonClassifacation();
		 for(int j=0;j<=sons.size()-1;j++){
			 System.out.println("son:"+sons.get(j));
		 }
	 }
	 if(classification.getGoodsList()==null){
		 System.out.println("There are no goods.");
	 }else{
		 ArrayList<String> goods=classification.getGoodsList();
		 for(int k=0;k<=goods.size()-1;k++){
			 System.out.println("goods:"+goods.get(k));
		 }
	 }
	 System.out.println();

 }
 public void testDelete(){
	 ClassificationPO classification=new ClassificationPO();
	 classification.setName("������11��");
	 classification.setNumber("C0101");
	 classification.setFatherClassification("C01-������1��");
	 ArrayList<String> sons2=new ArrayList<String>();
	 sons2.add("C010101-������111��");
	 classification.setSonClassification(sons2);
	 classification.setGoodsList(null);

	 GoodsClassificationData data=new GoodsClassificationData();
	 data.delete(classification);
 }
 public void testUpdate(){
	 ClassificationPO classification=new ClassificationPO();
	 classification.setName("������2��");
	 classification.setNumber("C01");
	 classification.setFatherClassification(null);
	 ArrayList<String> sons2=new ArrayList<String>();
	 sons2.add("C0101-������11��");
	 classification.setSonClassification(sons2);
	 classification.setGoodsList(null);
	 GoodsClassificationData data=new GoodsClassificationData();
	 data.update(classification);
 }
 public static void main(String[] args){
    TestGoodsClassificationData test=new TestGoodsClassificationData();
    test.testInsert();
    test.testFinds();
  //  test.testFind("C00");
  //  test.testDelete();
  //  test.testUpdate();
  //  test.testFinds();
 }
}
