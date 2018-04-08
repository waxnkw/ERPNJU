package ui.adminUi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import vo.UserVO;

public class AdminUiController implements AdminForAddUserController,AdminForUpdateUserController{
	private UserList userList;//�����û��ļ���
	private ObservableList<UserVO> showUserList = FXCollections.observableArrayList();//չʾ���û���list
	private UserVO currentShowUser ;//��������չʾ���û�
	
	
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
					deleteButton.setDisable(false);
					updateButton.setDisable(false);
					//showUser TODO
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
	
	@FXML Button  updateButton;
	@FXML
	protected void updateUserButtonListener(){
		UpdateUserUiStarter starter = new UpdateUserUiStarter(this, currentShowUser);
		starter.start();
	}
	
	@FXML private Button deleteButton;
	@FXML
	protected void deleteUserButtonListener(){
		Alert alert = new Alert(AlertType.CONFIRMATION,"�Ƿ����ɾ�����û�");
		Optional<ButtonType> result = alert.showAndWait();
		if(result.isPresent()&&result.get()==ButtonType.OK){
			userList.deleteUser(currentShowUser);//��ϵͳ��ɾ�����û�
			showUserList.remove(currentShowUser);//�ڵ�ǰչʾ�û��б���ɾ�����û�
			currentShowUser =null;//�����趨��ǰչʾ�û�
			showUserInformation(null);//��յ�ǰ��ʾ
		}
	}
	
	/**
	 * �����bottom����
	 * �����û���ť
	 * 
	 * */
	@FXML
	protected void addUserButtonListener(){
		AddUserUiStarter starter = new AddUserUiStarter(this);
		starter.start();
	}


	/**
	 * �����͸����û��ӿ�
	 * */
	@Override
	public boolean addUser(UserVO user){
		userList.addUser(user);
		showUserList.add(user);
		return true;
	}
	@Override
	public void updateUser(UserVO user,UserVO oldUser){
		userList.updateUser(user, oldUser);
		refreshShowUserList();
	}
	
	
	private void refreshShowUserList(){
		showUserList.clear();
		ArrayList<UserVO> list =userList.getUserList(); 
		showUserList.addAll(list);
		userTableView.refresh();
		showUserInformation(currentShowUser);
	}

	/**
	 * �����ʼ��
	 * */
	public void init(){
		initButtonDisable();
		initTextEditable();
		initUserTableView();
		initShowUserList();
	}
	
	private void initButtonDisable(){
		deleteButton.setDisable(true);
		updateButton.setDisable(true);
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
}
