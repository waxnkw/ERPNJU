package blStubs.listBlStubs;

import java.rmi.RemoteException;
import java.util.ArrayList;
import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.type.CustomerLevelEnum;
import assistant.utility.Date;
import blService.listBlService.BusinessProcessListBlService;
import vo.BillEntryVO;
import vo.BusinessProcessListBillVO;
import vo.BusinessProcessListVO;
import vo.CashExpenseBillVO;
import vo.CustomerInfoVO;
import vo.CustomerVO;
import vo.GiftBillVO;
import vo.InventoryLossBillVO;
import vo.InventoryOverBillVO;
import vo.InventoryWarningBillVO;
import vo.PaymentBillVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.ReceiptBillVO;
import vo.SalesBillVO;
import vo.SalesGoodsVO;
import vo.SalesReturnBillVO;
import vo.UserInfoVO;
import vo.UserVO;

/**
 * �鿴��Ӫ���̱��߼��ӿڵ�׮
 * @author guxinyu
 * @version 2017.12.27
 *
 */
public class BusinessProcessListBlService_Stub implements BusinessProcessListBlService{
	@Override
	public BusinessProcessListVO getBusinessProcessList(){
		
		InventoryWarningBillVO iwb=new InventoryWarningBillVO();
		iwb.setApproveDate(new Date());
		iwb.setApprover(new UserInfoVO("mememe","4561534"));
		iwb.setApproverComment("ͨ��");
		iwb.setBillStateEnum(BillStateEnum.DONE);
		iwb.setCategoryEnum(BillCategoryEnum.INVENTORY_WARNING_BILL);
		iwb.setCreateDate(new Date());
		iwb.setCreater(new UserInfoVO("yoii","16546848"));
		iwb.setCreaterComment("������");
		iwb.setExecutor(new UserInfoVO("hueiu","151654"));
		iwb.setFinishDate(new Date());
		iwb.setGoodsID("0115");
		iwb.setGoodsName("�������");
		iwb.setGoodsPrice("5000");
		iwb.setGoodsType("XX9H-CHECU");
		iwb.setId("KCBJD-20171128-15642");
		iwb.setLossAmount("2");
		iwb.setSystemAmount("32");
		iwb.setWarningAmount("34");
		ArrayList<InventoryWarningBillVO> iwbArray=new ArrayList<InventoryWarningBillVO>();
		iwbArray.add(iwb);
		
		InventoryOverBillVO iob=new InventoryOverBillVO();
		iob.setApproveDate(new Date());
		iob.setApprover(new UserInfoVO("mememe","4561534"));
		iob.setApproverComment("ͨ��");
		iob.setBillStateEnum(BillStateEnum.DONE);
		iob.setCategoryEnum(BillCategoryEnum.INVENTORY_WARNING_BILL);
		iob.setCreateDate(new Date());
		iob.setCreater(new UserInfoVO("yoii","16546848"));
		iob.setCreaterComment("������");
		iob.setExecutor(new UserInfoVO("hueiu","151654"));
		iob.setFinishDate(new Date());
		iob.setGoodsID("0115");
		iob.setGoodsName("�������");
		iob.setGoodsPrice("5000");
		iob.setGoodsType("XX9H-CHECU");
		iob.setId("KCBYD-20171113-18642");
		iob.setSystemAmount("32");
		ArrayList<InventoryOverBillVO> iobArray=new ArrayList<InventoryOverBillVO>();
		iobArray.add(iob);
		
		InventoryLossBillVO ilb=new InventoryLossBillVO();
		ilb.setApproveDate(new Date());
		ilb.setApprover(new UserInfoVO("mememe","4561534"));
		ilb.setApproverComment("ͨ��");
		ilb.setBillStateEnum(BillStateEnum.DONE);
		ilb.setCategoryEnum(BillCategoryEnum.INVENTORY_WARNING_BILL);
		ilb.setCreateDate(new Date());
		ilb.setCreater(new UserInfoVO("yoii","16546848"));
		ilb.setCreaterComment("������");
		ilb.setExecutor(new UserInfoVO("hueiu","151654"));
		ilb.setFinishDate(new Date());
		ilb.setGoodsID("0115");
		ilb.setGoodsName("�������");
		ilb.setGoodsPrice("5000");
		ilb.setGoodsType("XX9H-CHECU");
		ilb.setId("KCBSD-20170102-15642");
		ilb.setSystemAmount("32");
		ArrayList<InventoryLossBillVO> ilbArray=new ArrayList<InventoryLossBillVO>();
		ilbArray.add(ilb);

		PurchaseBillVO pb=new PurchaseBillVO();
		pb.setApproveDate(new Date());
		pb.setApprover(new UserInfoVO("mememe","4561534"));
		pb.setApproverComment("ͨ��");
		pb.setBillStateEnum(BillStateEnum.DONE);
		pb.setCategoryEnum(BillCategoryEnum.INVENTORY_WARNING_BILL);
		pb.setCreateDate(new Date());
		pb.setCreater(new UserInfoVO("yoii","16546848"));
		pb.setCreaterComment("������");
		pb.setExecutor(new UserInfoVO("hueiu","151654"));
		pb.setFinishDate(new Date());
		ArrayList<SalesGoodsVO> list=new ArrayList<SalesGoodsVO>();
		SalesGoodsVO goods1=new SalesGoodsVO();
		goods1.setComment("���渶��");
		goods1.setGoodsId("5165");
		goods1.setGoodsName("�������");
		goods1.setGoodsType("XXX-SDHU");
		goods1.setNumber(50);
		goods1.setSum(250000);
		goods1.setUnitPrice(5000);
		SalesGoodsVO goods2=new SalesGoodsVO();
		goods2.setComment("���渶��");
		goods2.setGoodsId("5165");
		goods2.setGoodsName("��ͷ��");
		goods2.setGoodsType("XXX-SDHU");
		goods2.setNumber(40);
		goods2.setSum(120000);
		goods2.setUnitPrice(3000);
		list.add(goods1);
		list.add(goods2);
		pb.setGoodsList(list);
		pb.setId("JHD-20170815-45321");
		pb.setMoney(370000);
		CustomerVO cus=new CustomerVO();
		cus.setId("001");
		cus.setName("mama");
		pb.setSupplier(cus);
		pb.setWare(5);
		ArrayList<PurchaseBillVO> pbArray=new ArrayList<PurchaseBillVO>();
		pbArray.add(pb);
		
		PurchaseReturnBillVO prb=new PurchaseReturnBillVO();
		prb.setApproveDate(new Date());
		prb.setApprover(new UserInfoVO("mememe","4561534"));
		prb.setApproverComment("ͨ��");
		prb.setBillStateEnum(BillStateEnum.DONE);
		prb.setCategoryEnum(BillCategoryEnum.PURCHASE_RETURN_BILL);
		prb.setCreateDate(new Date());
		prb.setCreater(new UserInfoVO("yoii","16546848"));
		prb.setCreaterComment("������");
		prb.setExecutor(new UserInfoVO("hueiu","151654"));
		prb.setFinishDate(new Date());
		ArrayList<SalesGoodsVO> list2=new ArrayList<SalesGoodsVO>();
		SalesGoodsVO goods3=new SalesGoodsVO();
		goods3.setComment("���渶��");
		goods3.setGoodsId("5165");
		goods3.setGoodsName("�������");
		goods3.setGoodsType("XXX-SDHU");
		goods3.setNumber(50);
		goods3.setSum(250000);
		goods3.setUnitPrice(5000);
		SalesGoodsVO goods4=new SalesGoodsVO();
		goods4.setComment("���渶��");
		goods4.setGoodsId("5165");
		goods4.setGoodsName("��ͷ��");
		goods4.setGoodsType("XXX-SDHU");
		goods4.setNumber(40);
		goods4.setSum(120000);
		goods4.setUnitPrice(3000);
		list2.add(goods3);
		list2.add(goods4);
		prb.setGoodsList(list2);
		prb.setId("JHTHD-20170102-15642");
		prb.setMoney(370000);
		CustomerVO cus2=new CustomerVO();
		cus.setId("001");
		cus.setName("mama");
		prb.setSupplier(cus2);
		prb.setWare(5);
		ArrayList<PurchaseReturnBillVO> prbArray=new ArrayList<PurchaseReturnBillVO>();
		prbArray.add(prb);
		
		SalesBillVO sb=new SalesBillVO();
		sb.setApproveDate(new Date());
		sb.setApprover(new UserInfoVO("mememe","4561534"));
		sb.setApproverComment("ͨ��");
		sb.setBillStateEnum(BillStateEnum.DONE);
		sb.setCategoryEnum(BillCategoryEnum.SALES_BILL);
		sb.setCreateDate(new Date());
		sb.setCreater(new UserInfoVO("yoii","16546848"));
		sb.setCreaterComment("������");
		sb.setExecutor(new UserInfoVO("hueiu","151654"));
		sb.setFinishDate(new Date());
		ArrayList<SalesGoodsVO> list3=new ArrayList<SalesGoodsVO>();
		SalesGoodsVO goods5=new SalesGoodsVO();
		goods5.setComment("���渶��");
		goods5.setGoodsId("5165");
		goods5.setGoodsName("�������");
		goods5.setGoodsType("XXX-SDHU");
		goods5.setNumber(50);
		goods5.setSum(250000);
		goods5.setUnitPrice(5000);
		SalesGoodsVO goods6=new SalesGoodsVO();
		goods6.setComment("���渶��");
		goods6.setGoodsId("5165");
		goods6.setGoodsName("��ͷ��");
		goods6.setGoodsType("XXX-SDHU");
		goods6.setNumber(40);
		goods6.setSum(120000);
		goods6.setUnitPrice(3000);
		list3.add(goods5);
		list3.add(goods6);
		sb.setGoodsList(list2);
		sb.setId("XSD-20170102-15642");
		sb.setMoney(370000);
		CustomerVO cus3=new CustomerVO();
		cus3.setId("001");
		cus3.setName("mama");
		sb.setCustomer(cus3);
		sb.setWare(5);
		sb.setOriMoney(560000);
		sb.setDiscount(2000);
		sb.setCoupon(323);
		sb.setActualMoney(5651);
		UserInfoVO bus=new UserInfoVO();
		bus.setId("21315");
		bus.setName("mkak");
		sb.setBusinessman(bus);
		ArrayList<SalesBillVO> sbArray=new ArrayList<SalesBillVO>();
		sbArray.add(sb);
		
		SalesReturnBillVO srb=new SalesReturnBillVO();
		srb.setApproveDate(new Date());
		srb.setApprover(new UserInfoVO("mememe","4561534"));
		srb.setApproverComment("ͨ��");
		srb.setBillStateEnum(BillStateEnum.DONE);
		srb.setCategoryEnum(BillCategoryEnum.PURCHASE_RETURN_BILL);
		srb.setCreateDate(new Date());
		srb.setCreater(new UserInfoVO("yoii","16546848"));
		srb.setCreaterComment("������");
		srb.setExecutor(new UserInfoVO("hueiu","151654"));
		srb.setFinishDate(new Date());
		ArrayList<SalesGoodsVO> list4=new ArrayList<SalesGoodsVO>();
		SalesGoodsVO goods7=new SalesGoodsVO();
		goods7.setComment("���渶��");
		goods7.setGoodsId("5165");
		goods7.setGoodsName("�������");
		goods7.setGoodsType("XXX-SDHU");
		goods7.setNumber(50);
		goods7.setSum(250000);
		goods7.setUnitPrice(5000);
		SalesGoodsVO goods8=new SalesGoodsVO();
		goods8.setComment("���渶��");
		goods8.setGoodsId("5165");
		goods8.setGoodsName("��ͷ��");
		goods8.setGoodsType("XXX-SDHU");
		goods8.setNumber(40);
		goods8.setSum(120000);
		goods8.setUnitPrice(3000);
		list4.add(goods7);
		list4.add(goods8);
		srb.setGoodsList(list4);
		srb.setId("XSTHD-20171012-15642");
		srb.setMoney(370000);
		CustomerVO cus4=new CustomerVO();
		cus4.setId("001");
		cus4.setName("mama");
		srb.setCustomer(cus4);
		srb.setWare(5);
		UserInfoVO bus2=new UserInfoVO();
		bus2.setId("21315");
		bus2.setName("mkak");
		srb.setBusinessman(bus2);
		ArrayList<SalesReturnBillVO> srbArray=new ArrayList<SalesReturnBillVO>();
		srbArray.add(srb);
		
		BillEntryVO entry1=new BillEntryVO("�������","5000");
		BillEntryVO entry2=new BillEntryVO("��ͷ��","500");
		BillEntryVO entry3=new BillEntryVO("������","2000");
		ArrayList<BillEntryVO> entries1=new ArrayList<BillEntryVO>();
		entries1.add(entry1);
		entries1.add(entry2);
		entries1.add(entry3);
		UserInfoVO maker1=new UserInfoVO();
		maker1.setName("����");
		maker1.setId("123456");
		ReceiptBillVO rb=new ReceiptBillVO(maker1,"һ���˻�",entries1,7500.0,"�ͻ�����",new Date());
		rb.setApproveDate(new Date());
		rb.setApprover(new UserInfoVO("mememe","4561534"));
		rb.setApproverComment("ͨ��");
		rb.setBillStateEnum(BillStateEnum.DONE);
		rb.setCategoryEnum(BillCategoryEnum.RECEIPT_BILL);
		rb.setCreateDate(new Date());
		rb.setCreater(new UserInfoVO("yoii","16546848"));
		rb.setCreaterComment("������");
		rb.setExecutor(new UserInfoVO("hueiu","151654"));
		rb.setFinishDate(new Date());
		ArrayList<ReceiptBillVO> rbArray=new ArrayList<ReceiptBillVO>();
		rbArray.add(rb);

		BillEntryVO entry4=new BillEntryVO("�������","5000");
		BillEntryVO entry5=new BillEntryVO("��ͷ��","500");
		BillEntryVO entry6=new BillEntryVO("������","2000");
		ArrayList<BillEntryVO> entries2=new ArrayList<BillEntryVO>();
		entries2.add(entry4);
		entries2.add(entry5);
		entries2.add(entry6);
		UserInfoVO maker2=new UserInfoVO();
		maker2.setName("����");
		maker2.setId("123456");
		PaymentBillVO pmb=new PaymentBillVO(maker2,"һ���˻�",entries2,7500.0,"�ͻ�����",new Date());
		pmb.setApproveDate(new Date());
		pmb.setApprover(new UserInfoVO("mememe","4561534"));
		pmb.setApproverComment("ͨ��");
		pmb.setBillStateEnum(BillStateEnum.DONE);
		pmb.setCategoryEnum(BillCategoryEnum.PAYMENT_BILL);
		pmb.setCreateDate(new Date());
		pmb.setCreater(new UserInfoVO("yoii","16546848"));
		pmb.setCreaterComment("������");
		pmb.setExecutor(new UserInfoVO("hueiu","151654"));
		pmb.setFinishDate(new Date());
		ArrayList<PaymentBillVO> pmbArray=new ArrayList<PaymentBillVO>();
		pmbArray.add(pmb);
		
		BillEntryVO entry7=new BillEntryVO("�������","5000");
		BillEntryVO entry8=new BillEntryVO("��ͷ��","500");
		BillEntryVO entry9=new BillEntryVO("������","2000");
		ArrayList<BillEntryVO> entries3=new ArrayList<BillEntryVO>();
		entries3.add(entry7);
		entries3.add(entry8);
		entries3.add(entry9);
		UserInfoVO maker3=new UserInfoVO();
		maker3.setName("����");
		maker3.setId("123456");
		CashExpenseBillVO ceb=new CashExpenseBillVO(maker3,"һ���˻�",entries3,7500.0,"�ͻ�����",new Date());
		ceb.setApproveDate(new Date());
		ceb.setApprover(new UserInfoVO("mememe","4561534"));
		ceb.setApproverComment("ͨ��");
		ceb.setBillStateEnum(BillStateEnum.DONE);
		ceb.setCategoryEnum(BillCategoryEnum.CASH_EXPENSE_BILL);
		ceb.setCreateDate(new Date());
		ceb.setCreater(new UserInfoVO("yoii","16546848"));
		ceb.setCreaterComment("������");
		ceb.setExecutor(new UserInfoVO("hueiu","151654"));
		ceb.setFinishDate(new Date());
		ArrayList<CashExpenseBillVO> cebArray=new ArrayList<CashExpenseBillVO>();
		cebArray.add(ceb);
		
		GiftBillVO gb=new GiftBillVO();
		gb.setApproveDate(new Date());
		gb.setApprover(new UserInfoVO("mememe","4561534"));
		gb.setApproverComment("ͨ��");
		gb.setBillStateEnum(BillStateEnum.DONE);
		gb.setCategoryEnum(BillCategoryEnum.GIFT_BILL);
		gb.setCreateDate(new Date());
		gb.setCreater(new UserInfoVO("yoii","16546848"));
		gb.setCreaterComment("������");
		gb.setExecutor(new UserInfoVO("hueiu","151654"));
		gb.setFinishDate(new Date());
		gb.setId("KCZSD-20171130-15642");
		ArrayList<GiftBillVO> gbArray=new ArrayList<GiftBillVO>();
		gbArray.add(gb);
		
		ArrayList<BusinessProcessListBillVO> bills=new ArrayList<BusinessProcessListBillVO>();
		
		BusinessProcessListBillVO bill1=new BusinessProcessListBillVO(
				"2017.1.2","�ֽ���õ�","XJFYD-20170102-15642","��",
				"00001","NONEXIST","NONEXIST");
		
		BusinessProcessListBillVO bill2=new BusinessProcessListBillVO(
				"2017.8.5","�տ","SKD-20170805-15142","��",
				"00001","NONEXIST","NONEXIST");
		
		BusinessProcessListBillVO bill3=new BusinessProcessListBillVO(
				"2017.8.6","���","FKD-20170806-15642","һ",
				"00005","NONEXIST","NONEXIST");
		
		BusinessProcessListBillVO bill4=new BusinessProcessListBillVO(
				"2017.8.15","������","JHD-20170815-45321","ʮ��",
				"00006","00002","05");
		
		BusinessProcessListBillVO bill5=new BusinessProcessListBillVO(
				"2017.9.5","�����˻���","JHTHD-20170102-15642","��",
				"00010","00004","06");
		
		BusinessProcessListBillVO bill6=new BusinessProcessListBillVO(
				"2017.9.5","���۵�","XSD-20170102-15642","��",
				"00008","00012","04");
		
		BusinessProcessListBillVO bill7=new BusinessProcessListBillVO(
				"2017.10.12","�����˻���","XSTHD-20171012-15642","ʮ",
				"00001","00002","01");
		
		BusinessProcessListBillVO bill8=new BusinessProcessListBillVO(
				"2017.11.13","��汨�絥","KCBYD-20171113-18642","ʮ��",
				"NONEXSIT","00007","08");
		
		BusinessProcessListBillVO bill9=new BusinessProcessListBillVO(
				"2017.11.25","��汨��","KCBSD-20170102-15642","ʮһ",
				"NONEXSIT","00002","05");
		
		BusinessProcessListBillVO bill10=new BusinessProcessListBillVO(
				"2017.11.28","��汨����","KCBJD-20171128-15642","��",
				"NONEXSIT","00004","04");
		
		BusinessProcessListBillVO bill11=new BusinessProcessListBillVO(
				"2017.11.30","������͵�","KCZSD-20171130-15642","��",
				"00005","00002","01");
		
	//	BusinessProcessListBillVO bill12=new BusinessProcessListBillVO(
	//			"2017.12.1","�ֽ���õ�","XJFYD-20171201-15322","��",
	//			"00001","NONEXIST","NONEXIST");
		
	//	BusinessProcessListBillVO bill13=new BusinessProcessListBillVO(
	//			"2017.12.2","�ֽ���õ�","XJFYD-20171202-15642","��",
	//			"00001","NONEXIST","NONEXIST");
		
	//	BusinessProcessListBillVO bill14=new BusinessProcessListBillVO(
	//			"2017.12.6","���","FKD-20171206-15642","ʮһ",
	//			"00008","NONEXIST","NONEXIST");
		
		bills.add(bill1);
		bills.add(bill2);
		bills.add(bill3);
		bills.add(bill4);
		bills.add(bill5);
		bills.add(bill6);
		bills.add(bill7);
		bills.add(bill8);
		bills.add(bill9);
		bills.add(bill10);
		bills.add(bill11);
	//	bills.add(bill12);
	//	bills.add(bill13);
	//	bills.add(bill14);
		
		BusinessProcessListVO toReturn=new BusinessProcessListVO();
		toReturn.setBills(bills);
		toReturn.setCashExpenseBills(cebArray);
		toReturn.setGiftBills(gbArray);
		toReturn.setInventoryLossBills(ilbArray);
		toReturn.setInventoryOverBills(iobArray);
		toReturn.setInventoryWarningBills(iwbArray);
		toReturn.setPaymentBills(pmbArray);
		toReturn.setPurchaseBills(pbArray);
		toReturn.setPurchaseReturnBills(prbArray);
		toReturn.setReceiptBills(rbArray);
		toReturn.setSalesBills(sbArray);
		toReturn.setSalesReturnBills(srbArray);
		
		return toReturn;
	}


	@Override
	public ArrayList<UserVO> getWareKeeperList() throws RemoteException {
		ArrayList<UserVO> toReturn=new ArrayList<UserVO>();
		
		UserVO user1=new UserVO();
		user1.setName("һ");
		user1.setId("00001");
		
		UserVO user2=new UserVO();
		user2.setName("��");
		user2.setId("00002");
		
		UserVO user3=new UserVO();
		user3.setName("��");
		user3.setId("00003");
		
		UserVO user4=new UserVO();
		user4.setName("��");
		user4.setId("00004");
		
		UserVO user5=new UserVO();
		user5.setName("��");
		user5.setId("00005");
		
		UserVO user6=new UserVO();
		user6.setName("��");
		user6.setId("00006");
		
		UserVO user7=new UserVO();
		user7.setName("��");
		user7.setId("00007");
		
		UserVO user8=new UserVO();
		user8.setName("��");
		user8.setId("00008");
		
		UserVO user9=new UserVO();
		user9.setName("��");
		user9.setId("00009");
		
		UserVO user10=new UserVO();
		user10.setName("ʮ");
		user10.setId("00010");
		
		UserVO user11=new UserVO();
		user11.setName("ʮһ");
		user11.setId("00011");
		
		UserVO user12=new UserVO();
		user12.setName("ʮ��");
		user12.setId("00012");
		
		UserVO user13=new UserVO();
		user13.setName("ʮ��");
		user13.setId("00013");
		
		UserVO user14=new UserVO();
		user14.setName("ʮ��");
		user14.setId("00014");
		
		toReturn.add(user1);
		toReturn.add(user2);
		toReturn.add(user3);
		toReturn.add(user4);
		toReturn.add(user5);
		toReturn.add(user6);
		toReturn.add(user7);
		toReturn.add(user8);
		toReturn.add(user9);
		toReturn.add(user10);
		toReturn.add(user11);
		toReturn.add(user12);
		toReturn.add(user13);
		toReturn.add(user14);
		
		return toReturn;
	}

	@Override
	public ArrayList<UserVO> getSalesmanList() throws RemoteException {
		ArrayList<UserVO> toReturn=new ArrayList<UserVO>();
		
		UserVO user1=new UserVO();
		user1.setName("һ");
		user1.setId("00015");
		
		UserVO user2=new UserVO();
		user2.setName("��");
		user2.setId("00016");
		
		UserVO user3=new UserVO();
		user3.setName("��");
		user3.setId("00017");
		
		UserVO user4=new UserVO();
		user4.setName("��");
		user4.setId("00018");
		
		UserVO user5=new UserVO();
		user5.setName("��");
		user5.setId("00019");
		
		UserVO user6=new UserVO();
		user6.setName("��");
		user6.setId("00020");
		
		UserVO user7=new UserVO();
		user7.setName("��");
		user7.setId("00021");
		
		UserVO user8=new UserVO();
		user8.setName("��");
		user8.setId("00022");
		
		UserVO user9=new UserVO();
		user9.setName("��");
		user9.setId("00023");
		
		UserVO user10=new UserVO();
		user10.setName("ʮ");
		user10.setId("00024");
		
		UserVO user11=new UserVO();
		user11.setName("ʮһ");
		user11.setId("00025");
		
		UserVO user12=new UserVO();
		user12.setName("ʮ��");
		user12.setId("00026");
		
		UserVO user13=new UserVO();
		user13.setName("ʮ��");
		user13.setId("00027");
		
		UserVO user14=new UserVO();
		user14.setName("ʮ��");
		user14.setId("00028");
		
		toReturn.add(user1);
		toReturn.add(user2);
		toReturn.add(user3);
		toReturn.add(user4);
		toReturn.add(user5);
		toReturn.add(user6);
		toReturn.add(user7);
		toReturn.add(user8);
		toReturn.add(user9);
		toReturn.add(user10);
		toReturn.add(user11);
		toReturn.add(user12);
		toReturn.add(user13);
		toReturn.add(user14);
		
		return toReturn;
	}

	@Override
	public ArrayList<UserVO> getFinancialStaffList() throws RemoteException {
		ArrayList<UserVO> toReturn=new ArrayList<UserVO>();
		
		UserVO user1=new UserVO();
		user1.setName("һ");
		user1.setId("00029");
		
		UserVO user2=new UserVO();
		user2.setName("��");
		user2.setId("00030");
		
		UserVO user3=new UserVO();
		user3.setName("��");
		user3.setId("00031");
		
		UserVO user4=new UserVO();
		user4.setName("��");
		user4.setId("00032");
		
		UserVO user5=new UserVO();
		user5.setName("��");
		user5.setId("00033");
		
		UserVO user6=new UserVO();
		user6.setName("��");
		user6.setId("00034");
		
		UserVO user7=new UserVO();
		user7.setName("��");
		user7.setId("00035");
		
		UserVO user8=new UserVO();
		user8.setName("��");
		user8.setId("00036");
		
		UserVO user9=new UserVO();
		user9.setName("��");
		user9.setId("00037");
		
		UserVO user10=new UserVO();
		user10.setName("ʮ");
		user10.setId("00038");
		
		UserVO user11=new UserVO();
		user11.setName("ʮһ");
		user11.setId("00039");
		
		UserVO user12=new UserVO();
		user12.setName("ʮ��");
		user12.setId("00040");
		
		UserVO user13=new UserVO();
		user13.setName("ʮ��");
		user13.setId("00041");
		
		UserVO user14=new UserVO();
		user14.setName("ʮ��");
		user14.setId("00042");
		
		toReturn.add(user1);
		toReturn.add(user2);
		toReturn.add(user3);
		toReturn.add(user4);
		toReturn.add(user5);
		toReturn.add(user6);
		toReturn.add(user7);
		toReturn.add(user8);
		toReturn.add(user9);
		toReturn.add(user10);
		toReturn.add(user11);
		toReturn.add(user12);
		toReturn.add(user13);
		toReturn.add(user14);
		
		return toReturn;
	}
	
	@Override
	public ArrayList<UserVO> getManagerList() throws RemoteException {
		ArrayList<UserVO> toReturn=new ArrayList<UserVO>();
		
		UserVO user1=new UserVO();
		user1.setName("һ");
		user1.setId("00043");
		
		UserVO user2=new UserVO();
		user2.setName("��");
		user2.setId("00044");
		
		UserVO user3=new UserVO();
		user3.setName("��");
		user3.setId("00045");
		
		UserVO user4=new UserVO();
		user4.setName("��");
		user4.setId("00046");
		
		UserVO user5=new UserVO();
		user5.setName("��");
		user5.setId("00047");
		
		UserVO user6=new UserVO();
		user6.setName("��");
		user6.setId("00048");
		
		UserVO user7=new UserVO();
		user7.setName("��");
		user7.setId("00049");
		
		UserVO user8=new UserVO();
		user8.setName("��");
		user8.setId("00050");
		
		UserVO user9=new UserVO();
		user9.setName("��");
		user9.setId("00051");
		
		UserVO user10=new UserVO();
		user10.setName("ʮ");
		user10.setId("00052");
		
		UserVO user11=new UserVO();
		user11.setName("ʮһ");
		user11.setId("00053");
		
		UserVO user12=new UserVO();
		user12.setName("ʮ��");
		user12.setId("00054");
		
		UserVO user13=new UserVO();
		user13.setName("ʮ��");
		user13.setId("00055");
		
		UserVO user14=new UserVO();
		user14.setName("ʮ��");
		user14.setId("00056");
		
		toReturn.add(user1);
		toReturn.add(user2);
		toReturn.add(user3);
		toReturn.add(user4);
		toReturn.add(user5);
		toReturn.add(user6);
		toReturn.add(user7);
		toReturn.add(user8);
		toReturn.add(user9);
		toReturn.add(user10);
		toReturn.add(user11);
		toReturn.add(user12);
		toReturn.add(user13);
		toReturn.add(user14);
		
		return toReturn;
	}

	@Override
	public ArrayList<CustomerInfoVO> getCustomerList() throws RemoteException {
		ArrayList<CustomerInfoVO> toReturn=new ArrayList<CustomerInfoVO>();
		
		CustomerInfoVO cus1=new CustomerInfoVO();
		cus1.setId("00001");
		cus1.setName("����");
		cus1.setType("��Ӧ��");
		cus1.setLevel(CustomerLevelEnum.VIP1);
		
		CustomerInfoVO cus2=new CustomerInfoVO();
		cus2.setId("00002");
		cus2.setName("����");
		cus2.setType("��Ӧ��");
		cus2.setLevel(CustomerLevelEnum.VIP2);
		
		CustomerInfoVO cus3=new CustomerInfoVO();
		cus3.setId("00003");
		cus3.setName("����");
		cus3.setType("��Ӧ��");
		cus3.setLevel(CustomerLevelEnum.VIP3);
		
		CustomerInfoVO cus4=new CustomerInfoVO();
		cus4.setId("00004");
		cus4.setName("����");
		cus4.setType("��Ӧ��");
		cus4.setLevel(CustomerLevelEnum.VIP4);
		
		CustomerInfoVO cus5=new CustomerInfoVO();
		cus5.setId("00005");
		cus5.setName("�׳�");
		cus5.setType("��Ӧ��");
		cus5.setLevel(CustomerLevelEnum.VIP5);
		
		CustomerInfoVO cus6=new CustomerInfoVO();
		cus6.setId("00006");
		cus6.setName("������");
		cus6.setType("������");
		cus6.setLevel(CustomerLevelEnum.VIP1);
		
		CustomerInfoVO cus7=new CustomerInfoVO();
		cus7.setId("00007");
		cus7.setName("�̾���");
		cus7.setType("������");
		cus7.setLevel(CustomerLevelEnum.VIP2);
		
		CustomerInfoVO cus8=new CustomerInfoVO();
		cus8.setId("00008");
		cus8.setName("������");
		cus8.setType("������");
		cus8.setLevel(CustomerLevelEnum.VIP3);
		
		CustomerInfoVO cus9=new CustomerInfoVO();
		cus9.setId("00009");
		cus9.setName("С��ñ");
		cus9.setType("������");
		cus9.setLevel(CustomerLevelEnum.VIP4);
		
		CustomerInfoVO cus10=new CustomerInfoVO();
		cus10.setId("00010");
		cus10.setName("��̫��");
		cus10.setType("������");
		cus10.setLevel(CustomerLevelEnum.VIP5);
		
		CustomerInfoVO cus11=new CustomerInfoVO();
		cus11.setId("00011");
		cus11.setName("ˮ����");
		cus11.setType("��Ӧ��");
		cus11.setLevel(CustomerLevelEnum.VIP2);
		
		CustomerInfoVO cus12=new CustomerInfoVO();
		cus12.setId("00012");
		cus12.setName("�����");
		cus12.setType("��Ӧ��");
		cus12.setLevel(CustomerLevelEnum.VIP1);
		
		CustomerInfoVO cus13=new CustomerInfoVO();
		cus13.setId("00013");
		cus13.setName("����");
		cus13.setType("������");
		cus13.setLevel(CustomerLevelEnum.VIP3);
		
		CustomerInfoVO cus14=new CustomerInfoVO();
		cus14.setId("00014");
		cus14.setName("��ɵɵ");
		cus14.setType("������");
		cus14.setLevel(CustomerLevelEnum.VIP1);
		
		toReturn.add(cus1);
		toReturn.add(cus2);
		toReturn.add(cus3);
		toReturn.add(cus4);
		toReturn.add(cus5);
		toReturn.add(cus6);
		toReturn.add(cus7);
		toReturn.add(cus8);
		toReturn.add(cus9);
		toReturn.add(cus10);
		toReturn.add(cus11);
		toReturn.add(cus12);
		toReturn.add(cus13);
		toReturn.add(cus14);
		
		return toReturn;
	}
}
