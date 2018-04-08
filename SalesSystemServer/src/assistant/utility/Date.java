package assistant.utility;

import java.io.Serializable;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Date implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -5407874967802305946L;

	/**
     * �����ַ����ĸ�ʽ
     */
	static final String BILL_DRAFT_ID_FORMAT = "yyyy-MM-dd_HH_mm_ss";
	static final String FORMAT="yyyy-MM-dd_HH:mm:ss";
	static final String YMD_FORMAT="yyyy.MM.dd";
	static final String BILL_ID_FORMAT="yyyyMMdd";
	static final String PROMOTION_ID_FORMAT = "yyyy-MMdd-hh-mm-ss";
	
	private Calendar calendar;

	/**
     * ��һ�����ڵ�string����һ�����ڵĸ�����
     */
	public Date(String date) throws ParseException{
		try{
		calendar=Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat(FORMAT);
		calendar.setTime(format.parse(date));
		calendar.getTime();
		}catch(ParseException e){
			throw e;
		}

	}
	public Date(int year,int month,int date,int hourOfDay,int minute){
		this();
		calendar.set(year, month, date, hourOfDay, minute);
	}


	/**
     * �õ���ʱ�乹��һ�����ڵĸ�����
     */
	public Date() {
		calendar = Calendar.getInstance();
		calendar.getTime();
	}

	/**
     * �õ������ڵ��ַ�����ʽ
     *
     * @return �����ڵ��ַ�����ʽ
     */
	public String getDate(){
		String string = (new SimpleDateFormat(FORMAT)).format(calendar.getTime());
		return string;
	}
	
	/**
     * �õ������������յ��ַ�����ʽ
     *
     * @return �����������յ��ַ�����ʽ
     */
	public String getYMDDate(){
		String string =  (new SimpleDateFormat(YMD_FORMAT)).format(calendar.getTime());
		return string;
	}
	
	/**
     * �õ��õ��ݵ�Id����
     * ����JHTHD-yyyyMMdd-�е�yyyyMMdd����
     * @return ���ݵ�Id����
     */
	public String getBillIdPart(){
		String string = (new SimpleDateFormat(BILL_ID_FORMAT)).format(calendar.getTime());
		return string;
	}
	
	/**
     * �õ��õ��ݵ�Id����
     * ����JHTHD-yyyyMMdd-�е�yyyyMMdd����
     * @return ���ݵ�Id����
     */
	public String getBillDraftIdPart(){
		String string = (new SimpleDateFormat(BILL_DRAFT_ID_FORMAT)).format(calendar.getTime());
		return string;
	}
	
	/**
     * ���ɸô������Ե�Id����
     * ��ʽ��2017-1204-01-56
     * @return �������Ե�Id����
     */
	public String toPromotionId(){
		String  string=(new SimpleDateFormat(PROMOTION_ID_FORMAT)).format(calendar.getTime());
		return string;
	}
	
	/**
     * �õ������ڵ�Calendar��ʽ
     *
     * @return �����ڵ�Calendar��ʽ
     */
	public Calendar getCalendar(){
		return this.calendar;
	}

	/**
     * �Ƚϵ�ǰ������Ŀ������
     *
     * @return 0:���  1:��ǰ���ڽ���  -1:��ǰ���ڽ���
     */
	public int compareTo(Date anothorDateUtility){
		return calendar.compareTo(anothorDateUtility.getCalendar());
	}

	/**
     * �Ƚϵ�ǰ�����Ƿ��ڸ����ڷ�Χ��
     *
     * @return true:�����ڷ�Χ��  false:�������ڷ�Χ��
     */
	public boolean isInDateArea(Date begin,Date end){
		if(calendar.compareTo(begin.getCalendar())>=0
				&&calendar.compareTo(end.getCalendar())<=0){
			return true;
		}
		return false;
	}

}
