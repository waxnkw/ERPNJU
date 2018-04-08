/**
 * �ֿ����Ա���п���̵�Ľ���
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package ui.commodityUi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import assistant.utility.Date;
import blService.commodityBlService.InventoryCheckBlService;
import blStubs.commodityBlStubs.InventoryCheckService_Stub;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rmi.remoteHelper.CommodityRemoteHelper;
import ui.uiAssistants.Fonts;
import vo.InventoryCheckSheetVO;

public class InventoryCheckUiController {
	@FXML private VBox goodsID;
	@FXML private VBox goodsName;
	@FXML private VBox goodsType;
	@FXML private VBox goodsAmount;
	@FXML private VBox goodsAveragePrice;
	@FXML private VBox goodsProductionDate;
	@FXML private Text dateLabel;

	private Stage currentStage=new Stage();
	private ArrayList<String[]> sheetContents;

	public void setInventoryCheckSheetContents(){
	//��ʼ�����������
		Date currentTime=new Date();
		String time=currentTime.getDate();
		//yyyy-MM-dd_HH:mm:ss
		String[] timeInfors=time.split("_");
		String date=timeInfors[0];
		//yyyy-MM-dd
		dateLabel.setText(date);

		InventoryCheckSheetVO invenCheckSheet=new InventoryCheckSheetVO();
		try{
		InventoryCheckBlService invenCheckSer=CommodityRemoteHelper.getInstance().getInventoryCheckBlService();
		invenCheckSheet=invenCheckSer.inventoryCheckSheet();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		sheetContents=invenCheckSheet.getInventoryCheckSheet();
		for(int i=0;i<=sheetContents.size()-1;i++){
			String[] oneInfor=sheetContents.get(i);
			String ID=oneInfor[0];
			String name=oneInfor[1];
			String type=oneInfor[2];
			String amount=oneInfor[3];
			String averagePrice=oneInfor[4];
			String productionDate=oneInfor[5];
			Text idText=new Text();
			idText.setText(ID);
			idText.setFont(Fonts.BILL_FONT);
			Text nameText=new Text();
			nameText.setText(name);
			nameText.setFont(Fonts.BILL_FONT);
			Text typeText=new Text();
			typeText.setText(type);
			typeText.setFont(Fonts.BILL_FONT);
			Text amountText=new Text();
			amountText.setText(amount);
			amountText.setFont(Fonts.BILL_FONT);
			Text averagePriceText=new Text();
			averagePriceText.setText(averagePrice);
			averagePriceText.setFont(Fonts.BILL_FONT);
			Text productionDateText=new Text();
			productionDateText.setText(productionDate);
			productionDateText.setFont(Fonts.BILL_FONT);
			goodsID.getChildren().add(idText);
			goodsName.getChildren().add(nameText);
			goodsType.getChildren().add(typeText);
			goodsAmount.getChildren().add(amountText);
			goodsAveragePrice.getChildren().add(averagePriceText);
			goodsProductionDate.getChildren().add(productionDateText);
		}
	}
	public void setInitInfor(Stage stage){
		currentStage=stage;
	}
    @FXML protected void exportInvenCheck(){
	//��������Ŀ��������ͻ��˵Ļ�����ֻ�ڿͻ��˻������棬����û�˾���û��
	//����뿴��ǰ�Ŀ����������Կ�����
    //�����ڿͻ��˻����ĺ�̨����
    //��excel�ļ�������d���е�InventorySheets�ļ�������
    	Date currentDate=new Date();
    	String sheetName="IS"+currentDate.getYMDDate();
    	//IS:inventory sheet

    	HSSFWorkbook wb=new HSSFWorkbook();
    	HSSFSheet sheet=wb.createSheet(sheetName);
    	HSSFRow row0=sheet.createRow(0);
    	HSSFCell cell00=row0.createCell(0);
    	cell00.setCellValue("Inventory Sheet of "+currentDate.getYMDDate());
    	sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));

    	HSSFRow row2=sheet.createRow(1);
    	HSSFCell idLabel=row2.createCell(0);
    	idLabel.setCellValue("��Ʒ���");
    	HSSFCell nameLabel=row2.createCell(1);
    	nameLabel.setCellValue("��Ʒ����");
    	HSSFCell typeLabel=row2.createCell(2);
    	typeLabel.setCellValue("��Ʒ�ͺ�");
    	HSSFCell amountLabel=row2.createCell(3);
    	amountLabel.setCellValue("��Ʒ����");
    	HSSFCell averagePriceLabel=row2.createCell(4);
    	averagePriceLabel.setCellValue("��Ʒ����");
    	HSSFCell productionDateLabel=row2.createCell(5);
    	productionDateLabel.setCellValue("��������");

    	int rowIndex=2;

    	for(int i=0;i<=sheetContents.size()-1;i++){
    		String[] oneInfor=sheetContents.get(i);
			String ID=oneInfor[0];
			String name=oneInfor[1];
			String type=oneInfor[2];
			String amount=oneInfor[3];
			String averagePrice=oneInfor[4];
			String productionDate=oneInfor[5];

			HSSFRow row=sheet.createRow(rowIndex);
    		HSSFCell idCell=row.createCell(0);
        	idCell.setCellValue(ID);
        	HSSFCell nameCell=row.createCell(1);
        	nameCell.setCellValue(name);
        	HSSFCell typeCell=row.createCell(2);
        	typeCell.setCellValue(type);
        	HSSFCell amountCell=row.createCell(3);
        	amountCell.setCellValue(amount);
        	HSSFCell averagePriceCell=row.createCell(4);
        	averagePriceCell.setCellValue(averagePrice);
        	HSSFCell productionDateCell=row.createCell(5);
        	productionDateCell.setCellValue(productionDate);

        	rowIndex++;
    	}

    	try{
    	File invenfile=new File("d:\\InventorySheets");
    	invenfile.mkdirs();
    	FileOutputStream fos=new FileOutputStream(invenfile.getAbsoluteFile()+"\\"+sheetName+".xls");
    	wb.write(fos);
    	fos.flush();
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}catch(IOException e2){
    		e2.printStackTrace();
    	}

	}
    @FXML protected void confirmInvenCheck(){
         currentStage.close();
    }
}
