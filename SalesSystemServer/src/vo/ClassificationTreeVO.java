package vo;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassificationTreeVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8259693120550886635L;
	private ArrayList<String[]> classificationLayer=new ArrayList<String[]>();
    //classificationLayerÿһ��Ԫ��Ϊһ��String����
    //�������ŵ��Ǹò���������ı�ż����Ƶ�String,��"-"����
	private ArrayList<String[]> sonFatherConnection=new ArrayList<String[]>();
    //sonFatherConnectionÿһ��Ԫ��Ϊһ��String����
    //�������ŵ��Ƕ�Ӧ�Ĳ㸸������һ������Ķ�Ӧ��ϵ
    //����String[] sonToFather=sonFatherConnection.at(0);
    //�������ŵ��ǵ�һ��Ԫ����ڶ���Ԫ�صĶ�Ӧ��ϵ
    //��sonToFather[0]="012"��ʾ
    //��һ���е�һ�������Ӧ�ڶ�����λ��Ϊ0��1��2����������
    public void setClassificationLayer(ArrayList<String[]> classiLayer){
    classificationLayer=classiLayer;
    }
    public void setSonFatherConnection(ArrayList<String[]> connection){
    sonFatherConnection=connection;
    }
    public ArrayList<String[]> getClassificationLayer(){
    return classificationLayer;
    }
    public ArrayList<String[]> getSonFatherConnection(){
    return sonFatherConnection;
    }
}
