/**
 * �鿴�ֿ����Ա�ƶ��ĵ��ݽ��棬������汨��������汨�𵥡���汨�����Ľ���
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package ui.billUi.viewBillUi;

import blStubs.billStubs.viewBillBlStubs.ViewWareKeeperBillBlService_Stub;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vo.InventoryLossBillVO;
import vo.InventoryOverBillVO;
import vo.InventoryWarningBillVO;

public class ViewWareKeeperBillUiController {
	@FXML private Text billNameText;
	@FXML private Text BillID;
	@FXML private Text createDateText;
	@FXML private Text Operator;
	@FXML private Text GoodsName;
	@FXML private Text GoodsID;
	@FXML private Text GoodsType;
	@FXML private Text GoodsPrice;
	@FXML private Text SysInvenAmount;
	@FXML private Text RealOrWarningLabel;
	@FXML private Text RealOrWarningAmount;
	@FXML private Text dAmountLabel;
	@FXML private Text dAmount;

	@FXML private Label billStateLabel;
	@FXML private Text approverText;
	@FXML private Text executorText;
	@FXML private Text approveDateText;
	@FXML private Text finishDateText;
	@FXML private TextArea approverCommentArea;

	private Stage billStage;
	private ViewWareKeeperBillBlService_Stub viewInvenBill=new ViewWareKeeperBillBlService_Stub();

	@FXML protected void confirmTheBill(){
       billStage.close();
	}

	public void setInventoryWarningBill(Stage stage,String billID){
	//��������һ����������������������ȡ��֮�����ú�bill���ݣ�Ȼ����ʾ
	//��汨��������
		billStage=stage;
		InventoryWarningBillVO bill=new InventoryWarningBillVO();
		bill=viewInvenBill.getInventoryWarningBill(billID);
		billNameText.setText(bill.getCategoryEnum().toChineseString());
		BillID.setText(bill.getId());
		createDateText.setText(bill.getCreateDate().getDate());
		Operator.setText(bill.getCreater().getName()+" "+bill.getCreater().getId());
		GoodsName.setText(bill.getGoodsName());
		GoodsID.setText(bill.getGoodsID());
		GoodsType.setText(bill.getGoodsType());
		GoodsPrice.setText(bill.getGoodsPrice());
		SysInvenAmount.setText(bill.getSystemAmount());
		RealOrWarningLabel.setText("����ֵ��");
		RealOrWarningAmount.setText(bill.getWarningAmount());
		dAmountLabel.setText("ȱ��ֵ��");
		dAmount.setText(bill.getLossAmount());

		billStateLabel.setText(bill.getBillStateEnum().toString());
		approverText.setText(bill.getApprover().getName());
		executorText.setText(bill.getExecutor().getName());
		approveDateText.setText(bill.getApproveDate().getDate());
		finishDateText.setText(bill.getFinishDate().getDate());
		approverCommentArea.setText(bill.getApproverComment());


	}

	public void setInventoryLossBill(Stage stage,String billID){
	//��汨�𵥽���
		billStage=stage;
		InventoryLossBillVO bill=new InventoryLossBillVO();
		bill=viewInvenBill.getInventoryLossBill(billID);
		billNameText.setText(bill.getCategoryEnum().toChineseString());
		BillID.setText(bill.getId());
		createDateText.setText(bill.getCreateDate().getDate());
		Operator.setText(bill.getCreater().getName()+" "+bill.getCreater().getId());
		GoodsName.setText(bill.getGoodsName());
		GoodsID.setText(bill.getGoodsID());
		GoodsType.setText(bill.getGoodsType());
		GoodsPrice.setText(bill.getGoodsPrice());
		SysInvenAmount.setText(bill.getSystemAmount());
		RealOrWarningLabel.setText("ʵ�ʿ�棺");
		RealOrWarningAmount.setText(bill.getRealAmount());
		dAmountLabel.setText("ȱ��ֵ��");
		dAmount.setText(bill.getLossAmount());

		billStateLabel.setText(bill.getBillStateEnum().toString());
		approverText.setText(bill.getApprover().getName());
		executorText.setText(bill.getExecutor().getName());
		approveDateText.setText(bill.getApproveDate().getDate());
		finishDateText.setText(bill.getFinishDate().getDate());
		approverCommentArea.setText(bill.getApproverComment());
	}

	public void setInventoryOverBill(Stage stage,String billID){
	//��汨�絥
		billStage=stage;
		InventoryOverBillVO bill=new InventoryOverBillVO();
		bill=viewInvenBill.getInventoryOverBill(billID);
		billNameText.setText(bill.getCategoryEnum().toChineseString());
		BillID.setText(bill.getId());
		createDateText.setText(bill.getCreateDate().getDate());
		Operator.setText(bill.getCreater().getName()+" "+bill.getCreater().getId());
		GoodsName.setText(bill.getGoodsName());
		GoodsID.setText(bill.getGoodsID());
		GoodsType.setText(bill.getGoodsType());
		GoodsPrice.setText(bill.getGoodsPrice());
		SysInvenAmount.setText(bill.getSystemAmount());
		RealOrWarningLabel.setText("ʵ�ʿ�棺");
		RealOrWarningAmount.setText(bill.getRealAmount());
		dAmountLabel.setText("���ֵ��");
		dAmount.setText(bill.getOverAmount());

		billStateLabel.setText(bill.getBillStateEnum().toString());
		approverText.setText(bill.getApprover().getName());
		executorText.setText(bill.getExecutor().getName());
		approveDateText.setText(bill.getApproveDate().getDate());
		finishDateText.setText(bill.getFinishDate().getDate());
		approverCommentArea.setText(bill.getApproverComment());
	}


}
