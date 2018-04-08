/**
 * �ֿ����Ա���п�����Ľ���
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package ui.commodityUi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import assistant.utility.Date;
import blStubs.commodityBlStubs.StockCheckService_Stub;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.uiAssistants.StageSize;
import vo.StockCheckSheetVO;

public class StockCheckUiController {
	@FXML private TextField startyear;
	@FXML private TextField startmonth;
	@FXML private TextField startday;
	@FXML private TextField starthour;
	@FXML private TextField startminute;
	@FXML private TextField endyear;
	@FXML private TextField endmonth;
	@FXML private TextField endday;
	@FXML private TextField endhour;
	@FXML private TextField endminute;



	private Stage currentStage;


	public void setStage(Stage stage){
		currentStage=stage;
	}
	@FXML protected void confirmTime(){
		boolean startTimeFor=true;
		boolean endTimeFor=true;
		boolean endOverStart=true;
		boolean nowOverEnd=true;
		Date start=null;
		Date end=null;
		String startTime=startyear.getText()+"-"+startmonth.getText()+"-"+startday.getText()+"_"+starthour.getText()+":"+startminute.getText()+":"+"00";
		//����Ĭ��Ϊ00
		 try{
	      		start=new Date(startTime);
	      		}catch(ParseException e){
	      			//startTime����yyyy-MM-dd_HH:mm:ss��ʽ
	      			startTimeFor=false;
	      			Alert startTimeErr=new Alert(Alert.AlertType.ERROR,"��ʼʱ��������ʽ������ο�Ĭ��ֵ����");
	          	    startTimeErr.showAndWait();
	      		}
		 String endTime=endyear.getText()+"-"+endmonth.getText()+"-"+endday.getText()+"_"+endhour.getText()+":"+endminute.getText()+":"+"00";
		 try{
	      		end=new Date(endTime);
	      		}catch(ParseException e){
	      			//endTime����yyyy-MM-dd_HH:mm:ss��ʽ
	      			endTimeFor=false;
	      			Alert endTimeErr=new Alert(Alert.AlertType.ERROR,"����ʱ��������ʽ������ο�Ĭ��ֵ����");
	          	    endTimeErr.showAndWait();
	      		}
		 if(startTimeFor&&endTimeFor){
			 int over=endTime.compareTo(startTime);
			 //0:���  1:��ǰ���ڽ���  -1:��ǰ���ڽ���
			 if(over>0){

			 }else{
				 endOverStart=false;
				 Alert startOverEndErr=new Alert(Alert.AlertType.ERROR,"��ʼʱ�����ڣ����ڣ�����ʱ�䣡");
	          	 startOverEndErr.showAndWait();
			 }
		 }
		 if(startTimeFor&&endTimeFor&&endOverStart){
			 Date current=new Date();
			 int over2=current.compareTo(end);
			//0:���  1:��ǰ���ڽ���  -1:��ǰ���ڽ���
			 if(over2>0){

			 }else{
				 nowOverEnd=false;
				 Alert startOverEndErr=new Alert(Alert.AlertType.ERROR,"����ʱ�����ڣ����ڣ���ǰʱ�䣡");
	          	 startOverEndErr.showAndWait();
			 }
		 }
		 if(startTimeFor&&endTimeFor&&endOverStart&&nowOverEnd){
			 initStockCheckBillUi(start,end);
		 }

	}
	private void initStockCheckBillUi(Date start,Date end){
		StockCheckSheetUiStarter starter=new StockCheckSheetUiStarter();
		starter.initStockCheckSheetUi(currentStage, start, end);
	}
	@FXML protected void returnBack(){
		currentStage.close();
	}
}
