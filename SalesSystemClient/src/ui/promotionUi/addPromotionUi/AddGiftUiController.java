package ui.promotionUi.addPromotionUi;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import ui.promotionUi.bLobj.Goods;
import vo.GiftVO;

public class AddGiftUiController {
	HashMap<GiftVO, Goods> giftGoodsMap= new HashMap<>();
	private PromotionUiForGiftsUiController controller;//�������controller
	private ObservableList<Goods> goodsList ;//��Ʒ�嵥
	private ObservableList<GiftVO> giftsList = FXCollections.observableArrayList();//��������Ʒ�����Ż���Ʒ
	private Goods currentShowGoods;//��������չʾ����Ʒ
	
	
	/***************************************************************************
     *                                                                         *
     * �������Ʒ��Ϣ��ʾ                                                           *
     *                                                                         *
     **************************************************************************/
	@FXML
	private Text nameText;
	@FXML
	private Text idText;
	@FXML
	private Text classificationText;
	@FXML
	private Text amountText;
	@FXML
	private Text costPriceText;
	@FXML
	private Text sellPriceText;
	@FXML
	Button addButton;
	
	//������Ʒ��Ϣ��ʾ
	private void showGoods(Goods goods){
		nameText.setText(goods.getName());
		idText.setText(goods.getId());
		classificationText.setText(goods.getClassification());
		amountText.setText(goods.getAmount()+"");
		costPriceText.setText(goods.getCostPrice()+"");
		sellPriceText.setText(goods.getSellingPrice()+"");
		setAddButtonDisable(goods);
	}
	
	//setAddButton��
	private void setAddButtonDisable(Goods goods){
		addButton.setDisable(goods.isAddedToGift());
	}
	//addButton�ļ�����
	@FXML
	protected void addButtonListener(Event e){
		addToGift(currentShowGoods);
		setAddButtonDisable(currentShowGoods);
	}
	/****************************************************************************************/	
	
	
	/***************************************************************************
     *                                                                         *
     * ��Ʒ�嵥��ListView������ʾ                                                           *
     *                                                                         *
     **************************************************************************/
	@FXML
	TableView<Goods> goodsTableView;
	@FXML
	TableColumn<Goods, String> goodsTableColumn;
	private void setGoodsTableView(){
		
		goodsTableColumn.setCellFactory(col->{
			TableCell<Goods,String> tableCell= new TableCell<Goods,String>(){
				@Override 
				protected void updateItem(String s,boolean empty){
					int i= this.getIndex();
					if(!empty){
						Goods goods =goodsList.get(i); 
						this.setText(goods.getName());
					}
				}
				
			};
			
			tableCell.setOnMouseClicked(e->{
				int i=0;
				if(e.getButton().equals(MouseButton.PRIMARY)
						&&e.getClickCount()==2
						&&(i=tableCell.getIndex())<goodsList.size()){
					currentShowGoods= goodsList.get(i);
					showGoods(currentShowGoods);
				}
			});
			return tableCell;
		});
		goodsTableView.setItems(goodsList);
	}
	/****************************************************************************************/
	
	
	/***************************************************************************
     *                                                                         *
     * ��Ʒ�嵥��ListView������ʾ                                                           *
     *                                                                         *
     **************************************************************************/
	@FXML
	TableView<GiftVO> giftsTableView;
	@FXML
	TableColumn<GiftVO, String> giftsTableColumn;
	
	private void setGiftsTableView(){	
		giftsTableColumn.setCellFactory(col->{
			TableCell<GiftVO,String> tableCell= new TableCell<GiftVO,String>(){
				@Override 
				protected void updateItem(String s,boolean empty){
					int i= this.getIndex();
					if(!empty&&i<giftsList.size()){
						GiftVO gift =giftsList.get(i); 
						this.setText(gift.getName());
					}
				}
				
			};
			//˫����ʾ��Ʒ��Ϣ
			tableCell.setOnMouseClicked(e->{
				int i=0;
				if(e.getButton().equals(MouseButton.PRIMARY)
						&&e.getClickCount()==2
						&&(i=tableCell.getIndex())<giftsList.size()){
					GiftVO gift = giftsList.get(i);
					showGoods(giftGoodsMap.get(gift));
				}
			});
			
			
			ContextMenu contextMenu = new ContextMenu();
			MenuItem showMenuItem = new MenuItem("�鿴");
			showMenuItem.setOnAction(e->{
				int i= tableCell.getIndex();
				GiftVO gift =i<0?null:giftsList.get(i);
				if(gift!=null){
					Goods goods = giftGoodsMap.get(gift);
					showGoods(goods);
				}
			});
			MenuItem deleteMenuItem = new MenuItem("ɾ��");
			deleteMenuItem.setOnAction(e->{
				int i= tableCell.getIndex();
				GiftVO gift =i<0?null:giftsList.get(i);
				deleteGift(gift);
			});
			
			contextMenu.getItems().add(showMenuItem);
			contextMenu.getItems().add(deleteMenuItem);
			
			tableCell.setContextMenu(contextMenu);
			return tableCell;
		});
		
		giftsTableView.setItems(giftsList);
	}
	/****************************************************************************************/
	
	/***************************************************************************
     *                                                                         *
     * ȷ����ȡ����ť������                                                        *
     *                                                                         *
     **************************************************************************/
	@FXML
	protected void ensureButtonListener(Event e){
		controller.addGifts(giftsList,giftGoodsMap);
		((Node)e.getSource()).getScene().getWindow().hide();
	}
	@FXML
	protected void cancelButtonListener(Event e){
		((Node)e.getSource()).getScene().getWindow().hide();
	}
	/****************************************************************************************/
	
	//controller�ĳ�ʼ������
	protected void init(){
		goodsList = controller.getGoodsList();
		setGoodsTableView();
		setGiftsTableView();
		if(currentShowGoods!=null){
			showGoods(currentShowGoods);
		}
	}
	
	
	//����promotion controller
	protected void setAddPromotionUiController(PromotionUiForGiftsUiController controller){
		this.controller = controller;
	}
	protected void setCurrentShowGoods(GiftVO gift){
		for(int i=0;i<goodsList.size();i++){
			Goods goods = goodsList.get(i);
			if(gift.getId().equals(goods.getId())){
				showGoods(goods);
				return;
			}
		}
	}
	
	
	//��goods��ӵ�gift
	private void addToGift(Goods goods){
		goods.setAddedToGift(true);
//		setAddButtonDisable(goods);
		GiftVO gift = goods.toGiftVO();
		giftsList.add(gift);
		giftGoodsMap.put(gift, goods);
	}
	//������ӵ�giftɾ��
	private void deleteGift(GiftVO gift){
		Goods goods= giftGoodsMap.get(gift);
		goods.setAddedToGift(false);
		giftGoodsMap.remove(gift);
		giftsList.remove(gift);
		giftsTableView.refresh();
	}
}
