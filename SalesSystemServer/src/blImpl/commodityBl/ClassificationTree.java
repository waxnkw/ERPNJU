package blImpl.commodityBl;



import java.util.ArrayList;

import dataImpl.commodityData.GoodsClassificationData;
import po.ClassificationPO;
import vo.ClassificationTreeVO;

//2017.11.06  Beibei Zhang
public class ClassificationTree {

	private ArrayList<String[]> layers=new ArrayList<String[]>();
	//ÿ��������+"-"+����
	private ArrayList<String[]> connections=new ArrayList<String[]>();
	//�����������ĸ��ӹ�ϵ����һ��ĸ���Ӧ����һ���n���ӣ��м��á�-������
	//����connection.get(0)��ʾlayer.get(0)��layer.get(1)�Ķ�Ӧ��ϵ
    //connection.get(0)�ĵ�0��Ԫ�������"0-1-2"����layer.get(0)�ĵ�0�ŷ������1���0��1��2�ŷ���Ϊ���ӹ�ϵ
	//connections�����һ���Ȼȫ�ǡ���

	public void getLayersAndConnections(ArrayList<ClassificationPO> fathers){
		//�Ȳ⣬������֮��public����private
		if(fathers.size()==0){

		}else{
		GoodsClassificationData classificationData=new GoodsClassificationData();
		//be used to find the sonPO

		String[] inforOfFathers=new String[fathers.size()];
		for(int i=0;i<=fathers.size()-1;i++){
			ClassificationPO father=fathers.get(i);
			String fatherName=father.getName();
			String fatherNumber=father.getNumber();
			inforOfFathers[i]=fatherNumber+"-"+fatherName;
		}
		layers.add(inforOfFathers);
		ArrayList<ClassificationPO> sons=new ArrayList<ClassificationPO>();
		ArrayList<String> connectionsLis=new ArrayList<String>();
		int sonIndex=0;
		for(int i=0;i<=fathers.size()-1;i++){
			ClassificationPO father=fathers.get(i);
			ArrayList<String> sonClassifications=father.getSonClassifacation();
			String connection="";
			//connection����������������ڸò�������ɣ��á�-������
			//������ʾ��ʱ��Ϳ��Եõ���i�������Ԫ�ص����ڵ�i+1������
			if(sonClassifications==null){

			}else{
			for(int j=0;j<=sonClassifications.size()-1;j++){
				String son=sonClassifications.get(j);
				//son:sonNumber+"-"+sonName
				String[] sonInfors=son.split("-");
				String sonNumber=sonInfors[0];
				ClassificationPO sonPO=classificationData.find(sonNumber);
				sons.add(sonPO);
				connection=connection+String.valueOf(sonIndex)+"-";
				//connection����������������ڸò�������ɣ��á�-������
				sonIndex++;
			}
			}
			//����������û�����࣬��connection="",��ʱ���ڽ��������""��֪�ú�Ԫ����������
			connectionsLis.add(connection);
		}
		String[] connectionsArr=new String[connectionsLis.size()];
		for(int i=0;i<=connectionsLis.size()-1;i++){
			connectionsArr[i]=connectionsLis.get(i);
		}
		connections.add(connectionsArr);
		getLayersAndConnections(sons);
		//�ݹ��������ṹ
		}
	}

	public ClassificationTreeVO setTreeLayerAndConnection(ClassificationTreeVO tree){
		//�Ȳ⣬������֮��public����private
		GoodsClassificationData classificationData=new GoodsClassificationData();
		ArrayList<ClassificationPO> allClassifications=classificationData.finds();
		ArrayList<ClassificationPO> roots=new ArrayList<ClassificationPO>();
		ArrayList<ClassificationPO> fathers=new ArrayList<ClassificationPO>();
		ArrayList<ClassificationPO> sons=new ArrayList<ClassificationPO>();
		for(int i=0;i<=allClassifications.size()-1;i++){
			ClassificationPO classification=allClassifications.get(i);
			String father=classification.getFatherClassification();
			if(father==null){
				roots.add(classification);
			}
			}
        layers.clear();
        connections.clear();
        getLayersAndConnections(roots);
        tree.setClassificationLayer(layers);
        tree.setSonFatherConnection(connections);
		return tree;
	}

	public ClassificationTreeVO getTree(){
        ClassificationTreeVO classificationTree=new ClassificationTreeVO();
        classificationTree=setTreeLayerAndConnection(classificationTree);
		return classificationTree;
	}

}
