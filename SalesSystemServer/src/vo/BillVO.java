package vo;


import java.io.Serializable;

import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;

/**
 * billVO������
 * @author �Ű�  161250193
 * @version 2017.11.26
 */

public class BillVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2353458588470743452L;
	private BillCategoryEnum categoryEnum;//���ݵ�����
	private String Id;//���ݵı��(��ʽΪ��ͷ��ĸ��д+"yyyyMMdd-xxxxx")
	private BillStateEnum billStateEnum;//���ݵ�״̬
	private UserInfoVO creater;//���ݵĴ�����
	private UserInfoVO approver;//���ݵ�������
	private UserInfoVO executor;//���ݵ�ִ����
	private Date createDate;//���ݵĴ�������
	private Date approveDate;//���ݵ���������
	private Date finishDate;//�����������
	private String createrComment;//���ݴ����ߵı�ע
	private String approverComment; //���������ߵı�ע
	private boolean isSelected;
	public BillCategoryEnum getCategoryEnum() {
		return categoryEnum;
	}
	public void setCategoryEnum(BillCategoryEnum categoryEnum) {
		this.categoryEnum = categoryEnum;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public BillStateEnum getBillStateEnum() {
		return billStateEnum;
	}
	public void setBillStateEnum(BillStateEnum billStateEnum) {
		this.billStateEnum = billStateEnum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public String getCreaterComment() {
		return createrComment;
	}
	public void setCreaterComment(String createrComment) {
		this.createrComment = createrComment;
	}
	public String getApproverComment() {
		return approverComment;
	}
	public void setApproverComment(String approverComment) {
		this.approverComment = approverComment;
	}
	public UserInfoVO getCreater() {
		return creater;
	}
	public void setCreater(UserInfoVO creater) {
		this.creater = creater;
	}
	public UserInfoVO getApprover() {
		return approver;
	}
	public void setApprover(UserInfoVO approver) {
		this.approver = approver;
	}
	public UserInfoVO getExecutor() {
		return executor;
	}
	public void setExecutor(UserInfoVO executor) {
		this.executor = executor;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
}
