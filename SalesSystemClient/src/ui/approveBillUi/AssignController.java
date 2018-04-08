package ui.approveBillUi;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.UserPositionEnum;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import ui.adminUi.UserList;
import vo.BillVO;
import vo.UserInfoVO;
import vo.UserVO;

public class AssignController {
	private BillVO bill;
	private UserList userList;//�����û��ļ���
	private ObservableList<UserVO> showUserList = FXCollections.observableArrayList();//չʾ���û���list
	private UserVO currentShowUser ;//��������չʾ���û�
	
	protected void init(BillVO bill){
		this.bill = bill;
		initTextEditable();
		initUserTableView();
		initShowUserList();
		
	}
	
	private void initTextEditable(){
		descriptionTextArea.setEditable(false);
	}
	
	private void initShowUserList(){
		try {
			userList = new UserList();
			showUserList.addAll(userList.getUserList());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * top���ֽ���
	 * �ؼ��ֲ�ѯ����
	 * */
	@FXML	private TextField keyWordTextField;
	@FXML
	protected void searchByKeyWordButtonListener(){
		String key = keyWordTextField.getText();
		showUserList.clear();
		ArrayList<UserVO> newShowUsers = userList.searchByKeyWords(key);
		showUserList.addAll(newShowUsers);
		userTableView.refresh();
	}
	
	/**
	 * left���ֽ���
	 * ��ʾ�û��嵥��tableView
	 * */
	@FXML 	TableView<UserVO> userTableView;
	@FXML	TableColumn<UserVO, String> userTableColumn;
	
	private void initUserTableView(){
		initUserTableColumn();
		userTableView.setItems(showUserList);
	}
	
	private void initUserTableColumn(){
		userTableColumn.setCellFactory(col->{
			TextFieldTableCell<UserVO, String> tableCell = new TextFieldTableCell<>();
			tableCell.setOnMouseClicked(e->{
				int i=0;
				if(e.getClickCount()==2
						&&e.getButton().equals(MouseButton.PRIMARY)
						&&(i=tableCell.getIndex())<showUserList.size()){
					currentShowUser = showUserList.get(i);
					showUserInformation(currentShowUser);
				}
			});
			return tableCell;
		});
		userTableColumn.setCellValueFactory(cellDataFeature->{
			UserVO user = cellDataFeature.getValue();
			String userName = user.getName();
			ObservableValue<String> name = new SimpleStringProperty(userName);
			return name;
		});
	}

	/**
	 * ����center����
	 * �û�������Ϣ����ʾ
	 * textField textArea 
	 * �����û���Ϣ��ɾ���û���Ϣ��ť
	 * */
	@FXML 	Text nameText;
	@FXML   Text idText;
	@FXML	Text ageText;
	@FXML	Text positionText;
	@FXML	TextArea descriptionTextArea;
	
	private void showUserInformation(UserVO user){
		if(user==null){
			nameText.setText(null);
			idText.setText(null);
			ageText.setText(null);
			positionText.setText(null);
			descriptionTextArea.setText(null);
			return;
		}
		nameText.setText(user.getName());
		idText.setText(user.getId());
		ageText.setText(user.getAge()+"");
		positionText.setText(user.getPosition().toChineseString());
		descriptionTextArea.setText(user.getDescription());
	}
	
	@FXML
	protected void setExecutor(Event e){
		String name = currentShowUser.getName();
		String id = currentShowUser.getId();
		UserPositionEnum position = currentShowUser.getPosition();
		UserInfoVO userInfo = new UserInfoVO(id,name,position);
		bill.setExecutor(userInfo);
		((Node)(e.getSource())).getScene().getWindow().hide();
	}
}
