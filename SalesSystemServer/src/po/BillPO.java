package po;

import java.io.Serializable;
import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import vo.BillVO;

/**
 * BillPO������
 * @author �Ű�  161250193
 * @version 2017.11.8
 */

public class BillPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6523859307356498788L;
	
	private BillCategoryEnum categoryEnum;//���ݵ�����
	private String Id;//���ݵı��(��ʽΪ��ͷ��ĸ��д+"yyyyMMdd-xxxxx")
	private BillStateEnum billStateEnum;//���ݵ�״̬
	private UserInfoPO creater;//���ݵĴ�����
	private UserInfoPO approver;//���ݵ�������
	private UserInfoPO executor;//���ݵ�ִ����
	private Date createDate;//���ݵĴ�������
	private Date approveDate;//���ݵ���������
	private Date finishDate;//�����������
	private String createrComment;//���ݴ����ߵı�ע
	private String approverComment; //���������ߵı�ע
	
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
	public UserInfoPO getCreater() {
		return creater;
	}
	public void setCreater(UserInfoPO creater) {
		this.creater = creater;
	}
	public UserInfoPO getApprover() {
		return approver;
	}
	public void setApprover(UserInfoPO approver) {
		this.approver = approver;
	}
	public UserInfoPO getExecutor() {
		return executor;
	}
	public void setExecutor(UserInfoPO executor) {
		this.executor = executor;
	}

	
}
