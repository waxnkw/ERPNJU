/**
 * 
 */
package ui.customerUi;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;

import assistant.type.CustomerLevelEnum;
import assistant.type.UserPositionEnum;
import blService.customerBlService.CustomerBlService;
import blStubs.customerBlStubs.CustomerBlService_Stub;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import rmi.remoteHelper.CustomerRemoteHelper;
import rmi.remoteHelper.RemoteHelperFactory;
import vo.BankAccountVO;
import vo.BillVO;
import vo.CustomerVO;

/**
 * @author 王宁一
 *
 */
public class SelectCustomerUiController {
	
	private CustomerVO waitToChangedCustomer;
	
	@FXML 
	private Label queryInfoLabel;
	
	@FXML
	private TableView<CustomerVO> customerList;
	
	@FXML
	private TableColumn<CustomerVO, String> customerNameColumn;
	
	@FXML
	private TableColumn<CustomerVO, String> customerIdColumn;
	
	@FXML
	private TableColumn<CustomerVO, Button> customerSelectColumn;
	
	@FXML
	private Label userIdLabel;
	
	@FXML
	private Label customerIdLabel;
	
	@FXML
	private Label customerTypeLabel;
	
	@FXML
	private Label customerLevelLabel;
	
	@FXML
	private Label customerNameLabel;
	
	@FXML
	private Label customerAddressLabel;
	
	@FXML
	private Label customerEmailLabel;
	
	@FXML
	private Label customerTelLabel;
	
	@FXML
	private Label customerPostLabel;
	
	@FXML
	private Label customerBusinessmanLabel;
	
	@FXML
	private Label customerShouldReceive;
	
	@FXML
	private Label customerShouldPay;
	
	@FXML
	private Label customerShouldReceiveCreditLabel;
	
	@FXML
	private Button addButton;
	
	@FXML
	private Button editButton;
	
	@FXML
	private Button deleteButton;
	
	private CustomerRemoteHelper remoteHelper=RemoteHelperFactory.getCustomerRemoteHelper();
	
	private CustomerBlService service=remoteHelper.getCustomerBlService();
	
	//private CustomerBlService service=new CustomerBlService_Stub();
	
	private ObservableList<CustomerVO> customers=FXCollections.observableArrayList();
	
	public void init(String Id, String name, UserPositionEnum position) {
		
		//Text
		userIdLabel.setText("UserID: "+Id);
		customerList.setItems(customers);
		
		try {
			ArrayList<CustomerVO> customerVOs=service.QueryCustomer("");
			customers.addAll(customerVOs);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
		customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
		customerSelectColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CustomerVO,Button>, ObservableValue<Button>>() {

			@Override
			public ObservableValue<Button> call(CellDataFeatures<CustomerVO, Button> param) {
				// TODO Auto-generated method stub
				CustomerVO customerVO=param.getValue();
				
				Button select=new Button("选择");
				
				select.setOnAction(paramx->{
					showContent(customerVO);
					waitToChangedCustomer=customerVO;
				});
				
				return new SimpleObjectProperty<Button>(select);
			}
		});			
	}
	
	@FXML
	protected void queryAction()throws Exception{
		String string=queryInfoLabel.getText();
		
		ArrayList<CustomerVO> customerVOs=new ArrayList<CustomerVO>();
		customerVOs=service.QueryCustomer(string);
		
		if(customerVOs==null) {
			customers.clear();
		}else {
			customers.clear();
			customers.addAll(customerVOs);
		}
		
	}
	
	@FXML
	protected void deleteButtonListener() {
		Alert confirmation=new Alert(AlertType.CONFIRMATION);
		confirmation.setTitle("系统消息");
		confirmation.setHeaderText(null);
		confirmation.setContentText("您确定要删除该客户吗？");
		Optional<ButtonType> result=confirmation.showAndWait();
		if(result.get()==ButtonType.OK) {			
			try {
				if(service.DelCustomer(waitToChangedCustomer.getId(), waitToChangedCustomer.getName())) {
					int position=customers.indexOf(waitToChangedCustomer);
					customers.remove(position);
				}				
			} catch (RemoteException e) {
				e.printStackTrace();
			}			
		}else {
			confirmation.close();
		}				
	}
	
	@FXML
	protected void editButtonListener() {
		if(waitToChangedCustomer==null) {
			
		}else {
			EditCustomerUiStarter editCustomerUiStarter=new EditCustomerUiStarter();
			editCustomerUiStarter.editCustomer(this, waitToChangedCustomer);
		}
	}
	
	public void showContent(CustomerVO customerVO) {
		customerIdLabel.setText(customerVO.getId());
		customerTypeLabel.setText(customerVO.getType());
		customerLevelLabel.setText(customerVO.getLevel().toString());
		customerNameLabel.setText(customerVO.getName());
		customerAddressLabel.setText(customerVO.getAddress());
		customerEmailLabel.setText(customerVO.getEmail());
		customerTelLabel.setText(customerVO.getTel());
		customerPostLabel.setText(customerVO.getPost());
		customerBusinessmanLabel.setText(customerVO.getDefaultSalesman().getName());
		customerShouldReceive.setText(""+customerVO.getShouldReceive());
		customerShouldPay.setText(""+customerVO.getShouldPay());
		customerShouldReceiveCreditLabel.setText(""+customerVO.getShouldReceiveCredit());
		
	}
	
	public void changeCustomer(CustomerVO oriCustomer, CustomerVO toReplace) {		
		try {
			if(service.ModCustomer(toReplace)) {
				int position=customers.indexOf(oriCustomer);		
				customers.set(position, toReplace);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}






























