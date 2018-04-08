package ui.listUi;

import java.rmi.RemoteException;

import blStubs.commodityBlStubs.SaveBillService_Stub;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vo.InventoryLossBillVO;
import vo.InventoryOverBillVO;
import vo.InventoryWarningBillVO;

public class EditInventoryBillUiController {
	@FXML private Text billNameText;
	@FXML private Text BillID;
	@FXML private Text createDateText;
	@FXML private Text Operator;
	@FXML private Text GoodsName;
	@FXML private Text GoodsID;
	@FXML private Text GoodsType;
	@FXML private TextField GoodsPrice;
	@FXML private TextField SysInvenAmount;
	@FXML private Text RealOrWarningLabel;
	@FXML private TextField RealOrWarningAmount;
	@FXML private Text dAmountLabel;
	@FXML private TextField dAmount;

	@FXML private Label billStateLabel;
	@FXML private Text approverText;
	@FXML private Text executorText;
	@FXML private Text approveDateText;
	@FXML private Text finishDateText;
	@FXML private TextArea approverCommentArea;

	private InventoryWarningBillVO warningBill=null;
	private InventoryLossBillVO lossBill=null;
	private InventoryOverBillVO overBill=null;



	private Stage billStage;

	public void editInventoryWarningBill(Stage stage,InventoryWarningBillVO bill,String type){
    	warningBill=bill;

    	billStage=stage;
   		billNameText.setText(bill.getCategoryEnum().toChineseString());
   		BillID.setText(bill.getId());
   		createDateText.setText(bill.getCreateDate().getDate());
   		Operator.setText(bill.getCreater().getName()+" "+bill.getCreater().getId());
   		GoodsName.setText(bill.getGoodsName());
   		GoodsID.setText(bill.getGoodsID());
   		GoodsType.setText(bill.getGoodsType());
   		RealOrWarningLabel.setText("警戒值：");
   		dAmountLabel.setText("缺损值：");
   		if(type.equals("红冲并复制")){
   			GoodsPrice.setText(bill.getGoodsPrice());
   			SysInvenAmount.setText(bill.getSystemAmount());
   			RealOrWarningAmount.setText(bill.getWarningAmount());
   			dAmount.setText(bill.getLossAmount());
   		}else{
   			GoodsPrice.setText("-"+bill.getGoodsPrice());
   			SysInvenAmount.setText("-"+bill.getSystemAmount());
   			RealOrWarningAmount.setText("-"+bill.getWarningAmount());
   			dAmount.setText("-"+bill.getLossAmount());
   		}


   		billStateLabel.setText(bill.getBillStateEnum().toString());
   		approverText.setText(bill.getApprover().getName());
   		executorText.setText(bill.getExecutor().getName());
   		approveDateText.setText(bill.getApproveDate().getDate());
   		finishDateText.setText(bill.getFinishDate().getDate());
   		approverCommentArea.setText(bill.getApproverComment());

       }
       public void editInventoryLossBill(Stage stage,InventoryLossBillVO bill,String type){
    	lossBill=bill;

    	billStage=stage;
   		billNameText.setText(bill.getCategoryEnum().toChineseString());
   		BillID.setText(bill.getId());
   		createDateText.setText(bill.getCreateDate().getDate());
   		Operator.setText(bill.getCreater().getName()+" "+bill.getCreater().getId());
   		GoodsName.setText(bill.getGoodsName());
   		GoodsID.setText(bill.getGoodsID());
   		GoodsType.setText(bill.getGoodsType());
   		RealOrWarningLabel.setText("实际库存：");
   		dAmountLabel.setText("缺损值：");

   		if(type.equals("红冲并复制")){
   			GoodsPrice.setText(bill.getGoodsPrice());
   			SysInvenAmount.setText(bill.getSystemAmount());
   			RealOrWarningAmount.setText(bill.getRealAmount());
   			dAmount.setText(bill.getLossAmount());
   		}else{
   			GoodsPrice.setText("-"+bill.getGoodsPrice());
   			SysInvenAmount.setText("-"+bill.getSystemAmount());
   			RealOrWarningAmount.setText("-"+bill.getRealAmount());
   			dAmount.setText("-"+bill.getLossAmount());
   		}

   		billStateLabel.setText(bill.getBillStateEnum().toString());
   		approverText.setText(bill.getApprover().getName());
   		executorText.setText(bill.getExecutor().getName());
   		approveDateText.setText(bill.getApproveDate().getDate());
   		finishDateText.setText(bill.getFinishDate().getDate());
   		approverCommentArea.setText(bill.getApproverComment());
       }

       public void editInventoryOverBill(Stage stage,InventoryOverBillVO bill,String type){
    	overBill=bill;

        billStage=stage;
   		billNameText.setText(bill.getCategoryEnum().toChineseString());
   		BillID.setText(bill.getId());
   		createDateText.setText(bill.getCreateDate().getDate());
   		Operator.setText(bill.getCreater().getName()+" "+bill.getCreater().getId());
   		GoodsName.setText(bill.getGoodsName());
   		GoodsID.setText(bill.getGoodsID());
   		GoodsType.setText(bill.getGoodsType());
   		RealOrWarningLabel.setText("实际库存：");
   		dAmountLabel.setText("溢出值：");

   		if(type.equals("红冲并复制")){
   			GoodsPrice.setText(bill.getGoodsPrice());
   			SysInvenAmount.setText(bill.getSystemAmount());
   			RealOrWarningAmount.setText(bill.getRealAmount());
   			dAmount.setText(bill.getOverAmount());
   		}else{
   			GoodsPrice.setText("-"+bill.getGoodsPrice());
   			SysInvenAmount.setText("-"+bill.getSystemAmount());
   			RealOrWarningAmount.setText("-"+bill.getRealAmount());
   			dAmount.setText("-"+bill.getOverAmount());
   		}

   		billStateLabel.setText(bill.getBillStateEnum().toString());
   		approverText.setText(bill.getApprover().getName());
   		executorText.setText(bill.getExecutor().getName());
   		approveDateText.setText(bill.getApproveDate().getDate());
   		finishDateText.setText(bill.getFinishDate().getDate());
   		approverCommentArea.setText(bill.getApproverComment());
       }

       @FXML protected void confirmTheBill(){
//保存红冲单
    	   if(warningBill==null){

    	   }else{
    		   warningBill.setGoodsPrice(GoodsPrice.getText());
    		   warningBill.setSystemAmount(SysInvenAmount.getText());
    		   warningBill.setWarningAmount(RealOrWarningAmount.getText());
    		   warningBill.setLossAmount(dAmount.getText());
    		   //这三处可能出现改动
    		   try{
    		   SaveBillService_Stub saveBillSer=new SaveBillService_Stub();
    		   saveBillSer.saveInventoryWarningBill(warningBill);
    		   }catch(RemoteException e){
                e.printStackTrace();
               }
    		   Alert saveBillSuccess=new Alert(Alert.AlertType.INFORMATION,"成功保存库存报警单");
    		   saveBillSuccess.showAndWait();
    	   }
           if(lossBill==null){

    	   }else{
    		   lossBill.setGoodsPrice(GoodsPrice.getText());
    		   lossBill.setSystemAmount(SysInvenAmount.getText());
    		   lossBill.setRealAmount(RealOrWarningAmount.getText());
    		   lossBill.setLossAmount(dAmount.getText());
    		   //这三处可能出现改动
    		   try{
    		   SaveBillService_Stub saveBillSer=new SaveBillService_Stub();
    		   saveBillSer.saveInventoryLossBill(lossBill);
    		   }catch(RemoteException e){
                e.printStackTrace();
               }
    		   Alert saveBillSuccess=new Alert(Alert.AlertType.INFORMATION,"成功保存库存报损单");
    		   saveBillSuccess.showAndWait();
    	   }
           if(overBill==null){

           }else{
        	   overBill.setGoodsPrice(GoodsPrice.getText());
        	   overBill.setSystemAmount(SysInvenAmount.getText());
    		   overBill.setRealAmount(RealOrWarningAmount.getText());
    		   overBill.setOverAmount(dAmount.getText());
    		   //这三处可能出现改动
    		   try{
    		   SaveBillService_Stub saveBillSer=new SaveBillService_Stub();
    		   saveBillSer.saveInventoryOverBill(overBill);
    		   }catch(RemoteException e){
                e.printStackTrace();
               }
    		   Alert saveBillSuccess=new Alert(Alert.AlertType.INFORMATION,"成功保存库存报溢单");
    		   saveBillSuccess.showAndWait();
           }

    	   billStage.close();
       }
}
