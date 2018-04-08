package ui.listUi;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import assistant.type.BillCategoryEnum;
import assistant.type.CustomerLevelEnum;
import assistant.utility.Date;
import blService.listBlService.BusinessProcessListBlService;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import rmi.remoteHelper.ListRemoteHelper;
import rmi.remoteHelper.RemoteHelperFactory;
import ui.billUi.viewBillUi.ViewFinancialStaffBillUiStarter;
import ui.billUi.viewBillUi.ViewGiftBillUiStarter;
import ui.billUi.viewBillUi.ViewSalesmanBillsUiStarter;
import ui.billUi.viewBillUi.ViewWareKeeperBillUiStarter;
import ui.mainUi.financialStaffMainUi.FinancialStaffMainUiStarter;
import ui.uiAssistants.StageFactory;
import vo.BusinessProcessListBillVO;
import vo.BusinessProcessListVO;
import vo.CashExpenseBillVO;
import vo.CustomerInfoVO;
import vo.InventoryLossBillVO;
import vo.InventoryOverBillVO;
import vo.InventoryWarningBillVO;
import vo.PaymentBillVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.ReceiptBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;
import vo.UserVO;

/**
 * ��Ӫ���̱����controller
 * @author guxinyu
 * @version 2017.12.25
 *
 */
public class BusinessProcessListUiController {
	private Stage stage=StageFactory.getFinanceStage();
	
	//�������ɸѡ��
		//ʱ��
	@FXML
	private DatePicker startDatePicker;
	
	@FXML
	private DatePicker endDatePicker;
	
		//��������
	@FXML
	private CheckBox salesTypeCheckBox;
	
	@FXML
	private CheckBox purchaseTypeCheckBox;
	
	@FXML
	private CheckBox financeTypeCheckBox;
	
	@FXML
	private CheckBox inventoryTypeCheckBox;
	
		//�ͻ�
	@FXML
	private TreeTableColumn<CustomerInfoVO, CheckBox> customerChooseColumn;
	
	@FXML
	private TreeTableColumn<CustomerInfoVO, String> customerNameColumn;
	
	@FXML
	private TreeTableColumn<CustomerInfoVO, String> customerIdColumn;
	
	@FXML
	private TreeTableView<CustomerInfoVO> customerTable;
	
		//ҵ��Ա
	@FXML
	private TreeTableColumn<UserVO, CheckBox> userChooseColumn;
	
	@FXML
	private TreeTableColumn<UserVO, String> userNameColumn;
	
	@FXML
	private TreeTableColumn<UserVO, String> userIdColumn;
	
	@FXML
	private TreeTableView<UserVO> userTable;
	
		//�ֿ�
	@FXML
	private TextField wareHouseTextField;
	
	//����
	@FXML
	private TableView<BusinessProcessListBillVO> listTable;
	
	@FXML
	private TableColumn<BusinessProcessListBillVO, String> dateColumn;
	
	@FXML
	private TableColumn<BusinessProcessListBillVO, String> billNameColumn;
	
	@FXML
	private TableColumn<BusinessProcessListBillVO, String> billIdColumn;
	
	@FXML
	private TableColumn<BusinessProcessListBillVO, String> creatorColumn;
	
	@FXML
	private TableColumn<BusinessProcessListBillVO, Button> viewColumn;
	
	@FXML
	private TableColumn<BusinessProcessListBillVO, Button> modifyCopyColumn;
	
	@FXML
	private TableColumn<BusinessProcessListBillVO, Button> modifyColumn;
	
	private ArrayList<BusinessProcessListBillVO> billInfos;
	
	private ObservableList<BusinessProcessListBillVO> listItems=FXCollections.observableArrayList();
	
	private ListRemoteHelper remoteHelper=RemoteHelperFactory.getListRemoteHelper();
	
	//private BusinessProcessListBlService listBl=new BusinessProcessListBlService_Stub();
	
	private BusinessProcessListBlService listBl=remoteHelper.getBusinessProcessListBlService();
	
	private final String dateFormat="yyyy.MM.dd";
	
	private boolean isChoosed=false;

	public void init(){
		
		//��ʼ���������ɸѡ��
			//ʱ��
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
	          DateTimeFormatter dateFormatter =
	              DateTimeFormatter.ofPattern(dateFormat);
	          @Override
	          public String toString(LocalDate date) {
	              if (date != null) {
	                  return dateFormatter.format(date);
	              } else {
	                  return "";
	              }
	          }
	 
	          @Override
	          public LocalDate fromString(String string) {
	              if (string != null && !string.isEmpty()) {
	                  return LocalDate.parse(string, dateFormatter);
	              } else {
	                  return null;
	              }
	          }
	      };
	      
	    startDatePicker.setConverter(converter);//��������ѡ�����ĸ�ʽ
	    endDatePicker.setConverter(converter);
	    
	    final Callback<DatePicker, DateCell> dayCellFactory = 
	            new Callback<DatePicker, DateCell>() {
	                @Override
	                public DateCell call(final DatePicker datePicker) {
	                    return new DateCell() {
	                        @Override
	                        public void updateItem(LocalDate item, boolean empty) {
	                            super.updateItem(item, empty);
	                           
	                            if (item.isBefore(startDatePicker.getValue().plusDays(1))) {
	                            	setDisable(true);
	                            	setStyle("-fx-background-color: #c1c1c1;");
	                            }   
	                    }
	                };
	            }
	        };
	    endDatePicker.setDayCellFactory(dayCellFactory);//��startDatePicker��ѡ������ڼ���֮ǰ�����ڵ�Ԫ�񶼽���
		
	    	//��������
	    salesTypeCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!isChoosed){
					listItems.clear();
					isChoosed=true;
				}
				Iterator<BusinessProcessListBillVO> it=listItems.iterator();
				
				if(oldValue==false&&newValue==true){
					for(int i=0;i<billInfos.size();i++){
						BusinessProcessListBillVO bill=billInfos.get(i);
						String billName=bill.getBillName();
	    		
						if(!isExist(bill.getBillId())&&(billName.equals("���۵�")||billName.equals("�����˻���"))){
							listItems.add(bill);
						}
	    		
					}
				}else if(oldValue==true&&newValue==false){
					while(it.hasNext()){
						BusinessProcessListBillVO bill=it.next();
						String billName=bill.getBillName();
	    		
						if(billName.equals("���۵�")||billName.equals("�����˻���")){
							it.remove();
						}
					}
				}
	
			}
	    	
	    });
	    	
	    
	    
	    purchaseTypeCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!isChoosed){
					listItems.clear();
					isChoosed=true;
				}
	    	
				Iterator<BusinessProcessListBillVO> it=listItems.iterator();
	    	
				if(oldValue==false&&newValue==true){
					for(int i=0;i<billInfos.size();i++){
						BusinessProcessListBillVO bill=billInfos.get(i);
						String billName=bill.getBillName();
	    		
						if(!isExist(bill.getBillId())&&(billName.equals("������")||billName.equals("�����˻���"))){
							listItems.add(bill);
						}
	    		
					}			
				}else if(oldValue==true&&newValue==false){
					while(it.hasNext()){
						BusinessProcessListBillVO bill=it.next();
						String billName=bill.getBillName();
	    		
						if(billName.equals("������")||billName.equals("�����˻���")){
							it.remove();
						}
					}				
				}	
			}
	    	
	    });

	    
	    
	    financeTypeCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!isChoosed){
					listItems.clear();
					isChoosed=true;
				}
	    	
				Iterator<BusinessProcessListBillVO> it=listItems.iterator();
	    	
				if(oldValue==false&&newValue==true){
					for(int i=0;i<billInfos.size();i++){
						BusinessProcessListBillVO bill=billInfos.get(i);
						String billName=bill.getBillName();
	    		
						if(!isExist(bill.getBillId())&&(billName.equals("���")||billName.equals("�տ")||billName.equals("�ֽ���õ�"))){
							listItems.add(bill);
						}
	    		
					}			
				}else if(oldValue==true&&newValue==false){
					while(it.hasNext()){
						BusinessProcessListBillVO bill=it.next();
						String billName=bill.getBillName();
	    		
						if(billName.equals("���")||billName.equals("�տ")||billName.equals("�ֽ���õ�")){
							it.remove();
						}
					}				
				}	
			}
	    	
	    });
	    
	    inventoryTypeCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!isChoosed){
					listItems.clear();
					isChoosed=true;
				}
	    	
				Iterator<BusinessProcessListBillVO> it=listItems.iterator();
	    	
				if(oldValue==false&&newValue==true){
					for(int i=0;i<billInfos.size();i++){
						BusinessProcessListBillVO bill=billInfos.get(i);
						String billName=bill.getBillName();
	    		
						if(!isExist(bill.getBillId())&&(billName.equals("��汨�絥")||billName.equals("��汨��")
								||billName.equals("��汨����")||billName.equals("������͵�"))){
							listItems.add(bill);
						}
	    		
					}			
				}else if(oldValue==true&&newValue==false){
					while(it.hasNext()){
						BusinessProcessListBillVO bill=it.next();
						String billName=bill.getBillName();
	    		
						if(billName.equals("��汨�絥")||billName.equals("��汨��")
								||billName.equals("��汨����")||billName.equals("������͵�")){
							it.remove();
						}
					}				
				}	
			}
	    	
	    });
	    
	    	//�ͻ�
	  	ArrayList<CustomerInfoVO> customers=null;
	  	try {
	  		customers=listBl.getCustomerList();
	  	} catch (RemoteException e2) {
	  		e2.printStackTrace();
	  	}
	  		
	  	CustomerInfoVO CusRootVO=new CustomerInfoVO();
	  	CusRootVO.setName("���й˿�");
	  	TreeItem<CustomerInfoVO> rootItem=new TreeItem<CustomerInfoVO>(CusRootVO);
	  		
	  	CustomerInfoVO supplier=new CustomerInfoVO();
	  	supplier.setName("������");
	  	TreeItem<CustomerInfoVO> supplierRootItem=new TreeItem<CustomerInfoVO>(supplier);
	  		
	  	CustomerInfoVO consumer=new CustomerInfoVO();
	  	consumer.setName("������");
	  	TreeItem<CustomerInfoVO> consumerRootItem=new TreeItem<CustomerInfoVO>(consumer);
	  		
	  	rootItem.getChildren().add(supplierRootItem);
	  	rootItem.getChildren().add(consumerRootItem);
	  		
	  	CustomerInfoVO supplierVIP1=new CustomerInfoVO();
	  	supplierVIP1.setName(CustomerLevelEnum.VIP1.toString());
	  	TreeItem<CustomerInfoVO> supplierVIP1RootItem=new TreeItem<CustomerInfoVO>(supplierVIP1);
	  		
	  	CustomerInfoVO supplierVIP2=new CustomerInfoVO();
	  	supplierVIP2.setName(CustomerLevelEnum.VIP2.toString());
	  	TreeItem<CustomerInfoVO> supplierVIP2RootItem=new TreeItem<CustomerInfoVO>(supplierVIP2);
	  		
	  	CustomerInfoVO supplierVIP3=new CustomerInfoVO();
	  	supplierVIP3.setName(CustomerLevelEnum.VIP3.toString());
	  	TreeItem<CustomerInfoVO> supplierVIP3RootItem=new TreeItem<CustomerInfoVO>(supplierVIP3);
	  		
	  	CustomerInfoVO supplierVIP4=new CustomerInfoVO();
	  	supplierVIP4.setName(CustomerLevelEnum.VIP4.toString());
	  	TreeItem<CustomerInfoVO> supplierVIP4RootItem=new TreeItem<CustomerInfoVO>(supplierVIP4);
	  		
	  	CustomerInfoVO supplierVIP5=new CustomerInfoVO();
	  	supplierVIP5.setName(CustomerLevelEnum.VIP5.toString());
	  	TreeItem<CustomerInfoVO> supplierVIP5RootItem=new TreeItem<CustomerInfoVO>(supplierVIP5);
	  		
	  	supplierRootItem.getChildren().add(supplierVIP1RootItem);
	  	supplierRootItem.getChildren().add(supplierVIP2RootItem);
	  	supplierRootItem.getChildren().add(supplierVIP3RootItem);
	  	supplierRootItem.getChildren().add(supplierVIP4RootItem);
	  	supplierRootItem.getChildren().add(supplierVIP5RootItem);
	  		
	  	CustomerInfoVO consumerVIP1=new CustomerInfoVO();
	  	consumerVIP1.setName(CustomerLevelEnum.VIP1.toString());
	  	TreeItem<CustomerInfoVO> consumerVIP1RootItem=new TreeItem<CustomerInfoVO>(consumerVIP1);
	  		
	  	CustomerInfoVO consumerVIP2=new CustomerInfoVO();
	  	consumerVIP2.setName(CustomerLevelEnum.VIP2.toString());
	  	TreeItem<CustomerInfoVO> consumerVIP2RootItem=new TreeItem<CustomerInfoVO>(consumerVIP2);
	  		
	  	CustomerInfoVO consumerVIP3=new CustomerInfoVO();
	  	consumerVIP3.setName(CustomerLevelEnum.VIP3.toString());
	  	TreeItem<CustomerInfoVO> consumerVIP3RootItem=new TreeItem<CustomerInfoVO>(consumerVIP3);
	  		
	  	CustomerInfoVO consumerVIP4=new CustomerInfoVO();
	  	consumerVIP4.setName(CustomerLevelEnum.VIP4.toString());
	  	TreeItem<CustomerInfoVO> consumerVIP4RootItem=new TreeItem<CustomerInfoVO>(consumerVIP4);
	  		
	  	CustomerInfoVO consumerVIP5=new CustomerInfoVO();
	  	consumerVIP5.setName(CustomerLevelEnum.VIP5.toString());
	  	TreeItem<CustomerInfoVO> consumerVIP5RootItem=new TreeItem<CustomerInfoVO>(consumerVIP5);
	  		
	  	consumerRootItem.getChildren().add(consumerVIP1RootItem);
	  	consumerRootItem.getChildren().add(consumerVIP2RootItem);
	  	consumerRootItem.getChildren().add(consumerVIP3RootItem);
	  	consumerRootItem.getChildren().add(consumerVIP4RootItem);
	  	consumerRootItem.getChildren().add(consumerVIP5RootItem);
	  		
	  	for(int i=0;i<customers.size();i++){
	  		CustomerInfoVO cus=customers.get(i);
	  		String type=cus.getType();
	  		String level=cus.getLevel().toString();
	  			
	  		TreeItem<CustomerInfoVO> item=new TreeItem<CustomerInfoVO>(cus);
	  			
	  		if(type.equals("��Ӧ��")){
	  			switch (level){
	  			case "vip1":
	  				supplierVIP1RootItem.getChildren().add(item);
	  				break;
	  			case "vip2":
	  				supplierVIP2RootItem.getChildren().add(item);
	  				break;
	  			case "vip3":
	  				supplierVIP3RootItem.getChildren().add(item);
	  				break;
	  			case "vip4":
	  				supplierVIP4RootItem.getChildren().add(item);
	  				break;
	  			case "vip5":
	  				supplierVIP5RootItem.getChildren().add(item);
	  				break;
	  			}
	  		}else if(type.equals("������")){
	  			switch (level){
	  			case "vip1":
	  				consumerVIP1RootItem.getChildren().add(item);
	  				break;
	  			case "vip2":
	  				consumerVIP2RootItem.getChildren().add(item);
	  				break;
	  			case "vip3":
	  				consumerVIP3RootItem.getChildren().add(item);
	  				break;
	  			case "vip4":
	  				consumerVIP4RootItem.getChildren().add(item);
	  				break;
	  			case "vip5":
	  				consumerVIP5RootItem.getChildren().add(item);
	  				break;
	  			}
	  		}
	  	}
	  		
	  	customerTable.setRoot(rootItem);
	  	
	  	customerNameColumn.setCellValueFactory(
	  		         (TreeTableColumn.CellDataFeatures<CustomerInfoVO, String> param) -> 
	  		         new ReadOnlyStringWrapper(param.getValue().getValue().getName())
	  	);
	  		
	  	customerIdColumn.setCellValueFactory(
	  		         (TreeTableColumn.CellDataFeatures<CustomerInfoVO, String> param) -> 
	  	          new ReadOnlyStringWrapper(param.getValue().getValue().getId())
	  	);
	  		
	  	customerChooseColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CustomerInfoVO, CheckBox>, ObservableValue<CheckBox>>(){

		@Override
		public ObservableValue<CheckBox> call(
			TreeTableColumn.CellDataFeatures<CustomerInfoVO, CheckBox> param) {
			CheckBox checkBox=new CheckBox();
	  				
	  		TreeItem<CustomerInfoVO> thisCus=param.getValue();
	  				
	  		if(!thisCus.isLeaf()){
	  			return null;
	  		}
	  				
	  		checkBox.selectedProperty().addListener(new ChangeListener<Boolean>(){

	  			@Override
	  			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
	  					Boolean newValue) {
	  				if(!isChoosed){
	  					listItems.clear();
	  					isChoosed=true;
	  				}
	  						
	  				Iterator<BusinessProcessListBillVO> it=listItems.iterator();
	  						
	  				if(oldValue==false&&newValue==true){
	  							
	  					for(int i=0;i<billInfos.size();i++){
	  						BusinessProcessListBillVO bill=billInfos.get(i);
	  						String cusId=bill.getCustomerId();
	  								
	  						if(thisCus.getValue().getId().equals(cusId)&&!isExist(bill.getBillId())){
	  							listItems.add(bill);
	  						}
	  					}
	  				}else if(oldValue==true&&newValue==false){
	  							
	  					while(it.hasNext()){
	  						BusinessProcessListBillVO bill=it.next();
	  						String cusId=bill.getCustomerId();
	  						
	  						if(!cusId.equals("NONEXIST")&&thisCus.getValue().getId().equals(cusId)){
	  							it.remove();
	  						}
	  					}
	  							
	  				}
	  						
	  			}
	  					
	  		});
	  				
	  		return new SimpleObjectProperty<CheckBox>(checkBox);
		}
	  			
	  });
		
	  		
	  		//ҵ��Ա
	  		ArrayList<UserVO> wareKeepers=null;
			ArrayList<UserVO> salesmen=null;
			ArrayList<UserVO> financialStaffs=null;
			ArrayList<UserVO> managers=null;
			try {
				wareKeepers=listBl.getWareKeeperList();
				salesmen=listBl.getSalesmanList();
				financialStaffs=listBl.getFinancialStaffList();
				managers=listBl.getManagerList();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			
			UserVO rootVO=new UserVO();
			rootVO.setName("����Ա��");
			TreeItem<UserVO> userRootItem=new TreeItem<UserVO>(rootVO);
			UserVO wareRootVO=new UserVO();
			wareRootVO.setName("�ֿ����Ա");
			TreeItem<UserVO> wareKeeperItems=new TreeItem<UserVO>(wareRootVO);
			UserVO salesRootVO=new UserVO();
			salesRootVO.setName("���۽���Ա");
			TreeItem<UserVO> salesmanItems=new TreeItem<UserVO>(salesRootVO);
			UserVO financialRootVO=new UserVO();
			financialRootVO.setName("������Ա");
			TreeItem<UserVO> financialStaffItems=new TreeItem<UserVO>(financialRootVO);
			UserVO managerRootVO=new UserVO();
			managerRootVO.setName("�ܾ���");
			TreeItem<UserVO> managerItems=new TreeItem<UserVO>(managerRootVO);
			userRootItem.getChildren().add(wareKeeperItems);
			userRootItem.getChildren().add(salesmanItems);
			userRootItem.getChildren().add(financialStaffItems);
			userRootItem.getChildren().add(managerItems);
			
			userTable.setRoot(userRootItem);
			
			for(int i=0;i<wareKeepers.size();i++){
				UserVO each=wareKeepers.get(i);
				TreeItem<UserVO> eachItem=new TreeItem<UserVO>(each);
				wareKeeperItems.getChildren().add(eachItem);
			}
			
			for(int i=0;i<salesmen.size();i++){
				UserVO each=salesmen.get(i);
				TreeItem<UserVO> eachItem=new TreeItem<UserVO>(each);
				salesmanItems.getChildren().add(eachItem);
			}
			
			for(int i=0;i<financialStaffs.size();i++){
				UserVO each=financialStaffs.get(i);
				TreeItem<UserVO> eachItem=new TreeItem<UserVO>(each);
				financialStaffItems.getChildren().add(eachItem);
			}
			
			for(int i=0;i<managers.size();i++){
				UserVO each=managers.get(i);
				TreeItem<UserVO> eachItem=new TreeItem<UserVO>(each);
				managerItems.getChildren().add(eachItem);
			}
			
			userNameColumn.setCellValueFactory(
			          (TreeTableColumn.CellDataFeatures<UserVO, String> param) -> 
			          new ReadOnlyStringWrapper(param.getValue().getValue().getName())
			);
			
			userIdColumn.setCellValueFactory(
			          (TreeTableColumn.CellDataFeatures<UserVO, String> param) -> 
			          new ReadOnlyStringWrapper(param.getValue().getValue().getId())
			);
			
			userChooseColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<UserVO, CheckBox>, ObservableValue<CheckBox>>(){

				@Override
				public ObservableValue<CheckBox> call(
						TreeTableColumn.CellDataFeatures<UserVO, CheckBox> param) {
					CheckBox checkBox=new CheckBox();
					
					TreeItem<UserVO> thisUser=param.getValue();
					
					if(!thisUser.isLeaf()){
						return null;
					}
					
					checkBox.selectedProperty().addListener(new ChangeListener<Boolean>(){

						@Override
						public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
								Boolean newValue) {
							if(!isChoosed){
								listItems.clear();
								isChoosed=true;
							}
							
							Iterator<BusinessProcessListBillVO> it=listItems.iterator();
							
							if(oldValue==false&&newValue==true){
								
								for(int i=0;i<billInfos.size();i++){
									BusinessProcessListBillVO bill=billInfos.get(i);
									String userId=bill.getUserId();
									
									if(!userId.equals("NONEXIST")&&thisUser.getValue().getId().equals(userId)&&!isExist(bill.getBillId())){
										listItems.add(bill);
									}
								}
							}else if(oldValue==true&&newValue==false){
								
								while(it.hasNext()){
									BusinessProcessListBillVO bill=it.next();
									String userId=bill.getUserId();
								
									if(thisUser.getValue().getId().equals(userId)){
										it.remove();
									}
								}
								
							}
							
						}
						
					});
					
					return new SimpleObjectProperty<CheckBox>(checkBox);
				}
				
			});
		
		//��ʼ����Table
			//��õ�������
		BusinessProcessListVO list=null;
		try {
			list = listBl.getBusinessProcessList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		billInfos=list.getBills();
		
		listItems.addAll(billInfos);
		
		listTable.setItems(listItems);
		
			//��TableColumn
		dateColumn.setCellValueFactory(
				new PropertyValueFactory<BusinessProcessListBillVO, String>("date"));
		billNameColumn.setCellValueFactory(
				new PropertyValueFactory<BusinessProcessListBillVO, String>("billName"));
		billIdColumn.setCellValueFactory(
				new PropertyValueFactory<BusinessProcessListBillVO, String>("billId"));
		creatorColumn.setCellValueFactory(
				new PropertyValueFactory<BusinessProcessListBillVO, String>("creator"));
		
		ArrayList<InventoryWarningBillVO> inventoryWarningBills=list.getInventoryWarningBills();  
		ArrayList<InventoryOverBillVO> inventoryOverBills=list.getInventoryOverBills();
		ArrayList<InventoryLossBillVO> inventoryLossBills=list.getInventoryLossBills();
		ArrayList<PurchaseBillVO> purchaseBills=list.getPurchaseBills();
		ArrayList<PurchaseReturnBillVO> purchaseReturnBills=list.getPurchaseReturnBills();
		ArrayList<SalesBillVO> salesBills=list.getSalesBills();
		ArrayList<SalesReturnBillVO> salesReturnBills=list.getSalesReturnBills();
		ArrayList<ReceiptBillVO> receiptBills=list.getReceiptBills();
		ArrayList<PaymentBillVO> paymentBills=list.getPaymentBills();
		ArrayList<CashExpenseBillVO> cashExpenseBills=list.getCashExpenseBills();
	//	ArrayList<GiftBillVO> giftBills=list.getGiftBills();
		
			//��Ӱ�ť
		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BusinessProcessListBillVO, Button>, ObservableValue<Button>>(){

			@Override
			public ObservableValue<Button> call(CellDataFeatures<BusinessProcessListBillVO, Button> param) {
				BusinessProcessListBillVO bill=param.getValue();
				String billType=bill.getBillName();
				String billId=bill.getBillId();
				
				Button view=new Button("�鿴");
				
				ViewFinancialStaffBillUiStarter financeStarter=new ViewFinancialStaffBillUiStarter();
				ViewWareKeeperBillUiStarter wareStarter=new ViewWareKeeperBillUiStarter();
				ViewGiftBillUiStarter giftStarter=new ViewGiftBillUiStarter(billId);
				ViewSalesmanBillsUiStarter salesStarter=new ViewSalesmanBillsUiStarter();
				
				view.setOnAction(oa ->{
					switch(billType){
					case "������͵�":
						giftStarter.start();
						break;
					case "�ֽ���õ�":
						financeStarter.viewCashExpenseBill(billId);
						break;
					case "���":
						financeStarter.viewPaymentBill(billId);
						break;
					case "�տ":
						financeStarter.viewReceiptBill(billId);
					case "��汨����":
						wareStarter.viewInventoryWarningBill(billId);
						break;
					case "��汨��":
						wareStarter.viewInventoryLossBill(billId);
						break;
					case "��汨�絥":
						wareStarter.viewInventoryOverBill(billId);
						break;
					case "���۵�":
						salesStarter.viewSalesBill(billId);
						break;
					case "�����˻���":
						salesStarter.viewSalesReturnBill(billId);
						break;
					case "������":
						salesStarter.viewPurchaseBill(billId);
						break;
					case "�����˻���":
						salesStarter.viewPurchaseReturnBill(billId);
						break;
					}
				});
				
				return new SimpleObjectProperty<Button> (view);
			}

		});
		
		modifyColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BusinessProcessListBillVO, Button>, ObservableValue<Button>>(){

			@Override
			public ObservableValue<Button> call(CellDataFeatures<BusinessProcessListBillVO, Button> param) {
				BusinessProcessListBillVO bill=param.getValue();
				String billId=bill.getBillId();
				String billType=bill.getBillName();
				
				if(billType.equals(BillCategoryEnum.GIFT_BILL.toChineseString()))
					return null;
				
				Button modify=new Button("���");
				
				EditInventoryBillUiStarter inventoryStarter=new EditInventoryBillUiStarter();
				EditFinanceBillsUiStarter financeStarter=new EditFinanceBillsUiStarter();
				EditSalesmanBillsUiStarter salesBillStarter=new EditSalesmanBillsUiStarter();
				
				modify.setOnAction(oa ->{
					switch(billType){
				//	case "������͵�":
				//		for(int i=0;i<giftBills.size();i++){
				//			if(billId.equals(giftBills.get(i).getId())){
				//				/**
				//				 * ������
				//				 */
				//				break;
				//			}
				//		}
				//		break;
					case "�ֽ���õ�":
						for(int i=0;i<cashExpenseBills.size();i++){
							if(billId.equals(cashExpenseBills.get(i).getId())){
								financeStarter.editCashExpenseBillUi(cashExpenseBills.get(i), "���");
								break;
							}
						}
						break;
					case "���":
						for(int i=0;i<paymentBills.size();i++){
							if(billId.equals(paymentBills.get(i).getId())){
								financeStarter.editPaymentBillUi(paymentBills.get(i), "���");
								break;
							}
						}
						break;
					case "�տ":
						for(int i=0;i<receiptBills.size();i++){
							if(billId.equals(receiptBills.get(i).getId())){
								financeStarter.editReceiptBillUi(receiptBills.get(i), "���");
								break;
							}
						}
						break;
					case "��汨����":
						for(int i=0;i<inventoryWarningBills.size();i++){
							if(billId.equals(inventoryWarningBills.get(i).getId())){
								inventoryStarter.editInventoryWarningBill(inventoryWarningBills.get(i),"���");
								break;
							}
						}
						break;
					case "��汨��":
						for(int i=0;i<inventoryLossBills.size();i++){
							if(billId.equals(inventoryLossBills.get(i).getId())){
								inventoryStarter.editInventoryLossBill(inventoryLossBills.get(i),"���");
								break;
							}
						}
						break;
					case "��汨�絥":
						for(int i=0;i<inventoryOverBills.size();i++){
							if(billId.equals(inventoryOverBills.get(i).getId())){
								inventoryStarter.editInventoryOverBill(inventoryOverBills.get(i),"���");
								break;
							}
						}
						break;
					case "���۵�":
						for(int i=0;i<salesBills.size();i++){
							if(billId.equals(salesBills.get(i).getId())){
								salesBillStarter.editSalesBillUi(salesBills.get(i), "���");
								break;
							}
						}
						break;
					case "�����˻���":
						for(int i=0;i<salesReturnBills.size();i++){
							if(billId.equals(salesReturnBills.get(i).getId())){
								salesBillStarter.editSalesReturnBillUi(salesReturnBills.get(i), "���");
								break;
							}
						}
						break;
					case "������":
						for(int i=0;i<purchaseBills.size();i++){
							if(billId.equals(purchaseBills.get(i).getId())){
								salesBillStarter.editPurchaseBillUi(purchaseBills.get(i), "���");
								break;
							}
						}
						break;
					case "�����˻���":
						for(int i=0;i<purchaseReturnBills.size();i++){
							if(billId.equals(purchaseReturnBills.get(i).getId())){
								salesBillStarter.editPurchaseReturnBillUi(purchaseReturnBills.get(i), "���");
								break;
							}
						}
						break;
					}
				});
				
				return new SimpleObjectProperty<Button> (modify);
			}
			
		});
		
		modifyCopyColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BusinessProcessListBillVO, Button>, ObservableValue<Button>>(){

			@Override
			public ObservableValue<Button> call(CellDataFeatures<BusinessProcessListBillVO, Button> param) {
				BusinessProcessListBillVO bill=param.getValue();
				String billType=bill.getBillName();
				String billId=bill.getBillId();
				
				if(billType.equals(BillCategoryEnum.GIFT_BILL.toChineseString()))
					return null;
					
				Button modifyCopy=new Button("��岢����");
						
				EditInventoryBillUiStarter inventoryStarter=new EditInventoryBillUiStarter();
				EditFinanceBillsUiStarter financeStarter=new EditFinanceBillsUiStarter();
				EditSalesmanBillsUiStarter salesBillStarter=new EditSalesmanBillsUiStarter();
				
				modifyCopy.setOnAction(oa ->{
					switch(billType){
				//	case "������͵�":
				//		for(int i=0;i<giftBills.size();i++){
				//			if(billId.equals(giftBills.get(i).getId())){
								/**
								 * ������
								 */
				//				break;
				//			}
				//		}
				//		break;
					case "�ֽ���õ�":
						for(int i=0;i<cashExpenseBills.size();i++){
							if(billId.equals(cashExpenseBills.get(i).getId())){
								financeStarter.editCashExpenseBillUi(cashExpenseBills.get(i), "��岢����");
								break;
							}
						}
						break;
					case "���":
						for(int i=0;i<paymentBills.size();i++){
							if(billId.equals(paymentBills.get(i).getId())){
								financeStarter.editPaymentBillUi(paymentBills.get(i), "��岢����");
								break;
							}
						}
						break;
					case "�տ":
						for(int i=0;i<receiptBills.size();i++){
							if(billId.equals(receiptBills.get(i).getId())){
								financeStarter.editReceiptBillUi(receiptBills.get(i), "��岢����");
								break;
							}
						}
						break;
					case "��汨����":
						for(int i=0;i<inventoryWarningBills.size();i++){
							if(billId.equals(inventoryWarningBills.get(i).getId())){
								inventoryStarter.editInventoryWarningBill(inventoryWarningBills.get(i),"��岢����");
								break;
							}
						}
						break;
					case "��汨��":
						for(int i=0;i<inventoryLossBills.size();i++){
							if(billId.equals(inventoryLossBills.get(i).getId())){
								inventoryStarter.editInventoryLossBill(inventoryLossBills.get(i),"��岢����");
								break;
							}
						}
						break;
					case "��汨�絥":
						for(int i=0;i<inventoryOverBills.size();i++){
							if(billId.equals(inventoryOverBills.get(i).getId())){
								inventoryStarter.editInventoryOverBill(inventoryOverBills.get(i),"��岢����");
								break;
							}
						}
						break;
					case "���۵�":
						for(int i=0;i<salesBills.size();i++){
							if(billId.equals(salesBills.get(i).getId())){
							//	System.out.println(salesBills.get(i).getId());
								salesBillStarter.editSalesBillUi(salesBills.get(i), "��岢����");
								break;
							}
						}
						break;
					case "�����˻���":
						for(int i=0;i<salesReturnBills.size();i++){
							if(billId.equals(salesReturnBills.get(i).getId())){
								salesBillStarter.editSalesReturnBillUi(salesReturnBills.get(i), "��岢����");
								break;
							}
						}
						break;
					case "������":
						for(int i=0;i<purchaseBills.size();i++){
							if(billId.equals(purchaseBills.get(i).getId())){
								salesBillStarter.editPurchaseBillUi(purchaseBills.get(i), "��岢����");
								break;
							}
						}
						break;
					case "�����˻���":
						for(int i=0;i<purchaseReturnBills.size();i++){
							if(billId.equals(purchaseReturnBills.get(i).getId())){
								salesBillStarter.editPurchaseReturnBillUi(purchaseReturnBills.get(i), "��岢����");
								break;
							}
						}
						break;
					}
				});
						
				return new SimpleObjectProperty<Button>(modifyCopy);
			}
					
		});
	}
	
	@FXML
	protected void backToDefaultButtonListener() throws Exception{
		listItems.clear();
		listItems.addAll(billInfos);
		isChoosed=false;
	}
	
	@FXML
	protected void dateOkButtonListener() throws Exception{
		if(!isChoosed){
			listItems.clear();
			isChoosed=true;
		}
		
		for(int i=0;i<listItems.size();i++){
			Iterator<BusinessProcessListBillVO> it=listItems.iterator();
			
			while(it.hasNext()){
				BusinessProcessListBillVO bill=it.next();
				if(!isInDateRange(bill)){
					it.remove();
				}
			}
		} 
		
		for(int i=0;i<billInfos.size();i++){
			BusinessProcessListBillVO bill=billInfos.get(i);
			
			if(isInDateRange(bill)&&!isExist(bill.getBillId()))
				listItems.add(bill);
		}
	}
	
	@FXML
	protected void wareHouseOkButtonListener() throws Exception{
		String wareChosed=wareHouseTextField.getText();
		
		if(!isChoosed){
			listItems.clear();
			isChoosed=true;
		}
		
		Iterator<BusinessProcessListBillVO> it=listItems.iterator();
		
		while(it.hasNext()){
			BusinessProcessListBillVO bill=it.next();
			String ware=bill.getWare();
			
			if(!ware.equals(wareChosed)){
				it.remove();
			}
		}
		
		for(int i=0;i<billInfos.size();i++){
			BusinessProcessListBillVO bill=billInfos.get(i);
			String ware=bill.getWare();
			
			if(ware.equals(wareChosed)&&!isExist(bill.getBillId())&&!ware.equals("NONEXIST")){
				listItems.add(bill);
			}
		}
	}
	
	@FXML
	protected void exportButtonListener() throws Exception{
		HSSFWorkbook book=new HSSFWorkbook();
		HSSFSheet sheet=book.createSheet();
		HSSFRow titleRow=sheet.createRow(0);
		HSSFCell title=titleRow.createCell(0);
		Date date=new Date();
		String time=date.getDate();
		HSSFCellStyle style=book.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		
		//����
		title.setCellValue("��Ӫ���̱�    "+time);
		title.setCellStyle(style);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
		
		//����
		HSSFRow row1=sheet.createRow(1);
		
		HSSFCell attribute1=row1.createCell(0);
		attribute1.setCellStyle(style);
		attribute1.setCellValue("ʱ��");
		HSSFCell attribute2=row1.createCell(1);
		attribute2.setCellStyle(style);
		attribute2.setCellValue("��������");
		HSSFCell attribute3=row1.createCell(2);
		attribute3.setCellStyle(style);
		attribute3.setCellValue("���ݱ��");
		HSSFCell attribute4=row1.createCell(3);
		attribute4.setCellStyle(style);
		attribute4.setCellValue("������");
		
		//����
		int rowIndex=2;
		for(int i=0;i<listItems.size();i++){
			BusinessProcessListBillVO bill=listItems.get(i);
			
			HSSFRow row=sheet.createRow(rowIndex);
			
			HSSFCell cell1=row.createCell(0);
			cell1.setCellValue(bill.getDate());
			cell1.setCellStyle(style);
			HSSFCell cell2=row.createCell(1);
			cell2.setCellValue(bill.getBillName());
			cell2.setCellStyle(style);
			HSSFCell cell3=row.createCell(2);
			cell3.setCellValue(bill.getBillId());
			cell3.setCellStyle(style);
			HSSFCell cell4=row.createCell(3);
			cell4.setCellValue(bill.getCreator());
			cell4.setCellStyle(style);
			
			rowIndex++;
		}
		
		FileChooser chooser=new FileChooser();
		chooser.setInitialFileName("��Ӫ���̱�.xls");
		File file=chooser.showSaveDialog(stage);
		
		if(file!=null){
			FileOutputStream stream=new FileOutputStream(file);
			book.write(stream);
			stream.close();
		}
		
		book.close();
	}
	
	private boolean isInDateRange(BusinessProcessListBillVO bill){
		String startDate=startDatePicker.getValue().toString();
		String[] startDateParts=startDate.split("-");
		
		int startYear=Integer.parseInt(startDateParts[0]);
		int startMonth=Integer.parseInt(startDateParts[1]);
		int startDay=Integer.parseInt(startDateParts[2]);
		
		//��ʼ����
		Date start=new Date(startYear, startMonth, startDay, 0, 0);
		
		String endDate=endDatePicker.getValue().toString();
		String[] endDateParts=endDate.split("-");
		
		int endYear=Integer.parseInt(endDateParts[0]);
		int endMonth=Integer.parseInt(endDateParts[1]);
		int endDay=Integer.parseInt(endDateParts[2]);
		
		//��������
		Date end=new Date(endYear, endMonth, endDay, 23, 59);
		
		String date=bill.getDate();
				
		String[] dateParts=date.split("\\.");
				
		int dateYear=Integer.parseInt(dateParts[0]);
		int dateMonth=Integer.parseInt(dateParts[1]);
		int dateDay=Integer.parseInt(dateParts[2]);
		
		//����������
		Date current=new Date(dateYear, dateMonth, dateDay, 12, 0);
				
		if((current.compareTo(start)>=0)&&(current.compareTo(end)<=0))
			return true;
		else
			return false;
	}
	
	private boolean isExist(String billId){
		Iterator<BusinessProcessListBillVO> it=listItems.iterator();
		
		while(it.hasNext()){
			BusinessProcessListBillVO bill=it.next();
			String id=bill.getBillId();
			
			if(billId.equals(id))
				return true;
		}
			
		return false;
	}
	
	@FXML
	protected void backButtonListener(){
		FinancialStaffMainUiStarter starter=new FinancialStaffMainUiStarter();
		starter.mainUi();
	}
}
