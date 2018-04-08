package blStubs.commodityBlStubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blService.commodityBlService.GoodsClassificationBlService;
import vo.ClassificationTreeVO;
import vo.ClassificationVO;
import vo.GoodsVO;

public class GoodsClassificationService_Stub implements GoodsClassificationBlService{
//do some change 2017.10.30
	public ClassificationTreeVO getClassificationTree() throws RemoteException{
		ClassificationTreeVO classificationTree=new ClassificationTreeVO();
		ArrayList<String[]> classificationLayer=new ArrayList<String[]>();
		String[] theFirstLayer={"C01-������1��"};
		String[] theSecondLayer={"C0101-������11��","C0102-������12��"};
		String[] theThirdLayer={"C010101-������111��"};
		classificationLayer.add(theFirstLayer);
		classificationLayer.add(theSecondLayer);
		classificationLayer.add(theThirdLayer);
		ArrayList<String[]> sonFatherConnection=new ArrayList<String[]>();
		String[] firstToSecond={"0 1 2"};
		sonFatherConnection.add(firstToSecond);
		classificationTree.setClassificationLayer(classificationLayer);
		classificationTree.setSonFatherConnection(sonFatherConnection);
		return classificationTree;
	}

	public boolean ifClassificationExist(String classificationTag) throws RemoteException{
		return true;
		//just return true is not suitable for the caller
		//because the caller need the boolen to do the judgement...???
	}
	public boolean addNewClassification(ClassificationVO vo)throws RemoteException{
		return true;
	}
	public ClassificationVO classificationInfor(String classificationNum) throws RemoteException{
		ClassificationVO classification=new ClassificationVO();
		classification.setName("������1��");
		classification.setNumber("C01");
		classification.setFatherClassification(null);
		ArrayList<String> sonClassification=new ArrayList<String>();
		sonClassification.add("C0101-������11��");
		sonClassification.add("C0102-������12��");
		classification.setSonClassification(sonClassification);
		classification.setGoodsList(null);
		return classification;
	}
	public boolean addClassification(ClassificationVO vo) throws RemoteException{
		return true;
	}
	public boolean deleteClassification(ClassificationVO vo) throws RemoteException{
		return true;
	}
	public boolean modifyClassificationInfor(ClassificationVO vo) throws RemoteException{
		return true;
	}

}
