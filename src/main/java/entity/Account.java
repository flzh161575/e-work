package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户类(PoJo类，基于JavaBean规范的实体类)
 * @author RanJi
 * @since JDK8	
 */
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	//-- 属性(私有化)
	private int id;
    private String actNo;
    private String password;
    private boolean enable;
    private Date createDate;
    private double balance;
    
    //-- 构造器
    public Account(){}
	public Account(String actNo) {
		super();
		this.actNo = actNo;
	}
	public Account(String actNo, String password, boolean enable, Date createDate, double balance) {
		super();
		this.actNo = actNo;
		this.password = password;
		this.enable = enable;
		this.createDate = createDate;
		this.balance = balance;
	}
	//-- getter()和setter()方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActNo() {
		return actNo;
	}
	public void setActNo(String actNo) {
		this.actNo = actNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
    //-- 重写toString方法
	@Override
	public String toString() {
		return "Account [id=" + id + ", actNo=" + actNo + ", password=" + password + ", enable=" + enable
				+ ", createDate=" + createDate + ", balance=" + balance + "]";
	}
	
	//-- 和集合框架中的Set有关，所以才要重写hashCode()方法
	@Override
	public int hashCode(){
		return 31 + actNo.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		//-- 要写出equals方法的几个特性
		if (this == obj)  //-- 自反性
			return true;
		if (obj == null)   //-- 非空性
			return false;
		if (!(obj instanceof Account))	//-- 类型是不是一致
			return false;
		//-- 真正比较内容代码
		Account other = (Account) obj;
		if (actNo == null) {
			if (other.actNo != null)
				return false;
		} else if (!actNo.equals(other.actNo))
			return false;
		return true;
	}
}
