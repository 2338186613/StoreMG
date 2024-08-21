package ShoppingSystem.DataBase;
import java.util.*;

public class User {
	
	/**
	 * @param userName		用户名称
	 * @param account		账号
	 * @param password		密码
	 * @param transPIN		交易密码		
	 */
	private String userName,account,password,transPIN;
	private ArrayList<Cart> cartList=new ArrayList<Cart>();
	
	public User() {
		super();
	}

	public User(String userName, String account, String password ,String transPIN) {
		super();
		this.userName = userName;
		this.account = account;
		this.password = password;
		this.transPIN=transPIN;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<Cart> cartList) {
		this.cartList = cartList;
	}

	public void setCart(Cart cart) {
		cartList.add(cart);
	}

	public String getTransPIN() {
		return transPIN;
	}

	public void setTransPIN(String transPIN) {
		this.transPIN = transPIN;
	}
	
	
}
