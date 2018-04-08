/**
 * �ֿ����Ա������Ʒ��Ϣ�������
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package ui.commodityUi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blService.commodityBlService.GoodsInforBlService;
import blStubs.commodityBlStubs.GoodsClassificationService_Stub;
import blStubs.commodityBlStubs.GoodsInforService_Stub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rmi.remoteHelper.CommodityRemoteHelper;
import ui.uiAssistants.StageSize;
import vo.GoodsVO;

public class GoodsInforManagementUiController {
	@FXML private TextField goodsTag;

	private Stage currentStage;
	private GoodsVO theGoods;

	public void setStage(Stage stage){
		currentStage=stage;
	}
	@FXML protected void confirmGoodsTag(){
		String keyWord=goodsTag.getText();
		ArrayList<GoodsVO> relatedGoods=new ArrayList<GoodsVO>();
		try{
		GoodsInforBlService goodsInforSer=CommodityRemoteHelper.getInstance().getGoodsInforBlService();
		relatedGoods=goodsInforSer.fuzzyEnquiry(keyWord);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		if(relatedGoods.size()!=0){
				//���������Ʒ������ģ����������
				initFuzzySearch(relatedGoods);
		}else{
			Alert notExistRelatedGoodsErr=new Alert(Alert.AlertType.ERROR,"��������ص���Ʒ��");
			notExistRelatedGoodsErr.showAndWait();
		}
	}
	private void initFuzzySearch(ArrayList<GoodsVO> goods){
		FuzzySearchUiStarter starter=new FuzzySearchUiStarter();
		starter.initFuzzySearchUi(currentStage, goods);
	}

	@FXML protected void returnBack(){
        currentStage.close();
	}



}
